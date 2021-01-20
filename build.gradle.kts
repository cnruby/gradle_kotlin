import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
}

group = "de.iotoi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.json:json:20201115")

	// https://repo.maven.apache.org/maven2/org/springdoc/springdoc-openapi-ui/1.5.2/springdoc-openapi-ui-1.5.2.pom
    implementation("org.springdoc:springdoc-openapi-ui:1.5.2")
	// https://repo.maven.apache.org/maven2/io/springfox/springfox-swagger2/3.0.0/springfox-swagger2-3.0.0.pom
    implementation("io.springfox:springfox-swagger2:3.0.0")
	// https://repo.maven.apache.org/maven2/io/springfox/springfox-swagger-ui/3.0.0/springfox-swagger-ui-3.0.0.pom
    implementation("io.springfox:springfox-swagger-ui:3.0.0")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
