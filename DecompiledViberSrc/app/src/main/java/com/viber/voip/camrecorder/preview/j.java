package com.viber.voip.camrecorder.preview;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.messages.k;
import dagger.a;
import org.greenrobot.eventbus.EventBus;

public class j extends n<RegularConversationLoaderEntity>
{
  public j(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, long paramLong, EventBus paramEventBus)
  {
    super(paramContext, paramLoaderManager, parama, false, false, n.a.a, null, null, parama1, paramEventBus, null, null);
    a(RegularConversationLoaderEntity.PROJECTIONS);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    b(arrayOfString);
  }

  protected RegularConversationLoaderEntity a(Cursor paramCursor)
  {
    return new RegularConversationLoaderEntity(paramCursor);
  }

  protected String r()
  {
    return "conversations._id=?";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.j
 * JD-Core Version:    0.6.2
 */