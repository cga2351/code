package com.viber.voip.flatbuffers.b.a;

import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import java.nio.ByteBuffer;

public class b extends com.viber.voip.flatbuffers.b.b.a<ConferenceInfo>
{
  public static boolean a = true;

  public b(String paramString)
  {
    super(paramString);
  }

  protected ConferenceInfo a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
      return null;
    return a.a(com.viber.voip.flatbuffers.a.a.a.a(paramByteBuffer));
  }

  public ConferenceInfo b(String paramString)
  {
    ConferenceInfo localConferenceInfo;
    if ((paramString == null) || (paramString.length() < 7))
      localConferenceInfo = new ConferenceInfo();
    while (true)
    {
      return localConferenceInfo;
      try
      {
        localConferenceInfo = (ConferenceInfo)super.a(paramString);
        if ((localConferenceInfo != null) || (!a))
          continue;
        return new d().c(paramString);
      }
      catch (Throwable localThrowable)
      {
        while (true)
          localConferenceInfo = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.a.b
 * JD-Core Version:    0.6.2
 */