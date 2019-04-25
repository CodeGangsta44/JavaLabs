package model;

public interface Model<T> {
    void receiveData(T[] data) throws Exception;
    T[] getAllInfo();
    T[] makeRequest();
}
