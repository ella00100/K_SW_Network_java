package day21;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Shape {
    private String type;
    private String color;
    private Double area;

    public Shape(String type, String color, Double area) {
        this.type = type;
        this.color = color;
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public Double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %.1f)", type, color, area);
    }

    static List<Shape> shapes = Arrays.asList(
            new Shape("삼각형", "빨간색", 10.5),
            new Shape("사각형", "파란색", 11.2),
            new Shape("원", "파란색", 16.5),
            new Shape("원", "빨간색", 5.3),
            new Shape("원", "노란색", 8.1),
            new Shape("사각형", "파란색", 20.7),
            new Shape("삼각형", "파란색", 3.4),
            new Shape("사각형", "빨간색", 12.6)
    );
}

public class day21_HW {
    public static void main(String[] args) {
        List<Shape> rectagles = findShapesByType(Shape.shapes, "사각형");
        System.out.print("사각형 : ");
        System.out.println(rectagles);
        List<Shape> redNSmallShapes = findShapesByColorNArea(Shape.shapes, "빨간색", 12.0);
        System.out.print("빨간 도형(면적<=12.0) : ");
        System.out.println(redNSmallShapes);
    }

    static List<Shape> findShapesByType(List<Shape> shapes, String type) {
        List<Shape> result = new ArrayList<>();

        for (Shape s : shapes) {
            if (s.getType().equals(type))
                result.add(s);
        }
        return result;
    }

    static List<Shape> findShapesByColorNArea(List<Shape> shapes, String color, Double area) {
        List<Shape> result = new ArrayList<>();

        for (Shape s : shapes) {
            if (s.getColor().equals(color) && s.getArea() <= area)
                result.add(s);
        }
        return result;
    }
}