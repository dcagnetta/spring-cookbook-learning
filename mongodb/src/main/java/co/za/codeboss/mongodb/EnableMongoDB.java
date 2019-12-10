package co.za.codeboss.mongodb;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MongoDBAutoConfiguration.class)
@Documented
public @interface EnableMongoDB {
}
