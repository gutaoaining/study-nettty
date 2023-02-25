package org.example;

public class Main {

    int position = 0;

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.position);
        System.out.println(main.position());
        System.out.println(main.position);

    }

    int position() {
        return position++;
    }
}