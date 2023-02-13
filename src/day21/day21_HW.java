package day21;

import java.util.ArrayList;
import java.util.List;

class Shape{
    private String type;
    private String color;
    private Double area;

    public Shape(String type, String color, double area){
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

    public String toString(){
        return type +"(" + color + "," + area + "}";
    }

}

class ShapeTest {

    static ArrayList shapes = new ArrayList(10);
    static List findShapesByType(List shapes, String type){
        List r = new ArrayList(10);
        for (int i = 0; i<shapes.size(); i++){
            Shape s = (Shape)shapes.get(i);
            if (s.getType().equals(type)){
                r.add(s);
            }
        }return r;
    }
    static List findShapesByColorNArea(List shapes, String color, double area){
        List r = new ArrayList(10);
        for (int i =0; i<shapes.size(); i++){
            Shape s = (Shape) shapes.get(i);
            if (s.getColor().equals(color) && s.getArea() <= area){
                r.add(s);
            }
        }return r;
    }
}

public class day21_HW {
    public static void main(String[] args){
        Shape[] arr = {
                new Shape("삼각형","빨간색",10.5),
                new Shape("사각형","파란색", 11.2),
                new Shape("원","파란색", 16.5),
                new Shape("원","빨간색", 5.3),
                new Shape("원","노란색", 8.1),
                new Shape("사각형","파란색", 20.7),
                new Shape("삼각형","파란색", 3.4),
                new Shape("사각형","빨간색", 12.6)
        };
        for (int i=0; i<arr.length; i++) Shape.add(arr[i]);
        System.out.println("사각형 : "+Shape.findShapesByType(Shape.shapes, "사각형"));
        System.out.println("빨간 도형(면적<=12.0) : "+ Shape.findShapesByColorNArea(Shape.shapes, "빨간색", 12));
    }
}
