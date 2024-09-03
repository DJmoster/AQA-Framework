package sviat.dev.task4;

import java.util.ArrayList;
import java.util.List;

public class GenericListTest<T> {

    private final List<T> list;

    public GenericListTest() {
        this.list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
    }

    public void add(List<T> arr) {
        list.addAll(arr);
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
