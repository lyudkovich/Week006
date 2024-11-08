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
		System.out.println("\tDeck has been created!");	    

		
//Instantiate two Players
		Player player1 = new Player("Tom", 0, cards1 );
		Player player2 = new Player("Pit", 0, cards2 );
		
//Call the shuffle method on the deck.		
		deck.shuffle();
		System.out.println("\tDeck has been shuffled!");		
		
		System.out.println("\t--------------------------");		
		System.out.println("\t GAME " + player1.getName() + "  vs. " + player2.getName() );
		System.out.println("\t--------------------------");			
		
		int numOfPlayers = 2;
		Map< String, List<Card> > gameBoard = createGame(numOfPlayers);
	
		// Print out each Player and their Hand here.
		for (int i = 1; i <= numOfPlayers; i++) {
			String playerName = "Player " + i;
			List<Card> playerList = gameBoard.get(playerName);
		}	
		
		List<Card> playerList1 = gameBoard.get("Player 1");        
		List<Card> playerList2 = gameBoard.get("Player 2");        
        
        player1.setHand(playerList1);
        player2.setHand(playerList2);
        
        String won_message = "";
        
        for ( int i = 1; i <=26; i++) {
        	
        	Card card1 = player1.flip();
        	Card card2 = player2.flip();
		        	
		        if ( card1.getValue() > card2.getValue()) {
		        	player1.setScore(player1.getScore() + 1);
		        	won_message = player1.getName() + "  won!";
		        	
		        }else if ( card1.getValue() < card2.getValue() ){
		        	player2.setScore(player2.getScore() + 1);
		        	won_message = player2.getName() + "  won!";
		        }else {
		        	
		        	won_message = "Game tied!";
		        }
		        
		        System.out.println("--------------------------"); 
		        System.out.println("Round " + i + ". " + player1.getName() + " got: " + card1.getName() + " " + card1.getValue()  + " ||  " + player2.getName() + " got: " + card1.getName() + "   " + card2.getValue());
		        System.out.println("Round " + i + ". " + won_message );
		        System.out.println("Round " + i + ". Running score: " + player1.getScore() + " : " + player2.getScore()); 
        }
        
        System.out.println(""); 
        System.out.println(""); 
        
        System.out.println("--------------------------"); 
        System.out.println("-----Game Over------------");
        
        if ( player1.getScore() > player2.getScore()) {
        	won_message = player1.getName() + "  won the game !";
        	
        }else if ( player1.getScore() < player2.getScore() ){
        	won_message = player1.getName() + "  won the game !";
        }else {
        	won_message = "Game tied!";
        }       
        
        System.out.println("" + won_message); 
        System.out.println("--------------------------");         
    
        
	} 
	
	// createGame Method:
	private static Map<String, List<Card>> createGame(int numOfPlayers) {
		Map<String, List<Card>> finalGameMap = new HashMap<>();
		Deck deck = new Deck();
		deck.shuffle();
		
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
