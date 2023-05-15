package baekjoon;

import java.util.Scanner;

public class baekjoon20546 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int money = input.nextInt();
		int[] price = new int[14];
		int sungminM = money;
		int sungminC = 0;
		int junheunM = money;
		int junheunC = 0;
		int pluscount = 0;
		int minuscount = 0;
		int stotal = 0;
		int jtotal = 0;
		for (int i = 0; i < price.length; i++) {
			price[i] = input.nextInt();
		}
		for (int i = 0; i < price.length; i++) {
			if (i > 0) {
				if (price[i] - price[i - 1] > 0) {
					pluscount++;
					minuscount = 0;
				} else if (price[i] - price[i - 1] < 0) {
					minuscount++;
					pluscount = 0;
				}
			}
			if (junheunM - price[i] >= 0) {
				junheunC += junheunM / price[i];
				junheunM = junheunM - (price[i] * (junheunM / price[i]));
			}
			if (sungminM - price[i] >= 0) {
				if (minuscount >= 3) {
					sungminC += sungminM / price[i];
					sungminM = sungminM - (price[i] * (sungminM / price[i]));
				}
			}
			if (pluscount == 3 && sungminC > 0) {
				sungminM += price[i] * sungminC;
				sungminC = 0;
			}
		}
		jtotal = junheunM + (price[13] * junheunC);
		stotal = sungminM + (price[13] * sungminC);
		if (jtotal > stotal) {
			System.out.print("BNP");
		} else if (jtotal < stotal) {
			System.out.print("TIMING");
		} else if (jtotal == stotal) {
			System.out.print("SAMESAME");
		}
	}

}
