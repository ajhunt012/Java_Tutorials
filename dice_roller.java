import random

def dice_roller(num_dice, dice_type, add):
        total = 0
        for i in range(num_dice):
        roll = random.randint(1, dice_type)
        print(f"Roll {i+1}: {roll}")
        total += roll
        total += add
        return total

        num_dice = int(input("Enter the number of dice you want to roll: "))
        dice_type = int(input("Enter the type of dice you want to roll (e.g. 6 for a standard die): "))
        add = int(input("Enter a number to add to the total roll: "))

        result = dice_roller(num_dice, dice_type, add)
        print("Total roll:", result)
