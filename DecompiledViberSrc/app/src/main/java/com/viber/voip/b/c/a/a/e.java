package com.viber.voip.b.c.a.a;

import java.io.File;

public class e extends d
{
  private b c;

  public e(b paramb)
  {
    this.c = paramb;
  }

  protected boolean a(File paramFile)
  {
    if (this.c.a(paramFile));
    String str;
    do
    {
      return true;
      str = paramFile.getName();
    }
    while ((str.equals("icon.png")) || (str.equals("color_icon.png")));
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.a.e
 * JD-Core Version:    0.6.2
 */