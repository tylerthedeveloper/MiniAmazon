public interface InventoryInterface {

    Item viewItem(Item item);

    void editItem(Item item, String _itemID, String _name, Category _category, 
    			String _description, int _price, int _quantity, boolean _onSale);

    void addItem(Item item);

    void deleteItem(Item item);

}