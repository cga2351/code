package c.b.a.a;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class h
  implements g
{
  private final String a;
  private final String b;
  private final String c;
  private final f d;
  private final ConcurrentHashMap<String, k.b> e = new ConcurrentHashMap();
  private final ConcurrentHashMap<Integer, k.b> f = new ConcurrentHashMap();

  h(e parame)
  {
    this("/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto", "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto", "/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto", parame);
  }

  h(String paramString1, String paramString2, String paramString3, e parame)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = new f(parame);
  }

  private boolean b(int paramInt)
  {
    List localList = (List)d.a().get(Integer.valueOf(paramInt));
    return (localList.size() == 1) && ("001".equals(localList.get(0)));
  }

  public k.b a(int paramInt)
  {
    if (!b(paramInt))
      return null;
    return this.d.a(Integer.valueOf(paramInt), this.f, this.a);
  }

  public k.b a(String paramString)
  {
    return this.d.a(paramString, this.e, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.h
 * JD-Core Version:    0.6.2
 */