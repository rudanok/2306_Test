//лошадь
public class Horse extends Pack {
    public Horse() {
        super();
    }

    @Override
    public void show() {
        System.out.println("<- Лошадь ->");
        super.show();
    }
}