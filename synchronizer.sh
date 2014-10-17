git pull origin
while true
do
	for i in `seq 1 10`
	do
		sleep 60
		git add .
		git commit -am "... and another commit ..."
		echo "committed"
	done
	git pull --all
	git push --all
	echo "exchanged, perhaps you better check for conficts?"
done
