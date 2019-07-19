package com.viber.voip.i;

import com.viber.common.permission.c;
import java.util.Arrays;
import java.util.List;

public class h extends b
{
  private final c a;
  private final String[] b;
  private final com.viber.common.permission.b c = new com.viber.common.permission.b()
  {
    private boolean a(String[] paramAnonymousArrayOfString)
    {
      List localList = Arrays.asList(h.a(h.this));
      int i = paramAnonymousArrayOfString.length;
      for (int j = 0; ; j++)
      {
        boolean bool = false;
        if (j < i)
        {
          if (localList.contains(paramAnonymousArrayOfString[j]))
            bool = true;
        }
        else
          return bool;
      }
    }

    public void onPermissionsDenied(int paramAnonymousInt, boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2, Object paramAnonymousObject)
    {
      if ((a(paramAnonymousArrayOfString1)) || (a(paramAnonymousArrayOfString2)))
        h.this.b();
    }

    public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
    {
      if (a(paramAnonymousArrayOfString))
        h.this.b();
    }
  };

  public h(c paramc, String[] paramArrayOfString)
  {
    this.a = paramc;
    this.b = paramArrayOfString;
    this.a.a(this.c);
  }

  public boolean a()
  {
    return this.a.a(this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.h
 * JD-Core Version:    0.6.2
 */