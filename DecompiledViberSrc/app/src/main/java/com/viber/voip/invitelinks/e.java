package com.viber.voip.invitelinks;

import android.os.Handler;
import com.viber.jni.PublicAccountInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CCheckGroup2InviteMsg;
import com.viber.jni.im2.CCheckGroup2InviteReplyMsg;
import com.viber.jni.im2.CCheckGroup2InviteReplyMsg.Receiver;
import com.viber.jni.im2.CCreateGroup2InviteMsg;
import com.viber.jni.im2.CCreateGroup2InviteReplyMsg;
import com.viber.jni.im2.CCreateGroup2InviteReplyMsg.Receiver;
import com.viber.jni.im2.CGetPublicAccountInfoMsg;
import com.viber.jni.im2.CGetPublicAccountInfoReplyMsg;
import com.viber.jni.im2.CGetPublicAccountInfoReplyMsg.Receiver;
import com.viber.jni.im2.CRevokeGroup2InviteMsg;
import com.viber.jni.im2.CRevokeGroup2InviteReplyMsg;
import com.viber.jni.im2.CRevokeGroup2InviteReplyMsg.Receiver;
import com.viber.jni.im2.CUpdateCommunitySettingsMsg;
import com.viber.jni.im2.CUpdateCommunitySettingsReplyMsg;
import com.viber.jni.im2.CUpdateCommunitySettingsReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountInfoReceiver;
import com.viber.jni.publicaccount.PublicAccountInfoReceiverListener;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.e;
import com.viber.voip.messages.controller.bs.e.a;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import java.util.Collections;
import org.greenrobot.eventbus.EventBus;

public class e extends b<a>
  implements CCheckGroup2InviteReplyMsg.Receiver, CCreateGroup2InviteReplyMsg.Receiver, CGetPublicAccountInfoReplyMsg.Receiver, CRevokeGroup2InviteReplyMsg.Receiver, CUpdateCommunitySettingsReplyMsg.Receiver, PublicAccountControllerDelegate.PublicAccountInfoReceiver, d
{
  private final o j;
  private final com.viber.voip.messages.controller.a k;

  public e(PhoneController paramPhoneController, GroupController paramGroupController, com.viber.voip.messages.controller.a parama, Im2Exchanger paramIm2Exchanger, ab paramab, dagger.a<bs> parama1, o paramo, EventBus paramEventBus, Handler paramHandler)
  {
    super(paramPhoneController, paramGroupController, paramIm2Exchanger, paramab, parama1, paramEventBus, paramHandler);
    this.k = parama;
    this.j = paramo;
  }

  private void a(int paramInt1, final int paramInt2, final long paramLong, int paramInt3, final String paramString)
  {
    a(paramInt1, new b.e(paramInt2)
    {
      protected void a(e.a paramAnonymousa)
      {
      }

      protected boolean a()
      {
        return paramInt2 == 0;
      }

      protected String b()
      {
        return paramString;
      }

      protected void b(e.a paramAnonymousa)
      {
        e.this.c().post(new d.c(paramAnonymousa.a, paramInt2, paramInt2, paramString, paramAnonymousa.e));
      }

      protected void c()
      {
      }

      protected void c(e.a paramAnonymousa)
      {
        if (cd.c(paramAnonymousa.f))
        {
          e.a(e.this, paramLong, this.f, paramAnonymousa.e, paramAnonymousa.d);
          return;
        }
        e.this.c().post(new d.c(paramAnonymousa.a, paramInt2, 0, paramString, paramAnonymousa.e));
      }

      protected void d(e.a paramAnonymousa)
      {
        e.this.c().post(new d.c(paramAnonymousa.a, paramInt2, paramInt2, paramString, paramAnonymousa.e));
      }
    });
  }

  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 46	com/viber/voip/invitelinks/e$a
    //   4: dup
    //   5: lload_1
    //   6: iload 4
    //   8: aconst_null
    //   9: iconst_1
    //   10: iload_3
    //   11: iload 5
    //   13: iconst_1
    //   14: iadd
    //   15: invokespecial 49	com/viber/voip/invitelinks/e$a:<init>	(JILjava/lang/String;III)V
    //   18: new 51	com/viber/voip/invitelinks/e$9
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 54	com/viber/voip/invitelinks/e$9:<init>	(Lcom/viber/voip/invitelinks/e;)V
    //   26: invokevirtual 57	com/viber/voip/invitelinks/e:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   29: return
  }

  private void a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: new 60	com/viber/voip/invitelinks/e$7
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 61	com/viber/voip/invitelinks/e$7:<init>	(Lcom/viber/voip/invitelinks/e;)V
    //   10: invokevirtual 57	com/viber/voip/invitelinks/e:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   13: return
  }

  private void b(long paramLong, byte paramByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 46	com/viber/voip/invitelinks/e$a
    //   4: dup
    //   5: lload_1
    //   6: iconst_4
    //   7: iload_3
    //   8: invokespecial 85	com/viber/voip/invitelinks/e$a:<init>	(JIB)V
    //   11: new 87	com/viber/voip/invitelinks/e$5
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 88	com/viber/voip/invitelinks/e$5:<init>	(Lcom/viber/voip/invitelinks/e;)V
    //   19: invokevirtual 57	com/viber/voip/invitelinks/e:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   22: return
  }

  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 46	com/viber/voip/invitelinks/e$a
    //   4: dup
    //   5: aload_1
    //   6: iconst_3
    //   7: invokespecial 94	com/viber/voip/invitelinks/e$a:<init>	(Ljava/lang/String;I)V
    //   10: new 96	com/viber/voip/invitelinks/e$2
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 97	com/viber/voip/invitelinks/e$2:<init>	(Lcom/viber/voip/invitelinks/e;)V
    //   18: invokevirtual 57	com/viber/voip/invitelinks/e:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   21: return
  }

  private void c(long paramLong, int paramInt)
  {
    a(new a(paramLong, 1, 0, paramInt));
  }

  private void d(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 46	com/viber/voip/invitelinks/e$a
    //   4: dup
    //   5: lload_1
    //   6: iconst_2
    //   7: iconst_2
    //   8: iload_3
    //   9: invokespecial 99	com/viber/voip/invitelinks/e$a:<init>	(JIII)V
    //   12: new 101	com/viber/voip/invitelinks/e$12
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 102	com/viber/voip/invitelinks/e$12:<init>	(Lcom/viber/voip/invitelinks/e;)V
    //   20: invokevirtual 57	com/viber/voip/invitelinks/e:a	(Lcom/viber/voip/invitelinks/b$b;Lcom/viber/voip/invitelinks/b$h;)V
    //   23: return
  }

  public void a(final long paramLong, byte paramByte)
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        e.a(e.this, paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, int paramInt)
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        e.a(e.this, paramLong, this.b);
      }
    });
  }

  public void a(PublicAccountInfoReceiverListener paramPublicAccountInfoReceiverListener)
  {
    if (b())
    {
      paramPublicAccountInfoReceiverListener.registerDelegate(this, this.i);
      this.f.registerDelegate(this, this.i);
    }
  }

  public void a(final String paramString)
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        e.a(e.this, paramString);
      }
    });
  }

  public void b(final long paramLong, int paramInt)
  {
    this.i.post(new Runnable()
    {
      public void run()
      {
        e.b(e.this, paramLong, this.b);
      }
    });
  }

  public void onCCheckGroup2InviteReplyMsg(final CCheckGroup2InviteReplyMsg paramCCheckGroup2InviteReplyMsg)
  {
    a(paramCCheckGroup2InviteReplyMsg.seq, new b.g(paramCCheckGroup2InviteReplyMsg)
    {
      protected void a(e.a paramAnonymousa)
      {
      }

      protected void b(e.a paramAnonymousa)
      {
        if (((paramCCheckGroup2InviteReplyMsg.status == 6) || (paramCCheckGroup2InviteReplyMsg.status == 5)) && (e.this.g.b(paramCCheckGroup2InviteReplyMsg.groupID) == null))
          if (paramCCheckGroup2InviteReplyMsg.status != 6)
            break label346;
        label346: for (int i = 3; ; i = 1)
        {
          PublicAccount localPublicAccount = new PublicAccount();
          localPublicAccount.setGroupID(paramCCheckGroup2InviteReplyMsg.groupID);
          localPublicAccount.setName(paramCCheckGroup2InviteReplyMsg.groupName);
          localPublicAccount.setGroupRole(i);
          localPublicAccount.setTagLines(paramCCheckGroup2InviteReplyMsg.tagLine);
          localPublicAccount.setGlobalPermissions(paramCCheckGroup2InviteReplyMsg.communityPrivileges.longValue());
          if (!da.a(paramCCheckGroup2InviteReplyMsg.iconDownloadID))
            localPublicAccount.setIcon(dx.g(paramCCheckGroup2InviteReplyMsg.iconDownloadID));
          bs.e locale = bs.e.a().a(true).a();
          bs.f localf = ((bs)e.this.h.get()).a(e.this.d.generateSequence(), paramCCheckGroup2InviteReplyMsg.groupID, 5, localPublicAccount, locale);
          if (paramCCheckGroup2InviteReplyMsg.status == 5)
            e.a(e.this).a();
          long l = localf.f.getId();
          if (l > 0L)
          {
            e.this.g.b(l, 3, true);
            e.b(e.this).a(Collections.singleton(Long.valueOf(l)), 5, false, false);
          }
          e.this.c().post(new d.b(paramCCheckGroup2InviteReplyMsg.groupID, paramCCheckGroup2InviteReplyMsg.groupName, paramCCheckGroup2InviteReplyMsg.iconDownloadID, paramCCheckGroup2InviteReplyMsg.tagLine, paramCCheckGroup2InviteReplyMsg.inviteToken, paramCCheckGroup2InviteReplyMsg.status, paramCCheckGroup2InviteReplyMsg.groupFlags.intValue(), paramAnonymousa.b));
          return;
        }
      }

      protected void c()
      {
      }
    });
  }

  public void onCCreateGroup2InviteReplyMsg(final CCreateGroup2InviteReplyMsg paramCCreateGroup2InviteReplyMsg)
  {
    a(paramCCreateGroup2InviteReplyMsg.seq, new b.d(paramCCreateGroup2InviteReplyMsg)
    {
      protected void a(e.a paramAnonymousa)
      {
      }

      protected boolean a()
      {
        return paramCCreateGroup2InviteReplyMsg.status == 6;
      }

      protected void b(e.a paramAnonymousa)
      {
        e.a(e.this, new e.a(paramAnonymousa.a, paramAnonymousa.e, paramAnonymousa.b, 0, paramAnonymousa.f, paramAnonymousa.d));
      }

      protected void c()
      {
      }

      protected void c(e.a paramAnonymousa)
      {
        e.this.c().post(new d.c(paramAnonymousa.a, paramAnonymousa.c, 1, paramCCreateGroup2InviteReplyMsg.inviteLink, paramAnonymousa.e));
      }

      protected void d(e.a paramAnonymousa)
      {
        e.this.c().post(new d.c(paramAnonymousa.a, paramAnonymousa.c, paramCCreateGroup2InviteReplyMsg.status, paramCCreateGroup2InviteReplyMsg.inviteLink, paramAnonymousa.e));
      }
    });
  }

  public void onCGetPublicAccountInfoReplyMsg(CGetPublicAccountInfoReplyMsg paramCGetPublicAccountInfoReplyMsg)
  {
    a(paramCGetPublicAccountInfoReplyMsg.seq, paramCGetPublicAccountInfoReplyMsg.status, paramCGetPublicAccountInfoReplyMsg.publicChatId, paramCGetPublicAccountInfoReplyMsg.userRole, paramCGetPublicAccountInfoReplyMsg.invitationLink);
  }

  public void onCRevokeGroup2InviteReplyMsg(final CRevokeGroup2InviteReplyMsg paramCRevokeGroup2InviteReplyMsg)
  {
    a(paramCRevokeGroup2InviteReplyMsg.seq, new b.f(paramCRevokeGroup2InviteReplyMsg)
    {
      protected void a(e.a paramAnonymousa)
      {
        e.this.c().post(new d.c(paramAnonymousa.a, paramAnonymousa.c, paramCRevokeGroup2InviteReplyMsg.status, null, paramAnonymousa.e));
      }

      protected void a(e.a paramAnonymousa, int paramAnonymousInt)
      {
        e.a(e.this, paramCRevokeGroup2InviteReplyMsg.groupID, paramAnonymousa.f, paramAnonymousa.e, paramAnonymousInt);
      }

      protected boolean a()
      {
        return paramCRevokeGroup2InviteReplyMsg.status == 0;
      }

      protected void c()
      {
      }
    });
  }

  public void onCUpdateCommunitySettingsReplyMsg(final CUpdateCommunitySettingsReplyMsg paramCUpdateCommunitySettingsReplyMsg)
  {
    a(paramCUpdateCommunitySettingsReplyMsg.seq, new b.g(paramCUpdateCommunitySettingsReplyMsg)
    {
      protected void a(e.a paramAnonymousa)
      {
      }

      protected void b(e.a paramAnonymousa)
      {
        r localr;
        if (paramCUpdateCommunitySettingsReplyMsg.status == 0)
        {
          localr = e.this.g.d(paramAnonymousa.a);
          if (localr != null)
            if (1 != paramAnonymousa.g)
              break label161;
        }
        label161: for (boolean bool = true; ; bool = false)
        {
          e.this.g.a(localr.getTable(), localr.getId(), "pg_extra_flags", Integer.valueOf(av.a(localr.A(), 1, bool)));
          h localh = e.this.g.b(paramAnonymousa.a);
          if (localh != null)
            e.b(e.this).a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), true, false);
          e.this.c().post(new d.a(paramAnonymousa.a, paramAnonymousa.g, paramCUpdateCommunitySettingsReplyMsg.invitationLink, paramCUpdateCommunitySettingsReplyMsg.status));
          return;
        }
      }

      protected void c()
      {
      }
    });
  }

  public void onPublicAccountInfo(int paramInt1, int paramInt2, PublicAccountInfo paramPublicAccountInfo)
  {
    a(paramInt2, paramInt1, paramPublicAccountInfo.getPublicChatId(), paramPublicAccountInfo.getUserRole(), paramPublicAccountInfo.getInvitationLink());
  }

  protected static class a extends b.b
  {
    protected final int e;
    protected final int f;
    protected final byte g;

    protected a(long paramLong, int paramInt, byte paramByte)
    {
      this(paramLong, paramInt, null, paramInt, 3, 0, paramByte);
    }

    protected a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramLong, paramInt1, null, paramInt2, paramInt3, 0, (byte)0);
    }

    protected a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramLong, paramInt1, paramString, paramInt2, paramInt3, paramInt4, (byte)0);
    }

    protected a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, byte paramByte)
    {
      super(paramString, paramInt2, paramInt4);
      this.e = paramInt1;
      this.f = paramInt3;
      this.g = paramByte;
    }

    protected a(String paramString, int paramInt)
    {
      this(0L, paramInt, paramString, paramInt, 3, 0, (byte)0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.e
 * JD-Core Version:    0.6.2
 */