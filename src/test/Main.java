package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//List<Category> categories = inputCategory();
		System.out.println("Enter a tag:");
		String tag = sc.nextLine();
		List<Product>  products   = findByTag(tag, inputProduct());
		Collections.sort(products,new Comparator<Product>() {
			@Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice() > o2.getPrice()) {
                	return -1;
                }else if (o1.getPrice() < o2.getPrice()) {
					return 1;
				}else {
					return o1.getName().compareToIgnoreCase(o2.getName());
				}
            }
		});
		for (Product product : products) {
			System.out.println(product.getPrice()+ " , "+product.getName());
		}
	}

	
	
	private static List<Product> findByTag(String categoryTag,List<Product> arr) {
		List<Product> result = new ArrayList<>();
		for (Product item : arr) {
			if(item.getCategoryTag().equals(categoryTag)) {
				result.add(item);
			}
		}
		return result;
	}
	private static List<Category> inputCategory() {
		List<Category> categories = new ArrayList<>();
		Category category1 = new Category();
		category1.setName("may tinh");
		category1.setTag("mt");
		categories.add(category1);
		Category category2 = new Category();
		category2.setName("dien lanh");
		category2.setTag("dl");
		categories.add(category2);
		return categories;
	}
	private static List<Product> inputProduct() {
		List<Product> result = new ArrayList<>();
		Product product1 = new Product();
		product1.setName("may tinh xach tay a");
		product1.setCategoryTag("mt");
		product1.setPrice(12.0);
		result.add(product1);
		Product product2 = new Product();
		product2.setName("laptop X");
		product2.setCategoryTag("mt");
		product2.setPrice(13.0);
		result.add(product2);
		Product product3 = new Product();
		product3.setName("pc 2");
		product3.setCategoryTag("mt");
		product3.setPrice(13.0);
		result.add(product3);
		Product product4 = new Product();
		product4.setName("ultrabook EZ");
		product4.setCategoryTag("mt");
		product4.setPrice(16.0);
		result.add(product4);
		Product product5 = new Product();
		product5.setName("tu lanh e");
		product5.setCategoryTag("dl");
		product5.setPrice(11.5);
		result.add(product5);
		Product product6 = new Product();
		product6.setName("dieu hoa nhiet do b");
		product6.setCategoryTag("dl");
		product6.setPrice(12.0);
		result.add(product6);
		return result;
	}
}
