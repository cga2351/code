package com.viber.voip.messages.adapters;

import android.app.Application;
import android.content.res.Resources;
import com.viber.voip.R.plurals;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.da;

public class m extends o
{
  private int c;

  public m(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.c = paramInt3;
  }

  public String a()
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    int i = this.b;
    int j = this.c;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = da.b(this.c);
    String str1 = localResources.getQuantityString(i, j, arrayOfObject1);
    int k = R.plurals.view_community_followers_likes_header;
    int m = this.a;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = da.b(this.a);
    String str2 = localResources.getQuantityString(k, m, arrayOfObject2);
    if ((this.c > 0) && (this.a == 0))
      return localResources.getString(R.string.liked_by, new Object[] { str1 });
    if ((this.c == 0) && (this.a > 0))
      return localResources.getString(R.string.liked_by, new Object[] { str2 });
    if ((this.c > 0) && (this.a > 0))
      return localResources.getString(R.string.liked_by_and, new Object[] { str1, str2 });
    return localResources.getString(R.string.have_no_likes);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.m
 * JD-Core Version:    0.6.2
 */