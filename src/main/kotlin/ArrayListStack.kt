package ADS.Basic.src.main.kotlin

import java.lang.IllegalArgumentException

/**
 * реализация с помощью динамического массива
 *
 * @T - тип элементов стека
 */
class ArrayListStack<T : Comparable<T>> : Stack<T> {
    private val data = ArrayList<T>()

    override fun push(item: T) {
        data.add(item)
    }

    override fun pop(): T {
        if (isEmpty()) {
            throw IllegalArgumentException("Stack is empty!")
        }
        return data.removeLast()
    }

    override fun peek(): T {
        if (isEmpty()) {
            throw IllegalArgumentException("Stack is empty!")
        }
        return data.last()
    }

    override fun isEmpty(): Boolean {
        return data.size == 0
    }

    override fun clear() {
        data.clear()
    }
}