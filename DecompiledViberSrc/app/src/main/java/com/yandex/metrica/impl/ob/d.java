package com.yandex.metrica.impl.ob;

import java.io.IOException;

public class d extends IOException
{
  private static final long serialVersionUID = -1616151763072450476L;

  public d(String paramString)
  {
    super(paramString);
  }

  static d a()
  {
    return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }

  static d b()
  {
    return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }

  static d c()
  {
    return new d("CodedInputStream encountered a malformed varint.");
  }

  static d d()
  {
    return new d("Protocol message contained an invalid tag (zero).");
  }

  static d e()
  {
    return new d("Protocol message end-group tag did not match expected tag.");
  }

  static d f()
  {
    return new d("Protocol message tag had invalid wire type.");
  }

  static d g()
  {
    return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.d
 * JD-Core Version:    0.6.2
 */