package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.VastVideoConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class ExternalViewabilitySessionManager
{
  private final Set<ExternalViewabilitySession> a;

  public ExternalViewabilitySessionManager(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.a = new HashSet();
    this.a.add(new b());
    this.a.add(new f());
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      a(localExternalViewabilitySession, "initialize", localExternalViewabilitySession.initialize(paramContext), false);
    }
  }

  private void a(ExternalViewabilitySession paramExternalViewabilitySession, String paramString, Boolean paramBoolean, boolean paramBoolean1)
  {
    Preconditions.checkNotNull(paramExternalViewabilitySession);
    Preconditions.checkNotNull(paramString);
    if (paramBoolean == null)
      return;
    if (paramBoolean.booleanValue());
    for (String str1 = ""; ; str1 = "failed to ")
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramExternalViewabilitySession.getName();
      arrayOfObject[1] = str1;
      arrayOfObject[2] = paramString;
      String str2 = String.format(localLocale, "%s viewability event: %s%s.", arrayOfObject);
      if (!paramBoolean1)
        break;
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { str2 });
      return;
    }
  }

  public void createDisplaySession(Context paramContext, WebView paramWebView)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramWebView);
    createDisplaySession(paramContext, paramWebView, false);
  }

  public void createDisplaySession(Context paramContext, WebView paramWebView, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramWebView);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      a(localExternalViewabilitySession, "start display session", localExternalViewabilitySession.createDisplaySession(paramContext, paramWebView, paramBoolean), true);
    }
  }

  public void createVideoSession(Activity paramActivity, View paramView, VastVideoConfig paramVastVideoConfig)
  {
    Preconditions.checkNotNull(paramActivity);
    Preconditions.checkNotNull(paramView);
    Preconditions.checkNotNull(paramVastVideoConfig);
    Iterator localIterator = this.a.iterator();
    if (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      HashSet localHashSet = new HashSet();
      if ((localExternalViewabilitySession instanceof b))
        localHashSet.addAll(paramVastVideoConfig.getAvidJavascriptResources());
      while (true)
      {
        a(localExternalViewabilitySession, "start video session", localExternalViewabilitySession.createVideoSession(paramActivity, paramView, localHashSet, paramVastVideoConfig.getExternalViewabilityTrackers()), true);
        break;
        if ((localExternalViewabilitySession instanceof f))
          localHashSet.addAll(paramVastVideoConfig.getMoatImpressionPixels());
      }
    }
  }

  public void endDisplaySession()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      a(localExternalViewabilitySession, "end display session", localExternalViewabilitySession.endDisplaySession(), true);
    }
  }

  public void endVideoSession()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      a(localExternalViewabilitySession, "end video session", localExternalViewabilitySession.endVideoSession(), true);
    }
  }

  public void invalidate()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      a(localExternalViewabilitySession, "invalidate", localExternalViewabilitySession.invalidate(), false);
    }
  }

  public void onVideoPrepared(View paramView, int paramInt)
  {
    Preconditions.checkNotNull(paramView);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      a(localExternalViewabilitySession, "on video prepared", localExternalViewabilitySession.onVideoPrepared(paramView, paramInt), true);
    }
  }

  public void recordVideoEvent(ExternalViewabilitySession.VideoEvent paramVideoEvent, int paramInt)
  {
    Preconditions.checkNotNull(paramVideoEvent);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      Boolean localBoolean = localExternalViewabilitySession.recordVideoEvent(paramVideoEvent, paramInt);
      a(localExternalViewabilitySession, "record video event (" + paramVideoEvent.name() + ")", localBoolean, true);
    }
  }

  public void registerVideoObstruction(View paramView)
  {
    Preconditions.checkNotNull(paramView);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      a(localExternalViewabilitySession, "register friendly obstruction", localExternalViewabilitySession.registerVideoObstruction(paramView), true);
    }
  }

  public void startDeferredDisplaySession(Activity paramActivity)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ExternalViewabilitySession localExternalViewabilitySession = (ExternalViewabilitySession)localIterator.next();
      a(localExternalViewabilitySession, "record deferred session", localExternalViewabilitySession.startDeferredDisplaySession(paramActivity), true);
    }
  }

  public static enum ViewabilityVendor
  {
    static
    {
      ALL = new ViewabilityVendor("ALL", 2);
      ViewabilityVendor[] arrayOfViewabilityVendor = new ViewabilityVendor[3];
      arrayOfViewabilityVendor[0] = AVID;
      arrayOfViewabilityVendor[1] = MOAT;
      arrayOfViewabilityVendor[2] = ALL;
    }

    public static ViewabilityVendor fromKey(String paramString)
    {
      Preconditions.checkNotNull(paramString);
      int i = -1;
      switch (paramString.hashCode())
      {
      default:
      case 49:
      case 50:
      case 51:
      }
      while (true)
        switch (i)
        {
        default:
          return null;
          if (paramString.equals("1"))
          {
            i = 0;
            continue;
            if (paramString.equals("2"))
            {
              i = 1;
              continue;
              if (paramString.equals("3"))
                i = 2;
            }
          }
          break;
        case 0:
        case 1:
        case 2:
        }
      return AVID;
      return MOAT;
      return ALL;
    }

    public static String getEnabledVendorKey()
    {
      boolean bool1 = b.a();
      boolean bool2 = f.a();
      String str = "0";
      if ((bool1) && (bool2))
        str = "3";
      do
      {
        return str;
        if (bool1)
          return "1";
      }
      while (!bool2);
      return "2";
    }

    public void disable()
    {
      switch (ExternalViewabilitySessionManager.1.a[ordinal()])
      {
      default:
        MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = ("Attempted to disable an invalid viewability vendor: " + this);
        MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
        return;
      case 1:
        b.b();
      case 2:
      case 3:
      }
      while (true)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = ("Disabled viewability for " + this);
        MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
        return;
        f.b();
        continue;
        b.b();
        f.b();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.ExternalViewabilitySessionManager
 * JD-Core Version:    0.6.2
 */