package ru.gb.jthree.lone;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {

    // метод, который меняет два элемента массива местами
    public static <T> void swap(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T a = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = a;
        }
    }

    // метод, который преобразует массив в ArrayList
    public static <T> ArrayList<T> toArrayList(T[] arr) {
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        Integer[] array = {23, 35, 57, 3, 45, 7, 96, 34, 98, 16};
        //    String[] array = {"fdf", "ee", "jkjk", "yuuu"};
        swap(array);
        System.out.println(Arrays.toString(array));

        /*-------------------------*/

        ArrayList<Integer> list = toArrayList(array);
        System.out.println(list);

        /*-------------------------*/

        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        ArrayList<Orange> oranges = new ArrayList<Orange>();
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());

        Box<Apple> boxOfApples = new Box<Apple>();
        Box<Orange> boxOfOranges = new Box<Orange>();

        boxOfApples.addList(apples);
        boxOfOranges.addList(oranges);

        // Сделать метод getWeight() который высчитывает вес коробки
        System.out.println("Box weight with apples: " + boxOfApples.getWeight());
        System.out.println("Box weight with oranges: " + boxOfOranges.getWeight());

        // метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в
        // качестве параметра
        System.out.println(
            "Box with applies heavier then the box of oranges: " + boxOfApples.compare(boxOfOranges));
        System.out.println(
            "Box with oranges heavier then the box of applies: " + boxOfOranges.compare(boxOfApples));

        // пересыпать фрукты из текущей коробки в другую коробку
        Box<Apple> newBoxOfApples = boxOfApples.shiftToNewBox();
        Box<Orange> newBoxOfOranges = boxOfOranges.shiftToNewBox();
        System.out.println("New box of apples contains: " + newBoxOfApples.getList());
        System.out.println("New box of apples contains: " + newBoxOfOranges.getList());

        // метод добавления фрукта в коробку
        newBoxOfOranges.addOne(new Orange());
        System.out.println("New box of apples contains: " + newBoxOfOranges.getList());
    }
}
