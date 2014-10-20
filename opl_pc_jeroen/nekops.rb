def nekops(arr)
	count = 1
	temp = []
	for i in 0...arr.length
		if i+1 < arr.length and arr[i] == arr[i+1] 
			count +=1
		else
			temp << count
			temp << arr[i]
			count = 1
		end
	end
	return temp
end

input = STDIN.readline.chomp.split(' ').map{|e|e.to_i}
n = input.shift
arr = []
arr << input
n.times do
	temp = nekops(input)
	arr << temp
	input = temp
end

arr = arr.map { |e| e.join(" ")  }
max_length = arr.max { |a, b| a.length <=> b.length }.length
arr = arr.map { |e| "."*((max_length-e.length+1)/2) + e + "."*((max_length-e.length)/2)}
arr.each { |e| puts e  }
puts input.length