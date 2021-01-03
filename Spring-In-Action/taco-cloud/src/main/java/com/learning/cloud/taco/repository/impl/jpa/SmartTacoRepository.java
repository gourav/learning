package com.learning.cloud.taco.repository.impl.jpa;

import com.learning.cloud.taco.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface SmartTacoRepository extends CrudRepository<Taco, Long> {
}
