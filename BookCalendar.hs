module BookCalendar where

import Data.Time
import Data.Time.Calendar.WeekDate

currentWordCount :: Integer
currentWordCount = 11326

wordsPerDay :: Integer
wordsPerDay = 333

isNotWeekDay :: Day -> Bool
isNotWeekDay d =
  let (_,_,dow) = toWeekDate d
  in dow > 5

addToDay :: UTCTime -> Integer -> Day
addToDay today days = addDays days . utctDay $ today

printDay :: FormatTime t => t -> String
printDay d = formatTime defaultTimeLocale "   %a - %b %e %Y" d

futureCounts :: [Integer]
futureCounts = map (\n -> currentWordCount + (n * wordsPerDay)) [1..]

buildDate :: UTCTime -> Integer -> String
buildDate today daysFuture =
  let dayNumber = addToDay today daysFuture
  in printDay dayNumber

dailyCounts :: t -> UTCTime -> [String]
dailyCounts goal today =
 let days = filter (\n -> not $ isNotWeekDay $ addToDay today n) [1..35]
     dayStrings = map (buildDate today) days
 in map (\(n, d) -> (show n) ++ d) $ zip futureCounts dayStrings

main :: IO [()]
main = do
  today <- getCurrentTime
  sequence $ map (putStrLn . show) $ dailyCounts wordsPerDay today
