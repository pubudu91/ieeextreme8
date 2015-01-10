-- Enter your code here. Read input from STDIN. Print output to STDOUT

import Data.List

buy :: [Int] -> Int
buy = buy' 0 . sort

buy' :: Int -> [Int] -> Int
buy' c [] = c
buy' c (w:ws) = buy' (c+1) (dropWhile (<=(w+4)) ws)

main = do
    a <- getLine
    b <- getLine
    let bints = map read $ words b
    print (buy bints)
