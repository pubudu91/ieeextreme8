module Main where

import qualified Data.Vector as V
import Data.Vector (Vector, fromList)

import Control.Applicative
import Control.Monad
import Debug.Trace
import qualified Data.Map as Data.Map
import System.IO.Unsafe
import Control.Concurrent.MVar
import Data.IORef
import System.IO.Unsafe


                   
import Prelude hiding (elem, foldl, foldr)
import qualified Data.Map as M
import qualified Data.Map as Map

import Control.Arrow (second)
import qualified Data.ByteString as SB
import qualified Data.ByteString.Lazy as LB
import qualified Data.List as L
import Data.Maybe (listToMaybe, mapMaybe)

import Data.List (maximumBy,tails,isPrefixOf)
import Data.Ord

-- | This is the suffixtree based implementation.
-- | If there are multiple longest substrings, which one is returned
-- | is undefined.

import Data.Array (array,(!))
 
import Data.List
 
longest xs ys = if length xs > length ys then xs else ys
 
 
lcs xs ys = a!(0,0) where
  n = length xs
  m = length ys
  a = array ((0,0),(n,m)) $ l1 ++ l2 ++ l3
  l1 = [((i,m),[]) | i <- [0..n]]
  l2 = [((n,j),[]) | j <- [0..m]]
  l3 = [((i,j), f x y i j) | (x,i) <- zip xs [0..], (y,j) <- zip ys [0..]]
  f x y i j 
    | x == y    = x : a!(i+1,j+1)
    | otherwise = longest (a!(i,j+1)) (a!(i+1,j))


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
	print $ length $ lcs x (reverse x)

palin :: (Vector Char) -> Int
palin x = gom (0, (V.length x - 1))
	where
		gom :: (Int, Int) -> Int
		gom = memoize go where
			go (l,r)
				 	|l == r =  1
					|l + 1 == r && x V.! l == x V.! r =2
					|l + 1 == r = 1
					|x V.! l == x V.! r =  2 + gom ((l+1), (r-1))
					|otherwise = max (gom (l ,(r-1))) (gom ((l+1) ,r))

