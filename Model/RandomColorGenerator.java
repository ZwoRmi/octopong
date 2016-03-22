package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Lucas on 22/03/2016.
 */
public class RandomColorGenerator {
    private List<Color> colors;

    public RandomColorGenerator() {
        this.colors = new ArrayList<>();
        this.colors.add(Color.rgb(102,0,0));
        this.colors.add(Color.rgb(102,51,0));
    }

    public Color getColor(){
        Random rn = new Random();
        int number = rn.nextInt(this.colors.size());
        return this.colors.get(number);
    }
}
