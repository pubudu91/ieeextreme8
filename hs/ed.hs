main = do
    nmk <- getLine
    vls <- getLine
    solve ( map (read) (words nmk))
