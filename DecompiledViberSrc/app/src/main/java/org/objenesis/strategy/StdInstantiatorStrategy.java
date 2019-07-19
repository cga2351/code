package org.objenesis.strategy;

import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.android.Android10Instantiator;
import org.objenesis.instantiator.android.Android17Instantiator;
import org.objenesis.instantiator.android.Android18Instantiator;
import org.objenesis.instantiator.gcj.GCJInstantiator;
import org.objenesis.instantiator.jrockit.JRockitLegacyInstantiator;
import org.objenesis.instantiator.perc.PercInstantiator;
import org.objenesis.instantiator.sun.SunReflectionFactoryInstantiator;
import org.objenesis.instantiator.sun.UnsafeFactoryInstantiator;

public class StdInstantiatorStrategy extends BaseInstantiatorStrategy
{
  public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> paramClass)
  {
    if ((PlatformDescription.isThisJVM("Java HotSpot")) || (PlatformDescription.isThisJVM("OpenJDK")))
      return new SunReflectionFactoryInstantiator(paramClass);
    if (PlatformDescription.isThisJVM("BEA"))
    {
      if ((PlatformDescription.VM_VERSION.startsWith("1.4")) && (!PlatformDescription.VENDOR_VERSION.startsWith("R")) && ((PlatformDescription.VM_INFO == null) || (!PlatformDescription.VM_INFO.startsWith("R25.1")) || (!PlatformDescription.VM_INFO.startsWith("R25.2"))))
        return new JRockitLegacyInstantiator(paramClass);
      return new SunReflectionFactoryInstantiator(paramClass);
    }
    if (PlatformDescription.isThisJVM("Dalvik"))
    {
      if (PlatformDescription.ANDROID_VERSION <= 10)
        return new Android10Instantiator(paramClass);
      if (PlatformDescription.ANDROID_VERSION <= 17)
        return new Android17Instantiator(paramClass);
      return new Android18Instantiator(paramClass);
    }
    if (PlatformDescription.isThisJVM("GNU libgcj"))
      return new GCJInstantiator(paramClass);
    if (PlatformDescription.isThisJVM("PERC"))
      return new PercInstantiator(paramClass);
    return new UnsafeFactoryInstantiator(paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.strategy.StdInstantiatorStrategy
 * JD-Core Version:    0.6.2
 */