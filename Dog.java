//собака
public class Dog extends Pet {
    public Dog() {
        super();
    }

    @Override
    public void show() {
        System.out.println("<- Собака ->");
        super.show();
    }
}