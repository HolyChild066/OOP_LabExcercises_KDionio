public class Car{
    private String Brand;
    private String Model;
    private String HorsePower;
    private String Color;
    private String Seaters;
    private String Transmission;

    public Car(){
        this.Brand = " No Brand ";
        this.Model = " No Model ";
        this.HorsePower = " 0MPH ";
        this.Color = " No Color ";
        this.Seaters = " No Seats ";
        this.Transmission = " No Transmission ";
    }
    public Car(String Brand, String Model, String HorsePower, String Color, String Seaters, String Transmission){
        this.Brand = Brand;
        this.Model = Model;
        this.HorsePower = HorsePower;
        this.Color = Color;
        this.Seaters = Seaters;
        this.Transmission = Transmission;
    }
    public void displayInfo(){
        String info = " ";
        info += " Brand: " + this.Brand + "\n";
        info += " Model: " + this.Model + "\n";
        info += " HorsePower: " + this.HorsePower + "\n";
        info += " Color: " + this.Color + "\n";
        info += " Seats: " + this.Seaters + "\n";
        info += " Transmission: " + this.Transmission + "\n";
        System.out.println(info);
    }
}