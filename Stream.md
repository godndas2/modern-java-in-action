## Stream
> 성능을 높이려면 멀티코어 아키텍쳐를 활용해서 병렬로 컬렉션의 요소를 처리해야한다. 정답은 Stream이다.
- Stream을 사용하면 MultiThread를 코드로 구현하지 않아도 데이터를 병렬처리할 수 있다. (Thread와 Lock을 걱정할 필요가 없다)  
- 가독성  
- 유연성  
- 병렬화(성능)
```
// 예제를 위한 클래스
public class Dish {
    // 불변형 클래스
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    // getter, setter, construct, toString..

    public enum Type { MEAT, FISH, OTHER }
}
```