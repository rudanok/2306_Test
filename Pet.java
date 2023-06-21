//домашнее животное
public class Pet extends Animal {

    public Pet() {
        super();
    }

    @Override
    public void show() {
        super.show();
        System.out.println("это домашнее животное");
    }
}