ferats :: [Int]
ferats = [a|a<-[1..1001],b<-[1..1000],c<-[1..1000],a*a == b*b+c*c]
