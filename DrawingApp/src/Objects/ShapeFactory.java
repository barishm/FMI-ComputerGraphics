package Objects;

public class ShapeFactory {

    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
            return new Triangle();
        } else if(shapeType.equalsIgnoreCase("RIGHT TRIANGLE")){
            return new RightTriangle();
        } else if (shapeType.equalsIgnoreCase("PENTAGON")) {
            return new Pentagon();
        } else if (shapeType.equalsIgnoreCase("HEXAGON")) {
            return new Hexagon();
        } else if (shapeType.equalsIgnoreCase("ZAD")) {
            return new Zad0();
        }

        return null;
    }
}
