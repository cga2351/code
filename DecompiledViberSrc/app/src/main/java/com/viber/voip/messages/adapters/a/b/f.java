package com.viber.voip.messages.adapters.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.viber.voip.R.attr;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.f.b;
import com.viber.voip.widget.AvatarWithInitialsView;

public class f<T extends com.viber.voip.messages.adapters.a.a> extends com.viber.voip.ui.g.e<T, com.viber.voip.messages.adapters.a.c.a>
{
  private final Context a;
  private final AvatarWithInitialsView b;
  private final com.viber.voip.util.e.e c;
  private final com.viber.voip.util.e.f d;

  public f(Context paramContext, AvatarWithInitialsView paramAvatarWithInitialsView, com.viber.voip.util.e.e parame)
  {
    this.a = paramContext;
    this.c = parame;
    this.d = com.viber.voip.util.e.f.a(dc.a(this.a, R.attr.contactDefaultPhoto), f.b.b, false);
    this.b = paramAvatarWithInitialsView;
  }

  @SuppressLint({"NewApi"})
  public void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama)
  {
    super.a(paramT, parama);
    ConversationLoaderEntity localConversationLoaderEntity = paramT.a();
    if (!localConversationLoaderEntity.isConversation1on1())
      return;
    int i = paramT.e();
    switch (i)
    {
    default:
      this.b.a(localConversationLoaderEntity.getInitialDisplayName(), true);
      this.c.a(localConversationLoaderEntity.getParticipantPhoto(), this.b, this.d);
    case 3:
      while (true)
      {
        Drawable localDrawable2 = parama.b(localConversationLoaderEntity.isHiddenConversation());
        this.b.setSelector(localDrawable2);
        return;
        this.c.a(localConversationLoaderEntity.getParticipantPhoto(), this.b, this.d);
      }
    case 1:
    case 2:
    }
    AvatarWithInitialsView localAvatarWithInitialsView = this.b;
    if (i == 2);
    for (Drawable localDrawable1 = parama.h(); ; localDrawable1 = parama.g())
    {
      localAvatarWithInitialsView.setImageDrawable(localDrawable1);
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.f
 * JD-Core Version:    0.6.2
 */