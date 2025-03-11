package br.com.fiap.spring_mvc.configuration;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class InternacionalizacaoConfiguration extends AcceptHeaderLocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        List<Locale> locales = Arrays.asList(new Locale("br"), new Locale("en"));
        String headerLanguage = request.getHeader("Accept-Language");
        return headerLanguage == null || headerLanguage.isEmpty() ?
                Locale.getDefault() : Locale.lookup(Locale.LanguageRange.parse(headerLanguage), locales);
    }

    @Bean
    ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("internationalization/messages");
        source.setDefaultEncoding(StandardCharsets.UTF_8.name());
        source.setDefaultLocale(new Locale("en"));
        return source;
    }
}

