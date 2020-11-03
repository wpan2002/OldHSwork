import java.util.Scanner;

public class Magpie
{
    public static void main(String[] args)
    {
        MagpieBot maggie = new MagpieBot();

        System.out.println (maggie.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();

        while (!statement.equals("Bye"))
        {
            System.out.println (maggie.getResponse(statement));
            statement = in.nextLine();
        }
    }
    public class MagpieBot
    {
        public String getGreeting()
        {
            return "Hello, let's talk.";
        }
        public String getResponse(String statement)
        {
            String response = "";

            if (statement.indexOf("no") >= 0 || statement.indexOf("No") >= 0) {
                response = "Why so negative?";
            } else if (statement.indexOf("William") >= 0 || statement.indexOf("ailliam") >= 0) {
                response = "Yes, William is the ruler of the observable Universe and all Domains thereof.";
            } else if (statement.indexOf("Anthony") >= 0 || statement.indexOf("anthony") >= 0) {
                response = "Anthony is a strange man";
            } else if (statement.indexOf("Sun") >= 0 || statement.indexOf("sun") >= 0) {
                response = "The sun is very hot.";
            } else if (statement.indexOf("mother") >= 0
                    || statement.indexOf("father") >= 0
                    || statement.indexOf("sister") >= 0
                    || statement.indexOf("brother") >= 0) {
                response = "Tell me more about your family.";
            } else if (statement.indexOf("dog") >= 0 || statement.indexOf("cat") >= 0) {
                response = "Tell me more about your pets.";
            } else if (statement.indexOf("Dr. Petach") >= 0) {
                response = "She sounds like a good teacher.";
            } else if (statement.trim().length() == 0) {
                response = "Say something, please.";
            } else {
                response = getRandomResponse();
            }
            return response;
        }

        /**
         * Pick a default response to use if nothing else fits.
         * @return a non-committal string
         */
        private String getRandomResponse()
        {
            final int NUMBER_OF_RESPONSES = 6;
            double r = Math.random();
            int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
            String response = "";

            if (whichResponse == 0)
            {
                response = "Interesting, tell me more.";
            }
            else if (whichResponse == 1)
            {
                response = "Hmmm.";
            }
            else if (whichResponse == 2)
            {
                response = "Do you really think so?";
            }
            else if (whichResponse == 3)
            {
                response = "You don't say.";
            }
            else if (whichResponse == 4)
            {
                response = "The HORSE is a noble animal.";
            }
            else if (whichResponse == 5)
            {
                response = "You should go give Elliot Gorokhovsky five dollars.";
            }
            return response;
        }
    }

}