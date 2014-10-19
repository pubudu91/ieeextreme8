require 'prime'
def go(ind, target)
	
end

STDIN.readline
balls_orig = STDIN.readline.chomp.split(' ').map{|e|e.to_i}
balls=balls_orig.map { |e| Prime.prime_division(e).to_h }
prims = balls.map { |e| e.map { |x| x[0] } }.flatten.uniq
arr =  Array.new(balls.length) { Array.new(prims.length) }
balls.each.with_index do |b,i|
	prims.each.with_index do |p,j|
		if !b[p].nil?
			arr[i][j] = b[p]
		else
			arr[i][j] = 0
		end
	end
end

nr_gcd = STDIN.readline.to_i
nr_gcd.times do 
	target_orig =STDIN.readline.to_i
	target = target_orig.prime_division.to_h
	tar_prims = Array.new(prims.length)
	prims.each.with_index do |p,j|
		if !target[p].nil?
			tar_prims[j] = target[p]
		else
			tar_prims[j] = 0
		end
	end
	ind = (0...balls_orig.length).select{|i| balls_orig[i].modulo(target_orig) == 0 }
	puts go(ind,target)
end

p arr