ferats :: [Int]
ferats = [a|a<-[2..1001],b<-[1..(a-1)],let cc = a*a-b*b, let c = floor ( sqrt ( fromIntegral cc)), b*b<cc,cc == c*c]

solve :: [String] -> String
solve = solve' . map (read)

solve' :: [Int] -> String
solve' [a,b] | (elem a ferats) && (elem b ferats) = "TRUE"
             | otherwise = "FALSE"

main = interact (unlines . map (solve . words) . tail . lines)
    
