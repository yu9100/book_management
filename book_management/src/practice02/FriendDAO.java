package practice02;

import java.util.List;

import beans.Friend;

public interface FriendDAO {

	List<Friend> selectFriend();
	void insertFriend(String name, String mail);
}
