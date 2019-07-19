package com.viber.voip.permissions;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import com.viber.common.dialogs.a.a;
import com.viber.common.permission.b;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.DHandlePermissions;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.bq;

public abstract class f extends b
{
  private static final Logger L = ViberEnv.getLogger();
  private final int[] mAcceptedRequestCodes;
  private final Context mContext;
  final SparseArray<m> mDialogs = new SparseArray();

  @SafeVarargs
  public f(Context paramContext, Pair<Integer, m>[] paramArrayOfPair)
  {
    this.mContext = paramContext;
    int i = paramArrayOfPair.length;
    this.mAcceptedRequestCodes = new int[i];
    for (int j = 0; j < i; j++)
    {
      Pair<Integer, m> localPair = paramArrayOfPair[j];
      this.mDialogs.put(((Integer)localPair.first).intValue(), localPair.second);
      this.mAcceptedRequestCodes[j] = ((Integer)localPair.first).intValue();
    }
  }

  public int[] acceptOnly()
  {
    return this.mAcceptedRequestCodes;
  }

  protected Context getContext()
  {
    return this.mContext;
  }

  protected m getDialog(int paramInt)
  {
    return (m)this.mDialogs.get(paramInt);
  }

  public void onPermissionsDenied(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, Object paramObject)
  {
    Context localContext = getContext();
    m localm = getDialog(paramInt);
    if ((localContext == null) || (localm == null))
      return;
    if (paramBoolean)
    {
      localm.b(localContext.getResources()).a(new ViberDialogHandlers.bq(paramInt)).a(localContext);
      return;
    }
    localm.a(localContext.getResources()).a(new ViberDialogHandlers.DHandlePermissions(paramInt, paramArrayOfString1, paramObject)).a(localContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.f
 * JD-Core Version:    0.6.2
 */