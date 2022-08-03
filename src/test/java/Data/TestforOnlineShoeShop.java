package Data;

public class TestforOnlineShoeShop {

	public static void main(String[] args) {
		
		BinarySearchStockTree womanStock = new BinarySearchStockTree();
		Shoes shoes1= new Shoes(1000, 38, Typee.CASUAL, Brand.SKECHERS, Color.RED,Gender.WOMAN , 5);
		Shoes shoes2= new Shoes(900, 38, Typee.SNEAKERS, Brand.SKECHERS, Color.RED,Gender.WOMAN , 5);
		Shoes shoes3= new Shoes(1500, 38, Typee.SNEAKERS, Brand.NIKE, Color.RED,Gender.WOMAN , 5);
		Shoes shoes4= new Shoes(1000, 38, Typee.SNEAKERS, Brand.NEWBALANCE, Color.RED,Gender.WOMAN , 5);
		Shoes shoes5= new Shoes(500, 38, Typee.SANDALS, Brand.CITYLIFE, Color.RED,Gender.WOMAN , 5);
		Shoes shoes6= new Shoes(2000, 38, Typee.SANDALS, Brand.CITYLIFE, Color.RED,Gender.WOMAN , 5);
		Shoes shoes7= new Shoes(200, 38, Typee.SNEAKERS, Brand.NEWBALANCE, Color.RED,Gender.WOMAN , 5);
		Shoes shoes12= new Shoes(1000, 38, Typee.HIGHHEELS, Brand.PROVOQ, Color.RED,Gender.WOMAN , 5);
		// if gender is w add womanStock , if gender is m add manStock
		 womanStock.insert(shoes1);
		 womanStock.insert(shoes2); 
		womanStock.insert(shoes3); 
		womanStock.insert(shoes4); 
		womanStock.insert(shoes5); 
		womanStock.insert(shoes12);
	    womanStock.insert(shoes6);
	    womanStock.insert(shoes7);
	womanStock.searchy(womanStock.getRoot(),200,38,Typee.SNEAKERS);
	womanStock.insert(shoes1);
	womanStock.getFoundShoes().outputList();         //prices are big numbers to small numbers
	System.out.println("------------------");
	 womanStock.getFoundShoes().outputListBackward();   //prices are small numbers to big numbers
	 
	 if(womanStock.getFoundShoes().isEmpty()) {
		 System.out.println("No maching found");
	 }
	 
	
	 
   //    womanStock.inorder(womanStock.getRoot());
   //  System.out.println(womanStock.delete(shoes2));
   //  womanStock.inorder(womanStock.getRoot());
	}
 
}
