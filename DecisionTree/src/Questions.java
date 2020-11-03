import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.security.CodeSource;


public class Questions implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static String path = "";
    Question firstQuestion;

    Question currentQuestion;
    int noOfQuestions = 0;

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void startGame() {
        currentQuestion = firstQuestion;
    }

    public boolean isQuestionAnswer() {
        return !currentQuestion.isQuestion;
    }

    public boolean isEmpty() {
        return firstQuestion == null;
    }

    public String ask() {
        return currentQuestion.question;
    }

    public Question nextQuestion(boolean isYes) {
        if (isYes) {
            currentQuestion = currentQuestion.yes;
        }
        else {
            currentQuestion = currentQuestion.no;
        }
        return currentQuestion;
    }


    public void addNewQuestion(String question,String answer,Boolean isYes) {

        //Question previousQuestion = new Question();
        //previousQuestion = currentQuestion.parent;

        Question newQuestion = new Question();
        newQuestion.question = question;
        newQuestion.isQuestion = true;
        newQuestion.parent = currentQuestion.parent;
        newQuestion.parentYesResponse = currentQuestion.parentYesResponse;

        Question newAnswer = new Question();
        newAnswer.isQuestion = false;
        newAnswer.question = answer;
        newAnswer.parent = newQuestion;

        if (isYes) {
            newQuestion.yes = newAnswer;
            newQuestion.no = currentQuestion;
            newAnswer.parentYesResponse = true;
            currentQuestion.parentYesResponse = false;
            currentQuestion.parent = newQuestion;
        }
        else {
            newQuestion.no = newAnswer;
            newQuestion.yes = currentQuestion;
            newAnswer.parentYesResponse = false;
            currentQuestion.parentYesResponse = true;
            currentQuestion.parent = newQuestion;
        }

        if (newQuestion.parentYesResponse) {
            newQuestion.parent.yes = newQuestion;
        }
        else {
            newQuestion.parent.no = newQuestion;
        }

    }


    public void displayTree(Question root){
        if(root!=null){
            displayTree(root.no);
            System.out.print(" " + root.question);
            displayTree(root.yes);
        }
    }

    public static void printBinaryTree(Question root, int level){
        if(root==null)
            return;
        printBinaryTree(root.yes, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+root.question);
        }
        else
            System.out.println(root.question);
        printBinaryTree(root.no, level+1);
    }

    public static String getPath() {
        CodeSource codeSource = Game.class.getProtectionDomain().getCodeSource();
        File jarFile = null;
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String jarDir = jarFile.getParentFile().getPath();
        return jarDir;
    }

    public  static void saveGame(Questions game) throws IOException {

        path = getPath()+"/game.txt";
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(game);
        oos.close();
    }

    public  static Questions loadGame() throws IOException, ClassNotFoundException {
        path = getPath()+"/game.txt";
        Questions newGame = new Questions();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        newGame = (Questions) ois.readObject();
        ois.close();
        return newGame;
    }

    public void addFirstQuestion(String question,String yesAnswer,String noAnswer) {
        Question newQuestion = new Question();
        newQuestion.question = question;
        newQuestion.isQuestion = true;

        Question newYesAnswer = new Question();
        newYesAnswer.isQuestion = false;
        newYesAnswer.question = yesAnswer;
        newYesAnswer.parent = newQuestion;
        newYesAnswer.parentYesResponse = true;

        Question newNoAnswer = new Question();
        newNoAnswer.isQuestion = false;
        newNoAnswer.question = noAnswer;
        newNoAnswer.parent = newQuestion;
        newNoAnswer.parentYesResponse = false;

        newQuestion.yes = newYesAnswer;

        newQuestion.no = newNoAnswer;

        currentQuestion = newQuestion;

        firstQuestion = newQuestion;

    }

    public void askQuestion() {
        if (firstQuestion == null) { //new game

        }

    }



}
