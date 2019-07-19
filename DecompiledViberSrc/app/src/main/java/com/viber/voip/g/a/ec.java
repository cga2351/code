package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap.a;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.util.cj;
import com.viber.voip.util.http.OkHttpClientFactory;

public abstract class ec
{
  static PixieController a()
  {
    return ViberEnv.getPixieController();
  }

  static com.viber.voip.util.ap a(ViberApplication paramViberApplication)
  {
    return paramViberApplication.getDownloadValve();
  }

  static cj a(Context paramContext)
  {
    return cj.a(paramContext);
  }

  static OkHttpClientFactory b()
  {
    return ViberEnv.getOkHttpClientFactory();
  }

  static ap.a c()
  {
    return com.viber.voip.ap.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ec
 * JD-Core Version:    0.6.2
 */