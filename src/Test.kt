package javaSolutions.src

fun main() {
    val a = 30
    val b = 20
    val c = 40
    val d = 10
    val e = 59
    test(a)
    test(b)
    test(c)
    test(d)
    test(e)

}
fun test (num: Int) {
    println(Math.floorMod(num, 60))
}