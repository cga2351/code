package com.viber.voip.util;

import android.os.Build;

public enum br
{
  private final String j;

  static
  {
    br[] arrayOfbr = new br[9];
    arrayOfbr[0] = a;
    arrayOfbr[1] = b;
    arrayOfbr[2] = c;
    arrayOfbr[3] = d;
    arrayOfbr[4] = e;
    arrayOfbr[5] = f;
    arrayOfbr[6] = g;
    arrayOfbr[7] = h;
    arrayOfbr[8] = i;
  }

  private br(String paramString)
  {
    this.j = paramString;
  }

  public boolean a()
  {
    return Build.MANUFACTURER.equalsIgnoreCase(this.j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.br
 * JD-Core Version:    0.6.2
 */