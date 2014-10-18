solve :: [Int] -> [Int] -> Int
solve [n,m,k] as = solve' n m k (as++take (k-1) as)

main = do
    nmk <- getLine
    vls <- getLine
    print (solve (map (read) (words nmk)) (map (read) (words vls)))
