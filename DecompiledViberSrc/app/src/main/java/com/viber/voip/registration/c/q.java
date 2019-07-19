package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="RegisterUserRequest")
public final class q
{

  @Element(name="IMEI", required=false)
  private String A;

  @Element(name="BT_MAC_ADDRESS", required=false)
  private String B;

  @Element(name="ReRegisterState", required=false)
  private String C;

  @Element(name="Reinstall", required=false)
  private a D;

  @Element(name="DebugInfo", required=false)
  private String E;

  @Element(name="PhoneNumber", required=false)
  private String a;

  @Element(name="PushToken", required=false)
  private String b;

  @Element(name="CountryIDDCode", required=false)
  private String c;

  @Element(name="UDID", required=false)
  private String d;

  @Element(name="DeviceType", required=false)
  private String e;

  @Element(name="Device", required=false)
  private String f;

  @Element(name="DeviceManuf", required=false)
  private String g;

  @Element(name="SystemVersion", required=false)
  private String h;

  @Element(name="System", required=false)
  private String i;

  @Element(name="Language", required=false)
  private String j;

  @Element(name="ViberVersion", required=false)
  private String k;

  @Element(name="CC", required=false)
  private String l;

  @Element(name="MCC", required=false)
  private String m;

  @Element(name="MNC", required=false)
  private String n;

  @Element(name="VoIP", required=false)
  private String o;

  @Element(name="MCCSim", required=false)
  private String p;

  @Element(name="MNCSim", required=false)
  private String q;

  @Element(name="MCCNetwork", required=false)
  private String r;

  @Element(name="MNCNetwork", required=false)
  private String s;

  @Element(name="IMSI", required=false)
  private String t;

  @Element(name="SixDigitsCode", required=false)
  private String u;

  @Element(name="SecureMessaging", required=false)
  private String v;

  @Element(name="SecureHash", required=false)
  private String w;

  @Element(name="NoHangup", required=false)
  private String x;

  @Element(name="ANDROID_ID", required=false)
  private String y;

  @Element(name="WIFI_MAC_ADDRESS", required=false)
  private String z;

  public q(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, a parama, String paramString30)
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
    this.y = paramString25;
    this.z = paramString26;
    this.A = paramString27;
    this.B = paramString28;
    this.C = paramString29;
    this.D = parama;
    this.E = paramString30;
  }

  public String toString()
  {
    return "RegisterUserRequest{phoneNumber='" + this.a + '\'' + ", pushToken='" + this.b + '\'' + ", countryIDDCode='" + this.c + '\'' + ", udid='" + this.d + '\'' + ", deviceType='" + this.e + '\'' + ", device='" + this.f + '\'' + ", deviceManufacturer='" + this.g + '\'' + ", systemVersion='" + this.h + '\'' + ", system='" + this.i + '\'' + ", language='" + this.j + '\'' + ", viberVersion='" + this.k + '\'' + ", cc='" + this.l + '\'' + ", mcc='" + this.m + '\'' + ", mnc='" + this.n + '\'' + ", voip='" + this.o + '\'' + ", mccSim='" + this.p + '\'' + ", mncSim='" + this.q + '\'' + ", mccNetwork='" + this.r + '\'' + ", mncNetwork='" + this.s + '\'' + ", imsi='" + this.t + '\'' + ", sixDigitsCode='" + this.u + '\'' + ", secureMessaging='" + this.v + '\'' + ", secureHash='" + this.w + '\'' + ", noHangup='" + this.x + '\'' + ", androidId='" + this.y + '\'' + ", wifiMacAddress='" + this.z + '\'' + ", imei='" + this.A + '\'' + ", btMacAddress='" + this.B + '\'' + ", reRegisterState='" + this.C + '\'' + ", reinstall=" + this.D + ", debugInfo='" + this.E + '\'' + '}';
  }

  public static class a
  {

    @Element(name="Timestamp", required=false)
    private String a;

    @Element(name="SignatureNPT", required=false)
    private String b;

    @Element(name="OldUDID", required=false)
    private String c;

    public a(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
    }

    public String toString()
    {
      return "Reinstall{timestamp='" + this.a + '\'' + ", signatureNpt='" + this.b + '\'' + ", oldUdid='" + this.c + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.q
 * JD-Core Version:    0.6.2
 */