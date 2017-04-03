package utils;

public class CurrentWorkingDirectory {
	
	private String path;
	
  public String getCurrentDirectoryPath(){
	  
	  path=System.getProperty("user.dir");
	  
	  return path;
	  
	  
  }
		
		


}
