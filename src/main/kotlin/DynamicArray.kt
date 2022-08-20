package ADS.Basic.src.main.kotlin

/**
 * ��������� ������: ����������� ������
 *
 * ��������: ������� ��� ������� ��������, � ������� �������������� ��������
 * �������� � ��� ������������ ������� ��� ������ ������������� �����������
 */
class DynamicArray(private var capacity: Int = 10) {
    private var data: Array<Int?> = Array(capacity) { 0 }
    private var index = 0

    /**
     * ��������� ����� ������� � ������,
     * ���� ������ �� ����� �������� �������, �� ��� ������
     * ������������ �������������
     * @value - �������
     */
    fun add(value: Int) {
        if (index < data.size - 1) {
            data[index++] = value
        } else {
            increaseSize()
            data[index++] = value
        }
    }

    /**
     * @return ���������� ������ ����������� � ������� ��������
     * ���� ��� ���, ���������� -1
     */
    fun indexOf(value: Int): Int {
        var foundElement = -1
        data.forEachIndexed { index, i ->
            if (value == i) {
                foundElement = index
            } else {
                foundElement
            }
        }
        return foundElement
    }

    /**
     * ������� ������� �� ������� � �������� �� ��� ����� �����������
     * @value - �������
     */
    fun remove(value: Int): Boolean {
        val foundedIndex = indexOf(value)
        var count = 0
        if (foundedIndex == -1) {
            return false
        }
        for (i in foundedIndex until data.size - 1) {
            data[i] = data[i + 1]
        }
        data.forEach {
            if (it != null) count++
        }
        if (count < capacity) {
            decreaseSize()
        }
        return true
    }

    /**
     * ��������� �� ������������� �������� � �������
     *
     * @value - �������
     *
     * @return ���������� true, ���� ������� ������������ � �������
     */
    fun contains(value: Int): Boolean {
        return value in data
    }

    /**
     * ������������� ����� �������� �������� ��� ���������� �������
     *
     * @index - ������ ��������
     * @value - ����� �������� ��������
     *
     * @return ������������ true, ���� ������� ��� ������ ������
     */
    fun set(index: Int, value: Int): Boolean {
        if (isBound(index)) {
            data[index] = value
            return true
        }
        return false
    }

    /**
     * ���������� �������� �������� �� ������� ��� ���������� ����������, ����
     * ������������ ������
     * @index - ������ ��������
     * @return ���������� �������� �������� �� �������
     */
    operator fun get(index: Int): Int? {
        if (isBound(index)) {
            return data[index]
        } else {
            throw java.lang.IllegalStateException("Index is out of bound!")
        }
    }

    /**
     * ���������� ������ �������
     *
     * @return ��������� ������ �������
     */
    fun capacity() = capacity

    /**
     * �������� �� ���������� ������
     *
     * @return ���������� true, ���� ������ ������ � ������� ��������� ��������
     */
    private fun isBound(i: Int) = i in 0 until index

    override fun toString() = data.joinToString(", ")

    /**
     * ����������� ������ �������, ����� ��� �� �������
     */
    private fun increaseSize() {
        val newArray = data.copyOf(capacity * 2)

        data = newArray
    }

    /**
     * ��������� ������ ������������ �����������, ���� ���������� "�����" �� ���������.
     */
    private fun decreaseSize() {
        val oldArray = data.copyOf(capacity)

        data = oldArray
    }
}