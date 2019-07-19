package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="AuthorizeChangePhoneNumberRequest")
public final class f
{

  @Element(name="PhoneNumber", required=false)
  private String a;

  @Element(name="OldPhoneNumber", required=false)
  private String b;

  @Element(name="PushToken", required=false)
  private String c;

  @Element(name="CountryIDDCode", required=false)
  private String d;

  @Element(name="OldCountryIDDCode", required=false)
  private String e;

  @Element(name="Mid", required=false)
  private String f;

  @Element(name="UDID", required=false)
  private String g;

  @Element(name="DeviceType", required=false)
  private String h;

  @Element(name="DeviceManuf", required=false)
  private String i;

  @Element(name="SystemVersion", required=false)
  private String j;

  @Element(name="System", required=false)
  private String k;

  @Element(name="Language", required=false)
  private String l;

  @Element(name="ViberVersion", required=false)
  private String m;

  @Element(name="CC", required=false)
  private String n;

  @Element(name="CN", required=false)
  private String o;

  @Element(name="MCC", required=false)
  private String p;

  @Element(name="MNC", required=false)
  private String q;

  @Element(name="VoIP", required=false)
  private String r;

  @Element(name="MCCSim", required=false)
  private String s;

  @Element(name="MNCSim", required=false)
  private String t;

  @Element(name="MCCNetwork", required=false)
  private String u;

  @Element(name="MNCNetwork", required=false)
  private String v;

  @Element(name="IMSI", required=false)
  private String w;

  @Element(name="SixDigitsCode", required=false)
  private String x;

  @Element(name="NoHangup", required=false)
  private String y;

  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
    this.k = paramString11;
    this.l = paramString12;
    this.m = paramString13;
    this.n = paramString14;
    this.o = paramString15;
    this.p = paramString16;
    this.q = paramString17;
    this.r = paramString18;
    this.s = paramString19;
    this.t = paramString20;
    this.u = paramString21;
    this.v = paramString22;
    this.w = paramString23;
    this.x = paramString24;
    if (paramBoolean);
    for (String str = "0"; ; str = "1")
    {
      this.y = str;
      return;
    }
  }

  public String toString()
  {
    return "AuthorizeChangePhoneNumberRequest{phoneNumber='" + this.a + '\'' + ", oldPhoneNumber='" + this.b + '\'' + ", pushToken='" + this.c + '\'' + ", countryIddCode='" + this.d + '\'' + ", oldCountryIddCode='" + this.e + '\'' + ", mid='" + this.f + '\'' + ", udid='" + this.g + '\'' + ", deviceType='" + this.h + '\'' + ", deviceManufacturer='" + this.i + '\'' + ", systemVersion='" + this.j + '\'' + ", system='" + this.k + '\'' + ", language='" + this.l + '\'' + ", viberVersion='" + this.m + '\'' + ", cc='" + this.n + '\'' + ", cn='" + this.o + '\'' + ", mcc='" + this.p + '\'' + ", mnc='" + this.q + '\'' + ", voip='" + this.r + '\'' + ", mccSim='" + this.s + '\'' + ", mncSim='" + this.t + '\'' + ", mccNetwork='" + this.u + '\'' + ", mncNetwork='" + this.v + '\'' + ", imsi='" + this.w + '\'' + ", sixDigitsCode='" + this.x + '\'' + ", noHangup='" + this.y + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.f
 * JD-Core Version:    0.6.2
 */