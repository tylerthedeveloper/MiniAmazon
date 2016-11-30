
public class Transaction
{
	String _itemID;
	String _transactionID;
	String _name;
	Item.Category _category;
	String _description;
	int _price;
	int _quantity;
	boolean _onSale;
	String _sellerID;

/*	
	public static enum Category 
	{
		Electronics,
		Software,
		Books
	};
*/	
	
	//public Transaction (String transactionID, String name, Category category, String description, int price, int quantity, boolean onSale, String sellerID)
	public Transaction (Item item)
	{
		this.setItemID(item.getItemID());
		this.setTransactionID(createNewTransactionGUID());
		this.setName(item.getName());
		this.setCategory(item.getCategory());
		this.setDescription(item.getDescription());
		this.setPrice(item.getPrice());
		this.setQuantity(item.getQuantity());
		this.setOnSale(item.getOnSale());
		this.setSellerID(item.getSellerID());
	}
	
	public String createNewTransactionGUID() {
		return "new Trans GUID";
	}
	
	public void setItemID(String itemID){
		_itemID = itemID;
	}

	public String getItemID(){
		return _itemID;
	}
	
	public void setTransactionID(String transactionID){
		_transactionID = transactionID;
	}

	public String getTransactionID(){
		return _transactionID;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	public void setCategory(Item.Category category){
		_category = category;
	}
	
	public Item.Category getCategory(){
		return _category;
	}
	
	public void setDescription(String description){
		_description = description;
	}

	public String getDescription(){
		return _description;
	}
	
	public void setPrice(int price) {
		_price = price;
	}
	
	public int getPrice() {
		return _price;
	}
	
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}
	
	public int getQuantity() {
		return _quantity;
	}
	
	public void setOnSale(boolean onSale) {
		_onSale = onSale;
	}
	
	public boolean getOnSale() {
		return _onSale;
	}
	
	public void setSellerID(String sellerID) {
		_sellerID = sellerID;
	}
	
	public String getSellerID() {
		return _sellerID;
	}
}