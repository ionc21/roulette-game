package com.caci.roulette.game;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;

import com.caci.roulette.exception.RouletteGameException;

public class ConsoleReader {

	// by default, read input from the user's console
	private static Scanner in = new Scanner(new InputStreamReader(System.in));

	public static void setInput(final InputStreamReader inputStream) {
		in = new Scanner(inputStream);
	}

	/**
	 * Prompts the user to input an integer value.
	 * 
	 * @param prompt
	 *            output to the user before waiting for input
	 * @return the value entered, waiting if necessary until one is given
	 * @throws RouletteGameException
	 */
	public static int promptInt(final String prompt)
			throws RouletteGameException {
		while (true) {
			try {
				Integer enteredNumber = Integer.parseInt(enteredString(prompt));
				if (enteredNumber <= 0) {
					throw new RouletteGameException(
							"You cannot enter bet a negative amount");
				} else {
					return enteredNumber;
				}

			} catch (NumberFormatException e) {
				System.out.println("Enter a valid number");
			}
		}
	}

	/**
	 * Prompts the user to input a word.
	 * 
	 * @param prompt
	 *            output to the user before waiting for input
	 * @return the value entered, waiting if necessary until one is given
	 */
	public static String enteredString(final String prompt) {
		System.out.print(prompt);
		return in.next();
	}

	/**
	 * Prompts the user to input an integer value between the given values,
	 * inclusive. Note, repeatedly prompts the user until a valid value is
	 * entered.
	 * 
	 * @param prompt
	 *            output to the user before waiting for input
	 * @param low
	 *            minimum possible valid value allowed
	 * @param hi
	 *            maximum possible valid value allowed
	 * @return the value entered, waiting if necessary until one is given
	 * @throws RouletteGameException
	 */
	public static int enterRange(final String prompt, final int low,
			final int hi) throws RouletteGameException {
		int answer;

		do {
			answer = promptInt(
					prompt + " between " + low + " and " + hi + "? ");
		} while (low > answer || answer > hi);

		return answer;
	}

	/**
	 * Prompts the user to input yes or no to the given question. Note,
	 * repeatedly prompts the user until yes or no is entered.
	 * 
	 * @param prompt
	 *            output to the user before waiting for input
	 * @return the value entered, waiting if necessary until one is given
	 */
	public static boolean enterYesNo(final String prompt) {
		String answer;

		do {
			answer = enteredString(prompt + " (yes or no)? ");
		} while (!answer.equals("yes") && !answer.equals("no"));

		return (answer.equals("yes"));
	}

	/**
	 * Prompts the user to input one of the given choices to the question. Note,
	 * repeatedly prompts the user until a valid choice is entered.
	 * 
	 * @param prompt
	 *            output to the user before waiting for input
	 * @param choices
	 *            possible valid responses user can enter
	 * @return the value entered, waiting if necessary until one is given
	 */
	public static String enterYourChoice(final String prompt,
			final Set<String> choices) {
		String result;

		do {
			result = enteredString(prompt + " on one of " + choices + "? ");
		} while (!choices.contains(result.toUpperCase()));

		return result;
	}
}
