recep = { 
	"Anchovies" => 50, 
	"Artichoke" => 60,
	"Bacon" => 92,
	"Broccoli" => 24,
	"Cheese" => 80,
	"Chicken" => 30,
	"Feta" => 99,
	"Garlic" => 8,
	"Ham" => 46,
	"Jalapeno" => 5,
	"Meatballs" => 120,
	"Mushrooms" => 11,
	"Olives" => 25,
	"Onions" => 11,
	"Pepperoni" => 80,
	"Peppers" => 6,
	"Pineapple" => 21,
	"Ricotta" => 108,
	"Sausage" => 115,
	"Spinach" => 18,
	"Tomatoes" => 14
}

def get_total_value(list,recep)
	arr = list.split(',')
	arr = arr.map { |e| recep[e] }
	return arr.inject(:+)
end

input = STDIN.readline.chomp.split(" ")[1..-1]
input = input.each_slice(2).to_a
answer = input.inject(0){|r,e|r + e[0].to_i * (get_total_value(e[1],recep)+270)}
puts "The total calorie intake is #{answer}"