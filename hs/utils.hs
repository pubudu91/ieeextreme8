next :: [Int] -> [Int]
next = filter (>0) . map (\x -> x-1)

solve :: [Int] -> [Int]
solve = map length . evolution next []

evolution :: (Eq a) => (a -> a) -> a -> a -> [a]
evolution f end x | x == end = []
                  | otherwise = x : (evolution f end (f x))
