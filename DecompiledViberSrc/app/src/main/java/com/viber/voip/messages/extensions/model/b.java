package com.viber.voip.messages.extensions.model;

import com.viber.jni.slashkey.SlashKeyRequest;
import com.viber.voip.util.da;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private String a = "";
  private String b = "";
  private double c = 0.0D;
  private double d = 0.0D;
  private String e = "";
  private String f = Locale.US.getCountry();
  private String g = Locale.US.getLanguage();
  private Map<String, String> h = new HashMap();

  public static a a()
  {
    return new a(null);
  }

  public String b()
  {
    return this.a;
  }

  public SlashKeyRequest c()
  {
    SlashKeyRequest localSlashKeyRequest = new SlashKeyRequest();
    localSlashKeyRequest.setQuery(this.a);
    localSlashKeyRequest.setCategory(this.b);
    localSlashKeyRequest.setNear(this.e);
    localSlashKeyRequest.setLongitude(this.d);
    localSlashKeyRequest.setLatitude(this.c);
    localSlashKeyRequest.setCountry(this.f);
    localSlashKeyRequest.setLang(this.g);
    localSlashKeyRequest.setExtraParams(new HashMap(this.h));
    return localSlashKeyRequest;
  }

  public String toString()
  {
    return "KeyboardExtensionItemsRequest{mQuery='" + this.a + '\'' + ", mCategory='" + this.b + '\'' + ", mLatitude=" + this.c + ", mLongitude=" + this.d + ", mNear='" + this.e + '\'' + ", mCountry='" + this.f + '\'' + ", mLang='" + this.g + '\'' + ", mExtraParams=" + this.h + '}';
  }

  public static final class a
  {
    private final b a = new b(null);

    public a a(String paramString)
    {
      b.a(this.a, da.h(paramString));
      return this;
    }

    public a a(String paramString1, String paramString2)
    {
      b.a(this.a).put(paramString1, da.h(paramString2));
      return this;
    }

    public a a(Map<String, String> paramMap)
    {
      if (paramMap == null);
      while (true)
      {
        return this;
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          a((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }

    public b a()
    {
      return this.a;
    }

    public a b(String paramString)
    {
      b.b(this.a, da.b(paramString, Locale.US.getLanguage()));
      return this;
    }

    public a c(String paramString)
    {
      b.c(this.a, da.b(paramString, Locale.US.getCountry()));
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.model.b
 * JD-Core Version:    0.6.2
 */