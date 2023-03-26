package com;

import com.business_logic.*;
import com.view.LoginView;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
//OrderList trebuie facut map - done
//pune lista de la order ca si string(vezi cum o face el prin serializare) - done
//reporturile -done
//bill - done
//employee -nu
//javadoc -done
//assert -done
//SCHIMBA BASEPRODUCT CU MENUITEM  - done

public class Main {
    public static void main(String[] args) throws IOException {
        LoginPresenter loginPresenter = new LoginPresenter(new LoginView());
//        System.out.println("yes");
//        Date d = new Date();
//        System.out.println(d);
//        //d.setTime(12);
//        d.setHours(12);
//        System.out.println(d);
//        System.out.println(d.getHours());
//        Order a = new Order();
//        a.setOrderDate(new Date(101, 1, 5));
//        System.out.println(a.getOrderDate().before(new Date(101, 1, 10)));//returs TRUE
//        List<MenuItems> q = new ArrayList<>();
//        q.add(new CompositeProduct("menu1", 3,3,3,3,3,3));
//        q.add(new BaseProduct("abc", 2,2,2,2,2, 2));
//        for (MenuItems m: q) {
//            System.out.println(m.objToString());
//        }


//        System.out.println("am trecut");
//        Path path = Path.of("products.csv");
//        HashMap<String, BaseProduct> map = new HashMap<>();
//        List<BaseProduct> productList = Files.lines(path)
//                .skip(1)
//                .map( line -> {
//                    return getProduct(line);
//                }).collect(Collectors.toList());
//
//        System.out.println("Size of List productlist: " + productList.size());
//        for (BaseProduct p: productList) {
//            map.put(p.getTitle(), p);
//        }
//        System.out.println("Size of map: " + map.size());
//
//    }
//
//
//    private static BaseProduct getProduct(String line) {
//        String[] fields = line.split(",");
//        if(fields.length != 7)
//            throw new RuntimeException("Invalid CSV line - " + line);
//        return new BaseProduct(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), Integer.parseInt(fields[6]));
    }

}
