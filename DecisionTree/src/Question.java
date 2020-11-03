import java.io.Serializable;

public class Question implements Serializable {

    int key;
    String question;
    public boolean isQuestion = true;

    Question parent;
    Boolean parentYesResponse;
    Question no; //left
    Question yes; //right

	/*public Question(String question, Boolean isQuestion) {
		this.question = question;
		this.isQuestion = isQuestion;
	} */

}
