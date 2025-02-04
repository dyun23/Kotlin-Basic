# 4. 클래스와 객체지향 프로그래밍
[코드](https://github.com/dyun23/Kotlin-Basic/blob/master/4.class/src/Class.kt)

## 기본 생성자

클래스 정의할 때 이름 뒤에 기본 생성자를 바로 정의할 수 있음

```kotlin
class Person(val name: String, var age: Int)
```

## 프로퍼티

자바의 멤버변수와 달리 코틀린에서는 **프로퍼티**를 선언

프로퍼티를 선언할 때 자동으로 getter, setter가 포함되어서 생성

```kotlin
class Person(val name: String, var age: Int) {
    var height: Double = 0.0 // 추가 프로퍼티 선언
}
```

## 커스텀 Getter, Setter

프로퍼티의 getter, setter를 커스텀해서 추가 가능

`get()`, `set()` : getter, setter를 커스텀할 때 사용

커스텀 getter만 정의하면 기본 setter는 자동 생성 X

```kotlin
class Person(val name: String, var age: Int) {
    var isAdult: Boolean
        get() = age >= 18 // 커스텀 게터
}
```

## 확장 프로퍼티

확장 함수처럼 기존 클래스에 새로운 프로퍼티 추가 가능

```kotlin
val String.firstChar: Char
		get() = this[0]
```

## 초기화 블록 (init)

기본 생성자 외에 초기화 블록 추가 가능

클래스가 생성될 때 실행

```kotlin
class Person(val name: String, var age: Int) {
    init {
        println("Person initialized with name = $name and age = $age")
    }
}
```

## 보조 생성자 (constructor)

기본 생성자 외에 보조 생성자 추가 가능

보조 생성자 만으로는 객체 생성 불가, 기본 생성자를 거쳐야함

→ 보조 생성자는 기본 생성자를 무조건 호출

**기본 생성자가 없는 경우**에는 보조 생성자만 사용 가능

```kotlin
class Person(val name: String) {
    var age: Int = 0

    constructor(name: String, age: Int) : this(name) { // 기본 생성자 호출
        this.age = age
    }
}
```

여러 보조 생성자도 선언 가능

```kotlin
class Person(val name: String, var age: Int) {
    var height: Double = 0.0

    // ✅ 첫 번째 보조 생성자 (name과 age 설정)
    constructor(name: String) : this(name, 0) {
        println("Person initialized with name only")
    }

    // ✅ 두 번째 보조 생성자 (모든 값 설정)
    constructor(name: String, age: Int, height: Double) : this(name, age) {
        this.height = height
        println("Person initialized with name, age, and height")
    }
}
```

## 상속 (open)

코틀린에서 클래스는 기본적으로 `final`

다른 클래스가 상속하게 하려면 부모 클래스에 `open` 키워드 사용

자식 클래스는 뒤에 `: [부모 클래스]` 붙여서 상속

```kotlin
open class Person(val name: String)

class Student(name: String, val studentId: String) : Person(name)
```

## 오버라이딩 (override)

`override` 키워드 : 메서드나 프로퍼티를 재정의

메서드나 프로퍼티도 기본적으로 `final`

재정의 하려는 메서드나 프로퍼티에 마찬가지로 `open` 키워드 사용

프로퍼티는 변경 가능 여부가 일치해야 재정의 가능

```kotlin
open class Person(val name: String) {
    open fun introduce() { // 메서드에도 open 사용
        println("Hello, I'm $name.")
    }
}

class Student(name: String, val studentId: String) : Person(name) {
    override fun introduce() { // override 키워드 사용
        println("Hello, I'm $name, and my student ID is $studentId.")
    }
}
```