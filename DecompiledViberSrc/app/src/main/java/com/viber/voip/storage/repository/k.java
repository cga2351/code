package com.viber.voip.storage.repository;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import com.google.d.f;
import dagger.a;
import org.greenrobot.eventbus.EventBus;

public class k extends e
{
  public k(Context paramContext, LoaderManager paramLoaderManager, Bundle paramBundle, a<com.viber.voip.messages.k> parama, EventBus paramEventBus, f paramf)
  {
    super(paramContext, paramLoaderManager, paramBundle, parama, paramEventBus, paramf);
    l(true);
  }

  protected String v()
  {
    return "conversations.flags & 262144=0";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.k
 * JD-Core Version:    0.6.2
 */