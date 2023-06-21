import java.util.ArrayList;
import java.util.Scanner;

//реестр животных
public class Main {

    //навигация по меню
    public static void main(String[] args) {

        //создаем новый счетчик
        Counter c = new Counter();
        int key = 0; //для выбора пункта меню
        Scanner sc = new Scanner(System.in); //для ввода данных
        Animal animal = null; //текущее животное
        ArrayList<Animal> animals = new ArrayList<>(); //список животных
        do {
            try {
                System.out.println("1 - завести животное");
                System.out.println("2 - определить животное в правильный класс");
                System.out.println("3 - увидеть список команд, которое выполняет животное");
                System.out.println("4 - обучить животное новым командам");
                System.out.println("5 - показать всех животных");
                System.out.println("6 - выход");
                System.out.print(">> ");
                key = Integer.parseInt(sc.nextLine());
                if (key < 1 || key > 6) {
                    throw new Exception();
                }
                switch (key) {
                    case 1: {

                        //если уже завели животное, но не присвоили класс
                        if(animal != null) {
                            System.out.println("у вас уже есть животное\n");
                            continue;
                        }

                        //создаем новое животное
                        animal = new Animal();
                        System.out.print("укажите имя животного = ");
                        animal.setName(sc.nextLine());

                        //корректный ввод возраста
                        while (true) {
                            try {
                                System.out.print("возраст = ");
                                int age = Integer.parseInt(sc.nextLine());
                                if (age >= 0) {
                                    animal.setAge(age);
                                    break;
                                } else {
                                    System.out.println("возраст не может быть отрицательным");
                                }
                            } catch (Exception ex) {
                                System.out.println("ошибка ввода");
                            }
                            System.out.println();
                        }

                        //try-with-resources
                        try (c) {

                            //ресурс уже ранее был открыт
                            if (c.check()) {
                                throw new Exception("работать со счетчиком можно только в блоке try");
                            } else {
                                //работаем если все поля заполнены
                                if (animal.getName().length() > 0 && animal.getAge() >= 0) {
                                    c.add(); //увеличиваем на 1
                                } else {
                                    animal = null; //убираем животное

                                }
                            }
                        } catch (Exception e) {
                            throw new Exception(e.getMessage());
                        }

                        //ресурс остался открыт
                        if (c.check()) {
                            throw new Exception("работать со счетчиком можно только в блоке try");
                        }
                        if (animal != null) {
                            System.out.println("вы завели " + c.get() + " животное");
                        } else {
                            System.out.println("не удалось завести животное");
                        }
                        break;
                    }
                    case 2: {
                        int key2 = 0;
                        if (animal != null) {
                            System.out.println("выберите класс животного:");
                            System.out.println("1 - собака");
                            System.out.println("2 - кошка");
                            System.out.println("3 - хомяк");
                            System.out.println("4 - лошадь");
                            System.out.println("5 - верблюд");
                            System.out.println("6 - осел");
                            System.out.println(">> ");
                            key2 = Integer.parseInt(sc.nextLine());
                            if (key2 < 1 || key2 > 6) {
                                throw new Exception();
                            }
                            Animal other = null;
                            switch (key2) {
                                case 1: {
                                    other = new Dog();
                                    break;
                                }
                                case 2: {
                                    other = new Cat();
                                    break;
                                }
                                case 3: {
                                    other = new Hamster();
                                    break;
                                }
                                case 4: {
                                    other = new Horse();
                                    break;
                                }
                                case 5: {
                                    other = new Camel();
                                    break;
                                }
                                case 6: {
                                    other = new Donkey();
                                    break;
                                }
                            }
                            other.setAge(animal.getAge());
                            other.setName(animal.getName());
                            other.setCommands(new ArrayList<>(animal.getCommands()));
                            animals.add(other);
                            animal = null;
                            System.out.println("класс животного успешно определен");
                        } else {
                            System.out.println("вы ещё не завели животное");
                        }
                        break;
                    }
                    case 3: {
                        if (animal != null) {
                            animal.show();
                        } else {
                            System.out.println("вы ещё не завели животное");
                        }
                        break;
                    }
                    case 4: {
                        if (animal != null) {
                            System.out.print("укажите новую команду = ");
                            String command = sc.nextLine();
                            if (animal.addCommand(command)) {
                                System.out.println("новая команда успешно добавлена");
                            } else {
                                System.out.println("такая команда уже есть в списке");
                            }
                        } else {
                            System.out.println("вы ещё не завели животное");
                        }
                        break;
                    }
                    case 5: {
                        if (animals.size() > 0) {
                            for (int i = 0; i < animals.size(); i++) {
                                animals.get(i).show();
                                System.out.println();
                            }
                        } else {
                            System.out.println("список животных пуст");
                        }
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("ошибка ввода");
            }
            System.out.println();
        } while (key != 6);
    }
}