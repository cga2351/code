package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.CGroupAttributesChanged;
import com.viber.jni.EncryptionParams;
import com.viber.jni.LocationInfo;
import com.viber.jni.PublicGroupChangeEvent;
import com.viber.jni.PublicGroupMessage;
import com.viber.jni.PublicGroupUserInfo;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.controller.PausedControllerListener;
import com.viber.jni.im2.CGroupMessageReceivedMsg;
import com.viber.jni.im2.CMessageReceivedMsg;
import com.viber.jni.im2.CMessageReceivedMsg.Receiver;
import com.viber.jni.im2.CMessageReceivedReplyableAckReplyMsg;
import com.viber.jni.im2.CMessageReceivedReplyableAckReplyMsg.Receiver;
import com.viber.jni.im2.CPGMessageReceivedMsg;
import com.viber.jni.im2.Location;
import com.viber.jni.im2.interfaces.IncomingGroupMessageReceiver;
import com.viber.jni.like.GroupLikesListener;
import com.viber.jni.like.LikeControllerDelegate.GroupLikes;
import com.viber.jni.messenger.FormattedReceiverListener;
import com.viber.jni.messenger.IncomingGroupMessagesReceiverListener;
import com.viber.jni.messenger.MediaReceiverListener;
import com.viber.jni.messenger.MessengerDelegate.MessagesReceiver;
import com.viber.jni.messenger.MessengerDelegate.RecentMessagesEnded;
import com.viber.jni.messenger.PttReceiverListener;
import com.viber.jni.messenger.TextReceiverListener;
import com.viber.jni.messenger.VideoReceiverListener;
import com.viber.jni.publicgroup.PublicGroupControllerDelegate.PublicGroupGetMessages;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.block.b;
import com.viber.voip.e.a.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import com.viber.voip.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ac extends ControllerListener<a>
  implements ConnectionDelegate, CMessageReceivedMsg.Receiver, CMessageReceivedReplyableAckReplyMsg.Receiver, IncomingGroupMessageReceiver, LikeControllerDelegate.GroupLikes, MessengerDelegate.MessagesReceiver, MessengerDelegate.RecentMessagesEnded, PublicGroupControllerDelegate.PublicGroupGetMessages
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private TextReceiverListener c = new TextReceiverListener();
  private MediaReceiverListener d = new MediaReceiverListener();
  private VideoReceiverListener e = new VideoReceiverListener();
  private PttReceiverListener f = new PttReceiverListener();
  private FormattedReceiverListener g = new FormattedReceiverListener();
  private GroupLikesListener h = new GroupLikesListener();
  private IncomingGroupMessagesReceiverListener i = new IncomingGroupMessagesReceiverListener();
  private CMessageReceivedMsg.Receiver j;
  private PausedControllerListener<?>[] k;
  private Map<String, f.a> l = new HashMap();
  private Map<Long, f.a> m = new HashMap();
  private f.a n;
  private f.a o;
  private final o p;
  private boolean q;
  private boolean r;
  private Runnable s = new Runnable()
  {
    public void run()
    {
      ac.this.onGetRecentMessagesEnded(-1);
    }
  };

  public ac(Context paramContext, PausedControllerListener<?>[] paramArrayOfPausedControllerListener)
  {
    this.b = paramContext;
    this.k = paramArrayOfPausedControllerListener;
    this.p = o.a();
  }

  private int a(PublicGroupMessage[] paramArrayOfPublicGroupMessage, PublicGroupChangeEvent[] paramArrayOfPublicGroupChangeEvent)
  {
    int i1 = 0;
    int i2 = -1;
    int i6;
    int i7;
    if (!n.a(paramArrayOfPublicGroupMessage))
    {
      int i5 = paramArrayOfPublicGroupMessage.length;
      i6 = 0;
      if (i6 < i5)
      {
        i7 = paramArrayOfPublicGroupMessage[i6].getMessageID();
        if (i2 >= i7)
          break label104;
      }
    }
    while (true)
    {
      i6++;
      i2 = i7;
      break;
      int i4;
      if (!n.a(paramArrayOfPublicGroupChangeEvent))
      {
        int i3 = paramArrayOfPublicGroupChangeEvent.length;
        if (i1 < i3)
        {
          i4 = paramArrayOfPublicGroupChangeEvent[i1].getEventId();
          if (i2 >= i4)
            break label97;
        }
      }
      while (true)
      {
        i1++;
        i2 = i4;
        break;
        return i2;
        label97: i4 = i2;
      }
      label104: i7 = i2;
    }
  }

  private f.a a(long paramLong)
  {
    if ((this.o == null) || (this.o.c() != paramLong))
      this.o = ((f.a)this.m.get(Long.valueOf(paramLong)));
    return this.o;
  }

  private f.a a(long paramLong, Member paramMember, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    int i1;
    if (paramLong > 0L)
    {
      i1 = 1;
      if (i1 == 0)
        break label58;
    }
    label58: for (f.a locala = a(paramLong); ; locala = a(paramMember, paramBoolean, paramString))
    {
      if (locala == null)
      {
        if (i1 == 0)
          break label72;
        locala = a(Long.valueOf(paramLong), f.a(paramLong, paramInt2, paramString));
      }
      return locala;
      i1 = 0;
      break;
    }
    label72: return a(paramMember.getId(), f.a(paramMember, paramInt1, paramBoolean, paramString));
  }

  private f.a a(Member paramMember, boolean paramBoolean, String paramString)
  {
    if ((this.n == null) || (!paramMember.equals(this.n.d())) || (!da.a(paramString, this.n.a())) || (paramBoolean != this.n.b()))
      this.n = ((f.a)this.l.get(a(paramMember.getId(), paramBoolean, paramString)));
    return this.n;
  }

  private f.a a(Long paramLong, f.a parama)
  {
    this.m.put(paramLong, parama);
    this.o = parama;
    return parama;
  }

  private f.a a(String paramString, f.a parama)
  {
    this.l.put(a(paramString, parama.b(), parama.a()), parama);
    this.n = parama;
    return parama;
  }

  private static String a(String paramString1, boolean paramBoolean, String paramString2)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramString1;
    arrayOfString[1] = da.h(paramString2);
    StringBuilder localStringBuilder = new StringBuilder().append("secret=");
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      arrayOfString[2] = str;
      return TextUtils.join(":", arrayOfString);
    }
  }

  private void a(int paramInt1, long paramLong1, Member paramMember, boolean paramBoolean1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, boolean paramBoolean2, String paramString1, LocationInfo paramLocationInfo, byte[] paramArrayOfByte, int paramInt4, String paramString2, String paramString3, int paramInt5, int paramInt6, int paramInt7, String paramString4, int paramInt8, int paramInt9, String paramString5)
  {
    while (true)
    {
      int i1;
      MessageEntity localMessageEntity;
      try
      {
        i1 = h.a(paramLong1, paramInt1);
        if (paramBoolean1)
        {
          if ((!this.r) || (paramInt4 == 4) || (!com.viber.voip.util.upload.i.b(paramString3)))
            break label320;
          str = null;
          localMessageEntity = com.viber.voip.messages.f.a(this.b, paramLong1, paramLong2, paramMember.getId(), paramArrayOfByte, paramLong3, paramInt3, paramInt2, paramLocationInfo, paramInt4, paramString2, str, paramMember.getPhoneNumber(), paramString1, paramInt5, paramInt6, i1, paramInt7, paramString4, this.r, paramInt8, paramInt9);
          if (this.r)
          {
            if ((2 == localMessageEntity.getMimeType()) || (1009 == localMessageEntity.getMimeType()))
            {
              if (!localMessageEntity.isOutgoing())
                continue;
              localMessageEntity.setExtraStatus(7);
            }
            if (localMessageEntity.isWink())
            {
              localMessageEntity.setOpened(1);
              if (localMessageEntity.isIncoming())
                localMessageEntity.addExtraFlag(22);
            }
          }
          if (paramBoolean2)
            localMessageEntity.addExtraFlag(3);
          a(a(paramLong1, paramMember, paramInt7, i1, localMessageEntity.isSecretMessage(), paramString5), localMessageEntity, paramMember);
          return;
          localMessageEntity.setExtraStatus(4);
          continue;
        }
      }
      finally
      {
      }
      if (paramLong1 > 0L);
      for (com.viber.voip.messages.controller.c.a locala = new com.viber.voip.messages.controller.c.a(paramLong1, paramMember.getId(), paramLong2, paramLong3, paramInt3, paramInt2, paramLocationInfo, i1, paramInt7, paramInt8); ; locala = new com.viber.voip.messages.controller.c.a(paramMember.getId(), paramLong2, paramLong3, paramInt3, paramInt2, paramLocationInfo, paramInt7, paramInt8))
      {
        locala.a(this.r);
        localMessageEntity = locala.a(0, paramString1, paramInt6, paramString4, paramInt9);
        break;
      }
      label320: String str = paramString3;
    }
  }

  private void a(int paramInt1, boolean paramBoolean, long paramLong1, long paramLong2, Member paramMember, long paramLong3, int paramInt2, int paramInt3, LocationInfo paramLocationInfo, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if ((!this.r) && (com.viber.voip.publicaccount.d.a.a().e()) && (b.a(ViberApplication.getInstance().getEngine(true), paramString, paramLong2)))
      return;
    int i1;
    if (paramLong1 > 0L)
    {
      i1 = 1;
      if (i1 == 0)
        break label150;
    }
    label150: for (MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.a(paramLong1, paramMember.getId(), paramLong2, paramLong3, paramInt2, paramInt3, paramLocationInfo, h.a(paramLong1, paramInt1), paramInt5, paramInt6).a(this.r).a(7, paramString, paramInt4, null, paramInt7); ; localMessageEntity = new com.viber.voip.messages.controller.c.a(paramMember.getId(), paramLong2, paramLong3, paramInt2, paramInt3, paramLocationInfo, paramInt5, paramInt6).a(this.r).a(7, paramString, paramInt4, null, paramInt7))
    {
      if (paramBoolean)
        localMessageEntity.addExtraFlag(3);
      a(a(paramLong1, paramMember, paramInt5, h.a(paramLong1, h.a(paramLong1, paramInt1)), localMessageEntity.isSecretMessage(), null), localMessageEntity, paramMember);
      return;
      i1 = 0;
      break;
    }
  }

  private void a(f.a parama, MessageEntity paramMessageEntity, Member paramMember)
  {
    e.b().c("RECEIVE MESSAGE", "connect - first message receive");
    if ((this.r) && (!paramMessageEntity.isSyncedMessage()))
      paramMessageEntity.addExtraFlag(19);
    while (true)
    {
      parama.a(paramMessageEntity, paramMember);
      return;
      getHandler().removeCallbacks(this.s);
      getHandler().postDelayed(this.s, 5000L);
    }
  }

  private void a(h paramh, PublicGroupChangeEvent[] paramArrayOfPublicGroupChangeEvent, long paramLong, int paramInt, com.viber.voip.registration.af paramaf)
  {
    f.a locala = a(paramLong, null, 0, paramh.j(), false, null);
    int i1 = 0;
    int i2 = paramArrayOfPublicGroupChangeEvent.length;
    int i3 = 0;
    PublicGroupChangeEvent localPublicGroupChangeEvent;
    String str1;
    String str2;
    String str3;
    label59: String str4;
    int i4;
    if (i3 < i2)
    {
      localPublicGroupChangeEvent = paramArrayOfPublicGroupChangeEvent[i3];
      str1 = localPublicGroupChangeEvent.getActorPhoneNumber();
      if (paramh.g())
      {
        str2 = null;
        str3 = str1;
        str4 = localPublicGroupChangeEvent.getActor();
        if (!paramh.g())
          break label251;
        i4 = 0;
        label76: if ((paramInt >= localPublicGroupChangeEvent.getEventId()) || (paramh.f()))
          i4 |= 64;
        if (!m.a(paramaf, str1))
          break label834;
        str4 = "";
      }
    }
    label804: label834: for (int i5 = i4 | 0x20; ; i5 = i4)
    {
      Member localMember;
      MessageEntity localMessageEntity;
      switch (localPublicGroupChangeEvent.getMsgType())
      {
      default:
        localMember = new Member(str1, str1, null, str4, null, str2, str3);
        int i16 = paramh.j();
        long l7 = localPublicGroupChangeEvent.getTimeSent();
        long l8 = localPublicGroupChangeEvent.getEventToken();
        int i17 = localPublicGroupChangeEvent.getEventId();
        localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramLong, i16, str1, l7, i5, l8, i17);
      case 3:
        while (true)
        {
          if (localMessageEntity != null)
          {
            localMessageEntity.addExtraFlag(3);
            a(locala, localMessageEntity, localMember);
          }
          i3++;
          break;
          str2 = str1;
          str3 = null;
          break label59;
          label251: i4 = 8;
          break label76;
          if (da.a(str1))
          {
            String str11 = paramaf.k();
            localMember = new Member(str11, str11, null, str4, null, null, str11);
            int i15 = i5 | 0x40;
            localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramLong, paramh.j(), "", localPublicGroupChangeEvent.getTimeSent(), i15, localPublicGroupChangeEvent.getEventToken(), localPublicGroupChangeEvent.getEventId());
          }
          else
          {
            localMember = new Member(str1, str1, null, str4, null, str2, str3);
            Context localContext = this.b;
            int i13 = localPublicGroupChangeEvent.getAttributes().getFlags();
            long l5 = localPublicGroupChangeEvent.getTimeSent();
            long l6 = localPublicGroupChangeEvent.getEventToken();
            String str9 = localPublicGroupChangeEvent.getAttributes().getGroupName();
            String str10 = paramh.o();
            int i14 = localPublicGroupChangeEvent.getEventId();
            localMessageEntity = com.viber.voip.messages.controller.c.c.a(localContext, i13, paramh, str1, i5, l5, l6, str9, str10, i14);
            if ((localMessageEntity != null) && (localMessageEntity.isEmpty()) && (paramh.g()) && (paramInt < localPublicGroupChangeEvent.getEventId()))
              i1++;
          }
        }
      case 4:
      }
      int i6;
      if ((localPublicGroupChangeEvent.getMembers() == null) || (paramh.g()))
        if (localPublicGroupChangeEvent.getMembers() == null)
          i6 = i1;
      while (true)
      {
        localMember = new Member(str1, str1, null, str4, null, str2, str3);
        int i7 = paramh.j();
        long l1 = localPublicGroupChangeEvent.getTimeSent();
        long l2 = localPublicGroupChangeEvent.getEventToken();
        int i8 = localPublicGroupChangeEvent.getEventId();
        localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramLong, i7, str1, l1, i5, l2, i8);
        i1 = i6;
        break;
        if ((paramh.g()) && (paramInt < localPublicGroupChangeEvent.getEventId()))
        {
          i6 = i1 + 1;
          continue;
          int i9 = localPublicGroupChangeEvent.getMembers().length;
          String[] arrayOfString = new String[i9];
          int i10 = 0;
          if (i10 < i9)
          {
            PublicGroupUserInfo localPublicGroupUserInfo = localPublicGroupChangeEvent.getMembers()[i10];
            if (da.a(localPublicGroupUserInfo.clientName));
            for (String str8 = "Unknown"; ; str8 = localPublicGroupUserInfo.clientName)
            {
              arrayOfString[i10] = str8;
              i10++;
              break;
            }
          }
          if (i9 == 1)
            str1 = localPublicGroupChangeEvent.getMembers()[0].memberId;
          String str5;
          label706: String str6;
          if (i9 == 1)
          {
            str5 = com.viber.voip.messages.j.b(localPublicGroupChangeEvent.getMembers()[0].memberId);
            if (!paramh.g())
              break label804;
            str6 = null;
          }
          for (String str7 = str1; ; str7 = null)
          {
            localMember = new Member(str1, str1, null, null, null, str6, str7);
            int i11 = paramh.j();
            long l3 = localPublicGroupChangeEvent.getTimeSent();
            long l4 = localPublicGroupChangeEvent.getEventToken();
            int i12 = localPublicGroupChangeEvent.getEventId();
            localMessageEntity = com.viber.voip.messages.controller.c.c.a(paramLong, i11, l3, str1, i5, l4, str5, i12);
            break;
            str5 = com.viber.voip.messages.j.a(this.b, arrayOfString);
            break label706;
            str6 = str1;
          }
          if (i1 > 0)
            locala.a(i1);
        }
        else
        {
          i6 = i1;
        }
      }
    }
  }

  public ControllerListener<IncomingGroupMessageReceiver> a(IncomingGroupMessageReceiver paramIncomingGroupMessageReceiver, Handler paramHandler)
  {
    return this.i.registerDelegate(paramIncomingGroupMessageReceiver, paramHandler);
  }

  public ControllerListener<LikeControllerDelegate.GroupLikes> a(LikeControllerDelegate.GroupLikes paramGroupLikes, Handler paramHandler)
  {
    return this.h.registerDelegate(paramGroupLikes, paramHandler);
  }

  public void a()
  {
    notifyListeners(ae.a);
  }

  public void a(CMessageReceivedMsg.Receiver paramReceiver, Handler paramHandler)
  {
    this.j = new ad(paramHandler, paramReceiver);
  }

  public void a(MessengerDelegate.MessagesReceiver paramMessagesReceiver, Handler paramHandler)
  {
    this.c.registerDelegate(paramMessagesReceiver, paramHandler);
    this.e.registerDelegate(paramMessagesReceiver, paramHandler);
    this.d.registerDelegate(paramMessagesReceiver, paramHandler);
    this.f.registerDelegate(paramMessagesReceiver, paramHandler);
    this.g.registerDelegate(paramMessagesReceiver, paramHandler);
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      this.r = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i1 = 0;
    if (!paramBoolean1);
    try
    {
      if (getHandler() != null)
        getHandler().removeCallbacks(this.s);
      final ArrayList localArrayList = new ArrayList(this.l.size() + this.m.size());
      localArrayList.addAll(this.l.values());
      this.l.clear();
      localArrayList.addAll(this.m.values());
      this.m.clear();
      this.n = null;
      this.o = null;
      this.q = false;
      notifyListeners(new ControllerListener.ControllerListenerAction()
      {
        public void a(ac.a paramAnonymousa)
        {
          if ((paramAnonymousa.a(localArrayList, paramBoolean1, paramBoolean2)) && (paramBoolean1))
            ac.this.notifyListeners(new ControllerListener.ControllerListenerAction()
            {
              public void a(ac.a paramAnonymous2a)
              {
                paramAnonymous2a.b(ac.2.this.b);
              }
            });
          if (!ac.a(ac.this))
            e.b().c("RECEIVE MESSAGE", "receive bulk messages");
        }
      });
      int i2 = this.k.length;
      while (i1 < i2)
      {
        this.k[i1].resume();
        i1++;
      }
      return;
    }
    finally
    {
    }
  }

  public void b(boolean paramBoolean)
  {
    try
    {
      if (this.q)
      {
        boolean bool = this.r;
        if (!bool);
      }
      while (true)
      {
        return;
        this.q = true;
        e.b().a("RECEIVE MESSAGE", "receive bulk messages");
        int i1 = 0;
        int i2 = this.k.length;
        while (i1 < i2)
        {
          this.k[i1].pause();
          i1++;
        }
        if (!paramBoolean)
        {
          getHandler().removeCallbacks(this.s);
          getHandler().postDelayed(this.s, 10000L);
        }
      }
    }
    finally
    {
    }
  }

  public void c(boolean paramBoolean)
  {
    notifyListeners(new af(paramBoolean));
  }

  public void onCGroupMessageReceivedMsg(CGroupMessageReceivedMsg paramCGroupMessageReceivedMsg)
  {
    if (this.q)
    {
      Member localMember = new Member(paramCGroupMessageReceivedMsg.originPhoneNumber, paramCGroupMessageReceivedMsg.clientName);
      LocationInfo localLocationInfo = new LocationInfo(paramCGroupMessageReceivedMsg.location.latitude, paramCGroupMessageReceivedMsg.location.longitude);
      if (paramCGroupMessageReceivedMsg.mediaType.intValue() == 7)
      {
        a(paramCGroupMessageReceivedMsg.groupType.intValue(), false, paramCGroupMessageReceivedMsg.groupID, paramCGroupMessageReceivedMsg.messageToken, localMember, paramCGroupMessageReceivedMsg.timeSent, paramCGroupMessageReceivedMsg.flags, 0, localLocationInfo, paramCGroupMessageReceivedMsg.msgInfo, paramCGroupMessageReceivedMsg.seqInPG.intValue(), 0, 0, paramCGroupMessageReceivedMsg.timebombInSec.intValue());
        return;
      }
      int i1 = paramCGroupMessageReceivedMsg.groupType.intValue();
      long l1 = paramCGroupMessageReceivedMsg.groupID;
      if (paramCGroupMessageReceivedMsg.mediaType.intValue() != 0);
      for (boolean bool = true; ; bool = false)
      {
        a(i1, l1, localMember, bool, paramCGroupMessageReceivedMsg.messageToken, 0, paramCGroupMessageReceivedMsg.timeSent, paramCGroupMessageReceivedMsg.flags, false, paramCGroupMessageReceivedMsg.text, localLocationInfo, paramCGroupMessageReceivedMsg.thumbnail, paramCGroupMessageReceivedMsg.mediaType.intValue(), paramCGroupMessageReceivedMsg.bucketName, paramCGroupMessageReceivedMsg.downloadID, paramCGroupMessageReceivedMsg.duration.intValue(), paramCGroupMessageReceivedMsg.seqInPG.intValue(), 0, paramCGroupMessageReceivedMsg.msgInfo, 0, paramCGroupMessageReceivedMsg.timebombInSec.intValue(), null);
        return;
      }
    }
    this.i.onCGroupMessageReceivedMsg(paramCGroupMessageReceivedMsg);
  }

  public void onCMessageReceivedMsg(CMessageReceivedMsg paramCMessageReceivedMsg)
  {
    if (this.q)
    {
      int i1 = i.a(paramCMessageReceivedMsg.originPhoneNumber);
      Member localMember = new Member(paramCMessageReceivedMsg.originPhoneNumber, paramCMessageReceivedMsg.clientName, null, null, null, null, paramCMessageReceivedMsg.peerEMID);
      LocationInfo localLocationInfo = new LocationInfo(paramCMessageReceivedMsg.location.latitude, paramCMessageReceivedMsg.location.longitude);
      if (paramCMessageReceivedMsg.mediaType.intValue() == 7)
      {
        a(0, false, 0L, paramCMessageReceivedMsg.messageToken, localMember, paramCMessageReceivedMsg.timeSent, paramCMessageReceivedMsg.flags, paramCMessageReceivedMsg.messageSeq.intValue(), localLocationInfo, paramCMessageReceivedMsg.msgInfo, 0, i1, paramCMessageReceivedMsg.chatType.intValue(), paramCMessageReceivedMsg.timebombInSec.intValue());
        return;
      }
      if ((paramCMessageReceivedMsg.mediaType.intValue() == 0) && ((0x100 & paramCMessageReceivedMsg.flags) != 0))
      {
        this.j.onCMessageReceivedMsg(paramCMessageReceivedMsg);
        return;
      }
      if (paramCMessageReceivedMsg.mediaType.intValue() != 0);
      for (boolean bool = true; ; bool = false)
      {
        a(0, 0L, localMember, bool, paramCMessageReceivedMsg.messageToken, 0, paramCMessageReceivedMsg.timeSent, paramCMessageReceivedMsg.flags, false, paramCMessageReceivedMsg.text, localLocationInfo, paramCMessageReceivedMsg.thumbnail, paramCMessageReceivedMsg.mediaType.intValue(), paramCMessageReceivedMsg.bucketName, paramCMessageReceivedMsg.downloadID, paramCMessageReceivedMsg.duration.intValue(), 0, i1, paramCMessageReceivedMsg.msgInfo, paramCMessageReceivedMsg.chatType.intValue(), paramCMessageReceivedMsg.timebombInSec.intValue(), paramCMessageReceivedMsg.toVLN);
        return;
      }
    }
    this.j.onCMessageReceivedMsg(paramCMessageReceivedMsg);
  }

  public void onCMessageReceivedReplyableAckReplyMsg(CMessageReceivedReplyableAckReplyMsg paramCMessageReceivedReplyableAckReplyMsg)
  {
  }

  public void onCPGMessageReceivedMsg(CPGMessageReceivedMsg paramCPGMessageReceivedMsg)
  {
    if (this.q)
    {
      Member localMember = new Member(paramCPGMessageReceivedMsg.encryptedPhoneNumber, paramCPGMessageReceivedMsg.clientName);
      LocationInfo localLocationInfo = new LocationInfo(paramCPGMessageReceivedMsg.location.latitude, paramCPGMessageReceivedMsg.location.longitude);
      if (paramCPGMessageReceivedMsg.mediaType == 7)
      {
        a(paramCPGMessageReceivedMsg.groupType.intValue(), false, paramCPGMessageReceivedMsg.groupID, paramCPGMessageReceivedMsg.messageToken, localMember, paramCPGMessageReceivedMsg.timeSent, paramCPGMessageReceivedMsg.flags, 0, localLocationInfo, paramCPGMessageReceivedMsg.msgInfo, paramCPGMessageReceivedMsg.seqInPG, 0, 0, 0);
        return;
      }
      int i1 = paramCPGMessageReceivedMsg.groupType.intValue();
      long l1 = paramCPGMessageReceivedMsg.groupID;
      if (paramCPGMessageReceivedMsg.mediaType != 0);
      for (boolean bool = true; ; bool = false)
      {
        a(i1, l1, localMember, bool, paramCPGMessageReceivedMsg.messageToken, 0, paramCPGMessageReceivedMsg.timeSent, paramCPGMessageReceivedMsg.flags, false, paramCPGMessageReceivedMsg.text, localLocationInfo, paramCPGMessageReceivedMsg.thumbnail, paramCPGMessageReceivedMsg.mediaType, paramCPGMessageReceivedMsg.bucketName, paramCPGMessageReceivedMsg.downloadID, paramCPGMessageReceivedMsg.duration, paramCPGMessageReceivedMsg.seqInPG, 0, paramCPGMessageReceivedMsg.msgInfo, 0, 0, null);
        return;
      }
    }
    this.i.onCPGMessageReceivedMsg(paramCPGMessageReceivedMsg);
  }

  public void onConnect()
  {
    b(false);
    if (!com.viber.common.d.a.g())
      ViberApplication.getInstance().logToCrashlytics("onConnect");
  }

  public void onConnectionStateChange(int paramInt)
  {
  }

  public boolean onFormattedMessageReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString3, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.q)
      a(h.a(true, paramInt3), false, paramLong1, paramLong2, new Member(paramString2, paramString4), paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString3, paramInt3, paramInt4, paramInt5, paramInt6);
    while (true)
    {
      return false;
      this.g.onFormattedMessageReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString3, paramString4, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }

  public void onGetPublicGroupMessages(int paramInt1, long paramLong, PublicGroupMessage[] paramArrayOfPublicGroupMessage, PublicGroupChangeEvent[] paramArrayOfPublicGroupChangeEvent, int paramInt2)
  {
    if ((paramInt2 != 0) || (this.r))
    {
      this.p.e(paramInt1, paramLong, paramInt2);
      return;
    }
    com.viber.common.d.i.a();
    ab localab = ab.b();
    h localh = localab.b(paramLong);
    r localr = localab.d(paramLong);
    if ((localh == null) || (localr == null) || (localh.aq()))
    {
      this.p.e(paramInt1, paramLong, paramInt2);
      return;
    }
    HashSet localHashSet = new HashSet();
    com.viber.voip.registration.af localaf = UserManager.from(this.b).getRegistrationValues();
    long l1 = localh.getId();
    int i1 = h.o(localh.j());
    this.p.c(paramInt1, paramLong, a(paramArrayOfPublicGroupMessage, paramArrayOfPublicGroupChangeEvent));
    b(true);
    int i2 = paramArrayOfPublicGroupMessage.length;
    int i3 = 0;
    PublicGroupMessage localPublicGroupMessage;
    String str1;
    String str2;
    Uri localUri;
    int i4;
    if (i3 < i2)
    {
      localPublicGroupMessage = paramArrayOfPublicGroupMessage[i3];
      str1 = localPublicGroupMessage.getSenderName();
      str2 = localPublicGroupMessage.getSenderDownloadId();
      localUri = dx.a(str2);
      if (localh.g())
      {
        i4 = 0;
        label193: if ((localr.K() < localPublicGroupMessage.getMessageID()) && (!localh.f()))
          break label455;
        i4 |= 64;
        label221: if (!m.a(localaf, localPublicGroupMessage.getPhoneNumber()))
          break label582;
        str1 = "";
        localUri = null;
      }
    }
    label267: label582: for (int i5 = i4 | 0x20; ; i5 = i4)
    {
      String str3;
      String str4;
      Member localMember;
      if (localh.g())
      {
        str3 = null;
        str4 = localPublicGroupMessage.getPhoneNumber();
        localMember = new Member(localPublicGroupMessage.getPhoneNumber(), localPublicGroupMessage.getPhoneNumber(), localUri, str1, null, str3, str4);
        switch (localPublicGroupMessage.getMediaType())
        {
        default:
          if (localPublicGroupMessage.getMediaType() == 0)
            break;
        case 7:
        }
      }
      for (boolean bool = true; ; bool = false)
      {
        a(i1, paramLong, localMember, bool, localPublicGroupMessage.getMessageToken(), localPublicGroupMessage.getMessageSeq(), localPublicGroupMessage.getTimeSent(), i5, true, localPublicGroupMessage.getText(), localPublicGroupMessage.getLocation(), null, localPublicGroupMessage.getMediaType(), localPublicGroupMessage.getBucketName(), localPublicGroupMessage.getDownloadId(), (int)localPublicGroupMessage.getDuration(), localPublicGroupMessage.getMessageID(), 0, localPublicGroupMessage.getMsgInfo(), 0, 0, null);
        while (true)
        {
          cd.a(str2, localMember.getEncryptedMemberId(), "MessagesAggregatorDecorator [onGetPublicGroupMessages] mediaType=" + localPublicGroupMessage.getMediaType(), localUri);
          i3++;
          break;
          i4 = 8;
          break label193;
          label455: localHashSet.add(Long.valueOf(localPublicGroupMessage.getMessageToken()));
          break label221;
          str3 = localPublicGroupMessage.getPhoneNumber();
          str4 = null;
          break label267;
          a(i1, true, paramLong, localPublicGroupMessage.getMessageToken(), localMember, localPublicGroupMessage.getTimeSent(), i5, localPublicGroupMessage.getMessageSeq(), localPublicGroupMessage.getLocation(), localPublicGroupMessage.getMsgInfo(), localPublicGroupMessage.getMessageID(), 0, 0, 0);
        }
      }
      a(localh, paramArrayOfPublicGroupChangeEvent, paramLong, localr.K(), localaf);
      a(false, true);
      notifyListeners(new ag(this, paramInt1, paramLong, l1, localHashSet));
      return;
    }
  }

  public void onGetRecentMessagesEnded(int paramInt)
  {
    try
    {
      a(this.r, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean onGroupMessageLike(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt, boolean paramBoolean)
  {
    int i1;
    int i2;
    label72: int i3;
    label84: boolean bool;
    if (this.q)
    {
      f.a locala = a(paramLong1);
      if (locala == null)
        locala = a(Long.valueOf(paramLong1), f.a(paramLong1, 1, null));
      com.viber.voip.model.entity.j localj = new com.viber.voip.model.entity.j();
      localj.b(0);
      if ((paramInt & 0x40) != 0)
      {
        i1 = 1;
        if ((paramInt & 0x10) == 0)
          break label162;
        i2 = 1;
        if ((paramInt & 0x2000) == 0)
          break label168;
        i3 = 1;
        if ((i1 == 0) && (i2 == 0) && (i3 != 0))
          break label174;
        bool = true;
        label102: localj.a(bool);
        localj.a(paramLong2);
        localj.b(paramLong3);
        localj.a(paramString);
        localj.c(paramLong4);
        locala.a(new f.b(paramInt, paramBoolean, localj));
      }
    }
    while (true)
    {
      return false;
      i1 = 0;
      break;
      label162: i2 = 0;
      break label72;
      label168: i3 = 0;
      break label84;
      label174: bool = false;
      break label102;
      this.h.onGroupMessageLike(paramLong1, paramLong2, paramLong3, paramString, paramLong4, paramInt, paramBoolean);
    }
  }

  public void onLikeGroupMessageReply(long paramLong, int paramInt1, int paramInt2)
  {
    this.h.onLikeGroupMessageReply(paramLong, paramInt1, paramInt2);
  }

  public boolean onMediaReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, EncryptionParams paramEncryptionParams, int paramInt6, int paramInt7)
  {
    int i1;
    if (this.q)
    {
      Member localMember = new Member(paramString2, paramString5);
      if (paramInt4 > 0)
      {
        i1 = 1;
        a(i1, paramLong1, localMember, true, paramLong2, paramInt2, paramLong3, paramInt1, false, paramString6, paramLocationInfo, paramArrayOfByte, paramInt3, paramString3, paramString4, 0, paramInt4, 0, paramString7, paramInt6, paramInt7, null);
      }
    }
    while (true)
    {
      return false;
      i1 = 0;
      break;
      this.d.onMediaReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramInt3, paramString3, paramString4, paramString5, paramString6, paramInt4, paramInt5, paramString7, paramEncryptionParams, paramInt6, paramInt7);
    }
  }

  public boolean onPttReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString3, int paramInt3, String paramString4, int paramInt4, int paramInt5, String paramString5, int paramInt6, int paramInt7)
  {
    int i1;
    if (this.q)
    {
      Member localMember = new Member(paramString2, paramString4);
      if (paramInt4 > 0)
      {
        i1 = 1;
        a(i1, paramLong1, localMember, true, paramLong2, paramInt2, paramLong3, paramInt1, false, "", paramLocationInfo, null, 2, null, paramString3, paramInt3, paramInt4, 0, paramString5, paramInt6, paramInt7, null);
      }
    }
    while (true)
    {
      return false;
      i1 = 0;
      break;
      if (this.f != null)
        this.f.onPttReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString3, paramInt3, paramString4, paramInt4, paramInt5, paramString5, paramInt6, paramInt7);
    }
  }

  public boolean onTextReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString4, int paramInt3, int paramInt4, String paramString5, int paramInt5, int paramInt6)
  {
    int i1;
    if (this.q)
    {
      Member localMember = new Member(paramString2, paramString4);
      if (paramInt3 > 0)
      {
        i1 = 1;
        a(i1, paramLong1, localMember, false, paramLong2, paramInt2, paramLong3, paramInt1, false, paramString3, paramLocationInfo, null, 0, null, null, 0, paramInt3, 0, paramString5, paramInt5, paramInt6, null);
      }
    }
    while (true)
    {
      return false;
      i1 = 0;
      break;
      this.c.onTextReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramString3, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString4, paramInt3, paramInt4, paramString5, paramInt5, paramInt6);
    }
  }

  public boolean onVideoReceivedFromGroup(long paramLong1, String paramString1, long paramLong2, String paramString2, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4, int paramInt5, String paramString7, EncryptionParams paramEncryptionParams, int paramInt6, int paramInt7)
  {
    int i1;
    if (this.q)
    {
      Member localMember = new Member(paramString2, paramString6);
      if (paramInt4 > 0)
      {
        i1 = 1;
        a(i1, paramLong1, localMember, true, paramLong2, paramInt2, paramLong3, paramInt1, false, paramString5, paramLocationInfo, paramArrayOfByte, 3, paramString3, paramString4, paramInt3, paramInt4, 0, paramString7, paramInt6, paramInt7, null);
      }
    }
    while (true)
    {
      return false;
      i1 = 0;
      break;
      this.e.onVideoReceivedFromGroup(paramLong1, paramString1, paramLong2, paramString2, paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramInt3, paramString3, paramString4, paramString5, paramString6, paramInt4, paramInt5, paramString7, paramEncryptionParams, paramInt6, paramInt7);
    }
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);

    public abstract void a(boolean paramBoolean1, boolean paramBoolean2);

    public abstract boolean a(List<f.a> paramList, boolean paramBoolean1, boolean paramBoolean2);

    public abstract void b(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.ac
 * JD-Core Version:    0.6.2
 */