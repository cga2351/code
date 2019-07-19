package com.viber.voip.backup.d;

import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.backup.MessageBackupEntity;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.o;
import com.viber.voip.flatbuffers.model.msginfo.MediaMetadata;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.model.entity.u;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import com.viber.voip.util.upload.ObjectId;

abstract class h<T extends MessageBackupEntity> extends a<T>
{
  private static final Logger f = ViberEnv.getLogger();
  private static final int[] g = { -1, 0, 3 };
  protected int c;
  protected d<u> d;
  protected final u e = new u();

  public h(Class<T> paramClass, o paramo)
  {
    super(paramClass, paramo);
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(d paramd)
  {
    this.d = paramd;
  }

  protected void a(u paramu, T paramT)
  {
    paramT.setMemberId(paramu.c);
    paramT.setDate(paramu.b);
    int i = paramu.d;
    int j;
    if ((i == 1005) || (i == 1009))
      j = 10;
    while (true)
    {
      switch (i)
      {
      default:
        label108: if ((i == 1003) || (i == 1004))
          j = 11;
        paramT.setMediaType(j);
        String str = paramu.i;
        if (!TextUtils.isEmpty(str))
          paramT.setBody(str);
        paramT.setMessageSeq(paramu.g);
        paramT.setMessageToken(paramu.h);
        switch (j)
        {
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 12:
        case 13:
        default:
          label240: if (j == 7)
            paramT.setMsgInfo(paramu.e);
          break;
        case 1:
        case 3:
        case 11:
        case 2:
        case 10:
        case 14:
        case 4:
        }
        break;
      case 0:
      case 2:
      case 3:
      case 14:
      case 1004:
      case 1009:
      case 1010:
      }
      while (true)
      {
        paramT.setFlags(c.a(paramu));
        paramT.setLatitude(paramu.q);
        paramT.setLongitude(paramu.r);
        if (this.d != null)
          paramT.setThumbnailByteArray(this.d.b(paramu));
        return;
        if (i != 1010)
          break label493;
        j = 3;
        break;
        paramT.setBody(paramu.e);
        break label108;
        paramT.setDuration(paramu.f);
        break label108;
        if (da.a(paramu.j))
          paramT.setDownloadId(paramu.l.toDecString());
        while (true)
        {
          if (av.d(this.c, 1))
            paramT.setEncryptionParams(EncryptionParams.unserializeCrossPlatformEncryptionParams(paramu.c().getMediaMetadata().getEncParams()));
          paramT.setBucket(paramu.k);
          break;
          paramT.setDownloadId(paramu.j);
        }
        if (da.a(paramu.j))
          paramT.setDownloadId(paramu.l.toDecString());
        while (av.d(this.c, 1))
        {
          paramT.setEncryptionParams(EncryptionParams.unserializeCrossPlatformEncryptionParams(paramu.c().getMediaMetadata().getEncParams()));
          break;
          paramT.setDownloadId(paramu.j);
        }
        paramT.setDownloadId(paramu.l.toServerString());
        break label240;
        paramT.setMsgInfo(paramu.m);
      }
      label493: j = i;
    }
  }

  protected String c()
  {
    return "messages LEFT OUTER JOIN conversations ON (messages.conversation_id = conversations._id) LEFT OUTER JOIN participants ON (messages.participant_id=participants._id) LEFT OUTER JOIN participants_info ON (participants.participant_info_id=participants_info._id)";
  }

  protected StringBuilder e()
  {
    StringBuilder localStringBuilder = new StringBuilder(750);
    localStringBuilder.append("messages.conversation_type = ").append(g());
    localStringBuilder.append(" AND messages.flag & 1 = 0");
    localStringBuilder.append(" AND messages.extra_flags & 1048576 = 0");
    localStringBuilder.append(" AND messages.extra_flags & 33554432 = 0");
    localStringBuilder.append(" AND messages.extra_flags & 4194304 = 0");
    localStringBuilder.append(" AND messages.extra_flags & " + av.a(0L, 32) + " = 0");
    localStringBuilder.append(" AND messages.extra_flags & " + av.a(0L, 38) + " = 0");
    localStringBuilder.append(" AND messages.deleted=0");
    localStringBuilder.append(" AND messages.token <> 0");
    localStringBuilder.append(" AND (conversations.flags & 32768)=0");
    localStringBuilder.append(" AND (conversations.flags & 16777216)=0");
    localStringBuilder.append(" AND (conversations.flags & 524288)=0");
    localStringBuilder.append(" AND conversations.deleted=0");
    localStringBuilder.append(" AND messages.status NOT IN (");
    for (int i = 0; i < g.length; i++)
    {
      if (i > 0)
        localStringBuilder.append(',');
      localStringBuilder.append(g[i]);
    }
    localStringBuilder.append(')');
    return localStringBuilder;
  }

  protected abstract int g();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.h
 * JD-Core Version:    0.6.2
 */