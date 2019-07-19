package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;

public class ViberWebView extends WebView
{
  private static Logger a = ViberEnv.getLogger();
  private boolean b;
  private String c;
  private a d;

  public ViberWebView(Context paramContext)
  {
    super(paramContext);
  }

  public ViberWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    dj.h(this);
  }

  public ViberWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dj.h(this);
  }

  public void a()
  {
    this.b = true;
    if (this.c != null)
    {
      super.loadUrl(this.c);
      this.c = null;
    }
  }

  public void loadUrl(String paramString)
  {
    if (this.b)
    {
      super.loadUrl(paramString);
      return;
    }
    this.c = paramString;
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.d != null)
      this.d.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    try
    {
      super.onWindowFocusChanged(paramBoolean);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
  }

  public void setScrollListener(a parama)
  {
    this.d = parama;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ViberWebView
 * JD-Core Version:    0.6.2
 */