/*
Раздел посвященный алгоритмам и структурам данных
Глава 2. Двумерные массивы.
*/

/*
Задача 1.
Дано число n - размер квадратной матрицы. 
Создайте двумерный массив и заполните его нулями, единицами и двойками по правилу: 
единицы располагаются на побочной диагонали, нули над единицами, а двойки под. 
Выведите полученный двумерный массив на экран. 
Входные данные
Программа получает на вход n - размер матрицы ( 1 ≤ n ≤ 2^7−1).
Выходные данные
Программа должна вывести  полученный массив. Числа разделяйте одним пробелом.
Sample Input:
4
Sample Output:
0 0 0 1 
0 0 1 2 
0 1 2 2 
1 2 2 2
*/
fun f1(num: Int){
    //Двумерный массив заполненный нулями
    var matrix = Array(num){Array(num){0}}
    for (i in 0..num-1){
        for (j in 0..num-1){
            when {
                i + j == num - 1 -> matrix[i][j] = 1
                i + j < num - 1 -> matrix[i][j] = 0
                else -> matrix[i][j] = 2
            } 
        }
    }
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}

/*
fun main(){
    var num : Int = readLine()!!.toInt()
    f1(num)
}
*/

/*
Задача 2. - та же самая задача 
Дано число n (n≤100). 
Создайте массив n×n и заполните его по следующему правилу:
 1)числа на диагонали, идущей из правого верхнего в левый нижний угол, равны 1;
 2)числа, стоящие выше этой диагонали, равны 0;
 3)числа, стоящие ниже этой диагонали, равны 2.
Входные данные
Программа получает на вход число n.

Выходные данные
Необходимо вывести  полученный массив. Числа разделяйте одним пробелом
Sample Input:
4
Sample Output:
0 0 0 1 
0 0 1 2 
0 1 2 2 
1 2 2 2 
*/

/*
Задача 3.
Проверьте, является ли двумерный массив симметричным относительно главной диагонали. 
Главная диагональ — та, которая идёт из левого верхнего угла двумерного массива в правый нижний.

Входные данные
Программа получает на вход число n (n≤100), являющееся числом строк и столбцов в массиве. 
Далее во входном потоке идет n строк по n чисел, являющихся элементами массива. 
Числа по модулю не превышают 2^31−1.

Выходные данные
Программа должна выводить слово yes для симметричного массива и слово no для несимметричного.

Sample Input 1:
3
0 1 2
1 5 3
2 3 4
Sample Output 1:
yes

Sample Input 2:
3
0 0 0
0 0 0
1 0 0
Sample Output 2:
no
*/

fun f2(num : Int){
    var flag : Boolean = true
    //Заводим двумерный массив и заносим в нём значения - способ 1
    var matrix = Array(num){Array(num){0}}
    for (i in 0 until num) {
        val row = readLine()!!.split(" ").map { it.toInt() }
        for (j in 0 until num) {
            matrix[i][j] = row[j]
        }
    }
    /* Способ 2
    val nums = readLine()!!.split(" ").map { it.toInt() }
    var index = 0
    for (i in 0 until num) {
        for (j in 0 until num) {
            matrix[i][j] = nums[index]
            index++
        }
    }
    */
    for (i in 0 until num){
        for (j in 0 until num){
            if (matrix[i][j] != matrix[j][i]) {
                flag = false
                break
            }
        }
        if (!flag) break
    }
    if (flag) println("yes") else println("no")
}

/*
fun main(){
    var num : Int = readLine()!!.toInt()
    f2(num)
}
*/

/*
Задача 4.
Напишите программу, отображающую игровое поле для игры "Сапер".

Входные данные
Даны числа N и M (целые, положительные, не превышают 32) – количество строк и столбцов в поле соответственно, 
далее число W (целое, неотрицательное, не больше 1000) – количество мин на поле, 
далее следует W пар чисел, координаты мины на поле (первое число – строка, второе число – столбец). 
Числа по модулю не превышают 2^9−1.

Выходные данные
Требуется вывести на экран поле. Формат вывода указан в примере.

Sample Input 1:
3 2
2
1 1
2 2
Sample Output 1:
* 2
2 *
1 1

Sample Input 2:
2 2
0
Sample Output 2:
0 0
0 0
*/

// fun fun4(pair_numbers: Pair<Int,Int>, W: Int, pairs: Array<Pair<Int, Int>>){
//     val field = Array(pair_numbers.first) { Array(pair_numbers.second){"0"}} // Поле с нулями
//     for (index in 0 until W){
//         field[pair_numbers.first, pair_numbers.second] = "*"
//     }
     
// }

// fun main(){
//     val (N,M) = readLine()!!.split(" ").map{it.toInt()}
//     val pair_numbres = Pair(N,M) //Первый способ создание пары - обращение через .first, .second
//     /*val pair_numbers = N to M - второй способ создания пары */
//     val W = readLine()!!.toInt()
//     val pairs : Array<Pair<Int, Int>> = Array(count_pairs){0 to 0}
    
// }
fun fun4(N:Int, M:Int, W:Int, cordMins:Array<Pair<Int,Int>>){
    val field = Array(N, {Array(M){0}}) //Двумерный массив с размерами N и M
    for (i in 0 until W) { // Устанавливаем мины
        field[cordMins[i].first - 1][cordMins[i].second - 1] = -1
    }
    // направления для проверки 8 соседей
    val dx = listOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = listOf(-1, 0, 1, -1, 1, -1, 0, 1)
    
    for((x,y) in cordMins){
        for (distinct in dx.indices){
            var tmp_x = (x - 1) + dx[distinct]
            var tmp_y = (y - 1) + dy[distinct]
            if(tmp_x in 0 until N && tmp_y in 0 until M && field[tmp_x][tmp_y] != -1){
                field[tmp_x][tmp_y] += 1
            }
        }
    }
    // выводим поле
    for (i in 0 until N) {
        val row = field[i].map { if (it == -1) "*" else it.toString() }
        println(row.joinToString(" "))
    }
}

fun main(){
    val (N, M) = readLine()!!.split(" ").map{it.toInt()}
    val W = readLine()!!.toInt()
    //Заносим пары в массив
    val cordMins: Array<Pair<Int,Int>> = Array(W){0 to 0} //Либо Array(W, Pair(0,0))
    for (i in 0 until W){
        val (a,b) = readLine()!!.split(" ").map{it.toInt()}
        cordMins[i] = Pair(a,b)
    }
    fun4(N,M,W,cordMins)
}