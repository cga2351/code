package com.viber.voip.shareviber.invitescreen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.contacts.adapters.f;

public class a extends f
{
  private final b.a a;

  public a(Context paramContext, LayoutInflater paramLayoutInflater, b.a parama)
  {
    super(paramContext, paramLayoutInflater);
    this.a = parama;
    a(0, R.layout.list_item_invite_to_viber_contact, this);
    a(1, R.layout.list_item_invite_to_viber_contact_with_header, this);
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    if ((paramInt == 0) || (paramInt == 1))
      return new b(paramView, paramInt, this.a);
    return super.a(paramView, paramInt, paramViewGroup);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.a.a
 * JD-Core Version:    0.6.2
 */