package io.github.jr.deveopers.eventlistener.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
