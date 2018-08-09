package com.bobby.loansystem.book.Dao;

import com.bobby.loansystem.book.Domain.Book;

public interface IBookDAO {
    Book find(String nameOrNumber); //��ѯͼ��
    void update(Book book); //�޸�ͼ����Ϣ
    void remove(Book book); //ɾ��ͼ����Ϣ
    void create(Book book) throws Exception;  //ͼ�����
}
