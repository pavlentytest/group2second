

fun main() {
    val x = { println("123") }
    val anon = fun() = println("123123")
    anon()
    anon.invoke()


    x()
    x.invoke()

    val z: () -> Unit = { println(123) }
    z()

    val printer = { a: String -> println(a) }
    printer("Hello")

    val sum = { a: Int, b: Int -> println(a+b)}
    sum(2,3)
    sum(4,5)

    val sum2 = {x: Int, y: Int ->
        val result = x*y
        println("$x * $y = $result")
    }

    val sum3 = {x: Int, y: Int -> val result = x*y; println("$x * $y = $result") }

    // Лямбду передаем
    doOperation(100,200, { a1, b1 -> a1+b1 })
//  Анонимная функцию - без названия
    doOperation(100,200, fun(a1: Int, b1: Int) = a1+b1)
// тоже Лямбда
    doOperation(100,200) { a1, b1 -> a1 + b1 }

    val r = bigFun(1)
    println(r(1,2))
    //println(r.invoke(1,2))
    val r1 = bigFun(10)
    println(r(1,2)) // 100
}


fun bigFun(key: Int) : (Int, Int) -> Int {
    when(key) {
        1 -> return fun(x: Int, y: Int) = x - y   // anonym
        2 -> return fun(x: Int, y: Int) = 2*x + 2*y // anonym
        else -> return { x, y -> 100} // lambda
    }
}



fun doOperation(x: Int, y: Int, op: (Int,Int) -> Int) {
    val result = op(x,y)
    //println("Result = $result")
    println("Result=${result+100}")
}


