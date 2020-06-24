## Behavior parameterization (동작 파라미터화)
> 아직은 어떻게 실행할 것인지 결정하지 않은 코드 블록을 의미한다.
- List의 모든 요소에 대해서 '어떤 동작' 을 수행할 수 있음
- List 관련 작업을 끝낸 다음에 '어떤 다른 동작' 을 수행할 수 있음  
### 예제 1
```
enum Color {RED, GREEN}
```

```
public static List<Apple> filterGreenApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>(); // Apple 누적 리스트
    for(Apple apple : inventory) {
        if(GREEN.equals(apple.getColor()) { // GREEN만 선택
            result.add(apple);
        }
    }

    return result;
}
```

> 만약, GREEN 말고 RED 도 filtering 하고 싶다는 '요구사항'이 생겼다면 filterRedApples() 만드는 방법이 있을 것이다.   
그러나 다양한 색깔이 있었다면 매번 Method를 추가해야 할까?
## 예제 1 - 2

```
public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) { // Color 를 파라미터화 한다.
    List<Apple> result = new ArrayList<>();
    for(Apple apple : inventory) {
        if(apple.getColor().equals(color)) {
            result.add(apple);
        }
    }

    return result;
}

// filterApplesByColor() 호출
List<Apple> greenApples = filterApplesByColor(inventory, GREEN);
List<Apple> redApples = filterApplesByColor(inventory, RED);
```
> 그러나, Color 뿐 만 아니라 Apple의 '무게' 라는 '요구사항'이 추가된다면? 게다가 무게가 지속적으로 변하는 '요구사항'이 발생한다면 어떻게 할까?

```
public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) { // 'weight' parameter 추가
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
        if(apple.getWeight() > weight) {
            result.add(apple);
        }
    }

    return result;
}
```
> 위 방법도 괜찮은 방법이지만, Color를 filtering 하는 코드와 대부분 중복되는 것을 확인할 수 있다.

## 예제 2 - 1
> Predicate를 사용해서 '선택 조건을 결정하는 인터페이스'를 정의해보자 ( strategy design pattern )
```
public interface ApplePredicate { // Apple 선택 전략 캡슐화
    boolean test(Apple apple);
}
```

```
public class AppleHeavyWeightPredicate implements ApplePredicate { // 무거운 Apple만 선택
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
```

```
public class AppleGreenColorPredicate implements ApplePredicate { // GREEN Apple만 선택
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
```

## 예제 2 - 2
