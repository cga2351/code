package com.viber.voip.messages.controller.b;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.LocationInfo;
import com.viber.jni.PublicGroupChangeEvent;
import com.viber.jni.PublicGroupMessage;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.SendMessageMediaTypeFactory;
import com.viber.jni.cdr.entity.SendMessageMediaTypeFactory.SendMessageMediaTypeData;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSendGroupMsg;
import com.viber.jni.im2.CSendMessageMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Location;
import com.viber.jni.messenger.MessengerDelegate.MessagesSender;
import com.viber.jni.publicgroup.PublicGroupControllerDelegate.PublicGroupGetMessages;
import com.viber.jni.publicgroup.PublicGroupGetMessagesListener;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.liblinkparser.LinkParser;
import com.viber.liblinkparser.LinkParser.Preview;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.a.i;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.n;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.Edit;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaMetadata;
import com.viber.voip.flatbuffers.model.msginfo.MediaMetadata.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Poll;
import com.viber.voip.flatbuffers.model.msginfo.PollUiOptions;
import com.viber.voip.flatbuffers.model.msginfo.Quote;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.ThumbnailInfo;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.i;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.messages.controller.bk.b;
import com.viber.voip.messages.controller.bk.c;
import com.viber.voip.messages.controller.bl;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.bv.m;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.action.ForwardAction;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.registration.af;
import com.viber.voip.sound.ptt.PttUtils;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cu;
import com.viber.voip.ui.dialogs.e.a;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.at.a;
import com.viber.voip.util.aw;
import com.viber.voip.util.bg.a;
import com.viber.voip.util.bp;
import com.viber.voip.util.cd;
import com.viber.voip.util.cg;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dv;
import com.viber.voip.util.dy;
import com.viber.voip.util.dy.b.a;
import com.viber.voip.util.e.j;
import com.viber.voip.util.e.j.b;
import com.viber.voip.util.u;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.util.upload.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class x extends l
  implements MessengerDelegate.MessagesSender
{
  private static final Logger d = ViberEnv.getLogger();
  private static final com.viber.voip.e.a.c e = com.viber.voip.e.a.e.b();
  private bv.l A = new bv.l()
  {
    private boolean a(MessageEntity paramAnonymousMessageEntity)
    {
      return (paramAnonymousMessageEntity.getMessageToken() == 0L) && (!paramAnonymousMessageEntity.isDeleted()) && ((paramAnonymousMessageEntity.getStatus() == 0) || (4 == paramAnonymousMessageEntity.getStatus()));
    }

    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
      if ((x.this.b != null) && (paramAnonymousBoolean) && (a(paramAnonymousMessageEntity)))
        x.this.a(Collections.singletonList(paramAnonymousMessageEntity));
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      com.viber.voip.messages.controller.by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };
  private final Runnable B = new y(this);
  private final com.viber.voip.messages.extras.b.a f;
  private final bn g;
  private final ab h;
  private final dagger.a<bs> i;
  private final com.viber.voip.messages.controller.manager.ak j;
  private final ak k;
  private final GroupController l;
  private final com.viber.voip.messages.controller.manager.o m;
  private final bl n;
  private final bk o;
  private final Handler p;
  private final Map<Long, Integer> q = Collections.synchronizedMap(new HashMap());
  private c r;
  private a s;
  private com.viber.voip.messages.extras.image.c t;
  private b u;
  private com.viber.common.permission.c v;
  private final ICdrController w;
  private final com.viber.voip.analytics.story.e.c x;
  private final com.viber.voip.messages.ui.ai y;
  private final dagger.a<com.viber.voip.model.a.d> z;

  public x(Context paramContext, Handler paramHandler, af paramaf, ab paramab, dagger.a<bs> parama, com.viber.voip.messages.controller.manager.ak paramak, ak paramak1, com.viber.voip.messages.controller.manager.o paramo, com.viber.voip.messages.extras.b.a parama1, bl parambl, bn parambn, bk parambk, com.viber.voip.messages.extras.image.c paramc, com.viber.common.permission.c paramc1, ICdrController paramICdrController, GroupController paramGroupController, com.viber.voip.analytics.story.e.c paramc2, com.viber.voip.messages.ui.ai paramai, dagger.a<com.viber.voip.model.a.d> parama2)
  {
    super(paramContext, paramaf);
    this.p = paramHandler;
    this.h = paramab;
    this.i = parama;
    this.j = paramak;
    this.m = paramo;
    this.f = parama1;
    this.n = parambl;
    this.g = parambn;
    this.o = parambk;
    this.w = paramICdrController;
    this.k = paramak1;
    this.l = paramGroupController;
    this.r = new c(null);
    this.s = new a(null);
    this.t = paramc;
    this.u = new b(null);
    this.m.a(this.u, this.p);
    this.m.a(this.A, this.p);
    this.v = paramc1;
    this.x = paramc2;
    this.y = paramai;
    this.z = parama2;
  }

  private int a(MessageEntity paramMessageEntity, int paramInt)
  {
    return paramInt;
  }

  private void a(final int paramInt1, int paramInt2, final long paramLong, String paramString)
  {
    com.viber.voip.model.entity.m localm = this.j.c(new Member(paramString), 1);
    if ((localm != null) && (localm.i() == 0L) && (!cg.c(localm.getNumber())) && (!cd.c(localm.getNumber())))
    {
      this.k.b(localm.getNumber(), new ci.a()
      {
        private void a()
        {
          x.a(x.this, x.a(x.this).c(paramInt1), paramLong, 0, this.c, false);
        }

        public void onGetUserDetail(com.viber.voip.model.entity.m[] paramAnonymousArrayOfm)
        {
          com.viber.voip.model.entity.m localm = paramAnonymousArrayOfm[0];
          if (localm.isOwner())
            a();
          MessageEntity localMessageEntity;
          do
            do
            {
              return;
              localMessageEntity = x.a(x.this).c(paramInt1);
            }
            while ((localMessageEntity == null) || (localMessageEntity.isDeleted()));
          while (localMessageEntity.hasAnyStatus(new int[] { -1 }));
          localMessageEntity.setMemberId(localm.a());
          localMessageEntity.setStatus(0);
          x.a(x.this).b(localMessageEntity);
          x.b(x.this);
        }

        public void onGetUserError()
        {
          a();
        }
      }
      , false);
      return;
    }
    a(this.h.c(paramInt1), paramLong, 0, paramInt2, false);
  }

  private void a(long paramLong1, long paramLong2, int paramInt)
  {
    MessageEntity localMessageEntity = this.h.k(paramLong1);
    if ((localMessageEntity == null) && (paramInt > 0))
      localMessageEntity = this.h.c(paramInt);
    if (localMessageEntity != null)
    {
      this.n.a(localMessageEntity.getId());
      ContentValues localContentValues = new ContentValues(2);
      if (!localMessageEntity.isFormattedMessage())
      {
        localMessageEntity.setMessageToken(paramLong1);
        localContentValues.put("token", Long.valueOf(paramLong1));
      }
      localContentValues.put("status", Integer.valueOf(2));
      localMessageEntity.setStatus(2);
      this.h.a(localMessageEntity.getId(), "messages", localContentValues);
      this.m.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      this.m.b(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      n(localMessageEntity);
    }
    this.b.getPhoneController().handleSendMessageDeliveredAck(paramLong1);
  }

  private void a(long paramLong1, long paramLong2, final long paramLong3, int paramInt)
  {
    com.viber.voip.model.entity.r localr = this.h.d(paramLong2);
    int i1 = com.viber.voip.messages.conversation.publicaccount.a.a.b(paramInt, Math.max(localr.n(), localr.v()));
    final int i2 = this.b.getPhoneController().generateSequence();
    this.b.getDelegatesManager().getPublicGroupGetMessagesListener().registerDelegate(new PublicGroupControllerDelegate.PublicGroupGetMessages()
    {
      public void onGetPublicGroupMessages(int paramAnonymousInt1, long paramAnonymousLong, PublicGroupMessage[] paramAnonymousArrayOfPublicGroupMessage, PublicGroupChangeEvent[] paramAnonymousArrayOfPublicGroupChangeEvent, int paramAnonymousInt2)
      {
        if (paramAnonymousInt1 != i2);
        label149: 
        while (true)
        {
          return;
          x.this.b.getDelegatesManager().getPublicGroupGetMessagesListener().removeDelegate(this);
          int i = paramAnonymousArrayOfPublicGroupMessage.length;
          for (int j = 0; ; j++)
          {
            if (j >= i)
              break label149;
            PublicGroupMessage localPublicGroupMessage = paramAnonymousArrayOfPublicGroupMessage[j];
            if (localPublicGroupMessage.getMessageToken() == paramLong3)
            {
              MessageEntity localMessageEntity = x.a(x.this).l(this.c);
              if ((localMessageEntity == null) || (localMessageEntity.getStatus() == -1))
                break;
              localMessageEntity.setStatus(0);
              Quote localQuote = localMessageEntity.getMessageInfo().getQuote();
              localQuote.setMemberId(localPublicGroupMessage.getPhoneNumber());
              com.viber.voip.messages.m.a(localMessageEntity, localQuote);
              x.a(x.this).b(localMessageEntity);
              x.c(x.this);
              return;
            }
          }
        }
      }
    }
    , this.p);
    ViberApplication.getInstance().getMessagesManager().d().a(i2, paramLong2, i1, false);
  }

  private void a(long paramLong, String paramString)
  {
    MessageEntity localMessageEntity1 = this.h.l(paramLong);
    if (localMessageEntity1 != null);
    try
    {
      com.viber.voip.util.links.d locald = com.viber.voip.util.links.f.d().a(localMessageEntity1.getBody(), com.viber.voip.messages.m.a);
      if (locald == null)
      {
        localMessageEntity1.setStatus(0);
        localMessageEntity1.setExtraStatus(3);
        localMessageEntity1.removeExtraFlag(18);
        com.viber.provider.b localb4 = ab.f();
        localb4.a();
        try
        {
          this.h.b(localMessageEntity1);
          localb4.c();
          localb4.b();
          c();
          return;
        }
        finally
        {
          localb4.b();
        }
      }
      LinkParser.Preview localPreview = LinkParser.generatePreview(locald.b);
      if (localPreview == null)
      {
        localMessageEntity1.setStatus(0);
        localMessageEntity1.setExtraStatus(3);
        localMessageEntity1.removeExtraFlag(18);
        com.viber.provider.b localb3 = ab.f();
        localb3.a();
        try
        {
          this.h.b(localMessageEntity1);
          localb3.c();
          localb3.b();
          c();
          return;
        }
        finally
        {
          localb3.b();
        }
      }
      boolean bool = localMessageEntity1.isBroadcastList();
      i2 = 0;
      Object localObject5 = null;
      if (bool)
      {
        List localList = this.h.m(paramLong);
        localObject5 = localList;
      }
      try
      {
        if (!u.a(localObject5))
        {
          i3 = 1;
          break label1061;
          localMsgInfo1 = localMessageEntity1.getMessageInfo();
          com.viber.voip.util.links.b.a(localMsgInfo1, paramString, locald.b, localPreview);
          localObject7 = null;
          if (i2 == 0)
            break label438;
          localArrayList = new ArrayList(localObject5.size());
          Iterator localIterator3 = localObject5.iterator();
          while (localIterator3.hasNext())
          {
            MessageEntity localMessageEntity6 = (MessageEntity)localIterator3.next();
            MsgInfo localMsgInfo3 = localMessageEntity6.getMessageInfo();
            localArrayList.add(localMsgInfo3);
            com.viber.voip.util.links.b.a(localMsgInfo3, localMessageEntity6.getBody(), locald.b, localPreview);
          }
        }
      }
      finally
      {
        MsgInfo localMsgInfo1;
        Object localObject7;
        ArrayList localArrayList;
        localObject3 = localObject5;
        i1 = i2;
        localObject2 = localObject6;
        localMessageEntity1.setStatus(0);
        localMessageEntity1.setExtraStatus(3);
        localMessageEntity1.removeExtraFlag(18);
        if (i1 != 0)
        {
          Iterator localIterator2 = localObject3.iterator();
          while (localIterator2.hasNext())
          {
            ((MessageEntity)localIterator2.next()).removeExtraFlag(18);
            continue;
            i3 = 0;
            break label1061;
            localObject7 = localArrayList;
            label438: if (bg.a.d(localMsgInfo1.getThumbnailContentType()))
              if (!u.a(localObject7))
                aw.a(localMsgInfo1, (MsgInfo[])localObject7.toArray(new MsgInfo[localObject7.size()]));
            while (com.viber.voip.messages.m.a(localMessageEntity1, localMsgInfo1))
            {
              if (i2 != 0)
              {
                Iterator localIterator4 = localObject5.iterator();
                while (true)
                  if (localIterator4.hasNext())
                  {
                    MessageEntity localMessageEntity5 = (MessageEntity)localIterator4.next();
                    com.viber.voip.messages.m.a(localMessageEntity5, localMessageEntity5.getMessageInfo());
                    localMessageEntity5.setMimeType(8);
                    continue;
                    aw.a(localMsgInfo1, new MsgInfo[0]);
                    break;
                    if (!bg.a.a(localMsgInfo1.getThumbnailContentType()))
                      break;
                    j.b localb = j.b(localMsgInfo1.getThumbnailUrl());
                    if (localb.a == null)
                      break;
                    if (!u.a(localObject7))
                    {
                      Iterator localIterator7 = localObject7.iterator();
                      while (localIterator7.hasNext())
                      {
                        MsgInfo localMsgInfo2 = (MsgInfo)localIterator7.next();
                        localMsgInfo2.setThumbnailHeight(localb.a.outHeight);
                        localMsgInfo2.setThumbnailWidth(localb.a.outWidth);
                      }
                    }
                    localMsgInfo1.setThumbnailHeight(localb.a.outHeight);
                    localMsgInfo1.setThumbnailWidth(localb.a.outWidth);
                    break;
                  }
              }
              if (localMessageEntity1.isEditMessage())
              {
                Edit localEdit = localMessageEntity1.getMessageInfo().getEdit();
                MessageEntity localMessageEntity4 = this.h.k(localEdit.getToken());
                if ((localMessageEntity4 != null) && (!localMessageEntity4.isImage()))
                {
                  localMessageEntity4.setBody(localMessageEntity1.getBody());
                  localMessageEntity4.setRawMessageInfo(localMessageEntity1.getRawMessageInfo());
                  localMessageEntity4.setSpans(localMessageEntity1.getSpans());
                  localMessageEntity4.setMimeType(8);
                  this.h.b(localMessageEntity4);
                }
              }
            }
            localMessageEntity1.setStatus(0);
            localMessageEntity1.setExtraStatus(3);
            localMessageEntity1.removeExtraFlag(18);
            if (i2 != 0)
            {
              Iterator localIterator6 = localObject5.iterator();
              while (localIterator6.hasNext())
                ((MessageEntity)localIterator6.next()).removeExtraFlag(18);
            }
            com.viber.provider.b localb2 = ab.f();
            localb2.a();
            if (i2 != 0)
              try
              {
                Iterator localIterator5 = localObject5.iterator();
                while (localIterator5.hasNext())
                {
                  MessageEntity localMessageEntity3 = (MessageEntity)localIterator5.next();
                  this.h.b(localMessageEntity3);
                }
              }
              finally
              {
                localb2.b();
              }
            this.h.b(localMessageEntity1);
            localb2.c();
            localb2.b();
            c();
            return;
          }
        }
        com.viber.provider.b localb1 = ab.f();
        localb1.a();
        if (i1 != 0)
          try
          {
            Iterator localIterator1 = localObject3.iterator();
            while (localIterator1.hasNext())
            {
              MessageEntity localMessageEntity2 = (MessageEntity)localIterator1.next();
              this.h.b(localMessageEntity2);
            }
          }
          finally
          {
            localb1.b();
          }
        this.h.b(localMessageEntity1);
        localb1.c();
        localb1.b();
        c();
      }
    }
    finally
    {
      while (true)
      {
        int i3;
        Object localObject2 = localObject1;
        int i1 = 0;
        Object localObject3 = null;
        continue;
        label1061: int i2 = i3;
      }
    }
  }

  private void a(long paramLong1, String paramString1, int paramInt1, LocationInfo paramLocationInfo, SendMessageMediaTypeFactory.SendMessageMediaTypeData paramSendMessageMediaTypeData, long paramLong2, byte[] paramArrayOfByte, String paramString2, int paramInt2, int paramInt3, byte paramByte, String paramString3, String paramString4, short paramShort, int paramInt4, long paramLong3)
  {
    this.b.getExchanger().handleCSendGroupMsg(new CSendGroupMsg(paramLong1, paramInt1, paramString1, Location.fromLegacyLocation(paramLocationInfo), (byte)paramSendMessageMediaTypeData.getMediaType(), paramLong2, new byte[0], paramByte, paramArrayOfByte, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramShort, paramInt4, paramLong3, paramSendMessageMediaTypeData.getCdrMediaType(), paramSendMessageMediaTypeData.getCdrExtraData()));
  }

  private void a(final long paramLong, final String paramString, final boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!com.viber.common.d.a.g())
      ViberApplication.getInstance().logToCrashlytics("convertVideo");
    e.a("MEDIA", "video convert", paramLong);
    dy.b.a local5 = new dy.b.a()
    {
      private void a(final long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        x.d(x.this).post(new Runnable()
        {
          public void run()
          {
            MessageEntity localMessageEntity = x.a(x.this).l(paramAnonymousLong);
            if ((localMessageEntity != null) && (localMessageEntity.getStatus() != -1))
            {
              if (this.b)
              {
                localMessageEntity.addExtraFlag(15);
                if (x.5.this.b)
                  x.a(x.this).c(paramAnonymousLong, 15, true);
              }
              localMessageEntity.setStatus(0);
              localMessageEntity.setExtraStatus(2);
              x.a(x.this).b(localMessageEntity);
              x.a().b("MEDIA", "video convert", paramAnonymousLong);
              x.c(x.this);
            }
          }
        });
      }

      public void a(Uri paramAnonymousUri)
      {
      }

      public void a(Uri paramAnonymousUri1, Uri paramAnonymousUri2)
      {
        x.a().a("MEDIA", "video convert", "process file end", paramLong);
        File localFile = at.a(x.this.a, paramAnonymousUri2);
        if ((localFile == null) || (localFile.length() > 25165824L))
        {
          x.a(x.this, paramLong, paramBoolean1);
          if (!paramAnonymousUri1.getPath().equals(paramAnonymousUri2.getPath()))
            at.f(localFile);
          if (!paramString)
            com.viber.voip.ui.dialogs.o.f().d();
          return;
        }
        a(paramLong, false);
      }

      public void a(String paramAnonymousString)
      {
        File localFile = at.a(x.this.a, Uri.parse(this.d));
        if (localFile == null)
        {
          x.a(x.this, paramLong, paramBoolean1);
          if (!paramString)
            com.viber.voip.ui.dialogs.o.f().d();
        }
        do
        {
          do
          {
            do
            {
              return;
              if (at.a.c != at.b(localFile.length()))
                break;
              x.a(x.this, paramLong, paramBoolean1);
            }
            while (paramString);
            h.a locala1 = com.viber.voip.ui.dialogs.o.h();
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = localFile.getName();
            arrayOfObject2[1] = Integer.valueOf(200);
            locala1.b(-1, arrayOfObject2).d();
            return;
            if (at.a.b != at.b(localFile.length()))
              break;
          }
          while (paramString);
          l.a locala = com.viber.voip.ui.dialogs.o.g();
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = localFile.getName();
          arrayOfObject1[1] = Integer.valueOf(50);
          locala.b(-1, arrayOfObject1).a(new ViberDialogHandlers.cu(paramLong, paramBoolean1)).d();
          return;
          if (localFile.length() <= 25165824L)
            break;
        }
        while (paramString);
        com.viber.voip.ui.dialogs.o.i().a(new ViberDialogHandlers.cu(paramLong, paramBoolean1)).d();
        return;
        a(paramLong, true);
      }
    };
    if (paramString != null)
    {
      dy.a().a(Uri.parse(paramString), local5);
      return;
    }
    local5.a("Video converter is unavailable");
  }

  private void a(long paramLong, boolean paramBoolean)
  {
    com.viber.voip.messages.controller.ai localai = ViberApplication.getInstance().getMessagesManager().c();
    localai.a(Collections.singleton(Long.valueOf(paramLong)), false, null);
    if (paramBoolean)
      localai.c(paramLong, null);
  }

  private void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f.a(2, paramLong, new z(this, paramLong, paramBoolean1, paramBoolean2));
  }

  private void a(MessageEntity paramMessageEntity, long paramLong)
  {
    if (!b(paramMessageEntity, paramLong));
    List localList;
    do
    {
      do
        return;
      while (!paramMessageEntity.isBroadcastList());
      localList = this.h.m(paramMessageEntity.getId());
    }
    while (u.a(localList));
    com.viber.provider.b localb = ab.f();
    localb.a();
    try
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        MessageEntity localMessageEntity = (MessageEntity)localIterator.next();
        if (b(localMessageEntity, paramLong))
          this.h.b(localMessageEntity);
      }
    }
    finally
    {
      localb.b();
    }
    localb.c();
    localb.b();
  }

  private void a(MessageEntity paramMessageEntity, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = 2;
    if (paramMessageEntity == null)
      return;
    switch (paramInt1)
    {
    default:
      b(paramMessageEntity, false);
      label91: if ((this.h.y(paramMessageEntity.getConversationId()) == 0L) && (!paramMessageEntity.isBroadcastList()) && (!paramMessageEntity.isOneToOneChatWithPa()))
      {
        this.h.a(paramMessageEntity.isPublicGroupBehavior(), paramMessageEntity.getConversationId());
        this.h.f(paramMessageEntity.getConversationId(), paramMessageEntity.getConversationType());
      }
      if (paramMessageEntity.isDeleted())
        this.m.a(Collections.singleton(Long.valueOf(paramMessageEntity.getConversationId())), true);
      break;
    case 1:
    case 2:
    case 16:
    case 17:
    case 14:
    case 7:
    case 20:
    case 0:
    }
    while (true)
    {
      b(paramMessageEntity, paramInt1);
      return;
      this.n.a(paramMessageEntity.getId());
      m(paramMessageEntity);
      if (paramMessageEntity.getStatus() != i1)
        if (!paramMessageEntity.isCommunityType())
          break label352;
      while (true)
      {
        paramMessageEntity.setStatus(i1);
        long l1 = System.currentTimeMillis();
        if (l1 - paramMessageEntity.getDate() > 60000L)
          paramMessageEntity.setDate(l1);
        paramMessageEntity.setMessageToken(paramLong);
        if ((paramMessageEntity.isPublicGroupBehavior()) && (paramInt2 > 0))
        {
          paramMessageEntity.setMessageGlobalId(paramInt2);
          if (((paramMessageEntity.isCommunityType()) && (paramMessageEntity.isDeletePinMessage())) || (paramMessageEntity.isEditMessage()))
          {
            paramMessageEntity.removeExtraFlag(22);
            paramMessageEntity.setMimeType(1007);
          }
        }
        l(paramMessageEntity);
        c(paramMessageEntity);
        d(paramMessageEntity);
        e(paramMessageEntity);
        this.h.b(paramMessageEntity);
        if (!paramMessageEntity.isForwardedMessage())
          break;
        a(paramMessageEntity.getConversationId());
        break;
        label352: i1 = 1;
      }
      if (paramMessageEntity.getStatus() == -1)
        break label91;
      paramMessageEntity.setStatus(0);
      this.h.b(paramMessageEntity);
      c();
      break label91;
      com.viber.voip.ui.dialogs.r.n().d();
      a(paramMessageEntity.getId(), false);
      break label91;
      com.viber.voip.ui.dialogs.r.o().d();
      a(paramMessageEntity.getId(), false);
      break label91;
      this.h.I(paramMessageEntity.getId());
      break label91;
      b(paramMessageEntity, false);
      if (paramMessageEntity.isPublicGroupBehavior())
      {
        h localh = this.h.f(paramMessageEntity.getConversationId());
        this.l.a(this.b.getPhoneController().generateSequence(), paramMessageEntity.getGroupId(), null, 1, paramMessageEntity.getConversationType(), localh.p());
      }
      com.viber.voip.ui.dialogs.k.n().d();
      break label91;
      if (paramMessageEntity.isActiveOneToOneBroadcast())
      {
        a(paramMessageEntity.getId(), false);
        MessageEntity localMessageEntity = this.h.l(paramMessageEntity.getBroadcastMessageId());
        if (localMessageEntity == null)
          break label91;
        this.l.b(localMessageEntity.getConversationId(), paramMessageEntity.getMemberId());
        break label91;
      }
      if ((paramBoolean) && (!paramMessageEntity.isGroupBehavior()))
      {
        a(paramMessageEntity.getMessageSeq(), paramInt2, paramMessageEntity.getMessageToken(), paramMessageEntity.getMemberId());
        return;
      }
      this.g.b(paramMessageEntity);
      break;
      this.m.a(paramMessageEntity.getConversationId(), paramLong, false);
      this.m.b(paramMessageEntity.getConversationId(), paramLong, false);
    }
  }

  private void a(MessageEntity paramMessageEntity, Map<String, List<MessageEntity>> paramMap, boolean[] paramArrayOfBoolean, String paramString)
  {
    paramMessageEntity.setStatus(-1);
    this.h.b(paramMessageEntity);
    this.h.b(paramMessageEntity);
    if (!a(paramArrayOfBoolean[1], paramMessageEntity, paramString))
    {
      Object localObject = (List)paramMap.get(paramMessageEntity.getMemberId());
      if (localObject == null)
      {
        localObject = new ArrayList();
        paramMap.put(paramMessageEntity.getMemberId(), localObject);
      }
      ((List)localObject).add(paramMessageEntity);
    }
    k(paramMessageEntity);
  }

  private void a(String paramString1, String paramString2, int paramInt1, LocationInfo paramLocationInfo, SendMessageMediaTypeFactory.SendMessageMediaTypeData paramSendMessageMediaTypeData, long paramLong1, byte[] paramArrayOfByte, String paramString3, int paramInt2, int paramInt3, byte paramByte, String paramString4, String paramString5, short paramShort, int paramInt4, long paramLong2)
  {
    this.b.getExchanger().handleCSendMessageMsg(new CSendMessageMsg(paramString1, paramString2, paramInt1, Location.fromLegacyLocation(paramLocationInfo), (byte)paramSendMessageMediaTypeData.getMediaType(), paramLong1, new byte[0], paramByte, paramArrayOfByte, paramInt2, paramInt3, paramString3, paramString4, paramString5, paramShort, paramInt4, paramLong2, paramSendMessageMediaTypeData.getCdrMediaType(), paramSendMessageMediaTypeData.getCdrExtraData()));
  }

  private void a(Collection<List<MessageEntity>> paramCollection)
  {
    com.viber.voip.ui.dialogs.e.a(b(paramCollection)).d();
  }

  private void a(boolean paramBoolean, MessageEntity paramMessageEntity)
  {
    if (!a(paramBoolean, paramMessageEntity, "sendPendingMessages: no connection, timeout"))
      com.viber.voip.ui.dialogs.e.a(paramMessageEntity).d();
  }

  private boolean a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, LocationInfo paramLocationInfo, SendMessageMediaTypeFactory.SendMessageMediaTypeData paramSendMessageMediaTypeData, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong3)
  {
    a(paramLong1, paramString1, paramInt1, paramLocationInfo, paramSendMessageMediaTypeData, paramLong2, paramArrayOfByte, paramString4, paramInt2, 0, (byte)paramInt3, paramString2, paramString3, (short)paramInt4, paramInt5, paramLong3);
    return true;
  }

  private boolean a(long paramLong1, byte[] paramArrayOfByte, SendMessageMediaTypeFactory.SendMessageMediaTypeData paramSendMessageMediaTypeData, int paramInt1, long paramLong2, LocationInfo paramLocationInfo, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, int paramInt4, long paramLong3)
  {
    a(paramLong1, paramString1, paramInt1, paramLocationInfo, paramSendMessageMediaTypeData, paramLong2, paramArrayOfByte, paramString4, 0, 0, (byte)paramInt2, paramString2, paramString3, (short)paramInt3, paramInt4, paramLong3);
    return true;
  }

  private boolean a(MessageEntity paramMessageEntity, int paramInt, String paramString1, String paramString2, ObjectId paramObjectId, long paramLong)
  {
    int i1;
    boolean bool1;
    boolean bool2;
    if (paramInt > 0)
    {
      i1 = 1;
      bool1 = paramMessageEntity.isFile();
      bool2 = paramMessageEntity.isVideo();
      if ((!paramMessageEntity.isImage()) && (!bool2) && (!bool1))
        break label70;
    }
    label70: for (int i2 = 1; ; i2 = 0)
    {
      if ((i1 != 0) || (!paramObjectId.isEmpty()) || (i2 == 0))
        break label76;
      b(paramMessageEntity);
      return false;
      i1 = 0;
      break;
    }
    label76: com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageSendDelegateImpl sendMedia getThumbnailBytes");
    int i3;
    if ((!bool1) || (paramMessageEntity.isGifFile()))
    {
      boolean bool3 = paramMessageEntity.isLocationMessage();
      i3 = 0;
      if (!bool3);
    }
    else
    {
      i3 = 1;
    }
    com.viber.voip.messages.extras.image.c localc = this.t;
    if (i3 != 0);
    byte[] arrayOfByte;
    for (String str = ""; ; str = paramMessageEntity.getBody())
    {
      arrayOfByte = localc.c(str);
      com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageSendDelegateImpl sendMedia getThumbnailBytes");
      if (((!bool2) || (paramMessageEntity.isWinkVideo())) && (!paramMessageEntity.isShortVideo()))
        break;
      return a(paramMessageEntity, paramString1, paramString2, paramObjectId, arrayOfByte, paramLong);
    }
    return a(paramMessageEntity, paramString1, paramString2, arrayOfByte, paramLong);
  }

  private boolean a(MessageEntity paramMessageEntity1, MessageEntity paramMessageEntity2)
  {
    if (!paramMessageEntity1.isActiveOneToOneBroadcast())
      return false;
    if (paramMessageEntity2 == null)
      paramMessageEntity2 = this.h.l(paramMessageEntity1.getBroadcastMessageId());
    if ((paramMessageEntity2 == null) || (paramMessageEntity2.isDeleted()) || (paramMessageEntity2.getStatus() != 3))
      return false;
    Iterator localIterator = this.h.m(paramMessageEntity2.getId()).iterator();
    while (localIterator.hasNext())
    {
      MessageEntity localMessageEntity = (MessageEntity)localIterator.next();
      if ((localMessageEntity.getId() != paramMessageEntity1.getId()) && (localMessageEntity.getStatus() != -1))
        return false;
    }
    c(paramMessageEntity2, -1);
    return true;
  }

  private boolean a(MessageEntity paramMessageEntity, ObjectId paramObjectId, long paramLong)
  {
    int i1 = com.viber.voip.messages.m.j(paramMessageEntity);
    String str = com.viber.voip.messages.m.i(paramMessageEntity);
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(0, paramMessageEntity);
    if (paramMessageEntity.isGroupBehavior())
      return a(paramMessageEntity.getGroupId(), paramMessageEntity.getBody(), paramMessageEntity.getMessageSeq(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, i1, paramObjectId.toLong(), str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    return a(paramMessageEntity.getMemberId(), paramMessageEntity.getBody(), paramMessageEntity.getMessageSeq(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, i1, paramObjectId.toLong(), str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), 0L);
  }

  private boolean a(MessageEntity paramMessageEntity, String paramString1, String paramString2, long paramLong)
  {
    int i1 = com.viber.voip.messages.m.j(paramMessageEntity);
    String str = com.viber.voip.messages.m.i(paramMessageEntity);
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(2, paramMessageEntity);
    if (paramMessageEntity.isGroupBehavior())
      a(paramMessageEntity.getGroupId(), "", paramMessageEntity.getMessageSeq(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, paramMessageEntity.getObjectId().toLong(), new byte[0], str, 0, (int)paramMessageEntity.getDuration(), (byte)i1, paramString1, paramString2, (short)paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    while (true)
    {
      return true;
      a(paramMessageEntity.getMemberId(), "", paramMessageEntity.getMessageSeq(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, paramMessageEntity.getObjectId().toLong(), new byte[0], str, 0, (int)paramMessageEntity.getDuration(), (byte)i1, paramString1, paramString2, (short)paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    }
  }

  private boolean a(MessageEntity paramMessageEntity, String paramString1, String paramString2, ObjectId paramObjectId, byte[] paramArrayOfByte, long paramLong)
  {
    int i1 = com.viber.voip.messages.m.j(paramMessageEntity);
    String str = com.viber.voip.messages.m.i(paramMessageEntity);
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(3, paramMessageEntity);
    int i2 = (int)paramMessageEntity.getDuration();
    if (paramMessageEntity.isGroupBehavior())
      return a(paramMessageEntity.getGroupId(), paramArrayOfByte, paramMessageEntity.getMessageSeq(), paramObjectId.toLong(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, paramMessageEntity.getDescription(), i2, i1, paramString1, paramString2, str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    return a(paramMessageEntity.getMemberId(), paramArrayOfByte, paramMessageEntity.getMessageSeq(), paramObjectId.toLong(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, paramMessageEntity.getDescription(), i2, i1, paramString1, paramString2, str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
  }

  private boolean a(MessageEntity paramMessageEntity, String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageSendDelegateImpl sendMediaMessage to voicelib");
    int i1 = com.viber.voip.messages.m.j(paramMessageEntity);
    String str = com.viber.voip.messages.m.i(paramMessageEntity);
    int i2;
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData;
    if (paramMessageEntity.isWink())
    {
      i2 = 11;
      localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(i2, paramMessageEntity);
      if (!paramMessageEntity.isGroupBehavior())
        break label180;
      a(paramMessageEntity.getGroupId(), paramArrayOfByte, localSendMessageMediaTypeData, paramMessageEntity.getMessageSeq(), paramMessageEntity.getObjectId().toLong(), paramMessageEntity.getLocation(), paramMessageEntity.getDescription(), i1, paramString1, paramString2, str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    }
    while (true)
    {
      com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageSendDelegateImpl sendMediaMessage to voicelib");
      return true;
      if (paramMessageEntity.isGifFile())
      {
        i2 = 10;
        break;
      }
      if (paramMessageEntity.isRichMessage())
      {
        i2 = 12;
        break;
      }
      if (paramMessageEntity.isVoiceMessage())
      {
        i2 = 10;
        break;
      }
      if (paramMessageEntity.isShortVideo())
      {
        i2 = 3;
        break;
      }
      i2 = paramMessageEntity.getMimeType();
      break;
      label180: a(paramMessageEntity.getMemberId(), paramArrayOfByte, localSendMessageMediaTypeData, paramMessageEntity.getMessageSeq(), paramMessageEntity.getObjectId().toLong(), paramMessageEntity.getLocation(), paramMessageEntity.getDescription(), i1, paramString1, paramString2, str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    }
  }

  private boolean a(MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    boolean bool = paramMessageEntity.isActiveOneToOneBroadcast();
    if (da.a(paramMessageEntity.getMediaUri()))
      b(paramMessageEntity);
    while (true)
    {
      return false;
      if ((paramBoolean) || (!com.viber.voip.util.by.a(this.a)) || (bool))
      {
        if ((paramMessageEntity.isImage()) && (paramMessageEntity.getMediaFlag() == 0))
        {
          k localk = new k(this.t, this.a, this.h, this.m, this.o, this.r, this.b, this, paramMessageEntity);
          localk.i();
          this.x.a(paramMessageEntity.getMessageSeq(), Uri.fromFile(localk.a()));
          return true;
        }
        if (paramMessageEntity.isImage())
        {
          a(paramMessageEntity, Uri.parse(paramMessageEntity.getMediaUri()));
        }
        else if ((paramMessageEntity.isFile()) || (paramMessageEntity.isVideoPtt()))
        {
          a(paramMessageEntity, Uri.parse(paramMessageEntity.getMediaUri()));
        }
        else if (paramMessageEntity.isAudioPtt())
        {
          a(paramMessageEntity, Uri.fromFile(new File(PttUtils.getPttFileNameFromPttId(paramMessageEntity.getMediaUri(), this.a))));
        }
        else if ((paramMessageEntity.isVideo()) || (paramMessageEntity.isShortVideo()))
        {
          if ((paramMessageEntity.isVideo()) && (paramMessageEntity.usesVideoConverter()));
          for (Uri localUri = Uri.fromFile(dy.b(Uri.parse(paramMessageEntity.getMediaUri()))); ; localUri = Uri.parse(paramMessageEntity.getMediaUri()))
          {
            if (at.d(this.a, localUri.toString()))
              break label286;
            b(paramMessageEntity);
            break;
          }
          label286: a(paramMessageEntity, at.c(this.a, localUri));
          a(paramMessageEntity, localUri);
        }
      }
      else
      {
        paramMessageEntity.setStatus(4);
        this.o.a(paramMessageEntity.getId());
      }
    }
  }

  private boolean a(String paramString1, byte[] paramArrayOfByte, int paramInt1, long paramLong1, LocationInfo paramLocationInfo, SendMessageMediaTypeFactory.SendMessageMediaTypeData paramSendMessageMediaTypeData, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, long paramLong2)
  {
    a(paramString1, paramString2, paramInt1, paramLocationInfo, paramSendMessageMediaTypeData, paramLong1, paramArrayOfByte, paramString5, paramInt2, 0, (byte)paramInt3, paramString3, paramString4, (short)paramInt4, paramInt5, paramLong2);
    return true;
  }

  private boolean a(String paramString1, byte[] paramArrayOfByte, SendMessageMediaTypeFactory.SendMessageMediaTypeData paramSendMessageMediaTypeData, int paramInt1, long paramLong1, LocationInfo paramLocationInfo, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4, long paramLong2)
  {
    a(paramString1, paramString2, paramInt1, paramLocationInfo, paramSendMessageMediaTypeData, paramLong1, paramArrayOfByte, paramString5, 0, 0, (byte)paramInt2, paramString3, paramString4, (short)paramInt3, paramInt4, paramLong2);
    return true;
  }

  private boolean a(boolean paramBoolean, MessageEntity paramMessageEntity, String paramString)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      if (!paramMessageEntity.isActiveOneToOneBroadcast())
        com.viber.voip.ui.dialogs.f.b().d();
      this.m.a(paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken(), false);
      bool = true;
    }
    return bool;
  }

  private MessageEntity b(MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    paramMessageEntity.setStatus(-1);
    boolean bool1 = paramMessageEntity.isActiveOneToOneBroadcast();
    MessageEntity localMessageEntity1;
    boolean bool2;
    if (bool1)
    {
      localMessageEntity1 = this.h.l(paramMessageEntity.getBroadcastMessageId());
      bool2 = a(paramMessageEntity, localMessageEntity1);
      if ((bool2) && (localMessageEntity1 != null) && (localMessageEntity1.isForwardedMessage()))
        this.h.a(localMessageEntity1, -1);
    }
    while (true)
    {
      if (paramMessageEntity.isEditMessage())
      {
        Edit localEdit = paramMessageEntity.getMessageInfo().getEdit();
        MessageEntity localMessageEntity4 = this.h.k(localEdit.getToken());
        if (localMessageEntity4 != null)
          if (!localMessageEntity4.hasAnyStatus(new int[] { -1 }))
          {
            localMessageEntity4.setStatus(-1);
            this.h.b(paramMessageEntity);
            paramMessageEntity = localMessageEntity4;
          }
      }
      if (paramMessageEntity.isPollOptionMessage())
      {
        MessageEntity localMessageEntity2 = this.h.c(paramMessageEntity.getMessageInfo().getPoll().getParentSeq());
        if (localMessageEntity2 != null)
          if (!paramMessageEntity.hasAnyStatus(new int[] { 1 }))
          {
            localMessageEntity2.setStatus(-1);
            for (PollUiOptions localPollUiOptions : localMessageEntity2.getMessageInfo().getPoll().getOptions())
            {
              MessageEntity localMessageEntity3 = this.h.c(localPollUiOptions.getSeq());
              if ((localMessageEntity3 != null) && (localMessageEntity3.isPollOptionMessage()) && (localMessageEntity3.isToSend()))
                if (!localMessageEntity3.hasAnyStatus(new int[] { -1 }))
                {
                  localMessageEntity3.setStatus(-1);
                  this.h.b(localMessageEntity3);
                }
            }
            paramMessageEntity = localMessageEntity2;
          }
      }
      if (paramMessageEntity.isForwardedMessage())
      {
        this.h.a(paramMessageEntity, -1);
        this.h.b(paramMessageEntity);
        if (!bool1)
          break label365;
        if ((localMessageEntity1 == null) || (!bool2))
          break label373;
      }
      while (true)
      {
        if ((paramBoolean) && (localMessageEntity1 != null) && (!c(localMessageEntity1, bool2)))
        {
          return null;
          this.h.b(paramMessageEntity);
          break;
          label365: localMessageEntity1 = paramMessageEntity;
          continue;
        }
        return paramMessageEntity;
        label373: localMessageEntity1 = null;
      }
      bool2 = false;
      localMessageEntity1 = null;
    }
  }

  private Queue<e.a> b(Collection<List<MessageEntity>> paramCollection)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = paramCollection.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
        localLinkedList.add(new e.a((MessageEntity)localIterator2.next()));
    }
    return localLinkedList;
  }

  private void b(MessageEntity paramMessageEntity, int paramInt)
  {
    if (!paramMessageEntity.isPublicAccount());
    com.viber.voip.model.entity.r localr;
    do
    {
      do
        return;
      while (1 != paramInt);
      localr = this.h.e(paramMessageEntity.getConversationId());
    }
    while ((localr == null) || (localr.r()));
    String str = localr.b();
    ((bs)this.i.get()).a(str, true);
    this.m.b(str);
    g.a().a(i.k(str));
  }

  private boolean b(MessageEntity paramMessageEntity, long paramLong)
  {
    MsgInfo localMsgInfo = paramMessageEntity.getMessageInfo();
    localMsgInfo.getFileInfo().setFileSize(paramLong);
    paramMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
    return true;
  }

  private boolean b(MessageEntity paramMessageEntity, ObjectId paramObjectId, long paramLong)
  {
    int i1 = com.viber.voip.messages.m.j(paramMessageEntity);
    String str = com.viber.voip.messages.m.i(paramMessageEntity);
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(0, paramMessageEntity);
    if (!da.a(paramMessageEntity.getBucket()))
    {
      if (!paramMessageEntity.isGroupBehavior())
        return a(paramMessageEntity.getMemberId(), paramMessageEntity.getBucket(), paramMessageEntity.getMessageSeq(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, i1, paramObjectId.toLong(), str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
      return a(paramMessageEntity.getGroupId(), paramMessageEntity.getBucket(), paramMessageEntity.getMessageSeq(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, i1, paramObjectId.toLong(), str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    }
    this.n.a(paramMessageEntity.getId());
    paramMessageEntity.setStatus(2);
    return true;
  }

  private void c()
  {
    this.p.removeCallbacks(this.B);
    this.p.post(this.B);
  }

  private void c(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isEngagementMessage());
    h localh;
    do
    {
      return;
      paramMessageEntity.removeExtraFlag(26);
      long l1 = paramMessageEntity.getConversationId();
      localh = this.h.f(l1);
    }
    while ((localh == null) || (!localh.P()));
    ((bs)this.i.get()).h(localh.getId(), false);
    ((bs)this.i.get()).a(localh.getId());
  }

  private void c(MessageEntity paramMessageEntity, int paramInt)
  {
    paramMessageEntity.setStatus(paramInt);
    ((bs)this.i.get()).c(paramMessageEntity);
  }

  private boolean c(MessageEntity paramMessageEntity, long paramLong)
  {
    int i1 = com.viber.voip.messages.m.j(paramMessageEntity);
    String str = "";
    FormattedMessage localFormattedMessage = paramMessageEntity.getFormattedMessage();
    if ((localFormattedMessage != null) && (localFormattedMessage.canDoAction(ActionType.FORWARD)))
    {
      ForwardAction localForwardAction = (ForwardAction)localFormattedMessage.getAction(ActionType.FORWARD);
      if (localForwardAction != null)
        str = localForwardAction.getForwardString();
    }
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(7, paramMessageEntity);
    a(paramMessageEntity.getMemberId(), "", paramMessageEntity.getMessageSeq(), paramMessageEntity.getLocation(), localSendMessageMediaTypeData, 0L, new byte[0], str, 0, 0, (byte)i1, "", "", (short)paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    return true;
  }

  private boolean c(MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    h localh = this.h.f(paramMessageEntity.getConversationId());
    if (localh == null)
      return paramBoolean;
    if (paramMessageEntity.isBroadcastList())
      dg.c(localh.o());
    while (true)
    {
      this.n.b(paramMessageEntity);
      return true;
      if (paramMessageEntity.isGroupBehavior())
        dg.b(localh.o());
      else
        com.viber.voip.messages.d.c.c().a(paramMessageEntity.getMemberId(), localh.j(), localh.p());
    }
  }

  private void d()
  {
    a(this.h.i());
  }

  private void d(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isStartNewUserConversationMessage());
    h localh;
    do
    {
      return;
      paramMessageEntity.removeExtraFlag(30);
      long l1 = paramMessageEntity.getConversationId();
      localh = this.h.f(l1);
    }
    while ((localh == null) || (!localh.Q()));
    ((bs)this.i.get()).g(localh.getId(), false);
  }

  private void d(MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    ViberApplication.getInstance().getMessagesManager().c().a(paramMessageEntity.getId(), paramMessageEntity.getDownloadId());
  }

  private boolean d(MessageEntity paramMessageEntity, long paramLong)
  {
    int i1 = com.viber.voip.messages.m.j(paramMessageEntity);
    String str = com.viber.voip.messages.m.i(paramMessageEntity);
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(8, paramMessageEntity);
    if (paramMessageEntity.isGroupBehavior())
      return a(paramMessageEntity.getGroupId(), new byte[0], localSendMessageMediaTypeData, paramMessageEntity.getMessageSeq(), 0L, paramMessageEntity.getLocation(), paramMessageEntity.getMessageInfo().getText(), i1, "", "", str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    return a(paramMessageEntity.getMemberId(), new byte[0], localSendMessageMediaTypeData, paramMessageEntity.getMessageSeq(), 0L, paramMessageEntity.getLocation(), paramMessageEntity.getMessageInfo().getText(), i1, "", "", str, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
  }

  private void e(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isPublicAccount());
    while (true)
    {
      return;
      long l1 = paramMessageEntity.getConversationId();
      MessageEntity localMessageEntity1 = this.h.t(l1);
      int i1;
      if (localMessageEntity1 == null)
        i1 = 1;
      while (i1 != 0)
      {
        paramMessageEntity.addExtraFlag(24);
        return;
        MessageEntity localMessageEntity2 = this.h.u(l1);
        if ((localMessageEntity2 != null) && (com.viber.voip.publicaccount.d.e.a(localMessageEntity1.getDate(), localMessageEntity2.getDate(), paramMessageEntity.getDate())))
          i1 = 1;
        else if (com.viber.voip.publicaccount.d.e.a(localMessageEntity1.getDate(), paramMessageEntity.getDate()))
          i1 = 1;
        else
          i1 = 0;
      }
    }
  }

  private boolean e(MessageEntity paramMessageEntity, long paramLong)
  {
    int i1 = com.viber.voip.messages.m.j(paramMessageEntity);
    String str1 = com.viber.voip.messages.m.i(paramMessageEntity);
    String str2 = paramMessageEntity.getMessageInfo().getName();
    String str3 = paramMessageEntity.getMessageInfo().getPhoneNumber();
    if (!da.a(str2))
      str3 = str2 + " " + str3;
    SendMessageMediaTypeFactory.SendMessageMediaTypeData localSendMessageMediaTypeData = SendMessageMediaTypeFactory.createMediaTypeData(9, paramMessageEntity);
    if (paramMessageEntity.isGroupBehavior())
      return a(paramMessageEntity.getGroupId(), new byte[0], localSendMessageMediaTypeData, paramMessageEntity.getMessageSeq(), 0L, paramMessageEntity.getLocation(), str3, i1, "", "", str1, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
    return a(paramMessageEntity.getMemberId(), new byte[0], localSendMessageMediaTypeData, paramMessageEntity.getMessageSeq(), 0L, paramMessageEntity.getLocation(), str3, i1, "", "", str1, paramMessageEntity.getNativeChatType(), paramMessageEntity.getTimebombInSec(), paramLong);
  }

  private void f(MessageEntity paramMessageEntity)
  {
    this.n.a(paramMessageEntity.getId());
    com.viber.provider.b localb = ab.f();
    localb.a();
    List localList;
    int i1;
    while (true)
    {
      try
      {
        localList = this.h.m(paramMessageEntity.getId());
        if (!u.a(localList))
        {
          i1 = 1;
          if (i1 == 0)
            break;
          Iterator localIterator1 = localList.iterator();
          if (!localIterator1.hasNext())
            break;
          MessageEntity localMessageEntity2 = (MessageEntity)localIterator1.next();
          if (!localMessageEntity2.hasAnyStatus(new int[] { -1, 12 }))
            continue;
          localMessageEntity2.setStatus(0);
          if (localMessageEntity2.isResendMessage())
            localMessageEntity2.setDate(System.currentTimeMillis());
          this.h.b(localMessageEntity2);
          this.h.f(localMessageEntity2.getConversationId(), localMessageEntity2.getConversationType());
          continue;
        }
      }
      finally
      {
        localb.b();
      }
      i1 = 0;
    }
    localb.c();
    localb.b();
    if (i1 != 0)
    {
      this.w.handleReportBroadcastSendMessage(com.viber.voip.messages.l.b(paramMessageEntity.getMimeType()), paramMessageEntity.getMediaFlag(), localList.size(), paramMessageEntity.getMessageSeq());
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        MessageEntity localMessageEntity1 = (MessageEntity)localIterator2.next();
        this.m.a(localMessageEntity1.getConversationId(), localMessageEntity1.getMessageToken(), false);
      }
      c();
    }
    a(paramMessageEntity.getConversationId());
  }

  private void g(MessageEntity paramMessageEntity)
  {
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageSendDelegateImpl onPostMessageSent");
    paramMessageEntity.setStatus(3);
    if (!paramMessageEntity.isResendMessage())
      paramMessageEntity.addExtraFlag(9);
    this.h.b(paramMessageEntity);
    if (paramMessageEntity.isActiveOneToOneBroadcast())
      if (this.h.z(paramMessageEntity.getBroadcastMessageId()) == 0L)
        h(paramMessageEntity);
    while (true)
    {
      boolean bool = com.viber.voip.messages.m.a(paramMessageEntity.getConversationType(), paramMessageEntity.getMemberId(), null);
      this.x.a(ae.b(), paramMessageEntity, bp.b(this.a), n.a(paramMessageEntity, this.y), bool);
      g.a().a(i.b());
      com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageSendDelegateImpl onPostMessageSent");
      return;
      if (!paramMessageEntity.isBroadcastList())
        h(paramMessageEntity);
    }
  }

  private void h(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isMediaWithThumbnail())
      this.t.a(paramMessageEntity.getBody());
    if (paramMessageEntity.isWinkImage())
      at.d(this.a, dv.e.a(this.a, paramMessageEntity.getMediaUri(), false));
    while (!paramMessageEntity.isImage())
      return;
    at.d(this.a, dv.h.a(this.a, paramMessageEntity.getMediaUri(), false));
  }

  private boolean i(MessageEntity paramMessageEntity)
  {
    boolean bool = bk.a(paramMessageEntity);
    EncryptionParams localEncryptionParams = paramMessageEntity.getEncryptionParams();
    return ((!EncryptionParams.contentIsEncrypted(localEncryptionParams)) && (bool)) || ((EncryptionParams.contentIsEncrypted(localEncryptionParams)) && (!bool));
  }

  private void j(MessageEntity paramMessageEntity)
  {
    paramMessageEntity.setStatus(0);
    paramMessageEntity.setExtraStatus(3);
    if (!paramMessageEntity.isForwardedFromPG())
    {
      if ((!paramMessageEntity.isVideo()) || (paramMessageEntity.isForwardedMessage()))
        break label38;
      paramMessageEntity.setExtraStatus(8);
    }
    label38: 
    do
    {
      return;
      if ((!paramMessageEntity.isUrlMessage()) && (paramMessageEntity.hasExtraFlagNeedFetchUrlByBody()))
      {
        paramMessageEntity.setExtraStatus(10);
        return;
      }
    }
    while ((!paramMessageEntity.isImage()) && (!paramMessageEntity.isFile()));
    if (paramMessageEntity.isForwardedMessage());
    for (int i1 = 9; ; i1 = 2)
    {
      paramMessageEntity.setExtraStatus(i1);
      return;
    }
  }

  private boolean k(MessageEntity paramMessageEntity)
  {
    return a(paramMessageEntity, null);
  }

  private void l(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isPollMessage());
    MessageEntity localMessageEntity;
    MsgInfo localMsgInfo;
    Poll localPoll2;
    do
    {
      do
      {
        return;
        if (!paramMessageEntity.isPollOptionMessage())
          break;
        Poll localPoll1 = paramMessageEntity.getMessageInfo().getPoll();
        localMessageEntity = this.h.c(localPoll1.getParentSeq());
      }
      while (localMessageEntity == null);
      localMsgInfo = localMessageEntity.getMessageInfo();
      localPoll2 = localMsgInfo.getPoll();
    }
    while ((localPoll2.getTokens() == null) || (Arrays.binarySearch(localPoll2.getTokens(), paramMessageEntity.getMessageToken()) >= 0));
    long[] arrayOfLong = new long[1 + localPoll2.getTokens().length];
    for (int i1 = 0; i1 < localPoll2.getTokens().length; i1++)
      arrayOfLong[i1] = localPoll2.getTokens()[i1];
    arrayOfLong[localPoll2.getTokens().length] = paramMessageEntity.getMessageToken();
    localPoll2.setTokens(arrayOfLong);
    PollUiOptions[] arrayOfPollUiOptions = localPoll2.getOptions();
    int i2 = arrayOfPollUiOptions.length;
    int i3 = 0;
    int i4 = 0;
    while (i3 < i2)
    {
      PollUiOptions localPollUiOptions = arrayOfPollUiOptions[i3];
      if (localPollUiOptions.getSeq() == paramMessageEntity.getMessageSeq())
      {
        localPollUiOptions.setToken(paramMessageEntity.getMessageToken());
        localPollUiOptions.setMessageId(paramMessageEntity.getMessageGlobalId());
      }
      if (localPollUiOptions.getToken() == 0L)
        i4 = 1;
      i3++;
    }
    localMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
    if (i4 == 0)
      localMessageEntity.setStatus(0);
    if (paramMessageEntity.isPublicGroupBehavior())
    {
      paramMessageEntity.removeExtraFlag(22);
      paramMessageEntity.setMimeType(1007);
    }
    this.h.b(localMessageEntity);
    this.m.a(localMessageEntity, true);
    return;
    ((bs)this.i.get()).a(null, null, paramMessageEntity, true);
  }

  private boolean m(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isActiveOneToOneBroadcast());
    MessageEntity localMessageEntity;
    do
      do
      {
        return false;
        localMessageEntity = this.h.l(paramMessageEntity.getBroadcastMessageId());
      }
      while ((localMessageEntity == null) || (localMessageEntity.isDeleted()));
    while (!localMessageEntity.hasAnyStatus(new int[] { 3, -1 }));
    c(localMessageEntity, 1);
    return true;
  }

  private boolean n(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isActiveOneToOneBroadcast());
    MessageEntity localMessageEntity;
    do
      do
      {
        return false;
        localMessageEntity = this.h.l(paramMessageEntity.getBroadcastMessageId());
      }
      while ((localMessageEntity == null) || (localMessageEntity.isDeleted()));
    while (!localMessageEntity.hasAnyStatus(new int[] { 3, -1, 1 }));
    c(localMessageEntity, 2);
    return true;
  }

  private void o(MessageEntity paramMessageEntity)
  {
    if (i(paramMessageEntity))
    {
      p(paramMessageEntity);
      return;
    }
    if ((!paramMessageEntity.isForwardedFromPG()) && (!paramMessageEntity.isActiveOneToOneBroadcast()))
    {
      paramMessageEntity.setStatus(7);
      this.h.b(paramMessageEntity);
      this.o.a(paramMessageEntity, this.s);
      return;
    }
    paramMessageEntity.setStatus(0);
    paramMessageEntity.setExtraStatus(3);
    this.h.b(paramMessageEntity);
    c();
  }

  private void p(MessageEntity paramMessageEntity)
  {
    paramMessageEntity.setStatus(0);
    paramMessageEntity.setExtraStatus(2);
    this.h.b(paramMessageEntity);
    c();
  }

  private boolean q(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isNotUploadedForwardedMediaTo1on1WithPublicAccount()) && (paramMessageEntity.getMediaUri() == null));
    do
    {
      return true;
      if ((!paramMessageEntity.isForwardedMessage()) || (paramMessageEntity.isForwardedFromPG()))
        return false;
      if (!paramMessageEntity.hasManagedMedia())
        return false;
    }
    while ((!paramMessageEntity.isForwardedFromPG()) && (paramMessageEntity.isPublicGroupBehavior()) && (paramMessageEntity.getMediaUri() == null));
    if (paramMessageEntity.getMediaUri() != null)
      return false;
    return i(paramMessageEntity);
  }

  private boolean r(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isNeedMediaUpload());
    while (((paramMessageEntity.isForwardedMessage()) && (paramMessageEntity.hasManagedMedia()) && (da.a(paramMessageEntity.getDownloadId())) && (paramMessageEntity.getObjectId().isEmpty())) || (paramMessageEntity.isNotUploadedForwardedMediaTo1on1WithPublicAccount()))
      return true;
    return false;
  }

  public void a(long paramLong)
  {
    List localList = this.h.n(paramLong);
    if (localList.size() > 0)
    {
      MessageEntity localMessageEntity = (MessageEntity)localList.get(0);
      localMessageEntity.setStatus(0);
      this.h.b(localMessageEntity);
      c();
    }
  }

  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.p.post(new aa(this, paramLong, paramString1, paramString2));
  }

  public void a(Engine paramEngine)
  {
    super.a(paramEngine);
    c();
  }

  void a(MessageEntity paramMessageEntity)
  {
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageSendDelegateImpl prepareThumbnail");
    if ((paramMessageEntity.getMediaUri() != null) && (paramMessageEntity.isMediaWithThumbnail()) && (paramMessageEntity.getThumbnailUri() == null))
      if (!paramMessageEntity.isWink())
        break label148;
    label148: for (Uri localUri = com.viber.voip.messages.extras.image.c.b(this.a, Uri.parse(paramMessageEntity.getMediaUri()), paramMessageEntity.getMimeType()); ; localUri = com.viber.voip.messages.extras.image.c.a(this.a, Uri.parse(paramMessageEntity.getMediaUri()), paramMessageEntity.getMimeType()))
    {
      if (localUri != null)
      {
        String str = localUri.toString();
        paramMessageEntity.setBody(str);
        if (paramMessageEntity.isBroadcastList())
          this.h.j(paramMessageEntity.getId(), str);
        this.h.a("messages", paramMessageEntity.getId(), "body", paramMessageEntity.getBody());
        this.m.a(paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken(), false);
      }
      com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageSendDelegateImpl prepareThumbnail");
      return;
    }
  }

  public void a(MessageEntity paramMessageEntity, Uri paramUri)
  {
    a(paramMessageEntity);
    this.o.a(paramMessageEntity, paramUri, this.b.getPhoneController().isConnected(), this.r);
    if (paramMessageEntity.isMediaWithThumbnail())
      this.t.c(paramMessageEntity.getBody());
    if (paramUri != null)
      this.x.a(paramMessageEntity.getMessageSeq(), paramUri);
  }

  void a(List<MessageEntity> paramList)
  {
    com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageSendDelegateImpl sendPendingMessages");
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      final MessageEntity localMessageEntity = (MessageEntity)localIterator.next();
      boolean bool1 = localMessageEntity.isActiveOneToOneBroadcast();
      boolean bool2 = localMessageEntity.isBroadcastList();
      this.n.a(localMessageEntity);
      boolean[] arrayOfBoolean1 = { 0, 0 };
      boolean bool4;
      if (!this.b.getPhoneController().isConnected())
      {
        com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - dissconnect");
        bool4 = false;
      }
      label119: ObjectId localObjectId;
      int i1;
      String str1;
      String str2;
      long l1;
      boolean bool3;
      while (true)
        if (!bool4)
        {
          a(localMessageEntity);
          break;
          if ((!bool2) && (localMessageEntity.isFile()))
          {
            if (!localHashMap.containsKey(localMessageEntity.getMemberId()))
            {
              arrayOfBoolean1 = com.viber.voip.messages.m.a(localMessageEntity, 1L);
              if (arrayOfBoolean1[0] != 0);
            }
            else
            {
              com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - handleUnsupportedMessages");
              a(localMessageEntity, localHashMap, arrayOfBoolean1, "sendPendingMessages file: no connection, timeout");
              bool4 = false;
            }
          }
          else if ((!bool2) && (localMessageEntity.isWink()))
          {
            boolean[] arrayOfBoolean2 = com.viber.voip.messages.m.a(localMessageEntity, 2L);
            if (arrayOfBoolean2[0] == 0)
            {
              com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - showDialogForWinkFile");
              localMessageEntity.setStatus(-1);
              this.h.b(localMessageEntity);
              this.h.b(localMessageEntity);
              a(arrayOfBoolean2[1], localMessageEntity);
              k(localMessageEntity);
              bool4 = false;
            }
          }
          else if (localMessageEntity.isNeedLoactionStatus())
          {
            com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - setLocation");
            localMessageEntity.setStatus(6);
            this.h.b(localMessageEntity);
            a(localMessageEntity.getId(), bool1, bool2);
            bool4 = false;
          }
          else if (((localMessageEntity.isForwardedMessage()) || (bool1)) && (localMessageEntity.isUploadCheckingNeeded()))
          {
            com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - handleForwardMediaUploadStatus");
            o(localMessageEntity);
            bool4 = false;
          }
          else if (localMessageEntity.isNeedVideoConvert())
          {
            com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - isNeedVideoConvert");
            localMessageEntity.setStatus(5);
            this.h.b(localMessageEntity);
            a(localMessageEntity.getId(), localMessageEntity.getMediaUri(), bool1, bool2);
            bool4 = false;
          }
          else if (q(localMessageEntity))
          {
            com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - messageRequiresDownload");
            localMessageEntity.setStatus(5);
            d(localMessageEntity, false);
            this.h.b(localMessageEntity);
            bool4 = false;
          }
          else if (r(localMessageEntity))
          {
            com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - needMediaUpload");
            localMessageEntity.setStatus(5);
            bool4 = a(localMessageEntity, false);
            if (!bool4)
            {
              this.h.b(localMessageEntity);
              this.m.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
              this.m.b(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
            }
          }
          else if (localMessageEntity.isNeedFetchUrl())
          {
            com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - needFetchUrl");
            localMessageEntity.setStatus(5);
            this.h.b(localMessageEntity);
            av.a(av.e.i).post(new Runnable()
            {
              public void run()
              {
                x.a(x.this, localMessageEntity.getId(), localMessageEntity.getBody());
              }
            });
            bool4 = false;
          }
          else if ((localMessageEntity.hasQuote()) && (com.viber.voip.messages.m.e(localMessageEntity.getConversationType())) && (TextUtils.isEmpty(localMessageEntity.getMessageInfo().getQuote().getMemberId())))
          {
            com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - handing extra");
            localMessageEntity.setStatus(5);
            this.h.b(localMessageEntity);
            QuotedMessageData localQuotedMessageData = localMessageEntity.getQuotedMessageData();
            a(localMessageEntity.getId(), localMessageEntity.getGroupId(), localQuotedMessageData.getToken(), localQuotedMessageData.getMessageId());
            bool4 = false;
          }
          else
          {
            com.viber.voip.e.a.d.a("SEND_MESSAGE", localMessageEntity, "sendPendingMessage - SENDING");
            localObjectId = localMessageEntity.getObjectId();
            i1 = com.viber.voip.messages.m.h(localMessageEntity);
            str1 = "";
            str2 = "";
            if (i1 != 0)
            {
              str1 = localMessageEntity.getDownloadId();
              str2 = localMessageEntity.getBucket();
            }
            l1 = 0L;
            if (!bool2)
              l1 = com.viber.voip.messages.m.k(localMessageEntity);
            if (!bool2)
              break label850;
            f(localMessageEntity);
            bool3 = true;
          }
        }
      while (true)
      {
        if (bool3)
          g(localMessageEntity);
        bool4 = false;
        break label119;
        break;
        label850: if (localMessageEntity.isReplyToBot())
          bool3 = b(localMessageEntity, localObjectId, l1);
        else if ((!localMessageEntity.isGroupBehavior()) && (localMessageEntity.isFormattedMessage()) && (!localMessageEntity.isShareContactMessage()) && (!localMessageEntity.isUrlMessage()))
          bool3 = c(localMessageEntity, l1);
        else if (localMessageEntity.isAudioPtt())
          bool3 = a(localMessageEntity, str1, str2, l1);
        else if (localMessageEntity.isTextMessage())
          bool3 = a(localMessageEntity, localObjectId, l1);
        else if (localMessageEntity.isUrlMessage())
          bool3 = d(localMessageEntity, l1);
        else if (localMessageEntity.isShareContactMessage())
          bool3 = e(localMessageEntity, l1);
        else
          bool3 = a(localMessageEntity, i1, str1, str2, localObjectId, l1);
      }
    }
    if (localHashMap.size() > 0)
      a(localHashMap.values());
    com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageSendDelegateImpl sendPendingMessages");
  }

  boolean a(long paramLong1, String paramString1, int paramInt1, LocationInfo paramLocationInfo, SendMessageMediaTypeFactory.SendMessageMediaTypeData paramSendMessageMediaTypeData, int paramInt2, long paramLong2, String paramString2, int paramInt3, int paramInt4, long paramLong3)
  {
    a(paramLong1, paramString1, paramInt1, paramLocationInfo, paramSendMessageMediaTypeData, paramLong2, new byte[0], paramString2, 0, 0, (byte)paramInt2, "", "", (short)paramInt3, paramInt4, paramLong3);
    return true;
  }

  boolean a(String paramString1, String paramString2, int paramInt1, LocationInfo paramLocationInfo, SendMessageMediaTypeFactory.SendMessageMediaTypeData paramSendMessageMediaTypeData, int paramInt2, long paramLong1, String paramString3, int paramInt3, int paramInt4, long paramLong2)
  {
    a(paramString1, paramString2, paramInt1, paramLocationInfo, paramSendMessageMediaTypeData, paramLong1, new byte[0], paramString3, 0, 0, (byte)paramInt2, "", "", (short)paramInt3, paramInt4, paramLong2);
    return true;
  }

  public void b(final long paramLong)
  {
    this.p.post(new Runnable()
    {
      public void run()
      {
        MessageEntity localMessageEntity = x.a(x.this).l(paramLong);
        localMessageEntity.setExtraStatus(2);
        x.a(x.this).b(localMessageEntity);
        x.a(x.this, localMessageEntity, true);
      }
    });
  }

  public void b(long paramLong, String paramString1, String paramString2)
  {
    MessageEntity localMessageEntity = this.h.l(paramLong);
    if (localMessageEntity == null);
    while (localMessageEntity.hasAnyStatus(new int[] { 1, 2, -1 }))
      return;
    if (this.f.b(Long.valueOf(localMessageEntity.getId())))
    {
      j(localMessageEntity);
      this.h.b(localMessageEntity);
    }
    do
    {
      t.a(localMessageEntity);
      this.f.a(Long.valueOf(localMessageEntity.getId()));
      this.m.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      this.m.b(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      return;
      localMessageEntity = b(localMessageEntity, true);
    }
    while (localMessageEntity != null);
  }

  protected void b(MessageEntity paramMessageEntity)
  {
    if (!paramMessageEntity.isActiveOneToOneBroadcast())
      p.b(paramMessageEntity.getMimeType()).d();
    paramMessageEntity.setStatus(-1);
    paramMessageEntity.setExtraStatus(7);
    this.h.b(paramMessageEntity);
    this.h.b(paramMessageEntity);
    this.m.a(paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken(), false);
    k(paramMessageEntity);
  }

  public void c(final long paramLong)
  {
    this.p.post(new Runnable()
    {
      private MessageEntity a(MessageEntity paramAnonymousMessageEntity, File paramAnonymousFile, boolean paramAnonymousBoolean)
      {
        long l = paramAnonymousMessageEntity.getId();
        MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.b(paramAnonymousMessageEntity).a(paramAnonymousFile, paramAnonymousMessageEntity, null, paramAnonymousMessageEntity.getTimebombInSec());
        localMessageEntity.setId(l);
        localMessageEntity.setOrderKey(paramAnonymousMessageEntity.getOrderKey());
        localMessageEntity.setMessageSeq(paramAnonymousMessageEntity.getMessageSeq());
        if (paramAnonymousMessageEntity.isActiveOneToOneBroadcast())
        {
          localMessageEntity.setBroadcastMessageId(paramAnonymousMessageEntity.getBroadcastMessageId());
          localMessageEntity.setFlag(0x20000 | localMessageEntity.getFlag());
          if (paramAnonymousBoolean)
          {
            localMessageEntity.setStatus(12);
            localMessageEntity.setExtraStatus(9);
          }
        }
        return localMessageEntity;
      }

      public void run()
      {
        MessageEntity localMessageEntity1 = x.a(x.this).l(paramLong);
        if ((localMessageEntity1 == null) || (-1 == localMessageEntity1.getStatus()));
        File localFile;
        do
        {
          return;
          Uri localUri = Uri.parse(localMessageEntity1.getMediaUri());
          localFile = at.a(x.this.a, localUri);
        }
        while (localFile == null);
        MessageEntity localMessageEntity2 = a(localMessageEntity1, localFile, false);
        com.viber.provider.b localb = ab.f();
        localb.a();
        try
        {
          if (localMessageEntity2.isBroadcastList())
          {
            List localList = x.a(x.this).m(localMessageEntity2.getId());
            if (!u.a(localList))
            {
              Iterator localIterator = localList.iterator();
              while (localIterator.hasNext())
              {
                MessageEntity localMessageEntity3 = a((MessageEntity)localIterator.next(), localFile, true);
                x.a(x.this).b(localMessageEntity3);
              }
            }
          }
        }
        finally
        {
          localb.b();
        }
        ((bs)x.g(x.this).get()).c(localMessageEntity2);
        localb.c();
        localb.b();
        x.c(x.this);
      }
    });
  }

  public boolean onMessageDelivered(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    a(paramLong1, paramLong2, paramInt1);
    return true;
  }

  public void onSendMessageReply(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    e.a("SEND_MESSAGE", "MessageSendDelegateImpl onSendMessageReply");
    if (paramInt1 == 0)
      return;
    com.viber.provider.b localb = ab.f();
    MessageEntity localMessageEntity = this.h.c(paramInt1);
    if ((localMessageEntity == null) && (paramInt2 != 2))
    {
      com.viber.voip.model.a.d locald = (com.viber.voip.model.a.d)this.z.get();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramInt1);
      locald.a("sent_members_invite_category", arrayOfString);
    }
    localb.a();
    try
    {
      int i1 = a(localMessageEntity, paramInt2);
      a(localMessageEntity, paramLong, i1, paramInt3, true);
      localb.c();
      localb.b();
      this.b.getPhoneController().handleSendMessageReplyAck(paramLong);
      if ((1 == i1) && (localMessageEntity != null) && (!localMessageEntity.isSticker()) && (!localMessageEntity.isAudioPtt()) && (!localMessageEntity.isVoiceMessage()) && (!localMessageEntity.isActiveOneToOneBroadcast()) && (!localMessageEntity.hasExtraFlag(39)))
        this.g.d();
      e.b("SEND_MESSAGE", "MessageSendDelegateImpl onSendMessageReply");
      return;
    }
    finally
    {
      localb.b();
      this.b.getPhoneController().handleSendMessageReplyAck(paramLong);
    }
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onSentMessageReceived(c.i parami)
  {
    onSendMessageReply(parami.a, parami.b, 1, parami.c, null);
  }

  public void onServiceStateChanged(int paramInt)
  {
    if (paramInt == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal())
    {
      this.h.q();
      this.h.r();
      c();
    }
  }

  private class a
    implements bk.b
  {
    private a()
    {
    }

    public void a(MessageEntity paramMessageEntity)
    {
      paramMessageEntity.setStatus(0);
      if (paramMessageEntity.getMediaUri() != null);
      for (int i = 3; ; i = 4)
      {
        paramMessageEntity.setExtraStatus(i);
        x.a(x.this).b(paramMessageEntity);
        x.c(x.this);
        return;
      }
    }

    public void b(MessageEntity paramMessageEntity)
    {
      c(paramMessageEntity);
    }

    public void c(MessageEntity paramMessageEntity)
    {
      x.b(x.this, paramMessageEntity);
    }

    public void d(MessageEntity paramMessageEntity)
    {
    }
  }

  private class b
    implements bv.m
  {
    private b()
    {
    }

    public void a(MessageEntity paramMessageEntity, int paramInt)
    {
      if (paramMessageEntity.getStatus() == 5)
      {
        if (paramInt == 0)
        {
          paramMessageEntity.setStatus(0);
          paramMessageEntity.setExtraStatus(2);
          x.a(x.this).b(paramMessageEntity);
          x.c(x.this);
        }
      }
      else
        return;
      paramMessageEntity.setStatus(-1);
      x.a(x.this).b(paramMessageEntity);
      x.a(x.this, paramMessageEntity);
    }
  }

  private class c
    implements bk.c
  {
    private c()
    {
    }

    public void a(MessageEntity paramMessageEntity)
    {
      if (paramMessageEntity == null);
      for (Object localObject = null; ; localObject = x.a(x.this).l(paramMessageEntity.getId()))
      {
        if ((localObject != null) && (!((MessageEntity)localObject).isDeleted()))
          if (!((MessageEntity)localObject).hasAnyStatus(new int[] { 2, -1 }))
          {
            ((MessageEntity)localObject).setStatus(-1);
            ((MessageEntity)localObject).setExtraStatus(2);
            x.a(x.this).b((com.viber.voip.model.entity.b)localObject);
            x.a(x.this).b((MessageEntity)localObject);
            x.e(x.this).a(((MessageEntity)localObject).getConversationId(), ((MessageEntity)localObject).getMessageToken(), false);
            x.f(x.this).remove(Long.valueOf(((MessageEntity)localObject).getId()));
            x.a(x.this, (MessageEntity)localObject);
          }
        return;
      }
    }

    public void a(MessageEntity paramMessageEntity, com.viber.voip.util.upload.r paramr)
    {
      com.viber.voip.e.a.e.b().a("SEND_MESSAGE", "MessageSendDelegateImpl UploadReplyListener onComplete");
      MessageEntity localMessageEntity1 = x.a(x.this).l(paramMessageEntity.getId());
      int j;
      List localList1;
      int i;
      if ((localMessageEntity1 != null) && (!localMessageEntity1.isDeleted()))
        if (!localMessageEntity1.hasAnyStatus(new int[] { -1, 2, 1, 3 }))
        {
          if (!localMessageEntity1.isBroadcastList())
            break label696;
          List localList2 = x.a(x.this).m(localMessageEntity1.getId());
          if (!u.a(localList2))
          {
            j = 1;
            localList1 = localList2;
            i = j;
          }
        }
      while (true)
      {
        if (localMessageEntity1.getStatus() != 4)
          localMessageEntity1.setStatus(0);
        localMessageEntity1.setExtraStatus(3);
        if (!paramr.a.isEmpty())
        {
          localMessageEntity1.setObjectId(paramr.a);
          localMessageEntity1.setDownloadId(null);
          localMessageEntity1.setBucket(null);
          if (i != 0)
          {
            Iterator localIterator6 = localList1.iterator();
            while (true)
              if (localIterator6.hasNext())
              {
                MessageEntity localMessageEntity4 = (MessageEntity)localIterator6.next();
                localMessageEntity4.setObjectId(paramr.a);
                localMessageEntity4.setDownloadId(null);
                localMessageEntity4.setBucket(null);
                continue;
                j = 0;
                break;
              }
          }
        }
        if (paramr.c != null)
        {
          localMessageEntity1.getMsgInfoFileInfo().setFileHash(paramr.c);
          if (i != 0)
          {
            Iterator localIterator5 = localList1.iterator();
            while (localIterator5.hasNext())
              ((MessageEntity)localIterator5.next()).getMsgInfoFileInfo().setFileHash(paramr.c);
          }
        }
        localMessageEntity1.getMessageInfo().setMediaMetadata(localMessageEntity1.getMessageInfo().getMediaMetadata().buildUpon().a(EncryptionParams.serializeEncryptionParams(paramr.d)).a());
        if (i != 0)
        {
          Iterator localIterator4 = localList1.iterator();
          while (localIterator4.hasNext())
            ((MessageEntity)localIterator4.next()).getMessageInfo().setMediaMetadata(localMessageEntity1.getMessageInfo().getMediaMetadata().buildUpon().a(EncryptionParams.serializeEncryptionParams(paramr.d)).a());
        }
        if (paramr.e != null)
        {
          EncryptionParams localEncryptionParams = paramr.e.d;
          ThumbnailInfo localThumbnailInfo = null;
          if (localEncryptionParams != null)
          {
            localThumbnailInfo = new ThumbnailInfo();
            localThumbnailInfo.setThumbnailEP(EncryptionParams.serializeEncryptionParams(localEncryptionParams));
          }
          localMessageEntity1.getMessageInfo().setThumbnailInfo(localThumbnailInfo);
          if (i != 0)
          {
            Iterator localIterator3 = localList1.iterator();
            while (localIterator3.hasNext())
              ((MessageEntity)localIterator3.next()).getMessageInfo().setThumbnailInfo(localThumbnailInfo);
          }
        }
        if (localMessageEntity1.getMessageInfoIfParsed() != null)
          localMessageEntity1.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMessageEntity1.getMessageInfo()));
        if (i != 0)
        {
          Iterator localIterator2 = localList1.iterator();
          while (localIterator2.hasNext())
          {
            MessageEntity localMessageEntity3 = (MessageEntity)localIterator2.next();
            if (localMessageEntity3.getMessageInfoIfParsed() != null)
              localMessageEntity3.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMessageEntity3.getMessageInfo()));
          }
        }
        com.viber.provider.b localb = ab.f();
        localb.a();
        if (i != 0)
          try
          {
            Iterator localIterator1 = localList1.iterator();
            while (localIterator1.hasNext())
            {
              MessageEntity localMessageEntity2 = (MessageEntity)localIterator1.next();
              x.a(x.this).b(localMessageEntity2);
            }
          }
          finally
          {
            localb.b();
          }
        x.a(x.this).b(localMessageEntity1);
        localb.c();
        localb.b();
        x.c(x.this);
        com.viber.voip.e.a.e.b().b("SEND_MESSAGE", "MessageSendDelegateImpl UploadReplyListener onComplete");
        return;
        label696: i = 0;
        localList1 = null;
      }
    }

    public void b(final MessageEntity paramMessageEntity)
    {
      if (paramMessageEntity == null)
        return;
      Integer localInteger1 = (Integer)x.f(x.this).get(Long.valueOf(paramMessageEntity.getId()));
      if (localInteger1 == null)
        localInteger1 = Integer.valueOf(0);
      Map localMap = x.f(x.this);
      Long localLong = Long.valueOf(paramMessageEntity.getId());
      Integer localInteger2 = Integer.valueOf(1 + localInteger1.intValue());
      localMap.put(localLong, localInteger2);
      if (localInteger2.intValue() >= 5)
      {
        a(paramMessageEntity);
        return;
      }
      x.d(x.this).postDelayed(new Runnable()
      {
        public void run()
        {
          MessageEntity localMessageEntity = x.a(x.this).l(paramMessageEntity.getId());
          if ((localMessageEntity != null) && (!localMessageEntity.isDeleted()))
            if (!localMessageEntity.hasAnyStatus(new int[] { 2, -1 }))
            {
              localMessageEntity.setStatus(0);
              x.a(x.this).b(localMessageEntity);
              x.c(x.this);
            }
        }
      }
      , 20000L);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.x
 * JD-Core Version:    0.6.2
 */