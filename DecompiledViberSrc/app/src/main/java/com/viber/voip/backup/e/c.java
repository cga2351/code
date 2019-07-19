package com.viber.voip.backup.e;

import com.viber.jni.EncryptionParams;
import com.viber.jni.LocationInfo;
import com.viber.jni.backup.BackupHeader;
import com.viber.jni.backup.GroupMessageBackupEntity;
import com.viber.voip.backup.l;
import com.viber.voip.backup.o;
import com.viber.voip.messages.controller.b.ac;

class c extends e<GroupMessageBackupEntity>
{
  public c(o paramo)
  {
    super(paramo);
  }

  protected Iterable<GroupMessageBackupEntity> a(b paramb)
  {
    return paramb.d();
  }

  protected void a(BackupHeader paramBackupHeader, GroupMessageBackupEntity paramGroupMessageBackupEntity, ac paramac)
  {
    if (paramBackupHeader.getVersion() >= 2);
    for (String str1 = paramGroupMessageBackupEntity.getPhoneNumber(); ; str1 = paramGroupMessageBackupEntity.getMemberId())
      switch (paramGroupMessageBackupEntity.getMediaType())
      {
      case 1:
      case 4:
      case 5:
      case 6:
      default:
        long l7 = paramGroupMessageBackupEntity.getGroupId();
        String str12 = paramGroupMessageBackupEntity.getGroupName();
        long l8 = paramGroupMessageBackupEntity.getMessageToken();
        String str13 = paramGroupMessageBackupEntity.getMemberId();
        byte[] arrayOfByte2 = paramGroupMessageBackupEntity.getThumbnailByteArray();
        long l9 = paramGroupMessageBackupEntity.getDate();
        int i2 = paramGroupMessageBackupEntity.getFlags();
        int i3 = paramGroupMessageBackupEntity.getMessageSeq();
        LocationInfo localLocationInfo3 = paramGroupMessageBackupEntity.getLocation();
        int i4 = paramGroupMessageBackupEntity.getMediaType();
        String str14 = paramGroupMessageBackupEntity.getBucket();
        String str15 = paramGroupMessageBackupEntity.getDownloadId();
        String str16 = paramGroupMessageBackupEntity.getBody();
        String str17 = paramGroupMessageBackupEntity.getMsgInfo();
        EncryptionParams localEncryptionParams2 = paramGroupMessageBackupEntity.getEncryptionParams();
        paramac.onMediaReceivedFromGroup(l7, str12, l8, str13, arrayOfByte2, l9, i2, i3, localLocationInfo3, i4, str14, str15, str1, str16, 0, 0, str17, localEncryptionParams2, 0, 0);
        return;
      case 0:
      case 2:
      case 7:
      case 3:
      }
    paramac.onTextReceivedFromGroup(paramGroupMessageBackupEntity.getGroupId(), paramGroupMessageBackupEntity.getGroupName(), paramGroupMessageBackupEntity.getMessageToken(), paramGroupMessageBackupEntity.getMemberId(), paramGroupMessageBackupEntity.getBody(), paramGroupMessageBackupEntity.getDate(), paramGroupMessageBackupEntity.getFlags(), paramGroupMessageBackupEntity.getMessageSeq(), paramGroupMessageBackupEntity.getLocation(), str1, 0, 0, paramGroupMessageBackupEntity.getMsgInfo(), 0, 0);
    return;
    long l4 = paramGroupMessageBackupEntity.getGroupId();
    String str8 = paramGroupMessageBackupEntity.getGroupName();
    long l5 = paramGroupMessageBackupEntity.getMessageToken();
    String str9 = paramGroupMessageBackupEntity.getMemberId();
    long l6 = paramGroupMessageBackupEntity.getDate();
    int m = paramGroupMessageBackupEntity.getFlags();
    int n = paramGroupMessageBackupEntity.getMessageSeq();
    LocationInfo localLocationInfo2 = paramGroupMessageBackupEntity.getLocation();
    String str10 = paramGroupMessageBackupEntity.getDownloadId();
    int i1 = (int)paramGroupMessageBackupEntity.getDuration();
    String str11 = paramGroupMessageBackupEntity.getMsgInfo();
    paramac.onPttReceivedFromGroup(l4, str8, l5, str9, l6, m, n, localLocationInfo2, str10, i1, str1, 0, 0, str11, 0, 0);
    return;
    paramac.onFormattedMessageReceivedFromGroup(paramGroupMessageBackupEntity.getGroupId(), paramGroupMessageBackupEntity.getGroupName(), paramGroupMessageBackupEntity.getMessageToken(), paramGroupMessageBackupEntity.getMemberId(), paramGroupMessageBackupEntity.getDate(), paramGroupMessageBackupEntity.getFlags(), paramGroupMessageBackupEntity.getMessageSeq(), paramGroupMessageBackupEntity.getLocation(), l.a(paramGroupMessageBackupEntity), str1, 0, 0, 0, 0);
    return;
    long l1 = paramGroupMessageBackupEntity.getGroupId();
    String str2 = paramGroupMessageBackupEntity.getGroupName();
    long l2 = paramGroupMessageBackupEntity.getMessageToken();
    String str3 = paramGroupMessageBackupEntity.getMemberId();
    byte[] arrayOfByte1 = paramGroupMessageBackupEntity.getThumbnailByteArray();
    long l3 = paramGroupMessageBackupEntity.getDate();
    int i = paramGroupMessageBackupEntity.getFlags();
    int j = paramGroupMessageBackupEntity.getMessageSeq();
    LocationInfo localLocationInfo1 = paramGroupMessageBackupEntity.getLocation();
    int k = (int)paramGroupMessageBackupEntity.getDuration();
    String str4 = paramGroupMessageBackupEntity.getBucket();
    String str5 = paramGroupMessageBackupEntity.getDownloadId();
    String str6 = paramGroupMessageBackupEntity.getBody();
    String str7 = paramGroupMessageBackupEntity.getMsgInfo();
    EncryptionParams localEncryptionParams1 = paramGroupMessageBackupEntity.getEncryptionParams();
    paramac.onVideoReceivedFromGroup(l1, str2, l2, str3, arrayOfByte1, l3, i, j, localLocationInfo1, k, str4, str5, str6, str1, 0, 0, str7, localEncryptionParams1, 0, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.e.c
 * JD-Core Version:    0.6.2
 */