plugins {
	java
	war
	id("org.springframework.boot") version "2.7.9"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("org.gretty") version "3.1.0"
}

group = "com.neeraj"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web") {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
	}
	implementation("org.springframework.boot:spring-boot-starter-jetty")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//implementation("javax.servlet:javax.servlet-api:4.0.1")
	//implementation("javax.servlet:jsp-api:2.3.3")
	//implementation("javax.servlet:jstl:1.2")

}



gretty {
	springBoot = true
	host = "localhost"
	httpPort = 8080
	springBootVersion	= "2.7.9"
	serverConfigFile = "$projectDir/jetty/jetty.xml"
}

tasks.withType<Test> {
	useJUnitPlatform()
}


