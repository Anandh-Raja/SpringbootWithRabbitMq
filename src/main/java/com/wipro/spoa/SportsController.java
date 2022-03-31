package com.wipro.spoa;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportsController {
	@GetMapping("/getSports")
	public List<String> getAllSports(){
		return Arrays.asList("VolleyBall","Hockey","Football","Cricket","JavelinThrow","DiscusThrow","Batminton");
	}

}
