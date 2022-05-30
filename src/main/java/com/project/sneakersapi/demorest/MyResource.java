
package com.project.sneakersapi.demorest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/myresource"
 */
//request goes to xml file and searches for this path
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	//specifies a get request
	//produce specifies the type
    @GET 
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
}
