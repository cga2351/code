package org.simpleframework.xml.core;

import java.lang.reflect.Method;
import java.util.Map;

class Function
{
  private final boolean contextual;
  private final Method method;

  public Function(Method paramMethod)
  {
    this(paramMethod, false);
  }

  public Function(Method paramMethod, boolean paramBoolean)
  {
    this.contextual = paramBoolean;
    this.method = paramMethod;
  }

  public Object call(Context paramContext, Object paramObject)
    throws Exception
  {
    if (paramObject != null)
    {
      Map localMap = paramContext.getSession().getMap();
      if (this.contextual)
        return this.method.invoke(paramObject, new Object[] { localMap });
      return this.method.invoke(paramObject, new Object[0]);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Function
 * JD-Core Version:    0.6.2
 */