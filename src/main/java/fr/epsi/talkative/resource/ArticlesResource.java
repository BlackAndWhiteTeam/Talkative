package fr.epsi.talkative.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * 
 * @author David CROCHOT
 *
 */
@Path("editors/{editor}/articles")
public class ArticlesResource {
	
	private @PathParam("editor") String editor;

	@GET
	@Path("{article:.*}/comments")
	public Response getComments(@PathParam("editor")String editor,@PathParam("articles")String article){
		return Response.noContent().build();
	}
}