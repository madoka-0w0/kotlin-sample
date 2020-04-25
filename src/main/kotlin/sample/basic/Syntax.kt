package sample.basic

// : Intは返り値の指定
fun sum1(a: Int, b: Int): Int {
    return a + b
}

// 省略形
fun sum2(a: Int, b: Int) = a + b

// javaのvoidはkotlinではUnit
fun print1(a: Int): Unit {
    println(a)
}

fun print2(a: Int) = println(a)

// unitは省略可能
fun print3(a: Int) {
    println(a)
}

/* ローカル変数 */
fun localVariable() {
    // valは変更できない
    val x: Int = 1
    val y = 1 // 推論
//    val z 初期値ないものは型指定が必要
    val z: Int
    z = 1
//    z = 2

    // varは変更できる
    var a: Int
    a = 1
    a = 2
}

fun strTemplate(str: String) {
    println("str: ${str}")
}

// 条件式省略形
fun condition(a: Int, b: Int) = if (a > b) a else b

// 返り値に?をつけるとnullが返せるようになる
fun nullFunc(str: String): Int? {
    if (str.length > 0)
        return str.length
    return null
}

// 型checkすると勝手にキャストしてくれるようだ
fun typeCheck1(obj: Any): Int? {
//    obj.length anyにはlengthはない

    if (obj is String) {
        return obj.length
    }
    return null
}

fun typeCheck2(obj: Any): Int? {
//    obj.length anyにはlengthはない

    if (obj !is String) {
        return null
    }
    // notのcheckでもキャストしてくれる
    return obj.length
}

fun loop(array: Array<String>) {
    for (arr in array) {
        print(arr)
    }
    for (i in array.indices) {
        print(array[i])
    }
    var i = 0
    while (i < array.size) {
        print(array[i++])
    }
}

fun switch(obj: Any) {
    when (obj) {
        1 -> println("1")
        "str" -> println("str")
        is Long -> println("long")
        else -> println("Unknown")
    }
}

fun range(array: Array<Int>) {
    val x = array[0]
    if (x in 1..10) {
        println("${x} in 1..10")
    }
    for (i in 1..5) {
        if (i !in 0..array.lastIndex) {
            println("out")
        }
    }
}

fun main() {
    println(sum1(1, 2))
    println(sum2(1, 2))
    print1(1)
    print2(1)
    print3(1)

    localVariable()

    strTemplate("test")

    condition(1, 2)

    print(nullFunc(""))

    println(typeCheck1("sample"))
    println(typeCheck2("sample"))

    /* 配列の作り方 */
    // List -> listOf
    // Array -> arrayOf
    // ArrayList -> arrayListOf
    // MutableList -> mutableListOf
    loop(arrayOf("a", "b", "c"))

    switch(arrayOf("a", "b", "c"))

    range(arrayOf(2, 3, 4, 5, 6))

    arrayOf(4, 5, 6, 2, 3, 4)
            .filter { it > 3 }
            .sortedBy { it }
            .map { "${it}" }
            .forEach { print(it) }

}