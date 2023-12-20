package tankrotationexample;

import tankrotationexample.game.GameWorld;
import tankrotationexample.game.Sound;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Resources {

    private static Map<String, BufferedImage> sprites = new HashMap<>();
    private static Map<String, Sound> sounds = new HashMap<>();
    private static Map<String, List<BufferedImage>> animations = new HashMap<>();


    private static BufferedImage loadSprite(String path) throws IOException {
        return ImageIO.read(Objects.
                requireNonNull(GameWorld
                        .class
                        .getClassLoader()
                        .getResource(path)));
    }

//    private static BufferedImage read(URL requireNonNull) {
//    }


    private static void initSprites() {

        try {

            Resources.sprites.put("tank1", loadSprite("tank/tank1.png"));
            Resources.sprites.put("tank2", loadSprite("tank/tank2.png"));
            Resources.sprites.put("bullet", loadSprite("bullet/Bullet.jpg"));
            Resources.sprites.put("rocket1", loadSprite("bullet/rocket1.png"));
            Resources.sprites.put("rocket2", loadSprite("bullet/rocket2.png"));
            Resources.sprites.put("floor", loadSprite("floor/bg.png"));
            Resources.sprites.put("unbreak", loadSprite("walls/unbreak.jpg"));
            Resources.sprites.put("break1", loadSprite("walls/break1.jpg"));
            Resources.sprites.put("break2", loadSprite("walls/break2.jpg"));
            Resources.sprites.put("menu", loadSprite("menu/title.png"));
            Resources.sprites.put("speed", loadSprite("powerups/speed.png"));
            Resources.sprites.put("health", loadSprite("powerups/health.png"));
            Resources.sprites.put("shield", loadSprite("powerups/shield.png"));


        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(-1);
            e.printStackTrace();
        }
    }


    private static void initSounds() {
        AudioInputStream audioStream;
        Clip c;
        Sound s;

        try {
            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/Music.mid")
            );
            c = AudioSystem.getClip();
            c.open(audioStream);
            s = new Sound(c);
            Resources.sounds.put("bg", s);

            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/shotexplosion.wav")
            );
            c = AudioSystem.getClip();
            c.open((audioStream));
            s = new Sound(c);
            Resources.sounds.put("shotexplosion", s);

            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/shotfiring.wav")
            );
            c = AudioSystem.getClip();
            c.open((audioStream));
            s = new Sound(c);
            Resources.sounds.put("shotfiring", s);


            audioStream = AudioSystem.getAudioInputStream(
                    Resources.class.getClassLoader().getResource("sounds/bullet.wav")
            );
            c = AudioSystem.getClip();
            c.open((audioStream));
            s = new Sound(c);
            Resources.sounds.put("bullet", s);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    private static void initAnimations() {


    }

    public static void loadResources() {

        initSprites();
          initSounds();
        initAnimations();
    }

    public static BufferedImage getSprite(String key) {

        if (!Resources.sprites.containsKey(key)) {
            System.out.println(key + "resource not found");

            System.exit(-2);
        }
        return Resources.sprites.get(key);


    }

    public static Sound getSound(String key) {
        if (!Resources.sounds.containsKey(key)) {
            System.out.println(key + " Sound not found");

            System.exit(-2);
        }
        return (Sound) Resources.sounds.get(key);

    }
}
