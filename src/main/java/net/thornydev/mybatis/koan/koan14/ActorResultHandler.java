package net.thornydev.mybatis.koan.koan14;

import java.util.ArrayList;
import java.util.List;

import net.thornydev.mybatis.koan.domain.Actor;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

// TODO: implement a ResultHandler that keeps a List of
//       all Actors passed to it, filtering out those that have
//       last name of length 4
public class ActorResultHandler implements ResultHandler {

    private List<Actor> actors = new ArrayList<Actor>();
    
  public List<Actor> getActors() {
    //return null;
      return actors;
  }

    @Override
    public void handleResult( ResultContext context )
    {
        Actor actor = (Actor)context.getResultObject();
        if ( actor.getLastName().length() != 4 )
            actors.add( actor );
    }

}
