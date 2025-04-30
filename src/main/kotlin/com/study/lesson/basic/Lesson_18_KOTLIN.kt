package com.study.lesson.basic

import com.study.lesson.basic.lesson18.Fruit18

/* LESSON 18. 코틀린에서 컬렉션을 함수형으로 다루는 방법 */

fun main() {
    // 1. 필터와 맵
    val fruits = listOf(
        Fruit18(1L, "사과", 500, 1_200),
        Fruit18(2L, "사과", 500, 1_000),
        Fruit18(3L, "사과", 600, 1_500),
        Fruit18(4L, "사과", 500, 1_200),
        Fruit18(5L, "바나나", 800, 3_000),
        Fruit18(6L, "바나나", 900, 3_200),
        Fruit18(7L, "바나나", 800, 2_500),
        Fruit18(8L, "수박", 2_000, 10_000)
    )

    filterFruits(fruits) {fruit -> fruit.name == "사과"}

    // ☑️ filter
    val apples = fruits.filter { fruit -> fruit.name == "사과" }
    println(apples)
    println("-------------------------")
    // ☑️ filterIndexed : filter 기능 + index
    val apples2 = fruits.filterIndexed {idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }
    println(apples2)
    println("-------------------------")
    // ☑️ map : 원하는 결과 추출
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }
    println(applePrices)
    println("-------------------------")
    // ☑️ mapIndexed : 원하는 결과 추출 + index
    val applePrices2 = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.currentPrice
        }
    println(applePrices2)
    println("-------------------------")
    // ☑️ mapNotNull : null이 아닌 값만 추출
    val values = fruits.filter { fruit -> fruit.name == "사과" }
        .mapNotNull { fruit -> fruit.nullOrValue() }
    println(values)
    println("-------------------------")

    // 2. 다양한 컬렉션 처리 기능
    // ☑️ all : 조건을 모두 만족하면 true, 그렇지 않으면 false
    val applesAll = fruits.all { fruit -> fruit.name == "바나나" }
    println("fruit은 모두 바나나인가? : $applesAll")
    println("-------------------------")
    // ☑️ none : 조건을 모두 불만족하면 true, 그렇지 않으면 false
    val applesNone = fruits.none { fruit -> fruit.name == "참외" }
    println("fruit은 모두 참외가 아닌가? : $applesNone")
    println("-------------------------")
    // ☑️ any : 조건을 하나라도 만족하면 true, 그렇지 않으면 false
    val applesAny = fruits.any { fruit -> fruit.name == "수박" }
    println("fruit 중 수박이 하나라도 존재하는가? : $applesAny")
    println("-------------------------")
    // ☑️ count : 개수, 크기
    val fruitCount = fruits.count();
    println("Fruit 총 개수 : $fruitCount")
    println("-------------------------")

    // ☑️ sorted : 정렬 (오름차순) / sortedByDescending : 정렬 (내림차순)
    val fruitSortedAsc = fruits.sortedBy { fruit -> fruit.currentPrice } // 현재 가격 오름차순
    val fruitSortedDesc = fruits.sortedByDescending { fruit -> fruit.currentPrice } // 현재 가격 내림차순
    println("Fruit 현재 가격 오름차순 : $fruitSortedAsc")
    println("Fruit 현재 가격 내림차순 : $fruitSortedDesc")
    println("-------------------------")

    // ☑️ distinctBy : 변형된 값을 기준으로 중복 제거
    val fruitDistinct = fruits.distinctBy { fruit -> fruit.name } // 이름 기준으로 중복 제거
        .map { fruit -> fruit.name } // 사과, 바나나, 수박
    val fruitDistinct2 = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.currentPrice } // 1200, 3000, 10000 (제일 앞에 있는게 살아남음)
    println("Fruit 이름 기준 중복 제거 후 이름 출력 : $fruitDistinct")
    println("Fruit 이름 기준 중복 제거 후 현재 가격 출력 : $fruitDistinct2")
    println("-------------------------")

    // ☑️ first : 첫 번째 값을 가져온다. (무조건 null이 아니어야 함)
    // ☑️ firstOrNull : 첫 번째 값 또는 null을 가져온다.
    // ☑️ last : 마지막 값을 가져온다. (무조건 null이 아니어야 함)
    // ☑️ lastOrNull : 마지막 값 또는 null을 가져온다.
    val fruitFirst = fruits.first()
    val fruitFirstNull = fruits.firstOrNull()
    val fruitLast = fruits.last()
    val fruitLastNull = fruits.lastOrNull()
    println("fruitFirst : $fruitFirst")
    println("fruitFirstNull : $fruitFirstNull")
    println("fruitLast : $fruitLast")
    println("fruitLastNull : $fruitLastNull")
    println("-------------------------")

    // 3. List를 Map으로
    // ☑️ groupBy : name 기준으로 Fruit List 추출
    val fruitMap: Map<String, List<Fruit18>> = fruits.groupBy { fruit -> fruit.name }
    println("fruitMap : $fruitMap")
    println("-------------------------")
    // ☑️ associatedBy : id 기준으로 Fruit 객체 추출
    //    => 중복되지 않는 key를 가지고 Map을 만들 때 사용
    val fruitAssociated: Map<Long, Fruit18> = fruits.associateBy { fruit -> fruit.id }
    println("fruitAssociated : $fruitAssociated")
    println("-------------------------")
    // ☑️ groupBy 활용 : name 기준으로 Fruit 출고가 List 추출
    val fruitFactoryPriceMap: Map<String, List<Long>> = fruits
        .groupBy({ fruit -> fruit.name }, { fruit -> fruit.factoryPrice })
    println("fruitFactoryPriceMap : $fruitFactoryPriceMap")
    println("-------------------------")
    // ☑️ associatedBy 활용 : id 기준으로 Fruit 출고가 추출
    val fruitFactoryPriceMap2: Map<Long, Long> = fruits
        .associateBy({ fruit -> fruit.id }, { fruit -> fruit.factoryPrice })
    println("fruitFactoryPriceMap2 : $fruitFactoryPriceMap2")
    println("-------------------------")
    // ☑️ gruopBy, filter 활용 : name 기준으로 Fruit List 추출 후 "사과"인 Fruit만 필터링
    val fruitComplex: Map<String, List<Fruit18>> = fruits
        .groupBy { fruit -> fruit.name }
        .filter { (key, value) -> key == "수박" }
    println("fruitComplex : $fruitComplex")
    println("-------------------------")

    // 4. 중첩된 컬렉션 처리
    val fruitsInList: List<List<Fruit18>> = listOf(
        listOf(
            Fruit18(1L, "사과", 1_000, 1_500),
            Fruit18(2L, "사과", 1_200, 1_500),
            Fruit18(3L, "사과", 1_200, 1_500),
            Fruit18(4L, "사과", 1_500, 1_500),
        ),
        listOf(
            Fruit18(5L, "바나나", 3_000, 3_200),
            Fruit18(6L, "바나나", 3_200, 3_500),
            Fruit18(7L, "바나나", 2_500, 3_200),
        ),
        listOf(
            Fruit18(8L, "수박", 8_000, 10_000),
        ),
    )

    // ☑️ 출고가와 현재가가 동일한 과일 고르기
    //    => flatMap 사용 : 중첩 리스트가 단일 리스트로 바뀜
    val samePriceFruits = fruitsInList.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }
    val samePriceFruitsWithFunc = fruitsInList
        .flatMap { list -> list.samePriceFilter }
    println("samePriceFruits : $samePriceFruits")
    println("samePriceFruitsWithFunc : $samePriceFruitsWithFunc")
    println("-------------------------")

    // ☑️ 중첩 리스트 => 단일 리스트
    //    - List<List<Fruit18>> => List<Fruit>
    val flattenFruits = fruitsInList.flatten()
    println("flattenFruits : $flattenFruits")
    println("-------------------------")
}

private fun filterFruits(
    fruits: List<Fruit18>, filter: (Fruit18) -> Boolean
): List<Fruit18> {
    return fruits.filter(filter)
}

// ☑️ 출고가와 현재가가 동일한 과일 고르기 리팩토링
//    => (2) 확장함수 생성
val List<Fruit18>.samePriceFilter: List<Fruit18>
    get() = this.filter(Fruit18::isSamePrice)