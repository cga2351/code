package android.support.design.widget;

import android.graphics.Outline;

public class CircularBorderDrawableLollipop extends CircularBorderDrawable
{
  public void getOutline(Outline paramOutline)
  {
    copyBounds(this.rect);
    paramOutline.setOval(this.rect);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.CircularBorderDrawableLollipop
 * JD-Core Version:    0.6.2
 */