package OnlineStockTradeCommandPattern;

public class Client
{
	public static void main(String args[])
	{
		StockTrade stock = new StockTrade();
		BuyStockOrder buyOrder = new BuyStockOrder(stock);
		SellStockOrder sellOrder = new SellStockOrder(stock);
		Agent agent = new Agent();
		
		agent.placeCommand(buyOrder);
		agent.placeCommand(sellOrder);
	}
}
