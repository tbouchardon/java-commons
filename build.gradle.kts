plugins {
    id("ksuto.java-library")
}

group = "fr.ksuto"
version = "1.2"

dependencies {
    implementation(libs.slf4j.api)
    implementation(libs.flatlaf)
}
