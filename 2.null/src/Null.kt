fun main() {
    var name: String? = null // null 가능
    println(name?.length)

    val length = name?.length ?: 0 // null이면 0으로 치환
    println("Length is $length")

//    val length2 = name!!.length // not-null로 강제 변환
//    println("Length2 is $length2")
}