rootProject.name = "AliucordPlugins"

// Inclure tes plugins
include(
    "MyFirstCommand",
    "MyFirstPatch"
)

// Si tes plugins sont dans ExamplePlugins/kotlin
rootProject.children.forEach {
    it.projectDir = file("ExamplePlugins/kotlin/${it.name}")
}