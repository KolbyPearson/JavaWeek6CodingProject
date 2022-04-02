package war;

public class Card {

	// Variables for cards
	private String value;
	private String suit;
	private int rank;
	
	// card constructor
	public Card(String value, String suit, int rank) {
		this.value = value;
		this.suit = suit;
		this.rank = rank;
		
	}
	// method to descrivbe cards
	@Override
	public String toString() {
		return value + " of " + suit;
	}
	
	// getters
	public String getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
