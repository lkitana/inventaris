package com.ojan.backend.inventaris.repositories;

import com.ojan.backend.inventaris.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {}