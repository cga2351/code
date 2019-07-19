package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class fz extends ds
  implements gs
{
  private final gt a;
  private Map<String, String> b;
  protected final v f;

  protected fz(Context paramContext, v paramv)
  {
    super(paramContext);
    this.f = paramv;
    this.a = new gt(this);
    a(paramContext);
  }

  protected void a(int paramInt, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"undefined".equals(paramString)))
    {
      this.b = new HashMap();
      this.b.put("test-tag", paramString);
    }
  }

  @SuppressLint({"AddJavascriptInterface"})
  protected abstract void a(Context paramContext);

  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.b());
    if (i());
    for (String str = dt.c; ; str = "")
      return str;
  }

  public final void b(int paramInt, String paramString)
  {
    new StringBuilder("onHtmlWebViewRender, height = ").append(paramInt).append(", testTag = ").append(paramString);
    a(paramInt, paramString);
    super.d();
  }

  public final void d()
  {
    if (i())
    {
      this.a.a();
      return;
    }
    super.d();
  }

  public final void g()
  {
    this.a.b();
    super.g();
  }

  protected final boolean i()
  {
    return "partner-code".equals(this.f.o());
  }

  public final Map<String, String> j()
  {
    if (this.b != null)
      return this.b;
    return Collections.emptyMap();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    new Object[] { paramConfiguration };
    a("AdPerformActionsJSI");
    super.onConfigurationChanged(paramConfiguration);
  }

  public void setHtmlWebViewListener(dn paramdn)
  {
    super.setHtmlWebViewListener(paramdn);
    this.a.a(paramdn);
  }

  public final class a
  {
    final WeakReference<Context> a;

    public a(Context arg2)
    {
      Object localObject;
      this.a = new WeakReference(localObject);
    }

    @JavascriptInterface
    public final String getBannerInfo()
    {
      return "{\"isDelicate\": false}";
    }

    @JavascriptInterface
    public final void onAdRender(int paramInt, String paramString)
    {
      fz.a(fz.this).a(paramInt, paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fz
 * JD-Core Version:    0.6.2
 */