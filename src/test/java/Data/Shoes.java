package Data;

public class Shoes {
 private Color color;
 private Brand brand;
 private Typee type;
 private Gender gender;
 private int size,quantity,price;
 private int buyedquantity;

 



public Shoes(int price, int size,Typee type,Brand brand,Color color, Gender gender, int quantity) {
	super();
	this.color = color;
	this.brand = brand;
	this.type = type;
	this.gender = gender;
	this.size = size;
	this.quantity = quantity;
	this.price = price;
}





public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}

public Brand getBrand() {
	return brand;
}

public void setBrand(Brand brand) {
	this.brand = brand;
}

public Typee getType() {
	return type;
}

public void setType(Typee type) {
	this.type = type;
}

public Gender getGender() {
	return gender;
}

public void setGender(Gender gender) {
	this.gender = gender;
}

public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}


@Override
public String toString() {
	return "Shoes [gender=" + gender + ", size=" + size + ", type=" + type + ", brand=" + brand + ", color=" + color
			+ ", quantity=" + quantity + ", price=" + price + "]";
}

public void buyShoes(Shoes shoes, int buyedquantity) {
	if(shoes.getQuantity()>0) 
	shoes.setQuantity(shoes.getQuantity() - buyedquantity);
	else
		System.out.println("There is no shoe in stock ");
}
  
 public int getBuyedquantity() {
	return buyedquantity;
}


public void setBuyedquantity(int buyedquantity) {
	this.buyedquantity = buyedquantity;
}


public boolean searchShoes( int price,int size,Typee type ) {
	 Shoes shoes = this;
	if(shoes.size==size && shoes.type==type && shoes.price<=price ) {
		return true;
	}
	
	return false;
		 
 }
 
 public boolean searchShoes(int price,int size, Typee type, Brand brand  ,Color color ) {
	 Shoes shoes = this;
	
	if(shoes.size==size &&shoes.color==color && shoes.brand==brand  && shoes.type==type && shoes.price<=price) {
		System.out.println(shoes.toString());
		return true;
	}
		 
	  System.out.println("Its not found");
	return false;
		 
 }


 
 
 public boolean searchShoes(int price,int size,Typee type,Color color) {
	 Shoes shoes = this;
	if(shoes.size==size && shoes.type==type && shoes.price<=price && shoes.color==color) {
		return true;
	}
	
	return false;
		 
 }
 
 public boolean searchShoes(int price,int size,Typee type , Brand brand) {
	 Shoes shoes = this;
	if(shoes.size==size && shoes.type==type && shoes.price<=price && shoes.brand==brand ) {
		return true;
	}
	
	return false;
		 
 }
 
 

 
// linked liste sepete eklenen ayakkabilar konulur linked listten bu satin alinan ayakkabilarin quantitysi 1 eksilir
// bir link list sepet digeri ise quantitysi 0 olan binary treeden silinen ayakkabilar
}


