def leven(s,t)
	return 0 if s == t
	return t.length if s.length == 0
	return s.length if t.length == 0
	v0 = []
	v1 = []
	for i in 0...t.length + 1
		v0[i] = i
	end
	for i in 0...s.length
		v1[0] = i + 1
		for j in 0...t.length
			cost = (s[i] == t[j]) ? 0 : 1
			v1[j+1] = [v1[j]+1,v0[j+1]+1,v0[j]+cost].min
		end
		for j in 0...v0.length
			v0[j] = v1[j]
		end
	end
	return v1[t.length]

end

@h = {}
def len(l,r)
	return @h[[l,r]] if !@h[[l,r]].nil?
	return 1 if l == r 
	if l+1 == r 
		return 2 if $s[l] == $s[r]
		return 1
	end
	if $s[l] == $s[r]
		ans = 2 + len(l+1,r-1)
		@h[[l,r]] = ans
		return ans
	end
	ans = [len(l,r-1),len(l+1,r)].max
	@h[[l,r]] = ans
	return ans
end
$s = STDIN.readline.chomp
puts len(0,$s.length-1)

