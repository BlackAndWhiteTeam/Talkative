package fr.epsi.talkative.resource;

import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.junit.ApplicationComposer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ApplicationComposer.class)
public class ArticleResourceTest {
	
	@Test
	public void canGetNoCommentWhenNewArticle()
	{
		WebClient webClient = WebClient.create("http://localhost:4204");
		String result = webClient.path("editor/me/articles/myarticle/comments").get(String.class);
		
		Assert.assertNull(result);
		Assert.assertEquals(Status.NO_CONTENT.getStatusCode(), webClient.getResponse().getStatus());
	}

}
