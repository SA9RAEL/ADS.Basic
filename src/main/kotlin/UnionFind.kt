package ADS.Basic.src.main.kotlin

import java.util.*

/**
 * Структура данных: СНМ(Система непересекающихся множеств)
 * Описание: Если мы оперирум элементами N видов (здесь - числа)
 * Некоторые группы чисел объединены в множества.
 * Операции: union(x,y) - объединяект множества, содержаащие х и у
 * find(x) - возвращает представителя множества, в котором находится х.
 */

class UnionFind(private val size: Int) {
    private val parent = IntArray(size)
    var count = size
        private set

    /** MakeSet(X) - внести в структуру новый элемент X,
     * создать для него множество размера 1 из самого себя.
     * */
    init {
        for (i in parent.indices) {
            parent[i] = i
        }
    }

    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }

    /**
     * find(X) - взвратить идентификатор множества, которому принадлежит элемент Х.
     * Идентификатор = представитель множества = корень = родитель.
     * Гарантируется, что для одного и того же множества
     * представитель будет возвращаться один и тот же.
     */
    fun find(x: Int): Int {
        return if (x == parent[x]) {
            x
        } else find(parent[x]).also { parent[x] = it }
    }

    /**
     * Объединить два множества, в котрых лежат элементы Х и Y. в одно новое.
     */
    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return
        if ((0..1).random() % 2 == 0) {
            parent[rootX] = rootY
        } else {
            parent[rootY] = rootX
        }
        count--
    }
}

