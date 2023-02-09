NUM_CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'


def convert_base(n, base=10):
    return convert_base(n // base, base) + NUM_CHARS[n % base] if n >= base else NUM_CHARS[n]


n = int(input('10진수 입력 --> ')); print()

for base in 2, 8, 16:
    print(f'{base:2d}진수 : {convert_base(n, base)}')
