package project2_OnlineShoppingCart;

import java.util.Scanner;

public class OnlineShoppingApp {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Shop shop=new Shop();
		User user =new User("Niharika");
		
		boolean shopping=true;
		
		System.out.println("\n Welcome ,"+user.getName());
		while(shopping)
		{
			shop.displayProduct();
			System.out.println("\n1. Add to cart"
					+ "\n2. Remove from cart"
					+ "\n3. View"
					+ "\n4. CheckOut"
					+ "\n5. Exit ");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:{
				System.out.println("Enter product id to add: ");
				String productId=sc.nextLine();
				Product p=shop.findProductById(productId);
				
				if(null!=p)
				{
					System.out.println("Enter quantity to add: ");
					int quantity=sc.nextInt();
					sc.nextLine();
					user.getCart().addProduct(p, quantity);
				}
				else
				{
					System.out.println("Product not found!!!");
				}
				break;
			}
			case 2:{
				System.out.println("Enter product id: ");
				String removeId=sc.nextLine();
				
				System.out.println("Enter quantity to be removed :");
				int removeQty=sc.nextInt();
				sc.nextLine();
				
				user.getCart().removeProduct(removeId, removeQty);
				
			}break;
			case 3:
			{
				user.getCart().displayCart();
			}
			break;
			case 4:
				double cost=user.getCart().calculateTotalCost();
				System.out.println("Total Amount to be paid :$"+cost);
				System.out.println("Thank You For Shopping...!!!");
			break;
			case 5:
				shopping=false;
				break;
			default:
				System.out.println("Invalid choice .Please try again!!!");
			}
		}

	}

	
	
	
	
	
	
	
	
}
