package SESSION08.demo;

public class FactoryMethod {
    public static Shape create(String type){
        switch (type.toLowerCase()){
            case "circle":
                return new Circle();
            case "triangel":
                return new Triangel();
            default:
                throw new RuntimeException("ko hop le");
        }
    }
    public static void main(String[] args) {
        Shape shape = FactoryMethod.create("circle");
        shape.draw();
    }
}


interface Shape {
    void draw();
}
class Circle implements Shape {
    public void draw() {
        System.out.println("Vẽ hình tròn");
    }
}
class Triangel implements Shape {
    public void draw() {
        System.out.println("Vẽ hình tam giác");
    }
}