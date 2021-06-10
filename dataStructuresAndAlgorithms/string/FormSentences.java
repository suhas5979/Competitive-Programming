package dataStructuresAndAlgorithms.string;

import java.util.ArrayList;

public class FormSentences {

	public static void main(String[] args) {

		ArrayList<ArrayList<String>> words = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("You");
		list1.add("We");
		words.add(list1);
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Have");
		list2.add("are");
		words.add(list2);
		ArrayList<String> list3 = new ArrayList<>();
		list3.add("sleep");
		list3.add("eat");
		list3.add("drink");
		words.add(list3);
		System.out.println(form(words));
	}

	static ArrayList<String> form(ArrayList<ArrayList<String>> words) {
		ArrayList<String> res = new ArrayList<>();
		form(words, words.size(), 0, "", res);
		return res;
	}

	static void form(ArrayList<ArrayList<String>> words, int n, int cur, String curString, ArrayList<String> res) {
		if (cur == n) {
			res.add(curString.substring(0, curString.length()-1));
			return;
		}
		for (String word : words.get(cur)) {
			form(words, n, cur + 1, curString + word + " ", res);
		}

	}

}
