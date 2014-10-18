ferats :: [Int]
ferats = [a|a<-[1..1001],b<-[1..a],let cc = a*a-b*b, let c = floor ( sqrt ( fromIntegral c)), b*b<cc,cc == c*c]
