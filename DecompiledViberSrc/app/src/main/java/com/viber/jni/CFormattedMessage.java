package com.viber.jni;

public class CFormattedMessage
{
  public final boolean button;
  public final String caption;
  public final String img;
  public final String link;
  public final String tag;
  public final String text;
  public final int type;

  public CFormattedMessage(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    this.type = paramInt;
    this.link = paramString1;
    this.img = paramString2;
    this.text = paramString3;
    this.caption = paramString4;
    this.button = paramBoolean;
    this.tag = paramString5;
  }

  public String toString()
  {
    return "CFormattedMessage [type=" + this.type + ", link=" + this.link + ", img=" + this.img + ", text=" + this.text + ", caption=" + this.caption + ", button=" + this.button + ", tag=" + this.tag + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CFormattedMessage
 * JD-Core Version:    0.6.2
 */