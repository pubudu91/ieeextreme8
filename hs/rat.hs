ferats :: [Int]
ferats = [a|a<-[1..1001],b<-[1..1000],let cc = a*a-b*b, let c = floor (sqrt cc), b*b<cc,cc == c*c]
