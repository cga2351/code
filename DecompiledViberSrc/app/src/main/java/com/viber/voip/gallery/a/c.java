package com.viber.voip.gallery.a;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public abstract class c extends PagerAdapter
{
  protected Context a;

  public c(Context paramContext)
  {
    this.a = paramContext;
  }

  public void a(int paramInt, View paramView)
  {
  }

  public abstract void a(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public void b(int paramInt, View paramView)
  {
  }

  public void c(int paramInt, View paramView)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.a.c
 * JD-Core Version:    0.6.2
 */