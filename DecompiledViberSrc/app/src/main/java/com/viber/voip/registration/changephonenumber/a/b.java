package com.viber.voip.registration.changephonenumber.a;

import com.viber.voip.registration.CountryCode;
import com.viber.voip.registration.c.i;

public class b
{
  private CountryCode a;
  private String b;
  private i c;
  private boolean d;

  public b(CountryCode paramCountryCode, String paramString, i parami, boolean paramBoolean)
  {
    this.a = paramCountryCode;
    this.b = paramString;
    this.c = parami;
    this.d = paramBoolean;
  }

  public CountryCode a()
  {
    return this.a;
  }

  public i b()
  {
    return this.c;
  }

  public boolean c()
  {
    return this.d;
  }

  public String toString()
  {
    return "ChangePhoneNumberAuthorizedEvent{mCountryCode=" + this.a + ", mPhoneNumber='" + this.b + '\'' + ", mResult=" + this.c + ", mIsChangeAccount=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.a.b
 * JD-Core Version:    0.6.2
 */