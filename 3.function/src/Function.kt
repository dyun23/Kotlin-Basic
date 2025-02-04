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


    fun String.lastChar() = this[this.length - 1] // 기존 클래스에 새로운 함수 추가 가능 (확장 함수)
    val text1 = "Hello"
    println(text1.lastChar())


    fun Employee.printInfo() { // 클래스에 이미 같은 이름의 멤버 함수가 있어 멤버 함수 > 확장 함수
        println("Extended Employee Info")
    }
    val emp = Employee()
    emp.printInfo()

}

class Employee {
    fun printInfo() {
        println("Employee Info")
    }
}

