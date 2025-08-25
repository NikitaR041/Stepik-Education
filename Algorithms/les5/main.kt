/*
Раздел посвященный алгоритмам и структурам данных
Глава 3. Списки.
*/

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

fun main(){
    var n_size : Int = readLine()!!.toInt()
    var my_list : MutableList<Int> = readLine()!!.split(" ").map{it.toInt()}.toMutableList()
    var delete_value : Int = readLine()!!.toInt()
    var result = f1(n_size, my_list, delete_value)
    println(if (result.isEmpty()) "None" else result.joinToString(" "))
}