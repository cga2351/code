package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.util.Numbers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class MoPubCustomEventNative extends CustomEventNative
{
  public static final String ADAPTER_NAME = MoPubCustomEventNative.class.getSimpleName();
  private a a;

  protected void a()
  {
    if (this.a == null)
      return;
    this.a.invalidate();
  }

  protected void a(Context paramContext, CustomEventNative.CustomEventNativeListener paramCustomEventNativeListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    MoPubLog.AdapterLogEvent localAdapterLogEvent1 = MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ADAPTER_NAME;
    MoPubLog.log(localAdapterLogEvent1, arrayOfObject1);
    if ((this.a != null) && (!this.a.isInvalidated()))
      return;
    Object localObject = paramMap.get("com_mopub_native_json");
    if (!(localObject instanceof JSONObject))
    {
      MoPubLog.AdapterLogEvent localAdapterLogEvent7 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
      Object[] arrayOfObject7 = new Object[3];
      arrayOfObject7[0] = ADAPTER_NAME;
      arrayOfObject7[1] = Integer.valueOf(NativeErrorCode.INVALID_RESPONSE.getIntCode());
      arrayOfObject7[2] = NativeErrorCode.INVALID_RESPONSE;
      MoPubLog.log(localAdapterLogEvent7, arrayOfObject7);
      paramCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
      return;
    }
    this.a = new a(paramContext, (JSONObject)localObject, new ImpressionTracker(paramContext), new NativeClickHandler(paramContext), paramCustomEventNativeListener);
    if (paramMap1.containsKey("impression-min-visible-percent"));
    try
    {
      this.a.setImpressionMinPercentageViewed(Integer.parseInt((String)paramMap1.get("impression-min-visible-percent")));
      if (!paramMap1.containsKey("impression-visible-ms"));
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      try
      {
        this.a.setImpressionMinTimeViewed(Integer.parseInt((String)paramMap1.get("impression-visible-ms")));
        if (!paramMap1.containsKey("impression-min-visible-px"));
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          while (true)
          {
            this.a.setImpressionMinVisiblePx(Integer.valueOf(Integer.parseInt((String)paramMap1.get("impression-min-visible-px"))));
            try
            {
              this.a.e();
              MoPubLog.AdapterLogEvent localAdapterLogEvent3 = MoPubLog.AdapterLogEvent.LOAD_SUCCESS;
              Object[] arrayOfObject3 = new Object[1];
              arrayOfObject3[0] = ADAPTER_NAME;
              MoPubLog.log(localAdapterLogEvent3, arrayOfObject3);
              return;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              MoPubLog.AdapterLogEvent localAdapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
              Object[] arrayOfObject2 = new Object[3];
              arrayOfObject2[0] = ADAPTER_NAME;
              arrayOfObject2[1] = Integer.valueOf(NativeErrorCode.UNSPECIFIED.getIntCode());
              arrayOfObject2[2] = NativeErrorCode.UNSPECIFIED;
              MoPubLog.log(localAdapterLogEvent2, arrayOfObject2);
              paramCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
              return;
            }
            localNumberFormatException3 = localNumberFormatException3;
            MoPubLog.AdapterLogEvent localAdapterLogEvent6 = MoPubLog.AdapterLogEvent.CUSTOM;
            Object[] arrayOfObject6 = new Object[2];
            arrayOfObject6[0] = ADAPTER_NAME;
            arrayOfObject6[1] = ("Unable to format min visible percent: " + (String)paramMap1.get("impression-min-visible-percent"));
            MoPubLog.log(localAdapterLogEvent6, arrayOfObject6);
          }
          localNumberFormatException2 = localNumberFormatException2;
          MoPubLog.AdapterLogEvent localAdapterLogEvent5 = MoPubLog.AdapterLogEvent.CUSTOM;
          Object[] arrayOfObject5 = new Object[2];
          arrayOfObject5[0] = ADAPTER_NAME;
          arrayOfObject5[1] = ("Unable to format min time: " + (String)paramMap1.get("impression-visible-ms"));
          MoPubLog.log(localAdapterLogEvent5, arrayOfObject5);
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          while (true)
          {
            MoPubLog.AdapterLogEvent localAdapterLogEvent4 = MoPubLog.AdapterLogEvent.CUSTOM;
            Object[] arrayOfObject4 = new Object[2];
            arrayOfObject4[0] = ADAPTER_NAME;
            arrayOfObject4[1] = ("Unable to format min visible px: " + (String)paramMap1.get("impression-min-visible-px"));
            MoPubLog.log(localAdapterLogEvent4, arrayOfObject4);
          }
        }
      }
    }
  }

  static class a extends StaticNativeAd
  {
    private final Context a;
    private final CustomEventNative.CustomEventNativeListener b;
    private final JSONObject c;
    private final ImpressionTracker d;
    private final NativeClickHandler e;

    a(Context paramContext, JSONObject paramJSONObject, ImpressionTracker paramImpressionTracker, NativeClickHandler paramNativeClickHandler, CustomEventNative.CustomEventNativeListener paramCustomEventNativeListener)
    {
      this.c = paramJSONObject;
      this.a = paramContext.getApplicationContext();
      this.d = paramImpressionTracker;
      this.e = paramNativeClickHandler;
      this.b = paramCustomEventNativeListener;
    }

    private void a(a parama, Object paramObject)
      throws ClassCastException
    {
      try
      {
        switch (MoPubCustomEventNative.1.a[parama.ordinal()])
        {
        default:
          MoPubLog.AdapterLogEvent localAdapterLogEvent2 = MoPubLog.AdapterLogEvent.CUSTOM;
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = MoPubCustomEventNative.ADAPTER_NAME;
          arrayOfObject2[1] = ("Unable to add JSON key to internal mapping: " + parama.a);
          MoPubLog.log(localAdapterLogEvent2, arrayOfObject2);
          return;
        case 1:
          setMainImageUrl((String)paramObject);
          return;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        }
      }
      catch (ClassCastException localClassCastException)
      {
        if (!parama.b)
        {
          MoPubLog.AdapterLogEvent localAdapterLogEvent1 = MoPubLog.AdapterLogEvent.CUSTOM;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = MoPubCustomEventNative.ADAPTER_NAME;
          arrayOfObject1[1] = ("Ignoring class cast exception for optional key: " + parama.a);
          MoPubLog.log(localAdapterLogEvent1, arrayOfObject1);
          return;
          setIconImageUrl((String)paramObject);
          return;
          a(paramObject);
          return;
          setClickDestinationUrl((String)paramObject);
          return;
          c(paramObject);
          return;
          setCallToAction((String)paramObject);
          return;
          setTitle((String)paramObject);
          return;
          setText((String)paramObject);
          return;
          setStarRating(Numbers.parseDouble(paramObject));
          return;
          setPrivacyInformationIconImageUrl((String)paramObject);
          return;
          setPrivacyInformationIconClickThroughUrl((String)paramObject);
          return;
        }
        throw localClassCastException;
      }
    }

    private boolean a(String paramString)
    {
      return (paramString != null) && (paramString.toLowerCase(Locale.US).endsWith("image"));
    }

    private boolean a(JSONObject paramJSONObject)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
        localHashSet.add(localIterator.next());
      return localHashSet.containsAll(a.c);
    }

    private void c(Object paramObject)
    {
      if ((paramObject instanceof JSONArray))
      {
        b(paramObject);
        return;
      }
      addClickTracker((String)paramObject);
    }

    public void clear(View paramView)
    {
      this.d.removeView(paramView);
      this.e.clearOnClickListener(paramView);
    }

    public void destroy()
    {
      this.d.destroy();
      super.destroy();
    }

    void e()
      throws IllegalArgumentException
    {
      if (!a(this.c))
        throw new IllegalArgumentException("JSONObject did not contain required keys.");
      Iterator localIterator = this.c.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a locala = a.a(str);
        if (locala != null)
          try
          {
            a(locala, this.c.opt(str));
          }
          catch (ClassCastException localClassCastException)
          {
            throw new IllegalArgumentException("JSONObject key (" + str + ") contained unexpected value.");
          }
        else
          addExtra(str, this.c.opt(str));
      }
      if (TextUtils.isEmpty(getPrivacyInformationIconClickThroughUrl()))
        setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout");
      NativeImageHelper.preCacheImages(this.a, g(), new NativeImageHelper.ImageListener()
      {
        public void onImagesCached()
        {
          if (MoPubCustomEventNative.a.this.isInvalidated())
            return;
          MoPubCustomEventNative.a.a(MoPubCustomEventNative.a.this).onNativeAdLoaded(MoPubCustomEventNative.a.this);
        }

        public void onImagesFailedToCache(NativeErrorCode paramAnonymousNativeErrorCode)
        {
          if (MoPubCustomEventNative.a.this.isInvalidated())
            return;
          MoPubCustomEventNative.a.a(MoPubCustomEventNative.a.this).onNativeAdFailed(paramAnonymousNativeErrorCode);
        }
      });
    }

    List<String> f()
    {
      ArrayList localArrayList = new ArrayList(getExtras().size());
      Iterator localIterator = getExtras().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((a((String)localEntry.getKey())) && ((localEntry.getValue() instanceof String)))
          localArrayList.add((String)localEntry.getValue());
      }
      return localArrayList;
    }

    List<String> g()
    {
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(getMainImageUrl()))
        localArrayList.add(getMainImageUrl());
      if (!TextUtils.isEmpty(getIconImageUrl()))
        localArrayList.add(getIconImageUrl());
      if (!TextUtils.isEmpty(getPrivacyInformationIconImageUrl()))
        localArrayList.add(getPrivacyInformationIconImageUrl());
      localArrayList.addAll(f());
      return localArrayList;
    }

    public void handleClick(View paramView)
    {
      MoPubLog.AdapterLogEvent localAdapterLogEvent = MoPubLog.AdapterLogEvent.CLICKED;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = MoPubCustomEventNative.ADAPTER_NAME;
      MoPubLog.log(localAdapterLogEvent, arrayOfObject);
      b();
      this.e.openClickDestinationUrl(getClickDestinationUrl(), paramView);
    }

    public void prepare(View paramView)
    {
      this.d.addView(paramView, this);
      this.e.setOnClickListener(paramView, this);
    }

    public void recordImpression(View paramView)
    {
      a();
    }

    static enum a
    {

      @VisibleForTesting
      static final Set<String> c;
      final String a;
      final boolean b;

      static
      {
        int i = 0;
        IMPRESSION_TRACKER = new a("IMPRESSION_TRACKER", 0, "imptracker", true);
        CLICK_TRACKER = new a("CLICK_TRACKER", 1, "clktracker", true);
        TITLE = new a("TITLE", 2, "title", false);
        TEXT = new a("TEXT", 3, "text", false);
        MAIN_IMAGE = new a("MAIN_IMAGE", 4, "mainimage", false);
        ICON_IMAGE = new a("ICON_IMAGE", 5, "iconimage", false);
        CLICK_DESTINATION = new a("CLICK_DESTINATION", 6, "clk", false);
        FALLBACK = new a("FALLBACK", 7, "fallback", false);
        CALL_TO_ACTION = new a("CALL_TO_ACTION", 8, "ctatext", false);
        STAR_RATING = new a("STAR_RATING", 9, "starrating", false);
        PRIVACY_INFORMATION_ICON_IMAGE_URL = new a("PRIVACY_INFORMATION_ICON_IMAGE_URL", 10, "privacyicon", false);
        PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL = new a("PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL", 11, "privacyclkurl", false);
        a[] arrayOfa1 = new a[12];
        arrayOfa1[0] = IMPRESSION_TRACKER;
        arrayOfa1[1] = CLICK_TRACKER;
        arrayOfa1[2] = TITLE;
        arrayOfa1[3] = TEXT;
        arrayOfa1[4] = MAIN_IMAGE;
        arrayOfa1[5] = ICON_IMAGE;
        arrayOfa1[6] = CLICK_DESTINATION;
        arrayOfa1[7] = FALLBACK;
        arrayOfa1[8] = CALL_TO_ACTION;
        arrayOfa1[9] = STAR_RATING;
        arrayOfa1[10] = PRIVACY_INFORMATION_ICON_IMAGE_URL;
        arrayOfa1[11] = PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL;
        d = arrayOfa1;
        c = new HashSet();
        a[] arrayOfa2 = values();
        int j = arrayOfa2.length;
        while (i < j)
        {
          a locala = arrayOfa2[i];
          if (locala.b)
            c.add(locala.a);
          i++;
        }
      }

      private a(String paramString, boolean paramBoolean)
      {
        this.a = paramString;
        this.b = paramBoolean;
      }

      static a a(String paramString)
      {
        for (a locala : values())
          if (locala.a.equals(paramString))
            return locala;
        return null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.MoPubCustomEventNative
 * JD-Core Version:    0.6.2
 */