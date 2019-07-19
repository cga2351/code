package com.viber.voip.messages.conversation.publicaccount;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.h;
import com.viber.voip.messages.conversation.ConversationWithPublicAccountLoaderEntity;
import com.viber.voip.messages.k;
import dagger.a;
import org.greenrobot.eventbus.EventBus;

public class c extends o
{
  public c(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, boolean paramBoolean, d.a parama1, EventBus paramEventBus)
  {
    super(paramContext, 17, c.h.a, paramLoaderManager, parama, parama1, paramEventBus);
    this.q = paramBoolean;
    a(ConversationWithPublicAccountLoaderEntity.PROJECTIONS);
    this.p = z();
    a(r());
  }

  protected String r()
  {
    return "(conversations.deleted=0 AND conversations.conversation_type=2 AND (group_role=2 OR group_role=1 OR group_role=4))";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.c
 * JD-Core Version:    0.6.2
 */