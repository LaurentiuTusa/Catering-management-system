package com.data;

import com.business_logic.BaseProduct;
import com.business_logic.MenuItem;
import com.business_logic.Order;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImportData {

    Path path = Path.of("products.csv");
    Path pathOrder = Path.of("orders.txt");
    HashMap<String, MenuItem> map;
    static List<MenuItem> productList;

    Map<Order, List<MenuItem>> orderMap;
    Order or;
    List<MenuItem> orderContent;

    /**
     * Constructor that works also for data fetching
     * @param map map od data
     * @param orderMap map of orders
     * @throws IOException - file handling
     */
    public ImportData(HashMap<String, MenuItem> map, Map<Order, List<MenuItem>> orderMap) throws IOException {
        this.map = map;
        this.orderMap = orderMap;

        productList = Files.lines(path)
                .skip(1)
                .map( line -> {
                    return getProduct(line);
                }).collect(Collectors.toList());

        //System.out.println("Size of List productlist: " + productList.size());
        System.out.println("THis is the size of productlist right after streaming: " + productList.size());
        for (MenuItem p: productList) {
            map.put(p.getTitle(), p);
        }

        //System.out.println("Size of map: " + map.size());
        productList.clear();
        productList.addAll(getMap().values());
        //System.out.println("This is the size of list right after streaming: " + productList.size());

        int x=1;
        int ok = 1;
        while(ok == 1){
            try
            {
                FileInputStream fis = new FileInputStream("Order_" + x + ".ser");//orderBody
                ObjectInputStream ois = new ObjectInputStream(fis);
                FileInputStream fisList = new FileInputStream("Order_" + x + "List.ser");//orderBody
                ObjectInputStream oisList = new ObjectInputStream(fisList);
                ArrayList<MenuItem> aux;

                or = (Order) ois.readObject();
                aux = (ArrayList) oisList.readObject();
                orderMap.put(or, aux);

                ois.close();
                fis.close();
                fisList.close();
                oisList.close();
                x++;
            }
            catch (IOException ioe)
            {
                ok = 0;
               // ioe.printStackTrace();
                //return;
            }
            catch (ClassNotFoundException c)
            {
                System.out.println("Class not found");
                c.printStackTrace();
               //return;
            }
        }
//        orderList = Files.lines(pathOrder)
//                .map(line -> {
//                    return getOrder(line);
//                }).collect(Collectors.toList());
    }

    /**
     * method used for streams with lambda expressions
     * @param line line fetched from the .CSV
     * @return instance of type BaseProduct
     */
    public static BaseProduct getProduct(String line) {
        String[] fields = line.split(",");
        if(fields.length != 7)
            throw new RuntimeException("Invalid CSV line - " + line);
        return new BaseProduct(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), Integer.parseInt(fields[6]));
    }

//    public static Order getOrder(String line) {
//        String[] fields = line.split(",");
//        if(fields.length != 4)
//            throw new RuntimeException("Invalid CSV line - " + line);
//        return new Order(Integer.parseInt(fields[0]), fields[1], Date.parse(fields[2]), createProductListForOrder(fields[3]));
//    }

    public HashMap<String, MenuItem> getMap() {
        return map;
    }

    public Map<Order, List<MenuItem>> getOrderMap() {
        return orderMap;
    }

    public static List<MenuItem> getList()
    {
        return productList;
    }

//    public static List<Order> getOrderList() {
//        return orderList;
//    }

    /**
     * Creates the bill
     * @param list list of items
     * @param or the order details
     */
    public static void exportData (List<MenuItem> list, Order or) {
        try {
            FileWriter file = new FileWriter("Order_" + or.getClientName() + ".txt");
            StringBuilder str = new StringBuilder();
            str.append("OrderId: " + or.getOrdeId() +"\n");
            str.append("Date: " + or.getOrderDate()+"\n");
            str.append("Client username: " + or.getClientName()+"\n");
            str.append("Products:\n");
            list.forEach(l->{
                str.append(l.objToString()+"\n");
            });
            str.append("Total price: " + or.cost(list));
            file.write(str.toString());
            file.close();
        } catch (IOException e) {
            System.out.println("Unable to store data");
            e.printStackTrace();
        }
    }
}
