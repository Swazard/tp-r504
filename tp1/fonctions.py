def puissance(a, b):
    if a == 0 and b > 0:
        return 1
    elif b == 0:
        print("On ne peut pas diviser par 0")
    elif a == 0:
        print("On ne peut pas mettre 0 à la puissance avec un négatif")
    elif b > 0:
        res = 1
        for i in range(abs(b)):
            res *= a
        return res
    if not type(var) is int:
        raise TypeError("Only intergers are allowed")
