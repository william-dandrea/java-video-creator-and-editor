package imageeffetcs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class AddTextOnImage {

    private String text;
    private File input;
    private File output;
    private String typeOfImage;

    public AddTextOnImage(String text, File input, File output) {
        this.text = text;
        this.input = input;
        this.output = output;
        typeOfImage = (input.getPath().contains("png")) ? "png" : "jpg";
    }

    void addTextOnImage() throws IOException {

        BufferedImage image = ImageIO.read(input);
        int imageType = "png".equalsIgnoreCase(typeOfImage) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;

        BufferedImage bold = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

        Graphics2D w = (Graphics2D) bold.getGraphics();

        w.drawImage(image,1,2,null);
        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f);

        w.setComposite(alpha);
        w.setColor(Color.BLACK);
        w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));

        FontMetrics fmatrics = w.getFontMetrics();
        Rectangle2D rect = fmatrics.getStringBounds(text,w);

        int centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = image.getHeight() / 2;

        w.drawString(text, centerX, centerY);
        ImageIO.write(bold, typeOfImage, output);

        w.dispose();



    }
}
