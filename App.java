//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  Object Oriented Programming
// Java Week 05 Lab  
//
package week06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

//	2. Create a class called App with a main method.
//
//	a.      Instantiate a Deck and two Players, call the shuffle method on the deck.
//
//	b.     Using a traditional for loop, iterate 52 times calling the Draw method on the other player each iteration using the Deck you instantiated.
//
//	c.      Using a traditional for loop, iterate 26 times and call the flip method for each player.
//
//	Compare the value of each card returned by the two player’s flip methods. Call the incrementScore method on the player whose card has the higher value.  Print a message to say which player received a point.
//	Note:  If the values are equal (it is a tie), print a message saying that no point was awarded.
//	d.      After the loop, compare the final score from each player.
//
//	e.      Print the final score of each player and either “Player 1”, “Player 2”, or “Draw” depending on which score is higher or if they are both the same.
		
	
	public static void main(String[] args) {
		
		List<Card> cards1 = new ArrayList<Card>();	
		List<Card> cards2 = new ArrayList<Card>();	

//Instantiate a Deck and two Players, call the shuffle method on the deck.		
		
		Deck deck = new Deck();
		System.out.println("Deck has been created!");	    
//		deck.describe();
		
//Instantiate two Players
		
		Player player1 = new Player("Tom", 0, cards1 );
		Player player2 = new Player("Pit", 0, cards2 );
		int score1 = 0;
		int score2 = 0;

//Call the shuffle method on the deck.		
		deck.shuffle();
		System.out.println("Deck has been shuffled!");		
//		deck.describe();
		
		
//	b.     Using a traditional for loop, iterate 52 times calling the Draw method on the other player each iteration using the Deck you instantiated.
		System.out.println("\nCreate Game");
		int numOfPlayers = 2;
		Map< String, List<Card> > gameBoard = createGame(numOfPlayers);
	
		// Print out each Player and their Hand here.
		System.out.println("--------------------------");
		for (int i = 1; i <= numOfPlayers; i++) {
			String playerName = "Player " + i;
			System.out.println(playerName + "\n--------");
			List<Card> playerList = gameBoard.get(playerName);
			
//			for (Card handCard : playerList) {
//				handCard.describe();
//			}	
			System.out.println("--------------------------");
		}	
		
//c.      Using a traditional for loop, iterate 26 times and call the flip method for each player.
//			Compare the value of each card returned by the two player’s flip methods. Call the incrementScore method on the player whose card has the higher value.  Print a message to say which player received a point.
//			Note:  If the values are equal (it is a tie), print a message saying that no point was awarded.
//d.      After the loop, compare the final score from each player.
		System.out.println(gameBoard.size());
		
		Set<String> keys = gameBoard.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        
		List<Card> playerList1 = gameBoard.get("Player 1");        
        System.out.println(playerList1.size());
        System.out.println(playerList1.get(0).getName() + ":" + playerList1.get(0).getSuit() + ":" + playerList1.get(0).getValue() );
        
		List<Card> playerList2 = gameBoard.get("Player 2");        
        System.out.println(playerList2.size()); 
        System.out.println(playerList2.get(0).getName() + ":" + playerList2.get(0).getSuit() + ":" + playerList2.get(0).getValue() );
        
        player1.setHand(playerList1);
        player2.setHand(playerList2);
        
        System.out.println("--------------------------");  
        System.out.println("player1");         
        player1.describe();
        
        System.out.println("--------------------------");  
        System.out.println("player2");         
        player2.describe();        
        
        
        for ( int i = 1; i <=26; i++) {
        	
        	Card card1 = player1.flip();
        	Card card2 = player2.flip();
		        	
		        if ( card1.getValue() > card2.getValue()) {
		        	score1 ++;
		        }else if ( card1.getValue() < card2.getValue() ){
		        	score2 ++;
		        }
		        
		        System.out.println("--------------------------"); 
		        System.out.println(i + ". Player1 card value " + card1.getValue()  + " Player2 card value  " + card2.getValue());
		        System.out.println(i + ". Running score: " + score1 + " : " + score2); 
        }
        
        
	} 
	
	// createGame Method:
	private static Map<String, List<Card>> createGame(int numOfPlayers) {
		Map<String, List<Card>> finalGameMap = new HashMap<>();
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println("Deck has " + deck.getCards().size() + " cards!");
		
		// Create the entries in the Map with the Player Name and an empty List
		for (int i = 1; i <= numOfPlayers; i++) {
			List<Card> playerList = new ArrayList<>();
			String playerName = "Player " + i;
			finalGameMap.put(playerName, playerList);
		}
		// Deal the deck:  draw a card, add the new card to a players hand, and store
		for (int i = 0; i < 52/numOfPlayers; i++) {
			for (int j = 1; j <= numOfPlayers; j++) {
				String playerName = "Player " + j;
				List<Card> playerList = finalGameMap.get(playerName);
				playerList.add(deck.draw());
				finalGameMap.replace(playerName, playerList);			
			}
		}
		
		return finalGameMap;
	}	
	

}
