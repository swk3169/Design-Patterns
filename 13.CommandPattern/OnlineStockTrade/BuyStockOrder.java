package OnlineStockTradeCommandPattern;

public class BuyStockOrder implements Command
{
	private StockTrade stock;
	
	public BuyStockOrder(StockTrade stock) { this.stock = stock; }
	public void execute() { stock.buy(); }
}
