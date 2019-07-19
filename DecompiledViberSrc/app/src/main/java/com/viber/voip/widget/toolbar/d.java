package com.viber.voip.widget.toolbar;

import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;

public abstract class d<T extends ToolbarCustomView>
  implements f
{
  protected T a;
  protected T b;
  private boolean c = false;

  public d(View paramView)
  {
    this.a = ((ToolbarCustomView)paramView.findViewById(R.id.toolbar_custom));
    this.b = ((ToolbarCustomView)paramView.findViewById(R.id.float_toolbar_custom));
    a();
  }

  protected void a()
  {
    if (this.a != null)
      this.a.c.setVisibility(8);
    if (this.b != null)
    {
      Typeface localTypeface = Typeface.create("sans-serif-light", 0);
      this.b.b.setTypeface(localTypeface);
      this.b.c.setTypeface(localTypeface);
      this.b.c.setVisibility(4);
    }
  }

  public void a(int paramInt)
  {
    if (this.a != null)
      this.a.b.setTextColor(paramInt);
    if (this.b != null)
      this.b.b.setTextColor(paramInt);
  }

  public void a(String paramString)
  {
    if (this.a != null)
      this.a.setTitle(paramString);
    if (this.b != null)
      this.b.setTitle(paramString);
  }

  public void b(int paramInt)
  {
    if (this.a != null)
      this.a.c.setTextColor(paramInt);
    if (this.b != null)
      this.b.c.setTextColor(paramInt);
  }

  public void b(String paramString)
  {
    if (this.a != null)
      this.a.a(paramString, false);
    if (this.b != null)
      this.b.a(paramString, true);
  }

  public void c()
  {
    if (this.b != null)
      this.b.getViewTreeObserver().dispatchOnPreDraw();
  }

  public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
  {
    boolean bool = true;
    int i = paramAppBarLayout.getTotalScrollRange();
    float f = Math.abs(paramInt) / i;
    if ((f == 1.0F) && (this.c))
    {
      dj.c(this.a, 0);
      dj.c(this.b, 4);
      if (!this.c)
        this.c = bool;
    }
    while ((f >= 1.0F) || (this.c))
      while (true)
      {
        return;
        bool = false;
      }
    dj.c(this.a, 4);
    dj.c(this.b, 0);
    if (!this.c);
    while (true)
    {
      this.c = bool;
      return;
      bool = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.toolbar.d
 * JD-Core Version:    0.6.2
 */