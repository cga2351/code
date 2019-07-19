package com.viber.voip.messages.controller.c;

import android.content.res.Resources;
import com.viber.jni.LocationInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.extras.map.b;
import com.viber.voip.messages.h;
import com.viber.voip.messages.orm.entity.json.FormattedUrlMessage;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.upload.ObjectId;
import java.io.File;

public class a
  implements h
{
  private long a;
  private int b;
  private String c;
  private long d;
  private long e;
  private int f;
  private int g;
  private int h;
  private LocationInfo i;
  private boolean j;
  private int k;
  private boolean l;

  public a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramString, paramLong2, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramInt3, paramInt4, paramInt5);
    this.a = paramLong1;
  }

  public a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, int paramInt4)
  {
    this(paramString, paramLong1, paramLong2, paramInt1, paramInt2, paramLocationInfo, 0, paramInt3, paramInt4);
  }

  private a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, int paramInt4, int paramInt5)
  {
    this.c = paramString;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.i = paramLocationInfo;
    this.b = paramInt3;
    this.h = paramInt4;
    this.k = paramInt5;
  }

  private MessageEntity a(int paramInt1, int paramInt2)
  {
    MessageEntity localMessageEntity = new MessageEntity();
    localMessageEntity.setCount(1);
    if (((0x10 & this.f) != 0) || ((0x20 & this.f) != 0))
    {
      localMessageEntity.setType(1);
      if ((0x10 & this.f) != 0)
      {
        localMessageEntity.setStatus(1);
        localMessageEntity.setUnread(0);
      }
    }
    while (true)
    {
      if (this.h == 2)
        localMessageEntity.addExtraFlag(8);
      if (this.k == 1)
        localMessageEntity.addExtraFlag(27);
      if ((0x40 & this.f) != 0)
        localMessageEntity.setUnread(0);
      if ((0x20 & this.f) != 0)
        localMessageEntity.setStatus(2);
      localMessageEntity.setMimeType(paramInt1);
      localMessageEntity.setGroupId(this.a);
      localMessageEntity.setConversationType(this.b);
      localMessageEntity.setMessageToken(this.d);
      localMessageEntity.setMemberId(this.c);
      localMessageEntity.setDate(this.e);
      localMessageEntity.setFlag(this.f);
      localMessageEntity.setMessageSeq(this.g);
      localMessageEntity.setLocation(this.i);
      localMessageEntity.setExtraStatus(3);
      localMessageEntity.setTimebombInSec(paramInt2);
      return localMessageEntity;
      localMessageEntity.setStatus(2);
      break;
      localMessageEntity.setType(0);
      localMessageEntity.setStatus(2);
    }
  }

  public a a(LocationInfo paramLocationInfo)
  {
    this.i = paramLocationInfo;
    return this;
  }

  public a a(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }

  public MessageEntity a(int paramInt1, ObjectId paramObjectId, int paramInt2)
  {
    MessageEntity localMessageEntity = a(paramInt1, paramInt2);
    localMessageEntity.setExtraStatus(4);
    localMessageEntity.addExtraFlag(28);
    localMessageEntity.setObjectId(paramObjectId);
    return localMessageEntity;
  }

  public MessageEntity a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    MessageEntity localMessageEntity = a(paramInt1, paramInt3);
    localMessageEntity.setRawMessageInfo(paramString2);
    localMessageEntity.setBody(paramString1);
    localMessageEntity.setTimebombInSec(paramInt3);
    localMessageEntity.setExtraStatus(3);
    localMessageEntity.setMessageGlobalId(paramInt2);
    if (this.l)
      localMessageEntity.setSpans("no_sp");
    return localMessageEntity;
  }

  public MessageEntity a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    MessageEntity localMessageEntity = a(paramInt1, paramInt2);
    localMessageEntity.setExtraStatus(4);
    localMessageEntity.setDescription(paramString2);
    localMessageEntity.setBody("");
    localMessageEntity.setMediaUri(paramString1);
    localMessageEntity.setRawMessageInfo(paramString3);
    return localMessageEntity;
  }

  public MessageEntity a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    MessageEntity localMessageEntity = a(paramInt1, paramInt2);
    localMessageEntity.setRawMessageInfo(paramString3);
    localMessageEntity.setDownloadId(paramString1);
    localMessageEntity.setDescription(paramString2);
    localMessageEntity.setBody(paramString4);
    localMessageEntity.setExtraStatus(4);
    return localMessageEntity;
  }

  public MessageEntity a(Resources paramResources, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    MessageEntity localMessageEntity = a(5, null, null, null, paramInt3);
    localMessageEntity.setBody(b.a(paramResources, localMessageEntity));
    return localMessageEntity;
  }

  public MessageEntity a(File paramFile, int paramInt)
  {
    throw new RuntimeException("Not implemented!");
  }

  public MessageEntity a(File paramFile, MessageEntity paramMessageEntity, MediaInfo paramMediaInfo, int paramInt)
  {
    throw new RuntimeException("Not Implemeted!");
  }

  public MessageEntity a(String paramString, int paramInt1, int paramInt2)
  {
    MessageEntity localMessageEntity = a(9, "", paramInt1, paramString, paramInt2);
    boolean bool1 = localMessageEntity.isOutgoing();
    if ((localMessageEntity.isGroupBehavior()) && (!localMessageEntity.isBroadcastList()));
    for (boolean bool2 = true; ; bool2 = false)
    {
      localMessageEntity.setBody(com.viber.voip.messages.conversation.ui.bu.a(paramString, bool1, bool2)[0]);
      return localMessageEntity;
    }
  }

  public MessageEntity a(String paramString, MsgInfo paramMsgInfo, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    MessageEntity localMessageEntity;
    if (paramBoolean)
    {
      localMessageEntity = a(0, paramMsgInfo.getText(), paramInt1, paramString, paramInt2);
      localMessageEntity.addExtraFlag(18);
      return localMessageEntity;
    }
    String str = "";
    if (!this.j)
      if (paramMsgInfo == null)
        break label90;
    label90: for (str = FormattedUrlMessage.createUrlMessage(paramMsgInfo, true); ; str = FormattedUrlMessage.createUrlMessage(paramString, true))
    {
      localMessageEntity = a(8, str, paramInt1, paramString, paramInt2);
      if ((this.j) || (!localMessageEntity.isGifUrlMessage()))
        break;
      localMessageEntity.setExtraStatus(4);
      return localMessageEntity;
    }
  }

  public MessageEntity a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return a(9, paramString1, paramInt1, paramString2, paramInt2);
  }

  public MessageEntity a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    throw new RuntimeException("Not implemented!");
  }

  public MessageEntity b(String paramString, int paramInt1, int paramInt2)
  {
    MessageEntity localMessageEntity = a(7, "", paramInt1, paramString, paramInt2);
    String[] arrayOfString = com.viber.voip.wallet.a.a(localMessageEntity, paramString);
    if (arrayOfString != null)
      localMessageEntity.setBody(arrayOfString[0]);
    return localMessageEntity;
  }

  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.c.a
 * JD-Core Version:    0.6.2
 */