package interactome.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import interactome.service.InteractomeService;
import interactome.domain.Link;
import interactome.domain.LinkRequest;
import interactome.domain.Node;

@Controller
@RequestMapping("/getLinks")
public class InteractomeController {
	// NOTE - AutoWiring is for when you have another project (WITH A POM) that is a dependency
	private InteractomeService interactomeService = new InteractomeService();
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Link> getLinks(@RequestBody LinkRequest linkRequest) throws IOException {
		List<Node> nodes = linkRequest.getNodes();
		List<Link> links = new ArrayList<Link>();
		
		try {
			links = interactomeService.getInteractomeData(nodes);
		} catch(MalformedURLException e) {
			System.err.println("MalformedURLException: " + e.getMessage());
		} catch(IOException e) {
			System.err.println("IOException: " + e.getMessage());
		} catch(JSONException e){
			System.err.println("JSONException: " + e.getMessage());
		} catch(Exception e){
			System.err.println("Exception: " + e.getMessage());
		}	
		
		return links;
	}
}
