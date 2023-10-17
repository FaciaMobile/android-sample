package com.example.faciasample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facia.faciasdk.Activity.Helpers.FaceDetectionThreshold
import com.facia.faciasdk.Activity.Helpers.LivenessType
import com.facia.faciasdk.Activity.Helpers.OvalSize
import com.facia.faciasdk.FaciaAi
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method will start Facia SDK
     */
    fun initFacia(view: View) {
        val faciaAi = FaciaAi()
        faciaAi.createRequest("ACCESS_TOKEN", this, getConfigObject()) { responseSet: HashMap<String?, String?> ->
            Toast.makeText(this, responseSet.toString(), Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Set Configuration Values according to your requirements
     *
     * @return Configuration Object
     */
    private fun getConfigObject(): JSONObject? {
        return try {
            val config = JSONObject()
            config.put("showConsent", true)
            config.put("showVerificationType", true)
            config.put("showResult", true)
            config.put("showFeedback", true)
            config.put("showGreetings", true)
            config.put("qlTimeout", true)
            config.put("dlTimeout", true)
            config.put("blinkTimeout", true)
            config.put("emulatorDetection", true)
            config.put("retryLivenessQL", true)
            config.put("retryDocDetectQL", true)
            config.put("showLivenessQlRetryInst", true)
            config.put("showDocDetectQlInst", true)
            config.put("retryLivenessQLCounter", 3)
            config.put("retryDocDetectQLCounter", 3)
            config.put("faceDetectionThreshold", FaceDetectionThreshold.LOW)
            config.put("ovalSize", OvalSize.MEDIUM)
            config.put("livenessType", LivenessType.DEFAULT_LIVENESS)
            config
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}