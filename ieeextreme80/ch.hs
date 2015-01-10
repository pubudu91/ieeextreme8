import Data.List

--gainlose, cost, cur, other
--pass :: Integer -> Integer -> Integer -> Integer -> [Integer]
--pass :: _ c [_] = c
--pass :: gl c e (hi:hj:hs) = pass (gl+(dgl hi hj)) 

--dgl :: Integer -> Integer -> Integer
--dgl a b | a < b = -1
--        | otherwise = 1

main = do
    a <- getLine
    b <- getLine
    let bints = map read $ words b :: [Integer]
    print (bisectUp (doRun bints) (-1) (maximum bints))

doRun :: [Integer] -> Integer -> Bool
doRun [] e = e >= 0
doRun (hk:hs) e | e < 0 = False
                | otherwise = doRun hs (2*e-hk)

bisectUp :: (Integer -> Bool) -> Integer -> Integer -> Integer
bisectUp f i j | i >= j-1 = j
               | f (div (i+j) 2) = bisectUp f i (div (i+j) 2)
               | otherwise = bisectUp f (div (i+j) 2) j
