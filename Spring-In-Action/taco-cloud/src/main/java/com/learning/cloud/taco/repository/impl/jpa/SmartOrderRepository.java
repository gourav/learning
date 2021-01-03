package com.learning.cloud.taco.repository.impl.jpa;

import com.learning.cloud.taco.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface SmartOrderRepository extends CrudRepository<Order, Long> {
}
