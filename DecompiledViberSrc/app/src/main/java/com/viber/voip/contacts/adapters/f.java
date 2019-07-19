package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.adapters.a.b.h;
import com.viber.voip.messages.adapters.a.b.j;
import com.viber.voip.messages.conversation.adapter.a;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.b;
import com.viber.voip.ui.af.c;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.GroupIconView;

public class f extends a
  implements a.a
{
  private Context a;
  private e b;

  public f(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    super(paramLayoutInflater);
    this.a = paramContext;
    this.b = e.a(paramContext);
    a(0, R.layout._ics_fragment_contacts_list_item, this);
    a(1, R.layout._ics_fragment_contacts_list_header_item, this);
    a(2, R.layout._ics_fragment_contacts_with_conversation_list_header_item, this);
    a(3, R.layout._ics_fragment_contacts_with_group_conversation_list_header_item, this);
  }

  public View a(int paramInt)
  {
    return b(paramInt).a(null);
  }

  public Object a(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    switch (paramInt)
    {
    default:
      throw new RuntimeException("INVALID VIEW TYPE: " + paramInt);
    case 3:
      paramView.setTag(R.id.participants_view_binder, new j(this.a, (GroupIconView)paramView.findViewById(R.id.group_icon), this.b));
    case 2:
      paramView.setTag(R.id.status_icon_view_binder, new h(this.a, (ImageView)paramView.findViewById(R.id.status_icon)));
    case 0:
    case 1:
    }
    paramView.setTag(R.id.header, new af.c());
    return new g.a(paramView, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.f
 * JD-Core Version:    0.6.2
 */