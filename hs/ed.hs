solve [Int] -> [Int] -> Int
solve ()

main = do
    nmk <- getLine
    vls <- getLine
    print solve (map (read) (words nmk)) (map (read) (words vls))
