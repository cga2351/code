package com.facebook.binaryresource;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayBinaryResource
  implements BinaryResource
{
  private final byte[] mBytes;

  public ByteArrayBinaryResource(byte[] paramArrayOfByte)
  {
    this.mBytes = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
  }

  public InputStream openStream()
    throws IOException
  {
    return new ByteArrayInputStream(this.mBytes);
  }

  public byte[] read()
  {
    return this.mBytes;
  }

  public long size()
  {
    return this.mBytes.length;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.binaryresource.ByteArrayBinaryResource
 * JD-Core Version:    0.6.2
 */