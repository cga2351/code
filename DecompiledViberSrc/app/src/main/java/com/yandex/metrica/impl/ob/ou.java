package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.yandex.metrica.impl.i;

public class ou
  implements oz
{
  private final ot a;

  ou(Context paramContext)
  {
    this(new os(paramContext));
  }

  ou(os paramos)
  {
    this(new ot("AES/CBC/PKCS5Padding", paramos.a(), paramos.b()));
  }

  ou(ot paramot)
  {
    this.a = paramot;
  }

  public oy a(i parami)
  {
    String str1 = parami.c();
    boolean bool = TextUtils.isEmpty(str1);
    Object localObject = null;
    if (!bool);
    try
    {
      byte[] arrayOfByte1 = str1.getBytes("UTF-8");
      byte[] arrayOfByte2 = this.a.a(arrayOfByte1);
      localObject = null;
      if (arrayOfByte2 != null)
      {
        String str2 = Base64.encodeToString(arrayOfByte2, 0);
        localObject = str2;
      }
      return new oy(parami.c(localObject), a());
    }
    catch (Exception localException)
    {
      while (true)
        localObject = null;
    }
  }

  public pb a()
  {
    return pb.c;
  }

  public byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject = new byte[0];
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0));
    try
    {
      byte[] arrayOfByte1 = Base64.decode(paramArrayOfByte, 0);
      byte[] arrayOfByte2 = this.a.b(arrayOfByte1);
      localObject = arrayOfByte2;
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ou
 * JD-Core Version:    0.6.2
 */