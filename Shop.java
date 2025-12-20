package project2_OnlineShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Shop 
{
  private List<Product> products;
  public Shop()
  {
	  products=new ArrayList<>();
	  loadProducts();
  }
  private void loadProducts()
  {
	  products.add(new Product("P001","Laptop",54499.99,10));
	  products.add(new Product("P002","SmartPhone",599.99,20));
	  products.add(new Product("P003","HeadPhone",999.99,30));

  }
  public void displayProduct()
  {
	  System.out.println("Available Products..");
	  for(Product p:products)
	  {
		  p.displayProduct();
	  }
  }
  
  public Product findProductById(String id)
  {
	  for(Product p:products)
	  {
		  if(p.getId().equals(id))
		  {
			  return p;
		  }
	  }
	  return null;
  }
}











