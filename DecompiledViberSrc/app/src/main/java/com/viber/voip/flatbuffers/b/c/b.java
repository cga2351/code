package com.viber.voip.flatbuffers.b.c;

import com.viber.voip.flatbuffers.a.b.t;
import com.viber.voip.flatbuffers.b.c;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import java.nio.ByteBuffer;

public class b extends com.viber.voip.flatbuffers.b.b.a<MsgInfo>
{
  public static boolean a = true;

  public b(String paramString)
  {
    super(paramString);
  }

  protected MsgInfo a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
      return null;
    return a.a(t.a(paramByteBuffer));
  }

  public MsgInfo b(String paramString)
  {
    MsgInfo localMsgInfo;
    if (c.a(paramString))
      localMsgInfo = new MsgInfo();
    while (true)
    {
      return localMsgInfo;
      try
      {
        localMsgInfo = (MsgInfo)super.a(paramString);
        if ((localMsgInfo != null) || (!a))
          continue;
        return new d().c(paramString);
      }
      catch (Throwable localThrowable)
      {
        while (true)
          localMsgInfo = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.c.b
 * JD-Core Version:    0.6.2
 */