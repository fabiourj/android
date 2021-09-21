package nome.do.pacote;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
////////////////////////////////////////////////////////////////////////////////////////
//ADD  implementation 'com.facebook.android:audience-network-sdk:6.+' //////////////////
//em APP build.gradle///////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////
import com.facebook.ads.*;
import java.util.Random;
import android.util.Log;
/////////////////////////////////////////////////

////////////////////ANÚNCIO INTERSTICIAL//////////////////////////////////////////////


public class Facebookad  extends Activity {

  

  ////////////////////////////////////////////////////////////////
 com.facebook.ads.InterstitialAd facebookInterstitialAd;
 private static final String TAG = ">>>>>>>>>>>";
///////////////////////////////////////////////////////////////

 //@Override
    public  void onCreate() {
       

        //Código a ser executado quando a activity é inicializada

////////////////////////////////////////////////////////////////
 Random rand = new Random();
int rand_int1 = rand.nextInt(3);
 AudienceNetworkAds.initialize(this);
//////////////////////////////////////////////////////////////





////////////////////////ANÚNCIO INTERSTICIAL//////////////////////////////////////////
facebookInterstitialAd = new com.facebook.ads.InterstitialAd(this, getString(R.string.facebook_interstitial_full_screen));
                com.facebook.ads.InterstitialAdListener interstitialAdListener = new com.facebook.ads.InterstitialAdListener() {
                    @Override
                    public void onInterstitialDisplayed(com.facebook.ads.Ad ad) {
                        // Interstitial ad displayed callback
                        Log.e(TAG, "Interstitial ad displayed.");                                             

                    }

                    @Override
                    public void onInterstitialDismissed(com.facebook.ads.Ad ad) {
                        // Interstitial dismissed callback
                        Log.e(TAG, "Interstitial ad dismissed.");
                    }
                    @Override
                    public void onError(com.facebook.ads.Ad ad, com.facebook.ads.AdError adError) {
                        // Ad error callback
                        Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
                    }
                    @Override
                    public void onAdLoaded(com.facebook.ads.Ad ad) {
                        // Interstitial ad is loaded and ready to be displayed
                        Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                       // showInterstitial();
                       if (rand_int1 == 0) {
                       facebookInterstitialAd.show(); }

                    }

                    @Override
                    public void onAdClicked(com.facebook.ads.Ad ad) {
                        // Ad clicked callback
                        Log.d(TAG, "Interstitial ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(com.facebook.ads.Ad ad) {
                        // Ad impression logged callback
                        Log.d(TAG, "Interstitial ad impression logged!");
                    }
                };
                  facebookInterstitialAd.loadAd(
                        facebookInterstitialAd.buildLoadAdConfig()
                                .withAdListener(interstitialAdListener)
                                .build());
///////////////////////////////////////////////////////////////////////////////////



    }

    


   
}
