ferats :: [Int]
ferats = [a|a<-[2..1001],b<-[1..(a-1)],let cc = a*a-b*b, let c = floor ( sqrt ( fromIntegral cc)), b*b<cc,cc == c*c]

solve :: [Int] -> String
solve [a,b] | (elem a ferats) and (elem b ferats) = "TRUE"
            | otherwise = "FALSE"

main = interact (unlines . map (solve . read) . words . tail . lines)
    
