package utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.junit.Test;

import domain.Account;

public class AccountNumberGennerator implements IdentifierGenerator {
	
	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		try {
			Account acc = (Account) arg1;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String yyyy = sdf.format(cal.getTime());
			StringBuilder sb = new StringBuilder().append(yyyy);
			int number = Integer.valueOf(acc.getId());
			if (number < 10) {
				sb.append("00");
			} else if (number < 100) {
				sb.append("0");
			}
			sb.append(acc.getId());
			if ("管理员".equals(acc.getType())) {
				sb.append("777");
			} else {
				sb.append("421");
			}
			return sb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
