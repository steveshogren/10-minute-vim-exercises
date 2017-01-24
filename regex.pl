s/(\\(\\*HIDE\\*\\))(.*?)(\\(\\*UHIDE\\*\\))/$1.decode_base64($2).$3/eigs
s/(\\(\\*HIDE\\*\\))(.*?)(\\(\\*UHIDE\\*\\))/$1.encode_base64($2).$3/eigs
