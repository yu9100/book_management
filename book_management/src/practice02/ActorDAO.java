package practice02;

import java.util.List;

import beans.Actor;

public interface ActorDAO {

	List<Actor> selectActor();
	void insertActor(String name);
	List<Actor> selectDvdActor();
}
