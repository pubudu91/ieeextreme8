evolution :: (Eq a) => (a -> a) -> a -> a -> [a]
evolution f end x | x == end = []
                  | otherwise = x : (evolution f end (f x))
