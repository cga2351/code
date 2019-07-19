package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="DeactivateUserRequest")
public final class k
{

  @Element(name="PhoneNumber", required=false)
  private String a;

  @Element(name="CountryIDDCode", required=false)
  private String b;

  @Element(name="UDID", required=false)
  private String c;

  @Element(name="DeactivateUDID", required=false)
  private String d;

  @Element(name="System", required=false)
  private String e;

  @Element(name="DeactivateSystemID", required=false)
  private String f;

  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
  }

  public String toString()
  {
    return "DeactivateUserRequest{phoneNumber='" + this.a + '\'' + ", countryIddCode='" + this.b + '\'' + ", udid='" + this.c + '\'' + ", deactivateUdid='" + this.d + '\'' + ", system='" + this.e + '\'' + ", deactivateSystemId='" + this.f + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.k
 * JD-Core Version:    0.6.2
 */