package project2_OnlineShoppingCart;

public class User 
{
   private String name;
   private Cart cart;
   
   public User(String name)
   {
	   this.name=name;
	   this.cart=new Cart();
   }

   public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

   public Cart getCart() {
	return cart;
   }

   public void setCart(Cart cart) {
	this.cart = cart;
   }
   
}
