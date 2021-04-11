plugins {
    java
    `maven-publish`
}

java {
    modularity.inferModulePath.set(true)
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
    
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

sourceSets {
    main {
        dependencies {
            implementation(group="org.jetbrains", name="annotations", version="20.1.0")
        }
    }
    test {
        dependencies {
            implementation(group="junit", name="junit", version="4.13.1")
            implementation(group="com.google.guava", name="guava", version="18.0")
        }
    }
}

group = "net.openhft"
version = "0.15-SNAPSHOT"
description = "Zero-allocation Hashing"
java.sourceCompatibility = JavaVersion.VERSION_1_9

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
