for f in *.md
do
	bn=$(basename "$f" ".md")
	echo '\newpage' >> problemset.tex
	pandoc -f markdown -t latex "$f" >> problemset.tex
	if [ -e "$bn.hs" ]
	then
		echo "\subsection{Source code}\lstinputlisting[language=Haskell]{$bn.hs}" >> problemset.tex
	fi
done
pdflatex --interaction batchmode book.tex
pdflatex --interaction batchmode book.tex
pdflatex --interaction batchmode book.tex
pdflatex --interaction batchmode book.tex
rm problemset.tex *.aux *.log *.toc *.out
