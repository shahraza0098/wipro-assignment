package day_four;

public class ArrayRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int[][] matrix = {{1, 2, 3}, {4, 5, 6},{7, 8, 9} };

		        int n = matrix.length;

	
		        for (int i = 0; i < n; i++) {
		        	
		            for (int j = i; j < n; j++) {
		                int temp = matrix[i][j];
		                matrix[i][j] = matrix[j][i];
		                matrix[j][i] = temp;
		                
		            }
		        }

		  
		        for (int i = 0; i < n; i++) {
		            int left = 0, right = n - 1;
		            while (left < right) {
		            	
		                int temp = matrix[i][left];
		                matrix[i][left] = matrix[i][right];
		                matrix[i][right] = temp;
		                left++;
		                right--;
		            }
		        }

		 
		        System.out.println("rotate matrix:");
		        for (int[] row : matrix) {
		            for (int val : row) {
		                System.out.print(val + " ");
		            }
		            System.out.println();
		        }

	}

}
