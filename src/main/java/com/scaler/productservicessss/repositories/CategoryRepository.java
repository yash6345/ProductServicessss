package com.scaler.productservicessss.repositories;

import com.scaler.productservicessss.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    Category save(Category category);
}