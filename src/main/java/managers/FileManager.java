package managers;

import generic.FileReader;


public class FileManager {

	   private static FileManager readfilemanager = new FileManager();
	   private static FileReader configFileReader;
	  
	   private FileManager() {
	    }

	   public FileReader getConfigReader() {
	       return (configFileReader == null) ? new FileReader() : configFileReader;
	    }
	    
	    public static FileManager getFileReaderManagerInstance( ) {
	        return readfilemanager;
	    }
	  
}
