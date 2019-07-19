package com.viber.voip.backup.e;

import com.viber.jni.backup.BackupHeader;
import com.viber.jni.backup.MessageBackupEntity;
import com.viber.jni.im2.CMessageReceivedMsg;
import com.viber.jni.im2.Location;
import com.viber.voip.backup.o;
import com.viber.voip.messages.controller.b.ac;
import com.viber.voip.messages.m;

class d extends e<MessageBackupEntity>
{
  public d(o paramo)
  {
    super(paramo);
  }

  protected Iterable<MessageBackupEntity> a(b paramb)
  {
    return paramb.c();
  }

  protected void a(BackupHeader paramBackupHeader, MessageBackupEntity paramMessageBackupEntity, ac paramac)
  {
    m.d(paramMessageBackupEntity.getMemberId());
    if (paramBackupHeader.getVersion() >= 2);
    for (String str = paramMessageBackupEntity.getPhoneNumber(); ; str = paramMessageBackupEntity.getMemberId())
    {
      paramac.onCMessageReceivedMsg(new CMessageReceivedMsg(paramMessageBackupEntity.getMemberId(), paramMessageBackupEntity.getMessageToken(), paramMessageBackupEntity.getBody(), paramMessageBackupEntity.getDate(), paramMessageBackupEntity.getFlags(), paramMessageBackupEntity.getMessageSeq(), Location.fromLegacyLocation(paramMessageBackupEntity.getLocation()), paramMessageBackupEntity.getMediaType(), paramMessageBackupEntity.getBucket(), paramMessageBackupEntity.getDownloadId(), paramMessageBackupEntity.getThumbnailByteArray(), str, paramMessageBackupEntity.getDate(), (int)paramMessageBackupEntity.getDuration(), 0, paramMessageBackupEntity.getMsgInfo(), 0, 0, "", ""));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.e.d
 * JD-Core Version:    0.6.2
 */