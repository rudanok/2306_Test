//кошка
public class Cat extends Pet {
    public Cat() {
        super();
    }

    @Override
    public void show() {
        System.out.println("<- Кошка ->");
        super.show();
    }
}