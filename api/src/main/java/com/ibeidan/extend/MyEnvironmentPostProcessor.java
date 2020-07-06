package com.ibeidan.extend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;


/**
 * @author lee
 * DATE 2020/5/7 16:19
 *
 *  可以实现加载任意文件并将它们添加到环境中。
 *  例如，下面的示例从类路径加载YAML配置文件：
 */
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        System.out.println("自定义 MyEnvironmentPostProcessor ，env ="+environment);

       /* Resource path = new ClassPathResource("com/example/myapp/config.yml");
        PropertySource<?> propertySource = loadYaml(path);
        environment.getPropertySources().addLast(propertySource);*/
    }

    private PropertySource<?> loadYaml(Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Resource " + path + " does not exist");
        }
        try {
            return this.loader.load("custom-resource", path).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
