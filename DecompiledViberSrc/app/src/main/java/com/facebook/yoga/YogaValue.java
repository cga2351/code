package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class YogaValue
{
  static final YogaValue AUTO = new YogaValue((0.0F / 0.0F), YogaUnit.AUTO);
  static final YogaValue UNDEFINED = new YogaValue((0.0F / 0.0F), YogaUnit.UNDEFINED);
  static final YogaValue ZERO = new YogaValue(0.0F, YogaUnit.POINT);
  public final YogaUnit unit;
  public final float value;

  @DoNotStrip
  YogaValue(float paramFloat, int paramInt)
  {
    this(paramFloat, YogaUnit.fromInt(paramInt));
  }

  public YogaValue(float paramFloat, YogaUnit paramYogaUnit)
  {
    this.value = paramFloat;
    this.unit = paramYogaUnit;
  }

  public static YogaValue parse(String paramString)
  {
    if (paramString == null)
      return null;
    if ("undefined".equals(paramString))
      return UNDEFINED;
    if ("auto".equals(paramString))
      return AUTO;
    if (paramString.endsWith("%"))
      return new YogaValue(Float.parseFloat(paramString.substring(0, -1 + paramString.length())), YogaUnit.PERCENT);
    return new YogaValue(Float.parseFloat(paramString), YogaUnit.POINT);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof YogaValue;
    boolean bool2 = false;
    if (bool1)
    {
      YogaValue localYogaValue = (YogaValue)paramObject;
      YogaUnit localYogaUnit1 = this.unit;
      YogaUnit localYogaUnit2 = localYogaValue.unit;
      bool2 = false;
      if (localYogaUnit1 == localYogaUnit2)
        if ((this.unit != YogaUnit.UNDEFINED) && (this.unit != YogaUnit.AUTO))
        {
          int i = Float.compare(this.value, localYogaValue.value);
          bool2 = false;
          if (i != 0);
        }
        else
        {
          bool2 = true;
        }
    }
    return bool2;
  }

  public int hashCode()
  {
    return Float.floatToIntBits(this.value) + this.unit.intValue();
  }

  public String toString()
  {
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.unit.ordinal()])
    {
    default:
      throw new IllegalStateException();
    case 1:
      return "undefined";
    case 2:
      return Float.toString(this.value);
    case 3:
      return this.value + "%";
    case 4:
    }
    return "auto";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaValue
 * JD-Core Version:    0.6.2
 */