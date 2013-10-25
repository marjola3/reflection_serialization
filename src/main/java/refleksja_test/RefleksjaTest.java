package refleksja_test;

import configuration.Connection;

/**
 * User: Mariola
 * Date: 25.10.13
 */
public class RefleksjaTest {
    public RefleksjaTest(String text){
        System.out.println("constructor: " + text);
    }

    public RefleksjaTest(String text, Integer i){
        System.out.println("constructor: " + text + " " + i);
    }

    public RefleksjaTest(Connection externalConnection){
        System.out.println(externalConnection.getConnectionUrl());
    }

    public void methodA(){
        System.out.println("methodA()");
    }

    public void methodB(int a, int b){
        System.out.println("methodB() " + a + " " + b);
    }
}
