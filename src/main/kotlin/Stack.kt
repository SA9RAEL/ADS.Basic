package ADS.Basic.src.main.kotlin

import java.lang.IllegalArgumentException
import kotlin.collections.ArrayList

/**
 * Структура данных: Стэк
 *
 * Описание: в стеке используется принцип LIFO (последний пришёл, первый вышел)
 * Все операции выполняются за время O(1)
 */

interface Stack<T : Comparable<T>> {
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

}