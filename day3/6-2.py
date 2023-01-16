# 6.2

guess_me = 7
number = 1

while True:
    if number < guess_me:
        print(f'too low ({number} < {guess_me})')

    elif number == guess_me:
        print(f'found it! (answer: {guess_me})')
        break
    else:
        print('oops')
        break

    number = number + 1
    
