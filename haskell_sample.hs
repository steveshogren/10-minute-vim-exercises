foldTextFile :: (String -> a -> IO a) -- ^ Fold callback function
             -> a                     -- ^ initial accumulator
             -> FilePath              -- ^ File to read
             -> IO a
foldTextFile chunkf ini fp = do
    buf <- V.newPinned (Size blockSize)
    V.withMutablePtr buf $ \ptr ->
        withFile fp S.ReadMode $ doFold buf ptr
  where
    doFold mv ptr handle = loop 0 ini
      where
        loop absPos acc = do
            r <- S.hGetBuf handle ptr blockSize
            if r > 0 && r <= blockSize
                then do
                    (pos, validateRet) <- S.mutableValidate mv 0 r
                    s <- case validateRet of
                        Nothing -> S.fromBytesUnsafe `fmap` V.freezeShrink mv r
                        Just S.MissingByte -> do
                            sRet <- S.fromBytesUnsafe `fmap` V.freezeShrink mv pos
                            V.unsafeSlide mv pos r
                            return sRet
                        Just _ ->
                            error ("foldTextFile: invalid UTF8 sequence: byte position: " <> show (absPos + pos))
                    chunkf s acc >>= loop (absPos + r)
                else error ("foldTextFile: read failed") -- FIXME
