package br.edu.ufcg.splab.experimentsExamples.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-07-02
 * 
 */
/**
 * <b>Objective:</b> Represents an output file of the experiment.
 * Stores the data related to a dependent variable
 * and also can save them into a file.
 * <br>
 * <b>Description of use:</b> It is used in every ARRSTT experiment to storage the dependent
 * variable's data.
 */
public class ExperimentFile {
	public static final String defaultFormat = ".txt";
	
	private BufferedWriter writer;
	
	/**
	 * Takes care of storing the data.
	 */
	private StringBuffer content;
	
	/**
	 * The file format in which the saving file will be.
	 */
	private String fileFormat;
	
	/**
	 * The name of the saving file.
	 */
	private String fileName;
	
	/**
	 * Build a new ExperimentFile.
	 * 
	 * @param fileName The name of the file.
	 * @param fileFormat The format of the file.
	 */
	public ExperimentFile(String fileName, String fileContent, String fileFormat) {
		this.content = new StringBuffer(fileContent);
		this.fileFormat = fileFormat;
		this.fileName = fileName;
	}
	
	public ExperimentFile(String fileName, String fileContent){
		this(fileName, fileContent, defaultFormat);
	}
	
	/**
	 * Build a new ExperimentFile with the file format being txt.
	 * 
	 * @param fileName The name of the file.
	 */
	public ExperimentFile(String fileName) {
		this(fileName, "" ,defaultFormat);
	}
	
	/**
	 * <b>Objective:</b>Save the the content of the object into a file.
	 * Location of the file: root.
	 * 
	 * @throws IOException
	 */
	public void save() throws IOException {
		writer = new BufferedWriter(new FileWriter(new File(fileName + fileFormat)));
		writer.write(content.toString());
		writer.close();
	}
	
	/**
	 * 
	 * @return The file name.
	 */
	public String getFileName() {
		return fileName;
	}	
	
	/**
	 * 
	 * @param fileName The new file name.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * 
	 * @return The data stored by an object of this class.
	 */
	public StringBuffer getContent() {
		return content;
	}
	
	/**
	 * 
	 * @param content The new data stored by an object of this class.
	 */
	public void setContent(StringBuffer content) {
		this.content = content;
	}
	
	/**
	 * <b>Objective:</b> Adds content to the end of an StringBuffer.
	 * 
	 * @param toAppendContent The content to be added.
	 */
	public void appendContent(StringBuffer toAppendContent) {
		this.content.append(toAppendContent);
	}
	
	/**
	 * <b>Objective:</b> Adds content to the end of an StringBuffer.
	 * 
	 * @param toAppendContent The content to be added.
	 */
	public void appendContent(String toAppendContent) {
		this.content.append(toAppendContent);
	}
}
