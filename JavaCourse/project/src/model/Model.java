package model;

public interface Model<T> {
    void receiveData(String[] data) throws Exception;
    T[] getAllInfo();
    T[] makeRequest();
}
