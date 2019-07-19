package com.mopub.common.factories;

import com.mopub.common.util.Reflection.MethodBuilder;

public class MethodBuilderFactory
{
  protected static MethodBuilderFactory a = new MethodBuilderFactory();

  public static Reflection.MethodBuilder create(Object paramObject, String paramString)
  {
    return a.a(paramObject, paramString);
  }

  @Deprecated
  public static void setInstance(MethodBuilderFactory paramMethodBuilderFactory)
  {
    a = paramMethodBuilderFactory;
  }

  protected Reflection.MethodBuilder a(Object paramObject, String paramString)
  {
    return new Reflection.MethodBuilder(paramObject, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.factories.MethodBuilderFactory
 * JD-Core Version:    0.6.2
 */