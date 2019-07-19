package com.viber.voip.messages.conversation.commongroups;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.conversation.c;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.MessageEntity;
import dagger.a;
import java.util.Set;

public class e extends c<f>
{
  private final bv.l m = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.a(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
      e.this.l();
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
      by.a(this, paramAnonymousMessageEntity, paramAnonymousBoolean);
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      e.this.l();
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if (!paramAnonymousBoolean1)
        e.this.l();
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };

  public e(Context paramContext, LoaderManager paramLoaderManager, a<bv> parama, d.a parama1, String paramString)
  {
    super(35, paramContext, paramLoaderManager, parama, parama1, 0);
    a(f.a);
    f(paramString);
    d("conversations.date DESC");
  }

  public f e(int paramInt)
  {
    if (b_(paramInt))
      return new f(this.f);
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
    ((bv)this.l.get()).a(this.m);
  }

  protected bv.e r()
  {
    return new bv.d()
    {
      public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        if (m.f(paramAnonymousInt))
          e.this.l();
      }

      public void onDelete(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (m.f(paramAnonymousInt))
          e.this.l();
      }

      public void onRead(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (m.f(paramAnonymousInt))
          e.this.l();
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.commongroups.e
 * JD-Core Version:    0.6.2
 */