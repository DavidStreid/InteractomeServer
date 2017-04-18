package interactome.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import interactome.domain.Link;
import interactome.domain.Node;

public class InteractomeDAO{
	/*
	 * Accesses the elastic search database for the link information
	 */
	public List<Link> getInteractomeData(List<Node> nodes) throws MalformedURLException, IOException, JSONException{
		// Place Nodes into Dictionary. Links with nodes both in this dictionary are returned
		HashMap<String, Boolean> queryNodes = new HashMap<String, Boolean>();
		for(int i = 0; i<nodes.size(); i++){
			queryNodes.put(nodes.get(i).getId(), true);
		}
		
		List<Link> linkResp = new ArrayList<Link>();

		// Define Endpoint and Retrieve Data 
		String url = "http://search-genomic-visualization-en4vqbwhnt5h7cx576wkaqweim.us-west-2.es.amazonaws.com/interactome/links/HI-I-05";
		String charset = "UTF-8";
		URLConnection connection = new URL(url).openConnection();
		connection.setRequestProperty("Accept-Charset", charset);
		InputStream response = connection.getInputStream();
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(response, "UTF-8")); 
		StringBuilder responseStrBuilder = new StringBuilder();

		// Read Response
		String inputStr;
		while ((inputStr = streamReader.readLine()) != null)
		    responseStrBuilder.append(inputStr);

			JSONObject esResp = new JSONObject(responseStrBuilder.toString());			// Elastic Search response			
			JSONObject src = esResp.getJSONObject("_source");
			JSONArray linkList = src.getJSONArray("links");
			
			// Check each link to see if its two nodes are in user query. Add to response
			for (int i = 0; i < linkList.length(); i++) {
				  JSONObject link = linkList.getJSONObject(i);
				  String idA = link.getString("idA");
				  String idB = link.getString("idB");

				  if(queryNodes.get(idA)!=null && queryNodes.get(idB)!=null){
					  linkResp.add(new Link(idA, idB));
				  }
			}
		return linkResp;
	}
}