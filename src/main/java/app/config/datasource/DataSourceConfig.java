package app.config.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

public interface DataSourceConfig {

	DataSource dataSource();

}
