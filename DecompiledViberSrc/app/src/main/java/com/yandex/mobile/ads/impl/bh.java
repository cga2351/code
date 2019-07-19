package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Environment;
import java.io.File;

final class bh
{
  static File a(Context paramContext, String paramString)
  {
    String str = Environment.getExternalStorageState();
    boolean bool1 = "mounted".equals(str);
    boolean bool2 = "mounted_ro".equals(str);
    boolean bool3 = Environment.isExternalStorageRemovable();
    int i;
    File localFile;
    if ((bool1) || ((!bool3) && (!bool2)))
    {
      i = 1;
      localFile = null;
      if (i != 0)
        localFile = paramContext.getExternalCacheDir();
      if (localFile == null)
        break label102;
    }
    while (true)
    {
      return new File(localFile.getPath() + File.separator + paramString);
      i = 0;
      break;
      label102: localFile = paramContext.getCacheDir();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bh
 * JD-Core Version:    0.6.2
 */