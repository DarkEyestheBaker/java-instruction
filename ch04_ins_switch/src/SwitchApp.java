
public class SwitchApp {
	public static void main(String[] args) {
		// using if/else statement
		String productCode = "hm01"; // we are declaring that the productCode must equal hm01
		String productDescription; // declaring product description
		if (productCode.equals("hm01")) { // if productCode equals hm01 the productDescription is a Hammer
			productDescription = "Hammer";
		} else if (productCode.equals("hm02")) { // if productCode isn't hm01 but is hm02 the productDescription is Box
													// of nails
			productDescription = "Box of nails";
		} else {
			productDescription = "Product not found"; // if productCode isn't hm01 or hm02 then it's not found
		}
		System.out.println("productDescription via if/else: " + productDescription);
		// using switch statement
		switch (productCode) {
		case "hm01":
			productDescription = "Hammer";
			break;
		case "hm02":
			productDescription = "Box of nails";
			break;
		default:
			productDescription = "Product not found";
			break;
		}
		System.out.println("productDescription via switch: " + productDescription);
	}
}