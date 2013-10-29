package fr.epsi.talkative.resource;

import javax.ws.rs.Path;

public class EditorResource {
	
	private String editor;

	public EditorResource(String editor){
		
		this.editor =editor;
		
	}

	@Path("articles")
	public ArticlesResource(){
		
	}
}
