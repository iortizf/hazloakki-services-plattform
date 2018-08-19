scan '30 seconds'

String encoderPattern = '%-12date{HH:mm:ss} %-5level %logger{35} - %msg%n'
String logDir = "build/logs"
String logFileName = 'registry'
jmxConfigurator()

appender('CONSOLE', ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = encoderPattern
  }
}

appender('FILE', RollingFileAppender) {
  file = "${logDir}/${logFileName}.log"
  append = true
  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "${logDir}/${logFileName}-%d{yyyy-MM-dd_HH}.log"
    maxHistory = 7
  }
  encoder(PatternLayoutEncoder) {
    pattern = encoderPattern
  }
}

root ERROR, ['CONSOLE', 'FILE']
//root loggingLevel, appenders

logger 'org.apache.tomcat', WARN
logger 'org.springframework.boot.context.web.ErrorPageFilter', OFF
logger 'org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver', OFF
logger 'org.hibernate.engine.jdbc.spi.SqlExceptionHelper', INFO
logger 'org.springframework.data.rest.webmvc.AbstractRepositoryRestController', OFF
logger 'org.apache.coyote', WARN
logger 'org.apache.catalina', WARN
logger 'org.apache.jasper', WARN
logger 'org.hibernate.validator', WARN
logger 'org.springframework.integration', INFO
logger 'org.jivesoftware.smack', INFO
logger 'com.cacti', ERROR
