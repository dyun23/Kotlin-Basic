fun main() {
    fun sum(a: Int, b: Int): Int { // 함수 기본형
        return a + b
    }
    fun sum2(a: Int, b: Int) = a + b // 간단한 표현식 함수


    fun greet(name: String = "Guest") { // 기본값 설정 가능
        println("Hello $name!")
    }
    greet()
    greet("Alice")


    fun displayInfo(name: String = "Unknown", age: Int = 0) {
        println("Name: $name, Age: $age")
    }
    displayInfo(age = 25) // 파라미터를 지정해서 값 전달 가능


    fun String.lastChar(): Char = this[this.length - 1] // 기존 클래스에 새로운 함수 추가 가능 (확장 함수)
    val text1 = "Hello"
    println(text1.lastChar())


    fun Employee.printInfo() { // 클래스에 이미 같은 이름의 멤버 함수가 있어 멤버 함수 > 확장 함수
        println("Extended Employee Info")
    }
    val emp = Employee()
    emp.printInfo()


    val text2 = "Hello"
    println(text2.firstChar)

    val numbers = listOf(10, 20, 30)
    println(numbers.firstElement) // 10 출력
}

class Employee {
    fun printInfo() {
        println("Employee Info")
    }
}

val String.firstChar: Char
    get() = this[0] // 확장 프로퍼티에 사용되는 커스텀 Getter, firstChar를 호출할 때마다 get()이 실행됨

val <T> List<T>.firstElement: T?  // 제네릭 타입 매개변수는 항상 함수나 프로퍼티 앞에 선언
    get() = if (this.isNotEmpty()) this[0] else null