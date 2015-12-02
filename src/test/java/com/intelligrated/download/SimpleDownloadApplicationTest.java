package com.intelligrated.download;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class SimpleDownloadApplicationTest {
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		Assert.assertNotNull(jdbcTemplate);
		
		String selectQuery = "SELECT * FROM def_down_up";
		
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(selectQuery);
		
		Assert.assertNotNull(resultSet);
		
	}
}
