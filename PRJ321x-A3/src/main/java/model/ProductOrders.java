package model;


/*Chứa thông tin của một sản phẩm trong đơn hàng*/
public class ProductOrders {

	private int orderId;
	private int productId;
	private int amountProduct; //Chất lương của sản phẩm lựa chọn
	private String nameProduct;
	
	public ProductOrders(int orderId, int productId, int amountProduct, String nameProduct) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.amountProduct = amountProduct;
		this.nameProduct = nameProduct;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	
	
}
