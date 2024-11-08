package week06;


// A standard deck of playing cards has 52 cards as specified below 
//		i. There are 4 suits:  Clubs, Diamonds, Hearts, & Spades
//				
//	   ii. Each suit has 13 cards:  Two, Three, Four, Five, Six, Seven, 
//									 Eight, Nine, Ten, Jack, Queen, King & Ace
//
//	  iii. Comparing Cards:  When comparing two cards, Ace is high and Two is low.
//							 to make this easy, a Two will have a value of 2, a
//							 Three will have a value of 3, ... and an Ace will have
//							 a value of 14.
//

// 1. Card Class:
//		Create a class called Card to represent a standard playing card. 
//		Fields:   The Card class should have the following fields:
// 			a. name field
//			b. suit field
//			c. value field for comparing against other cards.
//
//		Methods:  This class can have any useful method.
//			a. describe() to display the card information to the Console.
//			b. Getters & Setters 
//



public class Card {

	private String name;
	private String suit;
	private int value;
	
	public Card(String name, String suit, int value) {
		this.name = name;
		this.suit = suit;
		this.value = value;
	}
	
	public void describe() {
		System.out.println("Name : " + name + " Suit " + suit + " Value " + value );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
