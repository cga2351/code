package com.viber.voip.messages.conversation;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.k;
import dagger.a;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;

public class ak extends v
{
  public ak(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, EventBus paramEventBus, long paramLong)
  {
    super(10, paramContext, paramLoaderManager, parama, parama1, paramEventBus);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = String.valueOf(paramLong);
    a(String.format(localLocale, "messages.conversation_id=? AND  messages.deleted=0 AND messages.extra_mime <> 1007 AND messages.extra_mime <> 1008 AND ( messages.extra_mime IN ( 1, 3, 1003, 1004 )) AND ( messages._id = %s )", arrayOfObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ak
 * JD-Core Version:    0.6.2
 */