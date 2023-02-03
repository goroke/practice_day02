def test_printing(original_func):
    """
    insert_pokemon 함수의 결과물 출력을 위한 데커레이터
    """
    def return_func(*args, **kwargs):
        print(f'포켓몬 {args[0]}(HP: {args[1]})을(를) 추가합니다.')
        ret = original_func(*args, **kwargs)
        print(f'결과물: {pokemon}\n')
        return ret
    return return_func


@test_printing
def insert_pokemon(name, hp):
    """
    포켓몬을 리스트에 추가합니다.
    :param name: 포켓몬 이름
    :param hp: 체력(HP)
    :return: 리턴 값은 없으며, pokemon 리스트에 변경 사항이 저장됩니다.
    """
    pokemon.append(None)

    for i in range(len(pokemon)-1, 0, -1):
        # 내림차순 정렬이므로 왼쪽이 더 큰 경우 멈춘다.
        # (i-1)번: 포켓몬(비교 대상), i번: None(들어갈 자리)
        if hp <= pokemon[i-1][1]:
            break

        # 해당되지 않는 경우는 들어갈 자리(None)를 왼쪽으로 한 칸 이동한다.
        pokemon[i] = pokemon[i-1]
        pokemon[i-1] = None
    else:
        i = 0

    pokemon[i] = [name, hp]


pokemon = [['피카츄', 500], ['파이리', 450], ['꼬부기', 400]]

# 테스트
insert_pokemon('이상해씨', 480)
insert_pokemon('푸린', 330)
insert_pokemon('단데기', 1000)
