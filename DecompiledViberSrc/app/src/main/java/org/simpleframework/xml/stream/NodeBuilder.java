package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

public final class NodeBuilder
{
  private static Provider PROVIDER = ProviderFactory.getInstance();

  public static InputNode read(InputStream paramInputStream)
    throws Exception
  {
    return read(PROVIDER.provide(paramInputStream));
  }

  public static InputNode read(Reader paramReader)
    throws Exception
  {
    return read(PROVIDER.provide(paramReader));
  }

  private static InputNode read(EventReader paramEventReader)
    throws Exception
  {
    return new NodeReader(paramEventReader).readRoot();
  }

  public static OutputNode write(Writer paramWriter)
    throws Exception
  {
    return write(paramWriter, new Format());
  }

  public static OutputNode write(Writer paramWriter, Format paramFormat)
    throws Exception
  {
    return new NodeWriter(paramWriter, paramFormat).writeRoot();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeBuilder
 * JD-Core Version:    0.6.2
 */