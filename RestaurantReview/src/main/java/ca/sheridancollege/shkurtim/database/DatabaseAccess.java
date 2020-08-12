package ca.sheridancollege.shkurtim.database;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.shkurtim.beans.RestaurantReviews;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insert(String name, String title, String description, String reviewer) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "INSERT INTO review(name, title, description, reviewer, dat) VALUES (:name, :title, :description, :reviewer, '"
				+ LocalDate.now() + "')";
		namedParameters.addValue("name", name);
		namedParameters.addValue("title", title);
		namedParameters.addValue("description", description);
		namedParameters.addValue("reviewer", reviewer);
		int rowsAffected = jdbc.update(query, namedParameters);
		
		if (rowsAffected > 0)
			System.out.println("Inserted into database.");
	}

	public List<RestaurantReviews> getReviews() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "SELECT * FROM review";
		return jdbc.query(query, namedParameters,
				new BeanPropertyRowMapper<RestaurantReviews>(RestaurantReviews.class));
	}
}
