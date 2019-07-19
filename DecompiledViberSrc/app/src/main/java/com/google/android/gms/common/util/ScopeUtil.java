package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

@KeepForSdk
public final class ScopeUtil
{
  @KeepForSdk
  public static String[] toScopeString(Set<Scope> paramSet)
  {
    Preconditions.checkNotNull(paramSet, "scopes can't be null.");
    Scope[] arrayOfScope = (Scope[])paramSet.toArray(new Scope[paramSet.size()]);
    Preconditions.checkNotNull(arrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[arrayOfScope.length];
    for (int i = 0; i < arrayOfScope.length; i++)
      arrayOfString[i] = arrayOfScope[i].getScopeUri();
    return arrayOfString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.ScopeUtil
 * JD-Core Version:    0.6.2
 */