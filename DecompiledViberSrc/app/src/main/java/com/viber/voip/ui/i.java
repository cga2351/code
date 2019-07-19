package com.viber.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class i
  implements View.OnClickListener
{
  private ViberFab a;
  private a b;

  public i(View paramView, int paramInt, a parama)
  {
    if (paramView != null)
    {
      this.a = ((ViberFab)paramView.findViewById(paramInt));
      if (a())
      {
        if (parama != null)
          this.a.setOnClickListener(this);
        this.b = parama;
      }
    }
  }

  public void a(boolean paramBoolean)
  {
    ViberFab localViberFab;
    if (a())
    {
      localViberFab = this.a;
      if (!paramBoolean)
        break label24;
    }
    label24: for (int i = 0; ; i = 8)
    {
      localViberFab.setVisibility(i);
      return;
    }
  }

  protected boolean a()
  {
    return this.a != null;
  }

  public ViberFab b()
  {
    return this.a;
  }

  public void onClick(View paramView)
  {
    if (this.b != null)
      this.b.a();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.i
 * JD-Core Version:    0.6.2
 */