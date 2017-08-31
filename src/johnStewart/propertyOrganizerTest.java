package johnStewart;

import static org.junit.Assert.*;

import org.junit.Test;

public class propertyOrganizerTest {

	@Test
	public void testSortAccountant() {
		propertyOrganizer real = new propertyOrganizer();
		Property one = new Property("AzusaPark", "Sandra", "Angie", "Christine", "Marsha", 
				"Shapell", "10", "what", "address", "back", "phone", "pm", "units" );
		Property two = new Property("AzusaPark", "Dandra", "Angie", "Christine", "Marsha", 
				"hapell", "10", "what", "address", "back", "phone", "pm", "units");
		Property three = new Property("AzusaPark", "Fandra", "Angie", "Christine", "Marsha", 
				"apell", "10", "what", "address", "back", "phone", "pm", "units");
		Property four = new Property("AzusaPark", "Valentina", "Angie", "Christine", "Marsha", 
				"pell", "10", "what", "address", "back", "phone", "pm", "units");
		Property five = new Property("AzusaPark", "zandra", "Angie", "Christine", "Marsha", 
				"ell", "10", "what", "address", "back", "phone", "pm", "units");
		real.insert(one);
		real.insert(two);
		real.insert(three);
		real.insert(four);
		real.insert(five);
		assertEquals(real.getSize(), 5);
		real.sortAccountant(real.getArray());
	}
	
	@Test
	public void testSortReviewer() {
		propertyOrganizer real = new propertyOrganizer();
		Property one = new Property("AzusaPark", "Sandra", "Angie", "Christine", "Marsha", 
				"Shapell", "10", "what", "address", "back", "phone", "pm", "units" );
		Property two = new Property("AzusaPark", "Dandra", "Angie", "Christine", "Marsha", 
				"hapell", "10", "what", "address", "back", "phone", "pm", "units");
		Property three = new Property("AzusaPark", "Fandra", "Angie", "Christine", "Marsha", 
				"apell", "10", "what", "address", "back", "phone", "pm", "units");
		Property four = new Property("AzusaPark", "Valentina", "Angie", "Christine", "Marsha", 
				"pell", "10", "what", "address", "back", "phone", "pm", "units");
		Property five = new Property("AzusaPark", "zandra", "Angie", "Christine", "Marsha", 
				"ell", "10", "what", "address", "back", "phone", "pm", "units");
		real.insert(one);
		real.insert(two);
		real.insert(three);
		real.insert(four);
		real.insert(five);
		assertEquals(real.getSize(), 5);
		real.sortReviewer(real.getArray());
	}
	@Test
	public void testDelete() {
		propertyOrganizer real = new propertyOrganizer();
		Property one = new Property("AzusaPark", "Sandra", "Angie", "Christine", "Marsha", 
				"Shapell", "10", "what", "address", "back", "phone", "pm", "units" );
		Property two = new Property("AzusaPark", "Dandra", "Angie", "Christine", "Marsha", 
				"hapell", "10", "what", "address", "back", "phone", "pm", "units");
		Property three = new Property("AzusaPark", "Fandra", "Angie", "Christine", "Marsha", 
				"apell", "10", "what", "address", "back", "phone", "pm", "units");
		Property four = new Property("AzusaPark", "Valentina", "Angie", "Christine", "Marsha", 
				"pell", "10", "what", "address", "back", "phone", "pm", "units");
		Property five = new Property("AzusaPark", "zandra", "Angie", "Christine", "Marsha", 
				"ell", "10", "what", "address", "back", "phone", "pm", "units");
		real.insert(one);
		real.insert(two);
		real.insert(three);
		real.insert(four);
		real.insert(five);
		real.delete("property", "AzusaPark");
		assertEquals(real.getSize(), 5);
		
	}
	
	@Test
	public void testInsert() {
		propertyOrganizer real = new propertyOrganizer();
		Property one = new Property("AzusaPark", "Sandra", "Angie", "Christine", "Marsha", 
				"Shapell", "10", "what", "address", "back", "phone", "pm", "units" );
		Property two = new Property("AzusaPark", "Dandra", "Angie", "Christine", "Marsha", 
				"hapell", "10", "what", "address", "back", "phone", "pm", "units");
		Property three = new Property("AzusaPark", "Fandra", "Angie", "Christine", "Marsha", 
				"apell", "10", "what", "address", "back", "phone", "pm", "units");
		Property four = new Property("AzusaPark", "Valentina", "Angie", "Christine", "Marsha", 
				"pell", "10", "what", "address", "back", "phone", "pm", "units");
		Property five = new Property("AzusaPark", "zandra", "Angie", "Christine", "Marsha", 
				"ell", "10", "what", "address", "back", "phone", "pm", "units");
		real.insert(one);
		real.insert(two);
		real.insert(three);
		real.insert(four);
		real.insert(five);
		assertEquals(real.getSize(), 5);
	}

}
