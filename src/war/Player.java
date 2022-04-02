package war;

import java.util.LinkedList;
import java.util.List;

public class Player {
	
	// player variables
	private String name;
	private List<Card> hand = new LinkedList<>();
	private int score;
	
	public Player(String name) {
		this.name = name;
	}

	// Method to remove cards from deck
	public void draw(Deck deck) {
		getHand().add(deck.getCards().remove(0));
		
	}

	// Method to describe players hand
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		
		b.append("Player ").append(name).append("'s hand: ").append(System.lineSeparator());
		
		for(Card card : getHand()) {
			b.append("    ").append(card).append("\n");
		}
		return b.toString();
	}

	
	// Method to remove cards from players hands during play
	public Card flip() {
		return hand.remove(0);
	}

	// method to add to plyers scores
	public void incrementScore() {
		score = getScore() + 1;
	}

	// getters
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}

	public List<Card> getHand() {
		return hand;
	}
}