package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Strings;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VastVideoConfig
  implements Serializable
{
  private final Set<String> A = new HashSet();
  private String B;
  private String C;
  private String D;
  private boolean E;
  private final ArrayList<VastTracker> a = new ArrayList();
  private final ArrayList<VastFractionalProgressTracker> b = new ArrayList();
  private final ArrayList<VastAbsoluteProgressTracker> c = new ArrayList();
  private final ArrayList<VastTracker> d = new ArrayList();
  private final ArrayList<VastTracker> e = new ArrayList();
  private final ArrayList<VastTracker> f = new ArrayList();
  private final ArrayList<VastTracker> g = new ArrayList();
  private final ArrayList<VastTracker> h = new ArrayList();
  private final ArrayList<VastTracker> i = new ArrayList();
  private final ArrayList<VastTracker> j = new ArrayList();
  private String k;
  private String l;
  private String m;
  private String n;
  private VastCompanionAdConfig o;
  private VastCompanionAdConfig p;
  private Map<String, VastCompanionAdConfig> q = new HashMap();
  private i r;
  private boolean s = false;
  private String t;
  private String u;
  private String v;
  private DeviceUtils.ForceOrientation w = DeviceUtils.ForceOrientation.FORCE_LANDSCAPE;
  private VideoViewabilityTracker x;
  private final Map<String, String> y = new HashMap();
  private final Set<String> z = new HashSet();

  private List<String> a(String paramString, JSONArray paramJSONArray)
  {
    Preconditions.checkNotNull(paramJSONArray);
    if (paramString == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i1);
      if (str == null);
      while (true)
      {
        i1++;
        break;
        localArrayList.add(str.replace("%%VIDEO_EVENT%%", paramString));
      }
    }
    return localArrayList;
  }

  private List<VastTracker> a(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastTracker((String)localIterator.next()));
    return localArrayList;
  }

  private void a(final Context paramContext, int paramInt, final Integer paramInteger)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    TrackingRequest.makeVastTrackingHttpRequest(this.i, null, Integer.valueOf(paramInt), this.l, paramContext);
    if (TextUtils.isEmpty(this.k))
      return;
    UrlHandler.Builder localBuilder = new UrlHandler.Builder().withDspCreativeId(this.B);
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
        if (paramAnonymousUrlAction == UrlAction.OPEN_IN_APP_BROWSER)
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("URL", paramAnonymousString);
          localBundle.putString("mopub-dsp-creative-id", VastVideoConfig.a(VastVideoConfig.this));
          Intent localIntent = Intents.getStartActivityIntent(paramContext, MoPubBrowser.class, localBundle);
          try
          {
            if ((paramContext instanceof Activity))
            {
              Preconditions.checkNotNull(paramInteger);
              ((Activity)paramContext).startActivityForResult(localIntent, paramInteger.intValue());
              return;
            }
            Intents.startActivity(paramContext, localIntent);
            return;
          }
          catch (ActivityNotFoundException localActivityNotFoundException)
          {
            MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = ("Activity " + MoPubBrowser.class.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
            return;
          }
          catch (IntentNotResolvableException localIntentNotResolvableException)
          {
            MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = ("Activity " + MoPubBrowser.class.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
          }
        }
      }
    }).withoutMoPubBrowser().build().handleUrl(paramContext, this.k);
  }

  private void a(List<String> paramList, float paramFloat)
  {
    Preconditions.checkNotNull(paramList);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastFractionalProgressTracker((String)localIterator.next(), paramFloat));
    addFractionalTrackers(localArrayList);
  }

  private void b(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList);
    addCompleteTrackers(a(paramList));
  }

  private void c(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastAbsoluteProgressTracker((String)localIterator.next(), 0));
    addAbsoluteTrackers(localArrayList);
  }

  private void d(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList);
    if (hasCompanionAd())
    {
      List localList = a(paramList);
      this.o.addCreativeViewTrackers(localList);
      this.p.addCreativeViewTrackers(localList);
    }
  }

  private void e(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList);
    if (hasCompanionAd())
    {
      List localList = a(paramList);
      this.o.addClickTrackers(localList);
      this.p.addClickTrackers(localList);
    }
  }

  public void addAbsoluteTrackers(List<VastAbsoluteProgressTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "absoluteTrackers cannot be null");
    this.c.addAll(paramList);
    Collections.sort(this.c);
  }

  public void addAvidJavascriptResources(Set<String> paramSet)
  {
    if (paramSet != null)
      this.z.addAll(paramSet);
  }

  public void addClickTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "clickTrackers cannot be null");
    this.i.addAll(paramList);
  }

  public void addCloseTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "closeTrackers cannot be null");
    this.g.addAll(paramList);
  }

  public void addCompleteTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "completeTrackers cannot be null");
    this.f.addAll(paramList);
  }

  public void addErrorTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "errorTrackers cannot be null");
    this.j.addAll(paramList);
  }

  public void addExternalViewabilityTrackers(Map<String, String> paramMap)
  {
    if (paramMap != null)
      this.y.putAll(paramMap);
  }

  public void addFractionalTrackers(List<VastFractionalProgressTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "fractionalTrackers cannot be null");
    this.b.addAll(paramList);
    Collections.sort(this.b);
  }

  public void addImpressionTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "impressionTrackers cannot be null");
    this.a.addAll(paramList);
  }

  public void addMoatImpressionPixels(Set<String> paramSet)
  {
    if (paramSet != null)
      this.A.addAll(paramSet);
  }

  public void addPauseTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "pauseTrackers cannot be null");
    this.d.addAll(paramList);
  }

  public void addResumeTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "resumeTrackers cannot be null");
    this.e.addAll(paramList);
  }

  public void addSkipTrackers(List<VastTracker> paramList)
  {
    Preconditions.checkNotNull(paramList, "skipTrackers cannot be null");
    this.h.addAll(paramList);
  }

  public void addVideoTrackers(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null);
    JSONArray localJSONArray1;
    JSONArray localJSONArray2;
    do
    {
      return;
      localJSONArray1 = paramJSONObject.optJSONArray("urls");
      localJSONArray2 = paramJSONObject.optJSONArray("events");
    }
    while ((localJSONArray1 == null) || (localJSONArray2 == null));
    int i1 = 0;
    label32: String str;
    List localList;
    r localr;
    if (i1 < localJSONArray2.length())
    {
      str = localJSONArray2.optString(i1);
      localList = a(str, localJSONArray1);
      localr = r.fromString(str);
      if ((str != null) && (localList != null))
        break label81;
    }
    while (true)
    {
      i1++;
      break label32;
      break;
      label81: switch (2.a[localr.ordinal()])
      {
      default:
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("Encountered unknown video tracking event: " + str);
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
        break;
      case 1:
        c(localList);
        break;
      case 2:
        a(localList, 0.25F);
        break;
      case 3:
        a(localList, 0.5F);
        break;
      case 4:
        a(localList, 0.75F);
        break;
      case 5:
        b(localList);
        break;
      case 6:
        d(localList);
        break;
      case 7:
        e(localList);
      }
    }
  }

  public ArrayList<VastAbsoluteProgressTracker> getAbsoluteTrackers()
  {
    return this.c;
  }

  public Set<String> getAvidJavascriptResources()
  {
    return this.z;
  }

  public String getClickThroughUrl()
  {
    return this.k;
  }

  public List<VastTracker> getClickTrackers()
  {
    return this.i;
  }

  public List<VastTracker> getCloseTrackers()
  {
    return this.g;
  }

  public List<VastTracker> getCompleteTrackers()
  {
    return this.f;
  }

  public String getCustomCloseIconUrl()
  {
    return this.v;
  }

  public String getCustomCtaText()
  {
    return this.t;
  }

  public DeviceUtils.ForceOrientation getCustomForceOrientation()
  {
    return this.w;
  }

  public String getCustomSkipText()
  {
    return this.u;
  }

  public String getDiskMediaFileUrl()
  {
    return this.m;
  }

  public String getDspCreativeId()
  {
    return this.B;
  }

  public List<VastTracker> getErrorTrackers()
  {
    return this.j;
  }

  public Map<String, String> getExternalViewabilityTrackers()
  {
    return this.y;
  }

  public ArrayList<VastFractionalProgressTracker> getFractionalTrackers()
  {
    return this.b;
  }

  public List<VastTracker> getImpressionTrackers()
  {
    return this.a;
  }

  public Set<String> getMoatImpressionPixels()
  {
    return this.A;
  }

  public String getNetworkMediaFileUrl()
  {
    return this.l;
  }

  public List<VastTracker> getPauseTrackers()
  {
    return this.d;
  }

  public String getPrivacyInformationIconClickthroughUrl()
  {
    return this.D;
  }

  public String getPrivacyInformationIconImageUrl()
  {
    return this.C;
  }

  public int getRemainingProgressTrackerCount()
  {
    return getUntriggeredTrackersBefore(2147483647, 2147483647).size();
  }

  public List<VastTracker> getResumeTrackers()
  {
    return this.e;
  }

  public Integer getSkipOffsetMillis(int paramInt)
  {
    String str = this.n;
    Object localObject = null;
    if (str != null)
    {
      try
      {
        if (Strings.isAbsoluteTracker(this.n));
        for (Integer localInteger1 = Strings.parseAbsoluteOffset(this.n); ; localInteger1 = Integer.valueOf(Math.round(Float.parseFloat(this.n.replace("%", "")) / 100.0F * paramInt)))
        {
          localObject = null;
          if (localInteger1 == null)
            break label196;
          if (localInteger1.intValue() >= paramInt)
            break label187;
          return localInteger1;
          if (!Strings.isPercentageTracker(this.n))
            break;
        }
        MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject3 = new Object[1];
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = this.n;
        arrayOfObject3[0] = String.format("Invalid VAST skipoffset format: %s", arrayOfObject4);
        MoPubLog.log(localSdkLogEvent2, arrayOfObject3);
        return null;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject1 = new Object[1];
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.n;
        arrayOfObject1[0] = String.format("Failed to parse skipoffset %s", arrayOfObject2);
        MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
        return null;
      }
      label187: Integer localInteger2 = Integer.valueOf(paramInt);
      localObject = localInteger2;
    }
    label196: return localObject;
  }

  public String getSkipOffsetString()
  {
    return this.n;
  }

  public List<VastTracker> getSkipTrackers()
  {
    return this.h;
  }

  public Map<String, VastCompanionAdConfig> getSocialActionsCompanionAds()
  {
    return this.q;
  }

  public List<VastTracker> getUntriggeredTrackersBefore(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    boolean bool;
    ArrayList localArrayList;
    int i3;
    label62: VastAbsoluteProgressTracker localVastAbsoluteProgressTracker2;
    VastFractionalProgressTracker localVastFractionalProgressTracker1;
    int i4;
    if (paramInt2 > 0)
    {
      bool = true;
      if ((!Preconditions.NoThrow.checkArgument(bool)) || (paramInt1 < 0))
        break label202;
      float f1 = paramInt1 / paramInt2;
      localArrayList = new ArrayList();
      VastAbsoluteProgressTracker localVastAbsoluteProgressTracker1 = new VastAbsoluteProgressTracker("", paramInt1);
      int i2 = this.c.size();
      i3 = 0;
      if (i3 < i2)
      {
        localVastAbsoluteProgressTracker2 = (VastAbsoluteProgressTracker)this.c.get(i3);
        if (localVastAbsoluteProgressTracker2.compareTo(localVastAbsoluteProgressTracker1) <= 0)
          break label154;
      }
      localVastFractionalProgressTracker1 = new VastFractionalProgressTracker("", f1);
      i4 = this.b.size();
    }
    while (true)
    {
      VastFractionalProgressTracker localVastFractionalProgressTracker2;
      if (i1 < i4)
      {
        localVastFractionalProgressTracker2 = (VastFractionalProgressTracker)this.b.get(i1);
        if (localVastFractionalProgressTracker2.compareTo(localVastFractionalProgressTracker1) <= 0);
      }
      else
      {
        return localArrayList;
        bool = false;
        break;
        label154: if (!localVastAbsoluteProgressTracker2.isTracked())
          localArrayList.add(localVastAbsoluteProgressTracker2);
        i3++;
        break label62;
      }
      if (!localVastFractionalProgressTracker2.isTracked())
        localArrayList.add(localVastFractionalProgressTracker2);
      i1++;
    }
    label202: return Collections.emptyList();
  }

  public VastCompanionAdConfig getVastCompanionAd(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return this.o;
    case 1:
      return this.p;
    case 2:
    }
    return this.o;
  }

  public i getVastIconConfig()
  {
    return this.r;
  }

  public VideoViewabilityTracker getVideoViewabilityTracker()
  {
    return this.x;
  }

  public void handleClickForResult(Activity paramActivity, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramInt1, Integer.valueOf(paramInt2));
  }

  public void handleClickWithoutResult(Context paramContext, int paramInt)
  {
    a(paramContext.getApplicationContext(), paramInt, null);
  }

  public void handleClose(Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    TrackingRequest.makeVastTrackingHttpRequest(this.g, null, Integer.valueOf(paramInt), this.l, paramContext);
    TrackingRequest.makeVastTrackingHttpRequest(this.h, null, Integer.valueOf(paramInt), this.l, paramContext);
  }

  public void handleComplete(Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    TrackingRequest.makeVastTrackingHttpRequest(this.f, null, Integer.valueOf(paramInt), this.l, paramContext);
  }

  public void handleError(Context paramContext, VastErrorCode paramVastErrorCode, int paramInt)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    TrackingRequest.makeVastTrackingHttpRequest(this.j, paramVastErrorCode, Integer.valueOf(paramInt), this.l, paramContext);
  }

  public void handleImpression(Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    TrackingRequest.makeVastTrackingHttpRequest(this.a, null, Integer.valueOf(paramInt), this.l, paramContext);
  }

  public void handlePause(Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    TrackingRequest.makeVastTrackingHttpRequest(this.d, null, Integer.valueOf(paramInt), this.l, paramContext);
  }

  public void handleResume(Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    TrackingRequest.makeVastTrackingHttpRequest(this.e, null, Integer.valueOf(paramInt), this.l, paramContext);
  }

  public boolean hasCompanionAd()
  {
    return (this.o != null) && (this.p != null);
  }

  public boolean isCustomForceOrientationSet()
  {
    return this.E;
  }

  public boolean isRewardedVideo()
  {
    return this.s;
  }

  public void setClickThroughUrl(String paramString)
  {
    this.k = paramString;
  }

  public void setCustomCloseIconUrl(String paramString)
  {
    if (paramString != null)
      this.v = paramString;
  }

  public void setCustomCtaText(String paramString)
  {
    if (paramString != null)
      this.t = paramString;
  }

  public void setCustomForceOrientation(DeviceUtils.ForceOrientation paramForceOrientation)
  {
    if ((paramForceOrientation != null) && (paramForceOrientation != DeviceUtils.ForceOrientation.UNDEFINED))
    {
      this.w = paramForceOrientation;
      this.E = true;
    }
  }

  public void setCustomSkipText(String paramString)
  {
    if (paramString != null)
      this.u = paramString;
  }

  public void setDiskMediaFileUrl(String paramString)
  {
    this.m = paramString;
  }

  public void setDspCreativeId(String paramString)
  {
    this.B = paramString;
  }

  public void setIsRewardedVideo(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public void setNetworkMediaFileUrl(String paramString)
  {
    this.l = paramString;
  }

  public void setPrivacyInformationIconClickthroughUrl(String paramString)
  {
    this.D = paramString;
  }

  public void setPrivacyInformationIconImageUrl(String paramString)
  {
    this.C = paramString;
  }

  public void setSkipOffset(String paramString)
  {
    if (paramString != null)
      this.n = paramString;
  }

  public void setSocialActionsCompanionAds(Map<String, VastCompanionAdConfig> paramMap)
  {
    this.q = paramMap;
  }

  public void setVastCompanionAd(VastCompanionAdConfig paramVastCompanionAdConfig1, VastCompanionAdConfig paramVastCompanionAdConfig2)
  {
    this.o = paramVastCompanionAdConfig1;
    this.p = paramVastCompanionAdConfig2;
  }

  public void setVastIconConfig(i parami)
  {
    this.r = parami;
  }

  public void setVideoViewabilityTracker(VideoViewabilityTracker paramVideoViewabilityTracker)
  {
    if (paramVideoViewabilityTracker != null)
      this.x = paramVideoViewabilityTracker;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoConfig
 * JD-Core Version:    0.6.2
 */