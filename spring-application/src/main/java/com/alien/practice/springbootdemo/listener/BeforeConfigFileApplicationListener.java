package com.alien.practice.springbootdemo.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 实现 在 {@link ConfigFileApplicationListener} 之前加载的监听 <br/>
 * 示例可能也会改为之后，具体看具体实现 <br/>
 * @author: Alien
 * @since: 2019/4/6 15:21
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {

    @Override
    public int getOrder() {
        // 比 ConfigFileApplicationListener 优先级高
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;

        //比 ConfigFileApplicationListener 优先级低
        //return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }


    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent =
                    (ApplicationEnvironmentPreparedEvent) event;
            ConfigurableEnvironment environment = preparedEvent.getEnvironment();
            System.out.println("environment.getProperty(\"name\") is "
                    + environment.getProperty("name"));
        }
        if (event instanceof ApplicationPreparedEvent) {
            
        }
    }
}
