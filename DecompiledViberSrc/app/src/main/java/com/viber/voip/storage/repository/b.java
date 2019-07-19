package com.viber.voip.storage.repository;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.google.d.f;
import com.viber.provider.messages.b.c.c;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.k;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import dagger.a;
import java.util.ArrayList;

public class b extends com.viber.provider.d<ConversationWithMediaSizesEntity>
  implements h
{
  private final a<k> l;
  private final f m;
  private final d n = new d(this);
  private final l o = new l(this);
  private final c p = new c(this);
  private final g q = new g(this);
  private i r;

  public b(long paramLong, Context paramContext, LoaderManager paramLoaderManager, a<k> parama, f paramf)
  {
    super(33, c.c.b, paramContext, paramLoaderManager, null, 0);
    this.l = parama;
    this.m = paramf;
    a(ConversationWithMediaSizesEntity.PROJECTIONS);
    a("conversations._id=?");
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    b(arrayOfString);
    this.n.a(paramLong);
    this.o.a(paramLong);
    this.p.a(paramLong);
    this.q.a(paramLong);
  }

  public void a(i parami)
  {
    this.r = parami;
    this.n.a(parami);
    this.o.a(parami);
    this.p.a(parami);
    this.q.a(parami);
  }

  public ConversationWithMediaSizesEntity e(int paramInt)
  {
    if (b_(paramInt))
      return new ConversationWithMediaSizesEntity(this.f, this.m);
    return null;
  }

  public void f(String paramString)
  {
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
      if (this.r != null)
        this.r.a(localArrayList);
      return;
    }
    finally
    {
    }
  }

  public void p()
  {
    super.p();
    bv localbv = ((k)this.l.get()).b();
    localbv.a(this.n);
    localbv.a(this.o);
    localbv.a(this.p);
    localbv.a(this.q);
  }

  public void q()
  {
    super.q();
    bv localbv = ((k)this.l.get()).b();
    localbv.b(this.n);
    localbv.b(this.o);
    localbv.b(this.p);
    localbv.b(this.q);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.b
 * JD-Core Version:    0.6.2
 */