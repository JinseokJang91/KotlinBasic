package com.study.lesson.basic;


import com.study.lesson.basic.lesson17.Fruit;
import com.study.lesson.basic.lesson17.FruitFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lesson_17_JAVA {
    public static void main(String[] args) {
        // 1. Java에서 람다를 다루기 위한 노력
        List<Fruit> fruits = Arrays.asList(
                new Fruit("사과", 1_000),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_500),
                new Fruit("바나나", 3_000),
                new Fruit("바나나", 3_200),
                new Fruit("바나나", 2_500),
                new Fruit("수박", 10_000)
        );
        // (1) 사과만 추출
        List<Fruit> apples = findApples(fruits);
        // (2) 바나나만 추출
        List<Fruit> bananas = findBananas(fruits);
        // (1), (2) 함수를 리팩토링 (중복 로직 존재)
        List<Fruit> apples2 = findFruitsWithName(fruits, "사과");
        List<Fruit> bananas2 = findFruitsWithName(fruits, "바나나");
        // ☑️ 리팩토링 함수 사용 불가 CASE
        // => 사과랑 바나나 같이 추출
        // => 사과인데 가격이 1200원을 넘지 않는 사과만 추출
        // => 10000원 이하의 수박과 1000원 이상의 바나나 추출

        // ☑️ 인터페이스와 익명클래스 활용
        List<Fruit> filterFruits = filterFruits(fruits, new FruitFilter() {
            @Override
            public boolean isSelected(Fruit fruit) {
                // 사과와 바나나이고, 5000원이 넘는 과일 추출
                return Arrays.asList("사과", "바나나")
                        .contains(fruit.getName())
                        && fruit.getPrice() > 5_000;
            }
        });
        // => 익명클래스를 사용하는 것은 상대적으로 복잡하다.
        //    e.g. 과일 간의 무게 비교, N개의 과일 한 번에 비교 등등
        //    ☑️ JDK 8부터 람다(이름이 없는 함수) 등장
        //    ☑️ JDK 8에 미리 만들어진 함수형 인터페이스 활용 (Predicate, Consumer 등)
        List<Fruit> filterFruitsAfterJDK8 = filterFruitsAfterJDK8(
                fruits, fruit -> "사과".equals(fruit.getName())
        );
        // ☑️ stream을 사용해 간결하게 표현 가능 (병렬처리에도 강점 존재)
        List<Fruit> filterFruitsUsingStream = filterFruitsUsingStream(
                fruits, fruit -> "사과".equals(fruit.getName())
        );
        // ☑️ 메소드 레퍼런스 활용
        List<Fruit> filterFruitsMethodReference = filterFruitsAfterJDK8(
                fruits, Fruit::isApple
        );

        // 2. 코틀린에서의 람다

        // 3. Closure
        String targetFruitName = "바나나";
        targetFruitName = "수박";
        // ☑️ Java에서는 람다를 쓸 때 사용할 수 있는 변수에 제약이 있다.
        //    => 실질적인 final 변수만 사용
        //filterFruits(fruits, (fruit) -> targetFruitName.equals(fruit.getName())); // ⚠️ ERROR

        // 4. 다시 try with resources
    }

    private static List<Fruit> findApples(List<Fruit> fruits) {
        List<Fruit> apples = new ArrayList<>();
        for(Fruit fruit : fruits) {
            if("사과".equals(fruit.getName())) {
                apples.add(fruit);
            }
        }

        return apples;
    }

    private static List<Fruit> findBananas(List<Fruit> fruits) {
        List<Fruit> bananas = new ArrayList<>();
        for(Fruit fruit : fruits) {
            if("바나나".equals(fruit.getName())) {
                bananas.add(fruit);
            }
        }

        return bananas;
    }

    private static List<Fruit> findFruitsWithName(List<Fruit> fruits, String name) {
        List<Fruit> results = new ArrayList<>();
        for(Fruit fruit : fruits) {
            if(name.equals(fruit.getName())) {
                results.add(fruit);
            }
        }

        return results;
    }

    private static List<Fruit> filterFruits(List<Fruit> fruits, FruitFilter fruitFilter) {
        List<Fruit> results = new ArrayList<>();
        for(Fruit fruit : fruits) {
            if(fruitFilter.isSelected(fruit)) {
                results.add(fruit);
            }
        }

        return results;
    }

    private static List<Fruit> filterFruitsAfterJDK8(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
        List<Fruit> results = new ArrayList<>();
        for(Fruit fruit : fruits) {
            if(fruitFilter.test(fruit)) {
                results.add(fruit);
            }
        }

        return results;
    }

    private static List<Fruit> filterFruitsUsingStream(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
        return fruits.stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }
}
