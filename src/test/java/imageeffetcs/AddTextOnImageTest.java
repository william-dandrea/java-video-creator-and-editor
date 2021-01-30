package imageeffetcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AddTextOnImageTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void addTextOnImage() throws IOException {

        File input = new File("src/test/java/encoder/filestests/1.jpg");
        File output = new File("src/test/java/encoder/filestests/test.jpg");
        AddTextOnImage imageModif = new AddTextOnImage("test", input, output);
        imageModif.addTextOnImage();
    }
}
