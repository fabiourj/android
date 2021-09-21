package com.arena.esportes;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

/////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////
import com.facebook.ads.*;
import java.util.Random;
import android.util.Log;
/////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////


public class Facebookad  extends Activity {

    //TODO change this if you want to limit interstishal ads
    //public static int NUMBER_OF_INTERSTISHAL_ADS_PER_SESSION = 10;
    //TODO dont touch this
    //public static int NUMBER_OF_INTERSTISHAL_ADS_SHOWN = 0;


    //TODO change this if you want to limit banner ads
   // public static int NUMBER_OF_BANNER_ADS_PER_SESSION = 5;
    //TODO dont touch this
    //public static int NUMBER_OF_BANNER_ADS_SHOWN = 0;

  ////////////////////////////////////////////////////////////////
 com.facebook.ads.InterstitialAd facebookInterstitialAd;
 private static final String TAG = ">>>>>>>>>>>";
///////////////////////////////////////////////////////////////

 //@Override
    public  void onCreate() {
       

        //Código a ser executado quando o applicativo é inicializado

////////////////////////////////////////////////////////////////
 Random rand = new Random();
int rand_int1 = rand.nextInt(3);
 AudienceNetworkAds.initialize(this);
//////////////////////////////////////////////////////////////







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




    }

    


   
}
