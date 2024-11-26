package lv.mikeliskaneps.carnumberplaterecognizer

import android.content.Context
import android.net.Uri
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions


class NumberPlateRecognizer {

    fun recognizeTextFromImage(
        context: Context,
        uri: Uri,
        callback: (String) -> Unit,
        errorCallback: Function1<Exception, Unit>? = null
    ) {
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        val imageFromCamera = InputImage.fromFilePath(context, uri)

        imageFromCamera.let {
            recognizer.process(it)
                .addOnSuccessListener { visionText ->
                    var maxSize = 0
                    var biggestPredictedTextBlock = StringBuilder()
                    visionText.textBlocks.forEach { textBlock ->
                        val textBlockSize = textBlock.boundingBox?.height()
                            ?.times(textBlock.boundingBox?.width() ?: 1) ?: 1
                        if (textBlockSize > (maxSize * 2.5)) {
                            biggestPredictedTextBlock.setLength(0)
                            biggestPredictedTextBlock.append(textBlock.text)
                            maxSize = textBlockSize
                        } else if (textBlockSize > maxSize) {
                            biggestPredictedTextBlock.append(textBlock.text)
                            maxSize = textBlockSize
                        }
                    }
                    callback.invoke(
                        biggestPredictedTextBlock.toString().replace("\n", "")
                    )

                }
                .addOnFailureListener { e ->
                    errorCallback?.invoke(e)
                    e.printStackTrace()
                }
        }
    }
}