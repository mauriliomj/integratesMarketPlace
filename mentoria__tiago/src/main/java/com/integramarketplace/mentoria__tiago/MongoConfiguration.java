package integramarketplace.mentoriatiago.integraMarketPlace;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"integramarketplace.mentoriatiago.integramarketplace"})
public class MongoConfiguration {
}
