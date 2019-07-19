package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.Engine;
import com.viber.jni.LocationInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGroupMessageReceivedMsg;
import com.viber.jni.im2.CMessageReceivedAckMsg;
import com.viber.jni.im2.CMessageReceivedMsg;
import com.viber.jni.im2.CMessageReceivedMsg.Receiver;
import com.viber.jni.im2.CMessageReceivedReplyableAckMsg;
import com.viber.jni.im2.CPGMessageReceivedMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Location;
import com.viber.jni.im2.interfaces.IncomingGroupMessageReceiver;
import com.viber.jni.messenger.MessengerDelegate.MessagesReceiver;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.provider.messages.b.d;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.a.j;
import com.viber.voip.analytics.story.n;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.InviteCommunityInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.e;
import com.viber.voip.messages.a.c.i;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bn.a;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.cc;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.registration.ActivateSecondaryActivity;
import com.viber.voip.registration.af;
import com.viber.voip.util.ae;
import com.viber.voip.util.av;
import com.viber.voip.util.bp;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class u extends l
  implements CMessageReceivedMsg.Receiver, IncomingGroupMessageReceiver, MessengerDelegate.MessagesReceiver, ac.a, bn.a
{
  private static final Logger d = ViberEnv.getLogger();
  private static final com.viber.voip.e.a.c e = com.viber.voip.e.a.e.b();
  private com.viber.voip.messages.controller.ai f;
  private bn g;
  private dagger.a<bs> h;
  private final com.viber.voip.messages.controller.manager.o i;
  private final cc j;
  private ab k;
  private final EventBus l;
  private final com.viber.voip.analytics.story.e.c m;
  private final com.viber.voip.stickers.a.a n;
  private final com.viber.voip.messages.ui.ai o;
  private final dagger.a<com.viber.voip.util.e.e> p;
  private final com.viber.voip.util.e.f q;
  private boolean r;

  public u(Context paramContext, com.viber.voip.messages.controller.ai paramai, com.viber.voip.messages.controller.manager.o paramo, af paramaf, ab paramab, dagger.a<bs> parama, bn parambn, cc paramcc, EventBus paramEventBus, com.viber.voip.analytics.story.e.c paramc, com.viber.voip.stickers.a.a parama1, com.viber.voip.messages.ui.ai paramai1, dagger.a<com.viber.voip.util.e.e> parama2)
  {
    super(paramContext, paramaf);
    this.i = paramo;
    this.f = paramai;
    this.g = parambn;
    this.h = parama;
    this.k = paramab;
    this.j = paramcc;
    this.l = paramEventBus;
    this.m = paramc;
    this.n = parama1;
    this.o = paramai1;
    this.p = parama2;
    this.q = new com.viber.voip.util.e.f.a().b(false).c();
  }

  private bs.f a(MessageEntity paramMessageEntity, Member paramMember, int paramInt, String paramString)
  {
    int i1;
    int i2;
    label20: int i3;
    label37: boolean bool1;
    label64: bs.f localf;
    long l1;
    label108: String str;
    label120: InviteCommunityInfo localInviteCommunityInfo;
    if (!paramMessageEntity.isAggregatedMessage())
    {
      i1 = 1;
      if (paramMessageEntity.isSyncedMessage())
        break label216;
      i2 = 1;
      if ((!paramMessageEntity.isOneToOneType()) || (!paramMessageEntity.isInviteFromCommunity()))
        break label222;
      i3 = 1;
      bs localbs = (bs)this.h.get();
      if ((i2 == 0) || (i1 == 0))
        break label228;
      bool1 = true;
      localf = localbs.a(paramMessageEntity, null, paramMember, "", paramInt, bool1, paramString);
      if (i3 == 0)
        break label266;
      if (i1 != 0)
        a(localf);
      if (localf.g != null)
        break label234;
      l1 = 0L;
      if (localf.g != null)
        break label247;
      str = "";
      localInviteCommunityInfo = paramMessageEntity.getMessageInfo().getInviteCommunityInfo();
      if ((localf.f.ar()) || (localf.c) || (!localf.f.K()))
        break label260;
    }
    label260: for (boolean bool2 = true; ; bool2 = false)
    {
      this.l.post(new c.e(localInviteCommunityInfo.getInviteLink(), l1, str, localInviteCommunityInfo.getGroupId(), bool2));
      ((bs)this.h.get()).c();
      return localf;
      i1 = 0;
      break;
      label216: i2 = 0;
      break label20;
      label222: i3 = 0;
      break label37;
      label228: bool1 = false;
      break label64;
      label234: l1 = localf.g.i();
      break label108;
      label247: str = localf.g.a();
      break label120;
    }
    label266: if ((localf != null) && (localf.d))
    {
      if (i1 != 0)
        a(localf);
      this.l.post(new c.i(paramMessageEntity.getMessageSeq(), paramMessageEntity.getMessageToken(), paramMessageEntity.getMessageGlobalId()));
      return localf;
    }
    if ((localf != null) && (localf.e))
    {
      if (i1 != 0)
        a(localf);
      this.i.a(Collections.singleton(Long.valueOf(localf.f.getId())), paramMessageEntity.getConversationType(), false, false);
      this.g.a(localf.f, paramMember, paramMessageEntity.getMessageGlobalId(), paramMessageEntity.isYouWasMentionedInThisMessage());
      return localf;
    }
    if (i1 != 0)
    {
      if ((localf != null) && (localf.f != null) && (localf.f.J()))
        this.j.a();
      if ((com.viber.voip.messages.m.a(localf)) && (i2 != 0))
        a(localf);
      if ((localf.b) && ((paramMessageEntity.isIncoming()) || ((paramMessageEntity.isRichMessage()) && (paramMessageEntity.isOutgoing()))) && (!paramMessageEntity.isRead()) && (!paramMessageEntity.isSyncedMessage()) && ((!paramMessageEntity.isRoleFollower()) || (paramMessageEntity.isCommunityType())))
        this.g.a(localf.f, localf.g, localf.h, new v(this));
      if (localf.b)
      {
        a(paramMessageEntity, localf.f, localf.g, localf.c);
        if (!bk.a(paramMessageEntity, this.a))
          break label638;
        this.f.a(paramMessageEntity.getId(), paramMessageEntity.getDownloadId());
      }
    }
    while (true)
    {
      com.viber.voip.messages.m.a(localf.h, paramInt);
      if (((paramMessageEntity.isPublicAccount()) || (paramMessageEntity.isConvertedFromPublicAccountFormat())) && (paramMessageEntity.hasExtraFlagNeedFetchUrlByBody()))
        this.f.b(Collections.singletonList(paramMessageEntity));
      return localf;
      label638: a(paramMessageEntity);
    }
  }

  private void a(bs.f paramf)
  {
    int i1 = 1;
    int i2;
    boolean bool;
    int i3;
    label59: int i12;
    label102: int i6;
    int i7;
    if ((0x200 & paramf.h.getFlag()) == 0)
    {
      if ((paramf.g != null) && (paramf.g.i() > 0L))
        break label268;
      i2 = i1;
      bool = paramf.h.isInviteFromCommunity();
      if (!paramf.h.isGroupType())
        break label273;
      i3 = 0;
      if (!bool)
        break label285;
      if (i2 == 0)
        break label489;
      h localh = this.k.a(paramf.h.getMemberId(), false);
      if ((localh != null) && (localh.i(5)))
        break label279;
      i12 = i1;
      i6 = i12;
      i7 = 2;
    }
    while (true)
    {
      int i8;
      if ((paramf.h.isIncomingOneToOneBroadcast()) && (paramf.g != null) && (paramf.g.i() == 0L))
        i8 = 16;
      while (true)
      {
        label142: int i9;
        label173: int i10;
        label187: String str;
        if ((paramf.f != null) && (paramf.f.D()) && (paramf.f.aj()))
        {
          i9 = 6;
          if (i6 == 0)
            break label422;
          i10 = com.viber.voip.messages.m.m(paramf.h);
          str = com.viber.voip.messages.m.a(i10, i7);
          if ((!paramf.h.isIncoming()) || (paramf.f == null) || (!paramf.f.D()))
            break label428;
        }
        while (true)
        {
          if (i1 != 0)
            break label433;
          CMessageReceivedAckMsg localCMessageReceivedAckMsg = new CMessageReceivedAckMsg(paramf.h.getMessageToken(), i8, (short)0, CMessageReceivedAckMsg.translateClientStatus(i9), "", str);
          this.b.getExchanger().handleCMessageReceivedAckMsg(localCMessageReceivedAckMsg);
          return;
          label268: i2 = 0;
          break;
          label273: i3 = i1;
          break label59;
          label279: i12 = 0;
          break label102;
          label285: if ((!paramf.h.isGroupBehavior()) && (!paramf.h.isIncomingOneToOneBroadcast()) && (!paramf.h.isFromPublicAccount()) && (i2 != 0) && ((paramf.f == null) || (!paramf.f.i(5))));
          for (int i4 = i1; ; i4 = 0)
          {
            int i5 = i3;
            i6 = i4;
            i7 = i5;
            break;
          }
          if ((i6 != 0) && (bool))
          {
            i8 = 64;
            break label142;
          }
          if (i6 == 0)
            break label483;
          if (cd.c(paramf.h.getMemberId()));
          for (int i11 = 32; ; i11 = 4)
          {
            i8 = i11;
            break;
          }
          i9 = paramf.i;
          break label173;
          label422: i10 = 0;
          break label187;
          label428: i1 = 0;
        }
        label433: CMessageReceivedReplyableAckMsg localCMessageReceivedReplyableAckMsg = new CMessageReceivedReplyableAckMsg(this.b.getPhoneController().generateSequence(), paramf.h.getMessageToken(), i8, CMessageReceivedAckMsg.translateClientStatus(i9), "");
        this.b.getExchanger().handleCMessageReceivedReplyableAckMsg(localCMessageReceivedReplyableAckMsg);
        return;
        label483: i8 = 0;
      }
      label489: i7 = 2;
      i6 = 0;
    }
  }

  private void a(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isCommunityType()) && (paramMessageEntity.isMediaWithThumbnail()) && (bk.b(this.a)))
    {
      String str = paramMessageEntity.getBody();
      if (!da.a(str))
        ((com.viber.voip.util.e.e)this.p.get()).b(Uri.parse(str), this.q);
    }
  }

  private void a(MessageEntity paramMessageEntity, h paramh, com.viber.voip.model.entity.m paramm, boolean paramBoolean)
  {
    boolean bool1 = paramMessageEntity.isFromBackup();
    PublicAccountInfo localPublicAccountInfo = null;
    PublicAccountMsgInfo localPublicAccountMsgInfo = null;
    if (!bool1)
      if (!paramMessageEntity.isPublicAccount())
      {
        boolean bool4 = paramMessageEntity.isTextMessage();
        localPublicAccountInfo = null;
        localPublicAccountMsgInfo = null;
        if (!bool4);
      }
      else
      {
        localPublicAccountMsgInfo = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo();
        localPublicAccountInfo = localPublicAccountMsgInfo.getPublicAccountInfo();
      }
    if ((paramMessageEntity.isIncoming()) && (!paramMessageEntity.isRead()))
    {
      if (localPublicAccountInfo != null)
        this.m.a(paramMessageEntity.getMessageSeq(), localPublicAccountInfo.getUri(), localPublicAccountInfo.getPaName());
      if ((paramm != null) && (com.viber.voip.messages.m.a(paramMessageEntity.getConversationType(), paramm.a())))
      {
        bool3 = true;
        this.m.a(ae.b(), paramMessageEntity, paramh, bp.b(this.a), n.a(paramMessageEntity, this.o), paramBoolean, bool3);
      }
    }
    while ((!paramMessageEntity.isOutgoing()) || (paramMessageEntity.isInvisibleMessage()) || (localPublicAccountMsgInfo == null) || (localPublicAccountInfo == null))
      while (true)
      {
        return;
        boolean bool3 = false;
      }
    this.m.a(paramMessageEntity.getMessageSeq(), localPublicAccountInfo.getUri(), localPublicAccountInfo.getPaName());
    if (localPublicAccountMsgInfo.getStickerId() > 0L)
    {
      int i1 = (int)localPublicAccountMsgInfo.getStickerId();
      this.m.a(paramMessageEntity.getMessageSeq(), i1, com.viber.voip.stickers.c.g.f(i1), null, "Chat Extension", this.n.a(paramMessageEntity));
    }
    this.m.a(paramMessageEntity.getMessageSeq(), "Chat Extension");
    this.m.a(paramMessageEntity.getMessageSeq(), paramh);
    if ((paramm != null) && (com.viber.voip.messages.m.a(paramMessageEntity.getConversationType(), paramm.a())));
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.m.a(ae.b(), paramMessageEntity, bp.b(this.a), n.a(paramMessageEntity, this.o), bool2);
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.b());
      return;
    }
  }

  private void a(final List<bs.f> paramList)
  {
    av.e.f.a().post(new Runnable()
    {
      public void run()
      {
        u.a().a("RECEIVE MESSAGE", "send acks");
        int i = paramList.size();
        for (int j = 0; j < i; j++)
        {
          bs.f localf = (bs.f)paramList.get(j);
          if (com.viber.voip.messages.m.a(localf))
            u.a(u.this, localf);
        }
        u.a().b("RECEIVE MESSAGE", "send acks");
      }
    });
  }

  private void a(Map<String, Long> paramMap, MessageEntity paramMessageEntity)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Long localLong = (Long)paramMap.get(paramMessageEntity.getMemberId());
      if ((localLong != null) && (localLong.longValue() >= paramMessageEntity.getMessageToken()))
      {
        paramMessageEntity.setMimeType(1007);
        paramMessageEntity.setExtraFlags(paramMessageEntity.getExtraFlags() & av.a(0L, new int[] { 10, 3 }));
        paramMessageEntity.setRawMessageInfo("");
      }
    }
  }

  private void a(Set<Long> paramSet, Set<Integer> paramSet1)
  {
    Iterator localIterator = paramSet1.iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((Integer)localIterator.next()).intValue();
      this.k.d(i1);
      this.i.a(paramSet, i1, false, false);
    }
  }

  private void a(boolean paramBoolean, long paramLong1, String paramString1, long paramLong2, Member paramMember, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString2, int paramInt3, int paramInt4, long paramLong4, String paramString3, int paramInt5, int paramInt6)
  {
    e.a("RECEIVE MESSAGE", com.viber.voip.e.a.b.a(2, "receive"));
    int i1 = h.a(paramBoolean, paramInt3);
    if (paramBoolean);
    for (com.viber.voip.messages.controller.c.a locala = new com.viber.voip.messages.controller.c.a(paramLong1, paramMember.getId(), paramLong2, paramLong3, paramInt1, paramInt2, paramLocationInfo, i1, paramInt4, paramInt5); ; locala = new com.viber.voip.messages.controller.c.a(paramMember.getId(), paramLong2, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramInt4, paramInt5))
    {
      MessageEntity localMessageEntity = locala.a(2, null, null, paramString3, paramInt6);
      localMessageEntity.setDownloadId(paramString2);
      localMessageEntity.setDuration(paramLong4);
      a(localMessageEntity, paramMember, paramInt4, null);
      e.b("RECEIVE MESSAGE", com.viber.voip.e.a.b.a(2, "receive"));
      return;
    }
  }

  private boolean a(int paramInt1, long paramLong1, long paramLong2, Member paramMember, String paramString1, long paramLong3, int paramInt2, int paramInt3, LocationInfo paramLocationInfo, String paramString2, int paramInt4, int paramInt5, String paramString3, int paramInt6, int paramInt7, String paramString4)
  {
    e.a("RECEIVE MESSAGE", com.viber.voip.e.a.b.a(0, "receive"));
    int i1 = h.a(paramLong1, paramInt1);
    int i2;
    if (paramLong1 > 0L)
    {
      i2 = 1;
      if (i2 == 0)
        break label121;
    }
    label121: for (com.viber.voip.messages.controller.c.a locala = new com.viber.voip.messages.controller.c.a(paramLong1, paramMember.getId(), paramLong2, paramLong3, paramInt2, paramInt3, paramLocationInfo, i1, paramInt5, paramInt6); ; locala = new com.viber.voip.messages.controller.c.a(paramMember.getId(), paramLong2, paramLong3, paramInt2, paramInt3, paramLocationInfo, paramInt5, paramInt6))
    {
      a(locala.a(0, paramString1, paramInt4, paramString3, paramInt7), paramMember, paramInt5, paramString4);
      e.b("RECEIVE MESSAGE", com.viber.voip.e.a.b.a(0, "receive"));
      return false;
      i2 = 0;
      break;
    }
  }

  private boolean a(int paramInt1, long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt2, int paramInt3, LocationInfo paramLocationInfo, String paramString3, String paramString4, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    e.a("RECEIVE MESSAGE", com.viber.voip.e.a.b.a(7, "receive"));
    if ((com.viber.voip.publicaccount.d.a.a().e()) && (com.viber.voip.block.b.a(this.b, paramString3, paramLong2)))
      return false;
    int i1;
    MessageEntity localMessageEntity;
    label101: int i2;
    if (paramLong1 > 0L)
    {
      i1 = 1;
      if (i1 == 0)
        break label195;
      localMessageEntity = new com.viber.voip.messages.controller.c.a(paramLong1, paramString2, paramLong2, paramLong3, paramInt2, paramInt3, paramLocationInfo, h.a(paramLong1, paramInt1), paramInt5, paramInt6).a(7, paramString3, paramInt4, null, paramInt7);
      if ((paramInt2 & 0x10) == 0)
        break label235;
      i2 = 1;
      label112: if ((a(localMessageEntity, new Member(paramString2, paramString4), paramInt5, null).b) && (i2 != 0) && (j.b(localMessageEntity)))
      {
        if (i1 == 0)
          break label241;
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.c(com.viber.voip.analytics.a.f.a.i));
      }
    }
    while (true)
    {
      e.b("RECEIVE MESSAGE", com.viber.voip.e.a.b.a(7, "receive"));
      return false;
      i1 = 0;
      break;
      label195: localMessageEntity = new com.viber.voip.messages.controller.c.a(paramString2, paramLong2, paramLong3, paramInt2, paramInt3, paramLocationInfo, paramInt5, paramInt6).a(7, paramString3, paramInt4, null, paramInt7);
      break label101;
      label235: i2 = 0;
      break label112;
      label241: com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.a(com.viber.voip.analytics.a.f.a.i));
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.b(com.viber.voip.analytics.a.f.a.i));
    }
  }

  // ERROR //
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/viber/voip/messages/controller/b/u:k	Lcom/viber/voip/messages/controller/manager/ab;
    //   4: pop
    //   5: invokestatic 689	com/viber/voip/messages/controller/manager/ab:f	()Lcom/viber/provider/b;
    //   8: astore_2
    //   9: iconst_2
    //   10: anewarray 691	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 693
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: ldc_w 695
    //   24: aastore
    //   25: astore_3
    //   26: aload_2
    //   27: ldc_w 697
    //   30: aload_3
    //   31: ldc_w 699
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokeinterface 704 9 0
    //   44: astore 6
    //   46: aload 6
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +51 -> 103
    //   55: aload 5
    //   57: invokeinterface 709 1 0
    //   62: ifeq +41 -> 103
    //   65: aload_0
    //   66: getfield 78	com/viber/voip/messages/controller/b/u:k	Lcom/viber/voip/messages/controller/manager/ab;
    //   69: aload 5
    //   71: iconst_0
    //   72: invokeinterface 712 2 0
    //   77: i2l
    //   78: aload 5
    //   80: iconst_1
    //   81: invokeinterface 712 2 0
    //   86: invokevirtual 715	com/viber/voip/messages/controller/manager/ab:f	(JI)V
    //   89: aload 5
    //   91: invokeinterface 718 1 0
    //   96: istore 7
    //   98: iload 7
    //   100: ifne -35 -> 65
    //   103: aload 5
    //   105: invokestatic 723	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   108: return
    //   109: astore 4
    //   111: aconst_null
    //   112: astore 5
    //   114: aload 5
    //   116: invokestatic 723	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   119: aload 4
    //   121: athrow
    //   122: astore 4
    //   124: goto -10 -> 114
    //
    // Exception table:
    //   from	to	target	type
    //   26	46	109	finally
    //   55	65	122	finally
    //   65	98	122	finally
  }

  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    this.k.A(paramLong1);
    this.i.a(Collections.singleton(Long.valueOf(paramLong2)), paramInt, false, false);
    this.i.a(paramLong2, paramLong3, false);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      try
      {
        ab.f().a();
        this.r = true;
        d.c(this.a);
        ((bs)this.h.get()).a(new f(paramBoolean));
        return;
      }
      finally
      {
      }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.r));
    try
    {
      com.viber.provider.b localb = ab.f();
      if (paramBoolean1)
        d.a(this.a, false);
      b();
      if (paramBoolean1)
        localb.c();
      ((bs)this.h.get()).a(null);
      localb.b();
      this.r = false;
      this.k.d(0);
      Set localSet = this.k.i("conversation_type=0 OR conversation_type=1", null);
      this.i.a(localSet, 0, false, false);
      if (!paramBoolean2)
        this.j.a();
      return;
    }
    finally
    {
    }
  }

  boolean a(int paramInt1, long paramLong1, long paramLong2, Member paramMember, byte[] paramArrayOfByte, long paramLong3, int paramInt2, int paramInt3, LocationInfo paramLocationInfo, int paramInt4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9)
  {
    e.a("RECEIVE MESSAGE", com.viber.voip.e.a.b.a(paramInt4, "receive"));
    if ((13 == paramInt4) && (ViberApplication.isTablet(this.a)))
    {
      this.b.getExchanger().handleCMessageReceivedAckMsg(new CMessageReceivedAckMsg(paramLong2, 0, (short)0, 0, "", com.viber.voip.messages.m.a(0, 0)));
      return false;
    }
    int i1 = h.a(paramLong1, paramInt1);
    a(com.viber.voip.messages.f.a(this.a, paramLong1, paramLong2, paramMember.getId(), paramArrayOfByte, paramLong3, paramInt2, paramInt3, paramLocationInfo, paramInt4, paramString1, paramString2, paramMember.getPhoneNumber(), paramString4, paramInt5, paramInt6, i1, paramInt7, paramString5, false, paramInt8, paramInt9), paramMember, paramInt7, null);
    e.b("RECEIVE MESSAGE", com.viber.voip.e.a.b.a(paramInt4, "receive"));
    return false;
  }

  public boolean a(List<f.a> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList.isEmpty())
      return true;
    com.viber.voip.e.a.e.b().a("RECEIVE MESSAGE", "save messages after connect", "onMessagesAggregated");
    com.viber.voip.e.a.e.b().a("RECEIVE MESSAGE", "onMessagesAggregated");
    e.a("RECEIVE MESSAGE", "onMessagesAggregated: insert messages");
    LongSparseArray localLongSparseArray = new LongSparseArray(paramList.size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet(5);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    com.viber.provider.b localb1;
    int i1;
    long l1;
    int i2;
    int i4;
    Object localObject2;
    label176: f.a locala;
    Object localObject3;
    label234: Object localObject4;
    int i5;
    int i7;
    label250: int i8;
    Object localObject5;
    label449: int i9;
    int i11;
    label535: int i12;
    if (!paramBoolean1)
    {
      com.viber.provider.b localb2 = ab.f();
      localb2.a();
      ((bs)this.h.get()).a(new f(false));
      localb1 = localb2;
      i1 = 0;
      l1 = -1L;
      i2 = -1;
      try
      {
        int i3 = paramList.size();
        i4 = 0;
        localObject2 = null;
        if (i4 >= i3)
          break label643;
        locala = (f.a)paramList.get(i4);
        localArrayList2.clear();
        locala.a(localArrayList2);
        if (!com.viber.voip.messages.m.b(locala.i()))
          break label1279;
        localObject3 = this.k.Y(locala.c());
        localObject4 = null;
        i5 = 0;
        int i6 = localArrayList2.size();
        i7 = 0;
        if (i7 < i6)
        {
          MessageEntity localMessageEntity1 = (MessageEntity)localArrayList2.get(i7);
          Member localMember = locala.a(localMessageEntity1);
          a((Map)localObject3, localMessageEntity1);
          try
          {
            bs.f localf1 = a(localMessageEntity1, localMember, locala.e(), locala.a());
            if (paramBoolean1)
              break label1304;
            localArrayList1.add(localf1);
            if (!localf1.b)
              break label1304;
            if ((localMessageEntity1.isIncoming()) && (!localMessageEntity1.isRead()) && (!localMessageEntity1.isRoleFollower()) && (!localMessageEntity1.isSyncedMessage()))
              localLongSparseArray.put(localf1.f.getId(), localf1);
            if ((!localMessageEntity1.isSyncedMessage()) || (!com.viber.voip.messages.m.b(locala.i())) || (!localMessageEntity1.isDeletePinMessage()))
              break label1293;
            if (localObject4 == null)
              localObject4 = this.k.d(locala.c());
            if ((localObject4 == null) || (localMessageEntity1.getMessageGlobalId() <= ((r)localObject4).K()))
              break label1293;
            i8 = i5 + 1;
            localObject5 = localObject4;
            l1 = localf1.f.getId();
            i9 = localf1.f.j();
          }
          catch (IllegalStateException localIllegalStateException)
          {
            throw localIllegalStateException;
          }
        }
      }
      finally
      {
        if (!paramBoolean1)
        {
          ((bs)this.h.get()).a(null);
          localb1.b();
        }
      }
      if ((!paramBoolean1) && (l1 > 0L))
      {
        if (!com.viber.voip.messages.m.b(i2))
          break label1357;
        i11 = locala.j();
        i12 = i5 + i11;
        if (i12 <= 0)
          break label1363;
        i1 = 1;
        if (localObject4 != null)
          ((bs)this.h.get()).a((r)localObject4, i12);
      }
    }
    label643: label935: label1325: label1343: label1357: label1363: for (int i10 = i1; ; i10 = i1)
    {
      this.k.f(l1, i2);
      localHashSet1.add(Long.valueOf(l1));
      localHashSet2.add(Integer.valueOf(i2));
      break label1343;
      ((bs)this.h.get()).d(locala.c(), i12);
      continue;
      if (!paramBoolean1)
        localb1.c();
      if (!paramBoolean1)
      {
        ((bs)this.h.get()).a(null);
        localb1.b();
      }
      e.b("RECEIVE MESSAGE", "onMessagesAggregated: insert messages");
      if ((!paramBoolean1) && (paramBoolean2))
      {
        int i16 = localArrayList1.size();
        for (int i17 = 0; i17 < i16; i17++)
        {
          bs.f localf4 = (bs.f)localArrayList1.get(i17);
          if (localf4.b)
            a(localf4.h);
        }
        if (i1 != 0)
          a(localHashSet1, localHashSet2);
      }
      while (true)
      {
        com.viber.voip.e.a.e.b().b("RECEIVE MESSAGE", "onMessagesAggregated");
        com.viber.voip.e.a.e.b().b("RECEIVE MESSAGE", "save messages after connect");
        return true;
        if (!paramBoolean1)
        {
          ArrayList localArrayList3 = new ArrayList();
          e.a("RECEIVE MESSAGE", "onMessagesAggregated: postUpdate");
          int i13 = localArrayList1.size();
          int i14 = 0;
          if (i14 < i13)
          {
            bs.f localf3 = (bs.f)localArrayList1.get(i14);
            MessageEntity localMessageEntity2;
            if (localf3.b)
            {
              localMessageEntity2 = localf3.h;
              com.viber.voip.messages.m.a(localf3.h, localf3.f.l());
              if ((localf3.f.I()) || (!bk.a(localMessageEntity2, this.a)))
                break label997;
              this.f.a(localMessageEntity2.getId(), localMessageEntity2.getDownloadId());
              if ((localMessageEntity2.isPublicAccount()) && (localMessageEntity2.hasExtraFlagNeedFetchUrlByBody()))
                localArrayList3.add(localMessageEntity2);
              if (!localMessageEntity2.hasQuote())
                break label1006;
              if (com.viber.voip.messages.m.b(localMessageEntity2, this.k))
                this.k.b(localMessageEntity2);
            }
            while (true)
            {
              i14++;
              break;
              label997: a(localMessageEntity2);
              break label935;
              label1006: if ((localMessageEntity2.isPinMessage()) && (com.viber.voip.messages.m.a(localMessageEntity2, this.k)))
                this.k.b(localMessageEntity2);
            }
          }
          e.b("RECEIVE MESSAGE", "onMessagesAggregated: postUpdate");
          e.a("RECEIVE MESSAGE", "onMessagesAggregated notify changes");
          if (localHashSet1.size() > 0)
          {
            Set localSet = Collections.emptySet();
            Iterator localIterator = localHashSet1.iterator();
            while (localIterator.hasNext())
            {
              Long localLong = (Long)localIterator.next();
              this.i.a(localLong.longValue(), localSet);
            }
          }
          Boolean localBoolean = Boolean.valueOf(this.g.b());
          for (int i15 = 0; i15 < localLongSparseArray.size(); i15++)
          {
            bs.f localf2 = (bs.f)localLongSparseArray.get(localLongSparseArray.keyAt(i15));
            this.i.a(localf2.h, false);
            this.g.a(localf2.f, localf2.g, localf2.h, localBoolean, new w(this));
          }
          this.g.a();
          this.j.a();
          a(localHashSet1, localHashSet2);
          this.f.b(localArrayList3);
          e.b("RECEIVE MESSAGE", "onMessagesAggregated notify changes");
          a(localArrayList1);
        }
      }
      label1279: localObject3 = localObject2;
      break label234;
      i10 = i1;
      break label1343;
      i8 = i5;
      localObject5 = localObject4;
      break label449;
      i8 = i5;
      localObject5 = localObject4;
      i9 = i2;
      break label1325;
      localb1 = null;
      break;
      i7++;
      i2 = i9;
      localObject4 = localObject5;
      i5 = i8;
      break label250;
      i4++;
      localObject2 = localObject3;
      i1 = i10;
      break label176;
      i11 = 0;
      break label535;
    }
  }

  public void b(boolean paramBoolean)
  {
  }

  public void onCGroupMessageReceivedMsg(CGroupMessageReceivedMsg paramCGroupMessageReceivedMsg)
  {
    LocationInfo localLocationInfo = new LocationInfo(paramCGroupMessageReceivedMsg.location.latitude, paramCGroupMessageReceivedMsg.location.longitude);
    Member localMember = new Member(paramCGroupMessageReceivedMsg.originPhoneNumber, paramCGroupMessageReceivedMsg.clientName);
    switch (paramCGroupMessageReceivedMsg.mediaType.intValue())
    {
    default:
      a(paramCGroupMessageReceivedMsg.groupType.intValue(), paramCGroupMessageReceivedMsg.groupID, paramCGroupMessageReceivedMsg.messageToken, localMember, paramCGroupMessageReceivedMsg.thumbnail, paramCGroupMessageReceivedMsg.timeSent, paramCGroupMessageReceivedMsg.flags, 0, localLocationInfo, paramCGroupMessageReceivedMsg.mediaType.intValue(), paramCGroupMessageReceivedMsg.bucketName, paramCGroupMessageReceivedMsg.downloadID, paramCGroupMessageReceivedMsg.groupName, paramCGroupMessageReceivedMsg.text, paramCGroupMessageReceivedMsg.duration.intValue(), paramCGroupMessageReceivedMsg.seqInPG.intValue(), 0, paramCGroupMessageReceivedMsg.msgInfo, 0, paramCGroupMessageReceivedMsg.timebombInSec.intValue());
      return;
    case 7:
      a(paramCGroupMessageReceivedMsg.groupType.intValue(), paramCGroupMessageReceivedMsg.groupID, paramCGroupMessageReceivedMsg.groupName, paramCGroupMessageReceivedMsg.messageToken, paramCGroupMessageReceivedMsg.originPhoneNumber, paramCGroupMessageReceivedMsg.timeSent, paramCGroupMessageReceivedMsg.flags, 0, localLocationInfo, paramCGroupMessageReceivedMsg.msgInfo, paramCGroupMessageReceivedMsg.clientName, paramCGroupMessageReceivedMsg.seqInPG.intValue(), 0, 0, paramCGroupMessageReceivedMsg.timebombInSec.intValue());
      return;
    case 0:
    }
    a(paramCGroupMessageReceivedMsg.groupType.intValue(), paramCGroupMessageReceivedMsg.groupID, paramCGroupMessageReceivedMsg.messageToken, localMember, paramCGroupMessageReceivedMsg.text, paramCGroupMessageReceivedMsg.timeSent, paramCGroupMessageReceivedMsg.flags, 0, localLocationInfo, paramCGroupMessageReceivedMsg.groupName, paramCGroupMessageReceivedMsg.seqInPG.intValue(), 0, paramCGroupMessageReceivedMsg.msgInfo, 0, paramCGroupMessageReceivedMsg.timebombInSec.intValue(), null);
  }

  public void onCMessageReceivedMsg(CMessageReceivedMsg paramCMessageReceivedMsg)
  {
    int i1 = i.a(paramCMessageReceivedMsg.originPhoneNumber);
    Member localMember = new Member(paramCMessageReceivedMsg.originPhoneNumber, paramCMessageReceivedMsg.clientName, null, null, null, null, paramCMessageReceivedMsg.peerEMID);
    switch (paramCMessageReceivedMsg.mediaType.intValue())
    {
    default:
      a(0, 0L, paramCMessageReceivedMsg.messageToken, localMember, paramCMessageReceivedMsg.thumbnail, paramCMessageReceivedMsg.timeSent, paramCMessageReceivedMsg.flags, paramCMessageReceivedMsg.messageSeq.intValue(), paramCMessageReceivedMsg.location.toLegacyLocation(), paramCMessageReceivedMsg.mediaType.intValue(), paramCMessageReceivedMsg.bucketName, paramCMessageReceivedMsg.downloadID, null, paramCMessageReceivedMsg.text, paramCMessageReceivedMsg.duration.intValue(), 0, i1, paramCMessageReceivedMsg.msgInfo, paramCMessageReceivedMsg.chatType.intValue(), paramCMessageReceivedMsg.timebombInSec.intValue());
      return;
    case 7:
      a(0, 0L, null, paramCMessageReceivedMsg.messageToken, paramCMessageReceivedMsg.originPhoneNumber, paramCMessageReceivedMsg.timeSent, paramCMessageReceivedMsg.flags, paramCMessageReceivedMsg.messageSeq.intValue(), paramCMessageReceivedMsg.location.toLegacyLocation(), paramCMessageReceivedMsg.msgInfo, paramCMessageReceivedMsg.clientName, 0, i1, paramCMessageReceivedMsg.chatType.intValue(), paramCMessageReceivedMsg.timebombInSec.intValue());
      return;
    case 0:
    }
    if ((0x100 & paramCMessageReceivedMsg.flags) != 0)
    {
      i.b localb = new i.b(Long.parseLong(paramCMessageReceivedMsg.msgInfo));
      onSecondaryRegistered(paramCMessageReceivedMsg.messageToken, localb.c, localb.b, paramCMessageReceivedMsg.flags);
      return;
    }
    a(0, 0L, paramCMessageReceivedMsg.messageToken, localMember, paramCMessageReceivedMsg.text, paramCMessageReceivedMsg.timeSent, paramCMessageReceivedMsg.flags, paramCMessageReceivedMsg.messageSeq.intValue(), paramCMessageReceivedMsg.location.toLegacyLocation(), null, 0, i1, paramCMessageReceivedMsg.msgInfo, paramCMessageReceivedMsg.chatType.intValue(), paramCMessageReceivedMsg.timebombInSec.intValue(), paramCMessageReceivedMsg.toVLN);
  }

  public void onCPGMessageReceivedMsg(CPGMessageReceivedMsg paramCPGMessageReceivedMsg)
  {
    int i1 = paramCPGMessageReceivedMsg.flags;
    LocationInfo localLocationInfo = new LocationInfo(paramCPGMessageReceivedMsg.location.latitude, paramCPGMessageReceivedMsg.location.longitude);
    String str1;
    if (paramCPGMessageReceivedMsg.groupType.intValue() == 3)
      str1 = null;
    Member localMember;
    for (String str2 = paramCPGMessageReceivedMsg.encryptedPhoneNumber; ; str2 = null)
    {
      localMember = new Member(paramCPGMessageReceivedMsg.encryptedPhoneNumber, paramCPGMessageReceivedMsg.encryptedPhoneNumber, dx.a(paramCPGMessageReceivedMsg.senderDownloadID), paramCPGMessageReceivedMsg.clientName, null, str1, str2);
      if (com.viber.voip.messages.m.a(this.c, paramCPGMessageReceivedMsg.encryptedPhoneNumber))
        i1 = av.e(i1, 48);
      switch (paramCPGMessageReceivedMsg.mediaType)
      {
      default:
        int i4 = paramCPGMessageReceivedMsg.groupType.intValue();
        long l4 = paramCPGMessageReceivedMsg.groupID;
        long l5 = paramCPGMessageReceivedMsg.messageToken;
        byte[] arrayOfByte = paramCPGMessageReceivedMsg.thumbnail;
        long l6 = paramCPGMessageReceivedMsg.timeSent;
        int i5 = paramCPGMessageReceivedMsg.mediaType;
        String str6 = paramCPGMessageReceivedMsg.bucketName;
        String str7 = paramCPGMessageReceivedMsg.downloadID;
        String str8 = paramCPGMessageReceivedMsg.groupName;
        String str9 = paramCPGMessageReceivedMsg.text;
        int i6 = paramCPGMessageReceivedMsg.duration;
        int i7 = paramCPGMessageReceivedMsg.seqInPG;
        String str10 = paramCPGMessageReceivedMsg.msgInfo;
        a(i4, l4, l5, localMember, arrayOfByte, l6, i1, 0, localLocationInfo, i5, str6, str7, str8, str9, i6, i7, 0, str10, 0, 0);
        return;
        str1 = paramCPGMessageReceivedMsg.encryptedPhoneNumber;
      case 7:
      case 0:
      }
    }
    a(paramCPGMessageReceivedMsg.groupType.intValue(), paramCPGMessageReceivedMsg.groupID, paramCPGMessageReceivedMsg.groupName, paramCPGMessageReceivedMsg.messageToken, paramCPGMessageReceivedMsg.encryptedPhoneNumber, paramCPGMessageReceivedMsg.timeSent, i1, 0, localLocationInfo, paramCPGMessageReceivedMsg.msgInfo, paramCPGMessageReceivedMsg.clientName, paramCPGMessageReceivedMsg.seqInPG, 0, 0, 0);
    return;
    int i2 = paramCPGMessageReceivedMsg.groupType.intValue();
    long l1 = paramCPGMessageReceivedMsg.groupID;
    long l2 = paramCPGMessageReceivedMsg.messageToken;
    String str3 = paramCPGMessageReceivedMsg.text;
    long l3 = paramCPGMessageReceivedMsg.timeSent;
    String str4 = paramCPGMessageReceivedMsg.groupName;
    int i3 = paramCPGMessageReceivedMsg.seqInPG;
    String str5 = paramCPGMessageReceivedMsg.msgInfo;
    a(i2, l1, l2, localMember, str3, l3, i1, 0, localLocationInfo, str4, i3, 0, str5, 0, 0, null);
  }

  public boolean onFormattedMessageReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString3, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt3 > 0);
    for (int i1 = 1; ; i1 = 0)
      return a(i1, paramLong1, paramString1, paramLong2, paramString2, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString3, paramString4, paramInt3, paramInt4, paramInt5, paramInt6);
  }

  public boolean onMediaReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, EncryptionParams paramEncryptionParams, int paramInt6, int paramInt7)
  {
    if (paramInt4 > 0);
    for (int i1 = 1; ; i1 = 0)
    {
      a(i1, paramLong1, paramLong2, new Member(paramString2, paramString5), paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramInt3, paramString3, paramString4, paramString1, paramString6, 0, paramInt4, paramInt5, paramString7, paramInt6, paramInt7);
      return false;
    }
  }

  public boolean onPttReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString3, int paramInt3, String paramString4, int paramInt4, int paramInt5, String paramString5, int paramInt6, int paramInt7)
  {
    a(true, paramLong1, paramString1, paramLong2, new Member(paramString2, paramString4), paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString3, paramInt4, paramInt5, paramInt3, paramString5, paramInt6, paramInt7);
    return false;
  }

  public boolean onSecondaryRegistered(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Resources localResources = this.a.getResources();
    String str1 = String.valueOf(paramInt1);
    String str2 = com.viber.voip.registration.o.a(paramInt2, localResources);
    String str3 = localResources.getString(R.string.activate_secondary_your_code, new Object[] { str1, str2 });
    MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.a("Viber", paramLong, System.currentTimeMillis(), paramInt3, 0, null, 0, 0).a(0, str3, 0, null, 0);
    bs.f localf = ((bs)this.h.get()).a(localMessageEntity);
    if ((localf.a) || (localf.b))
      this.b.getPhoneController().handleSecondaryRegisteredAck(paramLong);
    if (localf.b)
    {
      Intent localIntent = new Intent(this.a, ActivateSecondaryActivity.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("code", str1);
      localIntent.putExtra("device_type", str2);
      this.a.startActivity(localIntent);
      this.f.b(new aa(localf.h));
    }
    return false;
  }

  public void onServiceStateChanged(int paramInt)
  {
    if (paramInt == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal())
    {
      com.viber.voip.e.a.e.b().d("RECEIVE MESSAGE", "save messages after connect");
      com.viber.voip.e.a.e.b().d("RECEIVE MESSAGE", "connect - first message receive");
      this.f.b();
    }
  }

  public boolean onTextReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5, int paramInt6)
  {
    if (paramInt3 > 0);
    for (int i1 = 1; ; i1 = 0)
    {
      a(i1, paramLong1, paramLong2, new Member(paramString2, paramString4), paramString3, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString1, paramInt3, paramInt4, paramString5, paramInt5, paramInt6, null);
      return false;
    }
  }

  public boolean onVideoReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, EncryptionParams paramEncryptionParams, int paramInt6, int paramInt7)
  {
    if (paramInt4 > 0);
    for (int i1 = 1; ; i1 = 0)
    {
      a(i1, paramLong1, paramLong2, new Member(paramString2, paramString6), paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, 3, paramString3, paramString4, paramString1, paramString5, paramInt3, paramInt4, paramInt5, paramString7, paramInt6, paramInt7);
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.u
 * JD-Core Version:    0.6.2
 */