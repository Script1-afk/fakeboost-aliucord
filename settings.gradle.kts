rootProject.name = "AliucordPlugins"

// Plugins are included like this
include(
    "MyFirstCommand",
    "MyFirstPatch"
)

// This is required because plugins are in the ExamplePlugins/kotlin subdirectory.
// Assuming you put all your plugins into the project root, so on the same
// level as this file, simply remove everything below.
//
// Otherwise, if you want a different structure, for example all plugins in a folder called "plugins",
// then simply change the path
rootProject.children.forEach {
    // Change kotlin to java if you'd rather use Java
    it.projectDir = file("ExamplePlugins/kotlin/${it.name}")
}