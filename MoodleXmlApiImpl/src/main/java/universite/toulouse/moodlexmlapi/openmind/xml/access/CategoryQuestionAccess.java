package universite.toulouse.moodlexmlapi.openmind.xml.access;


import org.jdom.Element;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;
import universite.toulouse.moodlexmlapi.core.data.CategoryQuestion;
import universite.toulouse.moodlexmlapi.core.data.QuestionType;
import universite.toulouse.moodlexmlapi.openmind.xml.manager.DomManager;

public class CategoryQuestionAccess {
	
	/**
	 * 
	 * @return an instance of category question
	 */
	public static CategoryQuestion getCategoryQuestion(){
		
		CategoryQuestion categoryQuestion = new CategoryQuestion();
		
		try {
			Element quizElement = DomManager.getRootElement("quiz");
			Element questionElement = DomManager.getElement(quizElement, "question");
			String typeElement =  DomManager.getAttributtValue(questionElement, "type");
			// Checking and add a value of type
			if(QuestionType.values().equals(typeElement)){
				categoryQuestion.setCategory(typeElement);
			}
			Element categoryElement = DomManager.getElement(questionElement, "category");
			Element textElement = DomManager.getElement(categoryElement, "text");
			// Add a value of course
			String course =  DomManager.getElementValue(textElement);
			categoryQuestion.setCourse(course);
		} catch (InvalidQuizFormatException e) {
			e.printStackTrace();
		}
		return categoryQuestion;
	}
}
