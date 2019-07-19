package com.viber.voip.messages.adapters.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import com.viber.voip.R.attr;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.b;
import com.viber.voip.widget.GroupIconView;

public class j<T extends com.viber.voip.messages.adapters.a.a> extends com.viber.voip.ui.g.e<T, com.viber.voip.messages.adapters.a.c.a>
{
  private final Context a;
  private final GroupIconView b;
  private final com.viber.voip.util.e.e c;
  private final f d;

  public j(Context paramContext, GroupIconView paramGroupIconView, com.viber.voip.util.e.e parame)
  {
    this.a = paramContext;
    this.b = paramGroupIconView;
    this.c = parame;
    this.d = f.a(dc.a(this.a, R.attr.contactDefaultPhoto), f.b.b, false);
  }

  @SuppressLint({"NewApi"})
  public void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama)
  {
    super.a(paramT, parama);
    ConversationLoaderEntity localConversationLoaderEntity = paramT.a();
    if (!localConversationLoaderEntity.isGroupBehavior())
      return;
    long[] arrayOfLong = localConversationLoaderEntity.getParticipantInfos();
    Uri localUri = localConversationLoaderEntity.getIconUriOrDefault();
    dj.a(this.b, this.c, this.d, parama.b(), localUri, arrayOfLong);
    this.b.setForeground(parama.b(localConversationLoaderEntity.isHiddenConversation()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.j
 * JD-Core Version:    0.6.2
 */