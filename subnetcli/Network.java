/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subnetcli;
/**
 *
 * @author Jirka
 */





public class Network {
 /**
 * Deklarace Proměnných
 */
    private String ip;
    private int prefix;
    private String[] ipp;
    private String[] array;
    private String o1;
    private String o2;
    private String o3;
    private String o4;
    private int po;
    private int vm;
    private int vm2;
    private int mask;
    private int square;
    private int mok1;
    private int mok2;
    private int mok3;
    private int mok4;
    private int fh;
    private int lh1;
    private int lh2;
    private int lh3;
    private int lh4;
    private int ph;
    private int broadcast;
    private int cor;
    private String cor2;
    private String padded;
    private String mokbin1;
    private String mokbin2;
    private String mokbin3;
    private String mokbin4;
    private String obin1;
    private String obin2;
    private String obin3;
    private String obin4;
    private int oint1;
    private int oint2;
    private int oint3;
    private int oint4;
    private String fhbin;
    private String lhbin1;
    private String lhbin2;
    private String lhbin3;
    private String lhbin4;
    private String broadcastbin;
    
/**
 * konstruktor
 */
    public Network(String ip){          
        
        this.ip = ip;
        
    }
   /**
    * Rozzaření Ip adresy na oktety a prefix
    */
    public void splitip(){
        ipp = ip.split("\\/");
        array = ipp[0].split("\\.");
        o1 = array[0];
        o2 = array[1];
        o3 = array[2];
        o4 = array[3];
        prefix = Integer.parseInt(ipp[1]);
        oint1 = Integer.parseInt(o1);
        oint2 = Integer.parseInt(o2);
        oint3 = Integer.parseInt(o3);
        oint4 = Integer.parseInt(o4);
        obin1 = Integer.toBinaryString(oint1);
        obin2 = Integer.toBinaryString(oint2);
        obin3 = Integer.toBinaryString(oint3);
        obin4 = Integer.toBinaryString(oint4);
        obin1 = "00000000".substring(obin1.length()) + obin1;
        obin2 = "00000000".substring(obin2.length()) + obin2;
        obin3 = "00000000".substring(obin3.length()) + obin3;
        obin4 = "00000000".substring(obin4.length()) + obin4;
        
    }
    /**
     * výpočet masky
     */
    public void mask(){
        po = prefix / 8;
        vm = prefix % 8;
        vm2 = 8 - vm;
        square = (int) Math.pow(2, vm2);
        mask = 255 - (square - 1);
        
        if (po == 4){
         mok1 = 255;
         mok2 = 255;
         mok3 = 255;
         mok4 = 255;
     }
        else if(po == 3){
        mok1 = 255;
        mok2 = 255;
        mok3 = 255;
        mok4 = mask;
     }
        else if(po == 2){
        mok1 = 255;
        mok2 = 255;
        mok3 = mask;
        mok4 = 0;
     }
        else if(po == 1){
        mok1 = 255;
        mok2 = mask;
        mok3 = 0;
        mok4 = 0;
     }
        else if(po == 0){
        mok1 = mask;
        mok2 = 0;
        mok3 = 0;
        mok4 = 0;
     }
        mokbin1 = Integer.toBinaryString(mok1);
        mokbin2 = Integer.toBinaryString(mok2);
        mokbin3 = Integer.toBinaryString(mok3);
        mokbin4 = Integer.toBinaryString(mok4);
        mokbin1 = "00000000".substring(mokbin1.length()) + mokbin1;
        mokbin2 = "00000000".substring(mokbin2.length()) + mokbin2;
        mokbin3 = "00000000".substring(mokbin3.length()) + mokbin3;
        mokbin4 = "00000000".substring(mokbin4.length()) + mokbin4;
    }
    /**
     * Výpočet prvního hosta
     */
    public void first(){
        fh = Integer.parseInt(o4);
        fh = fh + 1;
        fhbin = Integer.toBinaryString(fh);
        fhbin = "00000000".substring(fhbin.length()) + fhbin;
        
    }
    /**
     * výpočet posledního hosta
     */
    public void last(){
        
        lh1 = Integer.parseInt(o1);
        lh2 = Integer.parseInt(o2);
        lh3 = Integer.parseInt(o3);
        lh4 = Integer.parseInt(o4);
        ph = 32 - prefix;
        ph = (int) Math.pow(2, ph);
        ph = ph - 2;
        
        if(po == 3){
            lh4 = ph;
    }
        else if(po == 2){
            lh3 = (ph / 256);
            lh4 = 254;
    }
        else if(po == 1){
            lh2 = lh2 + (ph / 65553);
            lh3 = 255;
            lh4 = 254;
    }
        else if(po == 0){
            lh1 = lh1 + (ph / 16777216);
            lh2 = 255;
            lh3 = 255;
            lh4 = 254;            
    }
        lhbin1 = Integer.toBinaryString(lh1);
        lhbin2 = Integer.toBinaryString(lh2);
        lhbin3 = Integer.toBinaryString(lh3);
        lhbin4 = Integer.toBinaryString(lh4);
        lhbin1 = "00000000".substring(lhbin1.length()) + lhbin1;
        lhbin2 = "00000000".substring(lhbin2.length()) + lhbin2;
        lhbin3 = "00000000".substring(lhbin3.length()) + lhbin3;
        lhbin4 = "00000000".substring(lhbin4.length()) + lhbin4;
    }
    /**
     * výpočet broadcastu
     */
    public void broadcast(){
        
        broadcast = lh4 + 1;
        broadcastbin = Integer.toBinaryString(broadcast);
        broadcastbin = "00000000".substring(broadcastbin.length()) + broadcastbin;
        
    }
    /**
     * Controla jestli je zadaná ip adresa korektní
     */
    public void cor(){
        if(po == 3){
            cor = Integer.parseInt(o4);
        }
        else if(po == 2){
            cor = Integer.parseInt(o3);
        }
        else if(po == 1){
            cor = Integer.parseInt(o2);
        }
        else if(po == 0 ){
            cor = Integer.parseInt(o1);
        }
        cor2 = Integer.toBinaryString(cor);
        padded = "00000000".substring(cor2.length()) + cor2;
        padded = padded.substring(vm);
        cor = Integer.parseInt(padded);

        
    }
    /**
     * výpis
     */
    public void view(){
        
        this.splitip();
        this.mask();
        this.first();
        this.last();
        this.broadcast();
        this.cor();
        
        if (cor == 0){
            
        System.out.println("Maska: " + mok1 + "." + mok2 + "." + mok3 + "." + mok4 + "  " + mokbin1 + "." + mokbin2 + "." + mokbin3 + "." + mokbin4 );
        System.out.println("Network: " + o1 + "." + o2 + "." + o3 + "." + o4 + "  " + obin1 + "." + obin2 + "." + obin3 + "." + obin4 );
        System.out.println("První Host: " + o1 + "." + o2 + "." + o3 + "." + fh + "  " + obin1 + "." + obin2 + "." + obin3 + "." + fhbin );
        System.out.println("Poslední host: " + lh1 + "." + lh2 + "." + lh3 + "." + lh4 + "  " + lhbin1 + "." + lhbin2 + "." + lhbin3 + "." + lhbin4 );
        System.out.println("Broadcast: " + lh1 + "." + lh2 + "." + lh3 + "." + broadcast + "  " + lhbin1 + "." + lhbin2 + "." + lhbin3 + "." + broadcastbin );
        System.out.println("Počet Hostů: " + ph);

        }
        else{
            
            System.out.println("špatné zadání");
            
        }
    }
    
}
