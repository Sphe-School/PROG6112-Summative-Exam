public class ProductSales implements IProductSales
{
    public int GetTotalProductSold(int [][] ProductSales)
    {
        int total = 0;
        for (int row = 0; row < ProductSales.length; row++)
        {
            for (int col = 0; col < ProductSales[row].length; col++)
            {
                total = total + ProductSales[row][col];
            }
        }
        return total;

        public GetAverageProductSold(int [][] ProductSales)
        {
            int total = GetTotalProductSold(ProductSales);
            int count = 0;

            for (int row = 0; row < ProductSales.length; row++)
            {
                for (int col = 0; col < ProductSales[row].length; col++)
                {
                    count++;
                }
            }
            return (double) total / count;
        }
        public GetMostPopularProduct()
        {
            System.out.println();
        }
    }
}