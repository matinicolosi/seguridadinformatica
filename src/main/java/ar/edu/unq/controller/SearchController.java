package ar.edu.unq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.entity.Item;
import ar.edu.unq.service.SearchService;

@RestController
public class SearchController {
	@Autowired
	private SearchService searchService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "search-by-text/{text}", produces = "application/json")
	public List<Item> getBook(@PathVariable String text) {
		return searchService.findByText(text);
	}
}
