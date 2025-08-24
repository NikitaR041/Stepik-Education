/*
Раздел посвященный алгоритмам и структурам данных
Глава 2. Двумерные массивы.
*/
import kotlin.math.floor
import kotlin.math.ceil

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

/*
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
*/

/*
Задача 5.
Дан двумерный массив массив N×M. 
Требуется повернуть его по часовой стрелке на 90 градусов.

Входные данные
На первой строке даны натуральные числа N и M(1≤N, M≤50). 
На следующих N строках записано по M неотрицательных чисел, не превышающих 10^9 – сам массив. 
Числа по модулю не превышают 2^31-1.

Выходные данные
Выведите повернутый массив в формате входных данных.

Sample Input:

3 4
1 2 3 4
5 6 7 8
9 10 11 12
Sample Output:

4 3
9 5 1 
10 6 2 
11 7 3 
12 8 4 
*/

fun f5(N:Int, M:Int){
    val matrixNM = Array(N){Array(M){0}}
    for (i in 0 until N){ 
        val tmp_massive = readLine()!!.split(" ").map{it.toInt()}
        for (j in 0 until M){
            matrixNM[i][j] = tmp_massive[j]
        }
    }
    val newMatrixNM = Array(M){Array(N){0}}
    for (i in 0 until N){
        for (j in 0 until M){
            newMatrixNM[j][N-i-1] = matrixNM[i][j]
        }
    }
    for (row in newMatrixNM){
        println(row.joinToString(" "))
    }
}

/*
fun main(){
    val (N, M) = readLine()!!.split(" ").map{it.toInt()}
    f5(N,M)
}
*/

/*
Задача 6.
В прямоугольной таблице N×M в начале игрок находится в левой верхней клетке. 
За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз 
(влево и вверх перемещаться запрещено). 
Посчитайте, сколько есть способов у игрока попасть в правую нижнюю клетку.

Формат входных данных
Вводятся два числа N и M - размеры таблицы (1≤N≤10, 1≤M≤10).

Формат выходных данных
Выведите искомое количество способов.

Sample Input:
1 10
Sample Output:
1
*/

fun f6(N:Int, M:Int){
    val field = Array(N, {Array(M){1}}) //Двумерный массив с размерами N и M
    
    for (i in 0 until N){
        for (j in 0 until M){
            when {
                i == 0 && j > 0 -> field[i][j] = field[i][j-1] 
                i > 0 && j == 0 -> field[i][j] = field[i-1][j] 
                i > 0 && j > 0 -> field[i][j] = field[i-1][j] + field[i][j-1]
                else -> continue  
            }
        }
    }

    for (row in field){
        println(row.joinToString(" "))
    }
    println(field[N-1][M-1])
}

/*
fun main(){
    val (N, M) = readLine()!!.split(" ").map{it.toInt()}
    f6(N, M)
}
*/

/*
Задача 7.
Треугольник Паскаля
Даны два числа n и m. 
Создайте двумерный массив A[n][m] и заполните его по следующим правилам: 
Числа, стоящие в строке 0 или в столбце 0 равны 1 (A[0][j]=1, A[i][0]=1). 
Для всех остальных элементов массива A[i][j]=A[i-1][j]+A[i][j-1], то есть каждый элемент 
равен сумме двух элементов, стоящих слева и сверху от него.

Входные данные
Программа получает на вход два числа n и m.  
Числа от 1 до 15.

Выходные данные
Выведите данный массив.
Значения требуется выровнять по правому краю. 
Если число однозначное, перед ним устанавливается 5 знаков "пробел". 
Гарантируется, что все числа в правильном ответе не превышают 5 знаков в десятичной записи.

Sample Input:
3 4
Sample Output:
     1     1     1     1
     1     2     3     4
     1     3     6    10
*/
fun f7(N:Int, M:Int){
    val field = Array(N, {Array(M){1}}) //Двумерный массив с размерами N и M
    
    for (i in 0 until N){
        for (j in 0 until M){
            when {
                i == 0 && j > 0 -> field[i][j] = field[i][j-1] 
                i > 0 && j == 0 -> field[i][j] = field[i-1][j] 
                i > 0 && j > 0 -> field[i][j] = field[i-1][j] + field[i][j-1]
                else -> continue  
            }
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            print("%6d".format(field[i][j]))
        }
        println()
    }
}
/*
fun main(){
    val (N, M) = readLine()!!.split(" ").map{it.toInt()}
    f7(N, M)
}
*/

/*
Задача 8.
Заполнение спиралью.
Дано число n. 
Создайте массив A[2*n+1][2*n+1] и заполните его по спирали, начиная с числа 0 в центральной клетке A[n+1][n+1]. 
Спираль выходит вверх, далее закручивается против часовой стрелки.

Входные данные
Программа получает на вход одно число 0 ≤ n < 2^31.

Выходные данные
Программа должна вывести  полученный массив, отводя на вывод каждого числа не менее 3 символов.
Однозначное значение выравнивается по середине. Более длинные числа выравниваются слева.
Sample Input 1:

2
Sample Output 1:

12 11 10  9 24 
13  2  1  8 23 
14  3  0  7 22 
15  4  5  6 21 
16 17 18 19 20 
Sample Input 2:

1
Sample Output 2:

 2  1  8 
 3  0  7 
 4  5  6 
*/
fun f9(N: Int){
    var matrixTwoNAddPlus = Array(2*N+1){Array(2*N+1){0}}
    var size = (2*N+1)
    var tmp_x = N
    var tmp_y = N
    var count_move = 0 // Обход массива - должен достичь того же размера, что и N
    //Направления - Вверх,Вниз,Влево,Вправо - это не правильно
    // var dx = arrayOf(-1, 1, 0, 0)
    // var dy = arrayOf(0, 0, -1, 1)
    // Вверх, влево, вниз, вправо (по часовой/против часовой)
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, -1, 0, 1)

    var step = 1 //Изначальный шаг (движения по спирали)
    var dir = 0 //Изначальный индекс

    while (count_move < size * size - 1) {
        for (index in 0 until 2){ // дважды увеличиваем длину шага
            for (i in 0 until step) {
                if (count_move == size * size - 1) break
                tmp_x += dx[dir]
                tmp_y += dy[dir]
                count_move++
                matrixTwoNAddPlus[tmp_x][tmp_y] = count_move
            }
            dir = (dir + 1) % 4 // поворот
        }
        step++
    }
    for (row in matrixTwoNAddPlus) {
        for (value in row) {
            print("%3d ".format(value))
        }
        println()
    }
}

/*
fun main(){
    var N : Int = readLine()!!.toInt() //Есть центр клетки в матрице
    f9(N)
}
*/

/*
Задача 9.
Заполнение змейкой
Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой (см. пример).

Входные данные
Программа получает на вход два числа n и m. 
Числа по модулю не превышают 2^31−1.

Выходные данные
Программа должна вывести  полученный массив, отводя на вывод каждого числа ровно 3 символа с выравниванием по 
правой стороне.

Sample Input:
4 10
Sample Output:
  0  1  2  3  4  5  6  7  8  9
 19 18 17 16 15 14 13 12 11 10
 20 21 22 23 24 25 26 27 28 29
 39 38 37 36 35 34 33 32 31 30
*/

fun f10(N: Int, M: Int){
    var matrixNM = Array(N){Array(M){0}}
    var num = 0

    for (i in 0 until N) {
        if (i % 2 == 0) {
            // Чётная строка — слева направо
            for (j in 0 until M) {
                matrixNM[i][j] = num++
            }
        } else {
            // Нечётная строка — справа налево
            for (j in M - 1 downTo 0) {
                matrixNM[i][j] = num++
            }
        }
    }    // Печать
    for (row in matrixNM) {
        for (value in row) {
            print("%3d".format(value))
        }
        println()
    }
}

fun main(){
    var (N, M) = readLine()!!.split(" ").map{it.toInt()}
    f10(N,M)
}