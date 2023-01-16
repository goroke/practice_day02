names = ['Duck', 'Gourd', 'Spitz']

# 5.6
print('5.6. (using % formatting)')
for name in names:
    print('%sy Mc%sface' % (name, name))

# 5.7
print('\n5.7. (using format() method)')
for name in names:
    print('{0}y Mc{0}face'.format(name))

# 5.8
print('\n5.8. (using f-string)')
for name in names:
    print(f'{name}y Mc{name}face')
