class Queue {
    private val data = mutableListOf<String>()

    fun addToEnd(person: String) {
        data.add(person)
    }
    
    fun removeFromFront(): String {
        return data.removeFirst()
    }
}