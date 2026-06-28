// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

tasks.register("inspectWorkspaceFiles") {
    doLast {
        println("--- Inspecting Workspace Files ---")
        val specificFiles = listOf(
            "app/build/outputs/apk/debug/app-debug.apk",
            ".build-outputs/app-debug.apk",
            "Download_APK/app-debug.apk",
            "app-debug.apk"
        )
        specificFiles.forEach { path ->
            val f = file(path)
            if (f.exists()) {
                println("APK Path: $path | Exist: true | Size: ${f.length()} bytes (${String.format("%.2f", f.length().toDouble() / (1024 * 1024).toDouble())} MB)")
            } else {
                println("APK Path: $path | Exist: false")
            }
        }
        
        file(".").listFiles()?.forEach { f ->
            if (f.isFile) {
                println("File: ${f.name} | Size: ${f.length()} bytes")
            }
        }
    }
}

tasks.register("copyApkToDownloadFolder") {
    doLast {
        val srcFile = file("app/build/outputs/apk/debug/app-debug.apk")
        if (srcFile.exists()) {
            println("Freshly compiled APK exists! Size: ${srcFile.length()} bytes (${srcFile.length() / (1024 * 1024)} MB)")
            val downloadDir = file("Download_APK")
            if (!downloadDir.exists()) {
                downloadDir.mkdirs()
            }
            val destFile = file("Download_APK/app-debug.apk")
            srcFile.copyTo(destFile, overwrite = true)
            println("Successfully copied APK to non-hidden download folder: ${destFile.absolutePath}")
            
            val rootDestFile = file("app-debug.apk")
            srcFile.copyTo(rootDestFile, overwrite = true)
            println("Successfully copied APK directly to root workspace: ${rootDestFile.absolutePath}")
        } else {
            println("Source APK not found at: ${srcFile.absolutePath}")
        }
    }
}



