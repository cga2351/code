package okhttp3;

import java.io.IOException;

public enum Protocol
{
  private final String protocol;

  static
  {
    HTTP_2 = new Protocol("HTTP_2", 3, "h2");
    QUIC = new Protocol("QUIC", 4, "quic");
    Protocol[] arrayOfProtocol = new Protocol[5];
    arrayOfProtocol[0] = HTTP_1_0;
    arrayOfProtocol[1] = HTTP_1_1;
    arrayOfProtocol[2] = SPDY_3;
    arrayOfProtocol[3] = HTTP_2;
    arrayOfProtocol[4] = QUIC;
  }

  private Protocol(String paramString)
  {
    this.protocol = paramString;
  }

  public static Protocol get(String paramString)
    throws IOException
  {
    if (paramString.equals(HTTP_1_0.protocol))
      return HTTP_1_0;
    if (paramString.equals(HTTP_1_1.protocol))
      return HTTP_1_1;
    if (paramString.equals(HTTP_2.protocol))
      return HTTP_2;
    if (paramString.equals(SPDY_3.protocol))
      return SPDY_3;
    if (paramString.equals(QUIC.protocol))
      return QUIC;
    throw new IOException("Unexpected protocol: " + paramString);
  }

  public String toString()
  {
    return this.protocol;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Protocol
 * JD-Core Version:    0.6.2
 */