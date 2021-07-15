package practice02;

public class DAOFactory {
	public FriendDAO getFriendDAO() {
		return  new FriendDAOImpl();
	}

	public ActorDAO getActorDAO() {
		return  new ActorDAOImpl();
	}

	public GenreDAO getGenreDAO() {
		return  new GenreDAOImpl();
	}

	public DvdDAO getDvdDAO() {
		return  new DvdDAOImpl();
	}

	public RentalDAO getRentalDAO() {
		return  new RentalDAOImpl();
	}
}
