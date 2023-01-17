# 7.1
year_lists = [1996, 1997, 1998, 1999, 2000]
print(f'7.1\nyear_lists = {year_lists}\n')

# 7.2
print(f'7.2\n{year_lists[3]}\n')

# 7.3
print(f'7.3\n{year_lists[-1]}\n')

# 7.4 ~ 7.7 생략
print('7.4 ~ 7.7 은 생략합니다.\n')

# 7.8
surprise = ['Groucho', 'Chico', 'Harpo']
print(f'7.8\nsurprise = {surprise}\n')

# 7.9
surprise[-1] = surprise[-1][::-1].title()
print(f'7.9\n{surprise}\n')

# 7.10
even = [n for n in range(10) if not n % 2]
print(f'7.10\neven = {even}\n')

# 7.11
print(7.11)
start1 = ["fee", "fie", "foe"]
rhymes = [
    ('flop', 'get a mop'),
    ('fope', 'turn the rope'),
    ('fa', 'get your ma'),
    ('fudge', 'call the judge'),
    ('fat', 'pet the cat'),
    ('fog', 'walk the dog'),
    ('fun', "say we're done")
    ]

start2 = "Someone better"

for word, sentence in rhymes:
    for start in start1:
        print(f'{start.title()}! ', end=' ')
    print(f'{word.title()}!\n'
          f'{start2} {sentence}.')
