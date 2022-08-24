package ADS.Basic.src.main.kotlin

/**
 * Структура данных: минимальная куча
 * Операции и сложноссть работы алгоритма:
 * 1. Получение минимального элемента --- O(1)
 * 2. Вставка нового элемента --- O(logn)
 * 3. Удаление элемента --- O(logn)
 * Описание: мин-хип - это бинарное дерево, в котором каждый родитель меньше своих потомков.
 * Левый потомок вершины с интексом i имеет индекс 2*i+1, а правый 2*i+2
 * Корень дерева - элемент с индексом 0.
 * Высота двоичной кучи равна высоте дерева, log2(N), где N - кол-во элементов массива.
 */

class MinHeap<T : Comparable<T>>() {
    private val items = mutableListOf<T>()
    var size: Int = 0

    /**
     * Добавляет элемент в конец кучи, увеличивая её местимость на 1,
     * далее проводится процедура просеивания вверх.
     */
    fun insert(item: T) {
        set(size++, item)
        siftUp(size - 1)
    }

    /**
     * Возвращаает первый элемент (корень)
     */
    private fun peek() = get(0)

    /**
     * Достаёт и удаляет минимальное значение.
     * Если куча пустая - вернёт null.
     * В противном случае вернёт (и "запомнит") корневой (минимальный) элемент,
     * поменяет его с последним элементом в куче, потом просеет этот элемент вниз,
     * чтобы всстановить свойство кучи.
     */
    fun remove(): T? {
        return if (size == 0) {
            null
        } else {
            val min = peek()
            set(0, get(--size))
            items.removeAt(size)
            siftDown(0)
            min
        }
    }

    /**
     * Функция "просеивания вверх":
     * Если текущий элемент больше родительского, поменять их местами и
     * затем повторить для элемента, который теперь находится в родительской позиции,
     * пока не будет восстановлено свойство кучи.
     * Другими словами - Маленький элемент “всплывает вверх”.
     * Если у узла нет родителя (т.е. он корень), мы всё равно можем его типа сифтапнуть.
     */
    private fun siftUp(i: Int) {
        if (i == 0) {
            return
        }
        val parent = parentIndex(i)
        if (get(i) > get(parent)) {
            swap(i, parent)
            siftUp(parent)
        }
    }

    /**
     * Функция "просеивания вниз":
     * Найти большее дочернее значение.
     * Гарантировать, что левый дочерний элемент существует,
     * потому что это не конечный узел,
     * и поскольку мы добавляем элементы в кучу, добавляя их в конец,
     * левый узел должен быть заполнен перед правым узлом.
     *
     */
    private fun siftDown(i: Int) {
        if (i >= size / 2) {
            return
        }
        while (leftChildIndex(i) <= size) {
            val left = leftChildIndex(i)
            val right = rightChildIndex(i)
            var smallerChild = left
            if (right < size && get(right) < get(left)) {
                smallerChild = right
            }
            if (i <= smallerChild) {
                break
            }
            swap(i, smallerChild)

        }


    }

    private fun set(i: Int, value: T) {
        if (i < items.size - 1) {
            items[i] = value
        } else {
            items.add(value)
        }
    }

    private fun get(i: Int): T {
        return if (i <= items.size - 1 ) {
            items[i]
        } else {
            throw Exception("Element has not found")
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = items[i]
        items[i] = items[j]
        items[j] = temp
    }

    private fun parentIndex(i: Int) = (i - 1) / 2
    private fun leftChildIndex(i: Int) = i * 2 + 1
    private fun rightChildIndex(i: Int) = i * 2 + 2
}