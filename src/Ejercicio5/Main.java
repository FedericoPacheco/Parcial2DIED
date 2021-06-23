package Ejercicio5;

public class Main 
{
	public static void main(String[] args)
	{
		int[] arr1 = { 0, 0, 1, 1, 1, 1 }; 
		int[] arr2 = { 0, 0, 0, 0, 0, 0, 1 };
		int[] arr3 = { 0, 1, 1, 1 };
		int[] arr4 = { 0 };
		int[] arr5 = { 1 };
		int[] arr6 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		System.out.println(divideYVenceras(arr1));
		System.out.println(divideYVenceras(arr2));
		System.out.println(divideYVenceras(arr3));
		System.out.println(divideYVenceras(arr4));
		System.out.println(divideYVenceras(arr5));
		System.out.println(divideYVenceras(arr6));
	}
	
	public static int divideYVenceras(int[] arr) { return divideYVenceras(arr, 0, arr.length - 1);}
	
	private static int divideYVenceras(int[] arr, int i, int f)
	{
		int m = i + (f - i) / 2;
		int r = 0;
		
		if (arr[m] == 1)
		{
			if (m - 1 >= 0)
			{
				if (arr[m - 1] == 0)
					r = m;
				else
					r = divideYVenceras(arr, i, m - 1);
			}
		}
		else if (arr[m] == 0)
		{
			if (m + 1 < arr.length)
			{
				if (arr[m + 1] == 0)
					r = divideYVenceras(arr, m + 1, f);
				else if (arr[m + 1] == 1)
					r = m + 1;
			}
			else
				r = arr.length;
		}
		
		return r;
	}
}
