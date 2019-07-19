package com.viber.voip.messages.conversation.adapter.a.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.messages.conversation.ah;
import com.viber.voip.messages.d.b;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;

public class j extends i
{
  public j(Context paramContext, e parame, b paramb, com.viber.voip.messages.ui.ai paramai, x paramx, com.viber.voip.messages.j paramj, ah paramah, com.viber.voip.messages.controller.ai paramai1, boolean paramBoolean, com.viber.voip.messages.conversation.adapter.b.a parama, dagger.a<ConversationItemLoaderEntity> parama1, dagger.a<Boolean> parama2)
  {
    super(paramContext, parame, paramb, paramai, paramx, paramj, paramah, paramai1, paramBoolean, parama, parama2, parama1);
    int i = ContextCompat.getColor(this.v, R.color.negative);
    this.a = R.drawable.timestamp_bg;
    this.d = ContextCompat.getColor(this.v, R.color.solid_10);
    this.e = ContextCompat.getColor(this.v, R.color.solid_20);
    this.f = i;
    Resources localResources = this.v.getResources();
    this.g = localResources.getDimensionPixelSize(R.dimen.msg_separator_height_custom_back);
    this.h = localResources.getDimensionPixelSize(R.dimen.msg_separator_top_margin_custom_back);
    this.k = this.v.getResources().getDimensionPixelSize(R.dimen.conversation_incoming_left_controls_widht_custom);
    this.l = this.v.getResources().getDimensionPixelSize(R.dimen.conversation_incoming_right_controls_widht_custom);
    this.m = i;
  }

  public int a()
  {
    return this.a;
  }

  public int b()
  {
    return dc.a(this.v, R.attr.conversationCallBackground);
  }

  public int c()
  {
    return dc.a(this.v, R.attr.conversationMissedCallBackground);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c.a.j
 * JD-Core Version:    0.6.2
 */