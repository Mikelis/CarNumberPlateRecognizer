# CarNumberPlateRecognizer
This library allows to read a car number plate from Image Uri ([see example](https://github.com/Mikelis/CarNumberPlateRecognizer/blob/main/app/src/main/java/lv/mikeliskaneps/carnumberplaterecognizer/MainActivity.kt))

To use Camera, you should modify your Manifest file ([see example](https://github.com/Mikelis/CarNumberPlateRecognizer/blob/main/app/src/main/AndroidManifest.xml)) and add file_paths([here](https://github.com/Mikelis/CarNumberPlateRecognizer/blob/main/app/src/main/res/xml/file_paths.xml))

To use the library:

Add it in your root build.gradle at the end of repositories:

	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}

Add the dependency

	dependencies {
	        implementation 'com.github.Mikelis:CarNumberPlateRecognizer:1.0.4'
	}

