ferats :: [Int]
ferats = [a|a<-[1..1001],b<-[1..1000],b<c,a*a == b*b+c*c]
    where cc = a*a-b*b
          c = floor . sqrt (fromIntegral 
