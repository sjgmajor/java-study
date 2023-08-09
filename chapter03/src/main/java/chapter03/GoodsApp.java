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
		
		System.out.println(
				"상품이름: " + camera.getName() + 
				", 가격: " + camera.getPrice() + 
				", 재고개수: " + camera.getCountStock() +
				", 팔린 개수: " + camera.getCountSold() );
	}
}