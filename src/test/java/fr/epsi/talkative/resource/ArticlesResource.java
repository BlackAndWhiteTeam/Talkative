package fr.epsi.talkative.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("editor/{editor}/articles{articles}")
public class ArticlesResource {

	@GET
	public Response getComments(String editor){
		return Response.noContent().build();
	}
}
