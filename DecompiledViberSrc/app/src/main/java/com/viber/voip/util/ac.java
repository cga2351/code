package com.viber.voip.util;

import android.content.res.Resources;
import com.viber.voip.R.plurals;
import javax.inject.Inject;

public class ac
{
  private final Resources a;

  @Inject
  public ac(Resources paramResources)
  {
    this.a = paramResources;
  }

  public String a(int paramInt1, int paramInt2)
  {
    int i;
    switch (paramInt1)
    {
    default:
      return "";
    case 1:
      i = R.plurals.n_days;
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      Resources localResources = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt2);
      return localResources.getQuantityString(i, paramInt2, arrayOfObject);
      i = R.plurals.n_weeks;
      continue;
      i = R.plurals.n_months;
      continue;
      i = R.plurals.n_years;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ac
 * JD-Core Version:    0.6.2
 */