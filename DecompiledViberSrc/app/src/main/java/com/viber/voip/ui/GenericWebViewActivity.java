package com.viber.voip.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ScrollView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.SplashActivity;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.dz;
import com.viber.voip.util.k.b;
import com.viber.voip.widget.ViberWebView;

public class GenericWebViewActivity extends ViberFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] b = { "rgames.jp", "vbrpl.io" };
  private boolean c;
  private boolean d;
  private final cj.a e = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 == -1)
        GenericWebViewActivity.this.d();
    }
  };
  protected ViberWebView h;
  protected String i;
  protected String j;
  protected n k;
  protected Toolbar l;

  private void a(int paramInt)
  {
    if (paramInt != -1)
      com.viber.voip.n.a.a(this, paramInt);
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, paramString2, false);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramContext, paramString1, paramString2, paramBoolean, false);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramString2, paramBoolean1, paramBoolean2, -1);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    dz.a(paramContext, b(paramContext, paramString1, paramString2, paramBoolean1, paramBoolean2, paramInt));
  }

  public static Intent b(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, paramString1, paramString2, false, false);
  }

  public static Intent b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return b(paramContext, paramString1, paramString2, paramBoolean1, paramBoolean2, -1);
  }

  public static Intent b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, GenericWebViewActivity.class);
    localIntent.putExtra("extra_url", paramString1);
    localIntent.putExtra("extra_title", paramString2);
    localIntent.putExtra("extra_ignore_history", paramBoolean1);
    localIntent.putExtra("extra_use_host_for_title", paramBoolean2);
    localIntent.putExtra("extra_orientation", paramInt);
    if (!(paramContext instanceof Activity))
      localIntent.setFlags(268435456);
    return localIntent;
  }

  private void f()
  {
    View localView1 = getWindow().getDecorView();
    View localView2 = localView1.findViewById(R.id.empty_root);
    if (localView2 != null);
    for (ViewParent localViewParent = localView2.getParent(); ; localViewParent = null)
    {
      if ((localViewParent instanceof ScrollView))
      {
        localView2.setId(-1);
        ((View)localViewParent).setId(R.id.empty_root);
      }
      this.k = new n(localView1);
      this.k.b();
      this.k.f.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          GenericWebViewActivity.this.a(true);
          GenericWebViewActivity.a(GenericWebViewActivity.this);
        }
      });
      return;
    }
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void g()
  {
    this.h = ((ViberWebView)findViewById(R.id.webview));
    a(this.h);
    WebSettings localWebSettings = this.h.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    this.h.setWebChromeClient(h());
    this.h.setWebViewClient(i());
    dz.a(getIntent(), this.h);
  }

  private void j()
  {
    if (cj.b(this))
    {
      String str = e();
      this.h.loadUrl(str);
      return;
    }
    d();
  }

  private void k()
  {
    this.h.loadUrl("");
  }

  public void a()
  {
    if (da.a(this.i))
    {
      String str = this.h.getTitle();
      if ((da.a(str)) || (str.equals(this.j)))
        break label50;
      this.i = str;
    }
    while (true)
    {
      a(this.i);
      return;
      label50: if (this.d)
        this.i = Uri.parse(this.j).getHost();
    }
  }

  protected void a(WebView paramWebView)
  {
    String str1 = e();
    if (!da.a(str1))
    {
      String str2 = Uri.parse(str1).getHost();
      if (com.viber.voip.util.n.a(b, str2))
        paramWebView.getSettings().setUserAgentString(dz.b(this.h));
    }
  }

  protected void a(String paramString)
  {
    getSupportActionBar().a(paramString);
  }

  protected final void a(boolean paramBoolean)
  {
    View localView = this.k.a;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localView, bool);
      dj.b(this.h, paramBoolean);
      return;
    }
  }

  protected void b()
  {
    d();
  }

  protected int c()
  {
    return R.layout.generic_web_view;
  }

  protected void d()
  {
    a(false);
    k();
  }

  protected String e()
  {
    return this.j;
  }

  public void finish()
  {
    k();
    super.finish();
  }

  protected WebChromeClient h()
  {
    return new a();
  }

  protected WebViewClient i()
  {
    return new b(new Runnable()
    {
      public void run()
      {
        GenericWebViewActivity.this.b();
      }
    });
  }

  public void onBackPressed()
  {
    if ((!this.c) && (dz.a(this.h)))
    {
      this.h.goBack();
      return;
    }
    if (SplashActivity.a(this, getIntent()))
    {
      finish();
      return;
    }
    k();
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(c());
    this.l = ((Toolbar)findViewById(R.id.toolbar));
    setSupportActionBar(this.l);
    getSupportActionBar().a(false);
    getSupportActionBar().b(true);
    this.j = getIntent().getStringExtra("extra_url");
    this.i = getIntent().getStringExtra("extra_title");
    this.c = getIntent().getBooleanExtra("extra_ignore_history", false);
    this.d = getIntent().getBooleanExtra("extra_use_host_for_title", false);
    a(getIntent().getIntExtra("extra_orientation", -1));
    a(this.i);
    g();
    f();
    j();
  }

  protected void onDestroy()
  {
    k();
    super.onDestroy();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    onBackPressed();
    return true;
  }

  protected void onStart()
  {
    cj.a(getApplicationContext()).a(this.e);
    super.onStart();
  }

  protected void onStop()
  {
    cj.a(getApplicationContext()).b(this.e);
    super.onStop();
  }

  protected class a extends WebChromeClient
  {
    protected a()
    {
    }

    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt < 100);
      for (int i = 1; ; i = 0)
      {
        if (i == 0)
          GenericWebViewActivity.this.a();
        return;
      }
    }

    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      if ((GenericWebViewActivity.b(GenericWebViewActivity.this)) && (da.a(paramString)))
        paramString = Uri.parse(GenericWebViewActivity.this.j).getHost();
      if (da.a(GenericWebViewActivity.this.i))
      {
        GenericWebViewActivity.this.i = paramString;
        GenericWebViewActivity.this.a(GenericWebViewActivity.this.i);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.GenericWebViewActivity
 * JD-Core Version:    0.6.2
 */