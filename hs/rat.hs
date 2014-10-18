ferats :: [Int]
ferats = [a|a<-[1..1001],b<-[1..1000],let cc = a*a-b*b, c = floor (sqrt cc) in b*b<cc,cc == c*c]
