package com.viber.voip.messages;

import android.content.res.Resources;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.upload.ObjectId;
import java.io.File;

public abstract interface h
{
  public abstract MessageEntity a(int paramInt1, ObjectId paramObjectId, int paramInt2);

  public abstract MessageEntity a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3);

  public abstract MessageEntity a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2);

  public abstract MessageEntity a(Resources paramResources, int paramInt1, int paramInt2, String paramString, int paramInt3);

  public abstract MessageEntity a(File paramFile, int paramInt);

  public abstract MessageEntity a(File paramFile, MessageEntity paramMessageEntity, MediaInfo paramMediaInfo, int paramInt);

  public abstract MessageEntity a(String paramString1, String paramString2, int paramInt1, int paramInt2);

  public abstract MessageEntity a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.h
 * JD-Core Version:    0.6.2
 */