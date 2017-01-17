import java.io.*;
import java.util.*;
import java.awt.Point;
/**
 * Created by srathi on 1/13/17.
 */
public class MuleSoft {
        static int[][] image = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
        };


        public static void getCoordinates(ArrayList<Point> coordinates)
        {


            for (int i =0;i<image.length;i++)
            {
                for(int j=0;j<image[0].length;j++)
                {
                    if(image[i][j] == 0)
                        coordinates.add(new Point(i,j));
                }
            }
        }

        /*
        Imagine we have an image. We’ll represent this image as a simple 2D array where every pixel is a 1 or a 0.
        The image you get is known to have N rectangles of 0s on a background of 1s.
        Write a function that takes in the image and outputs the coordinates of all the 0 rectangles
        -- top-left and bottom-right; or top-left, width and height.

        For example:
        int[][] image = {
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 1, 1},
        {1, 1, 1, 0, 0, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
};
 */


    public static void dfs()
    {

        boolean[][] visited = new boolean[image.length][image[0].length];
        for (int i =0;i<image.length;i++)
        {
            for(int j=0;j<image[0].length;j++)
            {
                getrectangle(visited,i,j);
            }
        }

    }

    public static void getrectangle(boolean[][] visited,int i,int j)
    {

        if(image[i][j] == 0 && !visited[i][j])
        {
            visited[i][j] = true;
            getrectangle(visited,i,j+1);
            getrectangle(visited,i+1,j);
            System.out.println(i + " " + j);
        }

    }

        public static void main(String[] args)

        {

            ArrayList<Point> coordinates = new ArrayList<Point>();
            getCoordinates(coordinates);
            System.out.println(coordinates.get(0));
            System.out.println(coordinates.get(coordinates.size()-1));
            dfs();

        }
    }



