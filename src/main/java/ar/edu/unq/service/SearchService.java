package ar.edu.unq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import ar.edu.unq.entity.Item;

@Service
public class SearchService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL inyectable
	// Item' OR 1=1; DELETE FROM Item WHERE 1=1 --
	public List<Item> findByText(String text) {
		String query = "SELECT * FROM Item i WHERE i.name LIKE '%" + text + "%'";
		return jdbcTemplate.query(query, (rs, rowNum) -> new Item(rs.getLong("id"), rs.getString("name")));
	}
}
