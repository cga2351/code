package com.viber.voip.permissions;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import com.viber.common.dialogs.a.a;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.bq;

public abstract class h extends f
{
  @SafeVarargs
  public h(Context paramContext, Pair<Integer, m>[] paramArrayOfPair)
  {
    super(paramContext, paramArrayOfPair);
  }

  public void onPermissionsDenied(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, Object paramObject)
  {
    if (!paramBoolean);
    Context localContext;
    m localm;
    do
    {
      return;
      localContext = getContext();
      localm = (m)this.mDialogs.get(paramInt);
    }
    while ((localContext == null) || (localm == null));
    localm.b(localContext.getResources()).a(new ViberDialogHandlers.bq(paramInt)).a(localContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.h
 * JD-Core Version:    0.6.2
 */