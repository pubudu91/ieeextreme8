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

import Data.Vector (Vector,(!))


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


toScore "A" = 200
toScore "2" = 20
toScore "3" = 30
toScore "4" = 40
toScore "5" = 50
toScore "6" = 60
toScore "7" = 70
toScore "8" = 80
toScore "9" = 90
toScore "T" = 100
toScore "J" = 151
toScore "Q" = 152
toScore "K" = 153
toScore "R" = 500


main = do
  t <- getLine
  case t of 
    "0" -> return ()
    _ -> do
      x <- map toScore <$> words <$> getLine
      y <- map toScore <$> words <$> getLine
      print $ palin (fromList x) (fromList y)
      main


palin :: (Vector Int) -> (Vector Int) -> Int
palin x y = (2 *) . gom (0, 0 )
  where
    gom :: (Int, Int) -> Int
    gom = memoize go
      where  go (l1,l2)
                |l1 == V.length x = 0
                |l2 == V.length y = 0
                |x!l1 == y!l2 = div (x!l1) 10 + gom (l1+1,l2+1)
                |x!l1 == 500 = maximum [div (y!l2) 10+ gom (l1+1,l2+1), gom(l1,l2+1)]
                |y!l2 == 500 = maximum [div (x!l1) 10 + gom (l1+1,l2+1), gom(l1+1,l2)]
                |otherwise = maximum [gom (l1+1,l2), gom(l1,l2+1)]