package com.solam.ea.solam_rent.dao;

import com.solam.ea.solam_rent.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentDAO extends JpaRepository<Payment,Long> {

    List<Payment> findPaymentsByCustomerId(long id);

    Payment findPaymentByRentId(long id);
}
