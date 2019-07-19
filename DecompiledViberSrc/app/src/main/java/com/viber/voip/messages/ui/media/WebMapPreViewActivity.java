package com.viber.voip.messages.ui.media;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av.e;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.h;
import com.viber.voip.util.dz;
import com.viber.voip.widget.ViberWebView;

public class WebMapPreViewActivity extends ViberFragmentActivity
  implements d.a
{
  private static final Logger a = ViberEnv.getLogger();
  private ViberWebView b;
  private d c = new d();

  @SuppressLint({"SetJavaScriptEnabled"})
  public View a()
  {
    this.b = ((ViberWebView)findViewById(R.id.webview));
    this.b.getSettings().setJavaScriptEnabled(true);
    dz.a(getIntent(), this.b);
    return this.b;
  }

  public void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b.loadUrl(this.c.b());
    this.b.setWebViewClient(new a(null));
  }

  public int b()
  {
    return R.layout.map_web_preview;
  }

  protected c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.d(new h(), this, (com.viber.voip.ui.j.av)ViberApplication.getInstance().getThemeController().get());
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.c.a(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    if (!this.c.a(paramMenuItem))
      return super.onContextItemSelected(paramMenuItem);
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    supportRequestWindowFeature(5);
    super.onCreate(paramBundle);
    getSupportActionBar().a(false);
    getSupportActionBar().b(true);
    this.c.a(this);
    ViberApplication.getInstance().logToCrashlytics(new RuntimeException("MAP API: using web google maps"));
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    this.c.a(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.c.a().a(paramMenu))
      return true;
    return super.onCreateOptionsMenu(paramMenu);
  }

  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.c.a(paramIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.c.a().a(paramMenuItem))
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onStart()
  {
    this.c.c();
    super.onStart();
  }

  protected void onStop()
  {
    this.c.d();
    super.onStop();
  }

  private class a extends WebViewClient
  {
    private a()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      com.viber.voip.av.a(av.e.a).postDelayed(new Runnable()
      {
        public void run()
        {
          if (!WebMapPreViewActivity.this.isFinishing())
            WebMapPreViewActivity.a(WebMapPreViewActivity.this).a().a(false);
        }
      }
      , 1500L);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.WebMapPreViewActivity
 * JD-Core Version:    0.6.2
 */