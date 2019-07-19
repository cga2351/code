package com.viber.voip.ads.a;

import com.appnexus.opensdk.AdView.GENDER;
import com.google.d.a.c;

public enum d
{
  static
  {
    MALE = new d("MALE", 1);
    FEMALE = new d("FEMALE", 2);
    d[] arrayOfd = new d[3];
    arrayOfd[0] = UNKNOWN;
    arrayOfd[1] = MALE;
    arrayOfd[2] = FEMALE;
  }

  public static d fromId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= values().length))
      return UNKNOWN;
    return values()[paramInt];
  }

  public int toAdmobGender()
  {
    switch (1.a[ordinal()])
    {
    default:
      return 0;
    case 1:
      return 1;
    case 2:
    }
    return 2;
  }

  public AdView.GENDER toAppNexusGender()
  {
    switch (1.a[ordinal()])
    {
    default:
      return AdView.GENDER.UNKNOWN;
    case 1:
      return AdView.GENDER.MALE;
    case 2:
    }
    return AdView.GENDER.FEMALE;
  }

  public String toMopubTargetingParamGender()
  {
    switch (1.a[ordinal()])
    {
    default:
      return "";
    case 1:
      return "m_gender:m";
    case 2:
    }
    return "m_gender:f";
  }

  public String toTargetingParamGender()
  {
    switch (1.a[ordinal()])
    {
    default:
      return "U";
    case 1:
      return "M";
    case 2:
    }
    return "F";
  }

  public String toYandexTargetingParamGender()
  {
    switch (1.a[ordinal()])
    {
    default:
      return "UNKNOWN";
    case 1:
      return "male";
    case 2:
    }
    return "female";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.a.d
 * JD-Core Version:    0.6.2
 */