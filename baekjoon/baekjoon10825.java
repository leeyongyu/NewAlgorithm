package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class baekjoon10825 {

	static class Student {
		String name;
		int kscore;
		int escore;
		int mscore;

		Student(String name, int kscore, int escore, int mscore) {
			this.name = name;
			this.kscore = kscore;
			this.escore = escore;
			this.mscore = mscore;
		}
	}

	static class StudentCompare implements Comparator<Student> {
		int ret = 0;

		@Override
		public int compare(Student s1, Student s2) {
			if (s1.kscore == s2.kscore) {
				if (s1.escore == s2.escore) {
					if (s1.mscore == s2.mscore) {
						if (s1.name.compareTo(s2.name) < 0) {
							ret = -1;
						} else if (s1.name.compareTo(s2.name) == 0) {
							ret = 0;
						} else if (s1.name.compareTo(s2.name) > 0) {
							ret = 1;
						}
					} else if (s1.mscore < s2.mscore) {
						ret = 1;
					} else if (s1.mscore > s2.mscore) {
						ret = -1;
					}
				} else if (s1.escore < s2.escore) {
					ret = -1;
				} else if (s1.escore > s2.escore) {
					ret = 1;
				}
			} else if (s1.kscore < s2.kscore) {
				ret = 1;
			} else if (s1.kscore > s2.kscore) {
				ret = -1;
			}
			return ret;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		input.nextLine();

		String[] str = new String[N];
		for (int i = 0; i < str.length; i++) {
			str[i] = input.nextLine();
		}
		List<Student> list = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			String[] token = str[i].split(" ");
			int n1 = Integer.parseInt(token[1]);
			int n2 = Integer.parseInt(token[2]);
			int n3 = Integer.parseInt(token[3]);
			Student student = new Student(token[0], n1, n2, n3);
			list.add(student);
		}
		Collections.sort(list, new StudentCompare());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).name);
		}
	}

}
