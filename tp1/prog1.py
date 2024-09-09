import fonctions as f

print("Hello World!")
while True:
	a = input("Choisir deux nombres : ")
	b = input()
	res = f.puissance(int(a), int(b))
	print(res)
