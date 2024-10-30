package org.example.hsf301.service;

import java.util.List;
import org.example.hsf301.pojo.Tours;

public interface ITourService {
    void save(Tours tours);
    List<Tours> findAll();
    void delete(Integer id);
    Tours findById(Integer id);
}