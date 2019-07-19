package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.text.TextUtils;
import com.google.d.a.c;

public enum a
{
  private final String mTypeName;

  static
  {
    CENTER = new a("CENTER", 1, "center");
    RIGHT = new a("RIGHT", 2, "right");
    a[] arrayOfa = new a[3];
    arrayOfa[0] = LEFT;
    arrayOfa[1] = CENTER;
    arrayOfa[2] = RIGHT;
  }

  private a(String paramString)
  {
    this.mTypeName = paramString;
  }

  public static a fromName(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return null;
      for (a locala : values())
        if (locala.mTypeName.equalsIgnoreCase(paramString))
          return locala;
    }
  }

  public static a getDefault()
  {
    return CENTER;
  }

  public String getTypeName()
  {
    return this.mTypeName;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.a
 * JD-Core Version:    0.6.2
 */