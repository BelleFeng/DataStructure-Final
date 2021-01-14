import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;


public class RankTree {
	
	public String name;
	public String urlCodeName;
	
	public RankTree(String name) throws UnsupportedEncodingException{
		this.name = name;
		urlCodeName = java.net.URLEncoder.encode(name , "UTF-8");
	}
	
	public String[][] Rank() throws IOException{
		//System.out.print(this.urlCodeName);
		ArrayList<Integer> countListPChome;
		ArrayList<Integer> countListMOMO;
		ArrayList<Integer> countListShopee;
		ArrayList<Integer> countListYahoo;
		
		WordCounter wordcounterPChome = new WordCounter("https://shopping.pchome.com.tw/");
		WordCounter wordcounterMOMO = new WordCounter("https://m.momoshop.com.tw/main.momo?mdiv=1099800000-bt_0_243_01-bt_0_243_01_e1&ctype=B");
		WordCounter wordcounterShopee = new WordCounter("https://mall.shopee.tw/");
		WordCounter wordcounterYahoo = new WordCounter("https://tw.buy.yahoo.com/");
		
		
		
		WebPage rootPagePChome = new WebPage("https://shopping.pchome.com.tw/", "PChome");
		WebTree treePChome = new WebTree(rootPagePChome);
		
		WebPage rootPageMOMO = new WebPage("https://www.momoshop.com.tw/main/Main.jsp", "MOMO");
		WebTree treeMOMO = new WebTree(rootPageMOMO);
		
		WebPage rootPageShopee = new WebPage("https://mall.shopee.tw/", "Shopee");
		WebTree treeShopee = new WebTree(rootPageShopee);
		
		WebPage rootPageYahoo = new WebPage("https://tw.buy.yahoo.com/" , "Yahoo");
		WebTree treeYahoo = new WebTree(rootPageYahoo);

		
		treePChome.root.addChild(new WebNode(new WebPage("https://ecshweb.pchome.com.tw/search/v3.3/?scope=all&sortParm=sale&sortOrder=dc&cateId=DYAW&q=" + urlCodeName, "ㅲ업")));
		treePChome.root.children.get(0).addChild(new WebNode(new WebPage("https://ecshweb.pchome.com.tw/search/v3.3/?scope=all&sortParm=sale&sortOrder=dc&cateId=DYAJ&q=" + urlCodeName, "Apple")));
		
		treeMOMO.root.addChild(new WebNode(new WebPage("https://www.momoshop.com.tw/search/searchShop.jsp?keyword=" + urlCodeName + "&searchType=1&cateLevel=0&cateCode=1100000000&curPage=1&_isFuzzy=0&showType=chessboardType", "ㅲ업")));
		treeMOMO.root.children.get(0).addChild(new WebNode(new WebPage("https://www.momoshop.com.tw/search/searchShop.jsp?keyword=" + urlCodeName + "&searchType=1&cateLevel=0&cateCode=1100000000&curPage=1&_isFuzzy=0&brand=Apple%20%E8%98%8B%E6%9E%9C&brandNo=20160808155618011&showType=chessboardType", "iPhone")));
		
		treeShopee.root.addChild(new WebNode(new WebPage("https://shopee.tw/mall/search?facet=2683&noCorrection=true&page=0&keyword=" + urlCodeName, "ㅲ업")));
				
		treeYahoo.root.addChild(new WebNode(new WebPage("https://tw.buy.yahoo.com/search/product?cid=4385943&p=" + urlCodeName, "ㅲ업")));
		treeYahoo.root.children.get(0).addChild(new WebNode(new WebPage("https://tw.buy.yahoo.com/search/product?cid=40057185&p=" + urlCodeName, "Apple")));
		
		    ArrayList<Keyword> keyword = new ArrayList<Keyword>(); 
		    double weight = Math.random();
		    Keyword keywords =new Keyword(name,weight);
		    keyword.add(keywords);
			
			System.out.print("PChome");
			countListPChome = wordcounterPChome.countKeyword(name);
			System.out.println();		
			treePChome.setPostOrderScore(keyword);
			
			try {
				System.out.print("MOMO");
				countListMOMO = wordcounterMOMO.countKeyword(name);
				System.out.println();
				treeMOMO.setPostOrderScore(keyword);
			}catch (IOException e) {
				System.out.println();
				System.out.println("It can't work.");
			}
			
			System.out.print("Shopee");
			countListShopee = wordcounterShopee.countKeyword(name);
			System.out.println();
			treeShopee.setPostOrderScore(keyword);
			
			System.out.print("Yahoo");
			countListYahoo = wordcounterYahoo.countKeyword(name);
			System.out.println(); 
			treeYahoo.setPostOrderScore(keyword);
			
			
			double x = treePChome.root.nodeScore;
			double y = treeMOMO.root.nodeScore;
			double z = treeShopee.root.nodeScore;
			double a = treeYahoo.root.nodeScore;
		
			double [] score = new double[4];
			score[0] = Math.max(Math.max(x, y), Math.max(z, a));
			score[1] = Math.min(Math.max(x, y), Math.max(z, a));
			score[2] = Math.max(Math.min(x, y), Math.min(z, a));
			score[3] = Math.min(Math.min(x, y), Math.min(z, a));
			
			
		    
			String[][] retVal = new String[4][2];

            for (int i = 0; i <score.length; i++) {
                double j = score[i];
                if (j == x) {
                    String website = "PChome: ";
                    String url = wordcounterPChome.urlStr;
                    retVal[i][0] = website;
                    retVal[i][1] = url;
                    x = 1;
                } else if (j == y) {
                	String website = "MOMO: ";
                    String url = wordcounterMOMO.urlStr;
                    retVal[i][0] = website;
                    retVal[i][1] = url;
                    y = 1;
                } else if (j == z) {
                	String website = "Shopee: ";
                    String url = wordcounterShopee.urlStr;
                    retVal[i][0] = website;
                    retVal[i][1] = url;
                    z = 1;
                } else if (j == a) {
                	String website = "Yahoo: ";
                    String url = wordcounterShopee.urlStr;
                    retVal[i][0] = website;
                    retVal[i][1] = url;
                    a = 1;
                }
            }

            
			return retVal;
	}

}
