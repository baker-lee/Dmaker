package com.example.dmaker.repository;

import com.example.dmaker.entity.Developers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developers, Long> {
    Optional<Developers> findByMemberId(String memberId);
}
