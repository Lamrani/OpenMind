package universite.toulouse.moodlexmlapi.openmind.xml.manager;

import java.util.List;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.w3c.dom.DOMException;

import universite.toulouse.moodlexmlapi.core.InvalidQuizFormatException;

public class DomManager {

	/**
	 * 
	 * @param elementName
	 * @return
	 * @throws InvalidQuizFormatException 
	 */
	public static Element getRootElement(String elementName) throws InvalidQuizFormatException{
		
		if(QuizManager.DOCUMENT != null){
			Element racine = QuizManager.DOCUMENT.getRootElement();
			return racine.getChild(elementName);
		}else{
			throw new InvalidQuizFormatException(new JDOMException());
		}
	}
	
	/**
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 * @throws InvalidQuizFormatException 
	 */
	public static Element getElement(Element element, String elementName) throws InvalidQuizFormatException{
		if(element != null && elementName != null && elementName.length() != 0){
			return element.getChild(elementName);
		}else{
			throw new InvalidQuizFormatException(new JDOMException());
		}
	}
	
	/**
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 * @throws InvalidQuizFormatException 
	 */
	public static List getListElement(Element element, String elementName) throws InvalidQuizFormatException{
		
		if(element != null && elementName != null && elementName.length() != 0){
			return element.getChildren(elementName);
		}else{
			throw new InvalidQuizFormatException(new JDOMException());
		}
	}
	
	public static String getElementValue(Element element) throws InvalidQuizFormatException{
		if(element != null){
			return element.getText();
		}else{
			throw new InvalidQuizFormatException(new JDOMException());
		}
	}
	
	public static String getAttributtValue(Element element, String attributName) throws InvalidQuizFormatException{
		
		if(element != null && attributName != null && attributName.length() != 0){
			return element.getAttributeValue(attributName);
		}else{
			throw new InvalidQuizFormatException(new JDOMException());
		}
	}
}
