package leetCode;

public class Rotate48 {

	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
	//Memory Usage: 41.1 MB, less than 90.22% of Java online submissions for Rotate Image.
	public static void rotate(int[][] matrix) {
		int length = matrix.length ;
		int temp ;
		for (int i = 0 ; i < matrix.length; i++){
			for (int j = i ; j < matrix.length ; j++){
				 temp = matrix[i][j] ;
				matrix[i][j] = matrix[j][i] ;
				matrix[j][i] = temp ;
			}
		}

		for(int i = 0 ; i < matrix.length ; i++) {
			int k = matrix.length - 1;
			int j = 0 ;

			while (j < k){
				temp = matrix[i][j] ;
				matrix[i][j] = matrix[i][k] ;
				matrix[i][k] = temp ;
				j++ ; k-- ;
			}
		}


	}

	public static void printMatrix(int[][] matrix){
		for(int i = 0 ; i < matrix.length ; i++){
			for (int j = 0 ; j < matrix.length ; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}} ;

		rotate(matrix);
		printMatrix(matrix);

	}
}
