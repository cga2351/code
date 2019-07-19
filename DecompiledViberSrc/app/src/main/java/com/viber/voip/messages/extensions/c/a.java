package com.viber.voip.messages.extensions.c;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.b;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.b;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;

abstract class a extends d<ChatExtensionLoaderEntity>
{
  private final dagger.a<bv> l;
  private final bv.b m = new b(this);

  public a(int paramInt, Context paramContext, LoaderManager paramLoaderManager, dagger.a<bv> parama, d.a parama1)
  {
    super(paramInt, c.b.a, paramContext, paramLoaderManager, parama1, 0);
    a(ChatExtensionLoaderEntity.PROJECTIONS);
    this.l = parama;
  }

  public ChatExtensionLoaderEntity e(int paramInt)
  {
    if (b_(paramInt))
      return new ChatExtensionLoaderEntity(this.f);
    return null;
  }

  public void p()
  {
    super.p();
    ((bv)this.l.get()).a(this.m);
  }

  public void q()
  {
    super.q();
    ((bv)this.l.get()).b(this.m);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.c.a
 * JD-Core Version:    0.6.2
 */