import Data.List

--ferats :: [Int]
ferats a = nub [b|b<-[1..(a-1)],let cc = a*a-b*b, let c = floor ( sqrt ( fromIntegral cc)), b*b<cc,cc == c*c]

vferats :: Int -> Int -> Int
vferats a b = cc == c*c
    where cc = a*a-b*b
          c = floor ( sqrt ( fromIntegral cc))

solve :: Int -> Int -> Bool
solve a b = any (vferats b) (ferats a)

solve :: [String] -> String
solve = solve' . map (read)

--solve' :: [Int] -> String
--solve' [a,b] | (elem a ferats) && (elem b ferats) = "TRUE"
--             | otherwise = "FALSE"

--main = interact (unlines . map (solve . words) . tail . lines)
