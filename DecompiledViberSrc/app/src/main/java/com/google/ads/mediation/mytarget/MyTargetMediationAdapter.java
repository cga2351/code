package com.google.ads.mediation.mytarget;

import android.content.Context;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.my.target.a.a.a;
import com.my.target.common.b;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import java.util.List;

public class MyTargetMediationAdapter extends Adapter
  implements MediationRewardedAd, a.a
{
  private static final e a = ViberEnv.getLogger();
  private com.my.target.a.a b;
  private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> c;
  private MediationRewardedAdCallback d;

  public VersionInfo getSDKVersionInfo()
  {
    String[] arrayOfString = "5.3.11".split("\\.");
    return new VersionInfo(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]), Integer.parseInt(arrayOfString[2]));
  }

  public VersionInfo getVersionInfo()
  {
    String[] arrayOfString = "5.3.9.1".split("\\.");
    return new VersionInfo(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]), 100 * Integer.parseInt(arrayOfString[2]) + Integer.parseInt(arrayOfString[3]));
  }

  public void initialize(Context paramContext, InitializationCompleteCallback paramInitializationCompleteCallback, List<MediationConfiguration> paramList)
  {
    paramInitializationCompleteCallback.onInitializationSucceeded();
  }

  public void loadRewardedAd(MediationRewardedAdConfiguration paramMediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> paramMediationAdLoadCallback)
  {
    Context localContext = paramMediationRewardedAdConfiguration.getContext();
    int i = a.a(localContext, paramMediationRewardedAdConfiguration.getServerParameters());
    e locale = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(i);
    locale.b("Requesting rewarded mediation, slotID: ?", arrayOfObject);
    if (i < 0)
    {
      paramMediationAdLoadCallback.onFailure("Failed to request ad from MyTarget: Internal Error.");
      return;
    }
    this.c = paramMediationAdLoadCallback;
    this.b = new com.my.target.a.a(i, localContext);
    this.b.g().b("mediation", "1");
    this.b.a(this);
    this.b.d();
  }

  public void onClick(com.my.target.a.a parama)
  {
    a.b("Ad clicked", new Object[0]);
    if (this.d != null)
      this.d.reportAdClicked();
  }

  public void onDismiss(com.my.target.a.a parama)
  {
    a.b("Ad dismissed", new Object[0]);
    if (this.d != null)
      this.d.onAdClosed();
  }

  public void onDisplay(com.my.target.a.a parama)
  {
    a.b("Ad displayed", new Object[0]);
    if (this.d != null)
    {
      this.d.onAdOpened();
      this.d.onVideoStart();
      this.d.reportAdImpression();
    }
  }

  public void onLoad(com.my.target.a.a parama)
  {
    a.b("Ad loaded", new Object[0]);
    if (this.c != null)
      this.d = ((MediationRewardedAdCallback)this.c.onSuccess(this));
  }

  public void onNoAd(String paramString, com.my.target.a.a parama)
  {
    String str = "Failed to load ad from MyTarget: " + paramString;
    a.c(str, new Object[0]);
    if (this.c != null)
      this.c.onFailure(str);
  }

  public void onVideoCompleted(com.my.target.a.a parama)
  {
    a.b("Video completed", new Object[0]);
    if (this.d != null)
    {
      this.d.onVideoComplete();
      this.d.onUserEarnedReward(new a(null));
    }
  }

  public void showAd(Context paramContext)
  {
    a.b("Show video", new Object[0]);
    if (this.b != null)
      this.b.e();
    while (this.d == null)
      return;
    this.d.onAdFailedToShow("Rewarded Video is null.");
  }

  private static class a
    implements RewardItem
  {
    public int getAmount()
    {
      return 1;
    }

    public String getType()
    {
      return "";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.mytarget.MyTargetMediationAdapter
 * JD-Core Version:    0.6.2
 */