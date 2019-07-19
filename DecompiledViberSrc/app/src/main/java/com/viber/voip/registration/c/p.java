package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="GetRIDResponse")
public final class p extends j
{

  @Element(name="RID", required=false)
  private String a;

  public String a()
  {
    return this.a;
  }

  public String toString()
  {
    return "GetRIDResponse{status='" + this.g + '\'' + ", rid='" + this.a + '\'' + ", errorMessage='" + this.h + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.p
 * JD-Core Version:    0.6.2
 */