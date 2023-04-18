package collections.lists_and_sets;

public class GoodComparable implements Comparable<GoodComparable> {

    public String name;
    public Integer price;

    public GoodComparable(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(GoodComparable g) {
        //also, you can use compareTo() native method
        //return g.price.compareTo(getPrice());
        return g.price - getPrice();
    }
}
