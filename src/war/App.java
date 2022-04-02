package war;

import java.util.LinkedList;
import java.util.List;

public class App {

	// List of names the findPlayer method will use.
	private List<String> players = List.of("Kolby", "Rob");

	// Main method
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		// Instantiats a Deck
		Deck deck = new Deck();
		// Converts immutable List players to List playerNames
		List<String> playerNames = new LinkedList<>(players);
		// Instatiats two plyers
		Player player1 = findPlayer(playerNames);
		Player player2 = findPlayer(playerNames);

		// Calls the shuffle method on Deck
		deck.shuffle();
		// Calls the dealTheCards method
		dealTheCards(deck, player1, player2);
		// Calls the play method
		play(player1, player2);
		// Calls the findWinner mehtod
		findWinner(player1, player2);
	}
	// Uses if/else statement to compare scores and call printWinner or printTie
	private void findWinner(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			printWinner(player1, player2);
		} else if (player2.getScore() > player1.getScore()) {
			printWinner(player2, player1);
		} else {
			printTie(player1, player2);
		}
	}
	// Prints out winner
	private void printWinner(Player winner, Player loser) {
		System.out.println(winner.getName() + " is the winner with a score of " + winner.getScore() + " and " + loser.getName()
				+ " is the loser with a score of " + loser.getScore() + ".");

	}
	// Prints out tie
	private void printTie(Player player1, Player player2) {
		System.out.println(player1.getName() + " and " + player2.getName() + " tied with a score of " + player1.getScore() + ".");

	}
	// Runs for loop to cycle through cards and if/else to compare cards and populate players scores
	private void play(Player player1, Player player2) {
		int numTurns = player1.getHand().size();

		for (int turn = 0; turn < numTurns; turn++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();

			if (card1.getRank() > card2.getRank()) {
				player1.incrementScore();
			} else if (card2.getRank() > card1.getRank()) {
				player2.incrementScore();
			}
		}

	}
	// Uses for loop to cycle through deck and if/else to place cards in players hands in alternating fashion
	private void dealTheCards(Deck deck, Player player1, Player player2) {
		int deckSize = deck.size();

		for (int index = 0; index < deckSize; index++) {
			if (index % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}

	}

	//	takes list<> playerNames to populate Player	
	private Player findPlayer(List<String> playerNames) {
		String playerName = playerNames.remove(0);
		return new Player(playerName);
	}
}
