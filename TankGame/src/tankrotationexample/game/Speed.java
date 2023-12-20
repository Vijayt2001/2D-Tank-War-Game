package tankrotationexample.game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Speed extends PowerUp {

    float x,y;
    BufferedImage img;
    public Speed(float x, float y, BufferedImage img) {
        super(x,y, img);
//        this.hitbox = new Rectangle((int)x,(int)y,this.img.getWidth(),this.img.getHeight());


    }

    @Override
    public void drawImage(Graphics g) {

    }
}
