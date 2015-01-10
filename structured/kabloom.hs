data Card = A | N Int | T | J | Q | K | R deriving (Ord,Eq)

cardScore :: Card -> Int
cardScore A = 20
cardScore J = 15
cardScore Q = 15
cardScore K = 15
cardScore R = 50
cardScore T = 10
cardScore (N n) = n

score :: Card -> Card -> Int
score R x = cardScore x
score a b | a == b = cardScore a
          | otherwise = 0

calculateScore :: [Card] -> [Card] -> Int
calculateScore a = calculateScore' (replicate (length a) 0) a

calculateScore' :: [Int] -> [Card] -> [Card] -> Int
calculateScore' vs [] _ = last vs
calculateScore' ts (x:xs) ys = calculateScore' (calculateScore'' ts 0 0 x ys) xs ys

calculateScore'' :: [Int] -> Int -> Int -> Card -> [Card] -> [Int]
calculateScore'' [] _ _ _ _ = []
calculateScore'' (t:ts) tl l x (y:ys) = v : (calculateScore'' ts t v x ys)
    where v = max [l,t,tl+(score x y)]
