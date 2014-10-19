def calc_day(day,shops)
	t = []
	for i in 0...day.length
		temp = []
		for j in 0...day[0].length
			value = day[i][j]
			for k in -1..1
				for l in -1..1
					if i + k >=0 and i + k < day.length and j + l >= 0 and j + l < day[0].length and k.abs != l.abs		
					value += 1 if shops[i+k][j+l] == 3 and day[i+k][j+l] >= 5
					end
				end
			end
			temp << [value-20,0].max
		end
		t << temp
	end
	return t
end

def plus(arr,list)
	temp = []
	for i in 0...arr.length
		t = []
		for j in 0...arr[0].length
			t << arr[i][j] + list[i][j]
		end
		temp << t
	end
	return temp
end


col,row = STDIN.readline.chomp.split(' ').map{|e|e.to_i}
shops = []
convert = {
	"-" => 0,
	"L" => 1,
	"M" => 2,
	"H" => 3
}
row.times{shops << STDIN.readline.chomp.split('*').map { |e| convert[e[0]]}}
monday = []
STDIN.readline
row.times{monday << STDIN.readline.chomp.split('*').map { |e| e.to_i }}
tuesday = []
STDIN.readline
row.times{tuesday << STDIN.readline.chomp.split('*').map { |e| e.to_i }}
wednesday = []
STDIN.readline
row.times{wednesday << STDIN.readline.chomp.split('*').map { |e| e.to_i }}
thursday = []
STDIN.readline
row.times{thursday << STDIN.readline.chomp.split('*').map { |e| e.to_i }}
friday = []
STDIN.readline
row.times{friday << STDIN.readline.chomp.split('*').map { |e| e.to_i }}
saturday = []
STDIN.readline
row.times{saturday << STDIN.readline.chomp.split('*').map { |e| e.to_i }}
sunday = []
STDIN.readline
row.times{sunday << STDIN.readline.chomp.split('*').map { |e| e.to_i }}

week = [monday,tuesday,wednesday,thursday,friday,saturday,sunday]
week = week.map { |e| calc_day(e,shops) }.inject { |r, e|  plus(r,e)}
week = week.map { |e| e.map { |x| 6 * x } }


for i in 0...week.length
	for j in 0...week[0].length
			week[i][j] = week[i][j] / (shops[i][j] + 1)
			week[i][j] = -1 if shops[i][j] == 3
	end
end

maxi,maxj,maxvalue = 0,0,-1

for i in 0...week.length
	for j in 0...week[0].length
		maxi,maxj,maxvalue = i,j,week[i][j] if week[i][j] > maxvalue
	end
end
if maxvalue > 0
	puts "#{maxj + 1 } #{maxi +1}"
else
	puts "-1 -1"
end
