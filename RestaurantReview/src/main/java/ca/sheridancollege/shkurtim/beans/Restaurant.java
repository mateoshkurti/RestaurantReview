package ca.sheridancollege.shkurtim.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	private Long id;
	private String name;
	private String[] names = { "Moxie's at Square One", "Moxie's at Hamilton", "Moxie's at Toronto Downtown",
			" Moxie's at Dixon Road", "Moxie's at Cortneypark"};

}
