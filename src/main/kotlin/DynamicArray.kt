package ADS.Basic.src.main.kotlin

/**
 * структура данных: динамиеский массив
 *
 * описание: обертка над обычным массивом, в котором осуществл€етс€ проверка
 * индексов и при переполнении массива его размер увеличиваетс€ динамически
 */
class DynamicArray(private var capacity: Int = 10) {
    private var data: Array<Int?> = Array(capacity) { 0 }
    private var index = 0

    /**
     * добавл€ет новый элемент в массив,
     * если массив не может вместить элемент, то его размер
     * динамичесски увеличиваетс€
     * @value - элемент
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
     * @return возвращает индекс нахд€щегос€ в массиве элемента
     * если его нет, возвращает -1
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
     * удал€ет элемент из массива и сдвигает на его место последующие
     * @value - элемент
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
     * провер€ет на существование элемента в массива
     *
     * @value - элемент
     *
     * @return возвращает true, если элемент присутствует в массиве
     */
    fun contains(value: Int): Boolean {
        return value in data
    }

    /**
     * устанавливает новое значение элемента дл€ указанного индекса
     *
     * @index - индекс элемента
     * @value - новое значение элемента
     *
     * @return возвраащаает true, если элемент был успешн изменЄн
     */
    fun set(index: Int, value: Int): Boolean {
        if (isBound(index)) {
            data[index] = value
            return true
        }
        return false
    }

    /**
     * возвращает значение элемента по индексу или генерирует исключение, если
     * некорректный индекс
     * @index - индекс элемента
     * @return возвращает значение элемента по индексу
     */
    operator fun get(index: Int): Int? {
        if (isBound(index)) {
            return data[index]
        } else {
            throw java.lang.IllegalStateException("Index is out of bound!")
        }
    }

    /**
     * возвращает размер массива
     *
     * @return возвращет размер массива
     */
    fun capacity() = capacity

    /**
     * проверка на корректный индекс
     *
     * @return возвращает true, если индекс входит в дапазон доступных индексов
     */
    private fun isBound(i: Int) = i in 0 until index

    override fun toString() = data.joinToString(", ")

    /**
     * увеличивает размер массива, когда его не хватает
     */
    private fun increaseSize() {
        val newArray = data.copyOf(capacity * 2)

        data = newArray
    }

    /**
     * ”меньшает размер максимальной вместимости, если большинсво "€чеек" не заполнены.
     */
    private fun decreaseSize() {
        val oldArray = data.copyOf(capacity)

        data = oldArray
    }
}