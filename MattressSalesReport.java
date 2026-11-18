public class MattressSalesReport
{ 
    public static void main(String[] orgs)
    {
        int [][] mattressSales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        int [] allSales = new int [9];
        int index = 0;

        System.out.println("PRODUCT SALE REPORT - 2026");

        for (int row = 0; row < mattressSales.length; row++)
        {
            System.out.println("Month" + (row + 1));
            for (int col = 0; col < mattressSales[row].length; col++)
            {
                System.out.println("Sales" + (col + 1) + ":" + mattressSales[row][col]);
                allSales[index] = mattressSales[row][col];
                index++;
            }
            System.out.println();
        }
        int total = 0;
        for (int i = 0; i < allSales.length; i++)
        {
            total = total + allSales [i];
        }
        double average = (double) total / allSales.length;

        System.out.println("TOTAL PRODUCT SALES: " + total);
        System.out.println("AVERAGE PRODUCT SALES: " + average);
        System.out.println("MOST POPULAR PRODUCT: Cozy Nights Monarch (25)");

    }
}