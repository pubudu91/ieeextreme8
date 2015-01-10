import Data.Bits
import Data.Int
import Numeric

data State = S Int Int Int64 Int64

instance Show (State) where
    show (S i n a b) = (show i)++" -"++(printState n b)++"-"

printState :: Int -> Int64 -> String
printState 0 _ = []
printState k n = bf ++ en
    where nb = div n 2
          bf = printState (k-1) (div n 2)
          en = printBit n

printBit n | even n = " "
           | otherwise = "*"

evolution :: (a->Bool) -> (a -> a) -> a -> [a]
evolution c f s | c s = s : evolution c f (f s)
                | otherwise = [s]

continue :: State -> Bool
continue (S _ _ a b) = a /= b

next :: Int64 -> State -> State
next r (S i n a b) = S (i+1) n b (nextState r b)

nextState :: Int64 -> Int64 -> Int64
nextState r s = foldl (.|.) 0 [nextBit r b s | b <- [0..63]]

nextBit :: Int64 -> Int -> Int64 -> Int64
nextBit r b s = shiftL (1 .&. (shiftR r (fromIntegral (subsegment b s) :: Int))) b

subsegment :: Int -> Int64 -> Int
subsegment b x = fromIntegral (7 .&. (segment b x)) :: Int

segment :: Int -> Int64 -> Int64
segment 0 s = shiftL s 1
segment n s = shiftR s (n-1)

solve :: Int64 -> Int -> Int -> Int64 -> [String]
solve _ _ _ _ = ["Foo"]

main :: IO()
main = do
    q <- getLine
    putStrLn ("foo")
