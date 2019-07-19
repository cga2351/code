package com.shopchat.library.mvp.models;

import android.graphics.Color;
import com.google.d.a.c;

public class ColorModel
{

  @c(a="alpha")
  private int alpha;

  @c(a="blue")
  private int blue;

  @c(a="green")
  private int green;

  @c(a="red")
  private int red;

  public int getColor()
  {
    return Color.rgb(this.red, this.green, this.blue);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ColorModel{");
    localStringBuilder.append("red=").append(this.red);
    localStringBuilder.append(", green=").append(this.green);
    localStringBuilder.append(", blue=").append(this.blue);
    localStringBuilder.append(", alpha=").append(this.alpha);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.models.ColorModel
 * JD-Core Version:    0.6.2
 */