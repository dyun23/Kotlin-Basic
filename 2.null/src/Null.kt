fun main() {
    var name: String? = null // null 가능
    println(name?.length)

    // 엘비스 연산자(?:)
    val length = name?.length ?: 0 // null이면 0으로 치환
    println("Length is $length")

//    val length2 = name!!.length // not-null로 강제 변환
//    println("Length2 is $length2")

    // Safe Cast (as?)
    val obj: Any = 123
    val str1: Int? = obj as? Int
    val str2: String? = obj as? String

    println(str1) // 출력 : 123
    println(str2)  // 출력 : null
}