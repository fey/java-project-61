plugins {
	application
	checkstyle
	id("com.github.ben-manes.versions") version "0.52.0"
	id ("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(24))
	}
}

application {
	mainClass.set("hexlet.code.App")
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(platform("org.junit:junit-bom:5.13.1"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	implementation("org.apache.commons:commons-lang3:3.17.0")
}

tasks.test {
	useJUnitPlatform()
}

tasks.named<JavaExec>("run") {
	standardInput = System.`in`
}

sonar {
	properties {
		property("sonar.projectKey", "fey_java-project-61")
		property("sonar.organization", "fey")
		property("sonar.host.url", "https://sonarcloud.io")
	}
}