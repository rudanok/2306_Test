//счетчик
public class Counter implements AutoCloseable {
    private int n; //кол-во животных
    private boolean isOpened; //ресурс открыт или закрыт

    //конструктор
    public Counter() {
        n = 0;
        isOpened = false;
    }

    //проверка
    public boolean check() {
        return isOpened;
    }

    //значение счетчика
    public int get() {
        return n;
    }

    //добавить животное
    public void add() {
        isOpened = true;
        n++;
    }

    //закончили работу с ресурсом
    @Override
    public void close() throws Exception {
        isOpened = false;
    }
}