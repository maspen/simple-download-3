package com.intelligrated.download;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
@SpringApplicationConfiguration(classes = Config.class)
public class SimpleDownloadApplicationTest extends AbstractTestNGSpringContextTests {
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;
	
//	@Before
//	public void setup() {
//		jdbcTemplate = new JdbcTemplate(dataSource);
//		Assert.assertNotNull(jdbcTemplate);
//	}
	
	@Test
	public void getAllEntries() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		Assert.assertNotNull(jdbcTemplate);
		
		String selectQuery = "SELECT * FROM def_down_up";
		
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(selectQuery);
		
		Assert.assertNotNull(resultSet);
		Assert.assertEquals(9, resultSet.size());
		
		for (Map<String, Object> map : resultSet) {
			System.out.println(map);
		}
	}
}
