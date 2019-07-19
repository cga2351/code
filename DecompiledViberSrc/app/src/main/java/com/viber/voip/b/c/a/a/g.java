package com.viber.voip.b.c.a.a;

import java.io.File;

public class g extends d
{
  b c;

  public g(b paramb)
  {
    this.c = paramb;
  }

  protected boolean a(File paramFile)
  {
    String str1 = paramFile.getName();
    String str2 = paramFile.getAbsolutePath();
    return (this.c.a(paramFile)) || ("..".equals(str1)) || (".".equals(str1)) || (str2.endsWith(".nomedia"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.a.g
 * JD-Core Version:    0.6.2
 */