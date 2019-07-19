package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.text.TextUtils;
import com.google.d.a.c;

public enum b
{
  private final String mTypeName;

  static
  {
    MIDDLE = new b("MIDDLE", 1, "middle");
    BOTTOM = new b("BOTTOM", 2, "bottom");
    b[] arrayOfb = new b[3];
    arrayOfb[0] = TOP;
    arrayOfb[1] = MIDDLE;
    arrayOfb[2] = BOTTOM;
  }

  private b(String paramString)
  {
    this.mTypeName = paramString;
  }

  public static b fromName(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return null;
      for (b localb : values())
        if (localb.mTypeName.equalsIgnoreCase(paramString))
          return localb;
    }
  }

  public static b getDefault()
  {
    return MIDDLE;
  }

  public String getTypeName()
  {
    return this.mTypeName;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.b
 * JD-Core Version:    0.6.2
 */