import Debug.Trace
import Data.List

--ferats :: [Int]
ferats a = [b|b<-[1..(a-1)],let cc = a*a-b*b, cc > 0, let c = floor ( sqrt ( fromIntegral cc)), b*b<=cc,cc == c*c]

vferats :: Int -> Int -> Int -> Bool
vferats a b d = trace (show a++","++show b++","++show d) e*b == a*d && cc == c*c
    where e = div (a*d) b
          cc = a*a-e*e
          c = floor ( sqrt ( fromIntegral cc))

solve'' :: Int -> Int -> Bool
solve'' a b | a > b = solve'' b a
solve'' a b | otherwise = (any (vferats b a) (ferats a))

solve :: [String] -> String
solve = solve' . map (read)

solve' :: [Int] -> String
solve' [a,b] | solve'' a b = "TRUE"
             | otherwise = "FALSE"

main = interact (unlines . map (solve . words) . tail . lines)
