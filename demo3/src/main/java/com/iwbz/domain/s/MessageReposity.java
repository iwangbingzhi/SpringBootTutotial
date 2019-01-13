package com.iwbz.domain.s;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageReposity extends JpaRepository<Message,Long> {
}
