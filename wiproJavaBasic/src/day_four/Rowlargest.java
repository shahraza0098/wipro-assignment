package day_four;

public class Rowlargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int[][] arr = { {1, 5, 3}, {7, 2, 8},{4, 9, 6}};

		        for (int i = 0; i < arr.length; i++) {
		            int max = arr[i][0];

		            for (int j = 1; j < arr[i].length; j++) {
		                if (arr[i][j] > max) {
		                    max = arr[i][j];
		                }
		            }

		            System.out.println("largest" +": " + max);
		        }

	}

}
