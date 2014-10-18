siu :: [Int] -> Int -> Integer
siu as n = mod (n*(fromIntegral (foldl summ 0 as))) 1000000007

summ :: Int -> Int -> Int
summ a b = mod (a+b) 1000000007

powm :: Int -> Int -> Int
powm 0 _ = 1
powm n k | even n = mod (pow nb k) 1000000007
    where 

solve :: [String] -> String
solve = siu . map (read)

main = do
    a <- getLine
    b <- getLine
