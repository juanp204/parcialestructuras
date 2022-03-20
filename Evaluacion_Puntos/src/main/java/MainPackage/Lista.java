/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import interfa.LinkedList;
import interfa.LinkedListNode;
/**
 *
 * @author juanp
 */
public class Lista implements LinkedList {
    
    Nodo head=null;
    Nodo tail=null; 
    int c;

    @Override
    public boolean add(Object object) {
        Nodo n = new Nodo(object);
        if (head==null){
            head = n;
            c++;
            return true;
        }
        else if (tail==null){
            tail=n;
            head.setnext(tail);
            tail.setprev(head);
            c++;
            return true;
        }
        else if (tail!=null){
            tail.setnext(n);
            n.setprev(tail);
            tail=n;
            c++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean add(LinkedListNode node, Object object) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==null){return false;}
            if(n==node){
                Nodo o = new Nodo(object);
                o.setnext(n.getnext());
                n.getnext().setprev(o);
                n.setnext(o);
                o.setprev(n);
                c++;
                return true;
            }
            else{
                n=n.getnext();
            }
        }
        return false;
        
    }

    @Override
    public boolean addAll(Object[] objects) {
        try {
            for (Object o : objects){
            Nodo n = new Nodo(o);
            if (head==null){head=n;}
            else if(tail==null){
                head.setnext(n);
                n.setprev(head);
            }
            else{
                tail.setnext(n);
                n.setprev(tail);
                tail=n;
            }
            c++;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addAll(LinkedListNode node, Object[] objects) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==null){return false;}
            if(n==node){
                try {
                    for (Object o : objects){
                        Nodo e = new Nodo(o);
                        if(n.getnext()!=null){
                            e.setnext(n.getnext());
                            n.getnext().setprev(e);
                            n.setnext(e);
                            e.setprev(n);
                        }
                        if(n.getnext()==null){
                            n.setnext(e);
                            e.setprev(n);
                        }
                        n=e;
                        c++;
                    }
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            else{
                n=n.getnext();
            }
        }
        return false;
        
    }

    @Override
    public boolean addFirst(Object object) {
        Nodo n = new Nodo(object);
        if (head==null){
            head=n;
            c++;
            return true;
        }
        else if (head!=null){
            n.setnext(head);
            head.setprev(n);
            head=n;
            c++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean addLast(Object object) {
        Nodo n = new Nodo(object);
        if(head==null){
            head=n;
            c++;
            return true;
        }
        else if (tail==null){
            tail=n;
            head.setnext(tail);
            tail.setprev(head);
            c++;
            return true;
        }
        else if (tail!=null){
            tail.setnext(n);
            n.setprev(tail);
            tail=n;
            c++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        c=0;
        System.out.println("borrada con exito");
    }

    @Override
    public Lista clone() {
        Nodo n = head;
        Lista l = new Lista();
        for (int i = c; i>=1; i--){
            l.add(n.getvalor());
            n=n.getnext();
        }
        return l;
    }

    @Override
    public boolean contains(Object object) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if(n.getvalor()==object){
                return true;
            }
            n=n.getnext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Object[] objects) {
        boolean b = false;
        for (Object o : objects) {
            Nodo n = head;
            for (int i = c; i>=1; i--) {
                if(n.getvalor()==o){
                    b=true;
                }
            }
        }
        return b;
    }

    @Override
    public LinkedListNode nodeOf(Object object) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if(n.getvalor()==object){return n;}
            else{n=n.getnext();}
        }
        return null;
    }

    @Override
    public boolean isEquals(Object object) {
        return this==object;
    }

    @Override
    public boolean isEmpty() {
        return head == null & tail == null;
    }

    @Override
    public Object get() {
        return head.getvalor();
    }

    @Override
    public Object get(LinkedListNode node) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==node){return n.getvalor();}
            n=n.getnext();
        
        }
        return null;
    }

    @Override
    public Object getPrevious(LinkedListNode node) {
        Nodo n = tail;
        for (int i = c; i>=1; i--) {
            if (n==node){return n.getprev();}
            n=n.getprev();
        
        }
        return null;
    }

    @Override
    public Object getNext(LinkedListNode node) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==node){return n.getnext();}
            n=n.getnext();
        
        }
        return null;
    }

    @Override
    public Object getFirst() {
        return head.getvalor();
    }

    @Override
    public Object getLast() {
        return tail.getvalor();
    }

    @Override
    public boolean remove(Object object) { //wwwwwwwwaaaaaaeeeeeeeeeeeee
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if(n.getvalor()==object){
                n.getprev().setnext(n.getnext());
                n.getnext().setprev(n.getprev());
                n=null;
                c--;
                return true;
            }
            n=n.getnext();
        }
        return false;
    }

    @Override
    public boolean remove(LinkedListNode node) {
        Nodo n = head;
        if (head==node){
            head.getnext().setprev(null);
            head=head.getnext();
            c--;
            return true;
        }
        if (tail==node){
            tail.getprev().setnext(null);
            tail=tail.getprev();
            c--;
            return true;
        }
        for (int i = c; i>=1; i--) {
            if (n==node){
                n.getnext().setprev(n.getprev());
                n.getprev().setnext(n.getnext());
                n=null;
                c--;
                return true;
            }
            n=n.getnext();
        }
        return false;
    }

    @Override
    public boolean removeAll(Object[] objects) { //eeeeeeeeeeeeeee
        try {
            for (Object o : objects){
            Nodo n = head;
            for (int i = c; i>=1; i--) {
                if (n.getvalor()==o){
                    n.getnext().setprev(n.getprev());
                    n.getprev().setnext(n.getnext());
                    c--;
                }
                n=n.getnext();
            }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean retainAll(Object[] objects) {
        try {
            Nodo n = head;
            for (int i = c; i>=1; i--) {
                boolean b=true;
                for (Object o : objects){
                    if(n.getvalor()==o){
                    b=false;
                    }
                }
                if(b){
                    if(n==head){
                        head.getnext().setprev(null);
                        head=head.getnext();
                        c--;
                    }
                    if (tail==n){
                            tail.getprev().setnext(null);
                            tail=tail.getprev();
                            c--;
                    }
                    else{
                        n.getprev().setnext(n.getnext());
                        n.getnext().setprev(n.getprev());
                        c--;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean set(LinkedListNode node, Object object) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==node){n.setvalor(object);return true;}
        }
        return false;
    }

    @Override
    public int size() {
        return c;
    }

    @Override
    public LinkedList subList(Nodo from, Nodo to) {
        Lista l = new Lista();
        l.head=from;
        l.tail=to;
        return l;
    }

    @Override
    public Object[] toArray() {
        //Nodo n = this.head;
        //Object[] obs = new Object[]{(n) -> {for(int i = this.c; i>=1; i--){return n.getvalor();}}};
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList sort() {
        int i, j;
        Nodo a = this.head;
        Object aux;
        for (i = this.c; i>=1; i--) {
            Nodo b = this.head;
            for (j = this.c; j>=1; j--) {                                                             
                if ((int)b.getvalor() < (int)a.getvalor()) {
                    aux = b.getvalor();
                    b.setvalor(a.getvalor());
                    a.setvalor(aux);
                }
                b=b.getnext();
            }
            a=a.getnext();
        }
        return this;
    }
    
}
