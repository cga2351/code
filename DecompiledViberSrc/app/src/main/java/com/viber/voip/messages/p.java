package com.viber.voip.messages;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.LocationInfo;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.InviteCommunityInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.LocationInfoSection;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.settings.d.af;
import com.viber.voip.stickers.i;
import com.viber.voip.util.at;
import com.viber.voip.util.av;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.n;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.util.upload.i.c;
import com.viber.voip.util.upload.i.o;
import com.viber.voip.util.upload.o;
import java.io.File;

public final class p
{
  private static final Logger a = ViberEnv.getLogger();
  private final long b;
  private final long c;
  private final String d;
  private final byte[] e;
  private final long f;
  private final int g;
  private final int h;
  private final LocationInfo i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final MsgInfo r;
  private final String s;
  private final boolean t;
  private final boolean u;
  private final int v;
  private final int w;

  public p(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4, int paramInt5, int paramInt6, MsgInfo paramMsgInfo, String paramString6, boolean paramBoolean1, boolean paramBoolean2, int paramInt7, int paramInt8)
  {
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramString1;
    this.e = paramArrayOfByte;
    this.f = paramLong3;
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramLocationInfo;
    this.j = paramString2;
    this.k = paramString3;
    this.l = paramString4;
    this.m = paramString5;
    this.n = paramInt3;
    this.o = paramInt4;
    this.p = paramInt5;
    this.q = paramInt6;
    this.r = paramMsgInfo;
    this.s = paramString6;
    this.t = paramBoolean1;
    this.u = paramBoolean2;
    this.v = paramInt8;
    this.w = paramInt7;
  }

  private EncryptionParams a(MessageEntity paramMessageEntity)
  {
    String str = paramMessageEntity.getMessageInfo().getThumbnailEP();
    if (str == null)
      return null;
    return EncryptionParams.unserializeEncryptionParams(str);
  }

  private MessageEntity a(Context paramContext, int paramInt, MsgInfo paramMsgInfo)
  {
    switch (paramInt)
    {
    default:
      return a(paramInt, paramMsgInfo);
    case 5:
      return a(paramContext.getResources(), paramInt, paramMsgInfo);
    case 0:
      return l(paramInt, paramMsgInfo);
    case 4:
      return b(paramInt, paramMsgInfo);
    case 1:
      return c(paramInt, paramMsgInfo);
    case 3:
      return f(paramInt, paramMsgInfo);
    case 2:
      return g(paramInt, paramMsgInfo);
    case 9:
      return i(paramInt, paramMsgInfo);
    case 8:
      return k(paramInt, paramMsgInfo);
    case 10:
      return j(paramInt, paramMsgInfo);
    case 13:
      return b(paramMsgInfo);
    case 14:
      return h(paramInt, paramMsgInfo);
    case 1003:
      return d(paramInt, paramMsgInfo);
    case 1004:
      return e(paramInt, paramMsgInfo);
    case 1005:
      return j(paramInt, paramMsgInfo);
    case 1006:
      return a(paramMsgInfo);
    case 1009:
      return g(paramInt, paramMsgInfo);
    case 1010:
    }
    return h(paramInt, paramMsgInfo);
  }

  private MessageEntity a(Resources paramResources, int paramInt, MsgInfo paramMsgInfo)
  {
    return c(paramMsgInfo).a(paramResources, 0, 0, null, this.v);
  }

  private void a(Context paramContext, MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isVideo()) || (paramMessageEntity.isImage()) || (paramMessageEntity.isVideoPttBehavior()))
      if ((paramMessageEntity.isPublicGroupBehavior()) && (!this.u))
        if (paramMessageEntity.isVideoPttBehavior())
        {
          localUri4 = dx.e(this.k);
          paramMessageEntity.setBody(localUri4.toString());
        }
    label353: 
    while (!paramMessageEntity.isGifFile())
    {
      while (true)
      {
        return;
        Uri localUri4 = dx.a(this.k, 400, null);
      }
      if (this.u)
      {
        paramMessageEntity.setBody(paramMessageEntity.getMessageInfo().getThumbnailUrl());
        return;
      }
      if ((this.e != null) && (this.e.length > 0))
      {
        if (paramMessageEntity.isWink());
        for (dv localdv = dv.f; ; localdv = dv.q)
        {
          File localFile1 = localdv.b(ViberApplication.getApplication(), this.k, true);
          Uri localUri2 = com.viber.voip.messages.extras.image.c.a(this.e, localFile1);
          if (localUri2 != null)
            paramMessageEntity.setBody(localUri2.toString());
          if ((this.t) || (d.af.c.d()) || (bk.a(paramMessageEntity, paramContext)) || (paramMessageEntity.isVideoPttBehavior()))
            break;
          Uri localUri3 = dx.a(this.k, paramMessageEntity.getBody(), a(paramMessageEntity), i.c.b, i.o.a, null);
          if (localUri3 == null)
            break;
          paramMessageEntity.setBody(localUri3.toString());
          return;
        }
      }
      EncryptionParams localEncryptionParams = a(paramMessageEntity);
      i.c localc;
      boolean bool1;
      if (paramMessageEntity.isVideoPttBehavior())
      {
        localc = i.c.d;
        if (!paramMessageEntity.isVideoPttBehavior())
          break label353;
        if ((!paramMessageEntity.isPublicGroupBehavior()) && (!paramMessageEntity.isForwardedFromPG()))
        {
          boolean bool2 = paramMessageEntity.isPgForwardedMessage();
          bool1 = false;
          if (!bool2);
        }
        else
        {
          bool1 = true;
        }
      }
      for (Boolean localBoolean = Boolean.valueOf(bool1); ; localBoolean = null)
      {
        Uri localUri1 = dx.a(this.k, null, localEncryptionParams, localc, i.o.a, localBoolean);
        String str1 = null;
        if (localUri1 != null)
          str1 = localUri1.toString();
        paramMessageEntity.setBody(str1);
        return;
        localc = i.c.b;
        break;
      }
    }
    if ((this.u) && (paramMessageEntity.getMessageInfo().getThumbnailUrl() != null));
    for (String str2 = paramMessageEntity.getMessageInfo().getThumbnailUrl(); ; str2 = null)
    {
      Uri localUri6;
      if (!paramMessageEntity.isPublicGroupBehavior())
      {
        File localFile2 = dv.q.a(ViberApplication.getApplication(), this.k);
        localUri6 = com.viber.voip.messages.extras.image.c.a(this.e, localFile2);
        if (localUri6 == null);
      }
      for (String str3 = localUri6.toString(); ; str3 = null)
      {
        if ((paramMessageEntity.isPublicGroupBehavior()) || (paramMessageEntity.isForwardedFromPG()) || (paramMessageEntity.isPgForwardedMessage()));
        for (boolean bool3 = true; ; bool3 = false)
        {
          Uri localUri5 = dx.a(this.t, this.k, bool3, str3, str2, paramMessageEntity.getEncryptionParams());
          if (localUri5 == null)
            break;
          paramMessageEntity.setBody(localUri5.toString());
          return;
        }
      }
    }
  }

  private void a(Context paramContext, MessageEntity paramMessageEntity, int paramInt, MsgInfo paramMsgInfo)
  {
    if ((8 != paramInt) && (9 != paramInt))
      paramMessageEntity.setRawMessageInfo(this.s);
    paramMessageEntity.setMessageGlobalId(this.o);
    if (5 != paramInt)
    {
      paramMessageEntity.setBucket(this.j);
      paramMessageEntity.setDownloadId(this.k);
    }
    if (this.u)
    {
      if (!paramMessageEntity.isSystemMessage())
        paramMessageEntity.addExtraFlag(20);
      paramMessageEntity.addExtraFlag(25);
      if (!q.b(paramMsgInfo.getPublicAccountMsgInfo().getType()))
      {
        paramMessageEntity.addExtraFlag(22);
        paramMessageEntity.setFlag(av.e(paramMessageEntity.getFlag(), 64));
        paramMessageEntity.setUnread(0);
      }
    }
    a(paramContext, paramMessageEntity);
  }

  private boolean a()
  {
    int i1 = 1;
    int i2;
    int i3;
    label21: int i4;
    if (!this.t)
    {
      i2 = i1;
      if (this.p == 2)
        break label44;
      i3 = i1;
      i4 = i2 & i3;
      if (this.p == 3)
        break label49;
    }
    while (true)
    {
      return i4 & i1;
      i2 = 0;
      break;
      label44: i3 = 0;
      break label21;
      label49: i1 = 0;
    }
  }

  private boolean a(int paramInt)
  {
    return n.a(paramInt, new int[] { 1003, 1004, 10, 1005 });
  }

  private boolean a(h paramh, boolean paramBoolean)
  {
    if ((paramBoolean) && (1 == this.p) && (paramh != null))
    {
      com.viber.voip.model.entity.m localm = com.viber.voip.messages.d.c.c().b(paramh.Z());
      return (localm != null) && (localm.i() > 0L);
    }
    return false;
  }

  private MessageEntity b(Context paramContext, int paramInt, MsgInfo paramMsgInfo)
  {
    MessageEntity localMessageEntity = a(paramContext, paramInt, paramMsgInfo);
    a(paramContext, localMessageEntity, paramInt, paramMsgInfo);
    return localMessageEntity;
  }

  private boolean b(h paramh)
  {
    return (paramh == null) || (paramh.i(11));
  }

  private com.viber.voip.messages.controller.c.a c(MsgInfo paramMsgInfo)
  {
    if (this.b > 0L);
    for (com.viber.voip.messages.controller.c.a locala = new com.viber.voip.messages.controller.c.a(this.b, this.d, this.c, this.f, this.g, this.h, this.i, this.p, this.q, this.w); ; locala = new com.viber.voip.messages.controller.c.a(this.d, this.c, this.f, this.g, this.h, this.i, this.q, this.w))
    {
      locala.a(this.t);
      if (this.u)
      {
        LocationInfoSection localLocationInfoSection = paramMsgInfo.getPublicAccountMsgInfo().getLocation();
        if (localLocationInfoSection != null)
          locala.a(new LocationInfo((int)(10000000.0D * localLocationInfoSection.getLat()), (int)(10000000.0D * localLocationInfoSection.getLon())));
      }
      return locala;
    }
  }

  public MessageEntity a(int paramInt, MsgInfo paramMsgInfo)
  {
    com.viber.voip.messages.controller.c.a locala = c(paramMsgInfo);
    String str = this.m;
    if (this.u)
      str = paramMsgInfo.getPublicAccountMsgInfo().getText();
    return locala.a(paramInt, null, str, null, this.v);
  }

  public MessageEntity a(Context paramContext, int paramInt)
  {
    MsgInfo localMsgInfo = this.r;
    if ((localMsgInfo == null) && (l.d(paramInt)))
      localMsgInfo = (MsgInfo)e.a().a().a(this.s);
    return b(paramContext, l.a(paramInt, localMsgInfo), localMsgInfo);
  }

  public MessageEntity a(MsgInfo paramMsgInfo)
  {
    com.viber.voip.messages.controller.c.a locala = c(paramMsgInfo);
    locala.b(true);
    return locala.a(1006, null, 0, this.s, 0);
  }

  public boolean a(h paramh)
  {
    if ((paramh != null) && (1 == this.p))
      return ab.b().V(paramh.getId());
    return false;
  }

  public MessageEntity b(int paramInt, MsgInfo paramMsgInfo)
  {
    com.viber.voip.messages.controller.c.a locala = c(paramMsgInfo);
    String str = this.k;
    if (this.u)
      str = Long.toHexString(paramMsgInfo.getPublicAccountMsgInfo().getStickerId());
    try
    {
      long l2 = Long.parseLong(str, 16);
      l1 = l2;
      MessageEntity localMessageEntity = locala.a(paramInt, ObjectId.fromLong(l1), this.v);
      localMessageEntity.setExtraStatus(3);
      if (a())
        i.a().t((int)l1);
      return localMessageEntity;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        long l1 = 0L;
    }
  }

  public MessageEntity b(Context paramContext, int paramInt)
  {
    MsgInfo localMsgInfo = this.r;
    if ((localMsgInfo == null) && (a(paramInt)))
      localMsgInfo = (MsgInfo)e.a().a().a(this.s);
    return b(paramContext, paramInt, localMsgInfo);
  }

  public MessageEntity b(MsgInfo paramMsgInfo)
  {
    return c(paramMsgInfo).b(this.s, this.o, this.v);
  }

  public MessageEntity c(int paramInt, MsgInfo paramMsgInfo)
  {
    MessageEntity localMessageEntity = a(paramInt, paramMsgInfo);
    localMessageEntity.setRawMessageInfo(this.s);
    m.a(this.t, localMessageEntity, this.k, paramInt);
    return localMessageEntity;
  }

  public MessageEntity d(int paramInt, MsgInfo paramMsgInfo)
  {
    MessageEntity localMessageEntity = a(paramInt, paramMsgInfo);
    localMessageEntity.setRawMessageInfo(this.s);
    return localMessageEntity;
  }

  public MessageEntity e(int paramInt, MsgInfo paramMsgInfo)
  {
    MessageEntity localMessageEntity = a(paramInt, paramMsgInfo);
    localMessageEntity.setRawMessageInfo(this.s);
    return localMessageEntity;
  }

  public MessageEntity f(int paramInt, MsgInfo paramMsgInfo)
  {
    MessageEntity localMessageEntity = a(paramInt, paramMsgInfo);
    localMessageEntity.setRawMessageInfo(this.s);
    localMessageEntity.setDuration(this.n);
    localMessageEntity.addExtraFlag(15);
    if (m.a(this.t, localMessageEntity, this.k, paramInt))
      localMessageEntity.setExtraStatus(3);
    return localMessageEntity;
  }

  public MessageEntity g(int paramInt, MsgInfo paramMsgInfo)
  {
    MessageEntity localMessageEntity = a(paramInt, paramMsgInfo);
    localMessageEntity.setRawMessageInfo(this.s);
    localMessageEntity.setDuration(this.n);
    localMessageEntity.setDownloadId(this.k);
    return localMessageEntity;
  }

  public MessageEntity h(int paramInt, MsgInfo paramMsgInfo)
  {
    MessageEntity localMessageEntity = c(paramMsgInfo).a(14, null, 0, null, this.v);
    localMessageEntity.setDownloadId(this.k);
    localMessageEntity.setExtraStatus(4);
    return localMessageEntity;
  }

  public MessageEntity i(int paramInt, MsgInfo paramMsgInfo)
  {
    return c(paramMsgInfo).a(this.s, this.o, this.v);
  }

  public MessageEntity j(int paramInt, MsgInfo paramMsgInfo)
  {
    com.viber.voip.messages.controller.c.a locala = c(paramMsgInfo);
    FileInfo localFileInfo = paramMsgInfo.getFileInfo();
    String str;
    MessageEntity localMessageEntity;
    if (localFileInfo.isGifImage())
    {
      str = "";
      localMessageEntity = locala.a(paramInt, this.k, this.m, this.s, str, this.v);
      if (this.t)
      {
        if (!localMessageEntity.isOutgoing())
          break label84;
        localMessageEntity.setExtraStatus(2);
      }
    }
    label84: File localFile;
    do
    {
      do
      {
        return localMessageEntity;
        str = localFileInfo.getFileName();
        break;
      }
      while ((!localFileInfo.isGifImage()) || (!localMessageEntity.isIncoming()));
      localFile = dv.u.b(ViberApplication.getApplication(), this.k, false);
      if ((localFile == null) || (!localFile.exists()) || (localFile.length() <= 0L))
        localFile = o.a(this.k, 1005, ViberApplication.getApplication());
    }
    while ((!at.a(localFile)) || (localFile.length() <= 0L));
    localMessageEntity.setMediaUri(Uri.fromFile(localFile).toString());
    return localMessageEntity;
  }

  public MessageEntity k(int paramInt, MsgInfo paramMsgInfo)
  {
    int i1 = 1;
    com.viber.voip.messages.controller.c.a locala = c(paramMsgInfo);
    if (((0x10 & this.g) != 0) || ((0x20 & this.g) != 0) || (m.e(this.p)) || (this.t))
      return locala.a(this.s, paramMsgInfo, this.o, this.u, this.v);
    h localh = ab.b().b(this.b);
    boolean bool1 = b(localh);
    boolean bool2 = a(localh, bool1);
    if ((this.u) || (!bool1) || (bool2) || ((0x1 & this.g) != 0) || (ViberApplication.getInstance().getContactManager().c().b(this.l) != null) || (a(localh)))
      return locala.a(this.s, paramMsgInfo, this.o, this.u, this.v);
    if (paramMsgInfo != null);
    for (MsgInfo localMsgInfo1 = paramMsgInfo; (localMsgInfo1.getInviteCommunityInfo() != null) && (localMsgInfo1.getInviteCommunityInfo().hasPersonalLink()); localMsgInfo1 = (MsgInfo)e.a().a().a(this.s))
      return locala.a(this.s, localMsgInfo1, this.o, false, this.v);
    String str1 = localMsgInfo1.getText();
    MsgInfo localMsgInfo2 = new MsgInfo();
    if (localMsgInfo1.getTextMetaInfo() != null)
      localMsgInfo2.setTextMetaInfo(localMsgInfo1.getTextMetaInfo());
    for (int i2 = i1; ; i2 = 0)
    {
      if (localMsgInfo1.getEdit() != null)
      {
        localMsgInfo2.setEdit(localMsgInfo1.getEdit());
        i2 = i1;
      }
      if (localMsgInfo1.getGroupReferralInfo() != null)
        localMsgInfo2.setGroupReferralInfo(localMsgInfo1.getGroupReferralInfo());
      while (true)
      {
        if (i1 != 0);
        for (String str2 = e.a().b().a(localMsgInfo2); ; str2 = null)
        {
          if (str1 == null)
            str1 = "";
          return locala.a(0, str1, this.o, str2, this.v);
        }
        i1 = i2;
      }
    }
  }

  public MessageEntity l(int paramInt, MsgInfo paramMsgInfo)
  {
    com.viber.voip.messages.controller.c.a locala = c(paramMsgInfo);
    String str = paramMsgInfo.getPublicAccountMsgInfo().getText();
    if (str == null)
      str = "";
    return locala.a(0, str, this.o, this.s, this.v);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.p
 * JD-Core Version:    0.6.2
 */