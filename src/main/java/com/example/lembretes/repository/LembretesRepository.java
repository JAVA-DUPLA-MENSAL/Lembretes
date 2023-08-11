package com.example.lembretes.repository;

import com.example.lembretes.entity.Lembretes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LembretesRepository extends JpaRepository<Lembretes, Long> {


}
