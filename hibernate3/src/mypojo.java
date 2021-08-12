public class mypojo
{
	@Override
	public String toString() {
		return "mypojo [rollno=" + rollno + ", name=" + name + ", address=" + address + "]";
	}

	String rollno,name,address;

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}