package com.ddlab.spring.jdbc.txn;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override
	public void insertUser(User user) {
		getJdbcTemplate().update(
			"INSERT INTO USER1 (USERNAME, NAME) VALUES (?, ?)",
		    new Object[] {
				user.getUsername(),
				user.getName()
			}
		);
	}

	@Override
	public User getUser(String username) {
		User user = getJdbcTemplate().
			queryForObject("SELECT * FROM USER1 WHERE USERNAME = ?",
			new Object[] { username },
			new UserMapper()
			);
		return user;
	}
	
	@Override
	public List<User> getUsers() {
		List<User> users = getJdbcTemplate().
			query("SELECT * FROM USER1",
			new UserMapper()
			);
		return users;
	}
	
	private class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			return user;
		}
		
	}

}
