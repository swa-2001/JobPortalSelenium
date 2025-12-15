package Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReaderUtility {
	public List<HashMap<String,String>> getJsonDatafile() throws IOException {
		
		//reading json to string
	String jsonContent = 	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\test\\java\\Data\\ApplyJobs.json")
			
			,StandardCharsets.UTF_8);
	
	
	//String to HashMap     Jackson databind
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	
	return data;
	
	}
	
	

}
