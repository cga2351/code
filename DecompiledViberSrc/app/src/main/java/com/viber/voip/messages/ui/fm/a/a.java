package com.viber.voip.messages.ui.fm.a;

import android.content.Context;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.ButtonMessage;
import com.viber.voip.messages.orm.entity.json.GifMessage;
import com.viber.voip.messages.orm.entity.json.ImageMessage;
import com.viber.voip.messages.orm.entity.json.SeparatorMessage;
import com.viber.voip.messages.orm.entity.json.StickerMessage;
import com.viber.voip.messages.orm.entity.json.TextMessage;
import com.viber.voip.messages.orm.entity.json.VideoMessage;
import com.viber.voip.messages.ui.fm.TextMessageViewBuilder;
import com.viber.voip.messages.ui.fm.e;
import com.viber.voip.messages.ui.fm.g;
import com.viber.voip.messages.ui.fm.j;
import com.viber.voip.messages.ui.fm.n;
import com.viber.voip.messages.ui.fm.o;

public class a
{
  public com.viber.voip.messages.ui.fm.i<? extends View> a(b paramb, Context paramContext, BaseMessage paramBaseMessage, com.viber.voip.messages.conversation.adapter.a.c.a.i parami, com.viber.voip.messages.conversation.adapter.a.a parama, f paramf, com.viber.voip.messages.extensions.c paramc)
  {
    switch (1.a[paramBaseMessage.getType().ordinal()])
    {
    default:
      return null;
    case 1:
      return new com.viber.voip.messages.ui.fm.c((ButtonMessage)paramBaseMessage, paramContext, parama, parami, paramb);
    case 2:
      return new TextMessageViewBuilder((TextMessage)paramBaseMessage, paramContext, parama, parami, paramb, paramf);
    case 3:
      return new g((ImageMessage)paramBaseMessage, paramContext, parama, parami, paramb);
    case 4:
      return new o((VideoMessage)paramBaseMessage, paramContext, parama, parami, paramb, paramc);
    case 5:
      return new e((GifMessage)paramBaseMessage, paramContext, parama, parami, paramb);
    case 6:
      return new n((StickerMessage)paramBaseMessage, paramContext, parama, parami, paramb);
    case 7:
    }
    return new j((SeparatorMessage)paramBaseMessage, paramContext, parama, parami, paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.a.a
 * JD-Core Version:    0.6.2
 */