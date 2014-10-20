rest :: Int
rest = 1000000007

siu :: [Int] -> Int -> Int
siu as n = mod (powm n 2 * foldl summ 0 as) rest

summ :: Int -> Int -> Int
summ a b = mod (a+b) rest

powm :: Int -> Int -> Int
powm 0 _ = 1
powm n k | even n = pw
         | otherwise = mod (k*pw) rest
    where nb = div n 2
          kb = mod (k*k) rest
          pw = powm nb kb

main = do
    a <- getLine
    b <- getLine
    let bints = map read $ words b
    c <- readLn
    print (siu bints c)
