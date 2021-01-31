package imageeffetcs;

import utils.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class OurImage {




    public BufferedImage addRectangleOnImage(BufferedImage inputImg, Position upperLeft, Position lowerRight, Color color, float gamma) {

        Graphics2D workspace = (Graphics2D) inputImg.getGraphics();

        workspace.setColor(color);

        workspace.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, gamma));

        workspace.fillRect(upperLeft.getX(), upperLeft.getY(), lowerRight.getX()-upperLeft.getX(), lowerRight.getY()-upperLeft.getY());

        workspace.dispose();

        return inputImg;

    }






}
