package Utilities;

import Enums.InvalidPlaceEnum;
import Exceptions.InvalidPlaceException;

public class Coordinates {
    public int horizontal;
    public int vertical;
   public Coordinates(int y, int x)
    {
        this.horizontal = x;
        this.vertical = y;
    }

    public static Coordinates ConvertHumanToComputer(String place) throws InvalidPlaceException
    {
        place = place.toUpperCase();
        int col = place.charAt(0);
        int row =  place.charAt(1);
        if(col < 65 || col > 72 || row < 49 || row > 58 ) throw new InvalidPlaceException(InvalidPlaceEnum.NotAPlace);
        Coordinates location = new Coordinates(row-49, col-65);
        return location;
    }

    public static boolean CompareCoordinates(Coordinates pos1, Coordinates pos2)
    {
        return pos1.vertical == pos2.vertical && pos1.horizontal == pos2.horizontal;
    }

}
