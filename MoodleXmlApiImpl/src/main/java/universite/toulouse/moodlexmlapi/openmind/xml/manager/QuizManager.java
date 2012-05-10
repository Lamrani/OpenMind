package universite.toulouse.moodlexmlapi.openmind.xml.manager;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.ImportedQuiz;
import universite.toulouse.moodlexmlapi.core.data.Question;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import universite.toulouse.moodlexmlapi.core.data.Quiz;
import universite.toulouse.moodlexmlapi.openmind.xml.access.CategoryQuestionAccess;
import universite.toulouse.moodlexmlapi.openmind.xml.access.DomAccess;
import universite.toulouse.moodlexmlapi.openmind.xml.access.GenericQuestionAccess;

public class QuizManager implements ImportedQuiz, Quiz {

	public static Document DOCUMENT;
	
	/**
	 * Constructor
	 * @param document
	 */
	public QuizManager(Document document) {
		
		QuizManager.DOCUMENT = document;
	}

	public List<Question> getQuestionList() {
		
		List<Question> questionList = new ArrayList<Question>();
		Element quizElement;
		try {
			quizElement = DomAccess.getRootElement("quiz");
			List<Element> questionsList = DomAccess.getListElement(quizElement, "question");
			for(int i = 0; i < questionsList.size(); i++){
				Question question = CategoryQuestionAccess.getCategoryQuestion(questionsList.get(i));
			    if(QuestionType.category.equals(question.getQuestionType().toString())){
			    	questionList.add(question);
			    }else{
			    	question = GenericQuestionAccess.getGenericQuestion(questionsList.get(i));
			    	questionList.add(question);
			    }
			}
		} catch (InvalidQuizFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return questionList;
	}

	public int getProcessedQuestionCount() {
		Element quizElement = null;
		List questions = null;
		try {
			quizElement = DomAccess.getRootElement("quiz");
			questions = DomAccess.getListElement(quizElement, "question");
		} catch (InvalidQuizFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questions.size();
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
		Element quizElement = null;
		List questions = null;
		try {
			quizElement = DomAccess.getRootElement("quiz");
			questions = DomAccess.getListElement(quizElement, "question");
		} catch (InvalidQuizFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return questions ;
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
