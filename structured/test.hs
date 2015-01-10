import Data.List
import Data.List.Split

type Kn a = [[[a]]]

initkn :: [a] -> Kn a
initkn x = [[x]]

merge :: Kn a -> Kn a
merge 

readListDat :: (Read a) => String -> [a]
readListDat x = map read (words x)

main = interact (unlines . map (show) . merge . concat . map (initkn . (readListDat :: String -> [Int])) . tail . lines)
