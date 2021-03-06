package br.edu.ufcg.splab.experimentsExamples.core.dvcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.exceptions.ARRSTTException;

/**
 * This DVC collects how many failures a reduced TestSuite covers.
 * This collect is done with the aid of a txt file that contains
 * all failures the TestSuite had before it was reduced by selection
 * algorithms.
 */
public class FailuresByFileCollector implements IDvc {
	
	private File f;
	public FailuresByFileCollector(File f){
		this.f = f;
	}
	
	@Override
	public StringBuffer collect(TestSuite testSuite) {
		if (f != null) {
			List<String> ids = getIDs();
			int defectiveTCamount = 0;
			
			for (TestCase testCase : testSuite) {
				if (ids.contains(testCase.getID())) {
					defectiveTCamount++;
				}
			}
			double percentageFailure = 100*((double)defectiveTCamount/(double)ids.size());
			percentageFailure = (double)((int)percentageFailure/100.0);
			return new StringBuffer(percentageFailure + "");
			
		} else {
			return new StringBuffer("NP");
		}
	}
	
	
	// Each id should be a line in the file.
	private List<String> getIDs(){
		BufferedReader reader = null;
		List<String> ids = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(f));
			String line = reader.readLine();
			
			while (line != null) {	
				ids.add(line);
				line = reader.readLine();
			}
			
			return ids;
		} catch (IOException e) {
			throw new ARRSTTException(e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch(IOException e) {
				throw new ARRSTTException(e.getMessage());
			}
		}
	}
	
	@Override
	public String getName(){
		return "Failures by file";
	}
}
