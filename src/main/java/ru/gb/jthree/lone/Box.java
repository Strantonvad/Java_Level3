package ru.gb.jthree.lone;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    Float boxWeight = 0f;
    ArrayList<T> list = new ArrayList<T>();

    public void addList(ArrayList<T> arrayList) {
        list.addAll(arrayList);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public Float getWeight() {
        for (T fruit : list) {
            boxWeight += fruit.weight;
        }

        return boxWeight;
    }

    public boolean compare(Box obj) {
        if (obj == null) {
            return false;
        }

        return this.getWeight() > obj.getWeight();
    }

    public Box<T> shiftToNewBox() {
        Box<T> box = new Box<T>();
        box.addList(this.getList());
        this.getList().clear();
        return box;
    }

    public void addOne(T newObj) {
        this.getList().add(newObj);
    }
}
