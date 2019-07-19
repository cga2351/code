package com.viber.voip.news;

import android.webkit.WebView;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.util.cj;
import com.viber.voip.util.cv;
import com.viber.voip.util.dz;

class MoreScreenNewsBrowserPresenter extends NewsBrowserPresenter<f, NewsBrowserState, h>
{
  private boolean e;

  MoreScreenNewsBrowserPresenter(h paramh, cv paramcv, cj paramcj, com.viber.voip.util.i.a parama, dagger.a<ICdrController> parama1, dagger.a<com.viber.voip.analytics.story.g.a> parama2)
  {
    super(paramh, paramcv, paramcj, parama, parama1, parama2);
  }

  public void Q_()
  {
    super.Q_();
    this.e = true;
  }

  protected NewsBrowserState a()
  {
    return c();
  }

  public boolean a(WebView paramWebView)
  {
    if ((!this.e) && (dz.a(paramWebView)))
    {
      paramWebView.goBack();
      return true;
    }
    if ((this.e) || (((h)this.b).a()))
    {
      ((f)this.mView).a();
      return true;
    }
    return false;
  }

  public void onCreate(android.arch.lifecycle.h paramh)
  {
    this.a.a(false);
  }

  public void onStart(android.arch.lifecycle.h paramh)
  {
    super.onStart(paramh);
    e();
    d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.MoreScreenNewsBrowserPresenter
 * JD-Core Version:    0.6.2
 */