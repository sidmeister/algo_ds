package com.study.sid;

public class SimpleDotCom {
    int[] locationcells;
    int numofhits;

    public void setLocationCells(int[] l) {
        this.locationcells = l;
    }

    public String checkYourSelf(String Guess) {
        String result = "miss";
        int g = Integer.parseInt(Guess);

        for (int loc : locationcells)
            if (g == loc) {
                result = "hit";
                numofhits++;

                break;
            }

        if (numofhits == locationcells.length) {
            result = "kill";
        }

        System.out.println(result);

        return result;
    }
}
