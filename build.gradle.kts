plugins {
	java
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
	// testImplementation(platform("org.junit:junit-bom:5.9.1"))
	// testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
	// testImplementation("junit:junit:4.13.2")
}

repositories {
	mavenCentral()
}

tasks.withType<Test> {
	useJUnitPlatform()
}