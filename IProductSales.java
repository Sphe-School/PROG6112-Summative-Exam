public interface IProductSales 
{
    int GetTotalProductsSold(int [][] ProductSales);
    double GetAverageProductSold(int [][] ProductSales);
    String GetMostPopularProduct();
}