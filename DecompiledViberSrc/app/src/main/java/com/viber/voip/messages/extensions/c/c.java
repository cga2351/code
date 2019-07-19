package com.viber.voip.messages.extensions.c;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.controller.bv;

public class c extends a
{
  public c(Context paramContext, LoaderManager paramLoaderManager, dagger.a<bv> parama, d.a parama1)
  {
    super(30, paramContext, paramLoaderManager, parama, parama1);
    a("chat_extensions._id NOT IN (SELECT chat_extensions._id FROM chat_extensions WHERE chat_extensions.featured_index <> 2147483647 OR chat_extensions.last_use_time > 0 ORDER BY chat_extensions.featured_index ASC, chat_extensions.last_use_time DESC LIMIT 6)");
    d("chat_extensions.order_key ASC");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.c.c
 * JD-Core Version:    0.6.2
 */