package com.viber.voip.flatbuffers.b.e;

import com.viber.voip.flatbuffers.a.c.b;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.TextMetaInfo.a;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;

public class a
{
  private static TextMetaInfo a(b paramb)
  {
    if (paramb == null)
      return null;
    TextMetaInfo localTextMetaInfo = new TextMetaInfo();
    localTextMetaInfo.setStartPosition(paramb.b());
    localTextMetaInfo.setEndPosition(paramb.c());
    localTextMetaInfo.setType(TextMetaInfo.a.fromValue(paramb.d()));
    localTextMetaInfo.setMemberId(paramb.e());
    return localTextMetaInfo;
  }

  public static QuotedMessageData a(com.viber.voip.flatbuffers.a.c.a parama)
  {
    if (parama == null)
      return null;
    QuotedMessageData localQuotedMessageData = new QuotedMessageData();
    localQuotedMessageData.setBody(parama.b());
    localQuotedMessageData.setDownloadId(parama.e());
    localQuotedMessageData.setSenderName(parama.f());
    localQuotedMessageData.setToken(parama.g());
    localQuotedMessageData.setType(parama.c());
    localQuotedMessageData.setMemberId(parama.d());
    localQuotedMessageData.setFromPublicAccount(parama.h());
    localQuotedMessageData.setPreviewText(parama.i());
    localQuotedMessageData.setFlags(parama.j());
    localQuotedMessageData.setMessageUrl(parama.l());
    localQuotedMessageData.setMessageId(parama.k());
    localQuotedMessageData.setSpans(parama.m());
    localQuotedMessageData.setEncryptedPhoneNumber(parama.n());
    localQuotedMessageData.setReplySource(parama.p());
    a(localQuotedMessageData, parama);
    return localQuotedMessageData;
  }

  private static void a(QuotedMessageData paramQuotedMessageData, com.viber.voip.flatbuffers.a.c.a parama)
  {
    int i = parama.o();
    if (i > 0)
    {
      TextMetaInfo[] arrayOfTextMetaInfo = new TextMetaInfo[i];
      for (int j = 0; j < i; j++)
        arrayOfTextMetaInfo[j] = a(parama.f(j));
      paramQuotedMessageData.setTextMetaInfo(arrayOfTextMetaInfo);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.e.a
 * JD-Core Version:    0.6.2
 */