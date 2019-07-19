package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.e;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.cj;
import dagger.a;
import java.util.concurrent.atomic.AtomicInteger;
import org.greenrobot.eventbus.EventBus;

public class k extends q<aa>
{
  private static final Logger v = ViberEnv.getLogger();
  private bv.t w;
  private AtomicInteger x = new AtomicInteger(0);
  private Runnable y;

  public k(Context paramContext, LoaderManager paramLoaderManager, a<com.viber.voip.messages.k> parama, d.a parama1, EventBus paramEventBus)
  {
    super(paramContext, 20, c.e.a, aa.a, paramLoaderManager, parama, parama1, paramEventBus);
    a("messages.conversation_id=? AND status<>12 AND extra_flags & 4194304 = 0 AND messages.order_key>=IFNULL((SELECT messages.order_key FROM [messages] WHERE messages.conversation_id=? AND status<>12 AND extra_flags & 4194304 = 0 AND messages.extra_mime <> 1007 ORDER BY messages.order_key DESC, messages.msg_date DESC LIMIT ?, 1), 0)");
    this.w = new bv.t()
    {
      public void onPublicGroupSyncFinished(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        if (paramAnonymousInt1 == k.a(k.this).get())
        {
          k.a(k.this).set(0);
          k.this.l();
        }
      }

      public void onPublicGroupSyncRequestCanceled(int paramAnonymousInt)
      {
        if (paramAnonymousInt == k.a(k.this).get())
        {
          k.a(k.this).set(0);
          k.b(k.this);
        }
      }
    };
  }

  private void J()
  {
    try
    {
      if (this.y != null)
      {
        this.y.run();
        this.y = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    super.a(paramLong);
    this.x.set(0);
  }

  public boolean a(long paramLong, int paramInt, Runnable paramRunnable)
  {
    return a(paramLong, paramInt, paramRunnable, null);
  }

  public boolean a(long paramLong, int paramInt, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if (!cj.b(ViberApplication.getApplication()))
      if (paramRunnable1 != null)
        paramRunnable1.run();
    while ((paramInt <= 0) || (paramLong <= 0L))
      return false;
    this.x.set((int)(System.currentTimeMillis() / 1000L));
    this.y = paramRunnable2;
    ViberApplication.getInstance().getMessagesManager().d().a(this.x.get(), paramLong, paramInt, false);
    return true;
  }

  public void e(String paramString)
  {
    try
    {
      if (this.s > 0L)
        super.e(paramString);
      while (true)
      {
        return;
        super.e("");
      }
    }
    finally
    {
    }
  }

  protected void m()
  {
    try
    {
      super.m();
      if (this.x.get() == 0)
        J();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void p()
  {
    super.p();
    o.a().a(this.w);
  }

  public void q()
  {
    super.q();
    o.a().b(this.w);
  }

  protected void r()
  {
    if ((this.l > 0L) || (this.s > 0L))
    {
      a("messages.conversation_id=? AND status<>12 AND extra_flags & 4194304 = 0 AND messages.order_key>=?");
      super.r();
      return;
    }
    a("messages.conversation_id=? AND status<>12 AND extra_flags & 4194304 = 0 AND messages.order_key>=IFNULL((SELECT messages.order_key FROM [messages] WHERE messages.conversation_id=? AND status<>12 AND extra_flags & 4194304 = 0 AND messages.extra_mime <> 1007 ORDER BY messages.order_key DESC, messages.msg_date DESC LIMIT ?, 1), 0)");
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(this.t);
    arrayOfString[1] = String.valueOf(this.t);
    arrayOfString[2] = String.valueOf(this.r);
    b(arrayOfString);
  }

  public boolean s()
  {
    return this.x.get() != 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.k
 * JD-Core Version:    0.6.2
 */