package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Record;

/**
 * @author pparrado
 *
 */
public interface RecordRepository extends JpaRepository<Record, Integer> {

}
