package com.company;

import java.util.LinkedList;
import java.util.List;

public class Circle implements Movable, Resizable {

    private Point2D center;
    private Point2D point;

    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

    public double getRadius() {
        double xRadius = Math.abs(center.getX() - point.getX());
        double yRadius = Math.abs(center.getY() - point.getY());
        return Math.sqrt(xRadius * xRadius + yRadius * yRadius);
    }

    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    public List<Point2D> getSlicePoints(){
        List<Point2D> list = new LinkedList<>();
        double x = Math.abs(center.getX() - point.getX());
        double y = Math.abs(center.getY() - point.getY());
        Point2D point1 = new Point2D(center.getX() - y,center.getY() + x);
        Point2D point2 = new Point2D(center.getX() - x,center.getY() - y);
        Point2D point3 = new Point2D(center.getX() + y,center.getY() - x);
        list.add(point1);
        list.add(point2);
        list.add(point3);
        return list;
    }

    @Override
    public void move(MoveDirection moveDirection) {
        center.move(moveDirection);
        point.move(moveDirection);
    }

    @Override
    public void resize(double resizeFactor) {
        point.setX(center.getX() + resizeFactor * (point.getX() - center.getX()));
        point.setY(center.getY() + resizeFactor * (point.getY() - center.getY()));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", point=" + point +
                '}';
    }
}
