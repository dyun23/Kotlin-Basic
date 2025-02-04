# 2. Null 안전성
[코드](https://github.com/dyun23/Kotlin-Basic/blob/master/2.null/src/Null.kt)

## Nullable

코틀린은 변수나 객체가 null을 가질 수 있는지 여부를 명시

기본적으로 코틀린의 변수는 null 값을 허용하지 않음

null 값을 허용하려면 타입 뒤에 `?`를 붙이면 가능 (타입 지정 필요)

ㄴ 코틀린의 타입 추론이 nullability까지 고려하지 않기 때문

```kotlin
var name: String? = null // null 가능
var value? = "Hello"  // 오류: 타입을 지정하지 않음
```

## Safe Call (?.)

nullable 타입을 다룰 때는 `?.` 연산자를 사용해 객체가 null인지 안전하게 호출

만약 객체가 null이면 null을 반환

```kotlin
var name: String? = null
println(name?.length) // 출력 : null
```

## 엘비스 연산자 (?:)

엘비스 연산자는 null일 때 기본값 지정 가능

```kotlin
val length = name?.length ?: 0 // null이면 0으로 치환
println("Length is $length") // 출력 : Length is 0
```

## Non-Nullable로 강제 변환 (!!)

nullable 타입을 non-nullable 타입으로 변환할 때 사용하는 연산자

만약 null일 경우 `NullPointerException` 발생

```kotlin
val name: String? = null
val length = name!!.length  // NPE 발생
```

## Safe Cast (as?)

안전하게 타입 변환할 수 있는 연산자

타입 변환에 실패하면 null을 반환

ㄴ `ClassCastException` 방지

```kotlin
val obj: Any = 123 
val str1: Int? = obj as? Int
val str2: String? = obj as? String

println(str1) // 출력 : 123
println(str2)  // 출력 : null
```

### +) as 연산자란?

강제로 **타입 캐스팅** 시킬 수 있는 코틀린의 형변환 연산자

객체의 타입이 변환하려는 타입과 호환될 때 사용

```kotlin
val [변수명]: [대상_타입] = [값] as [대상_타입] // 변수 뒤 타입은 생략 가능
```

**as 연산자를 사용하는 경우**

1. 상위 타입(부모) → 하위 타입(자식) 변환 (다운캐스팅)
2. 인터페이스 타입을 구현 클래스로 변환
3. 컬렉션에서 특정 타입으로 변환