package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import domain.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {

	@Override
	public void addAccount(String pwd, String type) {
		Transaction tran=null;
		try {
			Session sess = HibernateUtils.getCurrentSession();
			tran = sess.beginTransaction();
			Account acc = new Account();
			acc.setPwd(pwd);
			acc.setType(type);
			AccountDao accDao =  new AccountDaoImpl();
			accDao.insert(acc);
			tran.commit();
		} catch (SQLException e) {
			if (tran!=null) {
				tran.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(String number) {
	}

	@Override
	public Account getAccount(String number) {
		return null;
	}


	@Override
	public void updatePassword(String number, String pwd) {
	}

	@Override
	public void updateType(String number, String type) {
	}

	@Override
	public boolean isExist(String number) {
		Transaction tran = null;
		try {
			Session sess = HibernateUtils.getCurrentSession();
			tran = sess.beginTransaction();
			AccountDao aDao = new AccountDaoImpl();
			Account account = aDao.getByNumber(number);
			tran.commit();
			if(account!=null) {
				return true;
			}
		} catch (SQLException e) {
			if (tran!=null) {
				tran.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isAccessible(String number, String pwd, String type) {
		Transaction tran=null;
		try {
			Session currentSession = HibernateUtils.getCurrentSession();
			tran = currentSession.beginTransaction();
			AccountDaoImpl accountDao = new AccountDaoImpl();
			Account account = (accountDao.getByNumber(number));
			if (account.getPwd().equals(pwd) && account.getType().equals(type)) {
				return true;
			}
			tran.commit();
		} catch (Exception e) {
			if (tran!=null) {
				tran.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
}
