package com.load.org.repo;

import com.load.org.model.LoadModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoadRepo extends JpaRepository<LoadModel,Long> {
}
