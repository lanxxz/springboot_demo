package com.alien.practice.springboot_demo.annotation;

import com.alien.practice.springboot_demo.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 实现 ImportSelector {@link ImportSelector}
 * @author Alien
 * @date 2019.03.24
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {HelloWorldConfiguration.class.getName()};
    }
}
