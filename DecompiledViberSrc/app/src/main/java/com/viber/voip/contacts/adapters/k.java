package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.ui.af.c;

public class k extends f
{
  private m a;
  private e b;

  public k(Context paramContext, LayoutInflater paramLayoutInflater, m paramm, e parame)
  {
    super(paramContext, paramLayoutInflater);
    this.a = paramm;
    this.b = parame;
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    switch (paramInt)
    {
    default:
      return super.a(paramView, paramInt, paramViewGroup);
    case 0:
    case 1:
    }
    paramView.setTag(R.id.header, new af.c());
    return new j.a(paramView, paramInt, this.a, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.k
 * JD-Core Version:    0.6.2
 */