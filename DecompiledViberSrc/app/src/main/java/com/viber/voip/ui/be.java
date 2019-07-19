package com.viber.voip.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;

public abstract class be
{
  protected final Context a;
  protected final Resources b;
  protected final LayoutInflater c;

  public be(Context paramContext)
  {
    this.a = paramContext;
    this.b = this.a.getResources();
    this.c = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
  }

  public abstract View a();

  public View b(View paramView)
  {
    return paramView;
  }

  public View c(View paramView)
  {
    return paramView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.be
 * JD-Core Version:    0.6.2
 */