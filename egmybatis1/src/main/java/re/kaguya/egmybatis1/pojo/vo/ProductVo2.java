package re.kaguya.egmybatis1.pojo.vo;

public class ProductVo2 {
    private String title;
    private double stock;


    @Override
    public String toString() {
        return "ProductVo2{" +
                "title='" + title + '\'' +
                ", stock=" + stock +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
