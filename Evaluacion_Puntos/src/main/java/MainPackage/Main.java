/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author juanp
 */
public class Main {
    
    //--------------Conjuntos-----------------//
    
    public Lista union(Lista a, Lista b){
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
    
    public Lista interseccion(Lista a, Lista b){
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
    
    public Lista resta(Lista a,Lista b){
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
    
    public float promedio (Lista a){
        float num = 0;
        Nodo n = a.head;
        for (int i = a.c; i>=1; i--){
            num +=(float)n.getvalor();
            n=n.getnext();
        }
        return num/a.c;
    }
    
    public float moda(Lista a){
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
    
    public float mediana(Lista l){
        Lista r = l.clone();
        r.sort();
        Nodo n = r.head;
        for (int i = Math.floorDiv(r.c, 2); i>=1; i--){n=n.getnext();}
        return (float)n.getvalor();
    }
    
    public float mayor(Lista l){
        float num =0;
        Nodo n = l.head;
        for(int i = l.c; i>=1; i--){
            if ((float)n.getvalor()>num){num = (float)n.getvalor();}
            n=n.getnext();
        }
        return num;
    }
    
    public float menor(Lista l){
        float num = (float)l.head.getvalor();
        Nodo n = l.head;
        for(int i = l.c; i>=1; i--){
            if ((float)n.getvalor()<num){num = (float)n.getvalor();}
            n=n.getnext();
        }
        return num;
    }
    
    public void frecuencia(Lista l){
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
    
    //----------------calculadora------------------//
    
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
    
    
    
    
    //------------------sistemas numericos--------------//
    
    //public String
    
    
    
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        Lista lista = new Lista();
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(lista.head.getnext(), 9);
        Nodo n = lista.head;
        for (int i = lista.c; i>=1; i--) {
            System.out.println(n.getvalor());
            n=n.getnext();
        }
        
    }
    
    
}
