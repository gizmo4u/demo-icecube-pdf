package com.chloesoft;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import com.spire.pdf.PdfDocument;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            // load the sample PDF
            PdfDocument doc = new PdfDocument();
            doc.loadFromFile("/Users/soonystory/Downloads/convert_samplepdf.pdf");

            // save every PDF to .png image
            BufferedImage image;
            for (int i = 0; i < doc.getPages().getCount(); i++) {
                image = doc.saveAsImage(i);
                File file = new File("/Users/soonystory/Downloads/output/" + String.format("ToImage-img-%d.png", i));
                ImageIO.write(image, "PNG", file);
            }

            doc.close();

            System.out.println("image Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
