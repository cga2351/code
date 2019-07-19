package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.react.ReactContextManager;
import com.viber.voip.react.d;
import java.util.Map;
import javax.inject.Singleton;

public class ez
{
  @Singleton
  public static ReactContextManager a(Map<String, d> paramMap, Handler paramHandler)
  {
    return new ReactContextManager(paramMap, paramHandler);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ez
 * JD-Core Version:    0.6.2
 */