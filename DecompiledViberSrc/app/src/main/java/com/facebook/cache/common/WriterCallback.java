package com.facebook.cache.common;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface WriterCallback
{
  public abstract void write(OutputStream paramOutputStream)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.WriterCallback
 * JD-Core Version:    0.6.2
 */