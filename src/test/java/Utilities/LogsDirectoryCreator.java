package Utilities;

import java.io.File;

public class LogsDirectoryCreator {

	    public static void main(String[] args) {
	        // Define the path to the "Logs" folder
	        String logsFolderPath = "Logs";

	        // Create a File object for the "Logs" folder
	        File logsFolder = new File(logsFolderPath);

	        // Check if the folder already exists
	        if (!logsFolder.exists()) {
	            // If it doesn't exist, create the "Logs" folder
	            if (logsFolder.mkdirs()) {
	                System.out.println("Created 'Logs' folder.");
	            } else {
	                System.err.println("Failed to create 'Logs' folder.");
	            }
	        } else {
	            System.out.println("'Logs' folder already exists.");
	        }
	    }
	}


