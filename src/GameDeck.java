import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/*Game deck is 8 decks of cards*/
public class GameDeck {
	/*Fields*/
	private Card[] gameDeck;
	private Deck[] deckArray;
	
	/*Constructor*/
	public GameDeck() {
		this.gameDeck = new Card[416];
		this.deckArray = new Deck[8];
	}
	
	/*Methods*/
	public void makeDeck() {
		//Make 8 decks of cards and shuffle them
		for(int i = 0; i < 8; i++) {
			deckArray[i] = new Deck(i);
			deckArray[i].makeDeck();
			deckArray[i].shffuleDeck(deckArray[i].getDeck());
		}	
		
		//Then put the 8 decks of card in game deck
		int deckLength = deckArray[0].getDeck().length;
		for(int i = 0; i < 8; i++) {
		System.arraycopy(deckArray[i].getDeck(), 0, gameDeck, deckLength*i, deckLength);
		}
	}
	
	public void shffuleDeck(Card[] inputDeck) {//shuffles the game deck
		Card[] shuffledDeck = inputDeck;
		Random rnd = ThreadLocalRandom.current();
		
		for(int i = 0; i < 416; i++) {	
			int index = rnd.nextInt(416);
			
			//Swap
			Card temp = shuffledDeck[index];
			shuffledDeck[index] = shuffledDeck[i];
			shuffledDeck[i] = temp;
		}
		
		this.gameDeck = shuffledDeck;
	}
	
	public void printDeck() {
		for(int i = 0; i < gameDeck.length; i++) {
			//System.out.print(inputDeck[i].getRank() + " of " + inputDeck[i].getSuit() + " ");	
			System.out.print(gameDeck[i].getID() + "\t");
			
			if((i + 1) % 20 == 0) {
				System.out.print("\n");
			}
		}
		System.out.print("\n");
	}
	
	public Card[] getDeck() {return this.gameDeck;}
}
