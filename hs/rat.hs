ferats :: [Int]
ferats = [a|a<-[1..1001],b<-[1..1000],b<c,cc == c*c
    where cc = a*a-b*b
           c = floor (sqrt cc)
]
