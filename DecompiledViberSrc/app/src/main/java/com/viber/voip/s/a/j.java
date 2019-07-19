package com.viber.voip.s.a;

import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;

public class j extends i
{
  private static final Logger d = ViberEnv.getLogger();

  public Cursor a(b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    if (!da.a(paramString1));
    for (String str = " AND (" + paramString1 + ")"; ; str = paramString1)
      return b(paramb, paramArrayOfString1, str, paramArrayOfString2, paramString2, paramString3, paramString4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.j
 * JD-Core Version:    0.6.2
 */