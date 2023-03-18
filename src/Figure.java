public class Figure {
    final private int INDEX_OF_FINAL_FIELD = 7;
    public int positionX;
    public int positionY;
    public String owner;
    public FigureType typeOfFigure;
    Figure(Coordinates pos, FigureType type, String owner){
        this.positionX = pos.horizontal;
        this.positionY = pos.vertical;
        this.typeOfFigure = type;
        this.owner = owner;
    }




}
