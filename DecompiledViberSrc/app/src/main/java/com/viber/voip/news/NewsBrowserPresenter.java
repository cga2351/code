package com.viber.voip.news;

import android.arch.lifecycle.h;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.util.ObjectsCompat;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.web.GenericWebViewPresenter;
import com.viber.voip.util.ae;
import com.viber.voip.util.ax;
import com.viber.voip.util.cj;
import com.viber.voip.util.cv;
import com.viber.voip.util.dl;
import org.onepf.oms.appstore.googleUtils.Base64;
import org.onepf.oms.appstore.googleUtils.Base64DecoderException;

class NewsBrowserPresenter<VIEW extends k, STATE extends NewsBrowserState, URL_SPEC extends n> extends GenericWebViewPresenter<VIEW, STATE, URL_SPEC>
{
  private static final Logger e = ViberEnv.getLogger();
  protected final cv a;
  private final com.viber.voip.util.i.a f;
  private final dagger.a<ICdrController> g;
  private final dagger.a<com.viber.voip.analytics.story.g.a> h;
  private NewsSession i;
  private String j;
  private String k;
  private boolean l;
  private boolean m;

  NewsBrowserPresenter(URL_SPEC paramURL_SPEC, cv paramcv, cj paramcj, com.viber.voip.util.i.a parama, dagger.a<ICdrController> parama1, dagger.a<com.viber.voip.analytics.story.g.a> parama2)
  {
    super(paramURL_SPEC, paramcj);
    this.a = paramcv;
    this.f = parama;
    this.g = parama1;
    this.h = parama2;
    this.i = NewsSession.startSession(parama);
  }

  private void b(NewsSession paramNewsSession)
  {
    ((com.viber.voip.analytics.story.g.a)this.h.get()).b(paramNewsSession.getSessionTimeMillis());
    ((ICdrController)this.g.get()).handleReportViberNewsSessionAndUrls(((n)this.b).c(), paramNewsSession);
  }

  private String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return null;
      Uri localUri1 = Uri.parse(paramString);
      if (!TextUtils.isEmpty(localUri1.getFragment()))
      {
        Uri localUri2 = Uri.parse("http://localhost?" + localUri1.getFragment());
        String str1 = localUri2.getQueryParameter("mode");
        if ((!TextUtils.isEmpty(str1)) && (str1.equalsIgnoreCase("Summary")))
        {
          String str2 = localUri2.getQueryParameter("url");
          try
          {
            if (!TextUtils.isEmpty(str2))
            {
              String str3 = new String(Base64.decode(str2));
              return str3;
            }
          }
          catch (Base64DecoderException localBase64DecoderException)
          {
          }
        }
      }
    }
    return null;
  }

  private boolean g(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = "about:blank".equals(paramString);
      bool2 = false;
      if (!bool3)
      {
        boolean bool4 = TextUtils.isEmpty(((n)this.b).d());
        bool2 = false;
        if (!bool4)
          break label50;
      }
    }
    while (true)
    {
      return bool2;
      label50: Uri localUri1 = Uri.parse(paramString);
      Uri localUri2 = Uri.parse(((n)this.b).d());
      String str1 = localUri1.getHost();
      bool2 = false;
      if (str1 != null)
      {
        String str2 = localUri2.getHost();
        bool2 = false;
        if (str2 != null)
        {
          int n = ((n)this.b).g();
          bool2 = false;
          switch (n)
          {
          default:
          case 0:
          case 1:
          }
          while (bool2)
          {
            return bool2;
            if (!localUri1.getHost().contains(localUri2.getHost()));
            for (boolean bool6 = true; ; bool6 = false)
            {
              bool2 = bool6;
              break;
            }
            if (ObjectsCompat.equals(localUri1.getHost(), localUri2.getHost()))
            {
              boolean bool5 = ObjectsCompat.equals(localUri2.getPath(), localUri1.getPath());
              bool2 = false;
              if (bool5);
            }
            else
            {
              bool2 = true;
            }
          }
        }
      }
    }
  }

  private NewsShareAnalyticsData h(String paramString)
  {
    int n = ((n)this.b).c();
    if (!TextUtils.isEmpty(((n)this.b).d()));
    for (String str = ((n)this.b).d(); ; str = "")
      return new NewsShareAnalyticsData(n, str, paramString);
  }

  protected void a(STATE paramSTATE)
  {
    super.onViewAttached(paramSTATE);
    if (paramSTATE != null)
    {
      this.j = paramSTATE.getLoadedUrl();
      this.k = paramSTATE.getUrlToShare();
      this.l = paramSTATE.isArticlePage();
      this.m = paramSTATE.isSessionWillBeContinuedOnAnotherScreen();
    }
  }

  public void a(NewsSession paramNewsSession)
  {
    this.i = paramNewsSession;
    d();
  }

  public void a(String paramString)
  {
    super.a(paramString);
    this.l = g(paramString);
    if (this.l);
    while (true)
    {
      d(paramString);
      return;
      paramString = null;
    }
  }

  public void a(String paramString1, String paramString2, int paramInt)
  {
    super.a(paramString1, paramString2, paramInt);
    ((k)this.mView).a(paramInt);
  }

  public void b(String paramString)
  {
    super.b(paramString);
    this.j = paramString;
    this.i.trackUrl(paramString, this.f);
    if (!this.l)
      paramString = f(paramString);
    while (true)
    {
      d(paramString);
      return;
      this.l = g(paramString);
      if (!this.l)
        paramString = null;
    }
  }

  protected NewsBrowserState c()
  {
    return new NewsBrowserState(this.j, this.k, this.l, this.m);
  }

  public boolean c(String paramString)
  {
    if ((((n)this.b).f()) && (g(paramString)) && (!TextUtils.isEmpty(paramString)))
    {
      this.m = true;
      ((k)this.mView).a(paramString, this.i, h("Article page"));
      return true;
    }
    return false;
  }

  protected void d()
  {
    this.m = false;
    if (this.i.isSessionStopped())
    {
      this.i = NewsSession.startSession(this.f);
      this.i.trackUrl(this.j, this.f);
    }
  }

  public void d(String paramString)
  {
    k localk;
    if (!ObjectsCompat.equals(this.k, paramString))
    {
      this.k = paramString;
      localk = (k)this.mView;
      if (TextUtils.isEmpty(this.k))
        break label44;
    }
    label44: for (boolean bool = true; ; bool = false)
    {
      localk.a(bool);
      return;
    }
  }

  protected void e()
  {
    if (this.i.isSessionStopped())
      ((com.viber.voip.analytics.story.g.a)this.h.get()).a("Automatic", ae.b(), ((n)this.b).d());
  }

  protected void f()
  {
    if ((!this.m) && (!this.i.isSessionStopped()) && (!((k)this.mView).c()))
    {
      NewsSession localNewsSession = this.i;
      localNewsSession.stopSession(this.f);
      b(localNewsSession);
    }
  }

  public void g()
  {
    NewsSession localNewsSession = NewsSession.startSession(this.f);
    localNewsSession.stopSession(this.f);
    this.i = localNewsSession;
  }

  protected boolean h()
  {
    return true;
  }

  protected String i()
  {
    String str1 = ((n)this.b).d();
    if (TextUtils.isEmpty(str1));
    do
    {
      return str1;
      if (((n)this.b).a(0))
        str1 = dl.f(str1);
      if (((n)this.b).a(1))
        str1 = dl.c(str1);
      if (((n)this.b).a(2))
        str1 = dl.a(str1, "default_language");
      if (((n)this.b).a(3))
      {
        String str3 = ax.a();
        if (TextUtils.isEmpty(str3))
          str3 = "0";
        str1 = Uri.parse(str1).buildUpon().appendQueryParameter("adid", str3).build().toString();
      }
    }
    while (!((n)this.b).a(4));
    if (((n)this.b).e() == 2);
    for (String str2 = "1"; ; str2 = "2")
      return Uri.parse(str1).buildUpon().appendQueryParameter("entry", str2).build().toString();
  }

  protected void j()
  {
    super.j();
    if (!com.viber.common.d.a.g())
      d(null);
  }

  public void k()
  {
    if (!TextUtils.isEmpty(this.k))
      if (!this.l)
        break label42;
    label42: for (String str = "Article page"; ; str = "Summary page")
    {
      ((k)this.mView).a(this.k, h(str));
      return;
    }
  }

  public void onStop(h paramh)
  {
    super.onStop(paramh);
    f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.NewsBrowserPresenter
 * JD-Core Version:    0.6.2
 */