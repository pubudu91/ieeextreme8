evolution :: (Eq a) => (a -> a) -> a -> a -> [a]
evolution f x y | x == y = []
                | otherwise x : (evolution f (f x) y)
