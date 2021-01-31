package imageeffetcs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class AddTextOnImage {

    private File input;
    private File output;
    private String typeOfImage;

    public AddTextOnImage(File input, File output) {
        this.input = input;
        this.output = output;
        typeOfImage = (input.getPath().contains("png")) ? "png" : "jpg";
    }

    void addTextOnImage(String text) throws IOException {

        BufferedImage image = ImageIO.read(input);

        // Create a new image
        int imageType = "png".equalsIgnoreCase(typeOfImage) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
        BufferedImage bold = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

        // Creation du "plan de travail"
        Graphics2D w = (Graphics2D) bold.getGraphics();

        // Ajout de l'image initiale sur le plan de travail,
        w.drawImage(image,200,100,null);

        //Configuration du alpha (transparence) du nouvel élément
        // - alpha = [0,1] 0 = transparent ; 1 = aucune transparence
        // - AlphaComposite.SRC_OVER : afficher l'élément au dessus du reste
        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f);

        // Ajout de l'élément alpha sur le plan de travail
        w.setComposite(alpha);

        // Configuration de la couleur sur le plan de travail
        w.setColor(Color.WHITE);

        // Configuration de la police d'écriture sur le plan de travail
        w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));

        // L'élément fmatrics corespond a tout les éléments concernant le texte mis en place sur le plan de travail
        FontMetrics fmatrics = w.getFontMetrics();

        // On crée un rectangle qui contient le texte
        Rectangle2D rect = fmatrics.getStringBounds(text,w);

        // On récupére les taille pour centrer l'élément
        int centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = image.getHeight() / 2;

        // On affiche l'élément sur le plan de travail
        w.drawString(text, centerX, centerY);

        // On crée une image de sortie grace le plan de travail
        ImageIO.write(bold, typeOfImage, output);

        w.dispose();

    }
}
