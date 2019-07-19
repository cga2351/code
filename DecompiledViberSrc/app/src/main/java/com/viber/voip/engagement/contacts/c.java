package com.viber.voip.engagement.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.viber.voip.contacts.a;
import com.viber.voip.contacts.adapters.f;
import com.viber.voip.contacts.adapters.i;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;

class c extends i
  implements g
{
  private final g k;
  private final m l;

  public c(Context paramContext, m paramm, a parama1, g paramg, a parama2, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, false, parama1, parama2, paramLayoutInflater);
    this.k = paramg;
    this.l = paramm;
  }

  protected f a(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    return new d(paramContext, paramLayoutInflater, this, false);
  }

  protected void a(int paramInt, View paramView, com.viber.voip.model.c paramc)
  {
    super.a(paramInt, paramView, paramc);
    b localb = (b)paramView.getTag();
    this.l.a(localb, SendButtonReceiverId.createFromContactId(paramc.getId()));
  }

  public void a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
  }

  public void a(com.viber.voip.model.c paramc, boolean paramBoolean)
  {
    this.k.a(paramc, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.c
 * JD-Core Version:    0.6.2
 */