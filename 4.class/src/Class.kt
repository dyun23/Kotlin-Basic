fun main() {
    // 확장 프로퍼티
    val text2 = "Hello"
    println(text2.firstChar)

    val numbers = listOf(10, 20, 30)
    println(numbers.firstElement) // 10 출력

    // 보조 생성자
    val p1 = Person("Alice")
    val p2 = Person("Bob", 25, 180.0)

    // 상속
    val s1 = Student("Christina", "250011")
    s1.introduce()
}

val String.firstChar: Char
    get() = this[0] // 확장 프로퍼티에 사용되는 커스텀 Getter, firstChar를 호출할 때마다 get()이 실행됨

val <T> List<T>.firstElement: T?
    get() = if (this.isNotEmpty()) this[0] else null

// 부모 클래스에 open을 앞에 달아줘야 상속 가능
open class Person(val name: String, var age: Int) { // 클래스 이름 뒤에 기본 생성자 정의 가능

    var height: Double = 0.0 // 프로퍼티를 선언할 때 자동으로 getter, setter 생성
    val isAdult: Boolean
        get() = age >= 18 // getter, setter 커스텀 가능

    init { // 기본 생성자 이외에 초기화 블록 사용 가능, 클래스가 생성될 때 실행
        println("Person initialized with name = $name and age = $age")
    }

    // 첫 번째 보조 생성자 (name만 입력)
    constructor(name: String) : this(name, 0) {  // 기본 생성자 호출
        println("Person initialized with name only")
    }

    // 두 번째 보조 생성자 (모든 값 설정)
    constructor(name: String, age: Int, height: Double) : this(name, age) { // 기본 생성자 호출
        this.height = height
        println("Person initialized with name, age, and height")
    }

    open fun introduce() { // 오버라이딩 가능한 메서드에도 open 사용
        println("Hello, I'm $name.")
    }
}

class Student(name: String, val studentId: String) : Person(name) {
    override fun introduce() { // override 키워드 사용해서 오버라이딩 가능, 메서드에도 부모 메서드에 open을 앞에 달아줘야 상속 가능
        println("Hello, I'm $name, and my student ID is $studentId.")
    }
}