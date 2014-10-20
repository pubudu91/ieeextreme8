

n,m = STDIN.readline.chomp.split(' ').map{|e|e.to_i}
cons = []
m.times{cons << STDIN.readline.chomp.split(' ').map{|e|e.to_i}}
plan = STDIN.readline.chomp.split(' ').map{|e|e.to_i}

answer = cons.all? do |con|
	plan.find_index(con[0]) < plan.find_index(con[1])
end

puts answer ? "YES" : "NO"