import Data.Tree

type State = (AVL Int,Int,AVL Int)

solve :: [Int] -> [Int] -> Int
solve [_,m,k] as = solve' k l (drop k l)
    where l = (as++take (k-1) as)

initialize :: Int -> [Int] -> State


main = do
    nmk <- getLine
    vls <- getLine
    print (solve (map (read) (words nmk)) (map (read) (words vls)))
