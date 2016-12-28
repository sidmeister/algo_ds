package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by srathi on 12/5/16.
 *
 Boggle (Find all possible words in a board of characters)

 Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
 Find all possible words that can be formed by a sequence of adjacent characters
 Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
 */
public class Boggle {

    static HashMap<String,Integer> dict= new HashMap<>();


    public static boolean isWord(String str) {

        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            String key = entry.getKey();
            if (key.equals(str))
                return true;
        }
        return false;
    }

    public static void findAllwords(Character[][] boggle, String str)
    {
        boolean[][] visited = new boolean[3][3];
        for(int row = 0; row < boggle.length;row++)
        {
            for(int col =0; col < boggle[0].length; col++)
            {
                    findWords(boggle,visited,row,col,str);
            }
        }
    }

    public static void findWords(Character[][] boggle,boolean[][] visited,int i, int j,String str) {

        visited[i][j] = true;

        str = str + boggle[i][j];

        if(isWord(str))
        {
            System.out.println(str);
        }

        for(int row = i -1; row < boggle.length && row <=i+1 ;row++)
        {
            for(int col =j-1; col < boggle[0].length && col <= j+1; col++)
            {
                if(row >= 0 && col >=0 && !visited[row][col])
                {
                    findWords(boggle,visited,row,col,str);
                }
            }
        }

        str = str.substring(0,str.length()-1);


        visited[i][j] = false;
        return;
    }

    public static void main(String[] args) {
        dict.put("GEEKS",1);
        dict.put("FOR",1);
        dict.put("QUIZ",1);
        dict.put("GO",1);

        Character[][] boggle = new Character[][]{{'G','I','Z'}, {'U','E','K'},{'Q','S','E'}};
//        Character[][] boggle = new Character[][]{{'A','B'},{'S','T'}};

        findAllwords(boggle,"");
    }

}
