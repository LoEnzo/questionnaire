# 问卷调查表后端说明文档

### 技术栈

Springboot+mybatis+logback

### 启动

拉取代码，本地打开工程，通过maven下载相关依赖，完成后用下面两种启动方式任意即可

* springboot main函数启动，

* mvn clean package 打包，通过执行`java -jar questionnaire.jar`启动

### api文档

项目启动后，访问`http://localhost:8080/questionnaire/doc.html`即可

### 日志

默认D:\questionnaire_log
