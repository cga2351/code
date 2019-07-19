package com.facebook.react.views.art;

import com.facebook.react.bridge.ReadableArray;
import javax.annotation.Nullable;

class PropHelper
{
  static int toFloatArray(ReadableArray paramReadableArray, float[] paramArrayOfFloat)
  {
    if (paramReadableArray.size() > paramArrayOfFloat.length);
    for (int i = paramArrayOfFloat.length; ; i = paramReadableArray.size())
      for (int j = 0; j < i; j++)
        paramArrayOfFloat[j] = ((float)paramReadableArray.getDouble(j));
    return paramReadableArray.size();
  }

  @Nullable
  static float[] toFloatArray(@Nullable ReadableArray paramReadableArray)
  {
    if (paramReadableArray != null)
    {
      float[] arrayOfFloat = new float[paramReadableArray.size()];
      toFloatArray(paramReadableArray, arrayOfFloat);
      return arrayOfFloat;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.PropHelper
 * JD-Core Version:    0.6.2
 */