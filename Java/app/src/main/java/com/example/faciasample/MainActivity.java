package com.example.faciasample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facia.faciasdk.Activity.Helpers.FaceDetectionThreshold;
import com.facia.faciasdk.Activity.Helpers.LivenessType;
import com.facia.faciasdk.Activity.Helpers.OvalSize;
import com.facia.faciasdk.FaciaAi;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method will start Facia SDK
     */
    public void initFacia(View view) {
        try {
            FaciaAi faciaAi = new FaciaAi();
            faciaAi.createRequest("ACCESS_TOKEN", this, getConfigObject(), responseSet ->
                    Toast.makeText(this, responseSet.toString(), Toast.LENGTH_LONG).show());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set Configuration Values according to your requirements
     *
     * @return Configuration Object
     */
    private JSONObject getConfigObject(){
        try {
            JSONObject config = new JSONObject();

            config.put("showConsent", true);
            config.put("showVerificationType", true);
            config.put("showResult", true);
            config.put("showFeedback", true);
            config.put("showGreetings", true);
            config.put("qlTimeout", true);
            config.put("dlTimeout", true);
            config.put("blinkTimeout", true);
            config.put("emulatorDetection", true);
            config.put("retryLivenessQL", true);
            config.put("retryDocDetectQL", true);
            config.put("showLivenessQlRetryInst", true);
            config.put("showDocDetectQlInst", true);
            config.put("retryLivenessQLCounter", 3);
            config.put("retryDocDetectQLCounter", 3);
            config.put("faceDetectionThreshold", FaceDetectionThreshold.LOW);
            config.put("ovalSize", OvalSize.MEDIUM);
            config.put("livenessType", LivenessType.DEFAULT_LIVENESS);
            return config;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}