solve :: [Int] -> [Int] -> Int
solve [_,m,k] as = solve' k (as++take (k-1) as)

solve' :: Int -> [Int]

main = do
    nmk <- getLine
    vls <- getLine
    print (solve (map (read) (words nmk)) (map (read) (words vls)))
