package Model;
import java.util.Date;
public class Car {
    private int price;
    private String brandName;
    private Date date;
    public Car(Date date,String brandName,int price){
        this.price=price;
        this.date=date;
        this.brandName=brandName;

    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public int getPrice(){
        return  price;
    }
    public void setPrice(int price)
    {
        this.price=price;
    }
    public String getName()
    {
        return  brandName;
    }
    public void setName(String brandName)
    {
        this.brandName=brandName;
    }
}
