package com.viber.voip.engagement.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.contacts.adapters.f;
import com.viber.voip.ui.af.c;

class d extends f
{
  private final g a;
  private final boolean b;

  public d(Context paramContext, LayoutInflater paramLayoutInflater, g paramg, boolean paramBoolean)
  {
    super(paramContext, paramLayoutInflater);
    this.a = paramg;
    this.b = paramBoolean;
    a(0, R.layout.list_item_engagement_contact, this);
    a(1, R.layout.list_item_suggested_contact_with_header, this);
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramView.setTag(R.id.header, new af.c());
      return new b(paramView, paramInt, this.a, this.b);
    }
    return super.a(paramView, paramInt, paramViewGroup);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.d
 * JD-Core Version:    0.6.2
 */