package inventoryrepo;

public class Item extends Object
{
	String _itemID;
	String _name;
	Category _category;
	String _description;
	int _price;
	int _quantity;
	boolean _onSale;
	String _sellerID;
	
	public static enum Category 
	{
		Electronics,
		Software,
		Books
	};
	
	
	public Item () {}
	
	public Item (String itemID, String name, Category category, String description,
				int price, int quantity, boolean onSale, String sellerID)
	{
		this.setItemID(itemID);
		this.setName(name);
		this.setCategory(category);
		this.setDescription(description);
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setOnSale(onSale);
		this.setSellerID(sellerID);
	}
	
	public String createNewItemGUID() {
		return "new Item GUID";
	}
	
	public void setItemID(String itemID){
		_itemID = itemID;
	}

	public String getItemID(){
		return _itemID;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	public void setCategory(Category category){
		_category = category;
	}
	
	public Category getCategory(){
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
	
	public void updateQuantity(int quant) {
		_quantity-=quant;
	}
	
	public boolean inStock()
	{
		return (this.getQuantity() > 0);
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
	
    public void editItem(String _itemID, String _name, Category _category, 
    					String _description, int _price, int _quantity, boolean _onSale) {
	
		
		if (_itemID != null) {	
		    this.setItemID(_itemID);
		}

		if (_name != null) {
		    this.setName(_name);
		}

		if (_category != null) {
            this.setCategory(_category);
        }

		if (_description != null) {
            this.setDescription(_description);
        }

		if (String.valueOf(_price) != null) {
            this.setPrice(_price);
        }

		if (String.valueOf(_quantity) != null) {
            this.setQuantity(_quantity);
        }

		if (String.valueOf(_onSale) != null) {
            this.setOnSale(_onSale);
        }
	}
}