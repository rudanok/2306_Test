//хомяк
public class Hamster extends Pet {
    public Hamster() {
        super();
    }

    @Override
    public void show() {
        System.out.println("<- Хомяк ->");
        super.show();
    }
}