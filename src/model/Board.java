package model;

import java.util.Arrays;

public class Board extends Observable {
	private int[][] arr;
	private boolean[][] tick;
	static int count = 0;

	public int[][] getArr() {
		return arr;
	}

	public void setArr(int i, int j) {
		arr = new int[i][j];
		notifyObs();
	}

	public void setArr(int i, int j, int value) {
		arr[i][j] = value;
		notifyObs();
	}

	public boolean checkWin(int i, int j) {
		int[][] array = new int[this.arr.length][this.arr[0].length];
		for (int n = 0; n < array.length; n++) {
			for (int m = 0; m < array[n].length; m++) {
				if (arr[n][m] != 0)

					if (arr[n][m] % 2 == 0) {
						array[n][m] = 1;
					} else if (arr[n][m] % 2 != 0) {
						array[n][m] = 2;
					}
			}
		}

		boolean row = checkWinOnArray( j, getRow(i, j));
		boolean col = checkWinOnArray(i, getCol(i, j));
		boolean mainDiagonal = checkWinOnArray(i, getMainDiagonal(i, j));
//		boolean	sideDiagonal = checkWinOnArray(i, getSideDiagonal(i, j));


//		int count = 0, k, h = j;
//
//		// check row
//		while (h < array.length && array[i][h] == array[i][j]) {
//			count++;
//			h++;
////			System.out.println("count" + count);
////			System.out.println("h:" + h);
//		}
//		h = j - 1;
//		while (h > 0 && array[i][h] == array[i][j]) {
//			count++;
//			h--;
//		}
//		if (count > 2) {
//			return true;
//		}
//		// check column
//		k = i;
//		count = 0;
//		while (k <array[0].length && array[k][j] == array[i][j]) {
//			count++;
//			k++;
//		}
//		k = i - 1;
//		while (k >0  && array[k][j] == array[i][j]) {
//			count++;
//			k--;
//		}
//		if (count > 2) {
//			return true;
//
//		}
//
//		// check main diagonal
//
//		count = 0;
//		k = i;
//		h = j;
//		while (k < array.length && h < array[0].length && array[i][j] == array[k][h]) {
//			count++;
//			k++;
//			h++;
//		}
//		k = i - 1;
//		h = j - 1;
//		while ( k > 0 && h > 0 && array[i][j] == array[k][h]) {
//			count++;
//			k--;
//			h--;
//		}
//		if(count>2){
//			return true;
//		}
////		check side diagonal
//		count = 0;
//		k = i;
//		h = j;
//
//
////		while (k >=0 && h <=array[0].length && array[i][j] == array[k][h]) {
////			count++;
////			k--;
////			h++;
////		}
//		do {
//			count++;
//			k--;
//			h++;
//		} while (k >0 && h <array[0].length && array[i][j] == array[k][h]);
//
//		k = i + 1;
//		h = j-1;
//		while (k <array.length && h >0 && array[i][j] == array[k][h]) {
//			count++;
//			k++;
//			h--;
//		}
//		if(count>2){
//			return true;
//		}

		return col||row|| mainDiagonal;
	}

	private int[] getSideDiagonal(int i, int j) {
		int[] arrayNeedCheck = new int[i+j+1];
		int saveValue = j + i;
		int count = arrayNeedCheck.length-1;
		for (int k = 0; k < arr.length; k++) {
			for (int k2 = 0; k2 < arr[0].length; k2++) {
				if (k2 + k == saveValue) {
					if (arr[k][k2] == 0) {
						arrayNeedCheck[count] = 0;
					} else
						arrayNeedCheck[count] = arr[k][k2] % 2 == 0 ? 2 : 1;
					count--;
				}
			}
		}
		System.out.println(Arrays.toString(arrayNeedCheck) + "hang: " + i + "cot: " + j);
		return arrayNeedCheck;
	}

	private int[] getMainDiagonal(int i, int j) {
		int[] arrayNeedCheck = new int[Math.min(arr.length, arr[0].length)];
		int saveValue = j - i;
		int count = 0;
		for (int k = 0; k < arr.length; k++) {
			for (int k2 = 0; k2 < arr[0].length; k2++) {
				if (k2 - k == saveValue) {
					if (arr[k][k2] == 0) {
						arrayNeedCheck[count] = 0;
					} else
						arrayNeedCheck[count] = arr[k][k2] % 2 == 0 ? 2 : 1;
					count++;
				}
			}
		}
		System.out.println(Arrays.toString(arrayNeedCheck) + "hang: " + i + "cot: " + j);
		return arrayNeedCheck;
	}

	private int[] getCol(int i, int j) {
		int[] arrayNeedCheck = new int[arr[0].length];
		for (int k = 0; k < arrayNeedCheck.length; k++) {
			if (arr[k][j] != 0) {
				arrayNeedCheck[k] = arr[k][j] % 2 == 0 ? 2 : 1;
			}
		}
		System.out.println(Arrays.toString(arrayNeedCheck) + "hang: " + i + "cot: " + j);
		return arrayNeedCheck;
	}

	private int[] getRow(int i, int j) {
		int[] arrayNeedCheck = new int[arr.length];
		for (int k = 0; k < arrayNeedCheck.length; k++) {
			if (arr[i][k] != 0) {
				arrayNeedCheck[k] = arr[i][k] % 2 == 0 ? 2 : 1;
			}
		}
		System.out.println(Arrays.toString(arrayNeedCheck) + "hang: " + i + "cot: " + j);
		return arrayNeedCheck;
	}

	private boolean checkWinOnArray(int location, int[] a) {
		System.out.println(location +" location");
//		int[] arrayNeedCheck = a;
//		int[] arrayNeedCheck = new int[arr.length];
//		for (int k = 0; k < arrayNeedCheck.length; k++) {
//			if (arr[i][k] != 0) {
//				arrayNeedCheck[k] = arr[i][k] % 2 == 0 ? 2:1 ;
//			}
//		}
		int count = 1;
		int h = location + 1;
		while (h < a.length && a[location] == a[h]) {
			count++;
			h++;
		}
		h = location - 1;
		while (h >= 0 && a[location] == a[h]) {
			count++;
			h--;
		}
		if (count > 2) {
			return true;
		}
//		System.out.println(Arrays.toString(a) + "hang: " + i + "cot: " + location);
		return false;
	}

}
