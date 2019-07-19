package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="ActivateChangePhoneNumberRequest")
public final class a
{

  @Element(name="UDID", required=false)
  private String a;

  @Element(name="ActivationCode", required=false)
  private String b;

  @Element(name="System", required=false)
  private String c;

  public a(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }

  public String toString()
  {
    return "ActivateChangePhoneNumberRequest{udid='" + this.a + '\'' + ", activationCode='" + this.b + '\'' + ", system='" + this.c + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.a
 * JD-Core Version:    0.6.2
 */