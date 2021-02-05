import encoder.PngToVideo;
import imageeffetcs.OurImage;
import utils.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VideoEditor {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome in this project !");
        
        File output = new File("src/main/resources/vdo.mp4");
        List<BufferedImage> listOfImages = new ArrayList<>();

        
        OurImage ourImage = new OurImage();


        
        for (int i = 0; i < 50; i++) {

            BufferedImage inputImg = new BufferedImage(1000, 1500, BufferedImage.TYPE_INT_ARGB);
            inputImg = ourImage.addRectangleOnImage(inputImg, new Position(0, 0), new Position(1000, 1500), Color.WHITE, 1.0f);
            inputImg = ourImage.addRectangleOnImage(inputImg, new Position(200, i*2), new Position(800, i*2 + 200), Color.GRAY, 1.0f);
            listOfImages.add(inputImg);
            System.out.println(i);
        }
        System.out.println(listOfImages.toString());
        
        PngToVideo vdo = new PngToVideo(output, listOfImages, 30);
        vdo.encode();
    }
}
