package com.viber.voip.banner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.viber.dexshared.Logger;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.market.MarketDialogActivity;
import com.viber.voip.util.dz;
import com.viber.voip.util.k.b;
import com.viber.voip.widget.ViberWebView;

public class RemoteSplashActivity extends MarketDialogActivity
{
  private static final Logger d = ViberEnv.getLogger();
  private static IntentFilter k = new IntentFilter();
  private String l;
  private String m;
  private long n;
  private String o;
  private boolean p = false;
  private final BroadcastReceiver q = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("com.viber.voip.action.HIDE_REMOTE_SPLASH".equals(paramAnonymousIntent.getAction()))
        RemoteSplashActivity.this.finish();
    }
  };

  static
  {
    k.addAction("com.viber.voip.action.HIDE_REMOTE_SPLASH");
  }

  public static Intent a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    Intent localIntent = new Intent(ViberApplication.getApplication(), RemoteSplashActivity.class);
    localIntent.putExtra("splash_title", paramString1);
    localIntent.putExtra("splash_url", paramString2);
    localIntent.putExtra("splash_token", paramLong);
    localIntent.putExtra("tag", paramString3);
    localIntent.setFlags(335544320);
    return localIntent;
  }

  private void b(Intent paramIntent)
  {
    this.l = paramIntent.getStringExtra("splash_title");
    this.m = paramIntent.getStringExtra("splash_url");
    this.n = paramIntent.getLongExtra("splash_token", -1L);
    this.o = paramIntent.getStringExtra("tag");
    d(null);
  }

  public static void b(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    Intent localIntent = a(paramString1, paramString2, paramLong, paramString3);
    dz.a(ViberApplication.getApplication(), localIntent);
  }

  private void d(String paramString)
  {
    i.a().a(this.n, paramString);
  }

  private void l()
  {
    p();
    e_(d());
    b();
  }

  private int x()
  {
    double d1 = com.viber.voip.util.e.j.b(this)[0];
    return (int)(100.0D * (this.f.getWidth() / d1));
  }

  private void y()
  {
    if (!this.p)
    {
      registerReceiver(this.q, k);
      this.p = true;
    }
  }

  private void z()
  {
    if (this.p);
    try
    {
      unregisterReceiver(this.q);
      label15: this.p = false;
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }

  protected WebViewClient a(Runnable paramRunnable)
  {
    return new b(paramRunnable)
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.startsWith("viber:")))
        {
          a(paramAnonymousWebView, paramAnonymousString);
          return true;
        }
        return false;
      }
    };
  }

  protected void a()
  {
    super.a();
    this.f.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        RemoteSplashActivity.b(RemoteSplashActivity.this).setInitialScale(RemoteSplashActivity.a(RemoteSplashActivity.this));
        RemoteSplashActivity.c(RemoteSplashActivity.this).getSettings().setUseWideViewPort(true);
      }
    });
  }

  protected void b()
  {
    super.b();
  }

  protected String c()
  {
    return this.m;
  }

  protected String d()
  {
    return this.l;
  }

  protected int e()
  {
    return R.layout.remote_splash_activity;
  }

  protected void onCreate(Bundle paramBundle)
  {
    y();
    b(getIntent());
    super.onCreate(paramBundle);
    b();
  }

  protected void onDestroy()
  {
    z();
    d(null);
    super.onDestroy();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    y();
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    b(paramIntent);
    l();
  }

  protected void s_()
  {
    d(this.o);
    super.s_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.RemoteSplashActivity
 * JD-Core Version:    0.6.2
 */