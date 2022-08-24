package ADS.Basic.src.main.kotlin

/**
 * ��������� ������: ����������� ����
 * �������� � ���������� ������ ���������:
 * 1. ��������� ������������ �������� --- O(1)
 * 2. ������� ������ �������� --- O(logn)
 * 3. �������� �������� --- O(logn)
 * ��������: ���-��� - ��� �������� ������, � ������� ������ �������� ������ ����� ��������.
 * ����� ������� ������� � �������� i ����� ������ 2*i+1, � ������ 2*i+2
 * ������ ������ - ������� � �������� 0.
 * ������ �������� ���� ����� ������ ������, log2(N), ��� N - ���-�� ��������� �������.
 */

class MinHeap<T : Comparable<T>>() {
    private val items = mutableListOf<T>()
    var size: Int = 0

    /**
     * ��������� ������� � ����� ����, ���������� � ���������� �� 1,
     * ����� ���������� ��������� ����������� �����.
     */
    fun insert(item: T) {
        set(size++, item)
        siftUp(size - 1)
    }

    /**
     * ����������� ������ ������� (������)
     */
    private fun peek() = get(0)

    /**
     * ������ � ������� ����������� ��������.
     * ���� ���� ������ - ����� null.
     * � ��������� ������ ����� (� "��������") �������� (�����������) �������,
     * �������� ��� � ��������� ��������� � ����, ����� ������� ���� ������� ����,
     * ����� ����������� �������� ����.
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
     * ������� "����������� �����":
     * ���� ������� ������� ������ �������������, �������� �� ������� �
     * ����� ��������� ��� ��������, ������� ������ ��������� � ������������ �������,
     * ���� �� ����� ������������� �������� ����.
     * ������� ������� - ��������� ������� ���������� ������.
     * ���� � ���� ��� �������� (�.�. �� ������), �� �� ����� ����� ��� ���� ����������.
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
     * ������� "����������� ����":
     * ����� ������� �������� ��������.
     * �������������, ��� ����� �������� ������� ����������,
     * ������ ��� ��� �� �������� ����,
     * � ��������� �� ��������� �������� � ����, �������� �� � �����,
     * ����� ���� ������ ���� �������� ����� ������ �����.
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