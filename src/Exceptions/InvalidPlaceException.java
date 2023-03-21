package Exceptions;

import Enums.InvalidPlaceEnum;

public class InvalidPlaceException extends Exception  {
    public String message;
   public InvalidPlaceException(InvalidPlaceEnum e)
    {
        switch(e){
            case EmptyPlace -> this.message = "You have selected an empty place. Try again.\n";
            case InCheck -> this.message = "You are in check. You are only allowed to make a move which can save the king.\n";
            case EnemyFigureInPlace -> this.message = "You have selected an enemy figure.\n";
            case NotAPlace -> this.message = "You have selected an invalid place.\n";
            case OutsideRangeOfFigure ->this.message = "Selected figure cannot be moved to the desired place.\n";
            case AllyFigureInPlace -> this.message = "There's an ally figure in your place of choice\n";
        }
    }
}
