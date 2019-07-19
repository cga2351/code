package com.viber.voip.videoconvert;

public class a
{
  String a;
  String b;

  public a(String paramString)
  {
    if (paramString == null)
      paramString = "";
    String[] arrayOfString = paramString.trim().split(" ", 2);
    this.a = arrayOfString[0].toUpperCase();
    if (arrayOfString.length == 2)
    {
      this.b = arrayOfString[1];
      return;
    }
    this.b = "";
  }

  public boolean a(int paramInt)
  {
    return this.a.indexOf(paramInt) != -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.a
 * JD-Core Version:    0.6.2
 */