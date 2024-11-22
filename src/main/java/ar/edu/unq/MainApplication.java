package ar.edu.unq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        // Crear tabla y cargar datos
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Item (id BIGINT PRIMARY KEY, name VARCHAR(255) NOT NULL);");
        jdbcTemplate.update("INSERT INTO Item (id, name) VALUES (?, ?)", 1, "Item A");
        jdbcTemplate.update("INSERT INTO Item (id, name) VALUES (?, ?)", 2, "Item B");
        jdbcTemplate.update("INSERT INTO Item (id, name) VALUES (?, ?)", 3, "Item C");
        jdbcTemplate.update("INSERT INTO Item (id, name) VALUES (?, ?)", 4, "Item D");
        
        System.out.println("Datos iniciales cargados.");
    }
}
