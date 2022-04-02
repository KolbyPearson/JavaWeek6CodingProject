package war;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
		
	//card types
	List<String> values = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");
	
	//Suits
	List<String> suits = List.of("Spades", "Clubs", "Hearts", "Diamonds");
	
	// List that stores the 52 cards
	List<Card> cards = new LinkedList<>();
	
	// Method that uses for loops to create 52 card deck
	public Deck() {
		for(int i = 0; i < values.size(); i++) {
			String value = values.get(i);
			int rank = i + 1;
			
			for(String suit : suits) {
				cards.add(new Card(value, suit, rank));
			}
		}
	}
	
	// shuffles cards using the Collections shuffle method
	public void shuffle() {
		Collections.shuffle(cards);
		
	}
	// method to describe the deck if called
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		
		for (Card card : cards) {
			b.append(card).append("\n");
		}
		return b.toString();
	}
	// method to call list of cards
	public List<Card> getCards() {
		return cards;
	}
	// method to return the number of cards left in deck
	public int size() {
		return cards.size();
	}

	
}
