package interactome.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;

import interactome.domain.Link;
import interactome.domain.Node;
import interactome.DAO.InteractomeDAO;;


public class InteractomeService{
	private InteractomeDAO interactomeDAO = new InteractomeDAO();
	
	public List<Link> getInteractomeData(List<Node> nodes) throws MalformedURLException, IOException, JSONException{
		List<Link> links = interactomeDAO.getInteractomeData(nodes);
		
		return links;
	}
	
	
}