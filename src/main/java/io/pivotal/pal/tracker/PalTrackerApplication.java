package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    /*
    @Bean
    TimeEntryRepository timeEntryRepository() {
        return new InMemoryTimeEntryRepository();
    }*/

    @Bean
    TimeEntryRepository timeEntryRepository() {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/tracker_dev?user=tracker&useSSL=false&useTimezone=true&serverTimezone=UTC&useLegacyDatetimeCode=false");

        return new JdbcTimeEntryRepository(dataSource);
    }
}
