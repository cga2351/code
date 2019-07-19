package com.viber.voip.storage.repository;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import com.viber.dexshared.Logger;
import com.viber.provider.messages.b.c.c;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.manager.af;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.k;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import dagger.a;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

public class e extends n<ConversationWithMediaSizesEntity>
  implements h
{
  protected static final Logger w = ViberEnv.getLogger();
  private c A;
  private final g B = new g(this);
  private i C;
  private final com.google.d.f x;
  private d y;
  private l z;

  public e(Context paramContext, LoaderManager paramLoaderManager, Bundle paramBundle, a<k> parama, EventBus paramEventBus, com.google.d.f paramf)
  {
    super(paramContext, 32, c.c.a, paramLoaderManager, parama, null, paramEventBus, null, null);
    b(paramBundle);
    this.x = paramf;
    i(true);
    j(true);
    k(true);
    n(true);
    o(true);
    l(false);
    q(true);
    r(true);
    g(true);
    h(true);
    a(ConversationWithMediaSizesEntity.PROJECTIONS);
    d("conversations.date DESC");
  }

  private void b(Bundle paramBundle)
  {
    if (paramBundle != null);
    for (String str = paramBundle.getString("manage_storage_conversation_search_query"); ; str = null)
    {
      this.o = str;
      return;
    }
  }

  protected ConversationWithMediaSizesEntity a(Cursor paramCursor)
  {
    return new ConversationWithMediaSizesEntity(paramCursor, this.x);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("manage_storage_conversation_search_query", this.o);
  }

  public void a(i parami)
  {
    this.C = parami;
    this.y.a(parami);
    this.z.a(parami);
    this.A.a(parami);
    this.B.a(parami);
  }

  protected void h()
  {
    try
    {
      super.h();
      int i = getCount();
      ArrayList localArrayList = new ArrayList(i);
      for (int j = 0; j < i; j++)
        localArrayList.add(e(j));
      if (this.C != null)
        this.C.a(localArrayList);
      return;
    }
    finally
    {
    }
  }

  public void p()
  {
    super.p();
    ((k)this.n.get()).b().a(this.B);
  }

  public void q()
  {
    super.q();
    ((k)this.n.get()).b().b(this.B);
  }

  protected bv.e s()
  {
    if (this.t == null)
    {
      this.y = new d(this);
      this.t = this.y;
    }
    return this.y;
  }

  protected bv.l t()
  {
    this.A = new c(this);
    return this.A;
  }

  protected bv.n u()
  {
    this.z = new l(this);
    return this.z;
  }

  protected af x()
  {
    return f.a(this.x, this.d.getContentResolver());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.e
 * JD-Core Version:    0.6.2
 */