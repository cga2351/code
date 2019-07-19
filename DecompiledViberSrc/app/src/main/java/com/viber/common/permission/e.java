package com.viber.common.permission;

import java.util.Arrays;
import java.util.List;

public class e
{
  final int a;
  final PermissionRequest b;
  final String[] c;
  final String[] d;

  e(int paramInt, PermissionRequest paramPermissionRequest, List<String> paramList1, List<String> paramList2)
  {
    this.a = paramInt;
    this.b = paramPermissionRequest;
    this.c = ((String[])paramList1.toArray(new String[paramList1.size()]));
    this.d = ((String[])paramList2.toArray(new String[paramList2.size()]));
  }

  public String toString()
  {
    return "PermissionResult{mStatus=" + this.a + ", mRequest=" + this.b + ", mGrantedPermissions=" + Arrays.toString(this.c) + ", mDeniedPermissions=" + Arrays.toString(this.d) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.permission.e
 * JD-Core Version:    0.6.2
 */