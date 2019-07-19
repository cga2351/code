package com.viber.voip.messages.adapters;

import android.content.Context;
import com.viber.voip.ViberApplication;

public class s extends n
{
  public s(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }

  public String a()
  {
    String str = ViberApplication.getLocalizedContext().getString(this.c);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(this.a);
    arrayOfObject[2] = Integer.valueOf(this.b);
    return String.format("%s (%s/%s)", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.s
 * JD-Core Version:    0.6.2
 */