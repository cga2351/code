package com.appnexus.opensdk;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.JsonUtil;
import com.appnexus.opensdk.utils.ViewUtil;
import com.appnexus.opensdk.utils.WebviewUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ANNativeAdResponse
  implements NativeAdResponse
{
  private String A;
  private ProgressDialog B;
  private ANClickThroughAction C = ANClickThroughAction.OPEN_SDK_BROWSER;
  private boolean D = true;
  private String a;
  private String b;
  private String c;
  private String d;
  private Bitmap e;
  private Bitmap f;
  private String g;
  private String h;
  private String i;
  private String j;
  private NativeAdResponse.Rating k;
  private HashMap<String, Object> l;
  private boolean m = false;
  private ArrayList<String> n;
  private ArrayList<String> o;
  private String p;
  private String q;
  private Handler r;
  private String s = "";
  private Runnable t = new Runnable()
  {
    public void run()
    {
      ANNativeAdResponse.a(ANNativeAdResponse.this, true);
      ANNativeAdResponse.a(ANNativeAdResponse.this, null);
      ANNativeAdResponse.a(ANNativeAdResponse.this, null);
      if (ANNativeAdResponse.a(ANNativeAdResponse.this) != null)
      {
        ANNativeAdResponse.a(ANNativeAdResponse.this).c();
        ANNativeAdResponse.a(ANNativeAdResponse.this, null);
      }
      ANNativeAdResponse.a(ANNativeAdResponse.this, null);
      ANNativeAdResponse.a(ANNativeAdResponse.this, null);
      if (ANNativeAdResponse.b(ANNativeAdResponse.this) != null)
      {
        ANNativeAdResponse.b(ANNativeAdResponse.this).recycle();
        ANNativeAdResponse.a(ANNativeAdResponse.this, null);
      }
      if (ANNativeAdResponse.c(ANNativeAdResponse.this) != null)
      {
        ANNativeAdResponse.c(ANNativeAdResponse.this).recycle();
        ANNativeAdResponse.b(ANNativeAdResponse.this, null);
      }
    }
  };
  private View u;
  private List<View> v;
  private NativeAdEventListener w;
  private View.OnClickListener x;
  private v y;
  private ArrayList<k> z;

  private void a(Context paramContext)
  {
    Class localClass = AdActivity.getActivityClass();
    try
    {
      Intent localIntent = new Intent(paramContext, localClass);
      localIntent.setFlags(268435456);
      localIntent.putExtra("ACTIVITY_TYPE", "BROWSER");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Clog.w(Clog.baseLogTag, Clog.getString(R.string.adactivity_missing, localClass.getName()));
      BrowserAdActivity.BROWSER_QUEUE.remove();
    }
  }

  private boolean b(String paramString, Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    localIntent.setFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Clog.w(Clog.baseLogTag, Clog.getString(R.string.opening_url_failed, paramString));
    }
    return false;
  }

  public static ANNativeAdResponse create(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null);
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(paramJSONObject, "impression_trackers"));
    }
    while (localArrayList == null);
    ANNativeAdResponse localANNativeAdResponse = new ANNativeAdResponse();
    localANNativeAdResponse.n = localArrayList;
    localANNativeAdResponse.a = JsonUtil.getJSONString(paramJSONObject, "title");
    localANNativeAdResponse.b = JsonUtil.getJSONString(paramJSONObject, "description");
    JSONArray localJSONArray = JsonUtil.getJSONArray(paramJSONObject, "main_media");
    int i1;
    if (localJSONArray != null)
      i1 = localJSONArray.length();
    for (int i2 = 0; ; i2++)
      if (i2 < i1)
      {
        JSONObject localJSONObject2 = JsonUtil.getJSONObjectFromArray(localJSONArray, i2);
        if (localJSONObject2 != null)
        {
          String str = JsonUtil.getJSONString(localJSONObject2, "label");
          if ((str != null) && (str.equals("default")))
            localANNativeAdResponse.c = JsonUtil.getJSONString(localJSONObject2, "url");
        }
      }
      else
      {
        localANNativeAdResponse.d = JsonUtil.getJSONString(paramJSONObject, "icon_img_url");
        localANNativeAdResponse.j = JsonUtil.getJSONString(paramJSONObject, "context");
        localANNativeAdResponse.i = JsonUtil.getJSONString(paramJSONObject, "cta");
        localANNativeAdResponse.g = JsonUtil.getJSONString(paramJSONObject, "click_url");
        localANNativeAdResponse.h = JsonUtil.getJSONString(paramJSONObject, "click_fallback_url");
        localANNativeAdResponse.q = JsonUtil.getJSONString(paramJSONObject, "sponsored_by");
        localANNativeAdResponse.p = JsonUtil.getJSONString(paramJSONObject, "full_text");
        JSONObject localJSONObject1 = JsonUtil.getJSONObject(paramJSONObject, "rating");
        localANNativeAdResponse.k = new NativeAdResponse.Rating(JsonUtil.getJSONDouble(localJSONObject1, "value"), JsonUtil.getJSONDouble(localJSONObject1, "scale"));
        localANNativeAdResponse.o = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(paramJSONObject, "click_trackers"));
        localANNativeAdResponse.l = JsonUtil.getStringObjectHashMap(JsonUtil.getJSONObject(paramJSONObject, "custom"));
        localANNativeAdResponse.r = new Handler(Looper.getMainLooper());
        localANNativeAdResponse.r.postDelayed(localANNativeAdResponse.t, 3600000L);
        localANNativeAdResponse.A = paramJSONObject.toString();
        return localANNativeAdResponse;
      }
  }

  void a()
  {
    this.x = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ANNativeAdResponse.d(ANNativeAdResponse.this) != null)
        {
          Iterator localIterator = ANNativeAdResponse.d(ANNativeAdResponse.this).iterator();
          while (localIterator.hasNext())
            new h((String)localIterator.next()).execute(new Void[0]);
        }
        if (ANNativeAdResponse.this.getClickThroughAction() == ANClickThroughAction.RETURN_URL)
          if (ANNativeAdResponse.e(ANNativeAdResponse.this) != null)
            ANNativeAdResponse.e(ANNativeAdResponse.this).onAdWasClicked(ANNativeAdResponse.f(ANNativeAdResponse.this), ANNativeAdResponse.g(ANNativeAdResponse.this));
        do
        {
          return;
          if (ANNativeAdResponse.e(ANNativeAdResponse.this) != null)
            ANNativeAdResponse.e(ANNativeAdResponse.this).onAdWasClicked();
        }
        while ((ANNativeAdResponse.this.a(ANNativeAdResponse.f(ANNativeAdResponse.this), paramAnonymousView.getContext())) || (ANNativeAdResponse.this.a(ANNativeAdResponse.g(ANNativeAdResponse.this), paramAnonymousView.getContext())));
        Clog.d(Clog.nativeLogTag, "Unable to handle click.");
      }
    };
  }

  void a(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }

  boolean a(String paramString, Context paramContext)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.isEmpty()))
      bool = false;
    do
    {
      return bool;
      if ((paramString.contains("://play.google.com")) || (paramString.contains("market://")))
      {
        Clog.d(Clog.nativeLogTag, Clog.getString(R.string.opening_app_store));
        return b(paramString, paramContext);
      }
      if (getClickThroughAction() != ANClickThroughAction.OPEN_DEVICE_BROWSER)
        break label95;
      if (!b(paramString, paramContext))
        break;
    }
    while (this.w == null);
    this.w.onAdWillLeaveApplication();
    return bool;
    return false;
    try
    {
      label95: if (getLoadsInBackground())
      {
        final a locala = new a(new MutableContextWrapper(paramContext));
        WebviewUtil.setWebViewSettings(locala);
        locala.loadUrl(paramString);
        BrowserAdActivity.BROWSER_QUEUE.add(locala);
        this.B = new ProgressDialog(paramContext);
        this.B.setCancelable(true);
        this.B.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            locala.stopLoading();
          }
        });
        this.B.setMessage(paramContext.getResources().getString(R.string.loading));
        this.B.setProgressStyle(0);
        this.B.show();
        return bool;
      }
    }
    catch (Exception localException)
    {
      Clog.e(Clog.baseLogTag, "Exception initializing the redirect webview: " + localException.getMessage());
      return false;
    }
    WebView localWebView = new WebView(new MutableContextWrapper(paramContext));
    WebviewUtil.setWebViewSettings(localWebView);
    localWebView.loadUrl(paramString);
    BrowserAdActivity.BROWSER_QUEUE.add(localWebView);
    a(paramContext);
    return bool;
  }

  public void destroy()
  {
    if (this.r != null)
    {
      this.r.removeCallbacks(this.t);
      this.r.post(this.t);
    }
  }

  public NativeAdResponse.Rating getAdStarRating()
  {
    return this.k;
  }

  public String getCallToAction()
  {
    return this.i;
  }

  public ANClickThroughAction getClickThroughAction()
  {
    return this.C;
  }

  public String getCreativeId()
  {
    return this.s;
  }

  public String getDescription()
  {
    return this.b;
  }

  public String getFullText()
  {
    return this.p;
  }

  public Bitmap getIcon()
  {
    return this.f;
  }

  public String getIconUrl()
  {
    return this.d;
  }

  public Bitmap getImage()
  {
    return this.e;
  }

  public String getImageUrl()
  {
    return this.c;
  }

  public List<String> getImpressionTrackers()
  {
    return this.n;
  }

  public boolean getLoadsInBackground()
  {
    return this.D;
  }

  public HashMap<String, Object> getNativeElements()
  {
    return this.l;
  }

  public NativeAdResponse.Network getNetworkIdentifier()
  {
    return NativeAdResponse.Network.APPNEXUS;
  }

  public String getOriginalResponse()
  {
    return this.A;
  }

  public String getSocialContext()
  {
    return this.j;
  }

  public String getSponsoredBy()
  {
    return this.q;
  }

  public String getTitle()
  {
    return this.a;
  }

  public boolean hasExpired()
  {
    return this.m;
  }

  public boolean isOpenNativeBrowser()
  {
    return getClickThroughAction() == ANClickThroughAction.OPEN_DEVICE_BROWSER;
  }

  public boolean registerView(View paramView, NativeAdEventListener paramNativeAdEventListener)
  {
    if ((!this.m) && (paramView != null))
    {
      this.w = paramNativeAdEventListener;
      this.y = v.a(paramView);
      if (this.y != null);
    }
    else
    {
      return false;
    }
    this.z = new ArrayList(this.n.size());
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      k localk = k.a((String)localIterator.next(), this.y, paramView.getContext());
      this.z.add(localk);
    }
    this.u = paramView;
    a();
    paramView.setOnClickListener(this.x);
    if (this.r != null)
      this.r.removeCallbacks(this.t);
    return true;
  }

  public boolean registerViewList(View paramView, List<View> paramList, NativeAdEventListener paramNativeAdEventListener)
  {
    if (registerView(paramView, paramNativeAdEventListener))
    {
      paramView.setOnClickListener(null);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        ((View)localIterator.next()).setOnClickListener(this.x);
      this.v = paramList;
      return true;
    }
    return false;
  }

  public void setClickThroughAction(ANClickThroughAction paramANClickThroughAction)
  {
    this.C = paramANClickThroughAction;
  }

  public void setCreativeId(String paramString)
  {
    this.s = paramString;
  }

  public void setIcon(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
  }

  public void setImage(Bitmap paramBitmap)
  {
    this.e = paramBitmap;
  }

  public void unregisterViews()
  {
    if (this.u != null)
      this.u.setOnClickListener(null);
    if ((this.v != null) && (!this.v.isEmpty()))
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext())
        ((View)localIterator.next()).setOnClickListener(null);
    }
    destroy();
  }

  private class a extends WebView
  {
    @SuppressLint({"SetJavaScriptEnabled"})
    public a(Context arg2)
    {
      super();
      WebviewUtil.setWebViewSettings(this);
      setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          Clog.v(Clog.browserLogTag, "Opening URL: " + paramAnonymousString);
          ViewUtil.removeChildFromParent(ANNativeAdResponse.a.this);
          if ((ANNativeAdResponse.h(ANNativeAdResponse.this) != null) && (ANNativeAdResponse.h(ANNativeAdResponse.this).isShowing()))
            ANNativeAdResponse.h(ANNativeAdResponse.this).dismiss();
          ANNativeAdResponse.a(ANNativeAdResponse.this, localContext);
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ANNativeAdResponse
 * JD-Core Version:    0.6.2
 */