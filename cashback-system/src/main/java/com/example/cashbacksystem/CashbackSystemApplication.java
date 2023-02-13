package com.example.cashbacksystem;

import com.example.cashbacksystem.domain.Order;
import com.example.cashbacksystem.domain.User;
import com.example.cashbacksystem.repository.OrderRepository;
import com.example.cashbacksystem.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class CashbackSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CashbackSystemApplication.class, args);
	}

}
