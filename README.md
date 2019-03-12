*Spring Boot 练习学习项目*

# mvn 打包命令  
 ```cmd
 mvn -Dmaven.test.skip -U clean package
 或者
 mvn -Dmaven.test.skip -U clean install
 ```  

# 打包知识点 
## jar 包  
1.由于项目是分模块的，所以打包需要做一些改动，将主目录下的pom.xml中的下面这段话删除  
```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```  
2.在web模块的pom.xml文件中添加以下内容
```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <mainClass>com.alien.practice.springboot_demo.SpringbootDemoApplication</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
```  
3.然后运行 mvn 打包命令
## war 包  
1.同上1  
2.同上2  
3.在web模块的pom.xml文件中添加以下内容
```xml
<packaging>war</packaging>
```  
4.在web 模块的 main 目录下创建 webapp/WEB-INF/web.xml,并补全web.xml内容  
5.然后运行 mvn 打包命令


