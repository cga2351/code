package com.viber.voip.ui.web;

import android.arch.lifecycle.h;
import android.net.Uri;
import android.webkit.WebView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.da;
import com.viber.voip.util.dz;
import com.viber.voip.util.n;

public class GenericWebViewPresenter<VIEW extends b, STATE extends State, URL_SPEC extends a> extends BaseMvpPresenter<VIEW, STATE>
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] e = { "rgames.jp", "vbrpl.io" };
  protected final URL_SPEC b;
  protected final cj c;
  protected CharSequence d;
  private final cj.a f = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 == -1)
        GenericWebViewPresenter.this.j();
    }
  };

  public GenericWebViewPresenter(URL_SPEC paramURL_SPEC, cj paramcj)
  {
    this.b = paramURL_SPEC;
    this.d = this.b.j();
    this.c = paramcj;
  }

  private void a()
  {
    if (this.b.b() != -1)
      ((b)this.mView).b(this.b.b());
  }

  public void Q_()
  {
    j();
  }

  protected void a(CharSequence paramCharSequence)
  {
    ((b)this.mView).a(paramCharSequence);
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt >= 100) && (da.a(this.d)))
    {
      if ((da.a(paramString2)) || (paramString2.equals(this.b.d())))
        break label51;
      this.d = paramString2;
    }
    while (true)
    {
      a(this.d);
      return;
      label51: if (this.b.k())
        this.d = Uri.parse(this.b.d()).getHost();
    }
  }

  public boolean a(WebView paramWebView)
  {
    if ((!this.b.i()) && (dz.a(paramWebView)))
    {
      paramWebView.goBack();
      return true;
    }
    if (this.b.l())
    {
      ((b)this.mView).f();
      return true;
    }
    m();
    return false;
  }

  public void b(String paramString)
  {
  }

  public boolean c(String paramString)
  {
    return false;
  }

  public void e(String paramString)
  {
    if ((this.b.k()) && (da.a(paramString)))
      paramString = Uri.parse(this.b.d()).getHost();
    if (da.a(this.d))
    {
      this.d = paramString;
      a(this.d);
    }
  }

  protected boolean h()
  {
    String str1 = i();
    if (!da.a(str1))
    {
      String str2 = Uri.parse(str1).getHost();
      return n.a(e, str2);
    }
    return false;
  }

  protected String i()
  {
    return this.b.d();
  }

  protected void j()
  {
    ((b)this.mView).b(false);
    m();
  }

  public void l()
  {
    ((b)this.mView).b(true);
    n();
  }

  protected void m()
  {
    ((b)this.mView).a("");
  }

  protected void n()
  {
    if (this.c.b())
    {
      String str = i();
      ((b)this.mView).a(str);
      return;
    }
    j();
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    m();
  }

  public void onStart(h paramh)
  {
    super.onStart(paramh);
    this.c.a(this.f);
  }

  public void onStop(h paramh)
  {
    super.onStop(paramh);
    this.c.b(this.f);
  }

  protected void onViewAttached(STATE paramSTATE)
  {
    super.onViewAttached(paramSTATE);
    a();
    a(this.d);
    if (h())
      ((b)this.mView).e();
    n();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.web.GenericWebViewPresenter
 * JD-Core Version:    0.6.2
 */