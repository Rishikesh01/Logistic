package com.load.org.repo;

import com.load.org.model.LoadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepo extends JpaRepository<LoadModel,Long> {
}
