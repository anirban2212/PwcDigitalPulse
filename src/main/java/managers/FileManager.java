package managers;

import generic.FileReader;

/*
 * This class is used read all the files from a single place.
 */
public class FileManager {

	private static FileManager readFileManager = new FileManager();
	private static FileReader configFileReader;

	private FileManager() {
	}

	/*
	 * This will return the current instance of the config file reader.If there's
	 * not existing config file reader object then it will create a new one.
	 */
	public FileReader getConfigReader() {
		return (configFileReader == null) ? new FileReader() : configFileReader;
	}

	/*
	 * This will return the current instance of the file reader manager class.
	 */
	public static FileManager getFileReaderManagerInstance() {
		return readFileManager;
	}

}
