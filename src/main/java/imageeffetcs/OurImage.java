package imageeffetcs;

import utils.Position;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class OurImage {

    public enum Alignment {RIGHT, LEFT, CENTER}

    public OurImage() {}

    /**
     * This method add an rectangle in a Buffered Image
     * @param inputImg the BufferedImage input
     * @param upperLeft The top left of the rectangle
     * @param lowerRight The back right of the rectangle
     * @param color the fill color of the rectangle
     * @param gamma the transparency of the rectangle (0.0f to fully transparent -> 1.0f to no transparent)
     * @return The buffered image with the rectangle
     */
    public BufferedImage addRectangleOnImage(BufferedImage inputImg, Position upperLeft, Position lowerRight, Color color, float gamma) {

        Graphics2D workspace = (Graphics2D) inputImg.getGraphics();
        workspace.setColor(color);
        workspace.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, gamma));
        workspace.fillRect(upperLeft.getX(), upperLeft.getY(), lowerRight.getX()-upperLeft.getX(), lowerRight.getY()-upperLeft.getY());
        workspace.dispose();

        return inputImg;

    }

    public BufferedImage addTextOnImage(BufferedImage inputImg, Position upperLeft, Position lowerRight,
                                        String text,
                                        Color color,
                                        float gamma,
                                        Font font) {

        Graphics2D workspace = (Graphics2D) inputImg.getGraphics();
        workspace.setColor(color);
        workspace.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, gamma));
        workspace.setFont(font);

        FontMetrics fontMetrics = workspace.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(text,workspace);

        int h = (int) rect.getHeight();int len = (int) rect.getWidth();
        int x1 = upperLeft.getX(); int y1 = upperLeft.getY(); int x2 = lowerRight.getX(); int y2 = lowerRight.getY();
        int posX = ((x2 - x1) / 2) - (len/2); int posY = ((y2 - y1) / 2) + (h/2);


        workspace.drawString(text, posX, posY);
        workspace.dispose();


        return inputImg;
    }

    public BufferedImage addImageOnImage(BufferedImage inputImg, BufferedImage imageToPlace, Position upperLeft, Position lowerRight) {



        Graphics2D workspace = (Graphics2D) inputImg.getGraphics();
        workspace.drawImage(imageToPlace, upperLeft.getX(), upperLeft.getY(), lowerRight.getX() - upperLeft.getX(), lowerRight.getY() - upperLeft.getY(), null);

        workspace.dispose();

        return inputImg;
    }






}
