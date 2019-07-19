package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

public class VastCompanionAdConfig
  implements Serializable
{
  private final int a;
  private final int b;
  private final n c;
  private final String d;
  private final List<VastTracker> e;
  private final List<VastTracker> f;

  public VastCompanionAdConfig(int paramInt1, int paramInt2, n paramn, String paramString, List<VastTracker> paramList1, List<VastTracker> paramList2)
  {
    Preconditions.checkNotNull(paramn);
    Preconditions.checkNotNull(paramList1, "clickTrackers cannot be null");
    Preconditions.checkNotNull(paramList2, "creativeViewTrackers cannot be null");
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramn;
    this.d = paramString;
    this.e = paramList1;
    this.f = paramList2;
  }

  void a(Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramContext);
    TrackingRequest.makeVastTrackingHttpRequest(this.f, null, Integer.valueOf(paramInt), null, paramContext);
  }

  void a(final Context paramContext, final int paramInt, String paramString1, final String paramString2)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkArgument(paramContext instanceof Activity, "context must be an activity");
    String str = this.c.getCorrectClickThroughUrl(this.d, paramString1);
    if (TextUtils.isEmpty(str))
      return;
    UrlHandler.Builder localBuilder = new UrlHandler.Builder();
    UrlAction localUrlAction = UrlAction.IGNORE_ABOUT_SCHEME;
    UrlAction[] arrayOfUrlAction = new UrlAction[6];
    arrayOfUrlAction[0] = UrlAction.OPEN_APP_MARKET;
    arrayOfUrlAction[1] = UrlAction.OPEN_NATIVE_BROWSER;
    arrayOfUrlAction[2] = UrlAction.OPEN_IN_APP_BROWSER;
    arrayOfUrlAction[3] = UrlAction.HANDLE_SHARE_TWEET;
    arrayOfUrlAction[4] = UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK;
    arrayOfUrlAction[5] = UrlAction.FOLLOW_DEEP_LINK;
    localBuilder.withSupportedUrlActions(localUrlAction, arrayOfUrlAction).withResultActions(new UrlHandler.ResultActions()
    {
      public void urlHandlingFailed(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
      {
      }

      public void urlHandlingSucceeded(String paramAnonymousString, UrlAction paramAnonymousUrlAction)
      {
        Intent localIntent;
        if (paramAnonymousUrlAction == UrlAction.OPEN_IN_APP_BROWSER)
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("URL", paramAnonymousString);
          if (!TextUtils.isEmpty(paramString2))
            localBundle.putString("mopub-dsp-creative-id", paramString2);
          localIntent = Intents.getStartActivityIntent(paramContext, MoPubBrowser.class, localBundle);
        }
        try
        {
          ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
          return;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = ("Activity " + MoPubBrowser.class.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
          MoPubLog.log(localSdkLogEvent, arrayOfObject);
        }
      }
    }).withDspCreativeId(paramString2).withoutMoPubBrowser().build().handleUrl(paramContext, str);
  }

  public void addClickTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "clickTrackers cannot be null");
    this.e.addAll(paramList);
  }

  public void addCreativeViewTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "creativeViewTrackers cannot be null");
    this.f.addAll(paramList);
  }

  public String getClickThroughUrl()
  {
    return this.d;
  }

  public List<VastTracker> getClickTrackers()
  {
    return this.e;
  }

  public List<VastTracker> getCreativeViewTrackers()
  {
    return this.f;
  }

  public int getHeight()
  {
    return this.b;
  }

  public n getVastResource()
  {
    return this.c;
  }

  public int getWidth()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastCompanionAdConfig
 * JD-Core Version:    0.6.2
 */