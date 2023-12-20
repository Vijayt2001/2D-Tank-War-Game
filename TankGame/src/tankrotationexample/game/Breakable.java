package tankrotationexample.game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Breakable extends wall{

    float x,y;
//    BufferedImage img;
    int state =2;

    public Breakable(float x, float y, BufferedImage img) {
    super(x, y, img);
    }

    public void drawImage(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(this.img,(int)x, (int)y, null);
        g2d.setColor(Color.BLUE);
        //g2d.rotate(Math.toRadians(angle), bounds.x + bounds.width/2, bounds.y + bounds.height/2);
        g2d.drawRect((int)x,(int)y,this.img.getWidth(), this.img.getHeight());

    }
}
