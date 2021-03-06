package com.company;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(new Point2D(0, 0), new Point2D(3, 4));
        System.out.println(circle);
        System.out.println(circle.getSlicePoints() + "\n");

        circle.resize(2.0);
        System.out.println(circle);
        System.out.println(circle.getSlicePoints() + "\n");

        circle.move(new MoveDirection(3, 3));
        System.out.println(circle);
        System.out.println(circle.getSlicePoints() + "\n");
    }
}
