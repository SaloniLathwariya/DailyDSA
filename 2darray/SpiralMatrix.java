public class SpiralMatrix {

    public static void printSpiralMatrix(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        while(rowStart <= rowEnd && colStart <= colEnd) {
            // upper row
            for(int j=colStart; j<=colEnd; j++) {
                System.out.print(matrix[rowStart][j]+" ");
            }

            // right col
            for(int i=rowStart+1; i<=rowEnd; i++) {
                System.out.print(matrix[i][colEnd]+" ");
            }

            // bottom row
            for(int j=colEnd-1; j>=colStart; j--) {
                if(rowStart == rowEnd) break;
                System.out.print(matrix[rowEnd][j]+" ");
            }

            // left col
            for(int i=rowEnd-1; i>=rowStart+1; i--) {
                if(colStart == colEnd) break;
                System.out.print(matrix[i][colStart]+" ");
            }

            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        printSpiralMatrix(matrix);
    }
}
