# 1. 기본 문법과 변수
[코드](https://github.com/dyun23/Kotlin-Basic/blob/master/1.variable/src/Variable.kt)

## 불변 변수, 가변 변수

`val` : 불변 변수, 값 변경 불가

`var` : 가변 변수, 값 변경 가능

변수를 선언할 때 자바와 다르게 변수의 변경 가능 여부를 먼저 명시

## 타입 명시

코틀린은 컴파일러가 타입을 추론해 자동으로 지정

만약 명시하고 싶다면 `[변수명]: [타입]` 형태로 지정

```kotlin
  val name2: String = "Alice"
  var age2: Int = 25
```

> 자바와 다르게 `int`, `double` 등 모든 데이터를 원시타입이 아닌 `Int`, `Double`, `String`처럼 객체로 다룸