import nu.studer.gradle.jooq.JooqGenerate
import org.gradle.kotlin.dsl.dependencies
import org.testcontainers.containers.PostgreSQLContainer

plugins {
    id("nu.studer.jooq")
    id("org.flywaydb.flyway")
}

dependencies {
    jooqGenerator(libs.postgres)
}

val POSTGRES_USERNAME = "postgres"
val POSTGRES_PASSWORD = "password"

val db =
    PostgreSQLContainer("postgres:16.0").apply {
        withDatabaseName("mydatabase")
        withUsername(POSTGRES_USERNAME)
        withPassword(POSTGRES_PASSWORD)
        withExposedPorts(5432)
    }

val stopPostgresContainer = tasks.register("stopPostgresContainer") { doLast { db.stop() } }

val startPostgresContainer =
    tasks.register("startPostgresContainer") {
        doLast {
            db.start()
            jooq.configurations.configureEach {
                jooqConfiguration.apply {
                    jdbc.apply {
                        url = "jdbc:postgresql://localhost:${db.firstMappedPort}/mydatabase"
                        driver = "org.postgresql.Driver"
                        user = POSTGRES_USERNAME
                        password = POSTGRES_PASSWORD
                    }
                }
            }
            flyway {
                url = "jdbc:postgresql://localhost:${db.firstMappedPort}/mydatabase"
                user = POSTGRES_USERNAME
                password = POSTGRES_PASSWORD
            }
        }
        finalizedBy(stopPostgresContainer)
    }

tasks.named("flywayMigrate") { mustRunAfter(startPostgresContainer) }

tasks.withType(JooqGenerate::class) {
    dependsOn(startPostgresContainer)
    dependsOn(tasks.named("flywayMigrate"))
    finalizedBy(stopPostgresContainer)

    inputs.files(fileTree("src/main/resources/db/migration"))
        .withPropertyName("migrations")
        .withPathSensitivity(PathSensitivity.RELATIVE)

    allInputsDeclared.set(true)
}
