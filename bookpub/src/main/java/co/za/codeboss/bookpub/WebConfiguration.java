package co.za.codeboss.bookpub;

import co.za.codeboss.bookpub.formatters.BookFormatter;
import co.za.codeboss.bookpub.repository.IBookRepository;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @SprintBootApplication meta-annotation that declares @ComponentScan
 * which will scan all @Configuration files and add its definitions to the context
 * @WebMvcConfigurer allows us to add request Interceptors
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * Spring will add all implementations of Filter interface automatically
     *
     * @see javax.servlet.Filter
     * Simply add as @Bean configuration
     */
    @Bean
    RemoteIpFilter remoteIpFilter() {
        // Just an example
        // Spring Boot provides us with configuration properties to set
        return new RemoteIpFilter();
    }


    // Create the interceptor Spring bean
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }
    // Add to the request handling chain.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }


    // Custom Formatters
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new BookFormatter(bookRepository));
    }
}
