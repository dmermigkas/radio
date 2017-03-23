package REST;

import com.radio.Controllers.ProducerResourceController;
import com.radio.Initializer;
import com.radio.Models.EmailAddress;
import com.radio.Models.Producer;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class ProducerRESTTest extends RESTTest{

    protected Application configure() { //todo does not know DebugExceptionMapper
        return new ResourceConfig(ProducerResourceController.class);
    }
    protected static Producer prod;
    protected static Producer prodPersistent;
    protected static Producer prod2;

    Initializer dataHelper;

    @Before
    public void setUpData() {

        prod = new Producer("firstname1", "lastname", new EmailAddress("a@a.a"));
        prod = super.createProducer(prod);

    }

    @Test
    public void testListAllProducers() {
        String response = target("producer").request().get(String.class);
        Assert.assertTrue(response.contains("firstname1"));
    }

    @Test
    public void testProducerById() { //todo runs on its own not with others....

        String response = target("producer/"+prod.getId()).request().get(String.class);
        Assert.assertTrue(response.contains("firstname1"));

    }

    @Test
    public void testAddProducer() {

        prod2 = new Producer("aaaaaa", "bbbbbb", new EmailAddress("asss@a.a"));
        Response response = target("producer").request().post(Entity.json(prod2));
        String allProds = target("producer").request().get(String.class);
        Assert.assertTrue(allProds.contains("bbbb"));
    }

    @Test
    public void testDeleteProducerById() { //todo runs on its own not with others....
        Response response = target("producer/"+prod.getId()).request().delete();
        String allTracks = target("producer").request().get(String.class);
        Assert.assertFalse(allTracks.contains("firstname1"));
    }

    @Test
    public void testUpdateProducer() {
        prod.setFirstName("dimitris");

        Response response = target( "producer/"+prod.getId()).request().put(Entity.entity(prod, MediaType.APPLICATION_JSON));
        String allProds = target("producer").request().get(String.class);
        System.out.println(allProds);
        Assert.assertFalse(allProds.contains("firstname1"));

    }

}
