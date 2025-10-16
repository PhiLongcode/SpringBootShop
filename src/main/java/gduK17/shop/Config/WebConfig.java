package gduK17.shop.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
        // Map URL path /uploads/** to the filesystem folder 'public/uploads/'
        // Use 'file:' prefix and a trailing slash. On Windows, an absolute path isn't
        // necessary
        // if the folder is relative to the working directory. Controller saves files to
        // "public/uploads/".
            registry.addResourceHandler("/uploads/**")
                    .addResourceLocations("file:public/uploads/"); // serve files saved in public/uploads/
        }
}
