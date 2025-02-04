# 3. 함수 정의 및 확장 함수
[코드](https://github.com/dyun23/Kotlin-Basic/blob/master/3.function/src/Function.kt)

## 함수 정의 방식

함수 정의 시 `fun` 키워드를 사용

함수의 반환 타입은 함수 선언의 마지막 부분에 표시

```kotlin
fun sum(a: Int, b: Int): Int { // 반환 타입 Int
		return a + b
}
```

## 표현식 함수

return 키워드 없이 = 사용하여 반환 값 지정 가능

```kotlin
fun sum(a: Int, b: Int) = a + b
```

## 기본 인수

함수 매개변수에 기본값을 지정할 수 있음

```kotlin
fun greet(name: String = "Guest") {
		println("Hello, $name!") // 코틀린은 문자열 보간이 가능
}

greet() // 출력 : Hello, Guest!
greet("Alice") // 출력 : Hello, Alice!
```

## 명명된 인수

함수를 호출할 때 인수 이름을 지정하여 매개변수에 값을 전달할 수 있음

기본값을 가진 인수는 생략이 가능

```kotlin
fun displayInfo(name: String = "Unknown", age: Int = 0) {
		println("Name: $name, Age: $age")
}

displayInfo(age = 25) // 출력 : Name: Unknown, Age: 25
```

## 확장 함수

기존 클래스에 새로운 함수를 추가

원본 클래스를 수정하지 않고 기능 확장 가능

```kotlin
fun String.lastChar(): Char = this[this.length - 1] // Char 생략 가능

val text = "Hello"
println(text.lastChar()) // 'o' 출력
```

클래스에 같은 이름의 멤버 함수가 있다면 확장 함수를 정의 하더라도 멤버 함수 호출  
**멤버 함수** > **확장 함수**