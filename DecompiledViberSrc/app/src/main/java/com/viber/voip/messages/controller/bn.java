package com.viber.voip.messages.controller;

import android.app.KeyguardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.MessageEntity.a;
import com.viber.voip.notif.e.n;
import com.viber.voip.notif.e.s;
import com.viber.voip.notif.f;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.settings.d.ag;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.util.ViberActionRunner.ap;
import com.viber.voip.util.ap;
import com.viber.voip.util.cd;
import com.viber.voip.util.dv;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.util.upload.b.a;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class bn
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final KeyguardManager c;
  private PowerManager.WakeLock d;
  private dagger.a<ab> e;
  private dagger.a<com.viber.voip.notif.g> f;
  private com.viber.voip.c.g g;
  private final com.viber.voip.app.b h;
  private com.viber.voip.messages.controller.manager.k i;
  private final Handler j = av.e.g.a();
  private final Handler k = av.e.i.a();
  private final Runnable l = new bo(this);
  private final Runnable m = bp.a;

  @Inject
  bn(Context paramContext, KeyguardManager paramKeyguardManager, dagger.a<ab> parama, dagger.a<com.viber.voip.notif.g> parama1, com.viber.voip.app.b paramb)
  {
    this.b = paramContext;
    this.c = paramKeyguardManager;
    this.e = parama;
    this.f = parama1;
    this.h = paramb;
    this.g = ViberApplication.getInstance().getHandledCloudMessagesHolder();
  }

  private b a(com.viber.voip.model.entity.h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (g().c(paramh.getId()))
      return new b(true, false, false);
    if (paramBoolean1)
      return new b(false, false, false);
    if (paramh.y())
      return null;
    ab localab = (ab)this.e.get();
    int n = localab.q(paramh.getId());
    if (n <= 2)
      n += localab.i(paramh.getId());
    if ((n == 1) || ((n == 0) && (paramBoolean3)) || ((paramBoolean2) && (paramh.w() != 0L) && (300000L + paramh.w() < System.currentTimeMillis())));
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      if (paramh.w() > 0L)
      {
        paramh.c(0L);
        localab.a(paramh.getTable(), paramh.getId(), "smart_event_date", "0");
      }
      return new b(false, false, true);
    }
    if ((paramBoolean2) && (paramh.w() != 0L) && (300000L + paramh.w() > System.currentTimeMillis()))
      return new b(false, true, false);
    if ((paramBoolean2) && (paramh.w() == 0L))
    {
      paramh.c(System.currentTimeMillis());
      localab.a(paramh.getTable(), paramh.getId(), "smart_event_date", Long.valueOf(System.currentTimeMillis()));
    }
    return new b(false, false, false);
  }

  private void a(MessageEntity paramMessageEntity, com.viber.voip.model.entity.h paramh, boolean paramBoolean, Boolean paramBoolean1)
  {
    if ((!paramBoolean) && (!paramh.I()) && (!paramh.R()) && (!paramh.e()) && (!paramMessageEntity.isSilentMessage()) && (!paramMessageEntity.isCall()) && (!paramMessageEntity.isNotification()) && (!paramMessageEntity.isInvisibleMessage()))
    {
      bool = true;
      if (bool)
        if (paramBoolean1 != null)
          break label92;
    }
    label92: for (boolean bool = b(); ; bool = paramBoolean1.booleanValue())
    {
      if (bool)
        ViberActionRunner.ap.a(this.b, paramh);
      return;
      bool = false;
      break;
    }
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((d.ag.d.d()) && (!paramBoolean2))
      c();
    if (paramBoolean1)
    {
      this.j.removeCallbacks(this.l);
      this.j.postDelayed(this.l, 200L);
    }
  }

  private void b(MessageEntity paramMessageEntity, a parama)
  {
    String str = paramMessageEntity.getCustomIncomingMessageSound();
    File localFile = dv.z.b(this.b, str, false);
    if (localFile.exists())
      if (c(paramMessageEntity))
        ViberApplication.getInstance().getRingtonePlayer().playCustomTone(Uri.fromFile(localFile));
    while (true)
    {
      return;
      if (ViberApplication.getInstance().getDownloadValve().c(str))
      {
        com.viber.common.d.i locali = com.viber.common.d.i.a();
        com.viber.voip.util.upload.b localb = new com.viber.voip.util.upload.b(str, localFile.getPath(), localFile.getPath() + ".tmp", 60000L);
        try
        {
          localb.f();
          ViberApplication.getInstance().getDownloadValve().d(str);
          parama.a(paramMessageEntity.getId(), paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken(), paramMessageEntity.getConversationType());
          ((com.viber.voip.notif.g)this.f.get()).d().a();
          if ((locali.e() < 60000L) && (localFile.exists()) && (c(paramMessageEntity)))
          {
            n = 1;
            if (n == 0)
              continue;
            ViberApplication.getInstance().getRingtonePlayer().playCustomTone(Uri.fromFile(localFile));
          }
        }
        catch (b.a locala)
        {
          while (true)
          {
            ViberApplication.getInstance().getDownloadValve().a(str, localb.i());
            continue;
            int n = 0;
          }
        }
      }
    }
    parama.a(paramMessageEntity.getId(), paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken(), paramMessageEntity.getConversationType());
    ((com.viber.voip.notif.g)this.f.get()).d().a();
  }

  private boolean c(MessageEntity paramMessageEntity)
  {
    return (paramMessageEntity != null) && (!paramMessageEntity.isSilentMessage()) && (!paramMessageEntity.isCall()) && (!com.viber.voip.stickers.b.e().a()) && (!d(paramMessageEntity)) && (((f)ViberApplication.getInstance().getNotificationManagerWrapper().get()).b()) && (com.viber.voip.notif.c.a.b((f)ViberApplication.getInstance().getNotificationManagerWrapper().get()));
  }

  private boolean d(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity != null) && (paramMessageEntity.isSticker()))
    {
      int n = paramMessageEntity.getObjectId().toStickerId();
      if (com.viber.voip.stickers.i.a().u(n).hasSound())
        return true;
    }
    return false;
  }

  private com.viber.voip.messages.controller.manager.k g()
  {
    if (this.i == null)
      this.i = ViberApplication.getInstance().getMessagesManager().a();
    return this.i;
  }

  private PowerManager.WakeLock h()
  {
    if (this.d == null)
    {
      PowerManager localPowerManager = (PowerManager)this.b.getSystemService("power");
      if (localPowerManager != null)
      {
        this.d = localPowerManager.newWakeLock(805306394, bn.class.getSimpleName());
        this.d.setReferenceCounted(false);
      }
    }
    return this.d;
  }

  private boolean i()
  {
    boolean bool = this.c.inKeyguardRestrictedInputMode();
    if (g().g() != -1L);
    for (int n = 1; (n != 0) && (!bool); n = 0)
      return true;
    return false;
  }

  public void a()
  {
    if (this.g.a())
      ((com.viber.voip.notif.g)this.f.get()).a().g();
  }

  public void a(com.viber.voip.model.entity.h paramh, Member paramMember, int paramInt, boolean paramBoolean)
  {
    b localb = a(paramh, paramBoolean, paramh.ac(), false);
    com.viber.voip.notif.g localg = (com.viber.voip.notif.g)this.f.get();
    if ((localb == null) || (localg.k()) || (paramh.J()));
    while (true)
    {
      return;
      if (!b.a(localb))
      {
        if (!paramh.g())
          break label110;
        if (!paramBoolean)
          break label99;
        localg.g().a(paramh, paramMember, paramInt);
      }
      while (!b.b(localb))
      {
        a(b.a(localb), false);
        return;
        label99: localg.g().a();
        continue;
        label110: localg.d().a();
      }
    }
  }

  public void a(com.viber.voip.model.entity.h paramh, MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity == null);
    b localb;
    do
    {
      do
      {
        return;
        localb = a(paramh, paramMessageEntity.isYouWasMentionedInThisMessage(), paramh.ac(), false);
      }
      while ((localb == null) || (((com.viber.voip.notif.g)this.f.get()).k()));
      if (!b.a(localb))
        ((com.viber.voip.notif.g)this.f.get()).e().a();
    }
    while (b.b(localb));
    if (!i());
    for (boolean bool = true; ; bool = false)
    {
      a(bool, false);
      return;
    }
  }

  public void a(com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity)
  {
    a(paramh, paramm, paramMessageEntity, null, null);
  }

  public void a(com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity, a parama)
  {
    a(paramh, paramm, paramMessageEntity, null, parama);
  }

  public void a(com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity, Boolean paramBoolean, a parama)
  {
    boolean bool1 = true;
    if (this.h.a(this.b))
      ViberApplication.getInstance().getMessagesManager().c().d().a(paramh, paramm, paramMessageEntity);
    boolean bool2;
    b localb;
    com.viber.voip.notif.g localg;
    if ((paramh.ac()) && (!paramMessageEntity.isNotification()) && (!paramMessageEntity.isCall()) && (!paramMessageEntity.isYouWasMentionedInThisMessage()))
    {
      bool2 = bool1;
      localb = a(paramh, paramMessageEntity.isYouWasMentionedInThisMessage(), bool2, paramMessageEntity.isAggregatedMessage());
      localg = (com.viber.voip.notif.g)this.f.get();
      if ((localb != null) && (!localg.k()) && (!paramh.J()))
        break label129;
    }
    label129: label312: 
    while (true)
    {
      return;
      bool2 = false;
      break;
      if ((!paramMessageEntity.isSilentMessage()) || (!paramMessageEntity.isSystemMessage()))
      {
        if (!b.a(localb))
        {
          if ((!paramMessageEntity.isNotification()) && (!paramMessageEntity.isYouWasMentionedInThisMessage()) && (paramMessageEntity.isCommunityType()))
            localg.g().a();
        }
        else if (!b.b(localb))
          switch (1.a[paramMessageEntity.getMessageSoundOptions().ordinal()])
          {
          case 2:
          default:
          case 1:
          case 3:
          }
        while (true)
        {
          if (com.viber.common.d.a.o())
            break label312;
          a(paramMessageEntity, paramh, bool2, paramBoolean);
          return;
          localg.d().a();
          break;
          if ((b.a(localb)) && (c(paramMessageEntity)));
          while (true)
          {
            a(bool1, paramMessageEntity.isSilentMessage());
            break;
            bool1 = false;
          }
          if (parama != null)
            this.k.post(new bq(this, paramMessageEntity, parama));
        }
      }
    }
  }

  public boolean a(MessageEntity paramMessageEntity)
  {
    MessageEntity.a locala1 = paramMessageEntity.getMessageSoundOptions();
    MessageEntity.a locala2 = MessageEntity.a.c;
    boolean bool1 = false;
    if (locala1 == locala2)
    {
      boolean bool2 = dv.z.b(this.b, paramMessageEntity.getCustomIncomingMessageSound(), false).exists();
      bool1 = false;
      if (!bool2)
        bool1 = true;
    }
    return bool1;
  }

  public void b(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isGroupBehavior())
      l.g().d();
    label49: label101: label107: label113: 
    while (true)
    {
      return;
      com.viber.voip.model.entity.m localm = com.viber.voip.messages.d.c.c().c(paramMessageEntity.getMemberId(), 1);
      String str1;
      String str2;
      if (localm != null)
      {
        str1 = localm.getContactName();
        if (!TextUtils.isEmpty(str1))
          break label101;
        str2 = "";
        if (localm == null)
          break label107;
      }
      for (String str3 = localm.getNumber(); ; str3 = "")
      {
        if (cd.c(str3))
          break label113;
        l.a(str3).b(-1, new Object[] { str3, str2 }).d();
        return;
        str1 = "";
        break;
        str2 = str1;
        break label49;
      }
    }
  }

  public boolean b()
  {
    ViberApplication localViberApplication = ViberApplication.getInstance();
    com.viber.voip.notif.h localh = localViberApplication.getUpdateViberManager();
    boolean bool2;
    if ((localh.c()) || (localh.d()) || (localViberApplication.isOnForeground()))
    {
      boolean bool1 = this.c.inKeyguardRestrictedInputMode();
      bool2 = false;
      if (!bool1);
    }
    else
    {
      boolean bool3 = localViberApplication.getEngine(false).isGSMCallActive();
      bool2 = false;
      if (!bool3)
      {
        CallInfo localCallInfo = localViberApplication.getEngine(false).getCurrentCall();
        bool2 = false;
        if (localCallInfo == null)
        {
          boolean bool4 = d.ag.a.d();
          bool2 = false;
          if (bool4)
            bool2 = true;
        }
      }
    }
    return bool2;
  }

  public void c()
  {
    PowerManager.WakeLock localWakeLock = h();
    if (localWakeLock != null)
      localWakeLock.acquire(10000L);
  }

  public void d()
  {
    this.j.removeCallbacks(this.m);
    this.j.postDelayed(this.m, 200L);
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  }

  private class b
  {
    private final boolean b;
    private final boolean c;
    private final boolean d;

    b(boolean paramBoolean1, boolean paramBoolean2, boolean arg4)
    {
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      boolean bool;
      this.d = bool;
    }

    public String toString()
    {
      return "SmartEventInfo{skipNotification=" + this.b + ", updateOnlyNotification=" + this.c + ", restartSmart=" + this.d + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.bn
 * JD-Core Version:    0.6.2
 */