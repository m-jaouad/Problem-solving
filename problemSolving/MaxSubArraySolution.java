package problemSolving;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MaxSubArraySolution {

	public static int maxSubArray(int[] arr){
		int max = arr[0] ;
		int lefth = 0 ;
		int rigth = 0 ;

		int tempMax = arr[0] ;
		int i = 1 ;
		while(i < arr.length){
			tempMax += arr[i] ;
			if(tempMax > max){
				max = tempMax ;
				rigth = i ;
			}

			if( lefth + 1 < arr.length){
				if( arr[lefth + 1] > arr[lefth]){
					tempMax -= arr[lefth] ;
					lefth++ ;
					max = tempMax ;
					rigth = lefth ;
					i++ ;
					continue;
				}

				if (tempMax - arr[lefth + 1] -arr[lefth] > arr[i+1]  && i+1 < arr.length) {
					tempMax -= arr[lefth];
					tempMax -= arr[lefth +1 ];
					lefth += 2;
					if(max > 0) {
						max = tempMax;
					}

					if(lefth > rigth) rigth = lefth ;
					i += 2 ;
					continue;
				}

			}

			i++ ;
		}

		System.out.println("lefth : =" + lefth);
		System.out.println("rigth : =" + rigth);

		return max ;
	}


	public static int solution(int[] arr){
		int max = arr[0] ;
		int lefth = 0 ;
		int rigth = 0 ;

		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] > max){
				max = arr[i] ;
				rigth = i ;
				lefth = i ;
			}
		}


		int tempMax = arr[0] ;
		int i = 1 ;
		while(i < arr.length){
			tempMax += arr[i] ;
			if(tempMax > max){
				max = tempMax ;
				rigth = i ;

			}

			if( lefth + 1 < arr.length){
				if(arr[lefth] < 0 && arr[lefth + 1] > arr[lefth]){
					tempMax -= arr[lefth] ;
					lefth++ ;
					max = tempMax ;
					rigth = lefth ;
					i++ ;
					continue;
				}

				if (tempMax - arr[lefth + 1] -arr[lefth] > max && arr[lefth] > 0) {
					tempMax -= arr[lefth];
					tempMax -= arr[lefth +1 ];
					lefth += 2;
					max = tempMax;
					System.out.println("hello");
					if(lefth > rigth) rigth = lefth ;
				}

			}

			i++ ;
		}

		System.out.println("lefth : =" + lefth);
		System.out.println("rigth : =" + rigth);

		return max ;
	}

	public static int maxSubArray2(int[] arr){
		int max = arr[0];
		int lefth = 0 ;
		int rigth = 0 ;

		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] > max){
				max = arr[i] ;
				rigth = i ;
				lefth = i ;
			}
		}


		int currentSum = arr[0];
		int previousSum = arr[0] ;

		for(int i = 1 ; i < arr.length ; i++){
			currentSum += arr[i] ;

			if (currentSum > max){
				max = currentSum;
				rigth = i ;
			}

			if(previousSum < currentSum){
				if(currentSum - arr[lefth] > currentSum){
					if(currentSum - arr[lefth] > max){
						max = currentSum - arr[lefth] ;
					}
				}
			}

			previousSum = currentSum;
		}


		System.out.println("lefth : =" + lefth);
		System.out.println("rigth : =" + rigth);

		return max ;
	}


	public static  int hello(int[] arr){

		int lefth = 0 ;
		int rigth = 0 ;

		int bestSum = arr[0] ;
		int currentSum = arr[0] ;



		for (int i = 0 ; i < arr.length ; i++ ){
			currentSum += arr[i] ;

			if(currentSum > bestSum ){
				bestSum = currentSum ;
				rigth = i ;

				int absoluteNegativesValue = Math.abs(bestSum-arr[rigth] -arr[lefth]) ;
				if(arr[lefth] < absoluteNegativesValue) {
					lefth = i ;
					bestSum -= arr[lefth] - absoluteNegativesValue ;
				}
			}

		}


		System.out.println("lefth : =" + lefth);
		System.out.println("rigth : =" + rigth);

		return  bestSum ;

	}


	private boolean isAllNegative() {
		return  true ;
	}



	public static void main(String[] args) {
		int[] arr = new int[] {1, -2,1,-3,4,-1,2,1,-5,4} ;
		int maxSubArray = hello(arr);
		System.out.println("max =" + maxSubArray);
	}
}
