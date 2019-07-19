package com.viber.voip.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.extensions.activity.ChatExInternalBrowserActivity;
import com.viber.voip.messages.extensions.activity.ChatExInternalBrowserActivity.c;
import com.viber.voip.util.ViberActionRunner.az;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.ae;
import com.viber.voip.widget.ViberWebView;
import javax.inject.Inject;

public class ViberNewsArticleBrowserActivity extends ChatExInternalBrowserActivity
{
  private static final Logger m = ViberEnv.getLogger();

  @Inject
  com.viber.voip.util.i.a e;

  @Inject
  dagger.a<ICdrController> f;

  @Inject
  dagger.a<com.viber.voip.analytics.story.g.a> g;
  private NewsShareAnalyticsData n;
  private NewsSession o;
  private boolean p;

  private void m()
  {
    if ((!this.p) && (!isChangingConfigurations()))
    {
      NewsSession localNewsSession = this.o;
      localNewsSession.stopSession(this.e);
      ((com.viber.voip.analytics.story.g.a)this.g.get()).b(localNewsSession.getSessionTimeMillis());
      if (this.n != null)
        ((ICdrController)this.f.get()).handleReportViberNewsSessionAndUrls(this.n.newsProviderId, localNewsSession);
    }
  }

  private void n()
  {
    if (this.p)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("news_session", this.o);
      setResult(-1, localIntent);
    }
  }

  protected void f()
  {
    if (this.n != null)
    {
      startActivity(ViberActionRunner.u.a(e(), this.n));
      finish();
      return;
    }
    super.f();
  }

  public void finish()
  {
    n();
    super.finish();
  }

  protected void g()
  {
    if (this.n != null)
    {
      ViberActionRunner.az.a(this, 8, 0L, null, "", "", "", e(), null, false, null, null, this.n);
      return;
    }
    super.g();
  }

  protected WebViewClient i()
  {
    return new a(new o(this));
  }

  protected void k()
  {
    if ((this.o.isSessionStopped()) && (this.n != null))
      ((com.viber.voip.analytics.story.g.a)this.g.get()).a("Automatic", ae.b(), this.n.baseProviderUrl);
  }

  public void onBackPressed()
  {
    this.p = true;
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    this.n = ((NewsShareAnalyticsData)getIntent().getParcelableExtra("news_analytics_data"));
    NewsSession localNewsSession = null;
    if (paramBundle == null)
      localNewsSession = (NewsSession)getIntent().getParcelableExtra("news_session");
    if (localNewsSession != null);
    while (true)
    {
      this.o = localNewsSession;
      return;
      localNewsSession = NewsSession.startSession(this.e);
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
      this.p = true;
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onStart()
  {
    super.onStart();
    this.p = false;
    if (this.o.isSessionStopped())
    {
      k();
      this.o = NewsSession.startSession(this.e);
      this.o.trackUrl(this.h.getUrl(), this.e);
    }
  }

  protected void onStop()
  {
    super.onStop();
    m();
  }

  private class a extends ChatExInternalBrowserActivity.c
  {
    a(Runnable arg2)
    {
      super(localRunnable);
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      ViberNewsArticleBrowserActivity.a(ViberNewsArticleBrowserActivity.this).trackUrl(paramString, ViberNewsArticleBrowserActivity.this.e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.ViberNewsArticleBrowserActivity
 * JD-Core Version:    0.6.2
 */