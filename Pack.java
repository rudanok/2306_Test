//вьючное животное
public class Pack extends Animal {
    public Pack() {
        super();
    }

    @Override
    public void show() {
        super.show();
        System.out.println("это вьючное животное");
    }
}