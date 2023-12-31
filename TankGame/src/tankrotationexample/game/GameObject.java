package tankrotationexample.game;

import tankrotationexample.Resources;

import java.awt.*;
import java.util.List;

public abstract class GameObject {

    protected Rectangle hitbox;
    public Rectangle getHitHox(){
        return this.hitbox.getBounds();
    }

    public static GameObject gameObjectFactory(String type, float x, float y) {

         return switch (type) {
             case "2" -> new Breakable(x, y, Resources.getSprite( "break1"));
             case "3","9" -> new wall(x, y, Resources.getSprite( "unbreak"));
             case "4" -> new Speed (x, y, Resources.getSprite( "speed"));
             case "5" -> new Health(x, y, Resources.getSprite( "health"));
             case "6" -> new Shield(x, y, Resources.getSprite( "shield"));
             default -> throw new IllegalStateException("Unexpected value: "+ type);

        };
    }

    public abstract void drawImage(Graphics g);
}




