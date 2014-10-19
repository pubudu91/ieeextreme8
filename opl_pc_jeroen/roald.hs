import Control.Monad
import Control.Applicative

main = do
	x <- readLn
	replicateM_ x main'

main' = do
	[a,l,n]<- map read <$> words <$> getLine
	print $ sol a l n

sol :: Integer -> Integer -> Integer -> Integer
sol a l n = numNodes * a * 4
	where
		numNodes	|a == 1 = l
					|otherwise = 1 + sum [nodesat i | i <- [1..specialLimit]] + n * (l - specialLimit)
		specialLimit = min l (floor $ log (fromIntegral n) / log (fromIntegral a))

		nodesat i = min (a^i) n
