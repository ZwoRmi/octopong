package Model;

/**
 * Created by Lucas on 21/03/2016.
 */
public class DirectionConverter {
    private Position direction;

    public DirectionConverter(Position direction) {
        this.direction = direction;
    }

    public Direction getReboundCase(){
        float x = direction.getX();
        float y = direction.getY();
        if (x>=0 && y >=0){
            return Direction.RightDown;
        }
        if (x>=0 && y<=0){
            return Direction.RightUp;
        }
        if (x<=0 && y>=0){
            return  Direction.LeftDown;
        }
        if (x<=0 && y<=0){
            return Direction.LeftUp;
        }
        return Direction.Static;
    }
}
