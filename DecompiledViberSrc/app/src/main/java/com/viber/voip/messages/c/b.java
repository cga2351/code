package com.viber.voip.messages.c;

import android.app.Application;
import android.content.res.Resources;
import android.net.Uri;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.msginfo.Quote;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.l;
import com.viber.voip.messages.m;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import java.util.ArrayList;

public class b
{
  public static Uri a(int paramInt, QuotedMessageData paramQuotedMessageData, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default:
    case 1:
    case 3:
    case 5:
    case 1005:
    case 9:
    case 10:
    case 8:
    }
    do
    {
      do
        return null;
      while (paramQuotedMessageData.getBody() == null);
      return Uri.parse(paramQuotedMessageData.getBody());
      return dx.a(paramQuotedMessageData.getDownloadId());
      if (paramBoolean);
      for (int i = R.drawable.reply_banner_file_thumb; ; i = R.drawable.reply_file_thumb)
        return dx.a(i);
    }
    while ((!paramQuotedMessageData.isGif()) || (paramQuotedMessageData.getMessageUrl() == null));
    return Uri.parse(paramQuotedMessageData.getMessageUrl());
  }

  public static Quote a(QuotedMessageData paramQuotedMessageData, int paramInt)
  {
    Quote localQuote = new Quote();
    if (m.e(paramInt));
    for (String str = paramQuotedMessageData.getEncryptedPhoneNumber(); ; str = paramQuotedMessageData.getMemberId())
    {
      a(localQuote, paramQuotedMessageData);
      localQuote.setToken(paramQuotedMessageData.getToken());
      localQuote.setMediaType(l.b(paramQuotedMessageData.getType()));
      localQuote.setMemberId(str);
      localQuote.setMessageId(paramQuotedMessageData.getMessageId());
      localQuote.setReplySource(paramQuotedMessageData.getReplySource());
      return localQuote;
    }
  }

  public static CharSequence a(Resources paramResources, QuotedMessageData paramQuotedMessageData, ai paramai, com.viber.voip.messages.d.b paramb, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramQuotedMessageData.getType())
    {
    default:
      return paramQuotedMessageData.getBody();
    case 1:
      return paramResources.getString(R.string.image_quote_bubble_text);
    case 3:
      return paramResources.getString(R.string.video_quote_bubble_text);
    case 5:
      return paramResources.getString(R.string.location_quote_bubble_text);
    case 9:
      return paramResources.getString(R.string.contact_quote_bubble_text);
    case 4:
      return paramResources.getString(R.string.sticker_quote_bubble_text);
    case 10:
      if (paramQuotedMessageData.isGif())
        return paramResources.getString(R.string.gif_quote_bubble_text);
      return paramResources.getString(R.string.file_quote_bubble_text);
    case 1006:
      return paramResources.getString(R.string.message);
    case 7:
    case 8:
      if (paramQuotedMessageData.isGif())
        return paramResources.getString(R.string.gif_quote_bubble_text);
      if (da.a(paramQuotedMessageData.getPreviewText()));
      for (String str = paramQuotedMessageData.getBody(); ; str = paramQuotedMessageData.getPreviewText())
        return da.a(str, paramai, paramb, paramQuotedMessageData.getSpans(), paramBoolean1, false, true, paramBoolean2, aj.d, paramInt1, paramInt2);
    case 0:
      return da.a(paramQuotedMessageData.getBody(), paramai, paramb, paramQuotedMessageData.getSpans(), paramBoolean1, false, true, paramBoolean2, aj.d, paramInt1, paramInt2);
    case 1005:
    }
    return paramResources.getString(R.string.gif_quote_bubble_text);
  }

  public static String a(int paramInt, String paramString)
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    switch (paramInt)
    {
    default:
      return paramString;
    case 1:
      return localResources.getString(R.string.image_quote_bubble_text);
    case 3:
      return localResources.getString(R.string.video_quote_bubble_text);
    case 5:
      return localResources.getString(R.string.location_quote_bubble_text);
    case 9:
      return localResources.getString(R.string.contact_quote_bubble_text);
    case 4:
      return localResources.getString(R.string.sticker_quote_bubble_text);
    case 10:
      return localResources.getString(R.string.file_quote_bubble_text);
    case 1005:
      return localResources.getString(R.string.message_type_gif);
    case 1006:
    }
    return localResources.getString(R.string.message_type_rich_message);
  }

  private static void a(Quote paramQuote, QuotedMessageData paramQuotedMessageData)
  {
    String str;
    int i;
    switch (paramQuotedMessageData.getType())
    {
    default:
      str = "";
      i = 0;
    case 0:
    case 7:
    case 8:
    }
    while (true)
    {
      if (!da.a(str))
        str = str.substring(0, Math.min(str.length(), 120));
      paramQuote.setText(str);
      if (i != 0)
        paramQuote.setTextMetaInfo(a(str, paramQuotedMessageData));
      return;
      str = paramQuotedMessageData.getBody();
      i = 1;
      continue;
      str = paramQuotedMessageData.getPreviewText();
      i = 0;
    }
  }

  public static boolean a(QuotedMessageData paramQuotedMessageData)
  {
    switch (paramQuotedMessageData.getType())
    {
    default:
      return false;
    case 1:
    case 3:
    case 5:
    case 9:
    case 10:
    case 1005:
      return true;
    case 8:
    }
    return paramQuotedMessageData.isGif();
  }

  private static TextMetaInfo[] a(String paramString, QuotedMessageData paramQuotedMessageData)
  {
    TextMetaInfo[] arrayOfTextMetaInfo1 = paramQuotedMessageData.getTextMetaInfo();
    TextMetaInfo[] arrayOfTextMetaInfo2 = null;
    if (arrayOfTextMetaInfo1 != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramString.length();
      int j = arrayOfTextMetaInfo1.length;
      for (int k = 0; k < j; k++)
      {
        TextMetaInfo localTextMetaInfo1 = arrayOfTextMetaInfo1[k];
        if (localTextMetaInfo1.getStartPosition() < i)
        {
          TextMetaInfo localTextMetaInfo2 = new TextMetaInfo(localTextMetaInfo1);
          if (localTextMetaInfo1.getEndPosition() > i)
            localTextMetaInfo2.setEndPosition(i);
          localArrayList.add(localTextMetaInfo2);
        }
      }
      int m = localArrayList.size();
      arrayOfTextMetaInfo2 = null;
      if (m > 0)
      {
        arrayOfTextMetaInfo2 = new TextMetaInfo[localArrayList.size()];
        localArrayList.toArray(arrayOfTextMetaInfo2);
      }
    }
    return arrayOfTextMetaInfo2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.c.b
 * JD-Core Version:    0.6.2
 */