package com.base.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class BoneCPConfig {

	@Value("${bonecp.url}")
	private String jdbcUrl;

	@Value("${bonecp.username}")
	private String jdbcUsername;

	@Value("${bonecp.password}")
	private String jdbcPassword;

	@Value("${bonecp.driverClass}")
	private String driverClass;

	@Value("${bonecp.idleMaxAgeInMinutes}")
	private Integer idleMaxAgeInMinutes;

	@Value("${bonecp.idleConnectionTestPeriodInMinutes}")
	private Integer idleConnectionTestPeriodInMinutes;

	@Value("${bonecp.maxConnectionsPerPartition}")
	private Integer maxConnectionsPerPartition;

	@Value("${bonecp.minConnectionsPerPartition}")
	private Integer minConnectionsPerPartition;

	@Value("${bonecp.partitionCount}")
	private Integer partitionCount;

	@Value("${bonecp.acquireIncrement}")
	private Integer acquireIncrement;

	@Value("${bonecp.statementsCacheSize}")
	private Integer statementsCacheSize;

	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUsername(jdbcUsername);
		dataSource.setPassword(jdbcPassword);
		dataSource.setIdleConnectionTestPeriodInMinutes(idleConnectionTestPeriodInMinutes);
		dataSource.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
		dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
		dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
		dataSource.setPartitionCount(partitionCount);
		dataSource.setAcquireIncrement(acquireIncrement);
		dataSource.setStatementsCacheSize(statementsCacheSize);
		return dataSource;
	}

}