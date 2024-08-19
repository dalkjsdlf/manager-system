package io.ratel.managesystem.domain.application.repository;

import io.ratel.managesystem.domain.application.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
}
