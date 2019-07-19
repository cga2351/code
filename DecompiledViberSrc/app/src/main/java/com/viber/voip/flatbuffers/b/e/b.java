package com.viber.voip.flatbuffers.b.e;

import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import java.nio.ByteBuffer;

public class b extends com.viber.voip.flatbuffers.b.b.a<QuotedMessageData>
{
  public static boolean a = true;

  public b(String paramString)
  {
    super(paramString);
  }

  protected QuotedMessageData a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
      return null;
    return a.a(com.viber.voip.flatbuffers.a.c.a.a(paramByteBuffer));
  }

  public QuotedMessageData b(String paramString)
  {
    QuotedMessageData localQuotedMessageData;
    if ((paramString == null) || (paramString.length() < 7))
      localQuotedMessageData = new QuotedMessageData();
    while (true)
    {
      return localQuotedMessageData;
      try
      {
        localQuotedMessageData = (QuotedMessageData)super.a(paramString);
        if ((localQuotedMessageData != null) || (!a))
          continue;
        return new d().c(paramString);
      }
      catch (Throwable localThrowable)
      {
        while (true)
          localQuotedMessageData = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.e.b
 * JD-Core Version:    0.6.2
 */