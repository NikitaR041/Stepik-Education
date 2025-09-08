/*
Раздел посвященный алгоритмам и структурам данных
Глава 4. Стек.
*/

/*
Реализация стека - простейший случай с использованием связного списка
*/

class Stack(){
    private val myList: MutableList<Int> = mutableListOf<Int>()

    //Метод добавление элемента в список
    fun push(data: Int){
        this.myList.add(data)
    }

    fun pop() : Int{
        if (myList.isEmpty()) throw NoSuchElementException("Stack is empty")
        return myList.removeAt(myList.size - 1)
    }

    fun peek() : Int {
        if (myList.isEmpty()) throw NoSuchElementException("Stack is empty")
        return this.myList.get(this.myList.size - 1)
    }

    fun isMyEmpty() : Boolean{
        return myList.isEmpty()    
    }

    fun size() : Int {
        return this.myList.size
    }
}

/*
fun main(){
    val stack = Stack()
    stack.push(10)
    stack.push(20)
    println(stack.peek()) // 20
    println(stack.pop())  // 20
    println(stack.isMyEmpty()) // false
}
*/

/*
Такой же способ, но через Node
*/

class Node(var data: Int, var next: Node? = null) { }

class Stack2{
    private var head: Node? = null

    fun push(data : Int) {
        val new_node : Node = Node(data)
        new_node.next = this.head
        this.head = new_node
    }

    fun pop() : Int {
        if (this.head == null) {
            throw NoSuchElementException("Stack is empty")
        }else{
            val value : Int = this.head!!.data
            this.head = this.head!!.next
            return value
        }
    }

    fun peek() : Int {
        if (this.head == null) {
            throw NoSuchElementException("Stack is empty")
        }else{
            return this.head!!.data    
        }
    } 

    fun isMyEmpty() : Boolean{
        return this.head == null
    }
}

/*
fun main(){
    val stack = Stack()

    try {
        println("Пробуем достать элемент из пустого стека:")
        println(stack.pop())
    } catch (e: NoSuchElementException) {
        println("Ошибка: ${e.message}")
    }

    println("\nДобавляем элементы в стек:")
    stack.push(10)
    stack.push(20)
    println("Верхний элемент: ${stack.peek()}")
    
    try {
        println("Извлекаем элемент: ${stack.pop()}")
        println("Извлекаем элемент: ${stack.pop()}")
        println("Извлекаем элемент: ${stack.pop()}")
    } catch (e: NoSuchElementException) {
        println("Ошибка: ${e.message}")
    }
}*/