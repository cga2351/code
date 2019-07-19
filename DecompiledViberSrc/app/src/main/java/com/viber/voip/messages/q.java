package com.viber.voip.messages;

import android.text.TextUtils;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.b;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.ContactInfoSection;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class q
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "text", "picture", "url", "video", "contact", "file", "location", "sticker", "rich_media" })));

  public static a a(String paramString)
  {
    MsgInfo localMsgInfo = (MsgInfo)com.viber.voip.flatbuffers.b.e.a().a().a(paramString);
    int i = c(localMsgInfo.getPublicAccountMsgInfo().getType());
    String str = a(localMsgInfo, i);
    if (str == null);
    while (true)
    {
      return new a(paramString, localMsgInfo, i);
      paramString = str;
    }
  }

  private static String a(MsgInfo paramMsgInfo)
  {
    if (TextUtils.isEmpty(paramMsgInfo.getPublicAccountMsgInfo().getText()));
    return null;
  }

  private static String a(MsgInfo paramMsgInfo, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return a(paramMsgInfo);
    case 4:
      return b(paramMsgInfo);
    case 1:
      return d(paramMsgInfo);
    case 3:
      return e(paramMsgInfo);
    case 10:
      return f(paramMsgInfo);
    case 5:
      return c(paramMsgInfo);
    case 8:
      return g(paramMsgInfo);
    case 9:
      return h(paramMsgInfo);
    case 1006:
    }
    return i(paramMsgInfo);
  }

  private static String b(MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo.getPublicAccountMsgInfo().getStickerId() <= 0L);
    return null;
  }

  public static boolean b(String paramString)
  {
    return b.contains(paramString);
  }

  private static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return 0;
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3556653:
    case -577741570:
    case 116079:
    case 112202875:
    case 951526432:
    case 1901043637:
    case 3143036:
    case -1890252483:
    case 503739367:
    case -357685567:
    }
    while (true)
      switch (i)
      {
      case 0:
      case 8:
      default:
        return 0;
      case 1:
        return 1;
        if (paramString.equals("text"))
        {
          i = 0;
          continue;
          if (paramString.equals("picture"))
          {
            i = 1;
            continue;
            if (paramString.equals("url"))
            {
              i = 2;
              continue;
              if (paramString.equals("video"))
              {
                i = 3;
                continue;
                if (paramString.equals("contact"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("location"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("file"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("sticker"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("keyboard"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("rich_media"))
                            i = 9;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 9:
      }
    return 8;
    return 3;
    return 9;
    return 5;
    return 10;
    return 4;
    return 1006;
  }

  private static String c(MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo.getPublicAccountMsgInfo().getLocation() == null);
    return null;
  }

  private static String d(MsgInfo paramMsgInfo)
  {
    PublicAccountMsgInfo localPublicAccountMsgInfo = paramMsgInfo.getPublicAccountMsgInfo();
    if (TextUtils.isEmpty(localPublicAccountMsgInfo.getMedia()));
    paramMsgInfo.setText(localPublicAccountMsgInfo.getText());
    paramMsgInfo.setUrl(localPublicAccountMsgInfo.getMedia());
    paramMsgInfo.setUrlType(MsgInfo.a.IMAGE);
    paramMsgInfo.setContentType("image/*");
    paramMsgInfo.setThumbnailUrl(localPublicAccountMsgInfo.getThumbnailUrl());
    return com.viber.voip.flatbuffers.b.e.a().b().a(paramMsgInfo);
  }

  private static String e(MsgInfo paramMsgInfo)
  {
    PublicAccountMsgInfo localPublicAccountMsgInfo = paramMsgInfo.getPublicAccountMsgInfo();
    if ((!TextUtils.isEmpty(localPublicAccountMsgInfo.getMedia())) && (localPublicAccountMsgInfo.getSize() <= 0L));
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.setContentType(FileInfo.a.VIDEO);
    localFileInfo.setFileSize(localPublicAccountMsgInfo.getSize());
    localFileInfo.setDuration(1000L * localPublicAccountMsgInfo.getDuration());
    paramMsgInfo.setFileInfo(localFileInfo);
    paramMsgInfo.setText(localPublicAccountMsgInfo.getText());
    paramMsgInfo.setUrl(localPublicAccountMsgInfo.getMedia());
    paramMsgInfo.setUrlType(MsgInfo.a.VIDEO);
    paramMsgInfo.setContentType("video/*");
    paramMsgInfo.setThumbnailUrl(localPublicAccountMsgInfo.getThumbnailUrl());
    return com.viber.voip.flatbuffers.b.e.a().b().a(paramMsgInfo);
  }

  private static String f(MsgInfo paramMsgInfo)
  {
    PublicAccountMsgInfo localPublicAccountMsgInfo = paramMsgInfo.getPublicAccountMsgInfo();
    if ((!TextUtils.isEmpty(localPublicAccountMsgInfo.getMedia())) && (!TextUtils.isEmpty(localPublicAccountMsgInfo.getFileName())) && (localPublicAccountMsgInfo.getSize() <= 0L));
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.setContentType(FileInfo.a.FILE);
    localFileInfo.setFileSize(localPublicAccountMsgInfo.getSize());
    String str1 = localPublicAccountMsgInfo.getFileName();
    int i = str1.lastIndexOf('.');
    if (i > 0);
    for (String str2 = str1.substring(i + 1); ; str2 = "")
    {
      localFileInfo.setFileName(str1);
      localFileInfo.setFileExt(str2);
      localFileInfo.setFileSize(localPublicAccountMsgInfo.getSize());
      paramMsgInfo.setFileInfo(localFileInfo);
      paramMsgInfo.setText(localPublicAccountMsgInfo.getMedia());
      paramMsgInfo.setUrl(localPublicAccountMsgInfo.getMedia());
      return com.viber.voip.flatbuffers.b.e.a().b().a(paramMsgInfo);
    }
  }

  private static String g(MsgInfo paramMsgInfo)
  {
    PublicAccountMsgInfo localPublicAccountMsgInfo = paramMsgInfo.getPublicAccountMsgInfo();
    if (TextUtils.isEmpty(localPublicAccountMsgInfo.getMedia()));
    String str = localPublicAccountMsgInfo.getText();
    if (TextUtils.isEmpty(str))
      str = localPublicAccountMsgInfo.getMedia();
    while (true)
    {
      paramMsgInfo.setText(str);
      paramMsgInfo.setUrl(localPublicAccountMsgInfo.getMedia());
      return com.viber.voip.flatbuffers.b.e.a().b().a(paramMsgInfo);
      if (!str.contains(localPublicAccountMsgInfo.getMedia()))
        str = str + " " + localPublicAccountMsgInfo.getMedia();
    }
  }

  private static String h(MsgInfo paramMsgInfo)
  {
    ContactInfoSection localContactInfoSection = paramMsgInfo.getPublicAccountMsgInfo().getContact();
    if ((localContactInfoSection != null) && (!TextUtils.isEmpty(localContactInfoSection.getName())) && (TextUtils.isEmpty(localContactInfoSection.getPhoneNumber())));
    paramMsgInfo.setName(localContactInfoSection.getName());
    paramMsgInfo.setPhoneNumber(localContactInfoSection.getPhoneNumber());
    return com.viber.voip.flatbuffers.b.e.a().b().a(paramMsgInfo);
  }

  private static String i(MsgInfo paramMsgInfo)
  {
    return null;
  }

  public static class a
  {
    private String a;
    private MsgInfo b;
    private final int c;

    public a(String paramString, MsgInfo paramMsgInfo, int paramInt)
    {
      this.a = paramString;
      this.b = paramMsgInfo;
      this.c = paramInt;
    }

    public String a()
    {
      return this.a;
    }

    public MsgInfo b()
    {
      return this.b;
    }

    public int c()
    {
      return this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.q
 * JD-Core Version:    0.6.2
 */