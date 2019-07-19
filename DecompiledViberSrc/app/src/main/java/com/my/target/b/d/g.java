package com.my.target.b.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.my.target.av;
import com.my.target.b.c.a.h;
import com.my.target.ct;

public final class g
  implements j
{
  j.a a;
  private final ct b;

  private g(ct paramct)
  {
    this.b = paramct;
  }

  public static g a(Context paramContext)
  {
    return new g(new ct(paramContext));
  }

  public final void a(final h paramh)
  {
    this.b.a(paramh.L(), paramh.K(), paramh.D());
    this.b.setAgeRestrictions(paramh.a());
    this.b.getImageView().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (g.this.a != null)
          g.this.a.a(paramh, null, paramAnonymousView.getContext());
      }
    });
    this.b.getCloseButton().setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (g.this.a != null)
          g.this.a.b();
      }
    });
    if (this.a != null)
      this.a.a(paramh, this.b.getContext());
  }

  public final void a(j.a parama)
  {
    this.a = parama;
  }

  public final void c()
  {
  }

  public final void e()
  {
  }

  public final View f()
  {
    return this.b;
  }

  public final void l_()
  {
  }

  public final void m_()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.g
 * JD-Core Version:    0.6.2
 */