package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="ResendSMSRequest")
public final class u
{

  @Element(name="UDID", required=false)
  private String a;

  @Element(name="Device", required=false)
  private String b;

  @Element(name="System", required=false)
  private String c;

  @Element(name="Language", required=false)
  private String d;

  @Element(name="ViberVersion", required=false)
  private String e;

  @Element(name="MCCSim", required=false)
  private String f;

  @Element(name="MNCSim", required=false)
  private String g;

  @Element(name="MCCNetwork", required=false)
  private String h;

  @Element(name="MNCNetwork", required=false)
  private String i;

  @Element(name="IMSI", required=false)
  private String j;

  @Element(name="AttemptNumber", required=false)
  private String k;

  public u(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
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
  }

  public String toString()
  {
    return "ResendSmsRequest{udid='" + this.a + '\'' + ", device='" + this.b + '\'' + ", system='" + this.c + '\'' + ", language='" + this.d + '\'' + ", viberVersion='" + this.e + '\'' + ", mccSim='" + this.f + '\'' + ", mncSim='" + this.g + '\'' + ", mccNetwork='" + this.h + '\'' + ", mncNetwork='" + this.i + '\'' + ", imsi='" + this.j + '\'' + ", attemptNumber='" + this.k + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.u
 * JD-Core Version:    0.6.2
 */