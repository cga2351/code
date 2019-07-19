package com.viber.voip.banner.notificationsoff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.util.dj;

public class a
  implements f.b
{
  private final ViewGroup a;
  private LayoutInflater b;

  public a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater)
  {
    this.a = paramViewGroup;
    this.b = paramLayoutInflater;
  }

  public View a(int paramInt)
  {
    return this.b.inflate(paramInt, this.a, false);
  }

  public boolean a(View paramView)
  {
    boolean bool = dj.a(paramView, this.a);
    if (!bool)
      this.a.addView(paramView);
    return !bool;
  }

  public boolean b(View paramView)
  {
    boolean bool = dj.a(paramView, this.a);
    if (bool)
      this.a.removeView(paramView);
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.notificationsoff.a
 * JD-Core Version:    0.6.2
 */