package com.example.website.repository;

import com.example.website.entity.model.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {
    List<Telephone> findByUserid(int userid);
}
