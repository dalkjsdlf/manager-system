package io.fds.managesystem.domain.application.repository;

import io.fds.managesystem.domain.application.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
}
