package re.kaguya.egmybatis1.pojo.vo;

public class ProductVo1 {
    private String title;
    private double price;

    @Override
    public String toString() {
        return "ProductVo{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
