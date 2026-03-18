package SESSION08.demo;

public class Facade {
    public static void main(String[] args) {
        FacadeRestaurant facadeRestaurant = new FacadeRestaurant();
        facadeRestaurant.order();
        facadeRestaurant.pay();
    }
}
class FacadeRestaurant{
    private Chef chef = new Chef();
    private Staff staff = new Staff();
    private Manager manager = new Manager();
    void order(){
        staff.order();
        chef.cook();
    }
    void pay(){
        staff.invoice();
        manager.feedback();
        manager.complainChef();
    }


}
class Chef{
    public void cook(){
        System.out.println("Nhan order tu boi ban");
        System.out.println("Nau mon an");
        System.out.println("-----------------------");

    }

}
class Staff{
    public void order(){
        System.out.println("Order mon cho khach");
    }
    public void invoice(){
        System.out.println("Gui hoa don");
    }
}
class Manager{
    public void feedback(){
        System.out.println("Hoi y kien khach");
    }
    public void complainChef(){
        System.out.println(" dau bep");
    }
}
