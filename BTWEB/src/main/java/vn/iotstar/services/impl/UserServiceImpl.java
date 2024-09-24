package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.UserService;

public class UserServiceImpl implements UserService {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email, username, fullname, password, null, 5, phone, date));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
	
	public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Dữ liệu giả lập cho việc đăng nhập
        String username = "dainhan"; // Thay thế bằng username thật
        String password = "123"; // Thay thế bằng mật khẩu thật

        // Gọi phương thức login
        UserModel user = userService.login(username, password);

        // Kiểm tra và hiển thị kết quả
        if (user != null) {
            System.out.println("Đăng nhập thành công!");
            System.out.println("Thông tin người dùng:");
            System.out.println("ID: " + user.getId());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Username: " + user.getUserName());
            System.out.println("Full Name: " + user.getFullName());
            System.out.println("Phone: " + user.getPhone());
            System.out.println("Role ID: " + user.getRoleid());
            System.out.println("Created Date: " + user.getCreatedDate());
        } else {
            System.out.println("Đăng nhập thất bại! Kiểm tra lại username hoặc password.");
        }
	}
	
}
