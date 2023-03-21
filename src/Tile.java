package Chess;
import Figures.Figure;
import Utilities.Coordinates;

public class Tile {
    public final Coordinates pos;
    public Figure figureInPlace;
    public boolean hasFigure;
    public Tile(Coordinates pos, Figure figure)
    {
        this.pos = pos;
        this.figureInPlace = figure;
        this.hasFigure = true;
    }
    public Tile(Coordinates pos)
    {
        this.hasFigure = false;
        this.pos = pos;
    }

    public void  UpdateTile()
    {
        this.hasFigure = false;
        this.figureInPlace = null;
    }
    public void  UpdateTile(Figure figure)
    {
        this.hasFigure = true;
        this.figureInPlace = figure;
    }

}
