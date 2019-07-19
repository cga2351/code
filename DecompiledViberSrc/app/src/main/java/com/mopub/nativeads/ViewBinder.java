package com.mopub.nativeads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ViewBinder
{
  final int a;
  final int b;
  final int c;
  final int d;
  final int e;
  final int f;
  final int g;
  final Map<String, Integer> h;

  private ViewBinder(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
    this.e = Builder.e(paramBuilder);
    this.f = Builder.f(paramBuilder);
    this.g = Builder.g(paramBuilder);
    this.h = Builder.h(paramBuilder);
  }

  public static final class Builder
  {
    private final int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Map<String, Integer> h = Collections.emptyMap();

    public Builder(int paramInt)
    {
      this.a = paramInt;
      this.h = new HashMap();
    }

    public final Builder addExtra(String paramString, int paramInt)
    {
      this.h.put(paramString, Integer.valueOf(paramInt));
      return this;
    }

    public final Builder addExtras(Map<String, Integer> paramMap)
    {
      this.h = new HashMap(paramMap);
      return this;
    }

    public final ViewBinder build()
    {
      return new ViewBinder(this, null);
    }

    public final Builder callToActionId(int paramInt)
    {
      this.d = paramInt;
      return this;
    }

    public final Builder iconImageId(int paramInt)
    {
      this.f = paramInt;
      return this;
    }

    public final Builder mainImageId(int paramInt)
    {
      this.e = paramInt;
      return this;
    }

    public final Builder privacyInformationIconImageId(int paramInt)
    {
      this.g = paramInt;
      return this;
    }

    public final Builder textId(int paramInt)
    {
      this.c = paramInt;
      return this;
    }

    public final Builder titleId(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.ViewBinder
 * JD-Core Version:    0.6.2
 */