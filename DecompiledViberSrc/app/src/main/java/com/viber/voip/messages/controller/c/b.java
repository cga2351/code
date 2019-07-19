package com.viber.voip.messages.controller.c;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.net.Uri;
import com.viber.liblinkparser.LinkParser.Preview;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.orm.entity.json.FormattedUrlMessage;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.at;
import com.viber.voip.util.upload.ObjectId;
import java.io.File;

public class b
  implements com.viber.voip.messages.h
{
  protected long a;
  protected String b;
  protected int c;
  private long d;
  private int e;

  public b(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramLong2;
    if (this.a > 0L)
      paramString = null;
    this.b = paramString;
    this.c = paramInt1;
    this.d = paramLong1;
    this.e = paramInt2;
  }

  public b(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    this(paramLong, 0L, paramString, paramInt1, paramInt2);
  }

  public b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this(paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getGroupId(), paramConversationItemLoaderEntity.getParticipantMemberId(), paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.getNativeChatType());
  }

  public b(MessageEntity paramMessageEntity)
  {
    this(paramMessageEntity.getConversationId(), paramMessageEntity.getGroupId(), paramMessageEntity.getMemberId(), paramMessageEntity.getConversationType(), paramMessageEntity.getNativeChatType());
  }

  public b(com.viber.voip.model.entity.h paramh, com.viber.voip.model.entity.m paramm)
  {
  }

  private MessageEntity a(MessageEntity paramMessageEntity, int paramInt1, int paramInt2)
  {
    MessageEntity localMessageEntity = new MessageEntity();
    if (paramMessageEntity != null)
      a(paramMessageEntity, localMessageEntity);
    while (true)
    {
      localMessageEntity.setCount(1);
      if (paramInt1 != -1)
        localMessageEntity.setMimeType(paramInt1);
      localMessageEntity.setId(-1L);
      localMessageEntity.setGroupId(this.a);
      localMessageEntity.setMemberId(this.b);
      localMessageEntity.setConversationType(this.c);
      localMessageEntity.setConversationId(this.d);
      localMessageEntity.setTimebombInSec(paramInt2);
      localMessageEntity.setType(1);
      localMessageEntity.setUnread(0);
      localMessageEntity.setDate(System.currentTimeMillis());
      localMessageEntity.setStatus(0);
      if (this.e == 1)
        localMessageEntity.addExtraFlag(27);
      return localMessageEntity;
      localMessageEntity.setExtraStatus(3);
    }
  }

  private void a(MessageEntity paramMessageEntity1, MessageEntity paramMessageEntity2)
  {
    paramMessageEntity2.setBody(paramMessageEntity1.getBody());
    paramMessageEntity2.setBucket(paramMessageEntity1.getBucket());
    paramMessageEntity2.setConversationId(paramMessageEntity1.getConversationId());
    paramMessageEntity2.setConversationType(paramMessageEntity1.getConversationType());
    paramMessageEntity2.setCount(paramMessageEntity1.getCount());
    paramMessageEntity2.setDescription(paramMessageEntity1.getDescription());
    paramMessageEntity2.setDuration(paramMessageEntity1.getDuration());
    paramMessageEntity2.setGroupId(paramMessageEntity1.getGroupId());
    paramMessageEntity2.setMediaUri(paramMessageEntity1.getMediaUri());
    paramMessageEntity2.setMimeType(paramMessageEntity1.getMimeType());
    paramMessageEntity2.setParticipantId(paramMessageEntity1.getParticipantId());
    paramMessageEntity2.setMemberId(paramMessageEntity1.getMemberId());
    paramMessageEntity2.setLat(paramMessageEntity1.getLat());
    paramMessageEntity2.setLng(paramMessageEntity1.getLng());
    paramMessageEntity2.setDownloadId(paramMessageEntity1.getDownloadId());
    paramMessageEntity2.setObjectId(paramMessageEntity1.getObjectId());
    if (paramMessageEntity1.hasExtraFlag(1))
      paramMessageEntity2.addExtraFlag(1);
    while (true)
    {
      paramMessageEntity2.setRawMessageInfo(paramMessageEntity1.getRawMessageInfo());
      paramMessageEntity2.setSpans(paramMessageEntity1.getSpans());
      paramMessageEntity2.setExtraStatus(paramMessageEntity1.getExtraStatus());
      return;
      if (paramMessageEntity1.hasExtraFlag(2))
        paramMessageEntity2.addExtraFlag(2);
    }
  }

  public MessageEntity a(int paramInt1, ObjectId paramObjectId, int paramInt2)
  {
    MessageEntity localMessageEntity = a(paramInt1, null, null, null, paramInt2);
    localMessageEntity.setObjectId(paramObjectId);
    localMessageEntity.setExtraStatus(3);
    localMessageEntity.setStatus(0);
    localMessageEntity.addExtraFlag(28);
    return localMessageEntity;
  }

  public MessageEntity a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    MessageEntity localMessageEntity = a(null, paramInt1, paramInt3);
    localMessageEntity.setRawMessageInfo(paramString2);
    localMessageEntity.setBody(paramString1);
    localMessageEntity.setMessageGlobalId(paramInt2);
    if ((paramString1 != null) && (paramString1.startsWith("##")))
      localMessageEntity.setFlag(1);
    com.viber.voip.messages.m.a(10, new MessageEntity[] { localMessageEntity });
    return localMessageEntity;
  }

  public MessageEntity a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    MessageEntity localMessageEntity = a(null, paramInt1, paramInt2);
    localMessageEntity.setMimeType(paramInt1);
    localMessageEntity.setMediaUri(paramString1);
    localMessageEntity.setDescription(paramString2);
    localMessageEntity.setBody("");
    localMessageEntity.setStatus(4);
    localMessageEntity.setRawMessageInfo(paramString3);
    return localMessageEntity;
  }

  public MessageEntity a(Resources paramResources, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    MessageEntity localMessageEntity = a(5, "", 0, null, paramInt3);
    localMessageEntity.setLat(paramInt1);
    localMessageEntity.setLng(paramInt2);
    localMessageEntity.setBucket(paramString);
    localMessageEntity.setBody(com.viber.voip.messages.extras.map.b.a(paramResources, localMessageEntity));
    return localMessageEntity;
  }

  public MessageEntity a(Pin paramPin)
  {
    String str = "(paperclip) " + paramPin.getText();
    MsgInfo localMsgInfo = new MsgInfo();
    localMsgInfo.setPin(paramPin);
    MessageEntity localMessageEntity = a(0, str, 0, e.a().b().a(localMsgInfo), 0);
    localMessageEntity.addExtraFlag(32);
    localMessageEntity.setBucket(paramPin.getAction().getTypeName());
    return localMessageEntity;
  }

  @SuppressLint({"WrongConstant"})
  public MessageEntity a(MessageEntity paramMessageEntity)
  {
    MessageEntity localMessageEntity = a(paramMessageEntity, -1, paramMessageEntity.getTimebombInSec());
    localMessageEntity.addExtraFlag(28);
    return localMessageEntity;
  }

  public MessageEntity a(File paramFile, int paramInt)
  {
    return a(paramFile, null, null, paramInt);
  }

  public MessageEntity a(File paramFile, MessageEntity paramMessageEntity, MediaInfo paramMediaInfo, int paramInt)
  {
    String str1 = paramFile.getName();
    String str2 = at.j(paramFile);
    MessageEntity localMessageEntity;
    if (paramMessageEntity != null)
    {
      localMessageEntity = a(paramMessageEntity, 10, paramInt);
      localMessageEntity.setBody(str1);
    }
    while (true)
    {
      localMessageEntity.setStatus(4);
      localMessageEntity.setExtraStatus(2);
      localMessageEntity.setMediaUri(Uri.fromFile(paramFile).toString());
      MsgInfo localMsgInfo = new MsgInfo();
      FileInfo localFileInfo = new FileInfo();
      localMsgInfo.setFileInfo(localFileInfo);
      localFileInfo.setFileName(str1);
      localFileInfo.setFileExt(str2);
      localFileInfo.setContentType(FileInfo.a.FILE);
      long l = paramFile.length();
      localFileInfo.setFileSize(l);
      localFileInfo.setOriginalSize(l);
      if (paramMediaInfo != null)
        localFileInfo.setMediaInfo(paramMediaInfo);
      localMessageEntity.setRawMessageInfo(e.a().b().a(localMsgInfo));
      return localMessageEntity;
      if (paramMediaInfo != null)
        localMessageEntity = a(1005, "", 0, null, paramInt);
      else
        localMessageEntity = a(10, str1, 0, null, paramInt);
    }
  }

  public MessageEntity a(String paramString, MsgInfo paramMsgInfo, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    MessageEntity localMessageEntity = a(8, "", paramInt1, paramString, paramInt2);
    if (paramMsgInfo != null)
    {
      localMessageEntity.setBody(FormattedUrlMessage.createUrlMessage(paramMsgInfo, true));
      return localMessageEntity;
    }
    localMessageEntity.setBody(FormattedUrlMessage.createUrlMessage(paramString, true));
    return localMessageEntity;
  }

  public MessageEntity a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return a(9, paramString1, paramInt1, paramString2, paramInt2);
  }

  public MessageEntity a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    LinkParser.Preview localPreview = new LinkParser.Preview("", MsgInfo.a.IMAGE.getTypeName(), paramString1, paramString1, "image/gif", (int)FormattedUrlMessage.THUMB_SIZE_FORCE_PUT_TO_JSON, "", "", "", "image/gif");
    MessageEntity localMessageEntity = a(8, "", 0, null, paramInt3);
    MsgInfo localMsgInfo = localMessageEntity.getMessageInfo();
    localMsgInfo.setThumbnailWidth(paramInt1);
    localMsgInfo.setThumbnailHeight(paramInt2);
    com.viber.voip.util.links.b.a(localMsgInfo, paramString2, paramString1, localPreview);
    com.viber.voip.messages.m.a(localMessageEntity, localMsgInfo);
    return localMessageEntity;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.c.b
 * JD-Core Version:    0.6.2
 */