siu :: [Int] -> Int -> Int
siu as n = powm n (foldl summ 0 as)

summ :: Int -> Int -> Int
summ a b = mod (a+b) 1000000007

powm :: Int -> Int -> Int
powm 0 _ = 1
powm n k | even n = pw
         | otherwise = mod pw 1000000007
    where nb = div n 2
          kb = mod (k*k) 1000000007
          pw = powm nb kb

main = do
    a <- getLine
    b <- getLine
    let bints = map read $ words b
    c <- readLn
    print (siu bints c)
