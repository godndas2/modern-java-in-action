package ch03;

public class Apple {

    private int weight = 0;
    private Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    @SuppressWarnings("boxing") // boxing/unboxing 오퍼레이션과 관련된 경고를 억제
    @Override
    public String toString() {
        return String.format("Apple{color=%s, weight=%d}", color, weight);
    }
}
