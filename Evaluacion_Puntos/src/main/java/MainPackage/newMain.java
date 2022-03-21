/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainPackage;

import mainpackage.Lista;
import mainpackage.Nodo;

/**
 *
 * @author juanp
 */
public class newMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[] n = new Object[]{1,2,3,4};
        Lista a = new Lista();
        a.addAll(n);
        n = new Object[]{5,6,7,8,9};
        Lista b = new Lista();
        b.addAll(n);
        Lista c = union(a, b);
        Nodo nodo = c.head;
        for(int i = c.c; i>=1; i--){
            System.out.println(nodo.getvalor());
            nodo=nodo.getnext();
        }
    }
    
    //--------------Conjuntos-----------------//
    
    public static Lista union(Lista a, Lista b){
        Nodo n1 = a.head;
        Nodo n2 = b.head;
        Lista r = new Lista();
        Lista s = new Lista();
        for (int i = a.c; i>=1; i--){
            boolean bol = true;
            for(int e = b.c; e>=1; e--){
                if(n1.getvalor()==n2.getvalor()){bol=false;break;}
                n2=n2.getnext();
            }
            if(bol){r.add(n1.getvalor());}
            else{s.add(n1.getvalor());}
            n1=n1.getnext();
        }
        n1 = a.head;
        n2 = b.head;
        for (int i = a.c; i>=1; i--){
            boolean bol = true;
            for(int e = b.c; e>=1; e--){
                if(n2.getvalor()==n1.getvalor()){bol=false;break;}
                n1=n1.getnext();
            }
            if(bol){r.add(n2.getvalor());}
            n2=n2.getnext();
        }
        n1=s.head;
        for(int i = s.c; i>=1; i--){
            r.add(n1.getvalor());
            n1=n1.getnext();
        }
        return r;
    }
    
    public static Lista interseccion(Lista a, Lista b){
        Nodo n1 = a.head;
        Nodo n2 = b.head;
        Lista r = new Lista();
        for (int i = a.c; i>=1; i--){
            boolean bol = false;
            for(int e = b.c; e>=1; e--){
                if(n1.getvalor()==n2.getvalor()){bol=true;break;}
                n2=n2.getnext();
            }
            if(bol){r.add(n1.getvalor());}
            n1=n1.getnext();
        }
        return r;
    }
    
    public static Lista resta(Lista a,Lista b){
        Nodo n1 = a.head;
        Nodo n2 = b.head;
        Lista r = new Lista();
        for (int i = a.c; i>=1; i--){
            boolean bol = true;
            for(int e = b.c; e>=1; e--){
                if(n1.getvalor()==n2.getvalor()){bol=false;break;}
                n2=n2.getnext();
            }
            if(bol){r.add(n1.getvalor());}
            n1=n1.getnext();
        }
        n1 = a.head;
        n2 = b.head;
        for (int i = a.c; i>=1; i--){
            boolean bol = true;
            for(int e = b.c; e>=1; e--){
                if(n2.getvalor()==n1.getvalor()){bol=false;break;}
                n1=n1.getnext();
            }
            if(bol){r.add(n2.getvalor());}
            n2=n2.getnext();
        }
        return r;
    }
    
    //-------------Punto 2 ------------//
    
    public static float promedio (Lista a){
        float num = 0;
        Nodo n = a.head;
        for (int i = a.c; i>=1; i--){
            num +=(float)n.getvalor();
            n=n.getnext();
        }
        return num/a.c;
    }
    
    public static float moda(Lista a){
        float n = 0;
        int cantult = 0;
        Nodo n1 = a.head;
        for(int i = a.c; i>=1; i--){
            Nodo n2 = a.head;
            int cant = 0;
            for(int e = a.c; e>=1; e--){
                if (n1.getvalor()==n2.getvalor()){cant++;}
                n2=n2.getnext();
            }
            if(cant>cantult){n=(float)n1.getvalor();cantult=cant;}
            n1=n1.getnext();
        }
        return n;
    }
    
    public static float mediana(Lista l){
        Lista r = l.clone();
        r.sort();
        Nodo n = r.head;
        for (int i = Math.floorDiv(r.c, 2); i>=1; i--){n=n.getnext();}
        return (float)n.getvalor();
    }
    
    public static float mayor(Lista l){
        float num =0;
        Nodo n = l.head;
        for(int i = l.c; i>=1; i--){
            if ((float)n.getvalor()>num){num = (float)n.getvalor();}
            n=n.getnext();
        }
        return num;
    }
    
    public static float menor(Lista l){
        float num = (float)l.head.getvalor();
        Nodo n = l.head;
        for(int i = l.c; i>=1; i--){
            if ((float)n.getvalor()<num){num = (float)n.getvalor();}
            n=n.getnext();
        }
        return num;
    }
    
    public static void frecuencia(Lista l){
        Lista lc = l.clone();
        Nodo n1 = lc.head;
        for (int i = lc.c; i>=1; i--){
            Nodo n2 = lc.head;
            int b = 0;
            for (int e = lc.c; e>=1; e--){
                if(n1.getvalor()==n2.getvalor()){lc.remove(n2);b++;i--;}
                n2=n2.getnext();
            }
            if(b>0){System.out.print("el numero "+(float)n1.getvalor()+" se repite "+b+" veces");}
            n1=n1.getnext();
        }
    }
    
    //---------------polinomios----------------//
    /*
    public float evaluar(Lista l){
        Nodo n = l.head;
        for (int i = l.c; i>=1; i--){
            
        }
    }
    */
    
    
    //----------------calculadora------------------//
    /**
    public Lista suma(Lista a, Lista b){
        Nodo na = a.tail;
        Nodo nb = b.tail;
        int i;
        if (a.c>b.c){i=a.c;}
        else{i=b.c;}
        int sum = 0;
        for (i=i; i>=0; i--){
            if(na!=null | nb!=null){
                
            }
        }
        
        
        
    }
    
    */
    
    
    //------------------sistemas numericos--------------//
    
    //public String
    
    
    
    
}
