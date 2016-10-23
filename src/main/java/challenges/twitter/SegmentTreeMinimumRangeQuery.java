package challenges.twitter;

/**
 * Created by srathi on 9/19/16.
 */

 class coord
    {
        int red, blue, green;
        coord(int red, int blue, int green)
        {
            this.red = red;
            this.blue = blue;
            this.green = green;
        }
        double distance(coord input)
        {
            double distred = Math.pow(this.red - input.red,2);
            double distblue = Math.pow(this.blue - input.blue,2);
            double distgreen = Math.pow(this.green - input.green,2);
            return  Math.sqrt(distred + distblue + distgreen);

        }

    }


    class App {

            public static int binaryToInteger(String binary) {
                char[] numbers = binary.toCharArray();
                int result = 0;
                for(int i=numbers.length - 1; i>=0; i--)
                    if(numbers[i]=='1')
                        result += Math.pow(2, (numbers.length-i - 1));
                return result;
            }

        public static void main(String[] args) {
            String input = "000000001111111100000110";
            String Red = input.substring(0, 8);
            String Green = input.substring(8, 16);
            String Blue = input.substring(16, 24);
            int Ired = binaryToInteger(Red);
            int IGreen = binaryToInteger(Green);
            int IBlue = binaryToInteger(Blue);
            coord cinput = new coord(Ired,IGreen,IBlue);
            coord pureblack = new coord(255, 255, 255);
            coord purewhite = new coord(0, 0, 0);
            coord purered = new coord(255, 0, 0);
            coord puregreen = new coord(0, 255, 0);
            coord pureblue = new coord(0, 0, 255);
            double mindist = 0;
        //    double distpureblack = cinput.distance(pureblack);
//            double distpurewhite = cinput.distance(purewhite);
//            double distpurered = cinput.distance(purered);
//            double distpuregreen  = cinput.distance(puregreen);
//            double distpureblue = cinput.distance(pureblue);

            double distpureblack = pureblack.distance(cinput);
            double distpurewhite = purewhite.distance(cinput);
            double distpurered = purered.distance(cinput);
            double distpuregreen  = puregreen.distance(cinput);
            double distpureblue = pureblue.distance(cinput);
            mindist = distpureblack;

            if ( distpurewhite < distpureblack)
                mindist = distpurewhite;
            if ( distpurered < mindist)
                mindist = distpurered;
            if ( distpuregreen < mindist)
                mindist = distpuregreen;
            if ( distpureblue < mindist)
                mindist = distpureblue;
            System.out.println(pureblack.distance);
            System.out.println(purewhite.distance);
            System.out.println(purered.distance);
            System.out.println(puregreen.distance);
            System.out.println(pureblue.distance);
            System.out.println(mindist);

        }
    }





