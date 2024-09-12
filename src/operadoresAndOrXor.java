import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class operadoresAndOrXor {
    public static void main(String[] args) throws IOException {
        BufferedImage img1 = ImageIO.read(new File("C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - " +
                "Ccompt\\P. de imagens e V. computacional\\Operacoes Logicas e Aritmeticasc\\src\\grupo1\\island-8006762_640.jpg"));

        BufferedImage img2 = ImageIO.read(new File("C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - " +
                "Ccompt\\P. de imagens e V. computacional\\Operacoes Logicas e Aritmeticasc\\src\\grupo1\\bike-7950617_640.jpg"));

        BufferedImage resultImageAnd = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        BufferedImage resultImageOr = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        BufferedImage resultImageXor = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        for (int y = 0; y < img1.getHeight(); y++){
            for (int x = 0; x < img1.getWidth(); x++){

                int pixel1 = img1.getRGB(x, y);
                int pixel2 = img2.getRGB(x, y);

                int resultPixelAnd = pixel1 & pixel2;
                int resultPixelOr = pixel1 | pixel2;
                int resultPixelXor = pixel1 ^ pixel2;

                resultImageAnd.setRGB(x, y, resultPixelAnd);
                resultImageOr.setRGB(x, y, resultPixelOr);
                resultImageXor.setRGB(x, y, resultPixelXor);
            }
        }
        ImageIO.write(resultImageAnd, "png", new File("src\\operacao-and.png"));
        ImageIO.write(resultImageOr, "png", new File("src\\operacao-or.png"));
        ImageIO.write(resultImageXor, "png", new File("src\\operacao-xor.png"));


        System.out.println("Operações concluídas com sucesso!");
    }
}
