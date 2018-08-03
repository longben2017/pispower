#配置运行环境为java8
FROM java:8-alpine

MAINTAINER longgq 479501260@qq.com

#添加一个jar包到容器,并命名为app.jar
COPY target/user-service-0.0.1-SNAPSHOT-exec.jar app.jar

#运行
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
