import random
secret = random.randint(1, 10)
guess  = random.randint(1, 10)

if guess < secret:
    print('too low')
elif guess > secret:
    print('too high')
else:
    print('just right')
