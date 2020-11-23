import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		WebPage PChome = new WebPage("https://24h.pchome.com.tw/sign/mobile.htm","PChome");
		WebPage MOMO = new WebPage("https://www.momoshop.com.tw/category/LgrpCategory.jsp?l_code=1912900000&mdiv=1099700000-bt_0_997_11-bt_0_997_11_P101_2_e1&ctype=B","MOMO");
		WebPage Shopee = new WebPage("https://shopee.tw/mall/%E6%89%8B%E6%A9%9F%E5%B9%B3%E6%9D%BF%E8%88%87%E5%91%A8%E9%82%8A-cat.70","Shopee");
		WebPage Yahoo = new WebPage("https://tw.buy.yahoo.com/category/28507312","Yahoo");
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			String name = scanner.next();
			double weight = scanner.nextDouble();
			Keyword k = new Keyword(name, weight);
		}
	}
}
