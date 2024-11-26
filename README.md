# CarNumberPlateRecognizer
This library allows to read a car number plate from Image Uri ([see example](https://github.com/Mikelis/CarNumberPlateRecognizer/blob/main/app/src/main/java/lv/mikeliskaneps/carnumberplaterecognizer/MainActivity.kt))

To use Camera, you should modify your Manifest file ([see example](https://github.com/Mikelis/CarNumberPlateRecognizer/blob/main/app/src/main/AndroidManifest.xml)) and add file_paths([here](https://github.com/Mikelis/CarNumberPlateRecognizer/blob/main/app/src/main/res/xml/file_paths.xml))

To use the library:

Add it in your root build.gradle at the end of repositories:

	allprojects {
	 repositories {
	    mavenCentral()
	    maven { url "https://jitpack.io" }  <-- ADD THIS
	 }
	}

Add the dependency

	dependencies {
	        implementation 'com.github.Mikelis:CarNumberPlateRecognizer:1.0.4'
	}

Usage:

	NumberPlateRecognizer().recognizeTextFromImage(context, uri, callback = { recognizedText ->
	                            Toast.makeText(context, recognizedText, Toast.LENGTH_LONG).show()
	                        })


![WhatsApp Image 2024-11-26 at 14 40 51](https://github.com/user-attachments/assets/fc4fcdd4-a52a-46f6-b22f-b4047da1c78b)
