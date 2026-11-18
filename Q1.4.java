package test;

import java.beans.Transient;

import org.junit.test;
import static org.junit.assert.*;
import ProductSales.ProductSales;

public class ProductSalesTest
{
    @Test
    public void GetTotalProductSold()
    {
        int [][] mattressSales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        ProductSales sales = new ProductSales();
        int expectedTotal = 153;
        int actualTotal = sales.TotalSales(ProductSales);
        assertEquals(expectedTotal, actualTotal);
    }

    @Test 
    public void GetAverageProductSold()
    {
        int [][] mattressSales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        ProductSales sales = new ProductSales();
        double expectedAverage = 17;
        double actualAverage = sales.AverageSales(ProductSales);
        assertEquals(expectedAverage, actualAverage, 0.01);
    }
}