
public class Normalizacao {
    public static void main(String[] args) {
        int[][] matrizX = {
                { 46, 227, 180, 24, 115, 186 },
                { 147, 77, 71, 36, 85, 60 },
                { 122, 47, 70, 172, 116, 182 },
                { 139, 207, 146, 97, 26, 195 },
                { 86, 175, 72, 164, 59, 92 },
                { 16, 62, 141, 208, 102, 105 }
        };

        int[][] matrizY = {
                { 118, 136, 69, 183, 110, 135 },
                { 159, 22, 84, 251, 167, 62 },
                { 48, 209, 185, 143, 231, 153 },
                { 67, 26, 70, 68, 152, 184 },
                { 76, 170, 32, 64, 180, 68 },
                { 197, 150, 69, 167, 69, 113 }
        };

        int[][] somaMatrizes = new int[6][6];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x = 0; x < 6; x++){
            for (int y = 0; y < 6; y++){
                somaMatrizes[x][y] = matrizX[x][y] + matrizY[x][y];
                if (somaMatrizes[x][y] < min) min = somaMatrizes[x][y];
                if (somaMatrizes[x][y] > max) max = somaMatrizes[x][y];
            }
        }
        int[][] matrizNormalizada = new int[6][6];

        for (int x = 0; x < 6; x++){
            for (int y = 0; y < 6; y++){
                int valorOriginal = somaMatrizes[x][y];
                int valorNormalizado = (int) (((float)(valorOriginal - min) / (max - min)) * 255);
                matrizNormalizada[x][y] = valorNormalizado;
            }
        }
        System.out.println("Matriz normalizada:");
        for (int x = 0; x < 6; x++){
            for (int y = 0; y < 6; y++){
                System.out.print(matrizNormalizada[x][y] + " ");
            }
            System.out.println();
        }
    }
}