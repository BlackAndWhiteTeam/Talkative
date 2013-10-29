package fr.epsi.talkative.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * 
 * @author David CROCHOT
 *
 */
@Path("editors")
public class EditorsResource {
	
	@Path("{editor}/articles")
	public  EditorResource getArticles(@PathParam("editor")String editor){
		
		return new EditorResource();
	}

}
