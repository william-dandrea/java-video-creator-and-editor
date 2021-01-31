package imageeffetcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OurImageTest {

    OurImage ourImage;
    @BeforeEach
    void setUp() {
        ourImage = new OurImage();
    }

    @Test
    void addRectangleOnImageTest() throws IOException {

        BufferedImage inputImg = new BufferedImage(1000, 1500, BufferedImage.TYPE_INT_ARGB);

        inputImg = ourImage.addRectangleOnImage(inputImg, new Position(0, 0), new Position(1000, 1500), Color.WHITE, 1.0f);
        inputImg = ourImage.addRectangleOnImage(inputImg, new Position(200, 1000), new Position(800, 1200), Color.GRAY, 1.0f);

        ImageIO.write(inputImg, "png", new File("src/test/java/encoder/filestests/test2.png"));
    }
}
