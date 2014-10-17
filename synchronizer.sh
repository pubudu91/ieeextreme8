git pull origin
while true
do
	for i in `seq 1 10`
	do
		git add .
		git commit -am "... and another commit ..."
		echo "committed"
		sleep 60
	done
	git pull --all origin
	git push --all origin
	echo "exchanged, perhaps you better check for conficts?"
done
