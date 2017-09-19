package com.maispartners.conciliator.app.repository.jdbc;

import org.springframework.stereotype.Repository;

import com.maispartners.conciliator.app.model.User;
import com.maispartners.conciliator.core.repository.jdbc.JdbcInsertBuilder;
import com.maispartners.conciliator.core.repository.jdbc.JdbcSupport;
import com.maispartners.conciliator.core.repository.jdbc.JdbcUpdateBuilder;

@Repository
public class UserJdbcRepositoryImpl extends JdbcSupport<User> implements UserJdbcRepository {

	@Override
	public User save(User user) {

		JdbcInsertBuilder builder = getJdbcInsertBuilder();
		builder.table("user");
		builder.primaryKey("id");
		builder.addParam("firstName", user.getFirstName());
		builder.addParam("lastName", user.getLastName());
		builder.addParam("age", user.getAge());
		builder.addParam("active", user.getActive().booleanValue());
		return builder.executeAndReturnKey(user);
	}

	@Override
	public void update(User user) {

		JdbcUpdateBuilder builder = getJdbcUpdateBuilder();
		builder.setTableName("user");
		builder.addParam("firstName", user.getFirstName());
		builder.addParam("lastName", user.getLastName());
		builder.addParam("age", user.getAge());
		builder.addParam("active", user.getActive().booleanValue());
		builder.addWhereId("id", user.getId());
		builder.update();
	}

	@Override
	public User findOne(Long id) {

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM user WHERE id = ? ");

		return getJdbcTemplate().queryForObject(sb.toString(), new Object[] { id }, (rs, rowNum) -> {

			User user = new User();
			user.setId(rs.getLong("id"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setAge(rs.getInt("age"));
			user.setActive(rs.getBoolean("active"));
			user.setCreationDate(rs.getTimestamp("creationDate"));
			user.setModificationDate(rs.getTimestamp("modifiedDate"));

			return user;
		});
	}
}
