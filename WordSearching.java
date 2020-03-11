package wordSearching;

import java.util.ArrayList;
import java.util.List;

public class WordSearching {
	private static final String dictionary[] = { "algorithm", "syzygy", "ape", "hshp", "byk", "hhpq", "kkp" };
	static boolean rightWord(String str) {
		for (int i = 0; i < dictionary.length; i++)
			if (str.equals(dictionary[i]))
				return true;
		return false;
	}

	static boolean hasWord(String str, List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(str))
				return true;
		}
		return false;
	}

	static void findWordsLeft(char letters[][], boolean empty[][], int i, int j, String str, List<String> list) {
		empty[i][j] = true;
		str = str + letters[i][j];
		if (rightWord(str) && !hasWord(str, list))
			list.add(str);
		for (int row = i; row <= i + 1 && row < letters.length; row++)
			for (int col = j; col <= j + 1 && col < letters.length; col++)
				if (row >= 0 && col >= 0 && !empty[row][col])
					findWordsLeft(letters, empty, row, col, str, list);
		str = "" + str.charAt(str.length() - 1);
		empty[i][j] = false;
	}

	private static void findWordsRight(char[][] letters, boolean[][] empty, int i, int j, String str,
			List<String> list) {
		empty[i][j] = true;
		str += letters[i][j];

		if (rightWord(str) && !hasWord(str, list))
			list.add(str);
		for (int row = i; row >= i - 1 && row >= 0; row--)
			for (int col = j; col >= j - 1 && col >= 0; col--)
				if (row < letters.length && col < letters.length && !empty[row][col])
					findWordsRight(letters, empty, row, col, str, list);
		str = "" + str.charAt(0);
		empty[i][j] = false;

	}

	public static void main(String args[]) {
		char letters[][] = { { 'm', 'v', 'j', 'l', 'i', 'x', 'a', 'p', 'e' },
				{ 'j', 'h', 'b', 'x', 'e', 'e', 'n', 'p', 'p' }, { 'h', 'k', 't', 't', 'h', 'b', 's', 'w', 'y' },
				{ 'r', 'w', 'a', 'i', 'n', 'u', 'y', 'z', 'h' }, { 'p', 'p', 'f', 'x', 'r', 'd', 'z', 'k', 'q' },
				{ 't', 'p', 'n', 'l', 'q', 'o', 'y', 'j', 'y' }, { 'a', 'n', 'h', 'a', 'p', 'f', 'g', 'b', 'g' },
				{ 'h', 'x', 'm', 's', 'h', 'w', 'y', 'l', 'y' }, { 'u', 'j', 'f', 'j', 'h', 'r', 's', 'o', 'a' } };
		System.out.println("Following words of dictionary are present");
		List<String> list = new ArrayList<>();
		boolean empty[][] = new boolean[letters.length][letters.length];

		String str = "";
		for (int i = 0; i < letters.length; i++)
			for (int j = 0; j < letters.length; j++)
				findWordsLeft(letters, empty, i, j, str, list);
		for (int i = letters.length - 1; i >= 0; i--) {
			for (int j = letters.length - 1; j >= 0; j--) {
				findWordsRight(letters, empty, i, j, str, list);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
