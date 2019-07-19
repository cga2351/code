package com.viber.backup;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.p;
import com.viber.voip.registration.s;

public class e extends c
{
  private static final Logger c = ViberEnv.getLogger();

  public e(Context paramContext, String paramString)
  {
    super(paramString, p.a(paramContext));
  }

  public void a(byte[] paramArrayOfByte)
  {
    super.a(paramArrayOfByte);
    s.a(s.c);
  }

  public byte[] a()
  {
    byte[] arrayOfByte = super.a();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0));
    return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.e
 * JD-Core Version:    0.6.2
 */