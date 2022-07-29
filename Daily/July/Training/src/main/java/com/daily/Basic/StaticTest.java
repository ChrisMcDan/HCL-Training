/*July 20, 2022*/

package com.daily.Basic;

class Product
{
    int prdId;
    String prdName;
    static String prdLocation = "NY";
    
    public Product(int prdId, String prdName)
    {
        // super(); is implied.
        this.prdId = prdId;
        this.prdName = prdName;
    }

    void print()
    {
        System.out.println(prdId  +  "   " + prdName + "  " + prdLocation);
    }
}

public class StaticTest
{
    {
        System.out.println("1");//instance block
    }
    static
    {
        System.out.println("2");//static block always execute first
    }
    {
        System.out.println("3");//instance block
    }
    public static void main(String[] args)
    {
        System.out.println("4");
        new StaticTest();
        Product p1 = new Product(111, "Laptop");
        Product p2 = new Product(112, "Chair");
        p1.print();
        p2.print();
    }
}