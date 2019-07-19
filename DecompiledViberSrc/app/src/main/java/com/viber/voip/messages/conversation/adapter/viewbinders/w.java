package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.g;
import com.viber.voip.messages.conversation.adapter.a.c.a.h;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.FormattedMessageConstraintHelper;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.FormattedMessageConstraintHelper.a;
import com.viber.voip.messages.conversation.adapter.z;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.messages.ui.fm.d;
import com.viber.voip.ui.g.e;
import com.viber.voip.widget.FormattedMessageLayout;
import java.util.List;

public class w extends e<a, i>
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final FormattedMessageLayout c;
  private d d;
  private final FormattedMessageConstraintHelper e;
  private final g f;
  private z<MessageType> g;
  private final b h;
  private final f i;
  private final c j;

  public w(FormattedMessageLayout paramFormattedMessageLayout, FormattedMessageConstraintHelper paramFormattedMessageConstraintHelper, g paramg, z<MessageType> paramz, b paramb, f paramf, c paramc)
  {
    this.c = paramFormattedMessageLayout;
    this.b = paramFormattedMessageLayout.getContext();
    this.e = paramFormattedMessageConstraintHelper;
    this.f = paramg;
    this.g = paramz;
    this.h = paramb;
    this.i = paramf;
    this.j = paramc;
  }

  private void a(ViewGroup paramViewGroup, List<BaseMessage> paramList)
  {
    for (int k = 0; k < paramList.size(); k++)
    {
      BaseMessage localBaseMessage = (BaseMessage)paramList.get(k);
      View localView = paramViewGroup.getChildAt(k);
      this.g.a(localBaseMessage.getType(), localView);
    }
  }

  public void a()
  {
    a locala = (a)d();
    if (locala == null)
    {
      super.a();
      return;
    }
    FormattedMessage localFormattedMessage = locala.c().L();
    if (localFormattedMessage != null)
      a(this.c, localFormattedMessage.getMessage());
    this.c.removeAllViews();
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
    super.a();
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    FormattedMessage localFormattedMessage = localaa.L();
    if (localFormattedMessage == null)
      return;
    this.c.setTag(localaa);
    h localh = parami.ag();
    this.e.setTag(new FormattedMessageConstraintHelper.a(localFormattedMessage, localh.c(localaa), parama.q(), localaa.bO()));
    this.d = new d(this.h, localFormattedMessage, this.f, this.g, this.b, parama, parami, this.i, this.j);
    this.d.a(this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.w
 * JD-Core Version:    0.6.2
 */