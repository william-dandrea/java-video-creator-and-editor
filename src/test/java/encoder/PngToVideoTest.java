package encoder;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PngToVideoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void encodeTestWhenAllIsGood() {

        int fps = 1;
        String[] inputFiles = {"src/test/java/encoder/filestests/1.jpg", "src/test/java/encoder/filestests/2.jpg"};
        File outputFile = new File("src/test/java/encoder/filestests/test.mp4");

        //PngToVideo pngToVideo = new PngToVideo(outputFile, inputFiles, fps);

        //pngToVideo.encode();

        //assertTrue(outputFile.delete());
    }

}
