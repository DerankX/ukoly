/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subnetcli;
import java.util.Scanner;
/**
 *
 * @author Jirka
 */
public class Subnetcli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Zadej adresu.");
        System.out.println("např: 192.168.0.0/24");
        String IPadresa = myObj.nextLine();
        Network IP = new Network(IPadresa);
        IP.view();
    }
    
}
