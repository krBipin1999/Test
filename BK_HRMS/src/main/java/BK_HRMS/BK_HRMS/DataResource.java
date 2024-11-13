package BK_HRMS.BK_HRMS;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/api")
public class DataResource {
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response insertData(@FormParam("name") String name, @FormParam("number") String number,
			@FormParam("age") int age) {
		try {
			DataLogic.insertData(name, number, age);
			return Response.status(Status.OK).entity("Data inserted successfully").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error occurred").build();
		}
	}

	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it Again!";
	}
}
