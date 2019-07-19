package com.viber.voip.storage.repository;

import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.orm.entity.impl.MessageEntityHelper;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.i.c;
import com.viber.voip.util.upload.i.o;
import java.util.Collections;
import java.util.EnumSet;

public class p
{
  private static final Logger a = ViberEnv.getLogger();
  private final t b;
  private final o c;
  private final ab d;

  public p(t paramt, o paramo, ab paramab)
  {
    this.b = paramt;
    this.c = paramo;
    this.d = paramab;
  }

  private String a(MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    Uri localUri;
    if ((paramBoolean) && (!da.a(paramMessageEntity.getMediaUri())))
      localUri = dx.a(paramMessageEntity.getMediaUri(), paramMessageEntity.getMimeType());
    while (true)
    {
      String str2;
      if (localUri != null)
        str2 = localUri.toString();
      String str1;
      boolean bool;
      do
      {
        return str2;
        if (da.a(paramMessageEntity.getDownloadId()))
          break label152;
        if (c(paramMessageEntity))
        {
          if (paramMessageEntity.isVideoPtt())
          {
            localUri = dx.e(paramMessageEntity.getDownloadId());
            break;
          }
          localUri = dx.a(paramMessageEntity.getDownloadId(), 400, null);
          break;
        }
        localUri = dx.a(paramMessageEntity.getDownloadId(), null, EncryptionParams.unserializeEncryptionParams(paramMessageEntity.getMessageInfo().getThumbnailEP()), i.c.b, i.o.a, Boolean.valueOf(paramMessageEntity.isPublicGroupType()));
        break;
        str1 = paramMessageEntity.getMessageInfo().getThumbnailUrl();
        bool = da.a(str1);
        str2 = null;
      }
      while (bool);
      return str1;
      label152: localUri = null;
    }
  }

  private void a(MessageEntity paramMessageEntity)
  {
    boolean bool1 = true;
    boolean bool2 = b(paramMessageEntity);
    if ((paramMessageEntity.isIncoming()) && (!paramMessageEntity.hasExtraStatus()) && (bool2))
    {
      paramMessageEntity.setExtraStatus(4);
      paramMessageEntity.setMediaUri(null);
    }
    for (boolean bool3 = bool1; ; bool3 = false)
    {
      if (paramMessageEntity.isMediaWithThumbnail())
      {
        boolean bool4 = false;
        if (!bool2)
          bool4 = bool1;
        paramMessageEntity.setBody(a(paramMessageEntity, bool4));
      }
      while (true)
      {
        if (bool1)
          this.d.b(paramMessageEntity);
        return;
        bool1 = bool3;
      }
    }
  }

  private boolean b(MessageEntity paramMessageEntity)
  {
    String str;
    if (((paramMessageEntity.isImage()) || (paramMessageEntity.isVideo()) || (paramMessageEntity.isGifFile())) && (!paramMessageEntity.isWink()) && ((!c(paramMessageEntity)) || (paramMessageEntity.isOutgoing())))
      str = paramMessageEntity.getMediaUri();
    return (da.a(str)) || ((!dk.a(Uri.parse(str))) && (!dk.d(Uri.parse(str))));
  }

  private boolean c(MessageEntity paramMessageEntity)
  {
    return ((paramMessageEntity.isPublicGroupBehavior()) && (!paramMessageEntity.isPublicAccount())) || (paramMessageEntity.isPgForwardedMessage());
  }

  public a a(long paramLong, MediaFileType[] paramArrayOfMediaFileType, b paramb)
  {
    p.a.a locala = new p.a.a();
    MessageEntity localMessageEntity = new MessageEntity();
    n localn = new n();
    int[] arrayOfInt = MediaFileType.getAssociatedMessagesMimeTypes(paramArrayOfMediaFileType);
    EnumSet localEnumSet = EnumSet.noneOf(MediaFileType.class);
    Collections.addAll(localEnumSet, paramArrayOfMediaFileType);
    this.b.a(paramLong, arrayOfInt, MessageEntityHelper.PROJECTIONS, new q(this, localn, localMessageEntity, localEnumSet, locala, paramb));
    return locala.b();
  }

  public static class a
  {
    private final boolean a;

    private a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    public boolean a()
    {
      return this.a;
    }

    public String toString()
    {
      return "MediaFilesDeletionResult{mSucceed=" + this.a + '}';
    }

    static class a
    {
      private boolean a = true;

      a a()
      {
        this.a = false;
        return this;
      }

      public p.a b()
      {
        return new p.a(this.a, null);
      }
    }
  }

  public static abstract interface b
  {
    public abstract void a(long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.p
 * JD-Core Version:    0.6.2
 */