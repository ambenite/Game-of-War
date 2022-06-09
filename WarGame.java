import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class WarGame {

	public static void main(String[] args) {
		Queue<Integer> playerOne = new LinkedList<>(); 
		Queue<Integer> playerTwo = new LinkedList<>(); 
		Stack<Integer> warDeck = new Stack<>();
		
		int i; 
		int card;
		for (i = 0; i < 5; i++){
		card = (int)(Math.random()*52);
		playerOne.add(card); 
		}
		for (i = 0; i < 5; i++){
			card = (int)(Math.random()*52);
			playerTwo.add(card);
		}

		while (!playerOne.isEmpty() || !playerTwo.isEmpty()){
		System.out.println("Player Ones Cards are: " + playerOne);
		System.out.println("Player Twos Cards are: " + playerTwo);
		
		int playerOnePlay = playerOne.peek();
		int playerTwoPlay = playerTwo.peek();

		System.out.println("Player 1 plays: " + playerOnePlay);
		System.out.println("Player 2 plays: " + playerTwoPlay);
		if (playerOnePlay > playerTwoPlay){
			playerTwo.remove();
			playerOne.add(playerTwoPlay);
			playerOne.remove();
			playerOne.add(playerOnePlay);
			System.out.println("Player One wins!");
		}
			else if (playerOnePlay == playerTwoPlay){
				System.out.println("War!");
				warDeck.push(playerOnePlay);
				warDeck.push(playerTwoPlay);
				playerOne.remove();
				playerTwo.remove();
				System.out.println("Player 1 plays: " + playerOnePlay);
				System.out.println("Player 2 plays: " + playerTwoPlay);
				if (playerOnePlay > playerTwoPlay){
					while (!warDeck.isEmpty()){
					int warDeckCard = warDeck.pop();
					System.out.println(warDeckCard);
					playerOne.add(warDeckCard);
					}
					System.out.println("Player One wins!");
				}
					else {
						while (!warDeck.isEmpty()){
						int warDeckCard = warDeck.pop();
						System.out.println(warDeckCard);
						playerTwo.add(warDeckCard);
						}
						System.out.println("Player Two wins!");
				}
			}
			else {
				System.out.println("Player Two wins!");
				playerOne.remove();
				playerTwo.add(playerOnePlay);
				playerTwo.remove();
				playerTwo.add(playerTwoPlay);
			}	
		}
		if (playerOne.isEmpty()){
			System.out.println("Final Result: Player two is the winner!");
		}
		else if (playerTwo.isEmpty()){
			System.out.println("Final Result: Player One is the winner!");
		}
			
	}
}
	