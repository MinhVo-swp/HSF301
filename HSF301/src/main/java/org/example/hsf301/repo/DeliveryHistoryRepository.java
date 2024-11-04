package org.example.hsf301.repo;

import org.example.hsf301.dao.DeliveryHistoryDAO;
import org.example.hsf301.dao.IDeliveryHistoryDAO;
import org.example.hsf301.pojo.DeliveryHistory;

import java.util.List;

public class DeliveryHistoryRepository implements IDeliveryHistoryRepository {
    private IDeliveryHistoryDAO dao;
    public DeliveryHistoryRepository(String name) {
        dao = new DeliveryHistoryDAO(name);
    }
    @Override
    public List<DeliveryHistory> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(DeliveryHistory student) {
        dao.save(student);
    }

    @Override
    public void delete(Long studentID) {
        dao.delete(studentID);
    }

    @Override
    public DeliveryHistory findById(Long studentID) {
        return dao.findById(studentID);
    }

    @Override
    public void update(DeliveryHistory student) {
        dao.update(student);
    }
}