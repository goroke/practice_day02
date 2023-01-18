# 8.11
print('8.11')

odds = {x for x in range(10) if x % 2}
print(f'(new set) = {odds}')


# 9.1
print('\n9.1')


def good():
    return 'Harry Ron Hermione'.split()


print(f'good → {good()}')
