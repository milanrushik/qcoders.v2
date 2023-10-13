package com.qcoders.adscodenew;


import static com.qcoders.adscodenew.AD.Bannerad;
import static com.qcoders.adscodenew.AD.fbbannerad;

import android.app.Activity;
import android.util.Log;
import android.widget.RelativeLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class Bannerad {
    private Activity mActivity;
    private RelativeLayout mLayout;

    public Bannerad(Activity mActivity, RelativeLayout mLayout) {
        this.mActivity = mActivity;
        this.mLayout = mLayout;
    }

    public void show() {

        if (AD.prirotyisFb) {
            if (AD.Facebookshow) {
                showFB(true);
            } else if (AD.Admobshow) {
                showGoogle(true);
            } else if (AD.Qurekashow) {
                //   mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }
        }
        else{
            if (AD.Admobshow) {
                showGoogle( true);
            } else if (AD.Facebookshow) {
                showFB( true);
            } else if (AD.Qurekashow) {
             //
                //   mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }
        }

    }

    private void showFB(boolean isFirst) {
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(mActivity, fbbannerad, com.facebook.ads.AdSize.BANNER_HEIGHT_50.BANNER_HEIGHT_50);

        // Add the ad view to your activity layout
        mLayout.addView(adView);

        // Request an ad
        adView.loadAd();

        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.w("BannerADs", "Error:" + adError.getErrorMessage());
                if (isFirst) {
                    if (AD.Admobshow){
                        showGoogle(false);
                    }

                }

            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
                if (mLayout.getChildCount() != 0)
                    mLayout.removeAllViews();
                mLayout.addView(adView);
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        };

        // Request an ad
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());
    }

    public void showGoogle(boolean isFirst) {
        AdView mAdView = new AdView(mActivity);

        mAdView.setAdSize(AdSize.BANNER);

        mAdView.setAdUnitId(Bannerad);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.

                if (isFirst)
                    if (AD.Facebookshow){
                        showFB(false);
                    }
            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                if (mLayout.getChildCount() != 0)
                    mLayout.removeAllViews();
                mLayout.addView(mAdView);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        });
    }
}
