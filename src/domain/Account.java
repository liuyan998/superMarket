package domain;

import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@Column(name="account_number")
	@GenericGenerator(name="fk_number",strategy="utils.AccountNumberGennerator")
	@GeneratedValue(generator="fk_number")
	private String accountNumber;
	
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@Column(name="account_pwd",nullable=false)
	private String pwd;
	
	@Column(name="account_type",nullable=false)
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(id, other.id);
	}
	
}
