package project2_OnlineShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart 
{
private List<Product> products;

public Cart() {
	products=new ArrayList<>();
}
//add product
public void addProduct(Product product,int quantity)
{
	boolean found=false;
	for(Product p: products)
	{
	if(p.getId().equals(product.getId()))
	{
		p.setQuantity(p.getQuantity() +quantity);
		found=true;
		System.out.println(quantity +" "+p.getName()+" (s) added to your cart. New Quantity is "+p.getQuantity());
		break;
	}
	}
	if(!found)
	{
		product.setQuantity(quantity);
		products.add(product);
		System.out.println(quantity +" "+product.getName()+" (s) added to your cart .");
	}
}
public void removeProduct(String productId,int quantity)
{
	for(Product p: products)
	{
		if(p.getQuantity()>quantity)
		{
			p.setQuantity(p.getQuantity()- quantity);
			System.out.println(quantity+" "+p.getName()+" (s) removed from your cart.Remaining quantity is "+p.getQuantity());
		}
		else
		{
			products.remove(p);
			System.out.println(p.getName()+" removed from your cart !!!");
		}
		break;
	}
}

//display product
public void displayCart()
{
	System.out.println("Cart Items: ");
	for(Product p: products)
	{
		p.displayProduct();
	}
}

//calculate total cost
public double calculateTotalCost()
{
	double totalCost=0;
	for(Product p:products)
	{
		totalCost+=p.getPrice() * p.getQuantity();
	}
	return totalCost;
}


}






