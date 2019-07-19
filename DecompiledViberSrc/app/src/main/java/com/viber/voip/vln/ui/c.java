package com.viber.voip.vln.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.messages.k;
import com.viber.voip.util.da;
import dagger.a;
import org.greenrobot.eventbus.EventBus;

public class c extends n<RegularConversationLoaderEntity>
{
  public c(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, Bundle paramBundle, d.a parama1, EventBus paramEventBus, String paramString)
  {
    super(paramContext, paramLoaderManager, parama, false, true, n.a.g, paramBundle, "", parama1, paramEventBus, null, null);
    H();
    a(RegularConversationLoaderEntity.PROJECTIONS);
    if (!da.a(paramString))
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = ("vln_" + paramString);
      b(arrayOfString);
      return;
    }
    b(new String[] { "" });
  }

  private void H()
  {
    n(false);
    o(false);
    g(false);
    i(false);
    j(false);
    p(false);
    d(false);
    b(false);
    a(false);
    e(false);
    c(false);
  }

  protected RegularConversationLoaderEntity a(Cursor paramCursor)
  {
    return new RegularConversationLoaderEntity(paramCursor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.ui.c
 * JD-Core Version:    0.6.2
 */