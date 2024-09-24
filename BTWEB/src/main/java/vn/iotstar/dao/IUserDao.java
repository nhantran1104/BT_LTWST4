package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	UserModel findByUserName(String username);

	List<UserModel> findAll();

	UserModel findOne(int id);
<<<<<<< HEAD
	
=======

>>>>>>> f9ef2d84255e97eafe7bece77a2793c37f23ef9e
	void insert(UserModel user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
}	
