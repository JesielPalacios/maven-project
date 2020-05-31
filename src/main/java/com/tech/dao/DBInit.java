package com.tech.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class DBInit extends GenericDao {
	private static boolean loaded = false;
	public DBInit() {
		super();
	}

	@Autowired
	public DBInit(DataSource dataSource) {
		super(dataSource);
	}
	
	public void setupDB(boolean onceOnly) throws IOException {
		if(onceOnly && loaded) {
			return;
		}
		try {
			String sql = new String(Files.readAllBytes(Paths.get("data//db.sql")));
			jdbcTemplateObject.execute(sql);		

			sql = new String(Files.readAllBytes(Paths.get("data//data.sql")));
			jdbcTemplateObject.execute(sql);		
		} catch(DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		loaded = true;
	}
	
}
