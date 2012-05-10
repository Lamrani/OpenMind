package universite.toulouse.moodlexmlapi.openmind.xml.manager;

import java.util.List;

import org.jdom.Document;

import universite.toulouse.moodlexmlapi.core.data.ImportedQuiz;
import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.Quiz;

public class QuizManager implements ImportedQuiz, Quiz {

	public static Document DOCUMENT;
	
	/**
	 * Constructor
	 * @param document
	 */
	public QuizManager(Document document) {
		
		this.DOCUMENT = document;
	}

	public List<Question> getQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getProcessedQuestionCount() {
		// TODO Auto-generated method stub
		
		
		
		
		
		return 0;
	}

	public int getExtractedQuestionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNonExtractedQuestionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Question> getProcessedQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getExtractedQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getNonExtractedQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

}
