rootProject.name = "AliucordPlugins"

include(
    "MyFirstCommand",
    "MyFirstPatch"
)

rootProject.children.forEach {
    it.projectDir = file("ExamplePlugins/kotlin/${it.name}")
}