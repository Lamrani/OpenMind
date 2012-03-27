package universite.toulouse.moodlexmlapi.core;

import java.util.List;

/**
 * Interface representing a Moodle quiz
 * @author fsil 
 *
 */
public interface Quiz {
	
	/**
	 * @return the count of processed questions
	 */
	public int getProcessedQuestionCount();
	
	/**
	 * @return the count of extracted questions
	 */
	public int getExtractedQuestionCount();
	
	/**
	 * @return the count of non extracted questions
	 */
	public int getNonExtractedQuestionCount();
	
	/**
	 * @return the list of processed questions
	 */
	public List<Question> getProcessedQuestionList();
	
	/**
	 * @return the list of extracted questions
	 */
	public List<Question> getExtractedQuestionList();
	
	/**
	 * @return the list of non extracted questions
	 */
	public List<Question> getNonExtractedQuestionList();
	

}
