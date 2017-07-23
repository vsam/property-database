package johnStewart;

public class Property {
	String name;
	String accountant;
	String ap;
	String rm;
	String owner;
	String reviewer;
	String dueDate;
	String notes;
	String address;
	String back;
	String phone;
	String pm;
	
	public Property(String name, String accountant, String ap, 
			String rm, String owner, String reviewer, String dueDate, 
			String notes, String address, String back, String phone, String pm) {
		this.name = name;
		this.accountant = accountant;
		this.ap = ap;
		this.rm = rm;
		this.owner = owner;
		this.reviewer = reviewer;
		this.dueDate = dueDate;
		this.notes = notes;
		this.address = address;
		this.back = back;
		this.phone = phone;
		this.pm = pm;
	}
	
	public String getName() {
		return name;
	}
	public String getAccountant() {
		return accountant;
	}
	public String getAp() {
		return ap;
	}
	public String getRm() {
		return rm;
	}
	public String getOwner() {
		return owner;
	}
	public String getReviewer() {
		return reviewer;
	}
	public String getDueDate() {
		return dueDate;
	}
	public String getNotes() {
		return notes;
	}
	public String getAddress() {
		return address;
	}
	public String getBack() {
		return back;
	}
	public String getPhone() {
		return phone;
	}
	public String getPm() {
		return pm;
	}
	
}
