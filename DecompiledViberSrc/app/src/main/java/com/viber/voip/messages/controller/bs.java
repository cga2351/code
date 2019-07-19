package com.viber.voip.messages.controller;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.jni.ConversationSettings;
import com.viber.jni.Engine;
import com.viber.jni.LocationInfo;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.SecureMessagesController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.Edit;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.InviteCommunityInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Poll;
import com.viber.voip.flatbuffers.model.msginfo.PollUiOptions;
import com.viber.voip.flatbuffers.model.msginfo.TechInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.PublicAccountReplyData;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.h;
import com.viber.voip.messages.a.d.d;
import com.viber.voip.messages.a.j.a;
import com.viber.voip.messages.a.l.a;
import com.viber.voip.messages.controller.b.f;
import com.viber.voip.messages.controller.b.f.c;
import com.viber.voip.messages.controller.b.f.d;
import com.viber.voip.messages.controller.manager.aa;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ab.b;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.g.a;
import com.viber.voip.messages.controller.manager.g.b;
import com.viber.voip.messages.orm.entity.impl.PublicAccountEntityHelper;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.r;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.bh;
import com.viber.voip.sound.ptt.PttUtils;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.av;
import com.viber.voip.util.b.c.a;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.s;
import com.viber.voip.util.upload.t;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;
import org.sqlite.database.SQLException;

public class bs
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private ab c;
  private com.viber.voip.messages.controller.manager.o d;
  private dagger.a<bn> e;
  private UserManager f;
  private ViberApplication g;
  private Engine h;
  private ak i;
  private al j;
  private com.viber.voip.messages.controller.a.a k;
  private f l;
  private EventBus m;

  public bs(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = ab.b();
    this.d = com.viber.voip.messages.controller.manager.o.a();
    this.g = ViberApplication.getInstance();
    this.f = UserManager.from(paramContext);
    this.i = ak.a();
    this.j = al.a();
    this.e = this.g.getLazyMessageControllerUtils();
    this.m = com.viber.voip.h.a.b();
  }

  private long a(MessageEntity paramMessageEntity, Member paramMember)
  {
    if (paramMessageEntity.isOutgoing())
      return a().getId();
    int n = cd.j(paramMessageEntity.getConversationType());
    f.c localc = new f.c(paramMessageEntity.getMemberId(), n);
    f localf = this.l;
    Long localLong1 = null;
    if (localf != null)
      localLong1 = this.l.b(localc);
    if (localLong1 == null)
    {
      Long localLong2 = this.i.e(paramMember, n);
      if (localLong2 != null)
      {
        if (this.l != null)
          this.l.a(localc, localLong2);
        return localLong2.longValue();
      }
      localLong1 = Long.valueOf(this.i.b(paramMember, n).getId());
      if (this.l != null)
        this.l.a(localc, localLong1);
    }
    return localLong1.longValue();
  }

  private f a(MessageEntity paramMessageEntity, MessageCallEntity paramMessageCallEntity, Member paramMember, String paramString1, int paramInt, String paramString2)
  {
    int n;
    InviteCommunityInfo localInviteCommunityInfo;
    PublicAccount.ExtraInfo localExtraInfo;
    int i1;
    boolean bool;
    long l1;
    String str1;
    if (paramMessageEntity.isCommunityType())
    {
      n = 2;
      localInviteCommunityInfo = paramMessageEntity.getMessageInfo().getInviteCommunityInfo();
      localExtraInfo = null;
      if (localInviteCommunityInfo != null)
        break label93;
      i1 = paramMessageEntity.getConversationType();
      bool = false;
      l1 = paramMessageEntity.getGroupId();
      str1 = paramString1;
    }
    for (int i2 = n; ; i2 = 3)
    {
      return a(paramMessageEntity, paramMessageCallEntity, paramMessageEntity.getDate(), paramMember, l1, str1, i1, paramInt, i2, paramMessageEntity.isSecretMessage(), paramMessageEntity.getTimebombInSec(), null, paramString2, bool, localExtraInfo);
      n = 1;
      break;
      label93: i1 = 5;
      str1 = localInviteCommunityInfo.getCommunityName();
      bool = true;
      l1 = localInviteCommunityInfo.getGroupId();
      localExtraInfo = new PublicAccount.ExtraInfo();
      String str2 = localInviteCommunityInfo.getInviteLink();
      localExtraInfo.setInvitationLink(str2);
      Integer localInteger = Integer.valueOf(localInviteCommunityInfo.getParticipantsCount());
      localExtraInfo.setParticipantsCount(localInteger);
      long l2 = paramMessageEntity.getMessageToken();
      localExtraInfo.setInvitationToken(l2);
    }
  }

  private f a(com.viber.voip.model.entity.h paramh, long paramLong, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity, MessageCallEntity paramMessageCallEntity, Member paramMember)
  {
    boolean bool1 = paramMessageEntity.isFromBackup();
    if (b(paramMessageEntity, paramm))
      return new f(false, false, paramh, paramm, paramMessageEntity, true);
    Long localLong = a(paramh.getId(), 1, paramLong, paramh.j(), bool1);
    long l1 = paramh.getId();
    paramMessageEntity.setConversationId(l1);
    int n = paramh.j();
    paramMessageEntity.setConversationType(n);
    long l2 = localLong.longValue();
    paramMessageEntity.setParticipantId(l2);
    c(paramMessageEntity, paramh);
    boolean bool2 = paramh.Q();
    boolean bool3 = paramh.P();
    MessageEntity localMessageEntity3;
    MessageEntity localMessageEntity2;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if (paramMessageEntity.isCall())
    {
      localMessageEntity3 = this.c.c(paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken());
      localMessageEntity2 = this.c.s(paramMessageEntity.getConversationId());
      boolean bool13 = paramMessageCallEntity.getDuration() < 3L;
      bool5 = false;
      bool6 = false;
      if (!bool13)
      {
        boolean bool14 = paramMessageCallEntity.isOutgoing();
        bool5 = false;
        bool6 = false;
        if (bool14)
        {
          bool6 = false;
          if (bool3)
            bool6 = true;
          bool5 = false;
          if (bool2)
            bool5 = true;
        }
      }
      if ((paramMessageEntity.isToSend()) || (paramMessageEntity.isCall()) || (!paramMessageEntity.isOutgoing()))
        break label682;
      if (bool3)
        bool6 = true;
      if (!bool2)
        break label682;
      bool7 = true;
    }
    for (boolean bool8 = bool6; ; bool8 = bool6)
    {
      boolean bool10;
      label278: boolean bool11;
      boolean bool12;
      if (a(paramMessageEntity, localMessageEntity3, paramMessageCallEntity))
      {
        bool10 = true;
        paramMessageEntity = localMessageEntity3;
        a(paramMessageEntity.getConversationId(), paramMessageEntity.getId(), paramMessageCallEntity);
        bool11 = paramh.T();
        bool12 = a(paramMessageEntity, paramh, paramLong, bool8, bool7);
        if ((!paramMessageEntity.isIncoming()) || (!paramh.D()) || (!g().a(paramMessageEntity.getFlag(), paramh)))
          break label676;
      }
      label676: for (int i2 = 1; ; i2 = 0)
      {
        if (bool12)
          this.c.a("conversations", paramh.getId(), "flags", Long.valueOf(paramh.z()));
        if (i2 != 0)
          this.c.a("conversations", paramh.getId(), "business_inbox_flags", Integer.valueOf(paramh.ai()));
        if (bool11)
          this.c.o();
        return new f(bool10, false, paramh, paramm, paramMessageEntity, false);
        if ((!paramMessageEntity.isToSend()) && (!paramMessageEntity.isBroadcastList()) && ((!paramMessageEntity.isPublicGroupBehavior()) || (paramMessageEntity.getMessageGlobalId() != 0)))
        {
          a(paramMessageEntity, paramMessageEntity);
          bool5 = false;
          bool6 = false;
          localMessageEntity2 = null;
          localMessageEntity3 = null;
          break;
        }
        MessageEntity localMessageEntity1 = this.c.s(paramMessageEntity.getConversationId());
        if (localMessageEntity1 != null)
          a(paramMessageEntity, localMessageEntity1);
        boolean bool4 = paramh.O();
        bool5 = false;
        bool6 = false;
        localMessageEntity2 = null;
        localMessageEntity3 = null;
        if (!bool4)
          break;
        int i1 = 0x1000 | paramMessageEntity.getFlag();
        paramMessageEntity.setFlag(i1);
        bool5 = false;
        bool6 = false;
        localMessageEntity2 = null;
        localMessageEntity3 = null;
        break;
        if (a(paramMessageEntity, localMessageEntity2, paramMessageCallEntity))
        {
          bool10 = true;
          paramMessageEntity = localMessageEntity2;
          break label278;
        }
        if (a(paramh, paramMessageEntity, paramMember))
          return new f(paramh, paramMessageEntity, true);
        a(paramMessageEntity, paramm);
        f localf = b(paramh, paramMessageEntity);
        if (localf != null)
          return localf;
        boolean bool9 = this.c.a(paramMessageEntity);
        a(paramh, paramm, paramMessageEntity, false);
        bool10 = bool9;
        break label278;
      }
      label682: bool7 = bool5;
    }
  }

  private f a(com.viber.voip.model.entity.h paramh, MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isOutgoing()) && (paramMessageEntity.getMessageInfo().getTechInfo() != null) && (paramMessageEntity.getMessageInfo().getTechInfo().getSeq() > 0) && (this.c.a(paramMessageEntity.getMessageInfo().getTechInfo().getSeq(), paramMessageEntity.getGroupId())));
    for (int n = 1; n != 0; n = 0)
    {
      paramMessageEntity.setMessageSeq(paramMessageEntity.getMessageInfo().getTechInfo().getSeq());
      return new f(false, false, paramh, null, paramMessageEntity, true, true);
    }
    MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
    if (localMsgInfo.getTechInfo() != null)
    {
      localMsgInfo.setTechInfo(null);
      JSONObject localJSONObject = com.viber.voip.flatbuffers.b.e.a().b().b(paramMessageEntity.getRawMessageInfo());
      if (localJSONObject != null)
      {
        localJSONObject.remove("tech_info");
        paramMessageEntity.setRawMessageInfo(localJSONObject.toString());
      }
    }
    if ((paramMessageEntity.isSyncedMessage()) && (!paramMessageEntity.isPollQuestionMessage()))
    {
      boolean bool = this.c.a(paramMessageEntity.getMessageToken(), this.f.getRegistrationValues().l());
      int i1 = this.c.j(paramMessageEntity.getMessageToken());
      paramMessageEntity.setExtraFlags(av.a(paramMessageEntity.getExtraFlags(), 12, bool));
      paramMessageEntity.setLikesCount(i1);
    }
    if (0 != 0);
    return null;
  }

  private com.viber.voip.model.entity.h a(int paramInt1, long paramLong1, long paramLong2, String paramString1, int paramInt2, int paramInt3, Uri paramUri, PublicAccount paramPublicAccount, int paramInt4, String paramString2, d paramd)
  {
    com.viber.voip.model.entity.h localh = new com.viber.voip.model.entity.h();
    localh.b(paramString1);
    localh.e(paramLong2);
    localh.a(paramInt1);
    localh.b(paramInt2);
    localh.c(paramInt3);
    localh.a(paramUri);
    localh.d(com.viber.voip.backgrounds.m.a(this.b, paramInt1, null));
    localh.h(paramString2);
    if (localh.b())
    {
      localh.a(paramLong1);
      localh.e(1);
    }
    if (localh.g())
      localh.g(28);
    int n;
    com.viber.voip.apps.b localb;
    if (localh.g())
    {
      if (paramd.g)
      {
        n = 1;
        localh.f(n);
      }
    }
    else
    {
      if (!com.viber.voip.messages.m.i(paramInt2))
        break label459;
      localh.g(0);
      localh.g(4);
      localb = this.f.getAppsController().a(paramInt2);
      if (localb != null)
        break label423;
      localh.g(18);
      label178: localh.a(10, true);
      localh.a(14, paramd.d);
      localh.a(9, paramd.a);
      localh.a(19, paramd.c);
      localh.a(24, paramd.e);
      localh.a(35, paramd.h);
      localh.a(6, paramd.f);
      localh.a(36, paramd.f);
      localh.a(38, paramd.f);
      if (paramd.f)
      {
        localh.f(1);
        localh.a(33, true);
      }
      if ((!localh.a()) || (localh.G()) || (localh.D()))
        break label519;
      localh.g(32);
    }
    while (true)
    {
      if (!da.a(paramString2))
      {
        localh.g(34);
        localh.i("vln_" + paramString2);
        localh.m(1);
        if (d.bh.c.d() == 1)
          d.bh.c.a(2);
      }
      if (paramd.e)
        localh.l(paramInt4);
      return localh;
      n = 0;
      break;
      label423: if (localb.l())
        localh.g(13);
      this.g.getMessagesManager().w().a(localh);
      break label178;
      label459: boolean bool1;
      if ((paramd.c) && (paramPublicAccount == null))
      {
        bool1 = true;
        label475: localh.a(18, bool1);
        if (paramd.a)
          break label513;
      }
      label513: for (boolean bool2 = true; ; bool2 = false)
      {
        localh.a(10, bool2);
        break;
        bool1 = false;
        break label475;
      }
      label519: localh.g(11);
    }
  }

  private com.viber.voip.model.entity.h a(int paramInt1, long paramLong1, long paramLong2, String paramString, int paramInt2, Uri paramUri, int paramInt3, d paramd)
  {
    return a(paramInt1, paramLong1, paramLong2, paramString, 0, paramInt2, paramUri, null, paramInt3, null, paramd);
  }

  private com.viber.voip.model.entity.h a(MessageEntity paramMessageEntity, String paramString1, String paramString2, String paramString3)
  {
    String str2;
    com.viber.voip.model.entity.h localh;
    if (this.l != null)
    {
      str2 = f.a(paramMessageEntity, paramString3);
      localh = this.l.a(str2);
    }
    for (String str1 = str2; ; str1 = null)
    {
      if (localh == null)
      {
        if (!paramMessageEntity.isBroadcastList())
          break label81;
        localh = this.c.f(paramMessageEntity.getConversationId());
      }
      while (true)
      {
        if ((this.l != null) && (localh != null))
          this.l.a(str1, localh);
        return localh;
        label81: if (paramMessageEntity.isGroupBehavior())
        {
          localh = this.c.b(paramMessageEntity.getGroupId());
        }
        else if (paramMessageEntity.isInviteFromCommunity())
        {
          localh = this.c.b(paramMessageEntity.getMessageInfo().getInviteCommunityInfo().getGroupId());
        }
        else if (paramMessageEntity.isVlnMessage())
        {
          localh = this.c.a(paramString1, paramString3);
          if ((localh != null) && (!localh.U()) && (!localh.ae()))
          {
            l(localh.getId(), true);
            if (d.bh.c.d() == 1)
              d.bh.c.a(2);
          }
        }
        else
        {
          localh = this.c.a(paramMessageEntity.getMemberId(), paramString1, paramString2, paramMessageEntity.isSecretMessage());
        }
      }
      localh = null;
    }
  }

  private com.viber.voip.model.entity.h a(com.viber.voip.model.entity.h paramh, Map<Long, com.viber.voip.model.entity.h> paramMap)
  {
    com.viber.voip.model.entity.h localh = null;
    if (paramh != null)
    {
      boolean bool = com.viber.voip.util.u.a(paramMap);
      localh = null;
      if (!bool)
        localh = (com.viber.voip.model.entity.h)paramMap.get(Long.valueOf(paramh.getId()));
    }
    if (localh != null)
      paramh = localh;
    return paramh;
  }

  private com.viber.voip.model.entity.m a(Member paramMember, int paramInt1, int paramInt2, boolean paramBoolean, g.a parama)
  {
    return a(paramMember, paramInt1, null, false, paramInt2, paramBoolean, parama);
  }

  private com.viber.voip.model.entity.m a(Member paramMember, int paramInt1, PublicAccount paramPublicAccount, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, g.a parama)
  {
    f.c localc = new f.c(paramMember.getId(), paramInt2);
    f localf = this.l;
    com.viber.voip.model.entity.m localm = null;
    if (localf != null)
      localm = this.l.a(localc);
    if (localm == null)
    {
      localm = this.i.a(paramMember, paramInt1, paramPublicAccount, paramBoolean1, paramInt2, paramBoolean2, parama);
      if ((this.l != null) && (localm != null))
      {
        this.l.a(localc, localm);
        this.l.a(localc, Long.valueOf(localm.getId()));
      }
    }
    return localm;
  }

  private com.viber.voip.model.entity.m a(MessageEntity paramMessageEntity, Member paramMember, int paramInt, g.a parama)
  {
    if (paramMessageEntity.isOutgoing())
      if (this.l == null)
        break label377;
    label377: for (com.viber.voip.model.entity.m localm1 = this.l.a(); ; localm1 = null)
    {
      if (localm1 == null)
      {
        localm1 = this.i.b();
        if (this.l != null)
          this.l.a(localm1);
      }
      while (true)
      {
        return localm1;
        int n = cd.j(paramMessageEntity.getConversationType());
        f.c localc = new f.c(paramMessageEntity.getMemberId(), n);
        if (this.l != null);
        for (localm1 = this.l.a(localc); localm1 == null; localm1 = null)
        {
          String str2;
          String str1;
          if (paramMessageEntity.isRoleFollower())
            if (com.viber.voip.messages.m.b(paramMessageEntity.getConversationType()))
            {
              str2 = paramMember.getId();
              str1 = null;
            }
          for (Member localMember = new Member(paramMember.getId(), paramMember.getPhoneNumber(), paramMember.getPhotoUri(), paramMember.getViberName(), paramMember.getViberId(), str1, str2); ; localMember = paramMember)
          {
            com.viber.voip.model.entity.m localm2 = this.i.a(localMember, paramInt, null, false, n, paramMessageEntity.isFromBackup(), parama);
            if (this.l != null)
            {
              this.l.a(localc, localm2);
              this.l.a(localc, Long.valueOf(localm2.getId()));
            }
            if ((!da.a(localMember.getViberName())) && (!localMember.getViberName().equals(localm2.getViberName())) && (localm2.n() < paramMessageEntity.getDate()))
              com.viber.voip.messages.d.c.c().a(localm2, new Member(localMember.getId(), null, null, localMember.getViberName(), null));
            if ((!dk.a(localMember.getPhotoUri(), localm2.f())) && (localm2.n() < paramMessageEntity.getDate()))
              com.viber.voip.messages.d.c.c().a(localm2, new Member(localMember.getId(), null, localMember.getPhotoUri(), null, null));
            return localm2;
            str1 = paramMember.getId();
            str2 = null;
            break;
          }
        }
      }
    }
  }

  private r a(PublicAccount paramPublicAccount, boolean paramBoolean)
  {
    boolean bool = paramPublicAccount.getGroupID() < 0L;
    r localr = null;
    if (bool)
      localr = this.c.d(paramPublicAccount.getGroupID());
    if ((localr == null) && (paramBoolean))
      localr = this.c.a(paramPublicAccount.getPublicAccountId());
    if (localr == null)
    {
      localr = PublicAccountEntityHelper.createEntity(new r(), paramPublicAccount);
      this.c.a(localr);
    }
    return localr;
  }

  private Long a(f.d paramd)
  {
    if (this.l != null)
      return this.l.a(paramd);
    return null;
  }

  private String a(af paramaf, boolean paramBoolean)
  {
    if (paramBoolean)
      return paramaf.k();
    return paramaf.l();
  }

  private void a(long paramLong1, String paramString, long paramLong2)
  {
    try
    {
      a(aa.f(), paramLong1, paramString, paramLong2);
      return;
    }
    catch (SQLException localSQLException)
    {
    }
  }

  private void a(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("extra_mime", Integer.valueOf(1007));
    localContentValues.put("send_type", Integer.valueOf(0));
    if (paramBoolean)
    {
      com.viber.provider.b localb2 = aa.f();
      String[] arrayOfString2 = new String[2];
      arrayOfString2[0] = String.valueOf(paramLong1);
      arrayOfString2[1] = String.valueOf(paramLong2);
      localb2.a("messages", localContentValues, "group_id=? AND (send_type=1) AND extra_mime<>1007 AND token<=?", arrayOfString2);
      return;
    }
    com.viber.provider.b localb1 = aa.f();
    String[] arrayOfString1 = new String[3];
    arrayOfString1[0] = String.valueOf(paramLong1);
    arrayOfString1[1] = paramString;
    arrayOfString1[2] = String.valueOf(paramLong2);
    localb1.a("messages", localContentValues, "group_id=? AND user_id=?  AND send_type<>1 AND extra_mime<>1007 AND token<=?", arrayOfString1);
  }

  private void a(com.viber.provider.b paramb, long paramLong1, String paramString, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("group_id", Long.valueOf(paramLong1));
    localContentValues.put("participant_encrypted_number", paramString);
    localContentValues.put("last_message_token", Long.valueOf(paramLong2));
    paramb.b("group_delete_all_from_participant", null, localContentValues);
  }

  private void a(f.d paramd, Long paramLong)
  {
    if (this.l != null)
      this.l.a(paramd, paramLong);
  }

  private void a(MessageEntity paramMessageEntity1, MessageEntity paramMessageEntity2)
  {
    if (paramMessageEntity1.isPublicGroupBehavior())
    {
      paramMessageEntity1.setOrderKey(paramMessageEntity2.getMessageGlobalId());
      paramMessageEntity1.setMessageGlobalId(paramMessageEntity2.getMessageGlobalId());
      return;
    }
    if (paramMessageEntity1.isBroadcastList())
    {
      paramMessageEntity1.setOrderKey(paramMessageEntity2.getId());
      return;
    }
    if (paramMessageEntity1.isOneToOneChatWithPa())
    {
      paramMessageEntity1.setOrderKey(paramMessageEntity1.getDate());
      return;
    }
    if (paramMessageEntity2.getMessageToken() > 0L);
    for (long l1 = paramMessageEntity2.getMessageToken(); ; l1 = paramMessageEntity2.getOrderKey())
    {
      paramMessageEntity1.setOrderKey(l1);
      return;
    }
  }

  private void a(MessageEntity paramMessageEntity, com.viber.voip.model.entity.h paramh)
  {
    if ((this.l != null) && (paramh != null))
    {
      String str = f.a(paramMessageEntity, paramh.an());
      this.l.a(str, paramh);
    }
  }

  private void a(MessageEntity paramMessageEntity, com.viber.voip.model.entity.m paramm)
  {
    int n = 1;
    if ((paramMessageEntity.isFromBackup()) || (!paramMessageEntity.isEditMessage()))
      return;
    MsgInfo localMsgInfo1 = paramMessageEntity.getMessageInfo();
    Edit localEdit1 = localMsgInfo1.getEdit();
    MessageEntity localMessageEntity1 = this.c.k(localEdit1.getToken());
    MsgInfo localMsgInfo2;
    Edit localEdit2;
    int i2;
    boolean bool2;
    label175: label190: label254: Edit localEdit3;
    if (localMessageEntity1 != null)
    {
      localMsgInfo2 = localMessageEntity1.getMessageInfo();
      localEdit2 = localMsgInfo2.getEdit();
      if ((localEdit2 == null) || (paramMessageEntity.isToSend()) || (paramMessageEntity.getMessageToken() > localEdit2.getEditedWithToken()))
      {
        i2 = n;
        String str = localMessageEntity1.getMemberId();
        bool2 = paramMessageEntity.getMemberId().equals(str);
        if ((!bool2) && (paramMessageEntity.isOneToOneType()) && (localMessageEntity1.isOneToOneType()) && (paramMessageEntity.isIncoming()) && (localMessageEntity1.isIncoming()) && (paramm != null))
        {
          if ((!str.equals(paramm.a())) && (!str.equals(paramm.b())))
            break label451;
          bool2 = n;
        }
        if ((!paramMessageEntity.isOutgoing()) || (!localMessageEntity1.isOutgoing()))
          break label457;
        if ((i2 != 0) && (com.viber.voip.messages.m.k(localMessageEntity1.getMimeType())) && (paramMessageEntity.getType() == localMessageEntity1.getType()) && ((bool2) || (n != 0)))
        {
          if (!localMessageEntity1.isImage())
            break label474;
          if (!paramMessageEntity.isUrlMessage())
            break label462;
          localMessageEntity1.setDescription(paramMessageEntity.getMessageInfo().getText());
          if (localEdit2 != null)
            break label634;
          localEdit3 = new Edit();
          localMsgInfo2.setEdit(localEdit3);
        }
      }
    }
    while (true)
    {
      localEdit3.setEditedWithToken(paramMessageEntity.getMessageToken());
      localMsgInfo2.setTextMetaInfo(localMsgInfo1.getTextMetaInfo());
      localMsgInfo2.setUrl(localMsgInfo1.getUrl());
      localMsgInfo2.setText(localMsgInfo1.getText());
      localMsgInfo2.setTitle(localMsgInfo1.getTitle());
      localMsgInfo2.setThumbnailUrl(localMsgInfo1.getThumbnailUrl());
      localMsgInfo2.setUrlType(localMsgInfo1.getUrlType());
      localMsgInfo2.setContentType(localMsgInfo1.getContentType());
      localMsgInfo2.setContentLength(localMsgInfo1.getContentLength());
      localMsgInfo2.setThumbnailContentType(localMsgInfo1.getThumbnailContentType());
      localMessageEntity1.setSpans(paramMessageEntity.getSpans());
      localMessageEntity1.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo2));
      localMessageEntity1.addExtraFlag(37);
      this.c.b(localMessageEntity1);
      this.m.post(new j.a(localMessageEntity1));
      com.viber.voip.messages.m.a(this.c, paramMessageEntity);
      return;
      i2 = 0;
      break;
      label451: bool2 = false;
      break label175;
      label457: n = 0;
      break label190;
      label462: localMessageEntity1.setDescription(paramMessageEntity.getBody());
      break label254;
      label474: localMessageEntity1.setMimeType(paramMessageEntity.getMimeType());
      localMessageEntity1.setBody(paramMessageEntity.getBody());
      localMessageEntity1.removeExtraFlag(5);
      localMessageEntity1.setDescription("");
      break label254;
      localEdit1.setEditedWithToken(paramMessageEntity.getMessageToken());
      MessageEntity localMessageEntity2 = new com.viber.voip.messages.controller.c.b(paramMessageEntity).a(paramMessageEntity);
      localMessageEntity2.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo1));
      localMessageEntity2.setMessageToken(localEdit1.getToken());
      localMessageEntity2.setType(paramMessageEntity.getType());
      localMessageEntity2.setStatus(paramMessageEntity.getStatus());
      boolean bool1 = paramMessageEntity.isOutgoing();
      int i1 = 0;
      if (bool1);
      while (true)
      {
        localMessageEntity2.setUnread(i1);
        localMessageEntity2.addExtraFlag(37);
        localMessageEntity2.addExtraFlag(22);
        this.c.a(localMessageEntity2);
        break;
        i1 = n;
      }
      label634: localEdit3 = localEdit2;
    }
  }

  private void a(MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    PublicAccountReplyData localPublicAccountReplyData;
    PublicAccountInfo localPublicAccountInfo;
    if ((paramBoolean) && (!paramMessageEntity.isToSend()))
    {
      com.viber.voip.messages.m.e(paramMessageEntity);
      if (!"no_sp".equals(paramMessageEntity.getSpans()))
        com.viber.voip.messages.m.b(paramMessageEntity);
      if ((paramMessageEntity.isOutgoing()) && ((paramMessageEntity.isPublicAccount()) || (paramMessageEntity.isTextMessage())))
      {
        localPublicAccountReplyData = paramMessageEntity.getMessageInfo().getPublicAccountReplyData();
        localPublicAccountInfo = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo().getPublicAccountInfo();
        if (localPublicAccountInfo == null)
          break label275;
      }
    }
    label275: for (String str = localPublicAccountInfo.getPaId(); ; str = null)
    {
      if (localPublicAccountReplyData != null)
        com.viber.voip.publicaccount.d.e.a(paramMessageEntity, str, localPublicAccountReplyData, this.g.getChatExtensionConfig());
      if (paramMessageEntity.getMessageSeq() < 0)
        paramMessageEntity.setMessageSeq(this.h.getPhoneController().generateSequence());
      if ((paramMessageEntity.hasQuote()) && (com.viber.voip.flatbuffers.b.c.a(paramMessageEntity.getRawQuotedMessageData())))
        com.viber.voip.messages.m.b(paramMessageEntity, this.c);
      if (paramMessageEntity.isPinMessage())
        com.viber.voip.messages.m.a(paramMessageEntity, this.c);
      if (paramMessageEntity.isFile())
        com.viber.voip.messages.m.f(paramMessageEntity);
      if (paramMessageEntity.isVideo())
        com.viber.voip.messages.m.g(paramMessageEntity);
      if ((paramBoolean) && (paramMessageEntity.isIncoming()))
        com.viber.voip.messages.m.a(paramMessageEntity, this.f.getRegistrationValues());
      if ((paramBoolean) && (paramMessageEntity.isPublicGroupBehavior()) && (paramMessageEntity.isPollOptionMessage()))
        com.viber.voip.messages.m.a(this.c, paramMessageEntity);
      if ((paramBoolean) && (paramMessageEntity.isCommunityType()) && (paramMessageEntity.isDeletePinMessage()))
      {
        if (paramMessageEntity.isToSend())
          break;
        com.viber.voip.messages.m.a(this.c, paramMessageEntity);
      }
      return;
    }
    paramMessageEntity.addExtraFlag(22);
  }

  private void a(com.viber.voip.model.entity.h paramh, int paramInt)
  {
    if (com.viber.voip.messages.m.b(paramh.j()))
      com.viber.voip.messages.m.a(paramh, -1, paramInt);
  }

  private boolean a(long paramLong1, long paramLong2, MessageCallEntity paramMessageCallEntity)
  {
    if (paramMessageCallEntity != null)
    {
      paramMessageCallEntity.setConversationId(paramLong1);
      paramMessageCallEntity.setMessageId(paramLong2);
      return this.c.a(paramMessageCallEntity);
    }
    return false;
  }

  private boolean a(MessageEntity paramMessageEntity1, MessageEntity paramMessageEntity2, MessageCallEntity paramMessageCallEntity)
  {
    if ((paramMessageEntity2 != null) && (paramMessageEntity2.isCall()) && (ah.a(paramMessageEntity1, paramMessageEntity2)) && (!ae.a(paramMessageEntity2.getDate(), paramMessageEntity1.getDate())) && ("has_description".equals(paramMessageEntity2.getBucket())) && (!paramMessageEntity2.isInvisibleMessage()))
    {
      paramMessageEntity2.setOrderKey(paramMessageEntity1.getOrderKey());
      paramMessageEntity2.setCount(1 + paramMessageEntity2.getCount());
      paramMessageEntity2.setDuration(paramMessageEntity1.getDuration());
      paramMessageEntity2.removeExtraFlag(33);
      if (paramMessageCallEntity.isAnswerredOnAnotherDevice())
        if (this.c.S(paramMessageEntity2.getId()))
          paramMessageEntity2.setBody(paramMessageEntity1.getBody());
      while (true)
      {
        if (paramMessageEntity1.getMessageToken() > paramMessageEntity2.getMessageToken())
        {
          paramMessageEntity2.setDate(paramMessageEntity1.getDate());
          paramMessageEntity2.setMessageToken(paramMessageEntity1.getMessageToken());
          paramMessageEntity2.setMessageSeq(paramMessageEntity1.getMessageSeq());
        }
        if ((paramMessageEntity1.getUnread() > 0) && (k(paramMessageEntity1)))
          paramMessageEntity2.setUnread(1 + paramMessageEntity2.getUnread());
        this.c.b(paramMessageEntity2);
        return true;
        String str2;
        if (paramMessageCallEntity.isTypeViberGeneralVideo())
          str2 = "incoming_call_video";
        while (true)
        {
          paramMessageEntity2.setBody(str2);
          break;
          if (paramMessageCallEntity.isTypeViberGroup())
            str2 = "incoming_call_group";
          else
            str2 = "incoming_call";
        }
        if (paramMessageCallEntity.isTransferredIn())
        {
          if (this.c.T(paramMessageEntity2.getId()))
          {
            paramMessageEntity2.setBody(paramMessageEntity1.getBody());
          }
          else
          {
            String str1;
            if (paramMessageCallEntity.isTypeViberGeneralVideo())
              str1 = "incoming_call_video";
            while (true)
            {
              paramMessageEntity2.setBody(str1);
              break;
              if (paramMessageCallEntity.isTypeViberGroup())
                str1 = "incoming_call_group";
              else
                str1 = "incoming_call";
            }
          }
        }
        else
          paramMessageEntity2.setBody(paramMessageEntity1.getBody());
      }
    }
    return false;
  }

  private boolean a(MessageEntity paramMessageEntity, com.viber.voip.model.entity.h paramh, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramh.a()) && (!paramh.G()) && (!paramh.i(5)) && (!paramh.i(7)));
    for (boolean bool = a(paramh, paramLong); ; bool = false)
    {
      if (!paramMessageEntity.isGroupBehavior())
      {
        if ((!paramMessageEntity.isOutgoing()) || (paramh.i(5)))
          break label139;
        paramh.g(5);
      }
      for (bool = true; ; bool = true)
      {
        label139: 
        do
        {
          if (paramBoolean1)
          {
            paramh.h(21);
            a(paramh.getId());
            bool = true;
          }
          if (paramBoolean2)
          {
            paramh.h(25);
            bool = true;
          }
          if ((paramh.T()) && (!paramh.as()) && (!paramMessageEntity.isCall()))
          {
            paramh.a(33, false);
            bool = true;
          }
          return bool;
        }
        while ((!paramMessageEntity.isIncoming()) || (paramh.i(7)));
        paramh.g(7);
      }
    }
  }

  private boolean a(com.viber.voip.model.entity.h paramh, long paramLong)
  {
    ak localak = this.i;
    af localaf = this.f.getRegistrationValues();
    Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(paramh.getId());
    if (localak.a(paramLong, localaf, arrayOfLong))
    {
      paramh.a(9, true);
      paramh.a(10, false);
      return true;
    }
    return false;
  }

  private boolean a(com.viber.voip.model.entity.h paramh, MessageEntity paramMessageEntity, Member paramMember)
  {
    if ((paramMessageEntity.isCommunityType()) && (!paramMessageEntity.isSyncedMessage()) && (!paramMessageEntity.isAggregatedMessage()) && (!paramMessageEntity.isPinMessage()) && (!paramMessageEntity.isToSend()) && (!e().c(paramh.getId())))
    {
      r localr = this.c.d(paramMessageEntity.getGroupId());
      int n;
      if (localr != null)
      {
        n = localr.v();
        if ((n <= 0) || (n + 1 >= paramMessageEntity.getMessageGlobalId()))
          break label314;
        if (!paramMessageEntity.isTextMessage())
          break label275;
        localr.l(paramMessageEntity.getBody());
        label106: localr.h(paramMessageEntity.getMessageGlobalId());
        localr.m(paramMember.getEncryptedMemberId());
        localr.n(paramMember.getViberName());
        if (paramMember.getPhotoUri() == null)
          break label308;
      }
      label275: label308: for (String str = paramMember.getPhotoUri().getLastPathSegment(); ; str = null)
      {
        localr.o(str);
        localr.m(com.viber.voip.messages.l.b(paramMessageEntity.getMimeType()));
        this.c.b(localr);
        if (paramh.A() < paramMessageEntity.getDate())
        {
          this.c.a("conversations", paramh.getId(), "date", Long.valueOf(paramMessageEntity.getDate()));
          if (paramh.as())
          {
            this.c.a(Collections.singleton(Long.valueOf(paramh.getId())), 38, false);
            if (paramh.T())
              paramh.a(33, false);
          }
        }
        this.c.d(paramMessageEntity.getConversationType());
        return true;
        n = 0;
        break;
        if (paramMessageEntity.isUrlMessage())
        {
          localr.l(paramMessageEntity.getMessageInfo().getUrl());
          break label106;
        }
        localr.l("");
        break label106;
      }
    }
    label314: return false;
  }

  private f b(com.viber.voip.model.entity.h paramh, MessageEntity paramMessageEntity)
  {
    long l1;
    long l4;
    Object localObject;
    MessageEntity localMessageEntity2;
    if ((paramMessageEntity.isCommunityType()) && (i(paramMessageEntity)) && (paramMessageEntity.isSyncedMessage()) && (paramMessageEntity.getMessageGlobalId() > 0))
    {
      l1 = paramMessageEntity.getOrderKey();
      long l2 = l1 - 1L;
      long l3 = 1L + l1;
      l4 = paramh.getId();
      Iterator localIterator = this.c.a(l4, new long[] { l1, l3, l2 }).iterator();
      for (localObject = null; ; localObject = localMessageEntity2)
      {
        if (!localIterator.hasNext())
          break label378;
        localMessageEntity2 = (MessageEntity)localIterator.next();
        long l6 = localMessageEntity2.getOrderKey();
        if (l6 == l1)
          return null;
        if (l6 <= l1)
          break;
      }
    }
    label372: label378: for (MessageEntity localMessageEntity1 = localMessageEntity2; ; localMessageEntity1 = null)
    {
      if ((localMessageEntity1 != null) && (i(localMessageEntity1)));
      ab.b localb;
      long l5;
      for (int n = 1; ; n = 0)
      {
        localb = this.c.j(l4, l1);
        if (localb == null)
          break label372;
        l5 = 1L + (localb.a() - com.viber.voip.messages.m.l(localb.c()));
        if (l1 < l5)
          break;
        return new f(false, false, paramh, null, paramMessageEntity, true);
      }
      int i1;
      if (((localObject == null) || (i(localObject))) && (l5 - 1L == l1))
        i1 = 1;
      while (true)
        if ((i1 != 0) && (n != 0))
        {
          this.c.a(new bu(this, localb, localMessageEntity1));
          return new f(false, false, paramh, null, paramMessageEntity, true);
          i1 = 0;
        }
        else
        {
          if (n != 0)
          {
            paramMessageEntity.setCount(1 + com.viber.voip.messages.m.l(localMessageEntity1.getCount()));
            this.c.I(localMessageEntity1.getId());
          }
          while (i1 == 0)
            return null;
          this.c.c(localb.b(), 1 + com.viber.voip.messages.m.l(localb.c()));
          return new f(false, false, paramh, null, paramMessageEntity, true);
          i1 = 0;
        }
    }
  }

  private MessageEntity b(MessageEntity paramMessageEntity1, MessageEntity paramMessageEntity2)
  {
    MessageEntity localMessageEntity;
    if ((paramMessageEntity2 != null) && (paramMessageEntity2.isEditedMessage()) && (paramMessageEntity2.isInvisibleMessage()))
    {
      paramMessageEntity2.removeExtraFlag(22);
      paramMessageEntity2.setDate(paramMessageEntity1.getDate());
      if (paramMessageEntity1.isImage())
      {
        localMessageEntity = new com.viber.voip.messages.controller.c.b(paramMessageEntity2).a(paramMessageEntity1);
        localMessageEntity.setExtraFlags(paramMessageEntity2.getExtraFlags());
        localMessageEntity.setStatus(paramMessageEntity2.getStatus());
        localMessageEntity.setMemberId(paramMessageEntity2.getMemberId());
        localMessageEntity.setParticipantId(paramMessageEntity2.getParticipantId());
        localMessageEntity.setType(paramMessageEntity2.getType());
        if (!paramMessageEntity2.isUrlMessage())
          break label190;
        localMessageEntity.setDescription(paramMessageEntity2.getMessageInfo().getText());
      }
    }
    while (true)
    {
      localMessageEntity.setSpans(paramMessageEntity2.getSpans());
      localMessageEntity.setId(paramMessageEntity2.getId());
      localMessageEntity.setUnread(paramMessageEntity2.getUnread());
      localMessageEntity.setMessageToken(paramMessageEntity2.getMessageToken());
      paramMessageEntity2 = localMessageEntity;
      a(paramMessageEntity2, paramMessageEntity1);
      this.c.b(paramMessageEntity2);
      this.d.a(paramMessageEntity2.getConversationId(), paramMessageEntity2.getMessageToken(), false);
      return paramMessageEntity2;
      label190: localMessageEntity.setDescription(paramMessageEntity2.getBody());
    }
  }

  private com.viber.voip.model.entity.m b(MessageEntity paramMessageEntity, Member paramMember, int paramInt, g.a parama)
  {
    if (paramMessageEntity.isOutgoing())
      return a();
    return a(paramMember, paramInt, cd.j(paramMessageEntity.getConversationType()), paramMessageEntity.isFromBackup(), parama);
  }

  private void b(MessageEntity paramMessageEntity, com.viber.voip.model.entity.h paramh)
  {
    if (!paramh.G());
    PublicAccountMsgInfo localPublicAccountMsgInfo;
    BotReplyConfig localBotReplyConfig;
    do
    {
      do
        return;
      while ((!paramMessageEntity.isPublicAccount()) || (!paramMessageEntity.isIncoming()));
      localPublicAccountMsgInfo = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo();
      String str1 = localPublicAccountMsgInfo.getChatBackground();
      if (!da.a(str1))
      {
        long l1 = paramh.getId();
        this.c.h(l1, str1);
        this.d.b(l1);
      }
      if (!localPublicAccountMsgInfo.hasBotReply())
      {
        a(paramh.getId(), paramh.j());
        return;
      }
      localBotReplyConfig = localPublicAccountMsgInfo.getKeyboard();
      if (localBotReplyConfig == null)
        break;
    }
    while (!b(paramh.m(), paramMessageEntity.getDate()));
    localBotReplyConfig.setKeyboardDate(paramMessageEntity.getDate());
    localPublicAccountMsgInfo.setKeyboard(localBotReplyConfig);
    String str2 = localBotReplyConfig.toJson();
    paramh.a(str2);
    this.c.e(paramh.getId(), str2);
  }

  private boolean b(MessageEntity paramMessageEntity, com.viber.voip.model.entity.m paramm)
  {
    return (paramMessageEntity != null) && (paramMessageEntity.isIncomingOneToOneBroadcast()) && ((paramm == null) || (paramm.i() <= 0L));
  }

  private boolean b(String paramString, long paramLong)
  {
    if (da.a(paramString));
    BotReplyConfig localBotReplyConfig;
    do
    {
      return true;
      localBotReplyConfig = com.viber.voip.publicaccount.d.e.a(paramString);
    }
    while ((localBotReplyConfig == null) || (localBotReplyConfig.getKeyboardDate() < paramLong));
    return false;
  }

  private void c(MessageEntity paramMessageEntity, com.viber.voip.model.entity.h paramh)
  {
    if ((paramMessageEntity.isPublicGroupBehavior()) && (cd.f(paramh.p())))
      paramMessageEntity.addExtraFlag(4);
    if ((paramMessageEntity.isToSend()) && (paramh.Q()))
      paramMessageEntity.addExtraFlag(30);
    if ((paramMessageEntity.isToSend()) && (paramh.P()))
      paramMessageEntity.addExtraFlag(26);
    if ((!paramMessageEntity.isFromBackup()) && ((paramMessageEntity.isEditMessage()) || (paramMessageEntity.isPollOptionMessage())) && ((paramMessageEntity.isToSend()) || (!paramMessageEntity.isPublicGroupBehavior())))
    {
      paramMessageEntity.addExtraFlag(22);
      paramMessageEntity.setUnread(0);
    }
    if ((!paramMessageEntity.isFromBackup()) && (paramMessageEntity.isPollQuestionMessage()))
      paramMessageEntity.addExtraFlag(38);
    if ((!paramMessageEntity.isFromBackup()) && (paramMessageEntity.isPollOptionMessage()))
      paramMessageEntity.addExtraFlag(39);
    if (((bn)this.e.get()).a(paramMessageEntity))
    {
      paramMessageEntity.addExtraFlag(22);
      paramMessageEntity.setExtraStatus(13);
    }
    if (paramh.G())
    {
      com.viber.voip.messages.m.a(paramMessageEntity, paramMessageEntity.getMemberId());
      paramMessageEntity.addExtraFlag(20);
    }
    while (true)
    {
      if ((paramMessageEntity.isPublicAccount()) && ((paramh.c()) || ((paramh.a()) && (!paramh.G()))))
        paramMessageEntity.removeExtraFlag(20);
      return;
      if (paramh.F())
      {
        com.viber.voip.messages.m.a(paramMessageEntity, com.viber.voip.messages.m.j(paramh.l()));
        paramMessageEntity.addExtraFlag(16);
      }
      else if (paramh.I())
      {
        paramMessageEntity.addExtraFlag(17);
      }
    }
  }

  private Engine d()
  {
    if (this.h == null)
      this.h = this.g.getEngine(true);
    return this.h;
  }

  private f d(MessageEntity paramMessageEntity)
  {
    BotReplyConfig localBotReplyConfig;
    int n;
    if ((paramMessageEntity.isConvertedFromPublicAccountFormat()) && (!paramMessageEntity.isBroadcastList()))
    {
      localBotReplyConfig = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo().getKeyboard();
      if (localBotReplyConfig != null)
      {
        n = com.viber.voip.messages.m.a(localBotReplyConfig);
        switch (n)
        {
        case 1:
        default:
        case 2:
        case 0:
        }
      }
    }
    while (true)
    {
      return null;
      return new f(false, false, null, null, paramMessageEntity, true, n);
      PublicAccountInfo localPublicAccountInfo = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo().getPublicAccountInfo();
      if (localPublicAccountInfo != null)
        com.viber.voip.messages.controller.manager.o.a().a(localPublicAccountInfo.getPaId(), localBotReplyConfig);
    }
  }

  private com.viber.voip.messages.controller.manager.k e()
  {
    return this.g.getMessagesManager().a();
  }

  private void e(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isGroupBehavior()) || (!paramMessageEntity.isFromPublicAccount()));
    MessageEntity localMessageEntity;
    r localr;
    do
    {
      do
      {
        return;
        localMessageEntity = this.c.t(paramMessageEntity.getConversationId());
      }
      while (localMessageEntity == null);
      localr = this.c.e(paramMessageEntity.getConversationId());
    }
    while (localr == null);
    d().getCdrController().handleReportPA1On1MessageBotReplied(localr.b(), localr.P(), localr.Q(), localr.g(), new LocationInfo(localr.h(), localr.i()), Long.toString(paramMessageEntity.getMessageToken()), Long.toString(localMessageEntity.getMessageToken()), localMessageEntity.getDate(), (int)(paramMessageEntity.getDate() - localMessageEntity.getDate()));
  }

  private int f()
  {
    return this.g.getEngine(true).getPhoneController().generateSequence();
  }

  private void f(MessageEntity paramMessageEntity)
  {
    Uri localUri = Uri.parse(paramMessageEntity.getMediaUri());
    MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
    if (localMsgInfo == null)
      return;
    FileInfo localFileInfo = localMsgInfo.getFileInfo();
    long l1 = com.viber.voip.messages.extras.image.c.c(this.b, localUri, paramMessageEntity.getMimeType());
    if (paramMessageEntity.isWink())
      localFileInfo.setDurationMillis(l1);
    while (true)
    {
      paramMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
      paramMessageEntity.setDuration(l1);
      return;
      localFileInfo.setDuration(l1);
    }
  }

  private com.viber.voip.messages.controller.a.a g()
  {
    if (this.k == null)
      this.k = ViberApplication.getInstance().getMessagesManager().w();
    return this.k;
  }

  private boolean g(MessageEntity paramMessageEntity)
  {
    boolean bool1 = false;
    if (paramMessageEntity != null)
    {
      boolean bool2 = paramMessageEntity.isLocationMessage();
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = da.a(paramMessageEntity.getBucket());
        bool1 = false;
        if (bool3)
        {
          ViberApplication.getInstance().getLocationManager().a(2, paramMessageEntity.getLocation().getLatitude(), paramMessageEntity.getLocation().getLongitude(), false, new bt(paramMessageEntity));
          bool1 = true;
        }
      }
    }
    return bool1;
  }

  private com.viber.voip.model.entity.h h(long paramLong)
  {
    String str2;
    com.viber.voip.model.entity.h localh;
    if (this.l != null)
    {
      str2 = f.a(paramLong);
      localh = this.l.a(str2);
    }
    for (String str1 = str2; ; str1 = null)
    {
      if (localh == null)
      {
        localh = this.c.b(paramLong);
        if ((this.l != null) && (localh != null))
          this.l.a(str1, localh);
      }
      return localh;
      localh = null;
    }
  }

  private boolean h(final MessageEntity paramMessageEntity)
  {
    boolean bool1 = false;
    if (paramMessageEntity != null)
    {
      boolean bool2 = paramMessageEntity.isShareContactMessage();
      bool1 = false;
      if (bool2)
      {
        final ComposeDataContainer localComposeDataContainer = com.viber.voip.messages.conversation.ui.bu.a(paramMessageEntity.getRawMessageInfo());
        bool1 = false;
        if (localComposeDataContainer != null)
        {
          boolean bool3 = da.a(localComposeDataContainer.photoId);
          bool1 = false;
          if (bool3)
          {
            boolean bool4 = da.a(localComposeDataContainer.viberNumber);
            bool1 = false;
            if (!bool4)
            {
              ViberApplication.getInstance().getMessagesManager().e().b(localComposeDataContainer.selectedNumber, new ci.a()
              {
                public void onGetUserDetail(com.viber.voip.model.entity.m[] paramAnonymousArrayOfm)
                {
                  if (!da.a(paramAnonymousArrayOfm[0].e()))
                  {
                    String str = com.viber.voip.messages.conversation.ui.bu.a(paramMessageEntity.getBody(), localComposeDataContainer, paramAnonymousArrayOfm[0].e(), paramMessageEntity.isOutgoing());
                    if (bs.b(bs.this).l(paramMessageEntity.getId(), str) > 0)
                      bs.c(bs.this).a(paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken(), false);
                  }
                }

                public void onGetUserError()
                {
                }
              }
              , false);
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }

  private boolean i(MessageEntity paramMessageEntity)
  {
    return (paramMessageEntity.getMimeType() == 1007) && (!paramMessageEntity.isPoll()) && (!paramMessageEntity.isPollOption()) && (!paramMessageEntity.isPinMessage());
  }

  private int j(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isBroadcastList()) && (paramMessageEntity.getExtraStatus() == 3))
      return 3;
    return 0;
  }

  private boolean k(MessageEntity paramMessageEntity)
  {
    return (!ViberApplication.isTablet(null)) || (!paramMessageEntity.isVlnMessage());
  }

  public a a(com.viber.voip.model.entity.h paramh, String paramString, int paramInt1, int paramInt2)
  {
    com.viber.voip.model.entity.m localm = this.i.a(new Member(paramString), cd.j(paramh.j()));
    return new a(paramh, this.j.a(paramh.getId(), paramInt1, paramInt2, localm.getId()), localm);
  }

  public c a(boolean paramBoolean, long paramLong, String paramString, int paramInt)
  {
    com.viber.voip.model.entity.m localm = com.viber.voip.messages.d.c.c().c(paramString, cd.j(paramInt));
    if (!this.c.a(paramLong, paramString))
      return new c(true, false, null, localm, null);
    if (this.c.d(paramLong, paramString) > 0);
    MessageEntity localMessageEntity;
    for (boolean bool = true; ; bool = false)
    {
      localMessageEntity = null;
      if (!bool)
        break label158;
      localMessageEntity = this.c.k(paramLong);
      if (localMessageEntity != null)
        break;
      return new c(false, true, null, localm, null);
    }
    if (paramBoolean)
      localMessageEntity.setExtraFlags(av.b(localMessageEntity.getExtraFlags(), 12));
    localMessageEntity.setLikesCount(new UnsignedInt(localMessageEntity.getLikesCount()).decrement());
    com.viber.voip.messages.m.a(false, this.c, localMessageEntity);
    c(localMessageEntity);
    label158: return new c(false, bool, localMessageEntity, localm, null);
  }

  public f a(int paramInt1, long paramLong1, int paramInt2, Pair<String, Long> paramPair, PublicAccount paramPublicAccount, long paramLong2, e parame)
  {
    if (!com.viber.voip.messages.m.e(paramInt2))
      throw new IllegalArgumentException("New public group must be of type TYPE_PUBLIC_GROUP or TYPE_TRIAL_PUBLIC_GROUP or TYPE_COMMUNITY. Actual: " + paramInt2);
    boolean bool1;
    boolean bool2;
    label75: com.viber.voip.model.entity.h localh1;
    boolean bool3;
    label93: int n;
    boolean bool4;
    label125: com.viber.voip.model.entity.h localh2;
    r localr1;
    if ((parame.b) && (com.viber.voip.messages.m.a(paramInt2)))
    {
      bool1 = true;
      if ((!parame.d) || (!com.viber.voip.messages.m.b(paramInt2)))
        break label463;
      bool2 = true;
      localh1 = this.c.b(paramLong1);
      if (localh1 != null)
        break label469;
      bool3 = true;
      n = paramPublicAccount.getGroupRole();
      if (!bool3)
        break label488;
      bs.d.a locala = d.a().a(true);
      if (parame.e != null)
        break label475;
      bool4 = true;
      d locald = locala.g(bool4).a();
      com.viber.voip.model.entity.h localh3 = a(paramInt2, paramLong1, paramLong2, paramPublicAccount.getName(), n, paramPublicAccount.getIcon(), 0, locald);
      if (parame.c)
        a(localh3, n);
      this.c.a(localh3);
      com.viber.voip.analytics.g.a().c().g().b(String.valueOf(localh3.k()), localh3, ae.b());
      localh2 = localh3;
      this.m.post(new d.d(paramInt2));
      if ((!bool1) && (!com.viber.voip.messages.m.b(paramInt2)) && (!cd.f(n)))
      {
        this.j.a(localh2.getId(), localh2.p(), a());
        this.c.f(localh2.getId(), paramInt2);
      }
      localr1 = this.c.d(paramLong1);
      if (localr1 != null)
        break label664;
    }
    label645: label664: for (r localr2 = PublicAccountEntityHelper.createEntity(new r(), paramPublicAccount); ; localr2 = localr1)
    {
      localr2.b(bool1);
      if (paramPair != null)
      {
        localr2.k((String)paramPair.first);
        localr2.c(((Long)paramPair.second).longValue());
      }
      if (paramPublicAccount.getLastMessageId() != 0)
        localr2.n(paramPublicAccount.getLastMessageId());
      if (localr2.getId() > 0L)
        this.c.b(localr2);
      while (true)
      {
        if (parame.a)
          ViberApplication.getInstance().getMessagesManager().d().a(paramInt1, paramLong1, localr2.b(), paramPublicAccount.getRevision(), paramInt2, n);
        return new f(false, bool3, localh2, null, null, false);
        bool1 = false;
        break;
        label463: bool2 = false;
        break label75;
        label469: bool3 = false;
        break label93;
        label475: bool4 = parame.e.booleanValue();
        break label125;
        label488: localh1.h(6);
        if (parame.c)
          a(localh1, n);
        localh1.a(paramInt2);
        localh1.k(0);
        if ((parame.e != null) && (localh1.y() != parame.e.booleanValue()))
          if (!parame.e.booleanValue())
            break label645;
        for (int i2 = 1; ; i2 = 0)
        {
          localh1.f(i2);
          int i1 = localh1.p();
          localh1.c(n);
          localh1.a(36, bool2);
          this.c.b(localh1);
          if ((localh1.g()) && (cd.f(i1)) && (cd.b(localh1.p())))
            a(Collections.singletonList(localh1));
          localh2 = localh1;
          break;
        }
        this.c.a(localr2);
      }
    }
  }

  public f a(int paramInt1, long paramLong, int paramInt2, PublicAccount paramPublicAccount, e parame)
  {
    return a(paramInt1, paramLong, paramInt2, null, paramPublicAccount, System.currentTimeMillis(), parame);
  }

  @Deprecated
  public f a(long paramLong1, boolean paramBoolean1, String paramString, int paramInt, Uri paramUri, long paramLong2, boolean paramBoolean2, boolean paramBoolean3)
  {
    return a(paramLong1, paramBoolean1, paramString, paramInt, paramUri, paramLong2, paramBoolean2, ViberApplication.getInstance().getEngine(true).getSecureMessagesController().isGroupSecure(paramLong1), paramBoolean3);
  }

  public f a(long paramLong1, boolean paramBoolean1, String paramString, int paramInt, Uri paramUri, long paramLong2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    com.viber.voip.model.entity.h localh = a(1, paramLong1, paramLong2, paramString, paramInt, paramUri, 60, d.a().a(true).d(paramBoolean3).e(paramBoolean4).a());
    if (paramBoolean2)
      localh.h(11);
    if (this.c.a(localh))
      this.m.post(new d.d(localh.j()));
    com.viber.voip.model.entity.m localm = a();
    this.j.a(localh.getId(), localh.p(), localm);
    if (paramBoolean1)
    {
      int n = f();
      ViberApplication.getInstance().getMessagesManager().d().a(n, paramLong1);
    }
    return new f(false, true, localh, null, null, false);
  }

  public f a(CallEntity paramCallEntity, int paramInt, long paramLong, String paramString)
  {
    int n = 1;
    MessageCallEntity localMessageCallEntity = new MessageCallEntity(paramCallEntity);
    MessageEntity localMessageEntity = new MessageEntity();
    localMessageEntity.setMessageToken(paramCallEntity.getToken());
    localMessageEntity.setOrderKey(paramCallEntity.getToken());
    localMessageEntity.setDate(paramCallEntity.getDate());
    localMessageEntity.setCount(n);
    localMessageEntity.setFlag(paramInt);
    localMessageEntity.setExtraFlags(paramLong);
    localMessageEntity.setDuration(paramCallEntity.getDuration());
    localMessageEntity.setMimeType(1002);
    localMessageEntity.setStatus(2);
    int i1;
    if ((paramCallEntity.isMissed()) && ((paramInt & 0x40) == 0) && (k(localMessageEntity)))
      i1 = n;
    while (true)
    {
      int i2;
      label127: com.viber.provider.b localb;
      if (i1 != 0)
      {
        i2 = n;
        localMessageEntity.setUnread(i2);
        if ((paramCallEntity.isIncoming()) || (paramCallEntity.isMissed()))
          n = 0;
        localMessageEntity.setType(n);
        localMessageEntity.setMemberId(paramCallEntity.getMemberId());
        if (!paramCallEntity.isTypeViberOut())
          break label330;
        localMessageEntity.setBody("vo");
        label182: if (paramCallEntity.isTypeViberGroup())
          localMessageEntity.setDescription(paramCallEntity.getRawConferenceInfo());
        localMessageEntity.setExtraStatus(3);
        localMessageEntity.setBucket("has_description");
        localb = aa.f();
      }
      try
      {
        localb.a();
        f localf = a(localMessageEntity, localMessageCallEntity, paramString);
        localb.c();
        localb.b();
        if ((paramCallEntity.isMissed()) && (!localMessageEntity.isRead()) && (localf.f != null))
          ((bn)this.e.get()).a(localf.f, localf.g, localMessageEntity);
        return localf;
        i1 = 0;
        continue;
        i2 = 0;
        break label127;
        label330: if (paramCallEntity.isMissed())
        {
          String str4;
          if (paramCallEntity.isTypeViberVideo())
            str4 = "missed_call_video";
          while (true)
          {
            localMessageEntity.setBody(str4);
            break;
            if (paramCallEntity.isTypeViberGroup())
              str4 = "missed_call_group";
            else
              str4 = "missed_call";
          }
        }
        if (paramCallEntity.isAnswerredOnAnotherDevice())
        {
          if (localMessageCallEntity.isTypeViberGroup());
          for (String str3 = "answ_another_dev_group"; ; str3 = "answ_another_dev")
          {
            localMessageEntity.setBody(str3);
            break;
          }
        }
        if (paramCallEntity.isTransferredIn())
        {
          localMessageEntity.setBody("transferred");
          break label182;
        }
        if (paramCallEntity.isOutgoing())
        {
          if (paramCallEntity.isTypeViberVideo());
          for (String str2 = "outgoing_call_video"; ; str2 = "outgoing_call")
          {
            localMessageEntity.setBody(str2);
            break;
          }
        }
        if (paramCallEntity.isTypeViberVideo());
        for (String str1 = "incoming_call_video"; ; str1 = "incoming_call_group")
        {
          localMessageEntity.setBody(str1);
          break;
          if (!paramCallEntity.isTypeViberGroup())
            break label512;
        }
        label512: str1 = "incoming_call";
      }
      finally
      {
        localb.b();
      }
    }
  }

  public f a(MessageEntity paramMessageEntity)
  {
    return a(paramMessageEntity, "");
  }

  public f a(MessageEntity paramMessageEntity, MessageCallEntity paramMessageCallEntity, long paramLong1, Member paramMember, long paramLong2, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, PublicAccount paramPublicAccount, String paramString2)
  {
    return a(paramMessageEntity, paramMessageCallEntity, paramLong1, paramMember, paramLong2, paramString1, paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramPublicAccount, paramString2, false);
  }

  public f a(MessageEntity paramMessageEntity, MessageCallEntity paramMessageCallEntity, long paramLong1, Member paramMember, long paramLong2, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, PublicAccount paramPublicAccount, String paramString2, boolean paramBoolean2)
  {
    return a(paramMessageEntity, paramMessageCallEntity, paramLong1, paramMember, paramLong2, paramString1, paramInt1, paramInt2, paramInt3, paramBoolean1, paramInt4, paramPublicAccount, paramString2, paramBoolean2, null);
  }

  public f a(MessageEntity paramMessageEntity, MessageCallEntity paramMessageCallEntity, long paramLong1, Member paramMember, long paramLong2, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, PublicAccount paramPublicAccount, String paramString2, boolean paramBoolean2, PublicAccount.ExtraInfo paramExtraInfo)
  {
    int n;
    boolean bool1;
    boolean bool2;
    label48: boolean bool3;
    label69: boolean bool4;
    label87: boolean bool5;
    label141: Uri localUri;
    label195: com.viber.voip.model.entity.h localh;
    com.viber.voip.model.entity.m localm1;
    if (paramInt1 == 0)
    {
      n = 1;
      bool1 = n & this.g.getEngine(true).getPhoneController().isPublicAccountId(paramMember.getId());
      if ((paramMessageEntity == null) || (!paramMessageEntity.isAggregatedMessage()))
        break label310;
      bool2 = true;
      if ((paramMessageEntity != null) && (!paramMessageEntity.isOutgoing()) && (!paramMessageEntity.isFromBackup()))
        break label316;
      bool3 = true;
      if ((paramMessageEntity == null) || ((0x1000 & paramMessageEntity.getFlag()) == 0))
        break label322;
      bool4 = true;
      bs.d.a locala = d.a().a(bool3).b(bool2).c(bool1).d(bool4).e(paramBoolean1).f(paramBoolean2);
      if ((!bool3) || (!cd.c(paramMember.getId())))
        break label328;
      bool5 = true;
      d locald = locala.h(bool5).a();
      if ((paramMessageEntity == null) || (!paramMessageEntity.isInviteFromCommunity()) || (da.a(paramMessageEntity.getMessageInfo().getInviteCommunityInfo().getIconId())))
        break label334;
      localUri = dx.g(paramMessageEntity.getMessageInfo().getInviteCommunityInfo().getIconId());
      localh = a(paramInt1, paramLong2, paramLong1, paramString1, paramInt2, paramInt3, localUri, paramPublicAccount, paramInt4, paramString2, locald);
      localm1 = a();
      if ((paramMessageEntity == null) || (!paramMessageEntity.isFromBackup()) || (!paramMessageEntity.isOutgoing()) || (paramMember.getId() != null) || (paramMember.getPhoneNumber() != null))
        break label340;
    }
    com.viber.voip.model.entity.m localm2;
    label310: label316: label322: label328: label334: label340: for (int i1 = 1; ; i1 = 0)
    {
      if (i1 == 0)
        break label346;
      localm2 = null;
      if (!b(paramMessageEntity, localm2))
        break label407;
      a(paramMessageEntity, paramMessageEntity);
      return new f(false, false, null, localm2, paramMessageEntity, true);
      n = 0;
      break;
      bool2 = false;
      break label48;
      bool3 = false;
      break label69;
      bool4 = false;
      break label87;
      bool5 = false;
      break label141;
      localUri = null;
      break label195;
    }
    label346: int i2 = cd.j(paramInt1);
    if ((paramMessageEntity != null) && (paramMessageEntity.isFromBackup()));
    for (boolean bool6 = true; ; bool6 = false)
    {
      b localb = new b(null);
      localm2 = a(paramMember, paramInt2, paramPublicAccount, bool1, i2, bool6, localb);
      break;
    }
    label407: if ((localm2 != null) && (localm2.isOwner()));
    for (com.viber.voip.model.entity.m localm3 = null; ; localm3 = localm2)
    {
      if (localm3 != null)
      {
        if (!localh.b())
          break label1020;
        localh.j(localm3.getId());
        if ((!bool3) && (paramInt1 == 0) && (!bool1))
          a(localh, localm3.getId());
      }
      com.viber.voip.model.entity.l locall1 = this.j.b(0L, 0, localm1.getId(), 1);
      if (localm3 != null);
      for (com.viber.voip.model.entity.l locall2 = this.j.b(0L, 0, localm3.getId(), 1); ; locall2 = null)
      {
        if (paramMessageEntity != null)
        {
          if ((!paramMessageEntity.isGroupBehavior()) && ((paramMessageEntity.isSystemMessage()) || (paramMessageEntity.isActivateSecondaryNotification()) || (paramMessageEntity.isExternalAppMessage())))
          {
            localh.g(0);
            if (paramMessageEntity.isRakutenSystemMessage())
              localh.g(2);
          }
          if (localh.D())
            g().a(paramMessageEntity.getFlag(), localh);
        }
        ci localci;
        if ((localm3 != null) && (!bool1) && (!localh.D()) && (localm3.i() == 0L) && ((localh.a()) || (localh.ar())))
        {
          localci = ViberApplication.getInstance().getMessagesManager().e();
          if (!localh.ar())
            break label1050;
          String str4 = localm3.b();
          if (cd.c(str4))
            localci.a(Collections.singleton(str4), null, false, true, false);
        }
        label681: if (paramMessageEntity != null)
        {
          if (!paramMessageEntity.isIncoming())
            break label1098;
          localh.g(7);
          if (locall2 != null)
          {
            paramMessageEntity.setParticipantId(locall2.getId());
            locall2.c(paramMessageEntity.getId());
          }
        }
        label722: label764: boolean bool8;
        if ((paramMessageEntity != null) && (paramMessageEntity.isOutgoing()) && (paramInt1 == 1))
          if (localm3 != null)
          {
            localh.f(localm1.getId());
            localh.g(localm3.getId());
            if (!this.c.a(localh))
              break label1424;
            this.m.post(new d.d(paramInt1));
            if (!com.viber.voip.messages.m.f(localh.j()))
              break label1179;
            ViberApplication.getInstance().getMessagesManager().d().a(f(), paramLong2);
            label825: long l2 = localh.getId();
            bool8 = false;
            if (paramMessageEntity != null)
            {
              paramMessageEntity.setConversationId(l2);
              paramMessageEntity.setConversationType(localh.j());
              c(paramMessageEntity, localh);
              if ((paramMessageEntity.isPublicAccount()) && ((localh.c()) || ((localh.a()) && (!localh.G()))))
                paramMessageEntity.removeExtraFlag(20);
              a(paramMessageEntity, paramMessageEntity);
              if (paramMessageEntity.isInviteFromCommunity())
                break label1390;
              boolean bool9 = this.c.a(paramMessageEntity);
              a(l2, paramMessageEntity.getId(), paramMessageCallEntity);
              bool8 = bool9;
            }
            label937: if (locall2 != null)
            {
              locall2.b(l2);
              this.j.a(locall2.getId(), l2, locall2.c());
            }
            locall1.b(l2);
            this.j.a(locall1.getId(), l2, locall1.c());
            if (localm3 != null)
              break label1417;
          }
        label1417: for (com.viber.voip.model.entity.m localm5 = localm1; ; localm5 = localm3)
        {
          return new f(bool8, true, localh, localm5, paramMessageEntity, false);
          label1020: if ((!ViberApplication.isTablet(this.b)) || (!u.a(localh, localm3)))
            break;
          localh.g(12);
          break;
          label1050: String str3 = localm3.a();
          if (cd.c(str3))
          {
            localci.a(Collections.singleton(str3), null, true, true, false);
            break label681;
          }
          localci.a(str3, null, false);
          break label681;
          label1098: localh.g(5);
          paramMessageEntity.setParticipantId(locall1.getId());
          locall1.c(paramMessageEntity.getId());
          break label722;
          localh.f(localm1.getId());
          break label764;
          if (localm3 != null)
          {
            localh.f(localm3.getId());
            localh.g(localm1.getId());
            break label764;
          }
          localh.f(localm1.getId());
          break label764;
          label1179: if ((!localh.e()) && (!localh.G()))
            break label825;
          if (paramPublicAccount == null)
          {
            paramPublicAccount = new PublicAccount();
            long l1 = localh.k();
            paramPublicAccount.setGroupID(l1);
            if ((paramMessageEntity != null) && (paramExtraInfo != null))
            {
              InviteCommunityInfo localInviteCommunityInfo = paramMessageEntity.getMessageInfo().getInviteCommunityInfo();
              paramPublicAccount.setExtraInfo(paramExtraInfo);
              if (localInviteCommunityInfo != null)
              {
                String str2 = localInviteCommunityInfo.getCommunityDescription();
                paramPublicAccount.setTagLines(str2);
                paramPublicAccount.setRevision(0);
              }
            }
            if (localh.G())
            {
              String str1 = paramMember.getId();
              paramPublicAccount.setPublicAccountId(str1);
            }
          }
          boolean bool7 = localh.G();
          r localr = a(paramPublicAccount, bool7);
          if (!localh.ar())
            ViberApplication.getInstance().getMessagesManager().d().a(f(), localr.a(), localr.b(), localr.e(), localh.j(), localh.p());
          if (!localh.g())
            break label825;
          ViberApplication.getInstance().getMessagesManager().z().a();
          break label825;
          label1390: this.m.post(new c.h(localh.Z(), localh));
          bool8 = false;
          break label937;
        }
        label1424: if (paramMessageEntity != null)
          a(paramMessageEntity, paramMessageEntity);
        if (localm3 == null);
        for (com.viber.voip.model.entity.m localm4 = localm1; ; localm4 = localm3)
          return new f(false, false, null, localm4, paramMessageEntity, true);
      }
    }
  }

  public f a(MessageEntity paramMessageEntity, MessageCallEntity paramMessageCallEntity, Member paramMember, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    return a(paramMessageEntity, paramMessageCallEntity, paramMember, paramString1, paramInt, false, paramBoolean, paramString2);
  }

  public f a(MessageEntity paramMessageEntity, MessageCallEntity paramMessageCallEntity, Member paramMember, String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    f localf = d(paramMessageEntity);
    if (localf != null);
    label269: label275: label277: label684: label700: 
    while (true)
    {
      return localf;
      boolean bool;
      if (!paramMessageEntity.isFromBackup())
      {
        bool = true;
        if ((paramMessageEntity.isToSend()) && (paramMessageEntity.getMessageSeq() <= 0))
          paramMessageEntity.setMessageSeq(d().getPhoneController().generateSequence());
        if ((paramMessageEntity.isVideo()) && (paramMessageEntity.isToSend()) && (!da.a(paramMessageEntity.getMediaUri())))
          f(paramMessageEntity);
        if ((paramMessageEntity.isToSend()) || (paramMessageEntity.isCall()) || (paramMessageEntity.getMessageToken() == 0L) || (paramMessageEntity.isSystemEngagementMessage()) || (paramMessageEntity.isFeaturePromotion()) || (!this.c.a(paramMessageEntity.getMessageToken())))
          break label269;
      }
      MessageEntity localMessageEntity;
      com.viber.voip.model.entity.h localh1;
      for (int n = 1; ; n = 0)
      {
        localMessageEntity = null;
        if (n != 0)
        {
          localMessageEntity = null;
          if (bool)
            localMessageEntity = b(paramMessageEntity, this.c.k(paramMessageEntity.getMessageToken()));
        }
        localh1 = a(paramMessageEntity, paramMember.getPhoneNumber(), paramMember.getEncryptedMemberId(), paramString2);
        if (((localMessageEntity == null) && ((n == 0) || (bool))) || (localh1 == null))
          break label277;
        if (!bool)
          break label275;
        b localb3 = new b(null);
        com.viber.voip.model.entity.m localm3 = b(paramMessageEntity, paramMember, paramInt, localb3);
        return new f(false, false, a(localh1, localb3.a), localm3, localMessageEntity, true);
        bool = false;
        break;
      }
      return null;
      if (paramMessageEntity.isCommunityType())
      {
        localf = a(localh1, paramMessageEntity);
        if (localf != null);
      }
      else
      {
        a(paramMessageEntity, bool);
        if (localh1 == null)
        {
          if (localMessageEntity != null)
            this.c.c(localMessageEntity);
          localf = a(paramMessageEntity, paramMessageCallEntity, paramMember, paramString1, paramInt, paramString2);
          a(paramMessageEntity, localf.f);
        }
        while (true)
        {
          if ((!bool) || (!localf.b))
            break label700;
          b(paramMessageEntity, localf.f);
          e(paramMessageEntity);
          if (!paramBoolean2)
            break;
          long l2 = localf.f.getId();
          this.d.a(paramMessageEntity, paramMessageEntity.isOutgoing());
          this.c.f(l2, localf.f.j());
          if (paramBoolean1)
            d(paramMessageEntity.getGroupId(), 1);
          this.c.d(paramMessageEntity.getConversationType());
          g(paramMessageEntity);
          h(paramMessageEntity);
          localf.f = this.c.f(l2);
          this.d.a(Collections.singleton(Long.valueOf(l2)), paramMessageEntity.getConversationType(), false, false);
          return localf;
          if ((!paramMessageEntity.isToSend()) && (localh1.n() >= paramMessageEntity.getMessageToken()) && (localh1.n() != 0L))
          {
            com.viber.voip.model.entity.h localh2 = this.c.f(localh1.getId());
            b localb2 = new b(null);
            com.viber.voip.model.entity.m localm2 = b(paramMessageEntity, paramMember, paramInt, localb2);
            localf = new f(false, false, a(localh2, localb2.a), localm2, paramMessageEntity, true);
          }
          else
          {
            com.viber.voip.model.entity.m localm1 = null;
            long l1;
            if (paramMessageEntity.isFromBackup())
              l1 = a(paramMessageEntity, paramMember);
            while (true)
            {
              if (!paramMessageEntity.isInviteFromCommunity())
                break label684;
              localf = new f(false, false, localh1, localm1, paramMessageEntity, true);
              break;
              b localb1 = new b(null);
              localm1 = a(paramMessageEntity, paramMember, paramInt, localb1);
              l1 = localm1.getId();
              localh1 = a(localh1, localb1.a);
            }
            localf = a(localh1, l1, localm1, paramMessageEntity, paramMessageCallEntity, paramMember);
          }
        }
      }
    }
  }

  public f a(MessageEntity paramMessageEntity, MessageCallEntity paramMessageCallEntity, String paramString)
  {
    return a(paramMessageEntity, paramMessageCallEntity, new Member(paramMessageEntity.getMemberId(), paramMessageCallEntity.getCanonizedNumber()), "", 0, true, paramString);
  }

  public f a(MessageEntity paramMessageEntity, String paramString)
  {
    return a(paramMessageEntity, paramString, false);
  }

  public f a(MessageEntity paramMessageEntity, String paramString, boolean paramBoolean)
  {
    return a(paramMessageEntity, null, new Member(paramMessageEntity.getMemberId()), paramString, 0, paramBoolean, true, null);
  }

  public f a(String paramString, long paramLong)
  {
    com.viber.voip.model.entity.m localm = a();
    d locald = d.a().a(true).a();
    com.viber.voip.model.entity.h localh = a(4, 0L, paramLong, paramString, 2, Uri.parse("android.resource://com.viber.voip/drawable/broadcast_list_pic"), 0, locald);
    localh.h(11);
    localh.f(localm.getId());
    this.c.a(localh);
    this.j.a(localh.getId(), localh.p(), localm);
    return new f(false, true, localh, null, null, false);
  }

  public f a(boolean paramBoolean, long paramLong, com.viber.voip.model.entity.j paramj)
  {
    if (this.c.a(paramj.a(), paramj.d()))
      return new f(false, false, null, null, null, true);
    com.viber.voip.model.entity.h localh = h(paramLong);
    if (localh == null)
      return new f(false, false, null, null, null, true);
    if ((paramBoolean) && (com.viber.voip.messages.m.b(localh.j())) && (cd.c(paramj.d())))
      paramj.a(this.f.getRegistrationValues().l());
    MessageEntity localMessageEntity = this.c.k(paramj.a());
    if ((localMessageEntity == null) && (!com.viber.voip.messages.m.b(localh.j())))
      return new f(false, false, null, null, null, true);
    long l1;
    if (localMessageEntity != null)
    {
      boolean bool1 = av.c(localMessageEntity.getExtraFlags(), 12);
      l1 = localMessageEntity.getExtraFlags();
      if ((!bool1) && (!paramBoolean))
        break label257;
    }
    label257: for (boolean bool2 = true; ; bool2 = false)
    {
      localMessageEntity.setExtraFlags(av.a(l1, 12, bool2));
      localMessageEntity.setLikesCount(new UnsignedInt(localMessageEntity.getLikesCount()).increment());
      com.viber.voip.messages.m.a(false, this.c, localMessageEntity);
      c(localMessageEntity);
      this.c.a(paramj);
      return new f(true, false, localh, null, localMessageEntity, false);
    }
  }

  public g a(com.viber.voip.model.entity.h paramh, String paramString)
  {
    String str = paramh.o();
    this.c.f(paramh.getId(), paramString);
    this.d.a(Collections.singleton(Long.valueOf(paramh.getId())), paramh.j(), false, false);
    return new g(paramh, str, paramString);
  }

  public com.viber.voip.model.entity.h a(int paramInt1, Member paramMember, long paramLong, PublicAccount paramPublicAccount, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    return a(paramInt1, paramMember, paramLong, paramPublicAccount, paramInt2, paramBoolean1, paramBoolean2, paramInt3, true);
  }

  public com.viber.voip.model.entity.h a(int paramInt1, Member paramMember, long paramLong, PublicAccount paramPublicAccount, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, boolean paramBoolean3)
  {
    com.viber.voip.model.entity.h localh1;
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 0)
    {
      localh1 = this.c.a(paramMember.getId(), paramMember.getPhoneNumber(), paramMember.getEncryptedMemberId(), paramBoolean2);
      localObject1 = paramMember.getId();
      if (paramInt1 != 3)
        break label212;
      if ((!paramBoolean1) || (localh1 != null))
        break label158;
      e locale = e.a().a(true).a();
      localObject2 = a(f(), paramLong, paramInt1, paramPublicAccount, locale).f;
    }
    while (true)
    {
      if ((localObject2 != null) && (paramBoolean3))
        e().a(((com.viber.voip.model.entity.h)localObject2).getId(), ((com.viber.voip.model.entity.h)localObject2).j(), ((com.viber.voip.model.entity.h)localObject2).I());
      return localObject2;
      localh1 = this.c.b(paramLong);
      String str1 = String.valueOf(paramLong);
      com.viber.voip.analytics.g.a().c().g().b(str1, localh1, ae.b());
      localObject1 = str1;
      break;
      label158: if ((localh1 != null) && (localh1.j() == 3))
      {
        ViberApplication.getInstance().getMessagesManager().d().a(f(), paramLong, null, paramPublicAccount.getRevision(), paramInt1, localh1.p());
        localObject2 = localh1;
        continue;
        label212: if ((paramBoolean1) && (paramInt1 == 0))
        {
          boolean bool1;
          if (localh1 == null)
          {
            f localf = a(null, null, System.currentTimeMillis(), paramMember, 0L, "", 0, paramInt2, 1, paramBoolean2, paramInt3, paramPublicAccount, null);
            com.viber.voip.model.entity.h localh2 = localf.f;
            boolean bool2 = localf.c;
            if (paramBoolean2)
              com.viber.voip.h.a.b().post(new l.a(localh2.getId(), paramMember.getId(), paramInt3));
            bool1 = bool2;
            localObject2 = localh2;
          }
          while (true)
          {
            if (!bool1)
              break label441;
            com.viber.voip.analytics.story.e.c localc = com.viber.voip.analytics.g.a().c().g();
            String str2 = ae.b();
            localc.b((String)localObject1, (com.viber.voip.model.entity.h)localObject2, str2);
            break;
            if (localh1.M())
            {
              localh1.h(10);
              localh1.g(9);
              this.c.a(localh1.getTable(), localh1.getId(), "flags", Long.valueOf(localh1.z()));
            }
            if ((!localh1.U()) && (!e().a().contains(Long.valueOf(localh1.getId()))))
            {
              bool1 = true;
              localObject2 = localh1;
            }
            else
            {
              localObject2 = localh1;
              bool1 = false;
            }
          }
        }
      }
      else
      {
        label441: localObject2 = localh1;
      }
    }
  }

  public com.viber.voip.model.entity.h a(int paramInt, Member paramMember, long paramLong, boolean paramBoolean)
  {
    return a(paramInt, paramMember, paramLong, paramBoolean, true);
  }

  public com.viber.voip.model.entity.h a(int paramInt, Member paramMember, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt, paramMember, paramLong, null, 0, paramBoolean1, false, 0, paramBoolean2);
  }

  public com.viber.voip.model.entity.h a(Member paramMember)
  {
    com.viber.voip.model.entity.h localh = this.c.a(paramMember.getId(), paramMember.getPhoneNumber(), paramMember.getEncryptedMemberId(), false);
    if (localh == null)
      localh = a(null, null, System.currentTimeMillis(), paramMember, 0L, "", 0, 0, 1, false, 0, null, null).f;
    return localh;
  }

  public com.viber.voip.model.entity.m a()
  {
    f localf = this.l;
    com.viber.voip.model.entity.m localm = null;
    if (localf != null)
      localm = this.l.a();
    if (localm == null)
    {
      localm = this.i.b();
      if (this.l != null)
        this.l.a(localm);
    }
    return localm;
  }

  public Long a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    f.d locald = new f.d(paramLong1, paramLong2);
    Long localLong = a(locald);
    if (localLong == null)
    {
      localLong = this.j.a(paramLong1, paramLong2);
      if (localLong == null)
        if (!com.viber.voip.messages.m.b(paramInt2))
          break label102;
    }
    label102: for (int n = 3; ; n = 1)
    {
      localLong = Long.valueOf(this.j.a(paramLong1, paramInt1, paramLong2, n));
      if (!paramBoolean)
        this.d.c(Collections.singleton(Long.valueOf(paramLong1)), false);
      a(locald, localLong);
      return localLong;
    }
  }

  public void a(long paramLong)
  {
    p.a.c.a(this.b, paramLong);
    c.a locala = com.viber.voip.util.b.c.a(this.b);
    if (locala.b())
    {
      Pair localPair = this.c.d(new long[] { paramLong });
      com.viber.voip.notif.e.m localm = com.viber.voip.notif.g.a(this.b).a();
      Iterator localIterator = ((Set)localPair.first).iterator();
      while (localIterator.hasNext())
      {
        long l1 = ((Long)localIterator.next()).longValue();
        if (l1 > 0L)
          localm.a(l1);
      }
      this.c.a((Set)localPair.second, 21, false);
      this.d.a((Set)localPair.second, 0, false, false);
    }
    MessageEntity localMessageEntity = locala.a();
    if (localMessageEntity == null)
      return;
    b(localMessageEntity);
  }

  public void a(long paramLong, int paramInt)
  {
    this.c.e(paramLong, null);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
  }

  public void a(long paramLong1, int paramInt, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    MsgInfo localMsgInfo = (MsgInfo)com.viber.voip.flatbuffers.b.e.a().a().a(paramString1);
    if (localMsgInfo == null);
    com.viber.voip.model.entity.h localh;
    do
    {
      do
        return;
      while (!com.viber.voip.messages.m.a(localMsgInfo, this.f.getRegistrationValues()));
      localh = this.c.b(paramLong1);
    }
    while (localh == null);
    Member localMember = new Member(paramString2, paramString2, null, com.viber.voip.messages.d.c.c().a(paramString2, localh.j(), localh.p(), paramString3), null, null, paramString2);
    ((bn)this.e.get()).a(localh, localMember, paramInt, true);
  }

  public void a(long paramLong, int paramInt, CharSequence paramCharSequence, String paramString, LongSparseArray<Integer> paramLongSparseArray)
  {
    if (this.c.a(paramLong, paramCharSequence, paramString, paramLongSparseArray) > 0)
      this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
  }

  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    int n = com.viber.voip.backgrounds.m.a(this.b, paramInt, paramString1);
    if (this.c.a(paramLong, paramString1, paramString2, n) > 0)
      this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.c.b(paramLong, paramInt, paramBoolean);
  }

  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    MessageEntity localMessageEntity = this.c.k(paramLong1);
    if (localMessageEntity != null)
    {
      a(com.viber.voip.messages.controller.c.c.a(localMessageEntity.getGroupId(), localMessageEntity.getConversationType(), localMessageEntity.getMemberId(), System.currentTimeMillis(), 64, paramLong2, paramInt));
      a(paramLong1, localMessageEntity.getGroupId(), localMessageEntity.getConversationId(), Collections.singleton(new com.viber.voip.publicaccount.entity.a(paramLong1, localMessageEntity.getMemberId(), localMessageEntity.isOutgoing())));
    }
  }

  public void a(long paramLong1, final long paramLong2, long paramLong3, final Set<com.viber.voip.publicaccount.entity.a> paramSet)
  {
    this.c.a(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = paramSet.iterator();
        while (localIterator.hasNext())
        {
          com.viber.voip.publicaccount.entity.a locala = (com.viber.voip.publicaccount.entity.a)localIterator.next();
          if (!da.a(locala.b()))
            bs.a(bs.this, paramLong2, locala.b(), locala.a());
          bs.a(bs.this, paramLong2, locala.b(), locala.a(), locala.c());
        }
        bs.b(bs.this).U(this.c);
        bs.b(bs.this).d(5);
      }
    });
    this.c.f(paramLong3, 5);
    this.d.a(paramLong3, paramLong1, false);
    this.d.a(Collections.singleton(Long.valueOf(paramLong3)), 5, false, false);
  }

  public void a(long paramLong1, long paramLong2, Set<com.viber.voip.publicaccount.entity.a> paramSet)
  {
    com.viber.provider.b localb = aa.f();
    localb.a();
    try
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramLong1);
      localb.a("group_delete_all_from_participant", "group_id=?", arrayOfString);
      if (!paramSet.isEmpty())
      {
        Iterator localIterator = paramSet.iterator();
        while (localIterator.hasNext())
        {
          com.viber.voip.publicaccount.entity.a locala = (com.viber.voip.publicaccount.entity.a)localIterator.next();
          a(localb, paramLong1, locala.b(), locala.a());
          a(paramLong1, locala.b(), locala.a(), locala.c());
        }
      }
    }
    catch (SQLException localSQLException)
    {
      return;
      this.c.U(paramLong2);
      localb.c();
      return;
    }
    finally
    {
      localb.b();
    }
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    MessageEntity localMessageEntity = this.c.k(paramLong);
    if ((localMessageEntity != null) && (1007 != localMessageEntity.getMimeType()))
    {
      if (paramBoolean)
        if (localMessageEntity.hasAnyStatus(new int[] { -1 }))
        {
          this.c.I(localMessageEntity.getId());
          this.d.a(Collections.singleton(Long.valueOf(localMessageEntity.getConversationId())), false);
        }
    }
    else
      return;
    if (paramBoolean)
    {
      localMessageEntity.setDeleted(1);
      this.d.a(Collections.singleton(Long.valueOf(localMessageEntity.getConversationId())), true);
    }
    while (true)
    {
      this.c.b(localMessageEntity);
      this.c.f(localMessageEntity.getConversationId(), localMessageEntity.getConversationType());
      this.c.d(localMessageEntity.getConversationType());
      com.viber.voip.notif.g.a(this.b).a(localMessageEntity.getConversationId());
      this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      this.d.a(Collections.singleton(Long.valueOf(localMessageEntity.getConversationId())), localMessageEntity.getConversationType(), false, false);
      return;
      localMessageEntity.setMimeType(1007);
      localMessageEntity.setExtraFlags(0L);
      localMessageEntity.setRawMessageInfo("");
    }
  }

  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    this.c.b(Collections.singleton(Long.valueOf(paramLong1)), paramBoolean, paramLong2);
  }

  public void a(f paramf)
  {
    this.l = paramf;
  }

  public void a(MessageEntity paramMessageEntity, int paramInt)
  {
    com.viber.voip.model.entity.h localh = this.c.a(paramMessageEntity.getMemberId(), false);
    if (localh != null);
    for (MessageEntity localMessageEntity = this.c.u(localh.getId()); ; localMessageEntity = null)
    {
      if (localMessageEntity != null)
        paramMessageEntity.setMessageToken(localMessageEntity.getMessageToken());
      while (true)
      {
        f localf = a(paramMessageEntity, null, new Member(paramMessageEntity.getMemberId(), paramMessageEntity.getMemberId()), "", paramInt, true, null);
        if (localf.b)
          ((bn)this.e.get()).a(localf.f, localf.g, localf.h);
        return;
        paramMessageEntity.setMessageToken(1L);
      }
    }
  }

  public void a(com.viber.voip.model.entity.h paramh, Uri paramUri)
  {
    this.c.a(paramh.getId(), paramUri);
    this.d.a(Collections.singleton(Long.valueOf(paramh.getId())), paramh.j(), true, false);
  }

  public void a(com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    if ((paramMessageEntity.isFromBackup()) || (paramMessageEntity.isToSend()) || (!paramMessageEntity.isPollMessage()));
    while (true)
    {
      return;
      if (paramMessageEntity.isPollQuestionMessage())
      {
        MsgInfo localMsgInfo1 = paramMessageEntity.getMessageInfo();
        Poll localPoll = localMsgInfo1.getPoll();
        int n;
        label53: PollUiOptions[] arrayOfPollUiOptions;
        int i1;
        if (localPoll.getTokens() == null)
        {
          n = 0;
          if (n == 0)
            break label146;
          arrayOfPollUiOptions = new PollUiOptions[n];
          i1 = 0;
        }
        label146: int i3;
        for (int i2 = 0; ; i2 = i3)
        {
          if (i1 >= n)
            break label298;
          long l1 = localPoll.getTokens()[i1];
          MessageEntity localMessageEntity = this.c.k(l1);
          if ((localMessageEntity == null) || (!localMessageEntity.isPollMessage()))
          {
            if (!paramMessageEntity.isVisibleMessage())
              break;
            com.viber.voip.messages.m.a(this.c, paramMessageEntity);
            this.c.b(paramMessageEntity);
            return;
            n = localPoll.getTokens().length;
            break label53;
            break;
          }
          PollUiOptions localPollUiOptions = new PollUiOptions();
          localPollUiOptions.setName(localMessageEntity.getBody());
          localPollUiOptions.setToken(localMessageEntity.getMessageToken());
          localPollUiOptions.setLikesCount(localMessageEntity.getLikesCount());
          localPollUiOptions.setMessageId(localMessageEntity.getMessageGlobalId());
          arrayOfPollUiOptions[i1] = localPollUiOptions;
          i3 = i2 + 1;
          MsgInfo localMsgInfo2 = localMessageEntity.getMessageInfo();
          if (localMsgInfo2.getPoll().getParentToken().longValue() != paramMessageEntity.getMessageToken())
          {
            localMsgInfo2.getPoll().setParentToken(paramMessageEntity.getMessageToken());
            String str = com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo2);
            this.c.a(localMessageEntity.getTable(), localMessageEntity.getId(), "msg_info", str);
          }
          i1++;
        }
        label298: if (i2 == n)
        {
          localPoll.setOptions(arrayOfPollUiOptions);
          paramMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo1));
          boolean bool = paramMessageEntity.isInvisibleMessage();
          if (bool)
          {
            paramMessageEntity.removeExtraFlag(22);
            paramMessageEntity.setUnread(1);
          }
          if (paramMessageEntity.isEmpty())
            paramMessageEntity.setMimeType(0);
          c(paramMessageEntity);
          if ((bool) && (paramh != null) && (paramm != null) && (!paramh.g()))
            ((bn)this.e.get()).a(paramh, paramm, paramMessageEntity);
        }
      }
      else if (!paramBoolean)
      {
        Iterator localIterator = this.c.r(paramMessageEntity.getConversationId()).iterator();
        while (localIterator.hasNext())
          a(paramh, paramm, (MessageEntity)localIterator.next(), true);
      }
    }
  }

  public void a(com.viber.voip.model.entity.h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c.a(paramh, paramBoolean1, paramBoolean2);
    this.d.a(Collections.singleton(Long.valueOf(paramh.getId())), paramh.j(), false, true);
  }

  public void a(r paramr, int paramInt)
  {
    int n = paramr.K();
    int i1 = Math.max(paramr.v(), paramr.n());
    int i2 = Math.min(n + paramInt, i1);
    if (n != i2)
      this.c.a(paramr.getTable(), paramr.getId(), "last_read_message_id", Integer.valueOf(i2));
  }

  public void a(r paramr, boolean paramBoolean)
  {
    if (paramr == null)
      return;
    ab localab = this.c;
    long l1 = paramr.getId();
    int n;
    label23: com.viber.voip.model.entity.h localh1;
    if (paramBoolean)
    {
      n = 1;
      localab.a("public_accounts", l1, "subscription_status", Integer.valueOf(n));
      localh1 = this.c.b(paramr.a());
      if (localh1 != null)
      {
        this.d.a(Collections.singleton(Long.valueOf(localh1.getId())), localh1.j(), true, false);
        if ((!paramr.S()) && (!ao.f()))
        {
          PublicAccount localPublicAccount = new PublicAccount(paramr, localh1);
          if (localPublicAccount.getGroupRole() != 2)
          {
            if (!paramBoolean)
              break label220;
            e locale = e.a().a();
            a(0, paramr.a(), 2, localPublicAccount, locale);
          }
        }
      }
    }
    while (true)
    {
      com.viber.voip.model.entity.h localh2 = this.c.a(paramr.b(), false);
      if (localh2 != null)
        this.d.a(Collections.singleton(Long.valueOf(localh2.getId())), localh2.j(), true, false);
      if ((paramBoolean) || (da.a(paramr.b())))
        break;
      com.viber.voip.messages.m.a("", paramr.b());
      return;
      n = 0;
      break label23;
      label220: a(Collections.singleton(Long.valueOf(paramr.a())), localh1.j());
    }
  }

  public void a(String paramString, boolean paramBoolean)
  {
    a(this.c.a(paramString), paramBoolean);
  }

  public void a(List<com.viber.voip.model.entity.h> paramList)
  {
    Map localMap = null;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      com.viber.voip.model.entity.h localh = (com.viber.voip.model.entity.h)localIterator.next();
      ConversationSettings localConversationSettings = new ConversationSettings(true, localh.y(), localh.I());
      if (localh.b())
        com.viber.voip.model.a.b.c().b("not_sync_hide_group", String.valueOf(localh.k()), localConversationSettings.convertToFlags());
      while (true)
      {
        this.d.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), false, true);
        break;
        if (localMap == null)
          localMap = this.i.a((com.viber.voip.model.entity.h[])paramList.toArray(new com.viber.voip.model.entity.h[paramList.size()]));
        com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localMap.get(Long.valueOf(localh.getId()));
        com.viber.voip.model.a.b.c().b("not_sync_hide_1to1", localm.a(), localConversationSettings.convertToFlags());
      }
    }
  }

  public void a(Set<Long> paramSet)
  {
    if (this.c.i(paramSet) > 0)
    {
      Map localMap = this.c.k(paramSet);
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.c.f(((Long)localEntry.getKey()).longValue(), ((Integer)localEntry.getValue()).intValue());
      }
      this.c.b(localMap.values());
      this.d.a(localMap.keySet(), 1, false, false);
      this.d.a(localMap.keySet(), true);
    }
  }

  public void a(Set<Long> paramSet, int paramInt)
  {
    this.c.e(paramSet);
    this.c.d(paramSet);
    this.c.f(paramSet);
    this.c.g(paramSet);
    ((ConferenceCallsRepository)ViberApplication.getInstance().getLazyConferenceCallsRepository().get()).makeConferencesWithConversationIdsUnavailable(paramSet);
    new LongSparseSet(paramSet.size()).addAll(paramSet);
    this.m.post(new d.d(paramInt));
    this.d.b(paramSet, paramInt, true);
    com.viber.voip.notif.g.a(this.b).a(paramSet);
    this.c.h(paramSet);
    this.c.o();
    this.c.d(paramInt);
  }

  public void a(Set<Long> paramSet, boolean paramBoolean)
  {
    if (paramSet.size() == 0)
      return;
    this.c.a(paramSet, 26, paramBoolean);
    this.d.a(paramSet, 1, false, false);
  }

  public boolean a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3)
  {
    com.viber.provider.b localb = aa.f();
    localb.a();
    try
    {
      int n = this.c.a(paramLong1, paramLong2, paramInt2);
      boolean bool = false;
      if (n > 0)
      {
        if (!com.viber.voip.messages.m.e(paramInt1))
          break label102;
        this.c.k(paramLong3, paramInt2);
      }
      while (true)
      {
        this.c.d(paramInt1);
        bool = true;
        if ((paramInt1 != 0) && (paramInt1 != 4))
          bool |= this.c.B(paramLong1);
        localb.c();
        return bool;
        label102: this.c.a(paramLong1, paramLong2, true);
      }
    }
    finally
    {
      localb.b();
    }
  }

  public boolean a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    MessageEntity localMessageEntity = this.c.k(paramLong1);
    if (localMessageEntity != null)
    {
      if (1008 == localMessageEntity.getMimeType())
        return true;
      String str1;
      if (paramLong2 == 0L)
        if (localMessageEntity.isIncoming())
          str1 = localMessageEntity.getMemberId();
      while ((!paramBoolean) && (!da.a(str1)) && (!str1.equalsIgnoreCase(paramString)))
      {
        return true;
        str1 = a(this.f.getRegistrationValues(), cd.c(paramString));
        continue;
        str1 = localMessageEntity.getMemberId();
      }
      String str2 = localMessageEntity.getDownloadIdOrPublicAccountDownloadUrl();
      if (str2 != null)
        s.a(str2, true);
      String str3;
      int n;
      label181: String str4;
      if ((localMessageEntity.isAudioPtt()) || (localMessageEntity.isVoiceMessage()))
      {
        str3 = localMessageEntity.getMediaUri();
        if ((!localMessageEntity.isAudioPtt()) && (!localMessageEntity.isVoiceMessage()) && (!localMessageEntity.isVideoPttBehavior()) && (!localMessageEntity.isGifFile()))
          break label447;
        n = 1;
        if ((localMessageEntity.isIncoming()) || ((localMessageEntity.isOutgoing()) && (n != 0)))
        {
          str4 = localMessageEntity.getMediaUri();
          if ((str4 != null) && (this.c.e(str4).size() == 1))
            if (!localMessageEntity.isAudioPtt())
              break label453;
        }
      }
      label447: label453: for (String str5 = PttUtils.generateLegacyPttFileName(str4, this.b); ; str5 = Uri.parse(str4).getPath())
      {
        if ((!localMessageEntity.isVoiceMessage()) && (!localMessageEntity.isVideoPttBehavior()))
          at.k(str5);
        localMessageEntity.setMediaUri("");
        localMessageEntity.setMimeType(1008);
        localMessageEntity.setBody(com.viber.voip.messages.j.h(paramString));
        localMessageEntity.setRawMessageInfo("");
        localMessageEntity.setExtraFlags(0L);
        this.c.b(localMessageEntity);
        this.c.f(localMessageEntity.getConversationId(), localMessageEntity.getConversationType());
        this.c.d(localMessageEntity.getConversationType());
        this.c.W(localMessageEntity.getMessageToken());
        com.viber.voip.notif.g.a(this.b).a(localMessageEntity.getConversationId());
        if (str3 != null)
          this.d.a(Collections.singleton(str3));
        this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
        this.d.a(Collections.singleton(Long.valueOf(localMessageEntity.getConversationId())), localMessageEntity.getConversationType(), false, false);
        return true;
        str3 = null;
        break;
        n = 0;
        break label181;
      }
    }
    long l1 = System.currentTimeMillis();
    if (paramLong2 > 0L);
    for (boolean bool = true; ; bool = false)
    {
      a(new com.viber.voip.messages.controller.c.a(paramLong2, paramString, paramLong1, l1, 64, 0, null, com.viber.voip.model.entity.h.a(bool, 0), 0, 0).a(1008, com.viber.voip.messages.j.h(paramString), 0, null, 0));
      break;
    }
  }

  public void b()
  {
    Iterator localIterator = this.c.x().iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.model.entity.h localh = (com.viber.voip.model.entity.h)localIterator.next();
      int n = com.viber.voip.backgrounds.m.a(this.b, localh.j(), localh.t());
      if ((n != localh.u()) && (this.c.h(localh.getId(), n) > 0))
        this.d.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), false, false);
    }
  }

  public void b(long paramLong)
  {
    r localr = this.c.d(paramLong);
    com.viber.voip.model.entity.h localh = this.c.b(paramLong);
    if ((localr != null) && (localr.B()) && (localh != null))
    {
      localr.b(false);
      this.c.b(localr);
      this.d.a(Collections.singleton(Long.valueOf(localh.getId())), localh.j(), false, false);
      com.viber.voip.model.entity.m localm = a();
      this.j.a(localh.getId(), localh.p(), localm);
      this.d.a(Collections.singleton(Long.valueOf(localh.getId())), Collections.singleton(""), false);
    }
  }

  public void b(long paramLong, int paramInt)
  {
    long l1 = av.a(0L, new int[] { 30, 31 });
    this.c.a(paramLong, 0L, l1);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
  }

  public void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.c.b(paramLong, paramInt, paramBoolean);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), 0, false, false);
  }

  public void b(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      b(paramLong, 8, bool);
      return;
    }
  }

  public void b(MessageEntity paramMessageEntity)
  {
    a(paramMessageEntity, 1);
  }

  public int c(long paramLong, int paramInt)
  {
    return this.c.j(paramLong, paramInt);
  }

  public void c()
  {
    this.c.o();
  }

  public void c(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.c.a(paramLong, paramBoolean);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), paramInt, false, false);
  }

  public void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      b(paramLong, 9, bool);
      return;
    }
  }

  public void c(MessageEntity paramMessageEntity)
  {
    this.c.b(paramMessageEntity);
    this.d.a(paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken(), false);
  }

  public boolean c(long paramLong)
  {
    return this.c.B(paramLong);
  }

  public void d(long paramLong)
  {
    MessageEntity localMessageEntity1 = this.c.l(paramLong);
    MessageEntity localMessageEntity2;
    if (localMessageEntity1 != null)
      if (localMessageEntity1.hasAnyStatus(new int[] { -1 }))
      {
        if (!localMessageEntity1.isEditedMessage())
          break label292;
        localMessageEntity2 = this.c.a(localMessageEntity1.getConversationId(), localMessageEntity1.getMessageToken());
        if (localMessageEntity2 == null)
          break label292;
        localMessageEntity1.setStatus(2);
        this.c.b(localMessageEntity1);
      }
    while (true)
    {
      if (localMessageEntity2.isPollQuestionMessage())
      {
        localMessageEntity2.setStatus(13);
        c(localMessageEntity2);
        for (PollUiOptions localPollUiOptions : localMessageEntity2.getMessageInfo().getPoll().getOptions())
        {
          MessageEntity localMessageEntity3 = this.c.c(localPollUiOptions.getSeq());
          if ((localMessageEntity3 != null) && (localMessageEntity3.isPollOptionMessage()))
            if (localMessageEntity3.hasAnyStatus(new int[] { -1 }))
            {
              localMessageEntity3.setStatus(0);
              this.c.b(localMessageEntity3);
              this.d.a(localMessageEntity3, true);
            }
        }
      }
      localMessageEntity2.setDate(System.currentTimeMillis());
      localMessageEntity2.setStatus(j(localMessageEntity2));
      if (localMessageEntity2.getMessageSeq() <= 0)
        localMessageEntity2.setMessageSeq(f());
      this.c.b(localMessageEntity2);
      this.c.f(localMessageEntity2.getConversationId(), localMessageEntity2.getConversationType());
      this.d.a(localMessageEntity2, true);
      this.d.b(localMessageEntity2.getConversationId(), localMessageEntity2.getMessageToken(), false);
      return;
      label292: localMessageEntity2 = localMessageEntity1;
    }
  }

  public void d(long paramLong, int paramInt)
  {
    r localr = this.c.d(paramLong);
    if (localr != null)
      a(localr, paramInt);
  }

  public void d(long paramLong, boolean paramBoolean)
  {
    b(paramLong, 32, paramBoolean);
  }

  public void e(long paramLong)
  {
    MessageEntity localMessageEntity = this.c.l(paramLong);
    if (localMessageEntity != null)
      if (!localMessageEntity.hasAnyStatus(new int[] { 1, 2 }))
      {
        ViberApplication.getInstance().getLocationManager().a(Long.valueOf(paramLong));
        localMessageEntity.setStatus(-1);
        this.c.b(localMessageEntity);
        this.c.b(localMessageEntity);
        this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
        t.a(localMessageEntity);
      }
  }

  public void e(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      b(paramLong, 20, bool);
      return;
    }
  }

  public void f(long paramLong)
  {
    MessageEntity localMessageEntity = this.c.l(paramLong);
    if ((localMessageEntity != null) && (localMessageEntity.getStatus() != 1) && (localMessageEntity.getStatus() != 2))
    {
      localMessageEntity.setStatus(-1);
      localMessageEntity.setExtraStatus(2);
      this.c.b(localMessageEntity);
      this.c.b(localMessageEntity);
      this.d.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
    }
  }

  public void f(long paramLong, boolean paramBoolean)
  {
    b(paramLong, 26, paramBoolean);
  }

  public int g(long paramLong)
  {
    Set localSet = this.c.Z(paramLong);
    if (localSet.isEmpty())
      return 0;
    int n = this.c.a(paramLong, localSet);
    if (n > 0)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (localLong != null)
          this.c.f(localLong.longValue(), 0);
      }
      this.c.d(0);
      this.d.a(localSet, false);
      com.viber.voip.notif.g.a(this.b).a(localSet);
    }
    return n;
  }

  public void g(long paramLong, boolean paramBoolean)
  {
    b(paramLong, 25, paramBoolean);
  }

  public void h(long paramLong, boolean paramBoolean)
  {
    b(paramLong, 21, paramBoolean);
  }

  public void i(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      b(paramLong, 22, bool);
      return;
    }
  }

  public void j(long paramLong, boolean paramBoolean)
  {
    a(this.c.d(paramLong), paramBoolean);
  }

  public void k(long paramLong, boolean paramBoolean)
  {
    this.c.b(paramLong, paramBoolean);
    this.d.a(Collections.singleton(Long.valueOf(paramLong)), 1, false, false);
  }

  public void l(long paramLong, boolean paramBoolean)
  {
    this.c.c(paramLong, paramBoolean);
  }

  public static class a
  {
    public final com.viber.voip.model.entity.h a;
    public final com.viber.voip.model.entity.l b;
    public final com.viber.voip.model.entity.m c;

    public a(com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.l paraml, com.viber.voip.model.entity.m paramm)
    {
      this.a = paramh;
      this.b = paraml;
      this.c = paramm;
    }

    public String toString()
    {
      return "AddParticipantResult{conversation=" + this.a + ", participant=" + this.b + ", participantInfo=" + this.c + '}';
    }
  }

  private class b
    implements g.a
  {
    Map<Long, com.viber.voip.model.entity.h> a;

    private b()
    {
    }

    public void a(g.b paramb)
    {
      if (bs.a(bs.this) != null)
      {
        bs.a(bs.this).a(paramb.a.keySet());
        bs.a(bs.this).a(paramb.b);
        bs.a(bs.this).b(paramb.c);
      }
      this.a = paramb.a;
    }
  }

  public static class c
  {
    public final boolean a;
    public final boolean b;
    public final MessageEntity c;
    public final com.viber.voip.model.entity.m d;

    private c(boolean paramBoolean1, boolean paramBoolean2, MessageEntity paramMessageEntity, com.viber.voip.model.entity.m paramm)
    {
      this.c = paramMessageEntity;
      this.d = paramm;
      this.a = paramBoolean1;
      this.b = paramBoolean2;
    }
  }

  public static class d
  {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    private d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.c = paramBoolean3;
      this.d = paramBoolean4;
      this.e = paramBoolean5;
      this.g = paramBoolean6;
      this.h = paramBoolean7;
      this.f = paramBoolean8;
    }

    public static a a()
    {
      return new a(null);
    }

    public static class a
    {
      private boolean a;
      private boolean b;
      private boolean c;
      private boolean d;
      private boolean e;
      private boolean f;
      private boolean g;
      private boolean h;

      public a a(boolean paramBoolean)
      {
        this.a = paramBoolean;
        return this;
      }

      public bs.d a()
      {
        return new bs.d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
      }

      public a b(boolean paramBoolean)
      {
        this.b = paramBoolean;
        return this;
      }

      public a c(boolean paramBoolean)
      {
        this.c = paramBoolean;
        return this;
      }

      public a d(boolean paramBoolean)
      {
        this.d = paramBoolean;
        return this;
      }

      public a e(boolean paramBoolean)
      {
        this.e = paramBoolean;
        return this;
      }

      public a f(boolean paramBoolean)
      {
        this.h = paramBoolean;
        return this;
      }

      public a g(boolean paramBoolean)
      {
        this.f = paramBoolean;
        return this;
      }

      public a h(boolean paramBoolean)
      {
        this.g = paramBoolean;
        return this;
      }
    }
  }

  public static class e
  {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Boolean e;

    private e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Boolean paramBoolean, boolean paramBoolean4)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.c = paramBoolean3;
      this.e = paramBoolean;
      this.d = paramBoolean4;
    }

    public static a a()
    {
      return new a(null);
    }

    public static class a
    {
      private boolean a;
      private boolean b;
      private boolean c;
      private Boolean d;
      private boolean e;

      public a a(Boolean paramBoolean)
      {
        this.d = paramBoolean;
        return this;
      }

      public a a(boolean paramBoolean)
      {
        this.a = paramBoolean;
        return this;
      }

      public bs.e a()
      {
        return new bs.e(this.a, this.b, this.c, this.d, this.e, null);
      }

      public a b(boolean paramBoolean)
      {
        this.b = paramBoolean;
        return this;
      }

      public a c(boolean paramBoolean)
      {
        this.c = paramBoolean;
        return this;
      }

      public a d(boolean paramBoolean)
      {
        this.e = paramBoolean;
        return this;
      }
    }
  }

  public static class f
  {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public boolean e;
    public com.viber.voip.model.entity.h f;
    public final com.viber.voip.model.entity.m g;
    public final MessageEntity h;
    public int i;

    public f(com.viber.voip.model.entity.h paramh, MessageEntity paramMessageEntity, boolean paramBoolean)
    {
      this(false, false, paramh, null, paramMessageEntity, true);
      this.e = paramBoolean;
    }

    public f(boolean paramBoolean1, boolean paramBoolean2, com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity, boolean paramBoolean3)
    {
      this(paramBoolean1, paramBoolean2, paramh, paramm, paramMessageEntity, paramBoolean3, false);
    }

    public f(boolean paramBoolean1, boolean paramBoolean2, com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity, boolean paramBoolean3, int paramInt)
    {
      this(paramBoolean1, paramBoolean2, paramh, paramm, paramMessageEntity, paramBoolean3);
      this.i = paramInt;
    }

    public f(boolean paramBoolean1, boolean paramBoolean2, com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm, MessageEntity paramMessageEntity, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.a = paramBoolean3;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean4;
      this.f = paramh;
      this.g = paramm;
      this.h = paramMessageEntity;
      this.i = 0;
    }
  }

  public static class g
  {
    public final com.viber.voip.model.entity.h a;
    public final String b;
    public final String c;

    public g(com.viber.voip.model.entity.h paramh, String paramString1, String paramString2)
    {
      this.a = paramh;
      this.b = paramString1;
      this.c = paramString2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.bs
 * JD-Core Version:    0.6.2
 */