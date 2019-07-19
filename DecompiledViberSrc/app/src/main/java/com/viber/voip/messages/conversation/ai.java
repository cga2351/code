package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.conversation.a.h;
import com.viber.voip.messages.k;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.util.da;
import dagger.a;
import org.greenrobot.eventbus.EventBus;

public class ai extends n<RegularConversationLoaderEntity>
{
  public ai(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, boolean paramBoolean1, boolean paramBoolean2, n.a parama1, Bundle paramBundle, String paramString, d.a parama2, EventBus paramEventBus)
  {
    this(paramContext, paramLoaderManager, parama, paramBoolean1, paramBoolean2, parama1, paramBundle, paramString, parama2, paramEventBus, null, null);
  }

  public ai(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, boolean paramBoolean1, boolean paramBoolean2, n.a parama1, Bundle paramBundle, String paramString, d.a parama2, EventBus paramEventBus, h paramh, a<ConferenceCallsRepository> parama3)
  {
    super(paramContext, paramLoaderManager, parama, paramBoolean1, paramBoolean2, parama1, paramBundle, paramString, parama2, paramEventBus, paramh, parama3);
    H();
  }

  private void H()
  {
    a(RegularConversationLoaderEntity.PROJECTIONS);
    b("INBOX");
  }

  public String K()
  {
    return da.h(this.o);
  }

  protected RegularConversationLoaderEntity a(Cursor paramCursor)
  {
    return new RegularConversationLoaderEntity(paramCursor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ai
 * JD-Core Version:    0.6.2
 */