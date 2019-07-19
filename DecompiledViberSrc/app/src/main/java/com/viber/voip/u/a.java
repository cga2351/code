package com.viber.voip.u;

import android.annotation.SuppressLint;
import com.viber.common.b.e;
import com.viber.common.ui.b.b;
import com.viber.voip.flatbuffers.model.msginfo.IvmInfo;
import com.viber.voip.flatbuffers.model.msginfo.IvmInfo.a;
import com.viber.voip.settings.d.bl;

public class a
{
  public static b.b a()
  {
    if (c())
      return b.b.g;
    return b.b.f;
  }

  public static b.b a(IvmInfo paramIvmInfo)
  {
    if ((paramIvmInfo == null) || (paramIvmInfo.getShape() == null))
      return b.b.f;
    switch (1.a[paramIvmInfo.getShape().ordinal()])
    {
    default:
      return b.b.f;
    case 1:
    }
    return b.b.g;
  }

  @SuppressLint({"SwitchIntDef"})
  public static IvmInfo.a a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return IvmInfo.a.CIRCLE;
    case 2:
    }
    return IvmInfo.a.HEART;
  }

  public static int b()
  {
    if (c())
      return 2;
    return 1;
  }

  public static int b(IvmInfo paramIvmInfo)
  {
    if ((paramIvmInfo == null) || (paramIvmInfo.getShape() == null))
      return 1;
    switch (1.a[paramIvmInfo.getShape().ordinal()])
    {
    default:
      return 1;
    case 1:
    }
    return 2;
  }

  public static boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = d.bl.a.f();
    long l3 = d.bl.b.f();
    return (l2 <= l1) && (l1 < l3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.a
 * JD-Core Version:    0.6.2
 */