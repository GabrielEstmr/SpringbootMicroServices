package com.gabriel.worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.worker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
