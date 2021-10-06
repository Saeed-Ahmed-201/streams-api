package streamsapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertingCsvToPojo {
	
	    public static void main(String args[]) throws IOException {
	    	    convertCsvIntoObject();
	    }	
	    
	    public static void convertCsvIntoObject() throws IOException {
	    	   Pattern pattern = Pattern.compile(",");
	    	   try (Stream<String> lines = Files.lines(Path.of("src\\streamsapi\\Cake.csv"))){
	    		   
	    		  List<Cake> cakes =  lines.map(line -> {
	    			       String[] words = pattern.split(line);
    			         return new Cake(Integer.parseInt(words[0]), words[1], Double.parseDouble(words[2]));
	    		   }).collect(Collectors.toList());
	    		   
	    		  cakes.forEach(cake -> {
	    			  System.out.println(cake.getId() + " " + cake.getName() + " " + cake.getPrice());
	    		  });
	    	  }
	    	
	    }

}

class Cake{
	private int id;
    private String name;
    private double price;
    
    
	
	public Cake(int d, String name, double price) {
		super();
		this.id = d;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
