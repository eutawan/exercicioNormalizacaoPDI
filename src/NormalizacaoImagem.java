import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NormalizacaoImagem {
    public static BufferedImage normalizeImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage normalizeImage = new BufferedImage(width, height, image.getType());

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                int avg = (r + g + b) / 3;
                normalizeImage.setRGB(x, y, (avg << 16) | (avg << 8) | avg);
            }
        }
        return normalizeImage;
    }
    public static BufferedImage addImages(BufferedImage img1, BufferedImage img2){
        int width = img1.getWidth();
        int height = img1.getHeight();
        BufferedImage resultadoImage = new BufferedImage(width, height, img1.getType());

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                int rgb1 = img1.getRGB(x, y);
                int rgb2 = img2.getRGB(x,y);

                int r1 = (rgb1 >> 16) & 0xFF;
                int g1 = (rgb1 >> 8) & 0xFF;
                int b1 = rgb1 & 0xFF;

                int r2 = (rgb2 >> 16) & 0xFF;
                int g2 = (rgb2 >> 8) & 0xFF;
                int b2 = rgb2 & 0xFF;

                int rFinal = Math.min(255, r1 + r2);
                int gFinal = Math.min(255, g1 + g2);
                int bFinal = Math.min(255, b1 + b2);

                int finalRGB = (rFinal << 16) | (gFinal << 8) | bFinal;
                resultadoImage.setRGB(x, y, finalRGB);
            }
        }
        return resultadoImage;
    }

    public static void main (String[]args) throws IOException {
        String[][] paresDeImagens = {
                // GRUPO 1
                {"C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\" +
                        "Operacoes Logicas e Aritmeticasc\\src\\grupo1\\bike-7950617_640.jpg", "C:\\Users\\princ\\" +
                        "OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\Operacoes Logicas" +
                        " e Aritmeticasc\\src\\grupo1\\island-8006762_640.jpg"},
                // GRUPO 2
                {"C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\" +
                        "peracoes Logicas e Aritmeticasc\\src\\grupo2\\coast-8357312_640.jpg", "C:\\Users\\princ\\" +
                        "OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\Operacoes Logicas " +
                        "e Aritmeticasc\\src\\grupo2\\dragon-8412130_640.jpg"},
                // GRUPO 3
                {"C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\" +
                        "Operacoes Logicas e Aritmeticasc\\src\\grupo3\\bridge-7859045_640.jpg", "C:\\Users\\princ\\" +
                        "OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\Operacoes Logicas" +
                        " e Aritmeticasc\\src\\grupo3\\elephant-8994442_640.jpg"},
                // GRUPO 4
                {"C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\" +
                        "Operacoes Logicas e Aritmeticasc\\src\\grupo4\\lighthouse-7934208_640.jpg", "C:\\Users\\princ\\" +
                        "OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\Operacoes Logicas " +
                        "e Aritmeticasc\\src\\grupo4\\lion-7874143_640.jpg"},
                // GRUPO 5
                {"C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\" +
                        "Operacoes Logicas e Aritmeticasc\\src\\grupo5\\man-8532570_640.jpg", "C:\\Users\\princ\\" +
                        "OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\Operacoes Logicas " +
                        "e Aritmeticasc\\src\\grupo5\\otter-7609666_640.jpg"}
        };
        for (int i = 0; i < paresDeImagens.length; i++) {
            // grupo 1
            BufferedImage image1 = ImageIO.read(new File(paresDeImagens[i][0]));
            BufferedImage image2 = ImageIO.read(new File(paresDeImagens[i][1]));

            BufferedImage normalizedImage1 = normalizeImage(image1);
            BufferedImage normalizedImage2 = normalizeImage(image2);
            BufferedImage resultImageGroup1 = addImages(normalizedImage1, normalizedImage2);

            File output = new File("C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens" +
                    " e V. computacional\\Operacoes Logicas e Aritmeticasc\\src" + (i + 1 + ".jpg"));
            ImageIO.write(resultImageGroup1, "jpg", output);

            System.out.println("Resultado do grupo " + (i + 1) + " salvo.");
        }
    }
}

