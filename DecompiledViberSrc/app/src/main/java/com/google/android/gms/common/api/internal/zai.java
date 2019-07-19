package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

public final class zai<O extends Api.ApiOptions>
{
  private final Api<O> mApi;
  private final O zabh;
  private final boolean zact;
  private final int zacu;

  private zai(Api<O> paramApi)
  {
    this.zact = true;
    this.mApi = paramApi;
    this.zabh = null;
    this.zacu = System.identityHashCode(this);
  }

  private zai(Api<O> paramApi, O paramO)
  {
    this.zact = false;
    this.mApi = paramApi;
    this.zabh = paramO;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.mApi;
    arrayOfObject[1] = this.zabh;
    this.zacu = Objects.hashCode(arrayOfObject);
  }

  public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> paramApi)
  {
    return new zai(paramApi);
  }

  public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> paramApi, O paramO)
  {
    return new zai(paramApi, paramO);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zai localzai;
    do
    {
      return true;
      if (!(paramObject instanceof zai))
        return false;
      localzai = (zai)paramObject;
    }
    while ((!this.zact) && (!localzai.zact) && (Objects.equal(this.mApi, localzai.mApi)) && (Objects.equal(this.zabh, localzai.zabh)));
    return false;
  }

  public final int hashCode()
  {
    return this.zacu;
  }

  public final String zan()
  {
    return this.mApi.getName();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zai
 * JD-Core Version:    0.6.2
 */