package ca.sheridancollege.shkurtim.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantReviews {

	private Long id;
	private String name;
	private String title;
	private String description;
	private String reviewer;
	private LocalDate dat;
}
