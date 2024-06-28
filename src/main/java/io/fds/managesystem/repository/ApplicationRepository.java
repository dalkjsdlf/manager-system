package io.fds.managesystem.repository;

import io.fds.managesystem.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
}
