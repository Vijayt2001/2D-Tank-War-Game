package tankrotationexample.game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Shield extends PowerUp{

    float x,y;
    BufferedImage img;
    public Shield(float x, float y, BufferedImage img) {

        super(x,y, img);

    }

    @Override
    public void drawImage(Graphics g) {

    }
}
