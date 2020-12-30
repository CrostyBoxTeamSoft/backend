package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class CrostyboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrostyboxApplication.class, args);
	}

}

/*	MySQL Configuration for application.properties

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/crostybox_db?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=RootPassword
spring.jpa.show-sql=true

 */
