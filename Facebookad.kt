package nome.do.pacote

import android.app.Activity
import android.util.Log
import com.facebook.ads.*
import java.util.Random

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
////////////////////////////////////////////////////////////////////////////////////////
//ADD  implementation 'com.facebook.android:audience-network-sdk:6.+' //////////////////
//em APP build.gradle///////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
class Facebookad : Activity() {
   
var facebookInterstitialAd: InterstitialAd? = null
companion object {    private const val TAG = ">>>>>>>>>>>"    }


///////////////////////////////////////////////////////////////
    //@Override
    fun onCreate() {


    //Código a ser executado quando a instância é inicializada



////////////////////////////////////////////////////////////////
        val rand = Random()
        val rand_int1 = rand.nextInt(3)
        AudienceNetworkAds.initialize(this)
////////////////////////////ANÚNCIO INTERSTICIAL/////////////////////////////////////
/////////( this , requireActivity(), requireContext(), activity!! )//////////////////
//////////////////////////////////////////////////////////////////////////////////////

        facebookInterstitialAd = InterstitialAd(this, getString(R.string.facebook_interstitial_full_screen))
        val interstitialAdListener: InterstitialAdListener = object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.")
            }

            override fun onInterstitialDismissed(ad: Ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.")
            }

            override fun onError(ad: Ad, adError: AdError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.errorMessage)
            }

            override fun onAdLoaded(ad: Ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!")
                // showInterstitial();
                if (rand_int1 == 0) {
                    facebookInterstitialAd!!.show()
                }
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!")
            }
        }
        facebookInterstitialAd!!.loadAd(
                facebookInterstitialAd!!.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build())
    }

    
}