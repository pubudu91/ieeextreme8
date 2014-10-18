siu :: [Int] -> Int -> Int
siu as n = (foldl summ 0 as)

summ :: Int -> Int -> Int
summ a b = mod (a+b) 1000000007
