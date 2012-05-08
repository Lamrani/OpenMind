package universite.toulouse.moodlexmlapi.openmind.xml;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Singleton {

		// Instance of class
		private static Singleton instance = null;
		// Instance of document
		private static Document documentInstance = null;

		/**
		 * Singleton instance
		 * @return Singleton
		 */
		public static Singleton getInstance() {

			if (instance == null) {

				synchronized (Singleton.class) {
					if (instance == null) {
						instance = new Singleton();
					}
				}
			}
			return instance;
		}

		/**
		 * Obtains a SaxBuilder Document
		 * 
		 * @param nameFile
		 */
		public Document open(String nameFile) {

			SAXBuilder sxb = new SAXBuilder();
			File file = null;
			if(nameFile != null){
				try {
					if(documentInstance == null){
						synchronized (Document.class) {
							if (documentInstance == null) {
								file = new File(nameFile);
								documentInstance = sxb.build(file);
							}
						}
					}
				} catch (JDOMException e) {
					System.err.println("OpenMind cannot build quiz.xml, please respect xml format");
				} catch (IOException e) {
					System.err.println("OpenMind cannot found quiz.xml");
				} 
			}else{
				System.err.println("Quiz.xml is not defined in repository");
			}
			return documentInstance;
		}
}
