package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="GetDefaultCountryResponse")
public final class n
{

  @Element(name="CountryIDDCode", required=false)
  private String a;

  @Element(name="CountryCode", required=false)
  private String b;

  @Element(name="CountryName", required=false)
  private String c;

  @Element(name="CountryLocalCode", required=false)
  private String d;

  @Element(name="MPS", required=false)
  private String e;

  @Element(name="Status", required=false)
  private String f;

  @Element(name="Message", required=false)
  private String g;

  @Element(name="Debug", required=false)
  private String h;

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    return this.f;
  }

  public String f()
  {
    return this.g;
  }

  public boolean g()
  {
    return "1".equals(this.h);
  }

  public String toString()
  {
    return "GetDefaultCountryResponse{countryIddCode='" + this.a + '\'' + ", countryCode='" + this.b + '\'' + ", countryName='" + this.c + '\'' + ", countryLocalCode='" + this.d + '\'' + ", mps='" + this.e + '\'' + ", status='" + this.f + '\'' + ", message='" + this.g + '\'' + ", debug='" + this.h + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.n
 * JD-Core Version:    0.6.2
 */