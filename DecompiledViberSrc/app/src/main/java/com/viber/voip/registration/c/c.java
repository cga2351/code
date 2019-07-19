package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="ActivateUserRequest")
public final class c
{

  @Element(name="UDID", required=false)
  private String a;

  @Element(name="ActivationCode", required=false)
  private String b;

  @Element(name="ProtocolVersion", required=false)
  private String c;

  @Element(name="Language", required=false)
  private String d;

  @Element(name="System", required=false)
  private String e;

  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }

  public String toString()
  {
    return "ActivateUserRequest{udid='" + this.a + '\'' + ", activationCode='" + this.b + '\'' + ", protocolVersion='" + this.c + '\'' + ", language='" + this.d + '\'' + ", system='" + this.e + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.c
 * JD-Core Version:    0.6.2
 */