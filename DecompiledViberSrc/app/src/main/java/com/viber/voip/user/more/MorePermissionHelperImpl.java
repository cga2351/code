package com.viber.voip.user.more;

import android.support.v4.app.Fragment;
import android.util.Pair;
import android.util.SparseIntArray;
import com.viber.common.permission.c;
import com.viber.voip.permissions.e;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.m;
import dagger.a;

class MorePermissionHelperImpl
  implements MorePermissionHelper
{
  private final SparseIntArray mActionIds = new SparseIntArray();
  private final Fragment mFragment;
  private final k mPermissionConfig;
  private final com.viber.voip.g.b.b<com.viber.common.permission.b> mPermissionListener;
  private final a<c> mPermissionManager;
  private MorePermissionHelper.PermissionsGrantedListener mPermissionsGrantedListener;

  MorePermissionHelperImpl(Fragment paramFragment, a<c> parama, k paramk)
  {
    this.mFragment = paramFragment;
    this.mPermissionManager = parama;
    this.mPermissionConfig = paramk;
    this.mPermissionListener = createPermissionListener(paramFragment, paramk.a());
  }

  private com.viber.voip.g.b.b<com.viber.common.permission.b> createPermissionListener(final Fragment paramFragment, final Pair<Integer, m>[] paramArrayOfPair)
  {
    return new com.viber.voip.g.b.b()
    {
      protected com.viber.common.permission.b initInstance()
      {
        return new e(paramFragment, paramArrayOfPair)
        {
          public void onPermissionsGranted(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString, Object paramAnonymous2Object)
          {
            MorePermissionHelperImpl.this.notifyListener(MorePermissionHelperImpl.this.mActionIds.get(paramAnonymous2Int), paramAnonymous2ArrayOfString, paramAnonymous2Object);
          }
        };
      }
    };
  }

  private boolean hasPermissions(String[] paramArrayOfString)
  {
    return ((c)this.mPermissionManager.get()).a(paramArrayOfString);
  }

  private void notifyListener(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    if (this.mPermissionsGrantedListener != null)
      this.mPermissionsGrantedListener.onPermissionsGranted(paramInt, paramArrayOfString, paramObject);
  }

  private void requestPermissions(int paramInt, String[] paramArrayOfString)
  {
    int i = this.mPermissionConfig.a(paramInt);
    this.mActionIds.put(i, paramInt);
    ((c)this.mPermissionManager.get()).a(this.mFragment, i, paramArrayOfString);
  }

  public void registerPermissionsGrantedListener(MorePermissionHelper.PermissionsGrantedListener paramPermissionsGrantedListener)
  {
    this.mPermissionsGrantedListener = paramPermissionsGrantedListener;
    ((c)this.mPermissionManager.get()).a((com.viber.common.permission.b)this.mPermissionListener.get());
  }

  public void requestPermissionsWithCheck(int paramInt, String[] paramArrayOfString)
  {
    if (hasPermissions(paramArrayOfString))
    {
      notifyListener(paramInt, paramArrayOfString, null);
      return;
    }
    requestPermissions(paramInt, paramArrayOfString);
  }

  public void unregisterPermissionsGrantedListener()
  {
    this.mPermissionsGrantedListener = null;
    ((c)this.mPermissionManager.get()).b((com.viber.common.permission.b)this.mPermissionListener.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MorePermissionHelperImpl
 * JD-Core Version:    0.6.2
 */