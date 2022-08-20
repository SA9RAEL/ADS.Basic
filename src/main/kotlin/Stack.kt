package ADS.Basic.src.main.kotlin

import java.lang.IllegalArgumentException
import kotlin.collections.ArrayList

/**
 * Структура данных: Стэк
 *
 * Описание: в стеке используется принцип LIFO (последний пришёл, первый вышел)
 * Все операции выполняются за время O(1)
 */

interface Stack<T: Comparable<T>> {
    /**
     * добавляет элемент в вершин стека
     *
     * @item - элемент
     */
    fun push(item: T)

    /**
     * удаляет элемент с вершины стека и возвращает его
     */
    fun pop(): T

    /**
     * взвращает элемент из верхушки стека без его удаления
     */
    fun peek(): T

    /**
     * возввращает true если стек пустой
     */
    fun isEmpty(): Boolean

    /**
     * очищает стек
     */
    fun clear()

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

    /**
     * реализация через связный список
     *
     * @T - тип элементов стека
     */
    class LinkedListStack<T : Comparable<T>> : Stack<T> {
        private val data = java.util.LinkedList<T>()

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
            return data.peekLast()
        }

        override fun isEmpty() = data.isEmpty()


        override fun clear() {
            data.clear()
        }

    }
}