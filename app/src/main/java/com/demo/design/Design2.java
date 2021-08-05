package com.demo.design;

/**
 * author : Naruto
 * date   : 2020/12/13
 * desc   :
 * version:
 */
class Design2 {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(new Circle());
    }

}

class GraphicEditor {
    public void drawShape(Shape shape) {
        shape.draw();
    }
}

abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("画圆形");
    }
}