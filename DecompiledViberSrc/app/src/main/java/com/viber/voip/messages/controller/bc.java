package com.viber.voip.messages.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PublicGroupChangeEvent;
import com.viber.jni.PublicGroupMessage;
import com.viber.jni.cdr.CdrController;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.jni.im2.CLikeGroupMessage;
import com.viber.jni.im2.CSendActionOnPGMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.publicgroup.PublicGroupControllerDelegate.PublicGroupGetMessages;
import com.viber.jni.publicgroup.PublicGroupGetMessagesListener;
import com.viber.jni.secure.SecureMessagesController;
import com.viber.liblinkparser.LinkParser;
import com.viber.liblinkparser.LinkParser.Preview;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.b.a;
import com.viber.voip.flatbuffers.model.msginfo.AudioPttInfo;
import com.viber.voip.flatbuffers.model.msginfo.ExtendedInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Poll;
import com.viber.voip.flatbuffers.model.msginfo.PollUiOptions;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.d.b;
import com.viber.voip.messages.a.j.b;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.af.a;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.az.a;
import com.viber.voip.messages.controller.manager.y;
import com.viber.voip.messages.controller.manager.y.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.FormattedUrlMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.messages.orm.entity.json.TextMessage;
import com.viber.voip.messages.orm.entity.json.TextMessage.MutableTextMessageWrapper;
import com.viber.voip.model.a.d.a;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.l;
import com.viber.voip.model.entity.r;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.settings.d.as;
import com.viber.voip.sound.ptt.PttUtils;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.sound.tones.SampleTone;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.av;
import com.viber.voip.util.aw;
import com.viber.voip.util.bg.a;
import com.viber.voip.util.bu;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.util.upload.s;
import com.viber.voip.util.upload.s.d;
import com.viber.voip.util.upload.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

public class bc
  implements ai
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.analytics.g A;
  private final SparseArrayCompat<Long> B = new SparseArrayCompat();
  private DialerControllerDelegate.DialerPhoneState C = new DialerControllerDelegate.DialerPhoneState()
  {
    public void onPhoneStateChanged(int paramAnonymousInt)
    {
      CallInfo localCallInfo;
      if (paramAnonymousInt == 3)
      {
        localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
        if (localCallInfo == null)
          break label118;
      }
      label118: for (CallerInfo localCallerInfo = localCallInfo.getCallerInfo(); ; localCallerInfo = null)
      {
        if ((localCallerInfo != null) && (!localCallInfo.isConference()) && (!localCallInfo.isViberIn()))
        {
          String str1 = localCallerInfo.getMemberId();
          String str2 = localCallerInfo.getPhoneNumber();
          h localh = ((bs)bc.d(bc.this).get()).a(0, new Member(str1, str2), 0L, true);
          bc.f(bc.this).a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), false, true);
        }
        return;
      }
    }
  };
  private Context b;
  private boolean c;
  private com.viber.voip.messages.controller.manager.o d;
  private dagger.a<bs> e;
  private bk f;
  private ab g;
  private com.viber.voip.registration.af h;
  private ak i;
  private al j;
  private u k;
  private EventBus l;
  private Handler m;
  private Handler n;
  private Handler o;
  private final com.viber.voip.util.e.f p;
  private com.viber.voip.util.e.h.a q;
  private final com.viber.voip.messages.controller.manager.k r;
  private final cd s;
  private final ICdrController t;
  private final Engine u;
  private final dagger.a<com.google.d.f> v;
  private final com.viber.voip.analytics.story.e.c w;
  private final com.viber.voip.analytics.story.a.a x;
  private final com.viber.voip.analytics.story.g.a y;
  private final dagger.a<com.viber.voip.model.a.d> z;

  public bc(Context paramContext, EventBus paramEventBus, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, com.viber.voip.messages.controller.manager.o paramo, ab paramab, dagger.a<bs> parama, com.viber.voip.messages.controller.manager.k paramk, cd paramcd, dagger.a<com.viber.voip.contacts.c.d.g> parama1, com.viber.voip.registration.af paramaf, ICdrController paramICdrController, Engine paramEngine, dagger.a<com.google.d.f> parama2, com.viber.voip.analytics.story.e.c paramc, com.viber.voip.analytics.story.a.a parama3, com.viber.voip.analytics.story.g.a parama4, dagger.a<com.viber.voip.model.a.d> parama5, com.viber.voip.analytics.g paramg)
  {
    this.b = paramContext;
    this.c = ViberApplication.isTablet(paramContext);
    this.d = paramo;
    this.l = paramEventBus;
    this.m = paramHandler1;
    this.n = paramHandler3;
    this.o = paramHandler2;
    this.e = parama;
    this.g = paramab;
    this.h = paramaf;
    this.t = paramICdrController;
    this.u = paramEngine;
    this.v = parama2;
    this.w = paramc;
    this.x = parama3;
    this.y = parama4;
    this.z = parama5;
    this.A = paramg;
    this.f = new bk(paramContext, paramHandler1, paramo, paramab);
    this.j = al.a();
    this.i = ak.a();
    this.p = new f.a().f(true).b(false).c();
    if (this.c)
    {
      this.k = new u(this.m, this.g, this.d, parama1);
      paramEngine.getDelegatesManager().getDialerPhoneStateListener().registerDelegate(this.C, this.m);
    }
    this.r = paramk;
    this.s = paramcd;
    this.d.a(new bv.o()
    {
      public void a()
      {
        bc.this.a(bc.a(bc.this).i("conversations.flags & 32768<>0", null), 0);
      }

      public void a(String paramAnonymousString)
      {
      }
    });
    this.d.a(new bv.d()
    {
      public void onOpenConversation(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        if (bc.b(bc.this))
          bc.c(bc.this).a(paramAnonymousConversationItemLoaderEntity);
        if ((!paramAnonymousConversationItemLoaderEntity.isPublicGroupBehavior()) && (!paramAnonymousConversationItemLoaderEntity.isOneToOneWithPublicAccount()))
          bc.a(bc.this, paramAnonymousConversationItemLoaderEntity);
        if ((!paramAnonymousConversationItemLoaderEntity.isSeenConversation()) && (!paramAnonymousConversationItemLoaderEntity.isPublicGroupBehavior()))
          ((bs)bc.d(bc.this).get()).b(paramAnonymousConversationItemLoaderEntity.getId(), 23, true);
        if (paramAnonymousConversationItemLoaderEntity.isCommunityType())
          bc.b(bc.this, paramAnonymousConversationItemLoaderEntity);
        if (paramAnonymousConversationItemLoaderEntity.isMarkedAsUnreadConversation())
          bc.this.a(paramAnonymousConversationItemLoaderEntity.getId(), paramAnonymousConversationItemLoaderEntity.getConversationType(), false);
      }
    });
    this.u.getDelegatesManager().getConnectionListener().registerDelegate(new ConnectionDelegate()
    {
      public void onConnect()
      {
        bc.e(bc.this);
      }

      public void onConnectionStateChange(int paramAnonymousInt)
      {
      }
    }
    , this.m);
  }

  private MessageEntity a(com.viber.voip.messages.controller.c.b paramb, MessageEntity paramMessageEntity, Bundle paramBundle)
  {
    int i1 = 1;
    com.viber.voip.util.e.j.a(this.b, paramMessageEntity.getMediaUri());
    MessageEntity localMessageEntity = paramb.a(paramMessageEntity);
    if (!localMessageEntity.isLocationMessage())
    {
      localMessageEntity.setLat(0);
      localMessageEntity.setLng(0);
    }
    if ((paramMessageEntity.isPublicAccount()) && (!TextUtils.isEmpty(paramMessageEntity.getPublicAccountMediaUrl())))
    {
      localMessageEntity.setMimeType(0);
      localMessageEntity.setBody(paramMessageEntity.getPublicAccountMediaUrl());
      MsgInfo localMsgInfo2 = paramMessageEntity.getMessageInfo();
      if ((paramMessageEntity.isImage()) && (TextUtils.isEmpty(localMsgInfo2.getThumbnailUrl())))
      {
        localMsgInfo2.setThumbnailContentType(localMsgInfo2.getContentType());
        localMsgInfo2.setThumbnailUrl(localMsgInfo2.getUrl());
      }
      if ((!TextUtils.isEmpty(localMsgInfo2.getThumbnailUrl())) && (localMsgInfo2.getContentLength() <= 0L))
        localMsgInfo2.setContentLength(FormattedUrlMessage.THUMB_SIZE_FORCE_PUT_TO_JSON);
      if (com.viber.voip.messages.m.a(localMessageEntity, paramMessageEntity.getMessageInfo()))
        localMessageEntity.setMimeType(8);
    }
    localMessageEntity.removeExtraFlag(9);
    localMessageEntity.removeExtraFlag(7);
    localMessageEntity.setBroadcastMessageId(0L);
    localMessageEntity.addExtraFlag(6);
    int i2;
    label225: int i3;
    label267: label301: MsgInfo localMsgInfo1;
    if (paramMessageEntity.isCommunityType())
    {
      localMessageEntity.addExtraFlag(40);
      if ((!paramMessageEntity.isPublicGroupBehavior()) && (!paramMessageEntity.isPgForwardedMessage()))
        break label472;
      i2 = i1;
      if (!localMessageEntity.isPublicGroupBehavior())
        break label521;
      if (localMessageEntity.hasManagedMedia())
      {
        if (i2 == 0)
          break label478;
        localMessageEntity.addExtraFlag(7);
        localMessageEntity.setFlag(0x4000 | localMessageEntity.getFlag());
      }
      if ((!paramMessageEntity.usesVideoConverter()) && (!localMessageEntity.isNeedVideoConvert()))
        localMessageEntity.addExtraFlag(15);
      if (localMessageEntity.getMessageInfoIfParsed() == null)
        break label560;
      i3 = i1;
      localMsgInfo1 = localMessageEntity.getMessageInfo();
      if (!localMessageEntity.hasQuote())
        break label813;
      localMsgInfo1.setQuote(null);
      localMessageEntity.setRawQuotedMessageData(null);
    }
    label521: label804: label813: for (int i4 = i1; ; i4 = i3)
    {
      if ((localMessageEntity.isFormattedMessage()) && (localMessageEntity.isUrlMessage()))
      {
        FormattedMessage localFormattedMessage = localMessageEntity.loadFormattedMessage();
        if (localFormattedMessage != null);
        for (List localList = localFormattedMessage.getMessage(); ; localList = Collections.emptyList())
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            BaseMessage localBaseMessage = (BaseMessage)localIterator.next();
            if (localBaseMessage.getType() == MessageType.TEXT)
            {
              TextMessage localTextMessage = (TextMessage)localBaseMessage;
              String str3 = localTextMessage.getSpans();
              if ((localTextMessage.shouldConsiderMentions()) && (!TextUtils.isEmpty(str3)) && (!"no_sp".equals(str3)))
                localTextMessage.mutate().setSpans(null);
            }
          }
          localMessageEntity.removeExtraFlag(40);
          break;
          label472: i2 = 0;
          break label225;
          label478: if ((localMessageEntity.isVideo()) && (!localMessageEntity.isWinkVideo()) && (localMessageEntity.getMediaUri() != null))
          {
            localMessageEntity.setExtraStatus(8);
            break label267;
          }
          localMessageEntity.setExtraStatus(2);
          break label267;
          if (i2 != 0)
          {
            localMessageEntity.addExtraFlag(7);
            localMessageEntity.setFlag(0x4000 | localMessageEntity.getFlag());
            break label267;
          }
          localMessageEntity.setExtraStatus(9);
          break label267;
          label560: i3 = 0;
          break label301;
        }
      }
      if (localMessageEntity.getMessageInfo().getTextMetaInfo() != null)
      {
        localMessageEntity.getMessageInfo().setTextMetaInfo(null);
        localMessageEntity.setSpans(null);
        MessageEntity[] arrayOfMessageEntity = new MessageEntity[i1];
        arrayOfMessageEntity[0] = localMessageEntity;
        com.viber.voip.messages.m.a(11, arrayOfMessageEntity);
        i4 = i1;
      }
      if (localMessageEntity.getMessageInfo().getEdit() != null)
      {
        localMessageEntity.getMessageInfo().setEdit(null);
        i4 = i1;
      }
      GroupReferralInfo localGroupReferralInfo = b(paramMessageEntity, paramBundle);
      int i5 = 0;
      Object localObject = null;
      String str2;
      if (localGroupReferralInfo != null)
      {
        if ((i4 != 0) || (!paramMessageEntity.isRichMessage()))
          break label769;
        String str1 = paramMessageEntity.getRawMessageInfo();
        StringBuilder localStringBuilder = new StringBuilder(str1);
        if (!com.viber.voip.util.bk.a(str1, localStringBuilder, "groupReferralInfo", ((com.google.d.f)this.v.get()).b(localGroupReferralInfo)))
          break label804;
        str2 = localStringBuilder.toString();
      }
      while (true)
      {
        localObject = str2;
        i5 = i1;
        if (i4 != 0)
          localMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo1));
        while (i5 == 0)
        {
          return localMessageEntity;
          localMsgInfo1.setGroupReferralInfo(localGroupReferralInfo);
          i4 = i1;
          i5 = 0;
          localObject = null;
          break;
        }
        localMessageEntity.setRawMessageInfo(localObject);
        return localMessageEntity;
        str2 = null;
        i1 = 0;
      }
    }
  }

  private void a(int paramInt, long paramLong)
  {
    synchronized (this.B)
    {
      this.B.put(paramInt, Long.valueOf(paramLong));
      return;
    }
  }

  private void a(LongSparseArray<String> paramLongSparseArray)
  {
    if (!com.viber.voip.util.u.a(paramLongSparseArray))
    {
      PhoneController localPhoneController = this.u.getPhoneController();
      int i1 = paramLongSparseArray.size();
      for (int i2 = 0; i2 < i1; i2++)
      {
        int i3 = localPhoneController.generateSequence();
        long l1 = paramLongSparseArray.keyAt(i2);
        a(i3, l1);
        localPhoneController.handleDeleteMessage((String)paramLongSparseArray.valueAt(i2), l1, i3, 0);
      }
    }
  }

  private void a(final Pin paramPin, long paramLong, final com.viber.voip.messages.controller.c.b paramb, MessageEntity paramMessageEntity, final ExtendedInfo paramExtendedInfo)
  {
    final Engine localEngine = ViberApplication.getInstance().getEngine(true);
    r localr = this.g.d(paramMessageEntity.getGroupId());
    int i1 = com.viber.voip.messages.conversation.publicaccount.a.a.b(paramPin.getSeqInPG(), Math.max(localr.n(), localr.v()));
    final int i2 = localEngine.getPhoneController().generateSequence();
    localEngine.getDelegatesManager().getPublicGroupGetMessagesListener().registerDelegate(new PublicGroupControllerDelegate.PublicGroupGetMessages()
    {
      public void onGetPublicGroupMessages(int paramAnonymousInt1, long paramAnonymousLong, PublicGroupMessage[] paramAnonymousArrayOfPublicGroupMessage, PublicGroupChangeEvent[] paramAnonymousArrayOfPublicGroupChangeEvent, int paramAnonymousInt2)
      {
        if (paramAnonymousInt1 != i2);
        while (true)
        {
          return;
          localEngine.getDelegatesManager().getPublicGroupGetMessagesListener().removeDelegate(this);
          int i = paramAnonymousArrayOfPublicGroupMessage.length;
          for (int j = 0; j < i; j++)
          {
            PublicGroupMessage localPublicGroupMessage = paramAnonymousArrayOfPublicGroupMessage[j];
            if (localPublicGroupMessage.getMessageToken() == paramPin.getToken())
            {
              paramExtendedInfo.setDownloadId(localPublicGroupMessage.getDownloadId());
              bc.this.a(paramb.a(paramPin), null);
              return;
            }
          }
        }
      }
    }
    , this.m);
    ViberApplication.getInstance().getMessagesManager().d().a(i2, paramLong, i1, false);
  }

  private void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    MessageEntity localMessageEntity = this.g.s(paramConversationItemLoaderEntity.getId());
    String str;
    if (localMessageEntity != null)
    {
      str = String.valueOf(localMessageEntity.getMessageToken());
      this.t.handleCommunityView(paramConversationItemLoaderEntity.getGroupId(), str, CdrController.getCdrRole(paramConversationItemLoaderEntity.getGroupRole()));
      if (!(paramConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity))
        break label153;
    }
    label153: for (PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = (PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity; ; localPublicGroupConversationItemLoaderEntity = null)
    {
      if (localPublicGroupConversationItemLoaderEntity != null);
      for (long l1 = localPublicGroupConversationItemLoaderEntity.getWatchersCountRefDate(); ; l1 = 0L)
      {
        if (ae.a(System.currentTimeMillis(), l1))
        {
          com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.a.b(paramConversationItemLoaderEntity.getGroupName(), String.valueOf(paramConversationItemLoaderEntity.getGroupId())));
          if (localPublicGroupConversationItemLoaderEntity != null)
            this.g.a("public_accounts", localPublicGroupConversationItemLoaderEntity.getPublicAccounRowId(), "watchers_count_ref_date", Long.valueOf(System.currentTimeMillis()));
        }
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.b());
        return;
        str = null;
        break;
      }
    }
  }

  private void a(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isToSend()) && (paramMessageEntity.getMessageSeq() <= 0))
      paramMessageEntity.setMessageSeq(this.u.getPhoneController().generateSequence());
  }

  private void a(MessageEntity paramMessageEntity, h paramh, Bundle paramBundle)
  {
    if (paramBundle == null);
    int i2;
    do
    {
      do
      {
        return;
        this.w.a(paramMessageEntity.getMessageSeq(), com.viber.voip.analytics.story.n.b(paramBundle));
        this.w.a(paramMessageEntity.getMessageSeq(), paramh);
        int i1 = com.viber.voip.analytics.story.n.g(paramBundle);
        if (i1 > 0)
          this.w.a(paramMessageEntity.getMessageSeq(), i1);
        if (paramMessageEntity.isImage())
          this.w.a(paramMessageEntity.getMessageSeq(), com.viber.voip.analytics.story.n.h(paramBundle), com.viber.voip.analytics.story.n.a(paramBundle));
      }
      while (!paramMessageEntity.isSticker());
      i2 = com.viber.voip.analytics.story.n.c(paramBundle);
    }
    while (i2 <= 0);
    this.w.a(paramMessageEntity.getMessageSeq(), i2, com.viber.voip.stickers.c.g.f(i2), com.viber.voip.analytics.story.n.d(paramBundle), com.viber.voip.analytics.story.n.e(paramBundle), com.viber.voip.analytics.story.n.f(paramBundle));
  }

  private void a(final MessageEntity paramMessageEntity, String paramString)
  {
    com.viber.voip.util.upload.a local6 = new com.viber.voip.util.upload.a()
    {
      public void a(long paramAnonymousLong)
      {
      }

      public void a(Uri paramAnonymousUri)
      {
        MessageEntity localMessageEntity = bc.a(bc.this).l(paramMessageEntity.getId());
        if ((localMessageEntity != null) && (!localMessageEntity.isDeleted()) && (1008 != localMessageEntity.getMimeType()))
        {
          localMessageEntity.setExtraStatus(3);
          bc.a(bc.this, localMessageEntity);
          bc.f(bc.this).a(localMessageEntity, 0);
        }
      }

      public void a(Uri paramAnonymousUri, s.d paramAnonymousd)
      {
        MessageEntity localMessageEntity = bc.a(bc.this).l(paramMessageEntity.getId());
        int i;
        if (localMessageEntity != null)
        {
          i = 2;
          if (paramAnonymousd != s.d.b)
            break label63;
          localMessageEntity.setExtraStatus(11);
          i = 1;
        }
        while (true)
        {
          bc.a(bc.this, localMessageEntity);
          bc.f(bc.this).a(localMessageEntity, i);
          return;
          label63: localMessageEntity.setExtraStatus(4);
          localMessageEntity.setStatus(-1);
        }
      }
    };
    if (paramMessageEntity.getMessageInfo() != null)
      s.a(paramMessageEntity.getMessageInfo().getThumbnailUrl(), paramString, paramMessageEntity.getId(), local6);
  }

  private void a(Set<Long> paramSet, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.g.d(paramInt);
    Integer[] arrayOfInteger = new Integer[3];
    arrayOfInteger[0] = Integer.valueOf(1);
    arrayOfInteger[1] = Integer.valueOf(2);
    arrayOfInteger[2] = Integer.valueOf(4);
    List localList1 = Arrays.asList(arrayOfInteger);
    List localList2 = this.g.a(paramSet, localList1);
    ((bs)this.e.get()).a(localList2);
    if (paramBoolean3)
    {
      localList2.addAll(this.g.a(paramSet, Collections.singleton(Integer.valueOf(3))));
      Iterator localIterator = localList2.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (localh.g())
          this.l.post(new d.b(localh.k(), paramBoolean1, paramBoolean2));
      }
    }
  }

  private void a(Set<Long> paramSet, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.g.a(paramSet, paramBoolean1);
    if ((paramBoolean2) && (com.viber.voip.messages.m.b(paramInt)))
      a(paramSet, paramInt, paramBoolean1, false, paramBoolean3);
    this.d.a(paramSet, paramInt, false, false);
  }

  @Deprecated
  private void a(bs.f[] paramArrayOff, MessageEntity[] paramArrayOfMessageEntity)
  {
    com.viber.voip.analytics.story.n.a(paramArrayOff);
    com.viber.voip.analytics.a.j.a(paramArrayOfMessageEntity);
  }

  private GroupReferralInfo b(MessageEntity paramMessageEntity, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      GroupReferralForwardInfo localGroupReferralForwardInfo = (GroupReferralForwardInfo)paramBundle.getParcelable("group_referral_extra_info");
      if ((localGroupReferralForwardInfo != null) && (localGroupReferralForwardInfo.getGroupId() == paramMessageEntity.getGroupId()) && (paramMessageEntity.getMessageInfo().getGroupReferralInfo() == null))
      {
        GroupReferralInfo localGroupReferralInfo = new GroupReferralInfo();
        localGroupReferralInfo.setGroupId(localGroupReferralForwardInfo.getGroupId());
        localGroupReferralInfo.setGroupName(localGroupReferralForwardInfo.getGroupName());
        localGroupReferralInfo.setInviteLink(localGroupReferralForwardInfo.getInviteLink());
        localGroupReferralInfo.setMessageId(paramMessageEntity.getMessageGlobalId());
        localGroupReferralInfo.setMessageToken(paramMessageEntity.getMessageToken());
        return localGroupReferralInfo;
      }
    }
    return null;
  }

  private void b(bs.f paramf)
  {
    com.viber.voip.analytics.a.j.a(paramf.h);
    com.viber.voip.analytics.story.n.a(paramf);
  }

  private void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((!d.as.a.d()) && (!paramConversationItemLoaderEntity.isSecure()));
    boolean bool;
    do
    {
      SecureMessagesController localSecureMessagesController;
      String str;
      do
      {
        return;
        localSecureMessagesController = ViberApplication.getInstance().getEngine(true).getSecureMessagesController();
        switch (paramConversationItemLoaderEntity.getConversationType())
        {
        default:
          return;
        case 0:
          str = paramConversationItemLoaderEntity.getParticipantMemberId();
        case 1:
        }
      }
      while (str == null);
      localSecureMessagesController.handleGetSecureSessionInfo(str);
      return;
      bool = localSecureMessagesController.isGroupSecure(paramConversationItemLoaderEntity.getGroupId());
    }
    while (paramConversationItemLoaderEntity.isSecure() == bool);
    ((bs)this.e.get()).b(paramConversationItemLoaderEntity.getId(), 14, bool);
  }

  private void b(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isBroadcastList());
    List localList2;
    do
    {
      do
      {
        ArrayList localArrayList;
        do
        {
          return;
          List localList1 = this.j.c(paramMessageEntity.getConversationId());
          localArrayList = new ArrayList(localList1.size());
          Iterator localIterator1 = localList1.iterator();
          while (localIterator1.hasNext())
            localArrayList.add(String.valueOf(((l)localIterator1.next()).a()));
        }
        while (localArrayList.isEmpty());
        localList2 = this.i.b(localArrayList);
      }
      while (localList2.isEmpty());
      com.viber.voip.messages.controller.c.b localb = new com.viber.voip.messages.controller.c.b(paramMessageEntity);
      long l1 = paramMessageEntity.getExtraFlags();
      long l2 = 0x40 & l1 | 0x80 & l1 | l1 & 0x0;
      int i1 = 0x20000 | 0x4000 & paramMessageEntity.getFlag();
      Iterator localIterator2 = localList2.iterator();
      while (localIterator2.hasNext())
      {
        com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localIterator2.next();
        if (!localm.isOwner())
        {
          MessageEntity localMessageEntity = localb.a(paramMessageEntity);
          localMessageEntity.setMemberId(localm.a());
          localMessageEntity.setConversationId(0L);
          localMessageEntity.setConversationType(0);
          localMessageEntity.setMessageSeq(0);
          localMessageEntity.setBroadcastMessageId(paramMessageEntity.getId());
          localMessageEntity.setFlag(i1 | localMessageEntity.getFlag());
          localMessageEntity.setExtraFlags(l2 | localMessageEntity.getExtraFlags());
          localMessageEntity.setExtraStatus(9);
          if (paramMessageEntity.getStatus() != 3)
            localMessageEntity.setStatus(12);
          while (true)
          {
            ((bs)this.e.get()).a(localMessageEntity);
            break;
            localMessageEntity.setStatus(0);
          }
        }
      }
    }
    while (paramMessageEntity.getStatus() != 3);
    int i2 = paramMessageEntity.getMimeType();
    if (i2 == 4)
    {
      Sticker localSticker = com.viber.voip.stickers.i.a().u(paramMessageEntity.getObjectId().toStickerId());
      if ((localSticker != null) && (localSticker.isAnimated()))
        i2 = 6;
    }
    this.t.handleReportBroadcastSendMessage(i2, paramMessageEntity.getMediaFlag(), -1 + localList2.size(), paramMessageEntity.getMessageSeq());
  }

  private boolean b(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    return (paramConversationLoaderEntity.getConversationType() != 3) && (((bs)this.e.get()).a(paramConversationLoaderEntity.getId(), paramConversationLoaderEntity.getConversationType(), paramConversationLoaderEntity.getMessageToken(), paramConversationLoaderEntity.getServerLastMessageId(), paramConversationLoaderEntity.getGroupId()));
  }

  private void c(final MessageEntity paramMessageEntity)
  {
    bk.a local7 = new bk.a()
    {
      public void a(long paramAnonymousLong)
      {
        MessageEntity localMessageEntity = bc.a(bc.this).l(paramMessageEntity.getId());
        if ((localMessageEntity != null) && (localMessageEntity.getMessageInfo() != null) && (!localMessageEntity.isFile()))
        {
          MsgInfo localMsgInfo = localMessageEntity.getMessageInfo();
          localMsgInfo.getFileInfo().setFileSize(paramAnonymousLong);
          localMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
          bc.a(bc.this, localMessageEntity);
        }
      }

      public void a(long paramAnonymousLong, Uri paramAnonymousUri1, Uri paramAnonymousUri2)
      {
        final MessageEntity localMessageEntity = bc.a(bc.this).l(paramMessageEntity.getId());
        Runnable local1;
        if ((localMessageEntity != null) && (!localMessageEntity.isDeleted()) && (1008 != localMessageEntity.getMimeType()))
        {
          localMessageEntity.setDuration(paramAnonymousLong);
          localMessageEntity.setMediaUri(paramAnonymousUri1.toString());
          if ((localMessageEntity.isFile()) && (!localMessageEntity.isGifFile()))
            localMessageEntity.setBody(paramAnonymousUri1.getLastPathSegment());
          if (localMessageEntity.getStatus() != 5)
            break label173;
          localMessageEntity.setExtraStatus(2);
          local1 = new Runnable()
          {
            public void run()
            {
              bc.a(bc.this, localMessageEntity);
              bc.f(bc.this).a(localMessageEntity, 0);
            }
          };
          if (paramAnonymousUri2 == null)
            break label238;
          localMessageEntity.setBody(paramAnonymousUri2.toString());
          if (((!localMessageEntity.isGifFile()) && (!localMessageEntity.isPublicAccount()) && (!localMessageEntity.isWink())) || (localMessageEntity.isNotUploadedForwardedMediaTo1on1WithPublicAccount()))
            break label188;
        }
        label173: label188: for (int i = 1; ; i = 0)
        {
          if (i == 0)
            break label194;
          local1.run();
          return;
          localMessageEntity.setStatus(2);
          localMessageEntity.setExtraStatus(3);
          break;
        }
        label194: bc.a(bc.this, new bj(this, local1));
        com.viber.voip.util.e.e.a(ViberApplication.getApplication()).a(paramAnonymousUri2, bc.g(bc.this), bc.h(bc.this));
        return;
        label238: if (localMessageEntity.isAudioPtt())
          bc.b(bc.this, localMessageEntity);
        local1.run();
      }

      public void a(s.d paramAnonymousd)
      {
        int i = 4;
        MessageEntity localMessageEntity = bc.a(bc.this).l(paramMessageEntity.getId());
        if (localMessageEntity != null)
          switch (bc.8.a[paramAnonymousd.ordinal()])
          {
          default:
            i = 2;
          case 1:
          case 2:
          case 4:
          case 3:
          }
        while (true)
        {
          bc.f(bc.this).a(localMessageEntity, i);
          return;
          if (localMessageEntity.isGifFile())
            localMessageEntity.setExtraStatus(11);
          while (true)
          {
            bc.a(bc.this, localMessageEntity);
            i = 1;
            break;
            localMessageEntity.setExtraStatus(i);
          }
          i = 3;
          localMessageEntity.setStatus(-2);
          bc.a(bc.this, localMessageEntity);
          continue;
          i = 2;
          if (!localMessageEntity.hasAnyStatus(new int[] { 1, 2 }))
          {
            localMessageEntity.setStatus(-1);
            bc.a(bc.this, localMessageEntity);
          }
          else
          {
            bc.f(bc.this).a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
          }
        }
      }
    };
    this.f.a(paramMessageEntity, local7);
  }

  private boolean c(com.viber.voip.messages.conversation.aa paramaa)
  {
    return (paramaa.A() != 3) && (((bs)this.e.get()).a(paramaa.b(), paramaa.A(), paramaa.y(), paramaa.F(), paramaa.c()));
  }

  private void d(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.getMessageInfo().getAudioPttInfo() == null)
    {
      AudioPttInfo localAudioPttInfo = new AudioPttInfo();
      localAudioPttInfo.setSoundBarsInfo(PttUtils.getPackedBase64VolumeBarsByPttId(paramMessageEntity.getMediaUri(), this.b));
      MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
      localMsgInfo.setAudioPttInfo(localAudioPttInfo);
      paramMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
    }
    if ((paramMessageEntity.getDuration() == 0L) && (paramMessageEntity.getMediaUri() != null))
      paramMessageEntity.setDuration(PttUtils.getPttDuration(Uri.parse(paramMessageEntity.getMediaUri()).getPath()));
  }

  private void e(MessageEntity paramMessageEntity)
  {
    ((bs)this.e.get()).c(paramMessageEntity);
  }

  private void f()
  {
    Set localSet = ((com.viber.voip.model.a.d)this.z.get()).b("pending_remove_anonymous_message");
    if (!com.viber.voip.util.u.a(localSet))
    {
      LongSparseArray localLongSparseArray = new LongSparseArray(localSet.size());
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        d.a locala = (d.a)localIterator.next();
        String str = locala.b();
        try
        {
          localLongSparseArray.put(Long.parseLong(str), locala.d());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          ((com.viber.voip.model.a.d)this.z.get()).a("pending_remove_anonymous_message", new String[] { str });
        }
      }
      a(localLongSparseArray);
    }
  }

  private void f(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isPublicAccount());
    MsgInfo localMsgInfo;
    MessageEntity localMessageEntity;
    do
    {
      com.viber.voip.util.links.d locald;
      LinkParser.Preview localPreview;
      do
      {
        do
        {
          return;
          String str = paramMessageEntity.getPublicAccountMediaUrl();
          locald = com.viber.voip.util.links.f.d().a(str);
        }
        while (locald == null);
        localPreview = LinkParser.generatePreview(locald.b);
      }
      while (localPreview == null);
      localMsgInfo = paramMessageEntity.getMessageInfo();
      com.viber.voip.util.links.b.a(localMsgInfo, localMsgInfo.getPublicAccountMsgInfo().getText(), locald.b, localPreview);
      if (bg.a.d(localMsgInfo.getThumbnailContentType()))
        aw.a(localMsgInfo, new MsgInfo[0]);
      localMessageEntity = this.g.l(paramMessageEntity.getId());
    }
    while ((localMessageEntity == null) || (!com.viber.voip.messages.m.a(localMessageEntity, localMsgInfo)));
    localMessageEntity.removeExtraFlag(18);
    localMessageEntity.setMimeType(8);
    this.g.b(localMessageEntity);
    this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
  }

  public void a()
  {
    ab localab = this.g;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0);
    a(localab.i(String.format("(conversations.deleted=0 AND conversations.conversation_type=2) OR conversations._id IN (%s)", arrayOfObject), null), 2);
  }

  public void a(int paramInt, long paramLong, PublicAccount paramPublicAccount, ai.e parame)
  {
    if (parame == null)
      return;
    h localh = ((bs)this.e.get()).a(paramInt, null, paramLong, paramPublicAccount, 0, true, false, 0);
    if (localh == null)
    {
      parame.a(null);
      return;
    }
    parame.a(new PublicGroupConversationItemLoaderEntity(localh, this.g.d(paramLong)));
  }

  public void a(int paramInt, Member paramMember, long paramLong, boolean paramBoolean1, boolean paramBoolean2, ai.e parame)
  {
    if (parame == null)
      return;
    h localh = ((bs)this.e.get()).a(paramInt, paramMember, paramLong, null, 0, paramBoolean1, paramBoolean2, 60);
    if ((!paramBoolean1) && (localh == null))
    {
      parame.a(null);
      return;
    }
    parame.a(new ConversationItemLoaderEntity(localh));
  }

  public void a(long paramLong)
  {
    LongSparseArray localLongSparseArray = this.g.aa(paramLong);
    if (!com.viber.voip.util.u.a(localLongSparseArray))
    {
      int i1 = localLongSparseArray.size();
      ArrayList localArrayList = new ArrayList(i1);
      for (int i2 = 0; i2 < i1; i2++)
      {
        long l1 = localLongSparseArray.keyAt(i2);
        String str = (String)localLongSparseArray.valueAt(i2);
        localArrayList.add(d.a.a("pending_remove_anonymous_message", String.valueOf(l1), str));
      }
      this.A.a(com.viber.voip.analytics.story.g.a(Boolean.TRUE));
      ((com.viber.voip.model.a.d)this.z.get()).a(localArrayList);
      a(localLongSparseArray);
    }
    a(Collections.singleton(Long.valueOf(paramLong)), 0);
  }

  public void a(long paramLong, int paramInt)
  {
    this.g.J(paramLong);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
  }

  public void a(long paramLong, int paramInt, ai.m paramm)
  {
    ((bs)this.e.get()).b(paramLong, paramInt);
    if (paramm != null)
      paramm.a();
  }

  public void a(long paramLong, int paramInt, CharSequence paramCharSequence, String paramString, LongSparseArray<Integer> paramLongSparseArray)
  {
    ((bs)this.e.get()).a(paramLong, paramInt, paramCharSequence, paramString, paramLongSparseArray);
  }

  public void a(long paramLong, int paramInt, String paramString)
  {
    a(paramLong, paramInt, paramString, null, null);
  }

  public void a(long paramLong, int paramInt, String paramString, ai.j paramj)
  {
    List localList = this.g.a(paramLong, paramString, paramInt);
    this.o.post(new bh(paramj, localList));
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    ((bs)this.e.get()).a(paramLong, 33, paramBoolean);
    ((bs)this.e.get()).c();
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
    com.viber.voip.analytics.story.g.a locala = this.y;
    if (paramBoolean);
    for (String str = "Unread"; ; str = "Read")
    {
      locala.b(str, ae.b());
      return;
    }
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.g.D(paramLong1);
    this.d.a(paramLong2, paramLong1, false);
    this.d.a(Collections.singleton(Long.valueOf(paramLong2)), 5, false, false);
    this.l.post(new j.b(paramLong2));
  }

  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2, String[] paramArrayOfString, boolean paramBoolean, Bundle paramBundle)
  {
    com.viber.voip.messages.controller.c.b localb = new com.viber.voip.messages.controller.c.b(paramLong1, paramLong2, paramString1, paramInt1, paramInt2);
    PhoneController localPhoneController = ViberApplication.getInstance().getEngine(true).getPhoneController();
    if (com.viber.voip.messages.m.b(paramInt1));
    int i1;
    MsgInfo localMsgInfo;
    PollUiOptions[] arrayOfPollUiOptions;
    for (String str = this.h.k(); ; str = this.h.l())
    {
      i1 = localPhoneController.generateSequence();
      localMsgInfo = new MsgInfo();
      Poll localPoll1 = new Poll();
      localPoll1.setType("option");
      localPoll1.setParentSeq(i1);
      localPoll1.setGroupId(Long.toString(paramLong2));
      localPoll1.setSenderId(str);
      localMsgInfo.setPoll(localPoll1);
      arrayOfPollUiOptions = new PollUiOptions[paramArrayOfString.length];
      for (int i2 = 0; i2 < paramArrayOfString.length; i2++)
      {
        MessageEntity localMessageEntity2 = localb.a(0, paramArrayOfString[i2], 0, com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo), 0);
        localMessageEntity2.setMessageSeq(localPhoneController.generateSequence());
        ((bs)this.e.get()).a(localMessageEntity2);
        PollUiOptions localPollUiOptions = new PollUiOptions();
        localPollUiOptions.setSeq(localMessageEntity2.getMessageSeq());
        localPollUiOptions.setName(paramArrayOfString[i2]);
        arrayOfPollUiOptions[i2] = localPollUiOptions;
      }
    }
    Poll localPoll2 = new Poll();
    localPoll2.setType("poll");
    localPoll2.setOptions(arrayOfPollUiOptions);
    localPoll2.setMultiple(paramBoolean);
    localPoll2.setGroupId(Long.toString(paramLong2));
    localPoll2.setSenderId(str);
    localMsgInfo.setPoll(localPoll2);
    MessageEntity localMessageEntity1 = localb.a(0, paramString2, 0, com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo), 0);
    localMessageEntity1.setMessageSeq(i1);
    localMessageEntity1.setStatus(13);
    com.viber.voip.messages.m.a(3, new MessageEntity[] { localMessageEntity1 });
    bs.f localf = ((bs)this.e.get()).a(localMessageEntity1);
    if ((localf != null) && (localf.b))
    {
      a(localMessageEntity1, localf.f, paramBundle);
      b(localf);
    }
  }

  public void a(long paramLong, Uri paramUri)
  {
    MessageEntity localMessageEntity = ab.b().l(paramLong);
    if (localMessageEntity != null)
    {
      if (localMessageEntity.getMediaUri() == null)
        break label62;
      at.b(Uri.parse(localMessageEntity.getMediaUri()), paramUri);
      localMessageEntity.setMediaUri(paramUri.toString());
    }
    while (true)
    {
      ((bs)this.e.get()).c(localMessageEntity);
      return;
      label62: if ((localMessageEntity.getMessageInfo() != null) && (localMessageEntity.isGifUrlMessage()))
      {
        String str = localMessageEntity.getMessageInfo().getThumbnailUrl();
        File localFile = dv.u.b(this.b, str, false);
        if (at.a(localFile))
          at.b(Uri.fromFile(localFile), paramUri);
      }
    }
  }

  public void a(long paramLong, ai.b paramb)
  {
    MessageEntity localMessageEntity = this.g.l(paramLong);
    if (localMessageEntity.isPublicGroupBehavior())
    {
      t.a(localMessageEntity);
      ((bs)this.e.get()).a(localMessageEntity.getMessageToken(), true);
      if (paramb != null)
        paramb.a(Collections.singleton(Long.valueOf(paramLong)));
    }
  }

  public void a(long paramLong, ai.d paramd)
  {
    if (paramd != null)
      paramd.a(this.g.f(paramLong));
  }

  public void a(long paramLong, ai.e parame)
  {
    h localh;
    Object localObject;
    if (parame != null)
    {
      localh = this.g.f(paramLong);
      localObject = null;
      if (localh != null)
      {
        if (!localh.e())
          break label62;
        localObject = new PublicGroupConversationItemLoaderEntity(localh, this.g.d(localh.k()));
      }
    }
    while (true)
    {
      parame.a((ConversationItemLoaderEntity)localObject);
      return;
      label62: if (localh.G())
      {
        r localr = this.g.e(paramLong);
        localObject = new ConversationItemLoaderEntity(localh, this.i.b(localh.V()), localr);
      }
      else if (localh.b())
      {
        localObject = new ConversationItemLoaderEntity(localh);
      }
      else
      {
        localObject = new ConversationItemLoaderEntity(localh, this.i.b(localh.V()));
      }
    }
  }

  public void a(long paramLong, ai.f paramf)
  {
    if (paramf != null)
    {
      List localList = this.g.x(paramLong);
      this.o.post(new bd(paramf, localList));
    }
  }

  public void a(long paramLong, ai.h paramh)
  {
    Map localMap = this.i.e(paramLong);
    this.o.post(new bf(paramh, localMap));
  }

  public void a(long paramLong, String paramString)
  {
    MessageEntity localMessageEntity = this.g.l(paramLong);
    if (localMessageEntity != null)
    {
      if (localMessageEntity.isGifUrlMessage())
        a(localMessageEntity, paramString);
    }
    else
      return;
    c(localMessageEntity);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    ((bs)this.e.get()).d(paramLong, paramBoolean);
  }

  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    ((bs)this.e.get()).l(paramLong, paramBoolean);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
  }

  public void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    ((bs)this.e.get()).a(paramLong1, paramBoolean, paramLong2);
    Set localSet = Collections.singleton(Long.valueOf(paramLong1));
    a(localSet, true, paramInt, false, true);
    a(localSet, paramInt, true, paramBoolean, true);
  }

  public void a(long paramLong, boolean paramBoolean, ai.m paramm)
  {
    ((bs)this.e.get()).b(paramLong, paramBoolean);
    if (paramm != null)
      paramm.a();
  }

  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    h localh = this.g.f(paramLong);
    if (localh == null)
      return;
    localh.a(15, paramBoolean1);
    this.g.b(paramLong, 15, paramBoolean1);
    if ((paramBoolean1) && (paramBoolean2))
      this.r.a(localh.getId(), localh.j(), localh.I());
    if ((paramBoolean1) && (localh.ae()))
      ViberApplication.getInstance().getMessagesManager().c().a(localh.getId(), false, localh.j());
    if (localh.R())
    {
      this.d.a(Collections.singleton(Long.valueOf(paramLong)), localh.j(), false, false);
      return;
    }
    ((bs)this.e.get()).a(Collections.singletonList(localh));
  }

  public void a(Pin paramPin, long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    com.viber.voip.messages.controller.c.b localb = new com.viber.voip.messages.controller.c.b(paramLong1, paramLong2, paramString, paramInt1, paramInt2);
    MessageEntity localMessageEntity1;
    ExtendedInfo localExtendedInfo;
    if (com.viber.voip.messages.m.a(paramInt1))
    {
      paramPin.setNumber(this.h.j());
      if (paramPin.getMediaType() != 0)
      {
        localMessageEntity1 = this.g.k(paramPin.getToken());
        localExtendedInfo = new ExtendedInfo();
        paramPin.setExtendedInfo(localExtendedInfo);
        if (!localMessageEntity1.isSticker())
          break label150;
        localExtendedInfo.setDownloadId(Integer.toString(localMessageEntity1.getObjectId().toStickerId()));
      }
    }
    while (true)
    {
      a(localb.a(paramPin), null);
      return;
      if (com.viber.voip.messages.m.b(paramInt1))
      {
        paramPin.setNumber(this.h.k());
        break;
      }
      if (paramInt1 != 1)
        break;
      paramPin.setNumber(this.h.l());
      break;
      label150: if (localMessageEntity1.isLocationMessage())
      {
        localExtendedInfo.setLng(Integer.toString(localMessageEntity1.getLng()));
        localExtendedInfo.setLat(Integer.toString(localMessageEntity1.getLat()));
      }
      else
      {
        if ((localMessageEntity1.isImage()) || (localMessageEntity1.isVideo()) || (localMessageEntity1.isGifFile()))
        {
          if (localMessageEntity1.isGifFile())
            localExtendedInfo.setFileExt("gif");
          if (!TextUtils.isEmpty(localMessageEntity1.getDescription()))
          {
            paramPin.setText(localMessageEntity1.getDescription());
            localExtendedInfo.setDescription(localMessageEntity1.getDescription());
          }
          if (!TextUtils.isEmpty(localMessageEntity1.getDownloadId()))
          {
            localExtendedInfo.setDownloadId(localMessageEntity1.getDownloadId());
            if (localMessageEntity1.isGifFile());
            for (String str = localMessageEntity1.getEncryptionParamsSerialized(); ; str = localMessageEntity1.getMessageInfo().getThumbnailEP())
            {
              localExtendedInfo.setEncriptionParams(str);
              break;
            }
          }
          if (com.viber.voip.messages.m.e(paramInt1))
          {
            a(paramPin, paramLong2, localb, localMessageEntity1, localExtendedInfo);
            return;
          }
          MessageEntity localMessageEntity2 = localb.a(paramPin);
          localMessageEntity2.setMediaUri(localMessageEntity1.getBody());
          a(localMessageEntity2, null);
          return;
        }
        if (localMessageEntity1.isShareContactMessage())
        {
          localExtendedInfo.setDownloadId(localMessageEntity1.getMessageInfo().getDownloadId());
        }
        else if (localMessageEntity1.isGifUrlMessage())
        {
          localExtendedInfo.setFileExt("gif");
          localExtendedInfo.setDownloadId(localMessageEntity1.getMessageInfo().getUrl());
        }
      }
    }
  }

  public void a(ai.a parama)
  {
    Set localSet = this.g.t();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ((bs)this.e.get()).a(localLong.longValue(), 33, false);
    }
    ((bs)this.e.get()).c();
    this.d.a(localSet, false);
    ViberApplication.getInstance().getMessagesManager().a().e();
    if (parama != null)
      parama.a();
  }

  public void a(ai.k paramk)
  {
    Set localSet = this.g.i(com.viber.voip.messages.conversation.n.m, null);
    int i1 = this.g.b(localSet);
    a(localSet, 0);
    paramk.a(i1);
  }

  public void a(y paramy, com.viber.voip.messages.controller.manager.af paramaf, ai.l paraml)
  {
    if (paraml == null)
      return;
    if ((paramy == null) || (TextUtils.isEmpty(paramy.a())))
      paramy = new y.a().a("").a();
    String str = paramy.a();
    af.a locala = af.a.a;
    if ((paramy.m()) && (paramy.r()) && (str.length() == 4) && (TextUtils.isDigitsOnly(str)) && (str.equals(this.s.a())))
      locala = af.a.c;
    paraml.a(paramy, paramaf.a(paramy, locala));
  }

  public void a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    boolean bool = b(paramConversationLoaderEntity);
    if ((!bool) && (paramConversationLoaderEntity.isPublicGroupBehavior()))
    {
      this.g.k(paramConversationLoaderEntity.getGroupId(), paramConversationLoaderEntity.getServerLastMessageId());
      this.g.d(paramConversationLoaderEntity.getConversationType());
      bool = true;
    }
    if (bool)
    {
      long l1 = paramConversationLoaderEntity.getId();
      com.viber.voip.notif.g.a(this.b).a(l1);
      this.d.a(Collections.singleton(Long.valueOf(l1)), paramConversationLoaderEntity.getConversationType(), true);
    }
  }

  public void a(com.viber.voip.messages.conversation.aa paramaa)
  {
    if (c(paramaa))
    {
      long l1 = paramaa.b();
      com.viber.voip.notif.g.a(this.b).a(l1);
      this.d.a(Collections.singleton(Long.valueOf(l1)), paramaa.A(), true);
      if (paramaa.aa())
        this.x.a();
    }
  }

  public void a(com.viber.voip.messages.conversation.aa paramaa, int paramInt1, int paramInt2)
  {
    MessageEntity localMessageEntity = this.g.l(paramaa.a());
    if (localMessageEntity != null)
      try
      {
        String str = FormattedUrlMessage.updateFormattedMediaDimensions(localMessageEntity.getMessageInfo(), localMessageEntity.getBody(), paramInt1, paramInt2);
        if (str.equals(localMessageEntity.getBody()))
          return;
        localMessageEntity.setBody(str);
        localMessageEntity.setFormattedMessage(null);
        this.g.b(localMessageEntity);
        this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
        return;
      }
      catch (JSONException localJSONException)
      {
      }
  }

  public void a(CallEntity paramCallEntity, int paramInt, long paramLong, String paramString)
  {
    ((bs)this.e.get()).a(paramCallEntity, paramInt, paramLong, paramString);
  }

  public void a(MessageEntity paramMessageEntity, Bundle paramBundle)
  {
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageControllerImpl sendMessage");
    if ((!paramMessageEntity.isBroadcastList()) && (TextUtils.isEmpty(paramMessageEntity.getMemberId())) && (paramMessageEntity.getGroupId() <= 0L))
      return;
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageControllerImpl parseSpans");
    if ((paramMessageEntity.isSticker()) && (!com.viber.voip.stickers.i.a().u(paramMessageEntity.getObjectId().toStickerId()).hasSound()))
      ViberApplication.getInstance().getRingtonePlayer().playSample(SampleTone.OUTGOING_STICKER);
    a(paramMessageEntity);
    com.viber.voip.messages.m.d(paramMessageEntity);
    com.viber.voip.messages.m.a(11, new MessageEntity[] { paramMessageEntity });
    com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageControllerImpl parseSpans");
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageControllerImpl insertMessage");
    com.viber.provider.b localb = com.viber.voip.messages.controller.manager.aa.f();
    localb.a();
    try
    {
      bs.f localf = ((bs)this.e.get()).a(paramMessageEntity);
      localb.c();
      localb.b();
      com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageControllerImpl insertMessage");
      if (!paramMessageEntity.isPinMessage())
      {
        a(paramMessageEntity, localf.f, paramBundle);
        this.n.post(new be(this, localf));
      }
      b(paramMessageEntity);
      com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageControllerImpl sendMessage");
      return;
    }
    finally
    {
      localb.b();
    }
  }

  public void a(h paramh, ai.i parami)
  {
    long l1 = paramh.k();
    r localr = this.g.d(l1);
    PublicAccount localPublicAccount = null;
    if (localr != null)
      localPublicAccount = new PublicAccount(localr, paramh);
    parami.a(localPublicAccount);
  }

  public void a(Runnable paramRunnable)
  {
    com.viber.voip.model.entity.m localm = this.i.e();
    if (localm != null);
    for (String str = localm.getNumber(); !da.a(str, this.h.h()); str = "")
    {
      this.g.u();
      com.viber.voip.stickers.i.a().a(false, paramRunnable);
      return;
    }
    a.a(new RuntimeException("Same user re-registered!"), "Keeping user's data");
  }

  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    a(this.g.i("conversations.grouping_key = ?", new String[] { paramString }), 0);
  }

  public void a(String paramString, ai.e parame)
  {
    r localr;
    if (parame != null)
    {
      localr = this.g.c(paramString);
      if (localr == null)
        break label96;
      h localh1 = this.g.b(localr.a());
      if (localh1 != null)
        parame.a(new PublicGroupConversationItemLoaderEntity(localh1, localr));
    }
    else
    {
      return;
    }
    h localh2 = this.g.c(localr.a());
    if (localh2 != null)
    {
      PublicAccount localPublicAccount = new PublicAccount(localh2, localr);
      a(3, localPublicAccount.getGroupID(), localPublicAccount, parame);
      return;
    }
    label96: parame.a(null);
  }

  public void a(String paramString, ai.i parami)
  {
    PublicGroupConversationItemLoaderEntity localPublicGroupConversationItemLoaderEntity = this.g.b(paramString);
    PublicAccount localPublicAccount = null;
    if (localPublicGroupConversationItemLoaderEntity != null)
      localPublicAccount = new PublicAccount(localPublicGroupConversationItemLoaderEntity);
    parami.a(localPublicAccount);
  }

  public void a(List<com.viber.voip.apps.b> paramList)
  {
    List localList = this.g.e();
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
    {
      h localh2 = (h)localIterator1.next();
      localHashMap.put(Integer.valueOf(localh2.l()), localh2);
    }
    Iterator localIterator2 = paramList.iterator();
    while (localIterator2.hasNext())
    {
      com.viber.voip.apps.b localb = (com.viber.voip.apps.b)localIterator2.next();
      h localh1 = (h)localHashMap.get(Integer.valueOf(localb.a()));
      String str = com.viber.voip.messages.m.j(localb.a());
      com.viber.voip.messages.d.c.c().a(new Member(str, str, localb.a(b.a.b), localb.c(), null));
      if ((localh1 != null) && ((localh1.J()) || (localh1.F() != localb.l())))
      {
        if (localb.l())
          localh1.g(13);
        while (true)
        {
          if (localh1.J())
            localh1.h(18);
          if (!this.g.b(localh1))
            break;
          this.d.a(Collections.singleton(Long.valueOf(localh1.getId())), localh1.j(), false, false);
          break;
          localh1.h(13);
        }
      }
    }
  }

  public void a(Map<String, az.a> paramMap, long paramLong)
  {
    HashSet localHashSet1 = new HashSet(paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
      localHashSet1.add(Long.valueOf((String)localIterator.next()));
    Map localMap = this.g.a(localHashSet1);
    HashSet localHashSet2 = new HashSet();
    this.g.a(new bi(this, paramMap, paramLong, localMap, localHashSet2));
    if (localHashSet2.size() > 0)
      a(localHashSet2, 5, false, false, false);
    while (true)
    {
      this.d.a(new HashSet(localMap.values()), 5, false, false);
      return;
      this.g.d(5);
    }
  }

  public void a(Set<Long> paramSet)
  {
    com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.a(Boolean.TRUE));
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      MessageEntity localMessageEntity = this.g.l(localLong.longValue());
      if ((localMessageEntity != null) && (localMessageEntity.isOutgoing()))
        if (localMessageEntity.isGroupBehavior())
          localEngine.getPhoneController().handleDeleteGroupMessage(localMessageEntity.getGroupId(), localMessageEntity.getMessageToken(), localEngine.getPhoneController().generateSequence());
        else
          localEngine.getPhoneController().handleDeleteMessage(localMessageEntity.getMemberId(), localMessageEntity.getMessageToken(), localEngine.getPhoneController().generateSequence(), localMessageEntity.getNativeChatType());
    }
  }

  public void a(Set<Long> paramSet, int paramInt)
  {
    this.r.a(paramSet);
    ((bs)this.e.get()).a(paramSet, paramInt);
    Iterator localIterator = this.g.c(paramSet).iterator();
    while (localIterator.hasNext())
      t.a((MessageEntity)localIterator.next());
  }

  public void a(Set<Long> paramSet, ai.c paramc)
  {
    HashMap localHashMap = this.j.a(paramSet);
    this.o.post(new bg(paramc, localHashMap));
  }

  public void a(Set<Long> paramSet, boolean paramBoolean, int paramInt)
  {
    a(paramSet, paramBoolean, paramInt, true, true);
  }

  public void a(Set<Long> paramSet, boolean paramBoolean, ai.b paramb)
  {
    ((bs)this.e.get()).a(paramSet);
    if (paramb != null)
      paramb.a(paramSet);
    this.f.a(paramSet);
  }

  public void a(long[] paramArrayOfLong, Bundle paramBundle, ConversationItemLoaderEntity paramConversationItemLoaderEntity, ai.g paramg)
  {
    List localList = this.g.a(paramArrayOfLong, true);
    if (com.viber.voip.util.u.a(localList))
    {
      paramg.a(Collections.emptyList(), Collections.emptyList());
      return;
    }
    com.viber.voip.messages.controller.c.b localb = new com.viber.voip.messages.controller.c.b(paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getGroupId(), paramConversationItemLoaderEntity.getParticipantMemberId(), paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getNativeChatType());
    ArrayList localArrayList = new ArrayList(localList.size());
    int i1 = localList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      MessageEntity localMessageEntity = a(localb, (MessageEntity)localList.get(i2), paramBundle);
      localMessageEntity.setDate(localMessageEntity.getDate() + i2);
      localMessageEntity.setTimebombInSec(paramConversationItemLoaderEntity.getTimebombTime());
      if (i2 > 0)
        localMessageEntity.setStatus(11);
      localArrayList.add(localMessageEntity);
    }
    paramg.a(localList, localArrayList);
  }

  public void a(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageControllerImpl sendMessage array");
    com.viber.voip.messages.m.a(11, paramArrayOfMessageEntity);
    ArrayList localArrayList = new ArrayList(paramArrayOfMessageEntity.length);
    int i1 = 0;
    if (i1 < paramArrayOfMessageEntity.length)
    {
      MessageEntity localMessageEntity = paramArrayOfMessageEntity[i1];
      if ((!localMessageEntity.isBroadcastList()) && (TextUtils.isEmpty(localMessageEntity.getMemberId())) && (localMessageEntity.getGroupId() <= 0L));
      while (true)
      {
        i1++;
        break;
        com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "preInsert");
        a(localMessageEntity);
        bs.f localf = ((bs)this.e.get()).a(localMessageEntity);
        if (localf.b)
          a(localMessageEntity, localf.f, paramBundle);
        localArrayList.add(localf);
        com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "postInsert");
        b(localMessageEntity);
        com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "postBroadcast");
      }
    }
    a((bs.f[])localArrayList.toArray(new bs.f[localArrayList.size()]), paramArrayOfMessageEntity);
    com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageControllerImpl sendMessage array");
  }

  public boolean a(int paramInt, boolean paramBoolean)
  {
    synchronized (this.B)
    {
      int i1 = this.B.indexOfKey(paramInt);
      if (i1 >= 0)
      {
        if (!paramBoolean)
        {
          com.viber.voip.model.a.d locald = (com.viber.voip.model.a.d)this.z.get();
          String[] arrayOfString = new String[1];
          arrayOfString[0] = String.valueOf(this.B.valueAt(i1));
          locald.a("pending_remove_anonymous_message", arrayOfString);
        }
        this.B.removeAt(i1);
        return true;
      }
      return false;
    }
  }

  boolean a(long paramLong1, long paramLong2, int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.u.getExchanger().handleCLikeGroupMessage(new CLikeGroupMessage(paramString1, paramLong1, paramLong2, paramInt, paramBoolean));
    return true;
  }

  boolean a(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, long paramLong3, int paramInt2, String paramString1, String paramString2)
  {
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 2)
    {
      this.u.getExchanger().handleCSendActionOnPGMsg(new CSendActionOnPGMsg(paramLong1, paramLong2, paramInt1, i1, paramInt2, paramLong3, paramString1));
      return true;
    }
  }

  public void b()
  {
    int i1;
    Iterator localIterator;
    if (!bk.a(this.b))
    {
      i1 = 1;
      localIterator = this.g.k().iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MessageEntity localMessageEntity = (MessageEntity)localIterator.next();
      if (((i1 == 0) || (localMessageEntity.needForceDownloadMedia())) && (bk.b(localMessageEntity, this.b)))
      {
        if ((localMessageEntity.isGifUrlMessage()) && (bk.a(this.b, localMessageEntity.getMessageInfo().getContentLength(), localMessageEntity.isPublicGroupType(), localMessageEntity.isRoleFollower())))
        {
          a(localMessageEntity, bu.a(localMessageEntity.getMessageInfo().getThumbnailUrl()));
          continue;
          i1 = 0;
          break;
        }
        if (((localMessageEntity.isGifFile()) && (bk.a(this.b, localMessageEntity.getMsgInfoFileInfo().getFileSize(), localMessageEntity.isPublicGroupType(), localMessageEntity.isRoleFollower()))) || (bk.a(localMessageEntity, this.b)))
          c(localMessageEntity);
      }
    }
  }

  public void b(long paramLong)
  {
    ((bs)this.e.get()).d(paramLong);
  }

  public void b(long paramLong, int paramInt)
  {
    this.g.K(paramLong);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
  }

  public void b(long paramLong, Uri paramUri)
  {
    a(paramLong, paramUri);
    com.viber.voip.util.upload.o.b(paramUri);
  }

  public void b(long paramLong, ai.b paramb)
  {
    a(this.g.p(paramLong), false, paramb);
    long l1 = av.a(0L, new int[] { 5, 7 });
    this.g.a(paramLong, 0L, l1);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), 0, false, false);
  }

  public void b(long paramLong, String paramString)
  {
    if (this.g.k(paramLong, paramString) > 0)
    {
      MessageEntity localMessageEntity = this.g.l(paramLong);
      this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      this.l.post(new com.viber.voip.messages.a.h.a(localMessageEntity));
    }
  }

  public void b(long paramLong, boolean paramBoolean)
  {
    ((bs)this.e.get()).k(paramLong, paramBoolean);
  }

  public void b(long paramLong, boolean paramBoolean, ai.m paramm)
  {
    ((bs)this.e.get()).c(paramLong, paramBoolean);
    if (paramm != null)
      paramm.a();
  }

  public void b(com.viber.voip.messages.conversation.aa paramaa)
  {
    if (c(paramaa))
    {
      long l1 = paramaa.b();
      com.viber.voip.notif.g.a(this.b).a(l1);
      this.d.a(Collections.singleton(Long.valueOf(l1)), paramaa.aT(), true);
    }
  }

  public void b(List<MessageEntity> paramList)
  {
    int i1 = paramList.size();
    for (int i2 = 0; i2 < i1; i2++)
      f((MessageEntity)paramList.get(i2));
  }

  public void c()
  {
    this.f.a();
  }

  public void c(long paramLong)
  {
    ((bs)this.e.get()).e(paramLong);
  }

  public void c(long paramLong, int paramInt)
  {
    MessageEntity localMessageEntity = this.g.l(paramLong);
    localMessageEntity.addExtraFlag(paramInt);
    this.g.b(localMessageEntity);
    this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
  }

  public void c(long paramLong, ai.b paramb)
  {
    a(this.g.b(new long[] { paramLong }), false, paramb);
  }

  public void c(long paramLong, boolean paramBoolean)
  {
    MessageEntity localMessageEntity = this.g.l(paramLong);
    if (!localMessageEntity.isWink())
      return;
    int i1;
    if (paramBoolean)
    {
      i1 = 1;
      localMessageEntity.setOpened(i1);
      if (localMessageEntity.isIncoming())
      {
        if (!paramBoolean)
          break label118;
        localMessageEntity.addExtraFlag(22);
      }
    }
    while (true)
    {
      ((bs)this.e.get()).c(localMessageEntity);
      this.g.f(localMessageEntity.getConversationId(), localMessageEntity.getConversationType());
      this.d.a(Collections.singleton(Long.valueOf(localMessageEntity.getConversationId())), localMessageEntity.getConversationType(), false, false);
      return;
      i1 = 0;
      break;
      label118: localMessageEntity.removeExtraFlag(22);
    }
  }

  public void c(long paramLong, boolean paramBoolean, ai.m paramm)
  {
    ((bs)this.e.get()).e(paramLong, paramBoolean);
    if (paramm != null)
      paramm.a();
  }

  public u d()
  {
    return this.k;
  }

  public void d(long paramLong)
  {
    ((bs)this.e.get()).f(paramLong);
  }

  public void d(long paramLong, boolean paramBoolean)
  {
    ((bs)this.e.get()).i(paramLong, paramBoolean);
  }

  public void d(long paramLong, boolean paramBoolean, ai.m paramm)
  {
    ((bs)this.e.get()).f(paramLong, paramBoolean);
    if (paramm != null)
      paramm.a();
  }

  public void e()
  {
    ((bs)this.e.get()).b();
  }

  public void e(long paramLong)
  {
    MessageEntity localMessageEntity = this.g.k(paramLong);
    if (localMessageEntity == null);
    label131: label269: label413: 
    while (true)
    {
      return;
      int i1 = localMessageEntity.getMessageGlobalId();
      long l1 = localMessageEntity.getConversationId();
      Engine localEngine = ViberApplication.getInstance().getEngine(true);
      if (!localEngine.getPhoneController().isConnected())
      {
        cj.a(true);
        this.d.a(l1, paramLong, false);
        return;
      }
      int i2 = localEngine.getPhoneController().generateSequence();
      boolean bool;
      UnsignedInt localUnsignedInt;
      int i3;
      String str1;
      label228: Object localObject;
      String str2;
      if (!localMessageEntity.hasMyLike())
      {
        bool = true;
        long l2 = av.a(localMessageEntity.getExtraFlags(), 12, bool);
        localUnsignedInt = new UnsignedInt(localMessageEntity.getLikesCount());
        localMessageEntity.setExtraFlags(l2);
        if (!bool)
          break label328;
        i3 = localUnsignedInt.increment();
        localMessageEntity.setLikesCount(i3);
        this.g.b(localMessageEntity);
        com.viber.voip.messages.m.a(true, this.g, localMessageEntity);
        str1 = this.h.l();
        if (!bool)
          break label338;
        com.viber.voip.model.entity.j localj1 = new com.viber.voip.model.entity.j();
        localj1.a(paramLong);
        localj1.a(str1);
        localj1.c(System.currentTimeMillis());
        localj1.a(i2);
        localj1.b(1);
        localj1.a(true);
        this.g.a(localj1);
        this.d.a(l1, paramLong, false);
        localObject = localMessageEntity.getMemberId();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!localMessageEntity.isCommunityType())
            break label381;
          str2 = this.h.k();
          localObject = str2;
        }
        if (!localMessageEntity.isPublicGroupBehavior())
          break label393;
        a(localMessageEntity.getGroupId(), paramLong, i1, bool, localMessageEntity.getDate(), i2, (String)localObject, "");
      }
      while (true)
      {
        if (!localMessageEntity.isCommunityType())
          break label413;
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.b());
        return;
        bool = false;
        break;
        label328: i3 = localUnsignedInt.decrement();
        break label131;
        label338: com.viber.voip.model.entity.j localj2 = this.g.b(paramLong, str1);
        if (localj2 == null)
          break label228;
        localj2.a(i2);
        localj2.b(2);
        this.g.b(localj2);
        break label228;
        label381: str2 = this.h.l();
        break label269;
        a(paramLong, localMessageEntity.getGroupId(), i2, (String)localObject, bool, "");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.bc
 * JD-Core Version:    0.6.2
 */