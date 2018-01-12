
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Encryption {
	static Scanner sc = new Scanner(System.in);
	static int input;

	public static void main(String[] args) {
		System.out.println("Encryption encoder/decoder: ");
		System.out.println("Options: \n1: Encode \n2: Decode");

		start();

	}

	public static void start() {

		while (true) {
			try {
				input = sc.nextInt();

				if (input > 0 && input < 3) {
					if (input == 1) {

						encode();
						break;

					} else {

						decode();
						break;
					}
				} else {
					System.out.println("Not a valid entry try again!");

				}

			} catch (InputMismatchException e) {
				System.out.println("Not a valid entry try again!");
				sc.next();

			}

		}

	}

	public static void encode() {
		System.out.println("No special characters except .,!?");
		System.out.println("What would you like to encode? ");
		Scanner sc2 = new Scanner(System.in);
		String line = sc2.nextLine();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < line.length(); i++) {
			float y = (int) line.charAt(i);
			float z = y / 100;
			String edit = String.format("%.2f", z);

			sb.append(edit);
		}
		String sample = sb.toString();
		//System.out.println(sample);

		Random r = new Random();
		for (int i = 0; i < sample.length(); i++) {
			int y = r.nextInt((9 - 0) + 1);
			String z = Integer.toString(y);
			String w = ".";
			sample = sample.replaceFirst(Pattern.quote(w), z);

		}
		sc.close();
		sc2.close();
		System.out.println("Your code is: ");
		System.out.println(sample);

	}

	public static void decode() {
		System.out.println("What would you like to decode? ");
		Scanner sc1 = new Scanner(System.in);
		String code = sc1.nextLine();
		StringBuilder sb = new StringBuilder(code);
		//System.out.println(code);
		int y = code.length();
		for (int i = 1; i < code.length(); i += 4) {
			sb.setCharAt(i, '.');
		}
		code = sb.toString();
		for (int i = 0; i < y; i += 4) {

			String send = code.substring(i, i + 4);
			//System.out.println(send + " " + i);
			interp(send);

		}
		// System.out.println(code);

	}

	public static void interp(String send) {
		//System.out.println(send);
		float y = Float.parseFloat(send);
		//System.out.println(y);
		float z = y * 100 + (float).001;
		//System.out.println(z);
		int x = (int) z;
		// System.out.println(x);
		System.out.print(Character.toChars(x));
	}}