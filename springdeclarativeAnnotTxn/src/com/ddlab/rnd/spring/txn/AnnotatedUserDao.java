package com.ddlab.rnd.spring.txn;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
// bydefault @Transactional has readOnly false
public class AnnotatedUserDao implements IUserDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void deleteUser(int uid) {
		String delQuery = "delete from users where id = ?";
		jdbcTemplate.update(delQuery, new Object[] { uid });

	}

//	@Transactional(rollbackFor=RuntimeException.class) // It will rollback, still it will work even if you do not mention
	@Transactional(noRollbackFor=RuntimeException.class) // It will not rollback even if it is throwing exception
	public int insertUser(User user) {
		String inserQuery = "insert into users (username, password, enabled , id) values (?, ?, ?, ?) ";
		Object[] params = new Object[] { user.getUserName(),
				user.getPassword(), user.isEnabled(), user.getId() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.INTEGER };
		int number = jdbcTemplate.update(inserQuery, params, types);
		
		if(true)
		throw new RuntimeException("An intentional runtime exception");
		return number;
	}

	// override the class level transactional behaviour for select method
//	@Transactional(readOnly = true,rollbackFor=RuntimeException.class)
	@Transactional(readOnly = true,noRollbackFor=RuntimeException.class)
	public User selectUser(int uid) {
		// for all the RuntimeExceptions the transactions will be automatically
		// rolled back
		throw new RuntimeException("An intentional runtime exception");

	}

	public int updateUser(User user) throws Exception {
		/*
		 * for checked exceptions, transactions are not rolled back by default.
		 * The rolled back behaviour can be controlled by mentioning properties
		 * in xml file. Please chk
		 */
		throw new Exception("An intentional checked exception");
	}

}
