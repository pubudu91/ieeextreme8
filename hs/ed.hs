solve :: [Int] -> [Int] -> Int
solve [_,m,k] as = solve' k l (drop k l)
    where l = (as++take (k-1) as)

softOrdering :: Int -> Int64 -> Ordering
softOrdering a b = compare ()

solve' :: Int -> [Int] -> [Int]

main = do
    nmk <- getLine
    vls <- getLine
    print (solve (map (read) (words nmk)) (map (read) (words vls)))
