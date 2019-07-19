package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import java.util.HashSet;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class ag extends z<aa>
{
  private final Set<Long> l = new HashSet();
  private final a m;
  private bv.d n = new bv.d()
  {
    public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if ((!paramAnonymousBoolean2) && (paramAnonymousSet.contains(Long.valueOf(ag.this.t))))
        ag.this.l();
    }

    public void onDelete(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if ((!paramAnonymousBoolean) && (paramAnonymousSet.contains(Long.valueOf(ag.this.t))))
        ag.a(ag.this).a();
    }

    public void onRead(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if ((!paramAnonymousBoolean) && (paramAnonymousSet.contains(Long.valueOf(ag.this.t))))
        ag.a(ag.this).a();
    }
  };
  private bv.l o = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      if ((!paramAnonymousBoolean) && (paramAnonymousSet.contains(Long.valueOf(ag.this.t))))
        ag.this.l();
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if ((!paramAnonymousBoolean2) && (paramAnonymousSet.contains(Long.valueOf(ag.this.t))))
        ag.a(ag.this).a();
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };

  public ag(Context paramContext, LoaderManager paramLoaderManager, dagger.a<k> parama, a parama1, EventBus paramEventBus)
  {
    super(paramContext, 9, paramLoaderManager, parama, parama1, paramEventBus);
    this.m = parama1;
    s();
    d("messages.order_key ASC, messages.msg_date ASC");
  }

  private void s()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = com.viber.voip.s.a.e(this.l);
    a(String.format("messages.conversation_id=? AND +deleted=0 AND status<>12 AND extra_flags & 4194304 = 0 AND messages.extra_mime <>? AND messages.extra_mime <>? AND (messages.unread >0 OR messages._id IN (%s))", arrayOfObject));
  }

  protected aa a(Cursor paramCursor)
  {
    return new aa(paramCursor);
  }

  protected aa a(MessageEntity paramMessageEntity)
  {
    return new aa(paramMessageEntity);
  }

  public void a(long paramLong)
  {
    this.t = paramLong;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(this.t);
    arrayOfString[1] = String.valueOf(1000);
    arrayOfString[2] = String.valueOf(1002);
    b(arrayOfString);
  }

  protected void m()
  {
    int i = 0;
    super.m();
    int j = 0;
    while (i < getCount())
    {
      if (this.l.add(Long.valueOf(a(i))))
        j = 1;
      i++;
    }
    if (j != 0)
      s();
  }

  public void p()
  {
    super.p();
    bv localbv = ((k)this.u.get()).b();
    localbv.a(this.n);
    localbv.a(this.o);
  }

  public void q()
  {
    super.q();
    bv localbv = ((k)this.u.get()).b();
    localbv.b(this.n);
    localbv.b(this.o);
  }

  public static abstract interface a extends d.a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ag
 * JD-Core Version:    0.6.2
 */