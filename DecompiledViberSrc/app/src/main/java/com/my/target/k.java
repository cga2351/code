package com.my.target;

import com.my.target.common.a.b;
import com.my.target.common.a.c;
import java.util.ArrayList;

public final class k<T extends h> extends i
{
  private final ArrayList<j> C = new ArrayList();
  private final ArrayList<Object> D = new ArrayList();
  private T E;
  private b F;
  private String G = "Close";
  private String H = "Replay";
  private String I = "Ad can be skipped after %ds";
  private boolean J = false;
  private boolean K = true;
  private boolean L = true;
  private boolean M = true;
  private boolean N = true;
  private boolean O = true;
  private boolean P = false;
  private boolean Q = false;
  private boolean R = false;
  private boolean S = true;
  private boolean T = true;
  private float U = 0.0F;
  private float V;
  private float W;

  public static k<c> D()
  {
    return E();
  }

  public static <T extends h> k<T> E()
  {
    return new k();
  }

  public T F()
  {
    return this.E;
  }

  public String G()
  {
    return this.G;
  }

  public String H()
  {
    return this.H;
  }

  public boolean I()
  {
    return this.J;
  }

  public boolean J()
  {
    return this.N;
  }

  public boolean K()
  {
    return this.K;
  }

  public boolean L()
  {
    return this.L;
  }

  public b M()
  {
    return this.F;
  }

  public boolean N()
  {
    return this.M;
  }

  public float O()
  {
    return this.U;
  }

  public boolean P()
  {
    return this.O;
  }

  public ArrayList<j> Q()
  {
    return new ArrayList(this.C);
  }

  public boolean R()
  {
    return this.S;
  }

  public boolean S()
  {
    return this.T;
  }

  public String T()
  {
    return this.I;
  }

  public void a(T paramT)
  {
    this.E = paramT;
  }

  public void a(j paramj)
  {
    this.C.add(paramj);
  }

  public void c(float paramFloat)
  {
    this.U = paramFloat;
  }

  public void c(b paramb)
  {
    this.F = paramb;
  }

  public void d(float paramFloat)
  {
    this.V = paramFloat;
  }

  public void d(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }

  public void e(float paramFloat)
  {
    this.W = paramFloat;
  }

  public void e(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }

  public void f(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }

  public void g(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }

  public void h(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }

  public int i()
  {
    if (this.E != null)
      return this.E.c();
    return 0;
  }

  public void i(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }

  public void j(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }

  public void k(boolean paramBoolean)
  {
    this.T = paramBoolean;
  }

  public void q(String paramString)
  {
    this.G = paramString;
  }

  public void r(String paramString)
  {
    this.H = paramString;
  }

  public void s(String paramString)
  {
    this.I = paramString;
  }

  public int u()
  {
    if (this.E != null)
      return this.E.b();
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.k
 * JD-Core Version:    0.6.2
 */