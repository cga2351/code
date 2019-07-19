package com.viber.voip.messages.adapters;

import android.view.LayoutInflater;
import com.viber.voip.R.layout;
import com.viber.voip.messages.adapters.a.a.b;
import com.viber.voip.messages.adapters.a.a.c;
import com.viber.voip.messages.adapters.a.a.d;
import com.viber.voip.messages.adapters.a.a.f;
import com.viber.voip.messages.adapters.a.a.g;
import com.viber.voip.messages.adapters.a.a.h;
import com.viber.voip.messages.adapters.a.a.l;

public class v extends com.viber.voip.messages.conversation.adapter.a
{
  public v(LayoutInflater paramLayoutInflater, com.viber.voip.messages.adapters.a.e parame)
  {
    super(paramLayoutInflater);
    a(0, R.layout.fragment_messages_list_item, new c(parame));
    a(1, R.layout.fragment_messages_group_list_item, new f(parame));
    a(2, R.layout.fragment_messages_list_search_item, new b(parame));
    a(4, R.layout.fragment_messages_group_list_search_in_messeges_item, new d(parame));
    a(3, R.layout.fragment_messages_group_list_search_item, new com.viber.voip.messages.adapters.a.a.e(parame));
    a(5, R.layout.fragment_messages_list_item, new com.viber.voip.messages.adapters.a.a.a(parame));
    a(6, R.layout.fragment_messages_list_item, new l(parame));
    a(7, R.layout.fragment_messages_conference_list_item, new h(parame));
    a(8, R.layout.fragment_messages_conference_group_list_item, new g(parame));
  }

  public static v a(LayoutInflater paramLayoutInflater, com.viber.voip.messages.adapters.a.e parame)
  {
    return new v(paramLayoutInflater, parame);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.v
 * JD-Core Version:    0.6.2
 */