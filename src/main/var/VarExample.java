package main.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VarExample {
    public static void main(String[] args) {
        // Example 1: Inference with primitive types
        var number = 10; // The compiler infers the type as int
        System.out.println("Number: " + number);

        // Example 2: Inference with strings
        var message = "Hello, Java"; // The compiler infers the type as String
        System.out.println("Message: " + message);

        // Example 3: Inference with collections
        var list = new ArrayList<String>(); // The compiler infers the type as ArrayList<String>
        list.add("Java");
        list.add("Type Inference");
        for (var item : list) { // The compiler infers the type as String
            System.out.println("List item: " + item);
        }

        // Example 4: Inference in loops
        var numbers = List.of(1, 2, 3, 4, 5); // The compiler infers the type as List<Integer>
        for (var num : numbers) { // The compiler infers the type as Integer
            System.out.println("Number in list: " + num);
        }

        // Example 5: Inference with maps
        var map = new HashMap<String, Integer>(); // The compiler infers the type as HashMap<String, Integer>
        map.put("One", 1);
        map.put("Two", 2);
        for (var entry : map.entrySet()) { // The compiler infers the type as Map.Entry<String, Integer>
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Note: `var` can only be used for local variables
        // The following declarations are not allowed:
        // var x; // Error: cannot use 'var' on variable without initializer
        // var getNumber() { return 10; } // Error: 'var' not allowed in return type
    }
}
