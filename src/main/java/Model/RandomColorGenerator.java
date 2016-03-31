package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomColorGenerator {
    private final List<Color> colors;

    public RandomColorGenerator() {
        this.colors = new ArrayList<>();
        this.colors.add(Color.rgb(153, 0, 0));
        this.colors.add(Color.rgb(153, 76, 0));
        this.colors.add(Color.rgb(153, 153, 0));
        this.colors.add(Color.rgb(0, 76, 153));
        this.colors.add(Color.rgb(76, 0, 153));
        this.colors.add(Color.rgb(153, 0, 153));
        this.colors.add(Color.rgb(153, 0, 76));
    }

    public Color getColor() {
        Random rn = new Random();
        int number = rn.nextInt(this.colors.size());
        return this.colors.get(number);
    }
}
