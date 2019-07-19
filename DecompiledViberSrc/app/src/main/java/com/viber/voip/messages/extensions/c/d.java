package com.viber.voip.messages.extensions.c;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.controller.bv;

public class d extends a
{
  public d(Context paramContext, LoaderManager paramLoaderManager, dagger.a<bv> parama, d.a parama1)
  {
    super(31, paramContext, paramLoaderManager, parama, parama1);
    a("chat_extensions.featured_index <> 2147483647 OR chat_extensions.last_use_time > 0");
    d("chat_extensions.featured_index ASC, chat_extensions.last_use_time DESC");
    d(6);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.c.d
 * JD-Core Version:    0.6.2
 */