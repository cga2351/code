package com.viber.voip.messages.conversation.publicaccount;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.h;
import com.viber.voip.messages.conversation.l;
import com.viber.voip.messages.conversation.l.a;
import com.viber.voip.messages.k;

public class a extends l
{
  public a(Context paramContext, LoaderManager paramLoaderManager, dagger.a<k> parama, l.a parama1, d.a parama2)
  {
    super(19, c.h.d, paramContext, paramLoaderManager, parama2, parama, parama1);
    a(PublicGroupConversationItemLoaderEntity.PROJECTIONS);
  }

  public PublicGroupConversationItemLoaderEntity f(int paramInt)
  {
    if (b_(paramInt))
      return new PublicGroupConversationItemLoaderEntity(this.f);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.a
 * JD-Core Version:    0.6.2
 */