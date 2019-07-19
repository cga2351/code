package com.viber.voip.messages.conversation.adapter.a.b;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.messenger.MessageSenderListener;
import com.viber.jni.messenger.MessengerDelegate.MessagesSender;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.a.j.b;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.conversation.af;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import dagger.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class f extends d
{
  public static final String l = "messages.conversation_id=? AND (messages.extra_flags & " + com.viber.voip.util.av.a(0L, 32) + ") <> 0 AND (" + "messages" + "." + "status" + "<>" + -1 + ")";
  protected static final Logger m = ViberEnv.getLogger();
  private a<k> n;
  private MessageSenderListener o;
  private final EventBus p;
  private Set<Integer> q;
  private Set<Long> r;
  private long s;
  private bv.l t = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousLong1 == f.a(f.this)) && ((f.c(f.this).contains(Long.valueOf(paramAnonymousLong2))) || (paramAnonymousLong2 == 0L)))
        f.this.l();
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
      if (paramAnonymousLong == f.a(f.this))
        f.this.l();
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousMessageEntity.getConversationId() == f.a(f.this)) && (paramAnonymousMessageEntity.isPinMessage()))
      {
        f.b(f.this).add(Integer.valueOf(paramAnonymousMessageEntity.getMessageSeq()));
        f.this.l();
      }
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };
  private MessengerDelegate.MessagesSender u = new MessengerDelegate.MessagesSender()
  {
    public boolean onMessageDelivered(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return false;
    }

    public void onSendMessageReply(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString)
    {
      if (f.b(f.this).contains(Integer.valueOf(paramAnonymousInt1)))
      {
        f.b(f.this).remove(Integer.valueOf(paramAnonymousInt1));
        if ((paramAnonymousLong > 0L) && (1 == paramAnonymousInt2))
          f.c(f.this).add(Long.valueOf(paramAnonymousLong));
      }
    }
  };

  public f(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, Engine paramEngine, EventBus paramEventBus)
  {
    super(27, c.e.b, paramContext, paramLoaderManager, parama1, 0);
    this.n = parama;
    this.o = paramEngine.getDelegatesManager().getMessageSenderListener();
    this.p = paramEventBus;
    this.q = new HashSet();
    this.r = Collections.synchronizedSet(new HashSet());
    a(af.a);
    a(l);
    d("messages.order_key DESC, messages.msg_date DESC");
    d(1);
  }

  private void s()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(this.s);
    b(arrayOfString);
  }

  public void a(long paramLong)
  {
    if (this.s != paramLong)
    {
      this.s = paramLong;
      s();
    }
  }

  public af e(int paramInt)
  {
    if (b_(paramInt))
    {
      af localaf = new af(this.f);
      long l1 = localaf.b();
      if ((this.r.contains(Long.valueOf(l1))) && (localaf.a()))
        this.r.remove(Long.valueOf(l1));
      return localaf;
    }
    return null;
  }

  @Subscribe
  public void onLocalUnpin(j.b paramb)
  {
    if (this.s == paramb.a)
      l();
  }

  public void p()
  {
    super.p();
    if (!this.p.isRegistered(this))
      this.p.register(this);
    ((k)this.n.get()).b().a(this.t);
    this.o.registerDelegate(this.u, com.viber.voip.av.a(av.e.d));
  }

  public void q()
  {
    super.q();
    this.p.unregister(this);
    ((k)this.n.get()).b().b(this.t);
    this.o.removeDelegate(this.u);
  }

  public long r()
  {
    return this.s;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.b.f
 * JD-Core Version:    0.6.2
 */