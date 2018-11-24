package OnlineStockTradeCommandPattern;

public class SellStockOrder implements Command
{
	private StockTrade stock;
	
	public SellStockOrder(StockTrade stock) { this.stock = stock; }
	public void execute() { stock.sell(); }
}
