def zi(h,i)
	a,b,c = h
	c = c.split(':')
	l,m = c
	fi = (100.0*l.to_i/(m.to_i+l.to_i)).floor
	zi = fi * (i+1)
	return [a,b,zi]
end

def merge_sort(list)
  if list.size <= 1
  	return list
  end
  half_size = list.size/2
  left = merge_sort list[0, half_size]
  right = merge_sort list[half_size, list.size]
 
  merge(left, right)
end
 
 
def merge(left, right)
  result = []
  while right.size > 0 && left.size > 0
    result << if left[0][2] < right[0][2]
      left.shift
    else
      right.shift
    end
  end
 
  result.concat(left).concat(right)
end

n, m = STDIN.readline.chomp.split(' ').map{|e|e.to_i}
heroes = []
n.times{heroes << STDIN.readline.chomp.split(',')}
heroes = heroes.map.with_index{|h,i|zi(h,i)}
heroes = merge_sort(heroes).reverse
heroes = heroes[0...m]

intel = 0.0
stren = 0.0
agil = 0.0
heroes.each do |h|
	intel += 1.0 if h[1] == "Intelligence"
	stren += 1.0 if h[1] == "Strength"
	agil += 1.0 if h[1] == "Agility"
end
total = intel + stren + agil


out1 = sprintf('%.2f', (intel/total)*100)
out2 = sprintf('%.2f', (stren/total)*100)
out3 = sprintf('%.2f', (agil/total)*100)
heroes.each {|e| puts e[0] }
puts ""
puts "This set of heroes:"
puts "Contains #{out1} percentage of Intelligence"
puts "Contains #{out2} percentage of Strength"
puts "Contains #{out3} percentage of Agility"