package com.viber.voip.messages.orm.entity.json;

import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.dimen;

public enum TextSize
{
  final boolean mIsLight;
  final int mTextSize;

  static
  {
    NORMAL = new TextSize("NORMAL", 1, R.dimen.formatted_text_normal, false);
    BIG = new TextSize("BIG", 2, R.dimen.formatted_text_big, false);
    HUGE = new TextSize("HUGE", 3, R.dimen.formatted_text_huge, false);
    TextSize[] arrayOfTextSize = new TextSize[4];
    arrayOfTextSize[0] = SMALL;
    arrayOfTextSize[1] = NORMAL;
    arrayOfTextSize[2] = BIG;
    arrayOfTextSize[3] = HUGE;
  }

  private TextSize(int paramInt, boolean paramBoolean)
  {
    this.mTextSize = paramInt;
    this.mIsLight = paramBoolean;
  }

  public static TextSize toEnum(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < values().length))
      return values()[paramInt];
    return null;
  }

  public float getSizeInPx(Context paramContext)
  {
    return paramContext.getResources().getDimension(this.mTextSize);
  }

  public boolean isLight()
  {
    return this.mIsLight;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.TextSize
 * JD-Core Version:    0.6.2
 */