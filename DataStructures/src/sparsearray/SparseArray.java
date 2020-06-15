package sparsearray;


public class SparseArray {
    private static int originalArrayWidth = 11;

    private static int originalArrayHeight = 11;


    public static void main(String[] args) {

        int[][] originalArray = new int[originalArrayWidth][originalArrayHeight];

        originalArray[1][2] = 2;

        originalArray[2][3] = 4;

        int count = 0;
        for (int[] originalRaw : originalArray) {
            for (int original : originalRaw) {
                System.out.printf("%d\t", original);
                if (original != 0) {
                    count++;
                }
            }
            System.out.println();
        }

        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = originalArrayWidth;
        sparseArray[0][1] = originalArrayHeight;
        sparseArray[0][2] = count;

        int index = 1;
        for (int i = 0; i < originalArrayHeight; i++) {
            for (int j = 0; j < originalArrayWidth; j++) {
                if (originalArray[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = originalArray[i][j];
                    index++;
                }
            }
        }

        for (int[] sparseRaw : sparseArray) {
            for (int sparse : sparseRaw) {
                System.out.printf("%d\t", sparse);
            }
            System.out.println();
        }

        int[][] sparse2original = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i <= sparseArray[0][2]; i++) {
            sparse2original[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int[] originalRaw : sparse2original) {
            for (int original : originalRaw) {
                System.out.printf("%d\t", original);
            }
            System.out.println();
        }



    }




}
