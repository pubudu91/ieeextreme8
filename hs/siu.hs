siu :: [Int] -> Int -> Integer
siu as n = powm n (foldl summ 0 as)

summ :: Int -> Int -> Int
summ a b = mod (a+b) 1000000007

powm :: Int -> Int -> Int
powm 0 _ = 1
powm n k | even n = pw
         | otherwise = div k pw 1000000007
    where nb = div n 2
          kb = mod (k*k) 1000000007
          pw = powm nb kb

solve :: [String] -> String
solve = siu . map (read)

main = do
    a <- getLine
    b <- getLine
    c <- getLine
    print (siu (map (read) . words b) (read c))
