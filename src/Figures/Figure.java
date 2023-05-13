package Figures;
import Utilities.Coordinates;

public abstract class Figure implements ValidateMove {
    public Coordinates coordinates;
    public String owner;
    Figure(Coordinates pos, String owner){
        this.coordinates = pos;
        this.owner = owner;
    }
    public void UpdatePosition(Coordinates pos)
    {
        this.coordinates = pos;
    }
}
