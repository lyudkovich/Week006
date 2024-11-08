package week06;

import java.util.ArrayList;
import java.util.List;

//Player
//
//i.     Fields
//
//               1.     hand (List of Card)
//
//                2.     score (set to 0 in the constructor)
//
//                3.     name
//
//ii.    Methods
//
//               1.     describe (prints out information about the player and calls the describe method for each card in the Hand List)
//
//               2.     flip (removes and returns the top card of the Hand)
//
//               3.     draw (takes a Deck as an argument and calls the draw method on the deck, adding the returned Card to the hand field)
//
//              4.     incrementScore (adds 1 to the Player’s score field)
//

public class Player {
	
	private String name;
	private int score;
	private List<Card> hand = new ArrayList<Card>();
	
	
	public Player(String name, int score, List<Card> hand ) {
		this.setName(name);
		this.setScore(0);
		this.setHand(hand);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public List<Card> getHand() {
		return hand;
	}


	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
//  1.     describe (prints out information about the player and calls the describe method for each card in the Hand List)	
	public void describe() {
		System.out.println("---------------------" );
		System.out.println("Player Name : " + name );
		System.out.println("---------------------" );
		for( Card card: hand) {
			card.describe() ;
		}
	}	

//  2.     flip (removes and returns the top card of the Hand)	
	public Card flip() {
		Card card = this.hand.getFirst();
		this.hand.removeFirst();
//		System.out.println(card.getValue() );
		return card;
	}	
	
//  3.     draw (takes a Deck as an argument and calls the draw method on the deck, adding the returned Card to the hand field)	
	public void draw(Deck deck) {
		hand.add(deck.draw() );
	}	
	
	
	

}
