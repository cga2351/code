package com.viber.voip.banner.datatype;

public class TextBannerItem extends BannerItem
{
  Alignment alignment;
  String color;
  Float opacity;
  private int paddingTop;
  String text;

  public Alignment getAlignment()
  {
    return this.alignment;
  }

  public String getColor()
  {
    return this.color;
  }

  public Float getOpacity()
  {
    return this.opacity;
  }

  public int getPaddingTop()
  {
    return this.paddingTop;
  }

  public String getText()
  {
    return this.text;
  }

  public BannerItem.Type getType()
  {
    return BannerItem.Type.TEXT;
  }

  public void setPaddingTop(int paramInt)
  {
    this.paddingTop = paramInt;
  }

  public void setText(String paramString)
  {
    this.text = paramString;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = getType();
    arrayOfObject[1] = getText();
    arrayOfObject[2] = getAlignment();
    arrayOfObject[3] = getColor();
    arrayOfObject[4] = getOpacity();
    return String.format("[%s, text = %s, alignment = %s, color = %s, opacity = %s]", arrayOfObject);
  }

  public static enum Alignment
  {
    private String name;

    static
    {
      CENTER = new Alignment("CENTER", 1, "center");
      RIGHT = new Alignment("RIGHT", 2, "right");
      Alignment[] arrayOfAlignment = new Alignment[3];
      arrayOfAlignment[0] = LEFT;
      arrayOfAlignment[1] = CENTER;
      arrayOfAlignment[2] = RIGHT;
    }

    private Alignment(String paramString)
    {
      this.name = paramString;
    }

    public static Alignment fromName(String paramString)
    {
      for (Alignment localAlignment : values())
        if (localAlignment.name.equalsIgnoreCase(paramString))
          return localAlignment;
      return LEFT;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.TextBannerItem
 * JD-Core Version:    0.6.2
 */