import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ImpDictionary<K, V> implements Dictionary<K, V> {
    List Keys = new ArrayList();
    List Values = new ArrayList();

    //devuelve la el largo de la lista
    private int getSize() {
        int leng = 0;
        int kSize = Keys.size();
        int vSize = Values.size();
        if (kSize == vSize) {
            leng = kSize;
        }
        return leng;
    }

    //este metodo añade valores a las listas
    //si la "key" ya existe actualiza el "value"
    public void set(K key, V value) {
        if (getSize() == 0) {
            Keys.add(key);
            Values.add(value);
        } else {
            int index = getIndexof(key);

            if (index != 0) {
                Values.set(index, value);
            } else {
                Keys.add(key);
                Values.add(value);
            }
        }
    }

    //este metodo busca el "value" que corresponda
    // a la "key" que le haya pasado
    public V get(K key) {
        V valueToReturn = null;
        for (int i = 0; i < getSize(); i++) {
            if (Keys.get(i).equals(key)) {

                valueToReturn = (V) Values.get(i);
            }
        }
        return valueToReturn;
    }

    //este metodo elimina tanto la "key" y el "value" corresponda
    //a la "key" que le haya pasado
    public void remove(K key) {
        for (int i = 0; i < getSize(); i++) {
            if (Keys.get(i).equals(key)) {
                Keys.remove(Keys.get(i));
                Values.remove(Values.get(i));
            }
        }
    }

    //limpia las listas
    public void clear() {
        Keys.clear();
        Values.clear();
    }

    //este metodo imprime por consola los datos intoducidos en el diccionario
    public void printDitcionary() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(Keys.get(i) + " - ");
            System.out.println(Values.get(i));
        }
    }

    //hace algo
    public void forEach(Iterator<K, V> it) {
        for (int i = 0; i < getSize(); i++) {
            K key = (K) Keys.get(i);
            V value = (V) Values.get(i);
            it.iterator(key, value);
        }
    }

    //este metodo añade el valor que le has pasado en un objeto del "value"
    public void setPropertyValue(K key, String fielName, Object value) {

        Field field = null;
        int index = getIndexof(key);
        try {
            field = Keys.get(index).getClass().getField(fielName);
            field.set(Keys.get(index), value);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //este metodo te devuelve la posicion de la "key" que le has pasado
    private int getIndexof(K key) {

        boolean itsIinside = false;


        int index = 0;
        for (int i = 0; i < getSize(); i++) {
            if (Keys.get(i).equals(key)) {
                itsIinside = true;
                index = i;
            }
        }
        if (itsIinside == false) {
            index = 0;
        }
        return index;
    }


}
