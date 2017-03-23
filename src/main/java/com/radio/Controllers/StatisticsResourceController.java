package com.radio.Controllers;

import com.radio.Models.PlaylistShow;
import com.radio.Models.Show;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("getDailySchedule")
public class StatisticsResourceController {

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlaylistShow> Schedule() {

        StatisticsController ctrl = new StatisticsController();

        try{
            List<PlaylistShow> s = new ArrayList<>();
            for (Show sh : ctrl.showDailySchedule()) {
                s.add((PlaylistShow)sh);
            }

            return s;
        }
        catch (Exception e){
            System.out.println(e.getCause());
        }

        return null;

    }

}
