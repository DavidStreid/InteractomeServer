package interactome.domain;

import java.util.ArrayList;
import java.util.List;

public class LinkRequest{
	private List<Node> nodes;
	
	public LinkRequest(){
		nodes = new ArrayList<Node>();
	}

	public List<Node> getNodes() {
		return nodes;
	}
	
	@Override
	public String toString() {
		return "NODES: " + nodes;
	}
}