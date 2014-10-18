siu :: [Int] -> Int -> Integer
siu as n = mod (n*(fromIntegral (foldl summ 0 as))) 1000000007

summ :: Int -> Int -> Int
summ a b = mod (a+b) 1000000007

solve :: [String] -> String
solve = siu . map (read)

main = do
    a <- getLine
    b <- getLine
