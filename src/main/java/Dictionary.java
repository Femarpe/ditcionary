public interface Dictionary <K,V>{
    void set(K key, V value);
    V get (K key);
    void remove( K key);
    void clear();
    void forEach(Iterator<K,V> it);
    void setPropertyValue(K key, String fielName, Object value);
    void printDitcionary();
}
