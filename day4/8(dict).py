# 8.1
print('8.1')

e2f = {'dog': 'chien',
       'cat': 'chat',
       'walrus': 'morse'}

print(f'e2f = {e2f}')

# 8.2
print('\n8.2')
# word 를 바꾸면 다른 것도 나오게 설정
word = 'walrus'
print(f'the word "{word}" is "{e2f[word]}" in French')

# 8.3
print('\n8.3')
f2e = {v: k for v, k in e2f.items()}
print(f'f2e = {f2e}')

# 8.4
print('\n8.4')
# keyword 를 바꾸면 다른 것도 나오게 설정
keyword = 'chien'
for k, v in e2f.items():
    if v == keyword:
        print(f'the word "{keyword}" is "{k}" in English')
        break

# 8.5
print('\n8.5')
print(' '.join(e2f))

# 8.6
print('\n8.6')
life = {'animals': {'cats': 'Henri',
                    'octopi': 'Grumpy',
                    'emus': 'Lucy'},
        'plants': {},
        'other': {}
        }
print(f'life = {life}')

# 8.7
print('\n8.7')
print(f'Keys of "life": {", ".join(life)}')

# 8.8
print('\n8.8')
print(f'Keys of "animals": {", ".join(life["animals"])}')

# 8.9
print('\n8.9')
print(f'Value of "cats": {life["animals"]["cats"]}')

# 8.10
print('\n8.10')
squares = {x: x*x for x in range(10)}
print(f'squares = {squares}')

# 8.11 ~ 8.12 생략

# 8.13
print('\n8.13')

perspective = dict(zip(('optimist', 'pessimist', 'troll'),
                       ('The glass is half full',
                        'The glass is half empty',
                        'How did you get a glass?')
                      )
                   )

print(f'new_dictionary = {perspective}')

# 8.14
print('\n8.14')

titles = ['Creature of Habit', 'Crewel Fate']
plots = ['A nun turns into a mon ster', 'A haunted yarn shop']

movies = dict(zip(titles, plots))
print(f'movies = {movies}')
