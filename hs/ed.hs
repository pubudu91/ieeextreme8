import Data.Tree

data State = Empty | Some (AVL Int,Int,AVL Int)

solve :: [Int] -> [Int] -> Int
solve [_,m,k] as = solve' k l (drop k l)
    where l = (as++take (k-1) as)

insert State -> Int -> State
insert Empty k = Some (empty,k,empty)
insert 


main = do
    nmk <- getLine
    vls <- getLine
    print (solve (map (read) (words nmk)) (map (read) (words vls)))
