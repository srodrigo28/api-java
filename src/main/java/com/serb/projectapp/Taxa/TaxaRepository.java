package com.serb.projectapp.Taxa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxaRepository extends JpaRepository<TaxaModel, Long> {
    
}
