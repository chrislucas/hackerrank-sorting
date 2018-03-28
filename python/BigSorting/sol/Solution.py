'''
https://www.hackerrank.com/challenges/big-sorting/problem
'''


def less_than(a, b):
    return a < b


def merge(data, aux, lo, mi, hi):
    for idx in range(lo, hi + 1):
        aux[idx] = data[idx]

    i, j = lo, mi + 1
    for k in range(lo, hi + 1):
        if i > mi:
            '''
                i > mi quer dizer que os valores menores do que data[mi]
                ja estao ordenados no vetor data
            '''
            data[k] = aux[j]
            j += 1

        elif j > hi:
            '''
                se j > hi quer dizer que o lado direito de data[mi]
                ja esta preenchido com os valores maiores
            '''
            data[k] = aux[i]
            i += 1

        elif less_than(aux[j], aux[i]):
            '''
                j representa o indice dos elementos a direita do meio.
                se um valor a direita do meio do vetor for maior que um valor a esquerda
                adicione-o primeiro ao vetor (merging)
            '''
            data[k] = aux[j]
            j += 1

        else:
            '''
                do contrario, o valor a esquerda do meio do vetor ja esta na posicao
                certa, adicione-o primeiro ao vetor (merging)
            '''
            data[k] = aux[i]
            i += 1


def mergesort(_list, _list_aux, lo, hi):
    if lo >= hi:
        return
    mi = (hi - lo) // 2 + lo
    mergesort(_list, _list_aux, lo, mi)
    mergesort(_list, _list_aux, mi + 1, hi)
    merge(_list, _list_aux, lo, mi, hi)


def swap(_list, idx_a, idx_b):
    aux = _list[idx_a]
    _list[idx_a] = _list[idx_b]
    _list[idx_b] = aux


def solver():
    n = int(input())
    _list, _list_aux = [0] * n, [0] * n
    for i in range(0, n):
        _list[i] = input().strip()  # int()
    # mergesort(_list, _list_aux, 0, len(_list) - 1)
    _list = sorted(map(str, sorted(_list)), key=len)
    print("\n".join([str(x) for x in _list]))


def solver_2():
    from collections import defaultdict
    n = int(input())
    _d = defaultdict(list)
    for i in range(0, n):
        num = input().strip()
        _d[len(num)].append(num)
    print("\n".join([str(v) for k in sorted(_d) for v in sorted(_d[k])]))


solver_2()

if __name__ == '__main__':
    pass
