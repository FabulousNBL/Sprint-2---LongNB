package com.project.repository;

import com.project.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value="SELECT * FROM transaction ORDER BY id DESC LIMIT 1", nativeQuery =true)
    Transaction getLastTransaction();

    @Modifying
    @Query ( value = "insert into transaction (payment,payment_method,start_date, customer_id) values (:payment, :method, :startDate, :customerId)", nativeQuery = true)
    void createTransaction(@Param("payment") int payment,
                           @Param("method") String method,
                           @Param("startDate") String startDate,
                           @Param("customerId") int customerId);

    @Query(value = "select * from transaction", nativeQuery =true)
    List<Transaction> getHistory();

}
