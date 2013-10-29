package fr.epsi.talkative.resource;

import javax.ws.rs.core.Response.Status;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 
 * @author David CROCHOT
 *
 */
@RunWith(ApplicationComposer.class)
@EnableServices("jax-rs")
public class ArticleResourceTest {
	
	
	@Module
	@Classes(ArticlesResource.class)
	public WebApp webApp(){
		return new WebApp().contextRoot("talkative");
	}
	@Test
	public void canGetNoCommentWhenNewArticle()
	{
		WebClient webClient = createWebClient();
		String result = webClient.path("talkative/editors/me/articles/myarticle/www.epsi.fr/talkative+projet.html/comments").get(String.class);
		
		Assert.assertEquals(Status.NO_CONTENT.getStatusCode(), webClient.getResponse().getStatus());
		Assert.assertEquals("http://www.epsi.fr/talkative projet.html; rel=\"article\"", webClient.getResponse().getMetadata().getFirst("Link")); 
		Assert.assertNull(result);
		
	}
	
	private WebClient createWebClient(){
		WebClient webClient = WebClient.create("http://localhost:4204");
		ClientConfiguration config = WebClient.getConfig(webClient);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return webClient;
	}

}
