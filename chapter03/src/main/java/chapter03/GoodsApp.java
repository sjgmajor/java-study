package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods();
		//countOfGoods = 1
		
		camera.setName("Nikon");
		camera.setPrice(400000);
		camera.setCountStock(10);
		camera.setCountSold(20);
		
		// 정보은닉(데이터 보호) -> setprice 매서드로 데이터 오류를 방지할 수 있음
		camera.setPrice(-1);
		
		// countOfGoods 테스트
		Goods goods1 = new Goods();
		//countOfGoods = 2
		Goods goods2 = new Goods();
		//countOfGoods = 3
		Goods goods3 = new Goods();
		//countOfGoods = 4
		
		System.out.println(Goods.countOfGoods);

		camera.showInfo();
		camera.setPrice(500000);
		int discountPrice = camera.calDiscountPrice(0.5);
		System.out.println(discountPrice);
		
		
		Goods tv = new Goods("TV", 400000, 10, 20);
		tv.showInfo();
		
		
		
	}
		
}