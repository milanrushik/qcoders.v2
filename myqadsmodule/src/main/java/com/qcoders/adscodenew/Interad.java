package com.qcoders.adscodenew;


import static com.qcoders.adscodenew.AD.MAX_TIME;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.ads.Ad;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Interad {
    public interface setOnClosed {
        void onClosed();
    }

    private static InterstitialAd mGoogleInterstitialAd = null;
    private static com.facebook.ads.InterstitialAd mFBInterstitialAd = null;
    private static InterstitialAdListener mInterstitialAdListener;
    private static Activity mActivity;
    public static setOnClosed mSetOnClosed;
    private static long CURR_TIME = 0;
    private static Handler mHandler = new Handler();
    private static Runnable mRunnable;

    public static void BackpressInterShow(Activity activity, setOnClosed setOnClosed) {

        if(AD.isbackpress) {
            mSetOnClosed = setOnClosed;
            mActivity = activity;

            if (AD.prirotyisFb) {
                if (AD.Facebookshow) {
                    loadFB(mSetOnClosed, true);
                } else if (AD.Admobshow) {
                    showGoogle(mSetOnClosed, true);
                } else if (AD.Qurekashow) {
                    mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
                }
            } else {
                if (AD.Admobshow) {
                    showGoogle(mSetOnClosed, true);
                } else if (AD.Facebookshow) {
                    loadFB(mSetOnClosed, true);
                } else if (AD.Qurekashow) {
                    mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
                }
            }
        }
        else {
            setOnClosed.onClosed();
        }
    }
    public static void loadGoogle() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(MyApplication.getInstance(), AD.Interad, adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mGoogleInterstitialAd = interstitialAd;
                mGoogleInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdClicked() {
                    }
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        mGoogleInterstitialAd = null;
                        loadGoogle();
                        onClosed(mSetOnClosed);
                    }
                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        mGoogleInterstitialAd = null;
                    }
                    @Override
                    public void onAdImpression() {
                    }
                    @Override
                    public void onAdShowedFullScreenContent() {
                    }
                });
            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                mGoogleInterstitialAd = null;
            }
        });
    }
    private static void loadFB(setOnClosed mSetOnClosed, boolean isFirst) {
        mFBInterstitialAd = new com.facebook.ads.InterstitialAd(MyApplication.getInstance(), AD.fbinterad);
        mInterstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }
            @Override
            public void onInterstitialDismissed(Ad ad) {
                onClosed(mSetOnClosed);
            }
            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {
            }
            @Override
            public void onAdLoaded(Ad ad) {
            }
            @Override
            public void onAdClicked(Ad ad) {
            }
            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        mFBInterstitialAd.loadAd(mFBInterstitialAd.buildLoadAdConfig().withAdListener(mInterstitialAdListener).build());
        showFB(mSetOnClosed, isFirst);
    }
    private static void loadFB2(setOnClosed mSetOnClosed, boolean isFirst) {
        mFBInterstitialAd = new com.facebook.ads.InterstitialAd(MyApplication.getInstance(), AD.fbinterad2);
        mInterstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }
            @Override
            public void onInterstitialDismissed(Ad ad) {
                onClosed(mSetOnClosed);
            }
            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {
            }
            @Override
            public void onAdLoaded(Ad ad) {
            }

            @Override
            public void onAdClicked(Ad ad) {
            }
            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        mFBInterstitialAd.loadAd(mFBInterstitialAd.buildLoadAdConfig().withAdListener(mInterstitialAdListener).build());
        showFB(mSetOnClosed, isFirst);
    }
    private static void loadFB3(setOnClosed mSetOnClosed, boolean isFirst) {
        mFBInterstitialAd = new com.facebook.ads.InterstitialAd(MyApplication.getInstance(), AD.fbinterad3);
        mInterstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }
            @Override
            public void onInterstitialDismissed(Ad ad) {
                onClosed(mSetOnClosed);
            }
            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {
            }
            @Override
            public void onAdLoaded(Ad ad) {
            }
            @Override
            public void onAdClicked(Ad ad) {
            }
            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        mFBInterstitialAd.loadAd(mFBInterstitialAd.buildLoadAdConfig().withAdListener(mInterstitialAdListener).build());
        showFB(mSetOnClosed, isFirst);
    }
    private static void loadFB4(setOnClosed mSetOnClosed, boolean isFirst) {
        mFBInterstitialAd = new com.facebook.ads.InterstitialAd(MyApplication.getInstance(), AD.fbinterad4);
        mInterstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }
            @Override
            public void onInterstitialDismissed(Ad ad) {
                onClosed(mSetOnClosed);
            }
            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {
            }
            @Override
            public void onAdLoaded(Ad ad) {
            }
            @Override
            public void onAdClicked(Ad ad) {
            }
            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        mFBInterstitialAd.loadAd(mFBInterstitialAd.buildLoadAdConfig().withAdListener(mInterstitialAdListener).build());
        showFB(mSetOnClosed, isFirst);
    }
    private static void loadFB5(setOnClosed mSetOnClosed, boolean isFirst) {
        mFBInterstitialAd = new com.facebook.ads.InterstitialAd(MyApplication.getInstance(), AD.fbinterad5);
        mInterstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }
            @Override
            public void onInterstitialDismissed(Ad ad) {
                onClosed(mSetOnClosed);
            }
            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {
            }
            @Override
            public void onAdLoaded(Ad ad) {
            }
            @Override
            public void onAdClicked(Ad ad) {
            }
            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        mFBInterstitialAd.loadAd(mFBInterstitialAd.buildLoadAdConfig().withAdListener(mInterstitialAdListener).build());
        showFB(mSetOnClosed, isFirst);
    }
    public static void show(Activity activity, setOnClosed setOnClosed) {
        mSetOnClosed = setOnClosed;
        mActivity = activity;
        if (AD.prirotyisFb) {
            if (AD.Facebookshow) {
                loadFB(mSetOnClosed, true);
            } else if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        } else {
            if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Facebookshow) {
                loadFB(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        }
    }
    public static void show2(Activity activity, setOnClosed setOnClosed) {
        mSetOnClosed = setOnClosed;
        mActivity = activity;
        if (AD.prirotyisFb) {
            if (AD.Facebookshow) {
                loadFB2(mSetOnClosed, true);
            } else if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        } else {
            if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Facebookshow) {
                loadFB2(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        }
    }
    public static void show3(Activity activity, setOnClosed setOnClosed) {
        mSetOnClosed = setOnClosed;
        mActivity = activity;
        if (AD.prirotyisFb) {
            if (AD.Facebookshow) {
                loadFB3(mSetOnClosed, true);
            } else if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        } else {
            if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Facebookshow) {
                loadFB3(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        }
    }
    public static void show4(Activity activity, setOnClosed setOnClosed) {
        mSetOnClosed = setOnClosed;
        mActivity = activity;
        if (AD.prirotyisFb) {
            if (AD.Facebookshow) {
                loadFB4(mSetOnClosed, true);
            } else if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        } else {
            if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Facebookshow) {
                loadFB4(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        }
    }
    public static void show5(Activity activity, setOnClosed setOnClosed) {
        mSetOnClosed = setOnClosed;
        mActivity = activity;
        if (AD.prirotyisFb) {
            if (AD.Facebookshow) {
                loadFB5(mSetOnClosed, true);
            } else if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        } else {
            if (AD.Admobshow) {
                showGoogle(mSetOnClosed, true);
            } else if (AD.Facebookshow) {
                loadFB5(mSetOnClosed, true);
            } else if (AD.Qurekashow) {
                mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
            }else{
                setOnClosed.onClosed();
            }
        }
    }
    private static void showFB(setOnClosed mSetOnClosed, boolean isFirst) {
        CURR_TIME = 0;
        mRunnable = () -> {
            if (CURR_TIME > MAX_TIME) {
                if (isFirst)
                {
                    if (AD.Admobshow){
                        if (mGoogleInterstitialAd!=null) {
                            showGoogle(mSetOnClosed, false);
                        } else if (AD.Qurekashow) {
                            mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
                        }
                        else onClosed(mSetOnClosed);
                    }
                    else if (AD.Qurekashow){
                        mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
                    }
                    else onClosed(mSetOnClosed);
                }
                else onClosed(mSetOnClosed);
                return;
            }
            if (mFBInterstitialAd == null) {
                if (isFirst) {
                    if (AD.Admobshow){
                        showGoogle(mSetOnClosed, false);
                    }
                    else if (AD.Qurekashow){
                        mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
                    }
                    else onClosed(mSetOnClosed);
                }
                else onClosed(mSetOnClosed);
                return;
            }
            if (mFBInterstitialAd.isAdLoaded()) {
                mFBInterstitialAd.show();
                return;
            }
            CURR_TIME = CURR_TIME + 100;
            mHandler.postDelayed(mRunnable, CURR_TIME);
        };
        mHandler.postDelayed(mRunnable, CURR_TIME);
    }
    private static void showGoogle(setOnClosed mSetOnClosed, boolean isFirst) {
        CURR_TIME = 0;
        mRunnable = () -> {
            if (CURR_TIME > MAX_TIME) {
                if (mGoogleInterstitialAd == null) {
                    loadGoogle();
                    if (isFirst)
                    {
                        if (AD.Facebookshow){
                            loadFB(mSetOnClosed, true);
                        }
                        else if (AD.Qurekashow){
                            mActivity.startActivityForResult(new Intent(mActivity, QurekaActivity.class), 523);
                        }
                        else onClosed(mSetOnClosed);
                    }
                    else onClosed(mSetOnClosed);
                    return;
                }
            }
            if (mGoogleInterstitialAd != null) {
                mGoogleInterstitialAd.show(mActivity);
                return;
            }
            CURR_TIME = CURR_TIME + 100;
            mHandler.postDelayed(mRunnable, CURR_TIME);
        };
        mHandler.postDelayed(mRunnable, CURR_TIME);
    }
    private static void onClosed(setOnClosed mSetOnClosed) {
        mFBInterstitialAd = null;
        if (mSetOnClosed != null) {
            mSetOnClosed.onClosed();
        }
    }
}
