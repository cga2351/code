package okhttp3.internal.http2;

import f.f;
import okhttp3.internal.Util;

public final class Header
{
  public static final f PSEUDO_PREFIX = f.a(":");
  public static final f RESPONSE_STATUS = f.a(":status");
  public static final f TARGET_AUTHORITY = f.a(":authority");
  public static final f TARGET_METHOD = f.a(":method");
  public static final f TARGET_PATH = f.a(":path");
  public static final f TARGET_SCHEME = f.a(":scheme");
  final int hpackSize;
  public final f name;
  public final f value;

  public Header(f paramf1, f paramf2)
  {
    this.name = paramf1;
    this.value = paramf2;
    this.hpackSize = (32 + paramf1.h() + paramf2.h());
  }

  public Header(f paramf, String paramString)
  {
    this(paramf, f.a(paramString));
  }

  public Header(String paramString1, String paramString2)
  {
    this(f.a(paramString1), f.a(paramString2));
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Header;
    boolean bool2 = false;
    if (bool1)
    {
      Header localHeader = (Header)paramObject;
      boolean bool3 = this.name.equals(localHeader.name);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.value.equals(localHeader.value);
        bool2 = false;
        if (bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public int hashCode()
  {
    return 31 * (527 + this.name.hashCode()) + this.value.hashCode();
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.name.a();
    arrayOfObject[1] = this.value.a();
    return Util.format("%s: %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Header
 * JD-Core Version:    0.6.2
 */