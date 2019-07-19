package com.viber.voip.vln;

import com.viber.jni.cdr.ICdrController;
import com.viber.voip.react.d;
import dagger.a;
import dagger.b;
import java.util.Map;

public final class c
  implements b<VlnActivity>
{
  public static void a(VlnActivity paramVlnActivity, a<ICdrController> parama)
  {
    paramVlnActivity.e = parama;
  }

  public static void a(VlnActivity paramVlnActivity, Map<String, d> paramMap)
  {
    paramVlnActivity.d = paramMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.c
 * JD-Core Version:    0.6.2
 */