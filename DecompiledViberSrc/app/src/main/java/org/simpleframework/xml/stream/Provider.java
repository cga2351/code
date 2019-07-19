package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;

abstract interface Provider
{
  public abstract EventReader provide(InputStream paramInputStream)
    throws Exception;

  public abstract EventReader provide(Reader paramReader)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Provider
 * JD-Core Version:    0.6.2
 */