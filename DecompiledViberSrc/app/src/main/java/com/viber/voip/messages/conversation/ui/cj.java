package com.viber.voip.messages.conversation.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;

public class cj
{
  private static final Logger a = ViberEnv.getLogger();
  private LinearLayout b;
  private LayoutInflater c;

  public cj(LinearLayout paramLinearLayout, LayoutInflater paramLayoutInflater)
  {
    this.b = paramLinearLayout;
    this.c = paramLayoutInflater;
  }

  private boolean a(View paramView, int paramInt)
  {
    if (dj.a(paramView, this.b))
      return false;
    this.b.addView(paramView, paramInt);
    return true;
  }

  public View a(int paramInt)
  {
    return this.c.inflate(paramInt, this.b, false);
  }

  public boolean a(View paramView)
  {
    return a(paramView, -1);
  }

  public boolean b(View paramView)
  {
    return a(paramView, 0);
  }

  public boolean c(View paramView)
  {
    if (dj.a(paramView, this.b))
    {
      this.b.removeView(paramView);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.cj
 * JD-Core Version:    0.6.2
 */