package streamsapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileStream {
  
	  public static void main(String args[]) throws IOException {
		  fileReader();
	  }
	  
	  public static void fileReader() throws IOException {
		      try(Stream<String> lines = Files.lines(Path.of("src\\streamsapi\\data.txt"))){
		    	    lines.forEach(System.out::println);
		      }
	  }
}
