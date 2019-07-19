package com.viber.voip.messages.controller.manager;

import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSecretChatReceivedEventAckMsg;
import com.viber.jni.im2.CSecretChatReceivedEventMsg;
import com.viber.jni.im2.CSecretChatReceivedEventMsg.Receiver;
import com.viber.jni.im2.CSecretChatSendEventMsg;
import com.viber.jni.im2.CSecretChatSendEventReplyMsg;
import com.viber.jni.im2.CSecretChatSendEventReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.h.a;
import com.viber.voip.messages.a.l.a;
import com.viber.voip.messages.a.l.b;
import com.viber.voip.messages.a.l.c;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.c.c;
import com.viber.voip.messages.j;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.settings.d.as;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class an
  implements ConnectionDelegate, CSecretChatReceivedEventMsg.Receiver, CSecretChatSendEventReplyMsg.Receiver
{
  private static final Logger a = ViberEnv.getLogger();
  private final bs b = new bs(ViberApplication.getApplication());
  private final ab c = ab.b();
  private final o d;

  public an()
  {
    a.b().register(this);
    this.d = o.a();
    this.d.a(new bv.d()
    {
      public void onConversationClosed(boolean paramAnonymousBoolean, long paramAnonymousLong)
      {
        if (paramAnonymousBoolean)
          an.a(an.this).L(paramAnonymousLong);
      }
    });
  }

  private Im2Exchanger a()
  {
    return ViberApplication.getInstance().getEngine(true).getExchanger();
  }

  private h a(CSecretChatReceivedEventMsg paramCSecretChatReceivedEventMsg)
  {
    ab localab = ab.b();
    if (paramCSecretChatReceivedEventMsg.groupID > 0L)
      return localab.b(paramCSecretChatReceivedEventMsg.groupID);
    return localab.a(paramCSecretChatReceivedEventMsg.mid, true);
  }

  private void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean)
  {
    int i;
    long l;
    if (paramLong1 > 0L)
    {
      i = 1;
      l = System.currentTimeMillis();
      if (!paramBoolean)
        break label70;
    }
    label70: for (int j = 16; ; j = 0)
    {
      MessageEntity localMessageEntity = c.a(paramInt, paramLong1, i, l, paramString1, j, paramLong2, paramString2, 0, 1000);
      localMessageEntity.addExtraFlag(27);
      this.b.a(localMessageEntity);
      return;
      i = 0;
      break;
    }
  }

  private void a(h paramh, CSecretChatReceivedEventMsg paramCSecretChatReceivedEventMsg)
  {
    if (this.b.c(paramh.getId(), paramCSecretChatReceivedEventMsg.timebombInSec) > 0)
      this.d.a(Collections.singleton(Long.valueOf(paramh.getId())), paramh.j(), false, false);
  }

  public static boolean a(boolean paramBoolean)
  {
    return (!paramBoolean) && (d.as.a.d());
  }

  private int b()
  {
    return ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence();
  }

  private boolean c()
  {
    return ViberApplication.getInstance().getEngine(true).getConnectionController().isConnected();
  }

  public void a(int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    CSecretChatSendEventMsg localCSecretChatSendEventMsg = new CSecretChatSendEventMsg(paramInt1, paramString, paramLong, (byte)paramInt3, paramInt2);
    if (c())
      a().handleCSecretChatSendEventMsg(localCSecretChatSendEventMsg);
  }

  public void onCSecretChatReceivedEventMsg(CSecretChatReceivedEventMsg paramCSecretChatReceivedEventMsg)
  {
    h localh = a(paramCSecretChatReceivedEventMsg);
    if (localh == null)
      return;
    switch (paramCSecretChatReceivedEventMsg.eventType)
    {
    default:
    case 1:
    case 0:
    case 2:
    }
    while (true)
    {
      a().handleCSecretChatReceivedEventAckMsg(new CSecretChatReceivedEventAckMsg(paramCSecretChatReceivedEventMsg.token, 0));
      return;
      a(0, paramCSecretChatReceivedEventMsg.groupID, paramCSecretChatReceivedEventMsg.mid, paramCSecretChatReceivedEventMsg.token, j.a(paramCSecretChatReceivedEventMsg.timebombInSec), false);
      a(localh, paramCSecretChatReceivedEventMsg);
      continue;
      a(0, paramCSecretChatReceivedEventMsg.groupID, paramCSecretChatReceivedEventMsg.mid, paramCSecretChatReceivedEventMsg.token, j.a(paramCSecretChatReceivedEventMsg.mid), false);
    }
  }

  public void onCSecretChatSendEventReplyMsg(CSecretChatSendEventReplyMsg paramCSecretChatSendEventReplyMsg)
  {
    if (paramCSecretChatSendEventReplyMsg.status == 1)
    {
      MessageEntity localMessageEntity = this.c.c(paramCSecretChatSendEventReplyMsg.seq);
      if (localMessageEntity != null)
      {
        localMessageEntity.setMessageToken(paramCSecretChatSendEventReplyMsg.token);
        this.c.b(localMessageEntity);
        this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      }
    }
  }

  public void onConnect()
  {
    Iterator localIterator = this.c.j().iterator();
    while (localIterator.hasNext())
    {
      MessageEntity localMessageEntity = (MessageEntity)localIterator.next();
      String[] arrayOfString = localMessageEntity.getBody().split("/");
      String str1 = arrayOfString[0];
      if (localMessageEntity.getGroupId() > 0L);
      for (String str2 = ""; ; str2 = localMessageEntity.getMemberId())
      {
        if (!"screenshot".equals(str1))
          break label101;
        a(localMessageEntity.getMessageSeq(), str2, localMessageEntity.getGroupId(), 0, 2);
        break;
      }
      label101: if ("timebomb".equals(str1))
      {
        int i = localMessageEntity.getMessageSeq();
        long l = localMessageEntity.getGroupId();
        int j = Integer.valueOf(arrayOfString[1]).intValue();
        a(i, str2, l, j, 1);
      }
    }
  }

  public void onConnectionStateChange(int paramInt)
  {
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onConversation1to1Started(l.a parama)
  {
    a(b(), parama.b, 0L, parama.c, 0);
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onConversationScreenShotTaken(l.b paramb)
  {
    int i = b();
    a(i, paramb.c, paramb.b, 0L, j.a(paramb.b), true);
    a(i, paramb.b, paramb.c, paramb.d, 2);
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onConversationTimeBombChanged(l.c paramc)
  {
    this.b.c(paramc.b, paramc.e);
    a(paramc.a, paramc.c, paramc.d, paramc.e, 1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.an
 * JD-Core Version:    0.6.2
 */