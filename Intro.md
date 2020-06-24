## Intro
- [Stream API](#stream-api)
- [Method에 code를 전달하는 기법](#behavior-parameterization)
- Interface의 Default Method


### Stream API
병렬 연산을 지원하는 새로운 API,  
Multi Core CPU를 이용하고 비용이 비싼 synchronized를 사용하지 않아도 된다  
<i> synchronized 는 공유된 가변 데이터를 보호한다. </i>  

### Behavior Parameterization
- filter : 특정 항목을 선택해서 반환하는 동작  
(Ex: 모든 녹색 사과를 선택해서 List를 return)   
> Before Java 8
```
public static List<Apple> filterGreenApples(List<Apple> inventory) {
        // 반환되는 result는 List이다. 처음에는 비어있다.
        List<Apple> result = new ArrayList<>();
        
        for (Apple apple : inventory) {
            if ("GREEN".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        
        return result;
    }

```

> Java 8  
```
// 코드를 parameter로 넘겨줄 수 있으므로, filter()를 중복구현하지 않아도 된다.
public static boolean isGreenApple(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
    
public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) { // apple은 p가 제시한 조건과 맞는지?
                result.add(apple);
            }
        }
        
        return result;
    }
```



  
<i>original https://www.manning.com/books/modern-java-in-action</i>
