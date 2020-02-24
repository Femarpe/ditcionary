import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ImpDictionary<K, V> implements Dictionary<K, V> {
    List Keys = new ArrayList();
    List Values = new ArrayList();


    private int getSize() {
        int leng = 0;
        int kSize = Keys.size();
        int vSize = Values.size();
        if (kSize == vSize) {
            leng = kSize;
        }
        return leng;
    }


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

    public V get(K key) {
        V valueToReturn = null;
        for (int i = 0; i < getSize(); i++) {
            if (Keys.get(i).equals(key)) {

                valueToReturn = (V) Values.get(i);
            }
        }
        return valueToReturn;
    }

    public void remove(K key) {
        for (int i = 0; i < getSize(); i++) {
            if (Keys.get(i).equals(key)) {
                Keys.remove(Keys.get(i));
                Values.remove(Values.get(i));
            }
        }
    }


    public void clear() {
        Keys.clear();
        Values.clear();
    }

    public void printDitcionary() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(Keys.get(i) + " - ");
            System.out.println(Values.get(i));
        }
    }

    public void forEach(Iterator<K, V> it) {
        for (int i = 0; i < getSize(); i++) {
            K key = (K) Keys.get(i);
            V value = (V) Values.get(i);
            it.iterator(key,value);
        }
    }

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
