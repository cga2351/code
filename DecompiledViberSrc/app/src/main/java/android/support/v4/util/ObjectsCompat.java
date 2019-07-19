package android.support.v4.util;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Objects;

public class ObjectsCompat
{
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return Objects.equals(paramObject1, paramObject2);
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static int hash(Object[] paramArrayOfObject)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return Objects.hash(paramArrayOfObject);
    return Arrays.hashCode(paramArrayOfObject);
  }

  public static int hashCode(Object paramObject)
  {
    if (paramObject != null)
      return paramObject.hashCode();
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.util.ObjectsCompat
 * JD-Core Version:    0.6.2
 */