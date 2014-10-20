import Data.Ratio

main = do
	x <- getLine
	case x of 
		"0"-> return ()
		"1" -> do
			putStrLn "1"
			main
		_ -> do
			x <- getLine
			print $ sum $ prods $ map (flip approxRational 4.94065645841247e-324 . read) $ words x
			main

p :: [Double] -> Int
p xs = round $ sum [ product (take i xs) / bigp | i <- [length xs,length xs-1..1]]
	where bigp = product xs

prods [] = [1]
prods (x:xs) = x*(head p) : p
	where p = prods xs