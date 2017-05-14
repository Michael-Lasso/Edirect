package online.edirect.connector.domain;

public class Administrator{
	private int warehouse_id;
	private int address_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String permissions;
	private String salt;

	public int getWarehouse_id(){
		return warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id){
		this.warehouse_id=warehouse_id;
	}

	public int getAddress_id(){
		return address_id;
	}

	public void setAddress_id(int address_id){
		this.address_id=address_id;
	}

	public String getFirst_name(){
		return first_name;
	}

	public void setFirst_name(String first_name){
		this.first_name=first_name;
	}

	public String getLast_name(){
		return last_name;
	}

	public void setLast_name(String last_name){
		this.last_name=last_name;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getPermissions(){
		return permissions;
	}

	public void setPermissions(String permissions){
		this.permissions=permissions;
	}

	public String getSalt(){
		return salt;
	}

	public void setSalt(String salt){
		this.salt=salt;
	}
}