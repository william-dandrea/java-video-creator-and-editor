package encoder;

import org.jcodec.api.awt.AWTSequenceEncoder;
import org.jetbrains.annotations.NotNull;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class PngToVideo {

    private final File output;
    private final List<BufferedImage> imagesFiles;
    private final int fps;

    public PngToVideo(@NotNull File output, @NotNull List<BufferedImage> imagesFiles) {
        this.output = output;
        this.imagesFiles = imagesFiles;
        this.fps = EncoderConfig.DEFAULT_FPS;
    }
    public PngToVideo(@NotNull File output, @NotNull List<BufferedImage> imagesFiles, @NotNull int fps) {
        this.output = output;
        this.imagesFiles = imagesFiles;
        this.fps = fps;
    }

    /**
     * This method will transform a list of images into a video
     * @throws IOException if we have a problem with one file
     */
    public void encode() {

        try {
            if (verifyImagesFilesNotEmpty() && verifySizeImages()) {
                AWTSequenceEncoder encoder = AWTSequenceEncoder.createSequenceEncoder(output, fps);

                for (int i = 0; i < imagesFiles.size(); i++) {
                    //for (int u = 1; u <= fps; u++) {
                    BufferedImage image = imagesFiles.get(i);
                    encoder.encodeImage(image);
                    System.out.println(i);
                    //}
                }

                encoder.finish();
                System.out.println("finish");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method will verify if all the images have the same size.
     * @return true if all the images in imagesFiles have the same size
     * @throws IllegalArgumentException if an image have a different size that the others
     */
    private boolean verifySizeImages() throws IOException {

        BufferedImage lastBufferedImage = imagesFiles.get(0);

        for (BufferedImage localImg : imagesFiles) {

            if (lastBufferedImage.getWidth() != localImg.getWidth() || lastBufferedImage.getHeight() != localImg.getHeight()) {
                throw new IllegalArgumentException("The pictures needs to have the same size. The picture " + localImg + " don't have the same size that the others");
            }
            lastBufferedImage = localImg;
        }
        return true;
    }

    /**
     * @return true if the ImagesFiles array is not empty
     * @throws IllegalArgumentException if the array is empty
     */
    private boolean verifyImagesFilesNotEmpty() {
        if (imagesFiles.size() == 0) {
            throw new IllegalArgumentException("Impossible to create a video with any elements in the input array (list of urls)");
        }
        return true;
    }

}
