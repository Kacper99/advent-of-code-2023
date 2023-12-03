plugins {
    java
    `jvm-test-suite`
    jacoco
    `jacoco-report-aggregation`
}

testing {
    suites {
        configureEach {
            if (this is JvmTestSuite) {
                useJUnitJupiter()
                dependencies {
                    implementation(libs.kotest)
                    implementation(libs.kotest.arrow) // https://kotest.io/docs/assertions/arrow.html
                }
                targets {
                    all {
                        testTask.configure{
                            finalizedBy(tasks.jacocoTestReport)
                        }
                    }
                }
            }
        }

        register<JvmTestSuite>("integrationTest") {
            dependencies {
                implementation(project())
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(testing.suites.named("test"))
                    }
                }
            }
        }
    }
}

tasks.named("check") {
    dependsOn(testing.suites.named("integrationTest"))
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.8".toBigDecimal() // TODO: Change this
            }
        }
    }
}

tasks.register<JacocoCoverageVerification>("projectJacocoReportVerification") {
    executionData(fileTree(project.rootDir).include("**/jacoco/*.exec"))
    dependsOn(project.tasks.withType(JacocoReport::class))
}

reporting {
    reports {
        val fullCodeCoverageReport by creating(JacocoCoverageReport::class) {
            testType.set("full")
            reportTask.configure {
                executionData(fileTree(project.rootDir).include("**/jacoco/*.exec"))
                dependsOn(project.tasks.withType(JacocoReport::class).filter { it != this })
                reports {
                    html.required.set(true)
                    xml.required.set(false)
                }
            }
        }
    }
}