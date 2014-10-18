import Data.List

--ferats :: [Int]
ferats a = nub [(b,c)|b<-[1..(a-1)],let cc = a*a-b*b, let c = floor ( sqrt ( fromIntegral cc)), b*b<cc,cc == c*c]

solve :

--solve :: [String] -> String
--solve = solve' . map (read)

--solve' :: [Int] -> String
--solve' [a,b] | (elem a ferats) && (elem b ferats) = "TRUE"
--             | otherwise = "FALSE"

--main = interact (unlines . map (solve . words) . tail . lines)
