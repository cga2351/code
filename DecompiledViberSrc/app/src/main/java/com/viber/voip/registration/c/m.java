package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="GetDefaultCountryRequest")
public class m
{

  @Element(name="CarrierInfo", required=false)
  private a a;

  @Element(name="Debug", required=false)
  private String b;

  public m(a parama, String paramString)
  {
    this.a = parama;
    this.b = paramString;
  }

  public String toString()
  {
    return "GetDefaultCountryRequest{carrierInfo=" + this.a + ", debug='" + this.b + '\'' + '}';
  }

  public static class a
  {

    @Element(name="CC", required=false)
    private String a;

    @Element(name="CN", required=false)
    private String b;

    @Element(name="MCC", required=false)
    private String c;

    @Element(name="MNC", required=false)
    private String d;

    @Element(name="VoIP", required=false)
    private String e;

    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramString5;
    }

    public String toString()
    {
      return "CarrierInfo{cc='" + this.a + '\'' + ", cn='" + this.b + '\'' + ", mcc='" + this.c + '\'' + ", mnc='" + this.d + '\'' + ", voip='" + this.e + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.m
 * JD-Core Version:    0.6.2
 */