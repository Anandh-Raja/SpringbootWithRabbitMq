package com.wipro.spoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportARepo extends JpaRepository<StudentSubscription,Integer> {

}
