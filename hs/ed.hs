import Data.Tree

type State = (AVL (Int,Int),Int,AVL (Int,Int))

--solve :: [Int] -> [Int] -> Int
--solve [_,m,k] as = solve' k l (drop k l)
--    where l = (as++take (k-1) as)

--initialize :: Int -> [Int] -> State
--initialize k as = 

subord :: (Int,Int) -> (Int,Int) -> Ordering
subord (a,_) (b,_) = compare a b

--insertavl :: AVL (Int,Int) -> 

--main = do
--    nmk <- getLine
--    vls <- getLine
--    print (solve (map (read) (words nmk)) (map (read) (words vls)))
