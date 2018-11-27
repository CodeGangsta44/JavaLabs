package lab01;

public class Matrix {

    private float[][] matrix;
    private int size;

    public Matrix(){

        size = 6;
        matrix = new float[size][size];
        fill_matrix();
    }

    public Matrix(int size){

        this.size = size;
        matrix = new float[size][size];
        fill_matrix();
    }

    private void fill_matrix(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = (float)Math.random()*100;
            }
        }
    }

    public void print(){


        for (float[] i:matrix){
            for (float j:i){
                System.out.printf("%6.1f", j);
            }
            System.out.printf("%n");
        }

        System.out.printf("%n");
    }

    public void rotate(){

        float swap;

        for (int i = 0; i < size / 2; i++){
            for (int j = i; j < size - i - 1; j++){
                swap = matrix[i][j];
                matrix[i][j] = matrix[j][size - i - 1];
                matrix[j][size - i - 1] = matrix[size - i - 1][size - j - 1];
                matrix[size - i - 1][size - j - 1] = matrix[size - j - 1][i];
                matrix[size - j - 1][i] = swap;
            }
        }
    }
}

