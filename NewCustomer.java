class NewCustomer
{
	private String customer_name;
	private String customer_email_id;
	private String customer_date_of_birth;
	private String customer_pan_card_number;
	private String customer_aadhar_card_number;
	private String customer_age;
	private String customer_mobile_number;
	private String customer_gender;
	private String customer_temporary_address;
	private String customer_permanent_address;
	private String customer_numeber;	// used for database purpose
	
	
	NewCustomer()
	{
		
	}
	
	//1
	public void setcustomer_name(String customer_name)
	{
		this.customer_name = customer_name;
	}
	
	public String getcustomer_name()
	{
		return (this.customer_name);
	}
	
	//2
	public void setcustomer_email_id(String customer_email_id)
	{
		this.customer_email_id = customer_email_id;
	}
	
	public String getcustomer_email_id()
	{
		return (this.customer_email_id);
	}
	
	//3
	public void setcustomer_date_of_birth(String customer_date_of_birth)
	{
		this.customer_date_of_birth = customer_date_of_birth;
	}
	
	public String getcustomer_date_of_birth()
	{
		return (this.customer_date_of_birth);
	}
	
	//4 customer_pan_card_number
	public void setcustomer_pan_card_number(String customer_pan_card_number)
	{
		this.customer_pan_card_number = customer_pan_card_number;
	}
	
	public String getcustomer_pan_card_number()
	{
		return (this.customer_pan_card_number);
	}
	
	//5 customer_aadhar_card_number
	public void setcustomer_aadhar_card_number(String customer_aadhar_card_number)
	{
		this.customer_aadhar_card_number = customer_aadhar_card_number;
	}
	
	public String getcustomer_aadhar_card_number()
	{
		return (this.customer_aadhar_card_number);
	}
	
	//6 customer_age
	public void setcustomer_age(String customer_age)
	{
		this.customer_age = customer_age;
	}
	
	public String getcustomer_age()
	{
		return (this.customer_age);
	}

	//7 customer_mobile_number
	public void setcustomer_mobile_number(String customer_mobile_number)
	{
		this.customer_mobile_number = customer_mobile_number;
	}
	
	public String getcustomer_mobile_number()
	{
		return (this.customer_mobile_number);
	}

	//8 customer_gender
	public void setcustomer_gender(String customer_gender)
	{
		this.customer_gender = customer_gender;
	}
	
	public String getcustomer_gender()
	{
		return (this.customer_gender);
	}


	//9 customer_temporary_address
	public void setcustomer_temporary_address(String customer_temporary_address)
	{
		this.customer_temporary_address = customer_temporary_address;
	}
	
	public String getcustomer_temporary_address()
	{
		return (this.customer_temporary_address);
	}
	
	
	//10 customer_permanent_address
	public void setcustomer_permanent_address(String customer_permanent_address)
	{
		this.customer_permanent_address = customer_permanent_address;
	}
	
	public String getcustomer_permanent_address()
	{
		return (this.customer_permanent_address);
	}

	/*
	public static void main(String args[])
	{
		NewCustomer ganesh = new NewCustomer();
		ganesh.setcustomer_name("Ganesh");
		String s = ganesh.getcustomer_age();
		System.out.println(s);
	}
	*/
}