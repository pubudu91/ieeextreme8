module Main where

import qualified Data.Vector as V
import Data.Vector (Vector, fromList, (!))

import Control.Applicative
import Control.Monad
import Debug.Trace
import qualified Data.Map as Data.Map
import System.IO.Unsafe
import Control.Concurrent.MVar
import Data.IORef
import System.IO.Unsafe


memoize :: Ord a => (a -> b) -> (a -> b)
memoize f = unsafePerformIO $ do 
    r <- newIORef Map.empty
    return $ \ x -> unsafePerformIO $ do 
        m <- readIORef r
        case Map.lookup x m of
            Just y  -> return y
            Nothing -> do 
                    let y = f x
                    writeIORef r (Map.insert x y m)
                    return y




main = do
	x <- getLine
	print $ palin (fromList x)

palin :: (Vector Char) -> Int
palin x = gom (0, (V.length x - 1))
	where
		gom :: (Int, Int) -> Int
		gom = memoize go where
			go (l,r)
				 	|l == r =  1
					|l + 1 == r && x!l == x!r =2
					|l + 1 == r = 1
					|x!l == x!r =  2 + gom ((l+1), (r-1))
					|otherwise = max (gom (l ,(r-1))) (gom ((l+1) ,r))


