package com.viber.voip.s.a;

import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;

public abstract class ai
{
  protected final Logger c = ViberEnv.getLogger(getClass());

  public Cursor a(b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      Cursor localCursor = paramb.a(a(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4), paramArrayOfString2);
      return localCursor;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  protected abstract String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.ai
 * JD-Core Version:    0.6.2
 */