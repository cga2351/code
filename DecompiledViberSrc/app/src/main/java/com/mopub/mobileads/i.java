package com.mopub.mobileads;

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
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

class i
  implements Serializable
{
  private final int a;
  private final int b;
  private final int c;
  private final Integer d;
  private final n e;
  private final List<VastTracker> f;
  private final String g;
  private final List<VastTracker> h;

  i(int paramInt1, int paramInt2, Integer paramInteger1, Integer paramInteger2, n paramn, List<VastTracker> paramList1, String paramString, List<VastTracker> paramList2)
  {
    Preconditions.checkNotNull(paramn);
    Preconditions.checkNotNull(paramList1);
    Preconditions.checkNotNull(paramList2);
    this.a = paramInt1;
    this.b = paramInt2;
    if (paramInteger1 == null);
    for (int i = 0; ; i = paramInteger1.intValue())
    {
      this.c = i;
      this.d = paramInteger2;
      this.e = paramn;
      this.f = paramList1;
      this.g = paramString;
      this.h = paramList2;
      return;
    }
  }

  int a()
  {
    return this.a;
  }

  void a(Context paramContext, int paramInt, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    TrackingRequest.makeVastTrackingHttpRequest(this.h, null, Integer.valueOf(paramInt), paramString, paramContext);
  }

  void a(final Context paramContext, String paramString1, final String paramString2)
  {
    Preconditions.checkNotNull(paramContext);
    String str = this.e.getCorrectClickThroughUrl(this.g, paramString1);
    if (TextUtils.isEmpty(str))
      return;
    UrlHandler.Builder localBuilder = new UrlHandler.Builder();
    UrlAction localUrlAction = UrlAction.IGNORE_ABOUT_SCHEME;
    UrlAction[] arrayOfUrlAction = new UrlAction[2];
    arrayOfUrlAction[0] = UrlAction.OPEN_NATIVE_BROWSER;
    arrayOfUrlAction[1] = UrlAction.OPEN_IN_APP_BROWSER;
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
          Intents.startActivity(paramContext, localIntent);
          return;
        }
        catch (IntentNotResolvableException localIntentNotResolvableException)
        {
          MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localIntentNotResolvableException.getMessage();
          MoPubLog.log(localSdkLogEvent, arrayOfObject);
        }
      }
    }).withoutMoPubBrowser().build().handleUrl(paramContext, str);
  }

  int b()
  {
    return this.b;
  }

  int c()
  {
    return this.c;
  }

  Integer d()
  {
    return this.d;
  }

  n e()
  {
    return this.e;
  }

  List<VastTracker> f()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.i
 * JD-Core Version:    0.6.2
 */