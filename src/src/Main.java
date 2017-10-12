import java.util.List;
import java.io.*;
import java.util.Scanner;

//Starting assignment 4 in branch Junaid
public class Main {
	
	public static void main(String[] args) throws Exception {
	    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	    Dice d1 = new Dice();
	    Dice d2 = new Dice();
	    Dice d3 = new Dice();
        Player player = new Player("Fred", 100);
        Game game = new Game(d1, d2, d3);
        List<DiceValue> cdv;
        int totalWins = 0;
        int totalLosses = 0;
        //Asking age from the user
		
		// bug 02 fixation 
		// asking user to enter your age 
        System.out.println("To play the game user age must be 18+");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you age: ");
        int age;
        age = 19;
        if(age < 18){
            System.out.println("Your age is less then 18 you are not allowed to play the game ");
            System.exit(0);
        }
        System.out.println("Your age is 18+ you can play the game");
        while (true)
        {
            int winCount = 0;
            int loseCount = 0;
			// Issue 03 fixation 
            // Start game counter starts from 1 
            for (int i = 1; i < 100; i++)
            {
                String name = "Fred";
                int balance = 100;
                int limit = 0;
                player = new Player(name, balance);
                player.setLimit(limit);
                int bet = 5;
                System.out.println(String.format("Start Game %d: ", i));
                System.out.println(String.format("%s starts with balance %d, limit %d",
                		player.getName(), player.getBalance(), player.getLimit()));
                int turn = 0;
                while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200)
                {

                    cdv = game.getDiceValues();
                    if(checkNoSpinThrow(cdv)){
                        turn++;
                        DiceValue pick = DiceValue.getRandom();
                      // Bug 04 fixation 
					  // minium and max values 
                        System.out.println("Mimimum wage is $5");
                        System.out.println("Mimimum wage is $200");
                        System.out.printf("Turn %d: %s bet %d on %s\n",
                                turn, player.getName(), bet, pick);

                          // Bug 05 fixation 
						  // random values appears on each turn 

					  int winnings = game.playRound(player, pick, bet);
                        cdv = game.getDiceValues();

                        System.out.printf("Rolled %s, %s, %s\n",
                                cdv.get(0), cdv.get(1), cdv.get(2));

                        if (winnings > 0) {
                            System.out.printf("%s won %d, balance now %d\n\n",
                                    player.getName(), winnings, player.getBalance());
                            winCount++;
                        }
                        else {
                            System.out.printf("%s lost, balance now %d\n\n",
                                    player.getName(), player.getBalance());
                            loseCount++;
                        }
                    }else {
                        System.out.println("Roled over as No Spin/Throw all wagers shall be void on that spin/throw");
                    }
                    
                } //while
 // issue 08 fixation 
 // balance update 
                System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
                System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
                
            } //for
            
            System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount/(winCount+loseCount)));
            totalWins += winCount;
            totalLosses += loseCount;

            String ans = console.readLine();
            if (ans.equals("q")) break;
        } //while true
		
		// Issue 06 Fixation 
		
        
        System.out.println(String.format("Overall win rate = %.1f%%", (float)(totalWins * 100) / (totalWins + totalLosses)));
	}

	// Bug 01 fixation roll over with no spin 
    private static boolean checkNoSpinThrow(List<DiceValue> cdv) {
	    boolean success = false;
	    for (int i = 0; i <cdv.size(); i++){
	        if(cdv.get(i).toString().equals("Anchor") ||
                    cdv.get(i).toString().equals("Crown") ||
                    cdv.get(i).toString().equals("Heart") ||
                    cdv.get(i).toString().equals("Diamond") ||
                    cdv.get(i).toString().equals("Club") ||
                    cdv.get(i).toString().equals("Spade")){
	            success = true;
            }
            else success = true;
            if(!success) {
                return false;
            }
        }
	    return true;
    }

}
