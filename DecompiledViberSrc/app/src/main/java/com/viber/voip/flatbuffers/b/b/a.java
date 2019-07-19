package com.viber.voip.flatbuffers.b.b;

import com.viber.voip.flatbuffers.library.NativeJsonFlatBuffersParser;
import java.nio.ByteBuffer;

public abstract class a<T extends com.viber.voip.flatbuffers.model.a>
  implements com.viber.voip.flatbuffers.b.a<T>
{
  protected final String b;

  public a(String paramString)
  {
    this.b = paramString;
  }

  public T a(String paramString)
  {
    ByteBuffer localByteBuffer = NativeJsonFlatBuffersParser.a(paramString, this.b);
    if (localByteBuffer == null)
      return null;
    return b(localByteBuffer);
  }

  protected abstract T b(ByteBuffer paramByteBuffer);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.b.a
 * JD-Core Version:    0.6.2
 */