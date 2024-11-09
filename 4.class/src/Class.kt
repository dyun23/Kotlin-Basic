open class Person(val name: String) { // 클래스 이름 뒤에 기본 생성자 정의
    var height: Double = 0.0 // 프로퍼티 선언할 때 자동으로 getter, setter 생성
    var age: Int = 0
    val isAdult: Boolean
        get() = age >= 18 // getter, setter 커스텀 가능

    init { // 기본 생성자 이외에 초기화 블록 사용 가능, 클래스가 생성될 때 실행
        println("Person initialized with name = $name and age = $age")
    }

    constructor(name: String, age: Int) : this(name) { // 보조 생성자 추가 가능, : this(기본 생성자) 형태로 기본 생성자 호출해서 사용
        this.age = age
    }

    open fun introduce() {
        println("Hello, I'm $name.")
    }
}

class Student(name: String, val studentId: String) : Person(name) { // 기본적으로 클래스는 final이라 부모 클래스에 open을 앞에 달아줘야 상속 가능
    override fun introduce() { // override 키워드 사용해서 오버라이딩 가능, 메서드에도 부모 메서드에 open을 앞에 달아줘야 상속 가능
        println("Hello, I'm $name, and my student ID is $studentId.")
    }
}