import Debug.Trace
import Data.List

--ferats :: [Int]
ferats a = nub [b|b<-[1..(a-1)],let cc = a*a-b*b, let c = floor ( sqrt ( fromIntegral cc)), b*b<=cc,cc == c*c]

vferats :: Int -> Int -> Bool
vferats a b = cc == c*c
    where cc = a*a-b*b
          c = floor ( sqrt ( fromIntegral cc))

solve'' :: Int -> Int -> Bool
solve'' a b | a < b = solve'' b a
solve'' a b | otherwise = a == f*b && (any (vferats (f*b)) (ferats a))
    where f = (div a b)

solve :: [String] -> String
solve = solve' . map (read)

solve' :: [Int] -> String
solve' [a,b] | solve'' a b = "TRUE"
             | otherwise = "FALSE"

main = interact (unlines . map (solve . words) . tail . lines)
