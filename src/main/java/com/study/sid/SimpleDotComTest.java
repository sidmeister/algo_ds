package com.study.sid;

public class SimpleDotComTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimpleDotCom dot = new SimpleDotCom();
        DotComGameHelper helper = new DotComGameHelper();
        int rand = (int) Math.random() * 5;
        int[] locationcells = { rand, rand + 1, rand + 2 };
        int numOfGuesses = 0;
        dot.setLocationCells(locationcells);

        Boolean isalive = true;

        while (isalive == true) {
            String UserGuess = helper.gameUserInput("Enter a number");
            String result = dot.checkYourSelf(UserGuess);
            numOfGuesses++;

            if (result.equals("kill")) {
                isalive = false;
                System.out.println("You took" + numOfGuesses + "guesses");
            }
        }
    }
}
