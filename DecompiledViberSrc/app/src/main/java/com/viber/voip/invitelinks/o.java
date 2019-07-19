package com.viber.voip.invitelinks;

import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import com.viber.jni.GroupUserChanged;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.group.GroupControllerDelegate.GroupInfo;
import com.viber.jni.group.GroupInfoListener;
import com.viber.jni.im2.CAcceptGroupInviteMsg;
import com.viber.jni.im2.CAcceptGroupInviteReplyMsg;
import com.viber.jni.im2.CAcceptGroupInviteReplyMsg.Receiver;
import com.viber.jni.im2.CCreateGroupInviteMsg;
import com.viber.jni.im2.CCreateGroupInviteReplyMsg;
import com.viber.jni.im2.CCreateGroupInviteReplyMsg.Receiver;
import com.viber.jni.im2.CRevokeGroupInviteMsg;
import com.viber.jni.im2.CRevokeGroupInviteReplyMsg;
import com.viber.jni.im2.CRevokeGroupInviteReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.b.m.b;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.e;
import dagger.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class o extends b<a>
  implements GroupControllerDelegate.GroupInfo, CAcceptGroupInviteReplyMsg.Receiver, CCreateGroupInviteReplyMsg.Receiver, CRevokeGroupInviteReplyMsg.Receiver, n
{
  private final g j;
  private final LongSparseArray<b> k = new LongSparseArray();

  public o(PhoneController paramPhoneController, GroupController paramGroupController, Im2Exchanger paramIm2Exchanger, ab paramab, a<bs> parama, EventBus paramEventBus, Handler paramHandler, g paramg)
  {
    super(paramPhoneController, paramGroupController, paramIm2Exchanger, paramab, parama, paramEventBus, paramHandler);
    this.j = paramg;
  }

  private void a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 39	com/viber/voip/invitelinks/o$a
    //   4: dup
    //   5: lload_1
    //   6: aload_3
    //   7: iload 4
    //   9: aconst_null
    //   10: iconst_1
    //   11: iload 5
    //   13: iconst_1
    //   14: iadd
    //   15: invokespecial 42	com/viber/voip/invitelinks/o$a:<init>	(JLjava/lang/String;ZLjava/lang/String;II)V
    //   18: new 44	com/viber/voip/invitelinks/o$7
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 47	com/viber/voip/invitelinks/o$7:<init>	(Lcom/viber/voip/invitelinks/o;)V
    //   26: invokevirtual 50	com/viber/voip/invitelinks/o:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   29: return
  }

  private void a(n.a parama)
  {
    c().post(parama);
  }

  private void a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: new 64	com/viber/voip/invitelinks/o$5
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 65	com/viber/voip/invitelinks/o$5:<init>	(Lcom/viber/voip/invitelinks/o;)V
    //   10: invokevirtual 50	com/viber/voip/invitelinks/o:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   13: return
  }

  private void b(long paramLong)
  {
    a(new a(paramLong, null, false, 0));
  }

  private void b(long paramLong, int paramInt)
  {
    b localb = (b)this.k.get(paramLong);
    if (localb != null)
      localb.c = paramInt;
  }

  private void b(long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 39	com/viber/voip/invitelinks/o$a
    //   4: dup
    //   5: lload_1
    //   6: aload_3
    //   7: iconst_1
    //   8: iconst_2
    //   9: invokespecial 93	com/viber/voip/invitelinks/o$a:<init>	(JLjava/lang/String;ZI)V
    //   12: new 104	com/viber/voip/invitelinks/o$10
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 105	com/viber/voip/invitelinks/o$10:<init>	(Lcom/viber/voip/invitelinks/o;)V
    //   20: invokevirtual 50	com/viber/voip/invitelinks/o:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   23: return
  }

  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 39	com/viber/voip/invitelinks/o$a
    //   4: dup
    //   5: aload_1
    //   6: iconst_3
    //   7: invokespecial 108	com/viber/voip/invitelinks/o$a:<init>	(Ljava/lang/String;I)V
    //   10: new 110	com/viber/voip/invitelinks/o$2
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 111	com/viber/voip/invitelinks/o$2:<init>	(Lcom/viber/voip/invitelinks/o;)V
    //   18: invokevirtual 50	com/viber/voip/invitelinks/o:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   21: return
  }

  public void a(final long paramLong)
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        o.a(o.this, paramLong);
      }
    });
  }

  public void a(final long paramLong, String paramString)
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        o.a(o.this, paramLong, this.b);
      }
    });
  }

  public void a(GroupInfoListener paramGroupInfoListener, EventBus paramEventBus)
  {
    if (b())
    {
      paramGroupInfoListener.registerDelegate(this, this.i);
      this.f.registerDelegate(this, this.i);
      paramEventBus.register(this);
    }
  }

  public void a(final String paramString)
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        o.a(o.this, paramString);
      }
    });
  }

  public void onCAcceptGroupInviteReplyMsg(final CAcceptGroupInviteReplyMsg paramCAcceptGroupInviteReplyMsg)
  {
    a(paramCAcceptGroupInviteReplyMsg.seq, new b.g(paramCAcceptGroupInviteReplyMsg)
    {
      protected void a(o.a paramAnonymousa)
      {
      }

      protected void b(o.a paramAnonymousa)
      {
        switch (paramCAcceptGroupInviteReplyMsg.status)
        {
        default:
          o.a(o.this, new n.a(paramCAcceptGroupInviteReplyMsg.groupID, paramCAcceptGroupInviteReplyMsg.status, paramAnonymousa.b));
        case 0:
        case 4:
        }
        do
        {
          return;
          o.a(o.this).put(paramCAcceptGroupInviteReplyMsg.groupID, new o.b(paramAnonymousa.b, paramCAcceptGroupInviteReplyMsg.status));
          return;
        }
        while (o.a(o.this).get(paramCAcceptGroupInviteReplyMsg.groupID) != null);
        if (o.this.g.b(paramCAcceptGroupInviteReplyMsg.groupID) != null)
        {
          Boolean localBoolean = e.d(String.valueOf(paramCAcceptGroupInviteReplyMsg.groupID), "key_not_synced_group");
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            int j = o.this.d.generateSequence();
            o.a(o.this).put(paramCAcceptGroupInviteReplyMsg.groupID, new o.b(paramAnonymousa.b, paramCAcceptGroupInviteReplyMsg.status, j));
            o.this.e.a(j, paramCAcceptGroupInviteReplyMsg.groupID);
            return;
          }
          o.a(o.this, new n.a(paramCAcceptGroupInviteReplyMsg.groupID, paramCAcceptGroupInviteReplyMsg.status, paramAnonymousa.b));
          return;
        }
        int i = o.this.d.generateSequence();
        o.a(o.this).put(paramCAcceptGroupInviteReplyMsg.groupID, new o.b(paramAnonymousa.b, paramCAcceptGroupInviteReplyMsg.status, i));
        ((bs)o.this.h.get()).a(paramCAcceptGroupInviteReplyMsg.groupID, false, paramCAcceptGroupInviteReplyMsg.groupName, 1, null, System.currentTimeMillis(), true, false, false);
        o.this.e.a(i, paramCAcceptGroupInviteReplyMsg.groupID);
      }

      protected void c()
      {
      }
    });
  }

  public void onCCreateGroupInviteReplyMsg(final CCreateGroupInviteReplyMsg paramCCreateGroupInviteReplyMsg)
  {
    a(paramCCreateGroupInviteReplyMsg.seq, new b.d(paramCCreateGroupInviteReplyMsg)
    {
      protected void a(o.a paramAnonymousa)
      {
      }

      protected boolean a()
      {
        return paramCCreateGroupInviteReplyMsg.status == 6;
      }

      protected void b(o.a paramAnonymousa)
      {
        o.a(o.this, new o.a(paramAnonymousa.a, paramAnonymousa.e, paramAnonymousa.f, paramAnonymousa.b, 0, paramAnonymousa.d));
      }

      protected void c()
      {
      }

      protected void c(o.a paramAnonymousa)
      {
        o.this.c().post(new n.b(paramAnonymousa.a, paramAnonymousa.c, 1, paramCCreateGroupInviteReplyMsg.inviteLinkData, paramAnonymousa.f));
      }

      protected void d(o.a paramAnonymousa)
      {
        o.this.c().post(new n.b(paramAnonymousa.a, paramAnonymousa.c, paramCCreateGroupInviteReplyMsg.status, paramCCreateGroupInviteReplyMsg.inviteLinkData, paramAnonymousa.f));
      }
    });
  }

  public void onCRevokeGroupInviteReplyMsg(final CRevokeGroupInviteReplyMsg paramCRevokeGroupInviteReplyMsg)
  {
    a(paramCRevokeGroupInviteReplyMsg.seq, new b.f(paramCRevokeGroupInviteReplyMsg)
    {
      protected void a(o.a paramAnonymousa)
      {
        o.this.c().post(new n.b(paramAnonymousa.a, paramAnonymousa.c, paramCRevokeGroupInviteReplyMsg.status, null, paramAnonymousa.f));
      }

      protected void a(o.a paramAnonymousa, int paramAnonymousInt)
      {
        o.a(o.this, paramCRevokeGroupInviteReplyMsg.groupID, paramAnonymousa.e, paramAnonymousa.f, paramAnonymousInt);
      }

      protected boolean a()
      {
        return paramCRevokeGroupInviteReplyMsg.status == 0;
      }

      protected void c()
      {
      }
    });
  }

  public void onGroupInfo(int paramInt1, final long paramLong, String paramString1, String paramString2, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt2, int paramInt3, final int paramInt4, int paramInt5, final String paramString3)
  {
    b localb = (b)this.k.get(paramLong);
    if ((localb != null) && (localb.c == paramInt1))
    {
      if (this.g.b(paramLong) == null)
      {
        this.k.remove(paramLong);
        a(new n.a(paramLong, 1, localb.a));
      }
    }
    else
    {
      a(paramInt1, new b.e(paramInt4)
      {
        protected void a(o.a paramAnonymousa)
        {
        }

        protected boolean a()
        {
          return paramInt4 == 0;
        }

        protected String b()
        {
          return paramString3;
        }

        protected void b(o.a paramAnonymousa)
        {
          o.this.c().post(new n.b(paramLong, paramInt4, paramInt4, paramString3, paramAnonymousa.f));
        }

        protected void c()
        {
        }

        protected void c(o.a paramAnonymousa)
        {
          o.a(o.this, paramLong, this.f, false, paramAnonymousa.d);
        }

        protected void d(o.a paramAnonymousa)
        {
          o.this.c().post(new n.b(paramAnonymousa.a, paramInt4, paramInt4, paramString3, paramAnonymousa.f));
        }
      });
      return;
    }
    this.k.remove(paramLong);
    int i;
    switch (paramInt4)
    {
    case 1:
    default:
      i = 1;
    case 0:
    case 2:
    }
    while (true)
    {
      a(new n.a(paramLong, i, localb.a));
      break;
      i = localb.b;
      continue;
      i = 2;
    }
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onGroupInfoRequestedForAddedByLinkGroup(final m.b paramb)
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        o.a(o.this, paramb.a, paramb.b);
      }
    });
  }

  protected static class a extends b.b
  {
    protected final String e;
    protected final boolean f;

    protected a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
    {
      this(paramLong, paramString, paramBoolean, null, paramInt, 0);
    }

    protected a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt1, int paramInt2)
    {
      super(paramString2, paramInt1, paramInt2);
      this.e = paramString1;
      this.f = paramBoolean;
    }

    protected a(String paramString, int paramInt)
    {
      this(0L, null, false, paramString, paramInt, 0);
    }
  }

  private static class b
  {
    final String a;
    final int b;
    int c;

    b(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }

    b(String paramString, int paramInt1, int paramInt2)
    {
      this(paramString, paramInt1);
      this.c = paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.o
 * JD-Core Version:    0.6.2
 */