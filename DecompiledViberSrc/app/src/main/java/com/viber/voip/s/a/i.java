package com.viber.voip.s.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.s.a;
import com.viber.voip.util.a.e;
import com.viber.voip.util.a.f;
import java.util.Set;

public class i extends k
{
  private static final Logger d = ViberEnv.getLogger();

  private static String[] a(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[-1 + paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 1, arrayOfString, 0, -1 + paramArrayOfString.length);
    return arrayOfString;
  }

  public Cursor a(b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    Set localSet = f.a(ViberApplication.getApplication(), paramArrayOfString2[0], e.m(paramArrayOfString2[0]));
    if (localSet.size() == 0);
    for (String str = String.format(paramString1, new Object[] { "0" }); ; str = String.format(paramString1, new Object[] { a.e(localSet) }))
      return b(paramb, paramArrayOfString1, " AND " + str, a(paramArrayOfString2), paramString2, paramString3, paramString4);
  }

  protected String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" ORDER BY ");
    if (!TextUtils.isEmpty(paramString));
    for (String str = paramString + ", "; ; str = "")
      return str + a;
  }

  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = a.d(paramArrayOfString);
    StringBuilder localStringBuilder = new StringBuilder(1250);
    localStringBuilder.append(String.format(b, new Object[] { str, paramString1 })).append(a(paramString4));
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.i
 * JD-Core Version:    0.6.2
 */