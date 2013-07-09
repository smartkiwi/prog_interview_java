package arrays;

public class ConnectedComponents {
    private final int[][] matrix;

    int getComponentsCounter() {
        return componentsCounter;
    }

    void incrementComponentsCounter() {
        this.componentsCounter++;
    }


    private final int shiftValue = 2;
    private int componentsCounter = shiftValue;

    ConnectedComponents(int[][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {

        int[][] testCase = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        ConnectedComponents cc = new ConnectedComponents(testCase);
        int result = cc.countComponents();
        System.out.println(result);
    }

    public int countComponents() {
        for (int rowNum = 0; rowNum < matrix.length; rowNum++) {
            for (int colNum = 0; colNum < matrix[0].length; colNum++) {
                if (getMatrixElement(rowNum, colNum) == 1) {
                    incrementComponentsCounter();
                    colorNeighbours(rowNum, colNum);
                }
            }
        }
        return componentsCounter - shiftValue;
    }

    void colorNeighbours(int rowNum, int colNum) {
        setMatrixElement(rowNum, colNum, getComponentsCounter());
        //up
        if (checkIfElementExists(rowNum - 1, colNum) && getMatrixElement(rowNum - 1, colNum) == 1) {
            colorNeighbours(rowNum - 1, colNum);
        }

        //down
        if (checkIfElementExists(rowNum + 1, colNum) && getMatrixElement(rowNum + 1, colNum) == 1) {
            colorNeighbours(rowNum + 1, colNum);
        }

        //left
        if (checkIfElementExists(rowNum, colNum - 1) && getMatrixElement(rowNum, colNum - 1) == 1) {
            colorNeighbours(rowNum, colNum - 1);
        }


        //right
        if (checkIfElementExists(rowNum, colNum + 1) && getMatrixElement(rowNum, colNum + 1) == 1) {
            colorNeighbours(rowNum, colNum + 1);
        }


    }

    private int getMatrixElement(int rowNum, int colNum) {
        if (!checkIfElementExists(rowNum, colNum)) return -1;
        return matrix[rowNum][colNum];
    }

    private boolean checkIfElementExists(int rowNum, int colNum) {
        if (rowNum < 0 || colNum < 0) {
            return false;
        } else if (rowNum >= matrix.length) {
            return false;
        } else {
            int[] row = matrix[rowNum];
            if (colNum >= row.length) {
                return false;
            }
        }
        return true;
    }


    private void setMatrixElement(int rowNum, int colNum, int newValue) {
        if (checkIfElementExists(rowNum, colNum))
            matrix[rowNum][colNum] = newValue;
    }

}
