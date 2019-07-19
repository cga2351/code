package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public final class Objects
{
  private Objects()
  {
    throw new AssertionError("Uninstantiable");
  }

  @KeepForSdk
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  @KeepForSdk
  public static int hashCode(Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }

  @KeepForSdk
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(paramObject, null);
  }

  @KeepForSdk
  public static final class ToStringHelper
  {
    private final List<String> zzer;
    private final Object zzes;

    private ToStringHelper(Object paramObject)
    {
      this.zzes = Preconditions.checkNotNull(paramObject);
      this.zzer = new ArrayList();
    }

    @KeepForSdk
    public final ToStringHelper add(String paramString, Object paramObject)
    {
      List localList = this.zzer;
      String str1 = (String)Preconditions.checkNotNull(paramString);
      String str2 = String.valueOf(paramObject);
      localList.add(1 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + "=" + str2);
      return this;
    }

    @KeepForSdk
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.zzes.getClass().getSimpleName()).append('{');
      int i = this.zzer.size();
      for (int j = 0; j < i; j++)
      {
        localStringBuilder.append((String)this.zzer.get(j));
        if (j < i - 1)
          localStringBuilder.append(", ");
      }
      return '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.Objects
 * JD-Core Version:    0.6.2
 */