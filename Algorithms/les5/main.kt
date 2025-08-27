/*
Раздел посвященный алгоритмам и структурам данных
Глава 3. Списки.
*/

/*
Реализация односвязного списка - простейший случай
*/

class Node(val data: Int, val next: Node? = null) { }

class LinkedList {
    private var head: Node? = null
    
    //Вставка в начало списка
    /*
        (1) - Создаем новую переменную типпа Node
        (2) - Зная, что существует свойство next у класса Node, 
            передадим начало списка head голове объекта new_node - теперь new_node голова (передали указатель)
        Важно: переменная head всё ещё указывает на старый первый узел.
        (3) - Передаем старой переменной head типа Node новый объект new_node типа Node -
            т.е. меняем у head указатель на указатель new_node, т.е. head - своеобразный помощник
    */
    fun insert_at_beginning(val data: Int){
        val new_node : Node = Node(data) //(1)
        new_node.next = this.head //(2)
        this.head = new_node //(3)
    }

    //Вставка в конец списка
    /*
        (1) - Создаем новый объект типа Node
        (2) - На всякий случай проверяем голову head на null
        (3) - Если голова head НЕ пуста, то присвоем переменной last, как голову, т.е. "условно" вставили вперед списка
            НО
        (4) - Перетаскиваем "условную" голову в конец списка
        (5) - Присваиваем "условную" голову last указатель переменной new_node, а сам new_node.next будет хранить null, 
            так как ждет другой новой переменной
    */
    fun insert_at_end(val data: Int){
        val new_node : Node = Node(data) // (1)
        if (this.head == null){ // (2)
            new_node.next = this.head // (?) -  по идеи как правильно
            this.head = new_node
            return
        }
        val last : Node = this.head //(3)
        while (last?.next != null){ //(4)
            last = last.next
        }
        last?.next = new_node //(5)
    }

    //Удаление узла по заданному ключу (значению data)
    fun delete_node(key: Int){

    }
}
/*
Задача 1.
Удалите из односвязного списка все узлы с заданным значением.

Формат входных данных
Первая строка содержит число n (1 ≤ n ≤ 10^5) - количество элементов в списке.
Вторая строка содержит n целых чисел (1 ≤ a_i ≤ 10^9), разделенных пробелами - значения элементов списка. 
Третья строка содержит целое число val (1 ≤ val ≤ 10^9) - значение, которое нужно удалить из списка.

Формат выходных данных
Все значения элементов обновленного списка, разделенные пробелами. Если список становится пустым, выведите None.

Sample Input 1:
5
1 2 3 4 5
3
Sample Output 1:
1 2 4 5

Sample Input 2:
1
1
1
Sample Output 2:
None
*/
fun f1(n_size: Int, my_list: MutableList<Int>, delete_value: Int) : MutableList<Int> {
    my_list.removeAll {element -> element == delete_value}
    return my_list
}
//Использовать фильтр
fun f1(myList: MutableList<Int>, deleteValue: Int): List<Int> {
    return myList.filter { it != deleteValue }
}

/*
fun main(){
    var n_size : Int = readLine()!!.toInt()
    var my_list : MutableList<Int> = readLine()!!.split(" ").map{it.toInt()}.toMutableList()
    var delete_value : Int = readLine()!!.toInt()
    var result = f1(n_size, my_list, delete_value)
    println(if (result.isEmpty()) "None" else result.joinToString(" "))
}*/

/*
Задача 2.
Найдите срединный элемент в односвязном списке. 
Если список содержит четное количество элементов, верните второй элемент из двух средних.

Формат входных данных:
Первая строка содержит число n (1 ≤ n ≤ 10ˆ5) - количество элементов в списке. 
Вторая строка содержит n целых чисел (1 ≤ a_i ≤ 10ˆ9), разделенных пробелами - значения элементов списка.

Формат выходных данных:
Значение среднего элемента в списке.

Sample Input:
5
1 2 3 4 5

Sample Output:
3
*/

fun f2(n_size:Int, my_list:MutableList<Int>) : Int {
    var middle : Int = n_size / 2
    return my_list.get(middle)
}

fun main(){
    var n_size : Int = readLine()!!.toInt()
    var my_list : MutableList<Int> = readLine()!!.split(" ").map{it.toInt()}.toMutableList()
    println(f2(n_size, my_list))
}