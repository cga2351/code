package com.viber.voip.flatbuffers.c;

import android.graphics.Color;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Frame;

public class h extends a
{
  protected Integer a(String paramString)
    throws Exception
  {
    return Integer.valueOf(Color.parseColor(paramString));
  }

  protected String a(Integer paramInteger)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0xFFFFFF & paramInteger.intValue());
    return String.format("#%06X", arrayOfObject);
  }

  protected Integer b()
  {
    return Frame.DEFAULT_BORDER_COLOR;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.h
 * JD-Core Version:    0.6.2
 */