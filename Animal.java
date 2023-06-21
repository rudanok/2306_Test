import java.util.ArrayList;

//базовый родительский класс
public class Animal {
    private ArrayList<String> commands; //список команд животного
    private String name; //имя животного
    private int age; //возраст

    //конструктор
    public Animal() {
        setCommands(new ArrayList<>());
        setName("_");
        setAge(-1);
    }

    //инкапсуляция
    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public boolean addCommand(String command) {
        command = command.toLowerCase().trim();
        for (int i = 0; i < commands.size(); i++) {

            //такая команда уже есть
            if (commands.get(i).equals(command)) {
                return false;
            }
        }

        //добавляем новую команду
        commands.add(command);
        return true;
    }

    //показать информацию о животном
    public void show() {
        System.out.println("имя = " + getName());
        System.out.println("возраст = " + getAge());
        System.out.print("список команд = ");
        if (commands.size() > 0) {
            for (int i = 0; i < commands.size(); i++) {
                System.out.print(commands.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("нет");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}