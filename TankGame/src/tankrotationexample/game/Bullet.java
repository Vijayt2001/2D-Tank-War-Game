package tankrotationexample.game;

import tankrotationexample.GameConstants;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject   {
    float x,y;
    float angle = 0;
    float vx =0;
    float vy = 0;
    float R = 6;
    BufferedImage img;

    public Bullet (float angle, float x, float y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.img = img;
        this.hitbox = new Rectangle((int)x,(int)y, this.img.getWidth(),this.img.getHeight());

    }

    void update() {
        x += Math.round(R * Math.cos(Math.toRadians (angle)));
        y += Math.round(R * Math.sin(Math.toRadians(angle)));
        checkBorder();
    }

    public void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0, this.img.getHeight() /2.0 );
    rotation.scale(5,5);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(this.img, (int)x, (int)y, null);
        g2d.setColor(Color.GREEN);
        //g2d.rotate(Math.toRadians(angle), bounds.x + bounds.width/2, bounds.y + bounds.height/2);
        g2d.drawRect((int)x,(int)y,this.img.getWidth()*5, this.img.getHeight());

    }

    private void checkBorder() {
        if (x < 30) {
            x = 30;
        }
        if (x >= GameConstants.WORLD_WIDTH - 88) {
            x = GameConstants.WORLD_WIDTH - 88;
        }
        if (y < 40) {
            y = 40;
        }
        if (y >= GameConstants.WORLD_HEIGHT- 80) {
            y = GameConstants.WORLD_HEIGHT - 80;
        }
    }


}
