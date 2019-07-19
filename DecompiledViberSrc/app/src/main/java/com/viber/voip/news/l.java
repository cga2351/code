package com.viber.voip.news;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebViewClient;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ui.web.c;
import com.viber.voip.ui.web.c.b;
import com.viber.voip.util.ViberActionRunner.bj;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ProgressBar;

class l<PRESENTER extends NewsBrowserPresenter> extends c<PRESENTER>
  implements k
{
  private final Fragment d;
  private MenuItem e;

  l(AppCompatActivity paramAppCompatActivity, Fragment paramFragment, PRESENTER paramPRESENTER, View paramView)
  {
    super(paramAppCompatActivity, paramPRESENTER, paramView);
    this.d = paramFragment;
  }

  public void a(int paramInt)
  {
    ProgressBar localProgressBar;
    if (this.c != null)
    {
      this.c.setProgress(paramInt);
      localProgressBar = this.c;
      if (paramInt >= 100)
        break label34;
    }
    label34: for (boolean bool = true; ; bool = false)
    {
      dj.b(localProgressBar, bool);
      return;
    }
  }

  public void a(CharSequence paramCharSequence)
  {
  }

  public void a(String paramString, NewsSession paramNewsSession, NewsShareAnalyticsData paramNewsShareAnalyticsData)
  {
    ViberActionRunner.bj.a(this.a, this.d, 200, paramString, paramNewsSession, paramNewsShareAnalyticsData);
  }

  public void a(String paramString, NewsShareAnalyticsData paramNewsShareAnalyticsData)
  {
    this.a.startActivity(ViberActionRunner.u.a(paramString, paramNewsShareAnalyticsData));
  }

  public void a(boolean paramBoolean)
  {
    if ((this.a.isFinishing()) || (this.e == null))
      return;
    this.e.setVisible(paramBoolean);
  }

  public boolean c()
  {
    return this.a.isChangingConfigurations();
  }

  protected WebViewClient d()
  {
    return new c.b(this, null);
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (200 == paramInt1)
      if (paramIntent == null)
        break label56;
    label56: for (NewsSession localNewsSession = (NewsSession)paramIntent.getParcelableExtra("news_session"); ; localNewsSession = null)
    {
      if (localNewsSession != null)
        ((NewsBrowserPresenter)this.mPresenter).a(localNewsSession);
      while (true)
      {
        return true;
        ((NewsBrowserPresenter)this.mPresenter).g();
      }
      return false;
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    this.e = paramMenu.add(0, R.id.forward_article, 0, R.string.forward_action);
    this.e.setIcon(R.drawable.forward_idle_dark).setVisible(false).setShowAsAction(2);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.forward_article)
    {
      ((NewsBrowserPresenter)this.mPresenter).k();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.l
 * JD-Core Version:    0.6.2
 */