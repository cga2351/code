package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import dagger.a;
import org.greenrobot.eventbus.EventBus;

public class v extends z<aa>
{
  public v(int paramInt, Context paramContext, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    super(paramContext, paramInt, paramLoaderManager, parama, parama1, paramEventBus);
    a("messages.conversation_id=? AND +deleted=0 AND messages.extra_mime IN ( 1, 3)");
    d("messages.order_key DESC, messages.msg_date DESC");
  }

  public v(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    this(9, paramContext, paramLoaderManager, parama, parama1, paramEventBus);
  }

  protected aa a(Cursor paramCursor)
  {
    return new aa(paramCursor);
  }

  protected aa a(MessageEntity paramMessageEntity)
  {
    return new aa(paramMessageEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.v
 * JD-Core Version:    0.6.2
 */