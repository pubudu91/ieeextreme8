intSqrt :: Int -> Int
intSqrt = floor . sqrt . fromIntegral

isSquare :: Int -> Bool
isSquare x2 = x2 == x*x
    where x = intSqrt x2

catheti :: Int -> [Int]
catheti a = [b|b<-[1..(a-1)], let cc = a*a-b*b, b*b<=cc, isSquare cc]

isCatheti :: Int -> Int -> Int -> Bool
isCatheti a b d = e*b == a*d && cc == c*c
    where e = div (a*d) b
          cc = a*a-e*e
          c = floor ( sqrt ( fromIntegral cc))

solve'' :: Int -> Int -> Bool
solve'' a b | a > b = solve'' b a
solve'' a b | otherwise = (any (isCatheti b a) (catheti a))

solve' :: [Int] -> String
solve' [a,b] | solve'' a b = "TRUE"
             | otherwise = "FALSE"

solve :: [String] -> String
solve = solve' . map (read)

main :: IO ()
main = interact (unlines . map (solve . words) . tail . lines)
