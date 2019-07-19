package com.viber.voip.util.upload;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;

@Deprecated
class g
{
  private static final Logger a = ViberEnv.getLogger();

  static class a extends s.e
  {
    private static final String p = "https://" + ap.r(ap.d());

    a(String paramString1, String paramString2, String paramString3)
    {
      super(paramString2, paramString3, paramString1, null);
    }

    private static String b(String paramString)
    {
      return p + "/ptt_download?filetype=speex&id=" + paramString + "&xuav=" + i.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.g
 * JD-Core Version:    0.6.2
 */