package com.facebook.react.views.common;

import android.content.Context;
import android.content.ContextWrapper;
import javax.annotation.Nullable;

public class ContextUtils
{
  @Nullable
  public static <T> T findContextOfType(@Nullable Context paramContext, Class<? extends T> paramClass)
  {
    Context localContext;
    for (Object localObject = paramContext; ; localObject = localContext)
      if (!paramClass.isInstance(localObject))
      {
        if (!(localObject instanceof ContextWrapper))
          break;
        localContext = ((ContextWrapper)localObject).getBaseContext();
        if (localObject == localContext)
          localObject = null;
      }
      else
      {
        return localObject;
      }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.common.ContextUtils
 * JD-Core Version:    0.6.2
 */