package ADS.Basic.src.main.kotlin

import java.lang.IllegalArgumentException

/**
 * ���������� ����� ������� ������
 *
 * @T - ��� ��������� �����
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