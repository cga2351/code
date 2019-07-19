package com.viber.backup;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class b extends e
{
  private static final Logger c = ViberEnv.getLogger();
  private byte[] d = null;

  public b(Context paramContext)
  {
    super(paramContext, "default_keychain");
  }

  public void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }

  public String b()
  {
    return "default_keychain";
  }

  public void c()
  {
    if (this.d != null);
    try
    {
      super.a(this.d);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.b
 * JD-Core Version:    0.6.2
 */