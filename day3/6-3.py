# 6.3

guess_me = 5

for number in range(10):
    if number < guess_me:
        print(f'too low ({number} < {guess_me})')

    elif number == guess_me:
        print(f'found it! (answer: {guess_me})')
        break
    else:
        print('oops')
        break