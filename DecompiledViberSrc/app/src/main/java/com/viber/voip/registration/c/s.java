package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="ResendActivationCodeRequest")
public final class s
{

  @Element(name="UDID", required=false)
  private String a;

  @Element(name="System", required=false)
  private String b;

  @Element(name="CanonizedPhoneNumber", required=false)
  private String c;

  public s(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }

  public String toString()
  {
    return "ResendActivationCodeRequest{udid='" + this.a + '\'' + ", system='" + this.b + '\'' + ", canonizedPhoneNumber='" + this.c + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.s
 * JD-Core Version:    0.6.2
 */