package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Account;

public interface AccountDao {
	void insert(Account account) throws SQLException;

	void delete(String id) throws SQLException;

	void update(String id, String pwd, String type) throws SQLException;

	void updatePwdOnly(String id, String pwd) throws SQLException;

	void updateTypeOnly(String id, String type) throws SQLException;

	Account getByNumber(String number) throws SQLException;

	List<Account> getAll() throws SQLException;

}
