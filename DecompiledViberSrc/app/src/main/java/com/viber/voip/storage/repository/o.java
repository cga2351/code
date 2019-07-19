package com.viber.voip.storage.repository;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.messages.extras.map.b;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.GifMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.sound.ptt.PttUtils;
import com.viber.voip.util.at;
import com.viber.voip.util.bg.a;
import com.viber.voip.util.dk;
import com.viber.voip.util.dv;
import com.viber.voip.util.dx;
import com.viber.voip.util.dx.b;
import com.viber.voip.util.dx.e;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class o
{
  private static final Logger a = ViberEnv.getLogger();
  private static final File b = new File("");
  private final Context c;

  public o(Context paramContext)
  {
    this.c = paramContext;
  }

  private File a(dv paramdv, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return b;
    return paramdv.b(this.c, paramString);
  }

  private File a(File paramFile)
  {
    File localFile;
    if ((paramFile == null) || (paramFile == b))
      localFile = b;
    do
    {
      return localFile;
      localFile = at.g(paramFile);
    }
    while (localFile != null);
    return b;
  }

  private void a(n paramn, FormattedMessage paramFormattedMessage)
  {
    if (paramFormattedMessage == null);
    while (true)
    {
      return;
      Iterator localIterator = paramFormattedMessage.getMessage().iterator();
      while (localIterator.hasNext())
      {
        BaseMessage localBaseMessage = (BaseMessage)localIterator.next();
        if (localBaseMessage.getType() == MessageType.GIF)
        {
          Uri localUri = Uri.parse(((GifMessage)localBaseMessage).getGifUrl());
          if (dx.l(localUri))
          {
            String str = dx.m(localUri).a;
            File localFile = a(dv.u, str);
            MediaFileType localMediaFileType = MediaFileType.GIF;
            File[] arrayOfFile = new File[3];
            arrayOfFile[0] = a(dv.g, str);
            arrayOfFile[1] = localFile;
            arrayOfFile[2] = a(localFile);
            paramn.a(localMediaFileType, arrayOfFile);
          }
        }
      }
    }
  }

  private void a(n paramn, ReplyButton[] paramArrayOfReplyButton)
  {
    if (com.viber.voip.util.n.a(paramArrayOfReplyButton));
    int i;
    int j;
    do
    {
      return;
      i = paramArrayOfReplyButton.length;
      j = 0;
    }
    while (j >= i);
    ReplyButton localReplyButton = paramArrayOfReplyButton[j];
    Uri localUri1 = localReplyButton.getImageUri();
    if (localUri1 != null)
      paramn.a(MediaFileType.PICTURE, a(dv.n, localUri1.toString()));
    Uri localUri2 = localReplyButton.getBgMedia();
    if (localUri2 != null)
      switch (1.a[localReplyButton.getBgMediaType().ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      }
    while (true)
    {
      j++;
      break;
      paramn.a(MediaFileType.PICTURE, a(dv.n, localUri2.toString()));
      continue;
      MediaFileType localMediaFileType2 = MediaFileType.VIDEO;
      File[] arrayOfFile2 = new File[2];
      arrayOfFile2[0] = a(dv.n, localUri2.toString());
      arrayOfFile2[1] = a(dv.q, localUri2.toString());
      paramn.a(localMediaFileType2, arrayOfFile2);
      continue;
      MediaFileType localMediaFileType1 = MediaFileType.GIF;
      File[] arrayOfFile1 = new File[3];
      arrayOfFile1[0] = a(dv.n, localUri2.toString());
      arrayOfFile1[1] = a(dv.q, localUri2.toString());
      arrayOfFile1[2] = a(dv.u, localUri2.toString());
      paramn.a(localMediaFileType1, arrayOfFile1);
    }
  }

  private boolean a(MessageEntity paramMessageEntity)
  {
    return ((paramMessageEntity.isPublicGroupBehavior()) && (!paramMessageEntity.isPublicAccount())) || (paramMessageEntity.isPgForwardedMessage());
  }

  private File b(MessageEntity paramMessageEntity)
  {
    Uri localUri = paramMessageEntity.getThumbnailUri();
    Object localObject;
    if (localUri == null)
      localObject = b;
    while (true)
    {
      return localObject;
      if (dk.b(localUri))
      {
        String str3 = localUri.getPath();
        boolean bool2 = TextUtils.isEmpty(str3);
        localObject = null;
        if (!bool2)
          localObject = new File(str3);
      }
      while (localObject == null)
      {
        return b;
        if (b.a(localUri.toString()))
        {
          localObject = dv.r.b(this.c, localUri.toString());
        }
        else if (dx.n(localUri))
        {
          dx.e locale = dx.o(localUri);
          localObject = dv.q.b(this.c, locale.a());
        }
        else
        {
          File localFile = dv.q.b(this.c, localUri.toString());
          if ((!localFile.exists()) && (dx.q(localUri)))
          {
            String str1 = dx.r(localUri);
            if (!TextUtils.isEmpty(str1))
            {
              String str2 = Uri.parse(str1).getPath();
              boolean bool1 = TextUtils.isEmpty(str2);
              localObject = null;
              if (!bool1)
                localObject = new File(str2);
            }
            else if (a(paramMessageEntity))
            {
              localObject = a(dv.n, localUri.toString());
            }
          }
          else
          {
            localObject = localFile;
          }
        }
      }
    }
  }

  private File c(MessageEntity paramMessageEntity)
  {
    if ((a(paramMessageEntity)) && ((paramMessageEntity.isVideo()) || (paramMessageEntity.isImage()) || (paramMessageEntity.isVideoPtt())) && (dk.b(paramMessageEntity.getThumbnailUri())))
    {
      if (paramMessageEntity.isVideoPtt());
      for (Uri localUri = dx.e(paramMessageEntity.getDownloadId()); ; localUri = dx.a(paramMessageEntity.getDownloadId(), 400, null))
        return a(dv.n, localUri.toString());
    }
    return b;
  }

  public void a(n paramn, MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isImage())
    {
      MediaFileType localMediaFileType13 = MediaFileType.PICTURE;
      File[] arrayOfFile13 = new File[3];
      arrayOfFile13[0] = b(paramMessageEntity);
      arrayOfFile13[1] = a(dv.h, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
      arrayOfFile13[2] = a(dv.n, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
      paramn.a(localMediaFileType13, arrayOfFile13);
      if (a(paramMessageEntity))
      {
        File localFile9 = a(dv.J, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
        MediaFileType localMediaFileType15 = MediaFileType.PICTURE;
        File[] arrayOfFile15 = new File[3];
        arrayOfFile15[0] = c(paramMessageEntity);
        arrayOfFile15[1] = localFile9;
        arrayOfFile15[2] = a(localFile9);
        paramn.a(localMediaFileType15, arrayOfFile15);
      }
    }
    label801: BotReplyConfig localBotReplyConfig1;
    do
    {
      do
      {
        BotReplyConfig localBotReplyConfig2;
        do
        {
          String str1;
          String str2;
          do
          {
            do
            {
              String str5;
              do
              {
                String str7;
                do
                {
                  String str6;
                  do
                  {
                    return;
                    if (paramMessageEntity.isHiddenContent())
                    {
                      File localFile8 = a(dv.p, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                      MediaFileType localMediaFileType14 = MediaFileType.PICTURE;
                      File[] arrayOfFile14 = new File[2];
                      arrayOfFile14[0] = localFile8;
                      arrayOfFile14[1] = a(localFile8);
                      paramn.a(localMediaFileType14, arrayOfFile14);
                      return;
                    }
                    File localFile7 = com.viber.voip.util.upload.o.b(paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl(), paramMessageEntity.getMimeType(), this.c);
                    paramn.a(MediaFileType.PICTURE, a(localFile7));
                    return;
                    if (paramMessageEntity.isVideo())
                    {
                      MediaFileType localMediaFileType10 = MediaFileType.VIDEO;
                      File[] arrayOfFile10 = new File[4];
                      arrayOfFile10[0] = b(paramMessageEntity);
                      arrayOfFile10[1] = a(dv.i, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                      arrayOfFile10[2] = a(dv.n, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                      arrayOfFile10[3] = a(dv.q, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                      paramn.a(localMediaFileType10, arrayOfFile10);
                      if (a(paramMessageEntity))
                      {
                        File localFile6 = a(dv.K, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                        MediaFileType localMediaFileType12 = MediaFileType.VIDEO;
                        File[] arrayOfFile12 = new File[3];
                        arrayOfFile12[0] = c(paramMessageEntity);
                        arrayOfFile12[1] = localFile6;
                        arrayOfFile12[2] = a(localFile6);
                        paramn.a(localMediaFileType12, arrayOfFile12);
                        return;
                      }
                      if (paramMessageEntity.isHiddenContent())
                      {
                        File localFile5 = a(dv.p, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                        MediaFileType localMediaFileType11 = MediaFileType.VIDEO;
                        File[] arrayOfFile11 = new File[2];
                        arrayOfFile11[0] = localFile5;
                        arrayOfFile11[1] = a(localFile5);
                        paramn.a(localMediaFileType11, arrayOfFile11);
                        return;
                      }
                      File localFile4 = com.viber.voip.util.upload.o.b(paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl(), paramMessageEntity.getMimeType(), this.c);
                      paramn.a(MediaFileType.VIDEO, a(localFile4));
                      return;
                    }
                    if (paramMessageEntity.isGifFile())
                    {
                      MediaFileType localMediaFileType9 = MediaFileType.GIF;
                      File[] arrayOfFile9 = new File[4];
                      arrayOfFile9[0] = b(paramMessageEntity);
                      arrayOfFile9[1] = a(dv.g, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                      arrayOfFile9[2] = a(dv.n, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                      arrayOfFile9[3] = a(dv.u, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                      paramn.a(localMediaFileType9, arrayOfFile9);
                      return;
                    }
                    if (!paramMessageEntity.isVoiceMessage())
                      break;
                    str6 = paramMessageEntity.getMediaUri();
                  }
                  while (TextUtils.isEmpty(str6));
                  str7 = Uri.parse(str6).getPath();
                }
                while (TextUtils.isEmpty(str7));
                File localFile3 = new File(str7);
                MediaFileType localMediaFileType8 = MediaFileType.AUDIO_PTT;
                File[] arrayOfFile8 = new File[2];
                arrayOfFile8[0] = localFile3;
                arrayOfFile8[1] = a(localFile3);
                paramn.a(localMediaFileType8, arrayOfFile8);
                return;
                if (!paramMessageEntity.isAudioPtt())
                  break;
                str5 = paramMessageEntity.getMediaUri();
              }
              while (TextUtils.isEmpty(str5));
              File localFile2 = PttUtils.generateLegacyPttFile(str5, this.c);
              MediaFileType localMediaFileType7 = MediaFileType.AUDIO_PTT;
              File[] arrayOfFile7 = new File[2];
              arrayOfFile7[0] = localFile2;
              arrayOfFile7[1] = a(localFile2);
              paramn.a(localMediaFileType7, arrayOfFile7);
              return;
              if (paramMessageEntity.isVideoPttBehavior())
              {
                String str4;
                File localFile1;
                if (!TextUtils.isEmpty(paramMessageEntity.getMediaUri()))
                {
                  Uri localUri = Uri.parse(paramMessageEntity.getMediaUri());
                  if (dk.b(localUri))
                  {
                    str4 = localUri.getPath();
                    if (!TextUtils.isEmpty(str4))
                      break label801;
                    localFile1 = b;
                  }
                }
                while (true)
                {
                  MediaFileType localMediaFileType6 = MediaFileType.VIDEO_PTT;
                  File[] arrayOfFile6 = new File[4];
                  arrayOfFile6[0] = b(paramMessageEntity);
                  arrayOfFile6[1] = c(paramMessageEntity);
                  arrayOfFile6[2] = localFile1;
                  arrayOfFile6[3] = a(localFile1);
                  paramn.a(localMediaFileType6, arrayOfFile6);
                  return;
                  str4 = "";
                  break;
                  localFile1 = new File(str4);
                  continue;
                  if (paramMessageEntity.isIncoming())
                  {
                    if (a(paramMessageEntity));
                    for (dv localdv = dv.J; ; localdv = dv.A)
                    {
                      localFile1 = a(localdv, paramMessageEntity.getDownloadIdOrPublicAccountDownloadUrl());
                      break;
                    }
                  }
                  localFile1 = b;
                }
              }
              if (!paramMessageEntity.isUrlMessage())
                break;
              str1 = paramMessageEntity.getUrlMessageThumbnailContentType();
            }
            while (TextUtils.isEmpty(str1));
            if (bg.a.d(str1))
            {
              MediaFileType localMediaFileType5 = MediaFileType.GIF;
              File[] arrayOfFile5 = new File[3];
              arrayOfFile5[0] = a(dv.q, paramMessageEntity.getMessageInfo().getThumbnailUrl());
              arrayOfFile5[1] = a(dv.n, paramMessageEntity.getMessageInfo().getUrl());
              arrayOfFile5[2] = a(dv.u, paramMessageEntity.getMessageInfo().getUrl());
              paramn.a(localMediaFileType5, arrayOfFile5);
              return;
            }
            if (!bg.a.a(str1))
              break;
            str2 = paramMessageEntity.getMessageInfo().getUrl();
            MediaFileType localMediaFileType3 = MediaFileType.PICTURE;
            File[] arrayOfFile3 = new File[2];
            arrayOfFile3[0] = a(dv.q, str2);
            arrayOfFile3[1] = a(dv.n, str2);
            paramn.a(localMediaFileType3, arrayOfFile3);
          }
          while ((!TextUtils.isEmpty(str2)) && (str2.equals(paramMessageEntity.getMessageInfo().getThumbnailUrl())));
          String str3 = paramMessageEntity.getMessageInfo().getThumbnailUrl();
          MediaFileType localMediaFileType4 = MediaFileType.PICTURE;
          File[] arrayOfFile4 = new File[2];
          arrayOfFile4[0] = a(dv.q, str3);
          arrayOfFile4[1] = a(dv.n, str3);
          paramn.a(localMediaFileType4, arrayOfFile4);
          return;
          if (bg.a.c(str1))
          {
            MediaFileType localMediaFileType2 = MediaFileType.VIDEO;
            File[] arrayOfFile2 = new File[2];
            arrayOfFile2[0] = a(dv.q, paramMessageEntity.getMessageInfo().getThumbnailUrl());
            arrayOfFile2[1] = a(dv.q, paramMessageEntity.getMessageInfo().getUrl());
            paramn.a(localMediaFileType2, arrayOfFile2);
            return;
          }
          MediaFileType localMediaFileType1 = MediaFileType.PICTURE;
          File[] arrayOfFile1 = new File[2];
          arrayOfFile1[0] = a(dv.q, paramMessageEntity.getMessageInfo().getThumbnailUrl());
          arrayOfFile1[1] = a(dv.n, paramMessageEntity.getMessageInfo().getThumbnailUrl());
          paramn.a(localMediaFileType1, arrayOfFile1);
          return;
          if (paramMessageEntity.isLocationMessage())
          {
            paramn.a(MediaFileType.PICTURE, b(paramMessageEntity));
            return;
          }
          if (paramMessageEntity.isFormattedMessage())
          {
            a(paramn, paramMessageEntity.getFormattedMessage());
            return;
          }
          if (!paramMessageEntity.isRichMessage())
            break;
          PublicAccountMsgInfo localPublicAccountMsgInfo2 = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo();
          paramn.a(MediaFileType.PICTURE, a(dv.n, localPublicAccountMsgInfo2.getThumbnailUrl()));
          localBotReplyConfig2 = localPublicAccountMsgInfo2.getRichMedia();
        }
        while (localBotReplyConfig2 == null);
        a(paramn, localBotReplyConfig2.getButtons());
        return;
      }
      while (!paramMessageEntity.isReplyToBot());
      PublicAccountMsgInfo localPublicAccountMsgInfo1 = paramMessageEntity.getMessageInfo().getPublicAccountMsgInfo();
      paramn.a(MediaFileType.PICTURE, a(dv.n, localPublicAccountMsgInfo1.getThumbnailUrl()));
      localBotReplyConfig1 = localPublicAccountMsgInfo1.getKeyboard();
    }
    while (localBotReplyConfig1 == null);
    a(paramn, localBotReplyConfig1.getButtons());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.o
 * JD-Core Version:    0.6.2
 */