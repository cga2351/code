package com.appnexus.opensdk;

import android.content.Context;
import android.graphics.Bitmap;
import com.appnexus.opensdk.ut.UTRequestParameters;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import com.appnexus.opensdk.utils.AdvertisingIDUtil;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.ImageService;
import com.appnexus.opensdk.utils.ImageService.ImageReceiver;
import com.appnexus.opensdk.utils.ImageService.ImageServiceListener;
import java.util.ArrayList;
import java.util.HashMap;

public class NativeAdRequest
  implements b
{
  boolean a = false;
  private NativeAdRequestListener b;
  private final UTRequestParameters c;
  private final d d;
  private final a e;
  private boolean f;
  private boolean g;

  public NativeAdRequest(Context paramContext, String paramString)
  {
    AdvertisingIDUtil.retrieveAndSetAAID(paramContext);
    this.c = new UTRequestParameters(paramContext);
    this.c.setPlacementID(paramString);
    this.c.setMediaType(MediaType.NATIVE);
    a();
    this.d = new d(this);
    this.d.a(-1);
    this.e = new a();
    Clog.setErrorContext(paramContext.getApplicationContext());
  }

  public NativeAdRequest(Context paramContext, String paramString, int paramInt)
  {
    AdvertisingIDUtil.retrieveAndSetAAID(paramContext);
    this.c = new UTRequestParameters(paramContext);
    this.c.setInventoryCodeAndMemberID(paramInt, paramString);
    this.c.setMediaType(MediaType.NATIVE);
    a();
    this.d = new d(this);
    this.d.a(-1);
    this.e = new a();
    Clog.setErrorContext(paramContext.getApplicationContext());
  }

  protected void a()
  {
    Clog.d(Clog.nativeLogTag, Clog.getString(R.string.set_allowed_sizes));
    AdSize localAdSize = new AdSize(1, 1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localAdSize);
    this.c.setSizes(localArrayList);
    this.c.setPrimarySize(localAdSize);
    this.c.setAllowSmallerSizes(false);
  }

  public void addCustomKeywords(String paramString1, String paramString2)
  {
    this.c.addCustomKeywords(paramString1, paramString2);
  }

  public void clearCustomKeywords()
  {
    this.c.clearCustomKeywords();
  }

  public c getAdDispatcher()
  {
    return this.e;
  }

  public String getAge()
  {
    return this.c.getAge();
  }

  public ANClickThroughAction getClickThroughAction()
  {
    return this.c.getClickThroughAction();
  }

  public String getExternalUid()
  {
    return this.c.getExternalUid();
  }

  public AdView.GENDER getGender()
  {
    Clog.d(Clog.nativeLogTag, Clog.getString(R.string.get_gender, this.c.getGender().toString()));
    return this.c.getGender();
  }

  public String getInventoryCode()
  {
    return this.c.getInvCode();
  }

  public NativeAdRequestListener getListener()
  {
    return this.b;
  }

  public boolean getLoadsInBackground()
  {
    return this.c.getLoadsInBackground();
  }

  public MediaType getMediaType()
  {
    return this.c.getMediaType();
  }

  public int getMemberID()
  {
    return this.c.getMemberID();
  }

  public boolean getOpensNativeBrowser()
  {
    Clog.d(Clog.nativeLogTag, Clog.getString(R.string.get_opens_native_browser, this.c.getOpensNativeBrowser()));
    return this.c.getOpensNativeBrowser();
  }

  public String getPlacementID()
  {
    Clog.d(Clog.nativeLogTag, Clog.getString(R.string.get_placement_id, this.c.getPlacementID()));
    return this.c.getPlacementID();
  }

  public UTRequestParameters getRequestParameters()
  {
    return this.c;
  }

  public boolean isReadyToStart()
  {
    return (this.b != null) && (this.c.isReadyForRequest());
  }

  public boolean loadAd()
  {
    if (this.b == null)
      Clog.e(Clog.nativeLogTag, "No listener installed for this request, won't load a new ad");
    do
    {
      return false;
      if (this.a)
      {
        Clog.e(Clog.nativeLogTag, "Still loading last native ad , won't load a new ad");
        return false;
      }
    }
    while (!this.c.isReadyForRequest());
    this.d.a();
    this.d.c();
    this.d.b();
    this.a = true;
    return true;
  }

  public void removeCustomKeyword(String paramString)
  {
    this.c.removeCustomKeyword(paramString);
  }

  public void setAge(String paramString)
  {
    this.c.setAge(paramString);
  }

  public void setClickThroughAction(ANClickThroughAction paramANClickThroughAction)
  {
    this.c.setClickThroughAction(paramANClickThroughAction);
  }

  public void setExternalUid(String paramString)
  {
    this.c.setExternalUid(paramString);
  }

  public void setGender(AdView.GENDER paramGENDER)
  {
    Clog.d(Clog.nativeLogTag, Clog.getString(R.string.set_gender, paramGENDER.toString()));
    this.c.setGender(paramGENDER);
  }

  public void setInventoryCodeAndMemberID(int paramInt, String paramString)
  {
    this.c.setInventoryCodeAndMemberID(paramInt, paramString);
  }

  public void setListener(NativeAdRequestListener paramNativeAdRequestListener)
  {
    this.b = paramNativeAdRequestListener;
  }

  public void setLoadsInBackground(boolean paramBoolean)
  {
    this.c.setLoadsInBackground(paramBoolean);
  }

  public void setOpensNativeBrowser(boolean paramBoolean)
  {
    Clog.d(Clog.nativeLogTag, Clog.getString(R.string.set_opens_native_browser, paramBoolean));
    this.c.setOpensNativeBrowser(paramBoolean);
  }

  public void setPlacementID(String paramString)
  {
    Clog.d(Clog.nativeLogTag, Clog.getString(R.string.set_placement_id, paramString));
    this.c.setPlacementID(paramString);
  }

  public void shouldLoadIcon(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public void shouldLoadImage(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  class a
    implements c, ImageService.ImageServiceListener
  {
    ImageService a;
    NativeAdResponse b;

    a()
    {
    }

    public void a()
    {
    }

    public void a(AdResponse paramAdResponse)
    {
      if (!paramAdResponse.getMediaType().equals(MediaType.NATIVE))
      {
        a(ResultCode.INTERNAL_ERROR);
        return;
      }
      final NativeAdResponse localNativeAdResponse = paramAdResponse.getNativeAdResponse();
      localNativeAdResponse.setCreativeId(paramAdResponse.getResponseData().getCreativeId());
      if ((!NativeAdRequest.b(NativeAdRequest.this)) && (!NativeAdRequest.c(NativeAdRequest.this)))
      {
        if (NativeAdRequest.a(NativeAdRequest.this) != null)
          NativeAdRequest.a(NativeAdRequest.this).onAdLoaded(localNativeAdResponse);
        while (true)
        {
          NativeAdRequest.this.a = false;
          return;
          localNativeAdResponse.destroy();
        }
      }
      this.a = new ImageService();
      this.b = localNativeAdResponse;
      ImageService.ImageReceiver local1 = new ImageService.ImageReceiver()
      {
        public void onFail(String paramAnonymousString)
        {
          Clog.e(Clog.httpRespLogTag, "Image downloading failed for url " + paramAnonymousString);
        }

        public void onReceiveImage(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          if (paramAnonymousString.equals("image"))
            localNativeAdResponse.setImage(paramAnonymousBitmap);
          while (!paramAnonymousString.equals("icon"))
            return;
          localNativeAdResponse.setIcon(paramAnonymousBitmap);
        }
      };
      HashMap localHashMap = new HashMap();
      if (NativeAdRequest.b(NativeAdRequest.this))
        localHashMap.put("image", localNativeAdResponse.getImageUrl());
      if (NativeAdRequest.c(NativeAdRequest.this))
        localHashMap.put("icon", localNativeAdResponse.getIconUrl());
      this.a.registerImageReceiver(local1, localHashMap);
      this.a.registerNotification(this);
      this.a.execute();
    }

    public void a(ResultCode paramResultCode)
    {
      if (NativeAdRequest.a(NativeAdRequest.this) != null)
        NativeAdRequest.a(NativeAdRequest.this).onAdFailed(paramResultCode);
      NativeAdRequest.this.a = false;
    }

    public void a(String paramString)
    {
    }

    public void a(String paramString1, String paramString2)
    {
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public void d()
    {
    }

    public void onAllImageDownloadsFinish()
    {
      if (NativeAdRequest.a(NativeAdRequest.this) != null)
        NativeAdRequest.a(NativeAdRequest.this).onAdLoaded(this.b);
      while (true)
      {
        this.a = null;
        this.b = null;
        NativeAdRequest.this.a = false;
        return;
        this.b.destroy();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.NativeAdRequest
 * JD-Core Version:    0.6.2
 */