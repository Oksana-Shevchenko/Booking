package com.epam.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.dao.UserDao;
import com.epam.model.User;
import com.epam.repository.RepositoryBooking;

public class UserDaoImpl implements UserDao{
	
	private RepositoryBooking repositoryBooking;
	
	public void setRepositoryBooking(RepositoryBooking repository){
		repositoryBooking = repository;
	}
	
	public RepositoryBooking getRepositoryBooking() {
		return repositoryBooking;
	}
	
	public boolean delete(long idUser) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		String key = "'user:" + idUser + "'"; 
		if (!repository.containsKey(key)) {
			return false;
		} else {
			repository.remove(key);
			return true;
		}		
	}
	
	public User getUserByEmail(String email) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		for(Entry<String, Object> item: repository.entrySet()){
			if(item.getKey().contains("user")){
				if(((User)item.getValue()).getEmail().equals(email)) {
					return (User)item.getValue();
				}
			}
		}
		return null;
	}
	
	public User createUser(User user) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		String userId = "'user:" + user.getId()+"'";
		repository.put(userId, user);
		User newUser = (User) repository.get(userId);
		return newUser;
	}
	
	public User updateUser(User user) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		String userId = "'user:" + user.getId()+"'";
		User updatedUser = (User) repository.get(userId);
		updatedUser.setName(user.getName());
		repository.put(userId, updatedUser);
		return updatedUser;
	}
	
	//TODO: pageSize and pageNum
	public List<User> getUsersByName(String name, int pageSize, int pageNum) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		List<User> lst = new ArrayList<User>();
		for (Entry<String, Object> item: repository.entrySet()) {
			if (item.getKey().contains("user")) {
				if (((User)item.getValue()).getName().contains(name)) {
					lst.add((User)item.getValue());
				}
			}
		}
		return lst;
	}
}
