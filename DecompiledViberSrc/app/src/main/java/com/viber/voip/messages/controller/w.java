package com.viber.voip.messages.controller;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.i.c.h;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.b.a;
import com.viber.voip.messages.conversation.ui.b.z;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.util.e.h.a;

public class w extends cb
{
  private static final Logger a = ViberEnv.getLogger();
  private final ConversationFragment b;
  private final z c;
  private final c d;
  private final a e;

  public w(ConversationFragment paramConversationFragment, z paramz, c paramc, a parama)
  {
    this.c = paramz;
    this.d = paramc;
    this.b = paramConversationFragment;
    this.e = parama;
  }

  private void a(String paramString)
  {
  }

  private String c(aa paramaa)
  {
    return paramaa.bx().getTitle();
  }

  public void a(Context paramContext, aa paramaa, int paramInt)
  {
    if (!paramaa.aE())
      return;
    String str1 = c(paramaa);
    StringBuilder localStringBuilder = new StringBuilder().append("Open youtube chatex: ");
    String str2;
    String str3;
    if (str1 != null)
    {
      str2 = str1;
      a(str2);
      this.c.a();
      str3 = this.d.g();
      if (!TextUtils.isEmpty(str1))
        break label99;
    }
    while (true)
    {
      this.e.a(str3, str1, 10, "Sticker Clicker");
      return;
      str2 = "none";
      break;
      label99: if (!c.h.f.e())
        this.c.a(str3, str1);
    }
  }

  public void a(aa paramaa, ImageView paramImageView, com.viber.voip.util.e.f paramf, h.a parama)
  {
    paramImageView.setImageResource(R.drawable.message_offer_chatex);
    if (parama != null)
      parama.onLoadComplete(null, null, false);
  }

  public boolean a(aa paramaa)
  {
    return (paramaa.aP()) && (this.b.Z().k()) && (this.d.h());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.w
 * JD-Core Version:    0.6.2
 */