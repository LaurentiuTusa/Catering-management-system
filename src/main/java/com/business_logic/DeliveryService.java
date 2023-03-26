package com.business_logic;

import com.data.ImportData;
import com.view.AdministratorView;
import com.view.ClientView;
import com.view.NewProductView;
import com.view.ReportView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

import static com.data.ImportData.getProduct;
import static java.util.stream.Collectors.toList;

/**
 * Class DeliveryService is responsible for implementing all the functional methods from the DeliveryService interface
 */

public class DeliveryService implements IDeliveryServiceProcessing{
    HashMap<String, MenuItem> map;
    List<MenuItem> productList;
    List<JRadioButton> radioButtons;
    List<MenuItem> selectedProducts;
    Map<Order, List<MenuItem>> orderMap;
    static List<MenuItem> filterList;

    public DeliveryService(HashMap<String, MenuItem> map, Map<Order, List<MenuItem>> orderMap) {
        this.map = map;
        this.productList = ImportData.getList();
        filterList = productList;
        this.radioButtons = new ArrayList<>();
        this.selectedProducts = new ArrayList<>();
        this.orderMap = orderMap;
    }

    /**
     * Add product
     * <pre>
     *     GUI textfields have correct values
     * </pre>
     * @param adminView for input from GUI
     */
    @Override
    public void addProduct(AdministratorView adminView) {
        //verify input and add to map
        System.out.println("Initial list size: "+ productList.size());
        //System.out.println(map.get("Beef Stock" + " "));//all of them have space

        NewProductView newProductView = new NewProductView();

        class ExecuteAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    assert newProductView.getTextField1() != null;
                    assert newProductView.getTextField2() != null;
                    assert newProductView.getTextField3() != null;
                    assert newProductView.getTextField4() != null;
                    assert newProductView.getTextField5() != null;
                    assert newProductView.getTextField6() != null;
                    assert newProductView.getTextField7() != null;
                    if(!(map.containsKey(newProductView.getTextField1() + " "))){

                        map.put(newProductView.getTextField1() + " ", new BaseProduct(newProductView.getTextField1() + " ", Double.parseDouble(newProductView.getTextField2()), Integer.parseInt(newProductView.getTextField3()), Integer.parseInt(newProductView.getTextField4()), Integer.parseInt(newProductView.getTextField5()), Integer.parseInt(newProductView.getTextField6()), Integer.parseInt(newProductView.getTextField7())));
                        productList.add(map.get(newProductView.getTextField1() + " "));

                        adminView.setMsg("Add successful");
                        System.out.println("New list size: "+ productList.size());
                        System.out.println("New map size: "+ map.size());
                    }
                    else adminView.setMsg("Product already exists");
                } catch (Exception e){
                    System.out.println("Can't add item");
                    e.printStackTrace();
                } finally {
                    newProductView.dispose();
                }
            }
        }
        newProductView.Execute(new ExecuteAction());
    }

    /**
     * Modify product
     * <pre>
     *     correct input is provided in the textfields
     * </pre>
     * <post>
     *     the item is modified and stored in the list
     * </post>
     * @param adminView for input from GUI
     */
    @Override
    public void modifyProduct(AdministratorView adminView) {
        System.out.println("Initial list size: "+ productList.size());
        //System.out.println(map.get("Beef Stock" + " "));//all of them have space

        NewProductView newProductView = new NewProductView();

        class ExecuteAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    assert newProductView.getTextField1() != null;
                    assert newProductView.getTextField2() != null;
                    assert newProductView.getTextField3() != null;
                    assert newProductView.getTextField4() != null;
                    assert newProductView.getTextField5() != null;
                    assert newProductView.getTextField6() != null;
                    assert newProductView.getTextField7() != null;
                    assert map.size()>0;
                    assert productList.size()>0;
                    MenuItem b = map.get(newProductView.getTextField1() + " ");
                    System.out.println(b.toString());
                    productList.remove(b);
                    b.update(Double.parseDouble(newProductView.getTextField2()), Integer.parseInt(newProductView.getTextField3()), Integer.parseInt(newProductView.getTextField4()), Integer.parseInt(newProductView.getTextField5()), Integer.parseInt(newProductView.getTextField6()), Integer.parseInt(newProductView.getTextField7()));
                    map.replace(newProductView.getTextField1() + " ", b);
                    productList.add(b);
                    assert map.size()>0;
                    System.out.println(map.get(newProductView.getTextField1() + " "));
                    adminView.setMsg("Modification successful");
                    System.out.println("New list size: "+ productList.size());
                } catch (NullPointerException e){
                    adminView.setMsg("Item does not exist");
                    e.printStackTrace();
                } finally {
                    newProductView.dispose();
                }
            }
        }
        newProductView.Execute(new ExecuteAction());
    }

    /**
     * Delete product
     * <pre>
     *     at least 1 item is selected
     * </pre>
     * <post>
     *     item(s) are removed from the list
     * </post>
     * @param adminView for output label of success operation for GUI
     */
    @Override
    public void deleteProduct(AdministratorView adminView) {
        assert adminView.getTable().getSelectedRowCount() > 0;

        int len = adminView.getTable().getSelectedRowCount();
        int[] arr = adminView.getTable().getSelectedRows();
        assert arr.length>0;
        System.out.println("len = " + len);
        for(int x = len-1; x>=0; x--){
            int f = arr[x];
            System.out.println(f);
      //      adminView.getTable().remove(f);
            map.remove(productList.get(f).getTitle());
            productList.remove(f);
        }
        adminView.getTable().clearSelection();
    }

    /**
     * Serializes the Order fields
     * <pre>
     *     productList contains al the data that must be serialized
     * </pre>
     * <post>
     *     data is serialized entirely
     * </post>
     * @param or is the Order insantce that needs to be serialized
     */
    public void serializeOrderBody(Order or) {
//        try {
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Order" + or.getOrdeId() + ".txt"), StandardCharsets.UTF_8));
//            //bw.write();
//            bw.newLine();
//           // bw.write();
//            bw.newLine();
//           // bw.write();
//            bw.newLine();
//            bw.flush();
//            bw.close();
//        } catch (IOException e) {
//            System.out.println("Unable to save orderBody");
//            e.printStackTrace();
//        }
        try {
            FileOutputStream fileOut = new FileOutputStream("Order_" + or.getOrdeId() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(or);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Unable to save orderBody");
            e.printStackTrace();
        }
    }

    /**
     * Serializes list of products in this order
     * <pre>
     *     productList contains al the data that must be serialized
     * </pre>
     * <post>
     *     data is serialized entirely
     * </post>
     * @param nr - describes the name of the file for serialisation
     * @param selectedProducts - the list of products in this order
     */
    public void serializeOrderList(int nr, List<MenuItem> selectedProducts){
        try {
            FileOutputStream fos = new FileOutputStream("Order_" + nr + "List.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(selectedProducts);
            oos.close();
            fos.close();
        } catch (IOException ioe)
        {
            System.out.println("Unable to save orderList");
            ioe.printStackTrace();
        }
    }

    /**
     * Serializes the list of products and composite products
     * <pre>
     *     productList contains al the data that must be serialized
     * </pre>
     * <post>
     *     data is serialized entirely
     * </post>
     * @param adminView - for input and output in GUI
     */
    @Override
    public void serializeChanges(AdministratorView adminView) {
        try {
            assert productList.size()>0;
            FileOutputStream fileOut = new FileOutputStream("products.csv");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.flush();
            out.close();
            fileOut.close();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("products.csv"), StandardCharsets.UTF_8));
            bw.write("Title,Rating,Calories,Protein,Fat,Sodium,Price");
            bw.newLine();
            for (MenuItem p:productList) {
                bw.write(p.objToString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            adminView.setMsg("Data saved!");
            showTable(adminView);
        } catch (IOException e) {
            System.out.println("Unable to save all data");
            e.printStackTrace();
        }
    }

    /**
     * populates JTable
     * @param adminView - output in GUI
     */
    public void showTable(AdministratorView adminView){
        String[] columnNames = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        Object data[][] = new Object[productList.size()][];
        int row = 0;
        for (MenuItem c:productList) {
            data[row] = new Object[]{c.getTitle(), c.getRating(), c.getCalories(), c.getProtein(), c.getFat(), c.getSodium(), c.getPrice()};
            row++;
        }
        adminView.displayTable(data, columnNames);

    }

    /**
     * creates a compound product
     * <pre>
     *     textFields in GUI are NOT empty and contain correct values
     * </pre>
     *
     * <post>
     *     compound product is created with correct computaions
     * </post>
     * @param adminView - input and output for GUI
     */
    @Override
    public void createCompoundProduct(AdministratorView adminView) {
        try{
            String title ="nothing is written";
            double rating = 0.0;
            int cal = 0, protein = 0, fat = 0, sodium = 0, price = 0;
            int len = adminView.getTable().getSelectedRowCount();
            for (int x:adminView.getTable().getSelectedRows()) {
                rating += productList.get(x).getRating();
                cal += productList.get(x).getCalories();
                protein += productList.get(x).getProtein();
                fat += productList.get(x).getFat();
                sodium += productList.get(x).getSodium();
                price += productList.get(x).getPrice();
            }
            assert adminView.getComposedTextField() != null;
            title = adminView.getComposedTextField();
            rating = rating/len;
            CompositeProduct c = new CompositeProduct(title, rating, cal, protein, fat, sodium, price);
            productList.add(c);
            serializeChanges(adminView);

            adminView.setMsg("Composite created");
            System.out.println(c.price);
            assert c.price>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * time interval of the orders
     * <pre>
     *     textFields in GUI are NOT empty
     *     textFields have an integer
     * </pre>
     * <post>
     *     the filtered clients are displayed, or a message for no clients
     * </post>
     * @param reportView - input and output for GUI
     */
    @Override
    public void reprot1(ReportView reportView) {
        try{assert reportView.getTime1() != null;
            assert reportView.getTime2() != null;
            assert Integer.parseInt(reportView.getTime1()) >= 0 && Integer.parseInt(reportView.getTime1()) <24;
            assert Integer.parseInt(reportView.getTime2()) > 0 && Integer.parseInt(reportView.getTime2()) <=24;
            reportView.refreshTextArea1();

            int min = Integer.parseInt(reportView.getTime1());
            int max = Integer.parseInt(reportView.getTime2());

            List<Order> results = orderMap.keySet().stream()
                    .filter(t -> t.getOrderDate().getHours() < max && t.getOrderDate().getHours() > min)
                    .collect(toList());

            if(results.size() != 0){
                results.stream()
                        .forEach( t-> reportView.setTextArea1(t.bodyToString() + "\n"));
            } else{
                reportView.refreshTextArea1();
                reportView.setTextArea1("no client\n");
            }

        } catch (NumberFormatException e) {
            reportView.refreshTextArea1();
            reportView.setTextArea1("Wrong inputs");
            e.printStackTrace();
        }
    }

    @Override
    public void reprot2(ReportView reportView) {
    }

    /**
     * reports clients that have ordered more than the number specified in the GUI
     * <pre>
     *     textFields in GUI are NOT empty
     *     textFields have an integer
     * </pre>
     * <post>
     *     the filtered clients are displayed, or a message for no clients
     * </post>
     * @param reportView - input and output for GUI
     */
    @Override
    public void reprot3(ReportView reportView) {
        try {assert reportView.getMoreThanTimes_3() != null;
            reportView.refreshTextArea1();
            int timesHigher = Integer.parseInt(reportView.getMoreThanTimes_3());
//             = new ArrayList<>();
            Map<String, Integer> numberTimes = new HashMap<>();
            for (Order v: orderMap.keySet()) {
                numberTimes.put(v.getClientName(), 0);
                }

            for (Order v: orderMap.keySet()) {
                int oldval = numberTimes.get(v.getClientName());
                numberTimes.replace(v.getClientName(), oldval + 1);
            }

//            for (String s: numberTimes.keySet()) {
//                if(numberTimes.get(s) >= timesHigher){
//                    results.add(s);
//                }
//            }

            List<String> results = numberTimes.keySet().stream()
                    .filter(t-> numberTimes.get(t) >= timesHigher)
                    .collect(toList());

            if(results.size() != 0) {
                results.stream()
                        .forEach (t -> reportView.setTextArea1("client name: '" + t + "' has ordered " + timesHigher + " or more times\n"));

            } else{
                reportView.refreshTextArea1();
                reportView.setTextArea1("no client has ordered " + timesHigher + " times\n");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reprot4(ReportView reportView) {
    }

    /**
     * searches for products, based on up to 7 filters
     * the products are shown as radioButtons
     * <pre>
     *     GUI textfilds have valid data
     * </pre>
     * <post>
     *     the items that pass the filters are displayed as radio buttons
     * </post>
     * @param clientView - input and output for GUI
     */
    @Override
    public void searchProduct(ClientView clientView) {

        filterList = productList;
        try {
            if (!(clientView.getTextField1().equals(""))) {
                filterList = filterList.stream()
                        .filter(t -> t.getTitle().contains((clientView.getTextField1())))
                        .collect(toList());
            }
            if (!(clientView.getTextField2().equals(""))) {
                filterList = filterList.stream()
                        .filter(t -> t.getRating() >= Double.parseDouble(clientView.getTextField2()))
                        .collect(toList());
            }
            if (!(clientView.getTextField3().equals(""))) {
                filterList = filterList.stream()
                        .filter(t -> t.getCalories() <= Integer.parseInt(clientView.getTextField3()))
                        .collect(toList());
            }
            if (!(clientView.getTextField4().equals(""))) {
                filterList = filterList.stream()
                        .filter(t -> t.getProtein() >= Integer.parseInt(clientView.getTextField4()))
                        .collect(toList());
            }
            if (!(clientView.getTextField5().equals(""))) {
                filterList = filterList.stream()
                        .filter(t -> t.getFat() <= Integer.parseInt(clientView.getTextField5()))
                        .collect(toList());
            }
            if (!(clientView.getTextField6().equals(""))) {
                filterList = filterList.stream()
                        .filter(t -> t.getSodium() <= Integer.parseInt(clientView.getTextField6()))
                        .collect(toList());
            }
            if (!(clientView.getTextField7().equals(""))) {
                filterList = filterList.stream()
                        .filter(t -> t.getPrice() <= Integer.parseInt(clientView.getTextField7()))
                        .collect(toList());
            }
        } catch (Exception e) {
            System.out.println("Wrong input for search");
            e.printStackTrace();
        }
        System.out.println(filterList.size());
        System.out.println(productList.size());
        clientView.clearShowPanel();
        if(!(radioButtons.isEmpty()))
            radioButtons.clear();

        filterList.forEach(v ->
        {   //show radiobuttons
            radioButtons.add(clientView.showItem(v.objToString()));
        });
    }

    /**
     * Creates an order based on the selected items
     * <pre>
     *     item(s) are selected in order to be processed
     * </pre>
     * <post>
     *     order is serialized
     * </post>
     * @param clientView - input and output for GUI
     * @param username - saves the username for the order creation
     */
    @Override
    public void createOrder(ClientView clientView, String username) {
        Order or = new Order(orderMap.size()+1, username, new Date()/*, selectedProducts*/);
        orderMap.put(or, selectedProducts);
        System.out.println("id: " + or.getOrdeId() + " Username: " + username + " Date: " + or.getOrderDate() + "\nProducts:");
        orderMap.get(or).forEach(d -> {
            System.out.println(d.objToString());
        });

        assert selectedProducts.size()>0;
        System.out.println("price: " + or.cost(selectedProducts));
        ImportData.exportData(selectedProducts, or);
        //serialize the order
        serializeOrderBody(or);
        serializeOrderList(or.getOrdeId(), selectedProducts);
        selectedProducts.clear();
        clientView.setMsg("Order created!");
    }

    /**
     * prepares the selected items for the order creation
     * @param clientView - input and output for GUI
     */
    @Override
    public void addItemToOrder(ClientView clientView) {
        radioButtons.forEach(r ->
        {
            if(r.isSelected()){
                selectedProducts.add(getProduct(r.getText()));
            }
        });
        System.out.println(selectedProducts.size());
        clientView.setMsg("Items added!");
    }

    /**
     * enables the user to see the currently selected items
     * @param clientView- input and output for GUI
     */
    @Override
    public void viewOrder(ClientView clientView) {
        clientView.clearShowPanel();
        selectedProducts.forEach(s ->
        {
            clientView.showList(s);
        });
    }
}
