package file;

import wrapper.GAParams;
import wrapper.PSOParams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataFileWriter
{
	public void writeResultToFile(File file, GAParams params){
		FileWriter fw = null;
		try {
			fw = new FileWriter(file,true);

			//BufferedWriter writer give better performance
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(new DataExtraction().printGAResults(params));
			//Closing BufferedWriter Stream
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeResultToFile(File file, PSOParams params){
		FileWriter fw = null;
		try {
			fw = new FileWriter(file,true);

			//BufferedWriter writer give better performance
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(new DataExtraction().printPSOResults(params));
			//Closing BufferedWriter Stream
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
