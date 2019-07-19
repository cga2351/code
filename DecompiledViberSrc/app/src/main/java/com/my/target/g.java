package com.my.target;

public class g
{
  public static final g a = new g(4096);
  public static final g b = new g(64);
  public final boolean c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final boolean j;
  public final boolean k;
  public final boolean l;
  public final boolean m;
  public final boolean n;
  public final boolean o;
  private final int p;

  private g(int paramInt)
  {
    this.p = paramInt;
    int i2;
    int i3;
    label35: int i4;
    label51: int i5;
    label69: int i6;
    label87: int i7;
    label105: int i8;
    label123: int i9;
    label143: int i10;
    label163: int i11;
    label183: int i12;
    label203: int i13;
    if ((paramInt & 0x1) == i1)
    {
      i2 = i1;
      this.c = i2;
      if ((paramInt & 0x2) != 2)
        break label251;
      i3 = i1;
      this.d = i3;
      if ((paramInt & 0x4) != 4)
        break label257;
      i4 = i1;
      this.e = i4;
      if ((paramInt & 0x8) != 8)
        break label263;
      i5 = i1;
      this.f = i5;
      if ((paramInt & 0x10) != 16)
        break label269;
      i6 = i1;
      this.g = i6;
      if ((paramInt & 0x20) != 32)
        break label275;
      i7 = i1;
      this.h = i7;
      if ((paramInt & 0x40) != 64)
        break label281;
      i8 = i1;
      this.i = i8;
      if ((paramInt & 0x80) != 128)
        break label287;
      i9 = i1;
      this.j = i9;
      if ((paramInt & 0x100) != 256)
        break label293;
      i10 = i1;
      this.k = i10;
      if ((paramInt & 0x200) != 512)
        break label299;
      i11 = i1;
      this.l = i11;
      if ((paramInt & 0x400) != 1024)
        break label305;
      i12 = i1;
      this.m = i12;
      if ((paramInt & 0x800) != 2048)
        break label311;
      i13 = i1;
      label223: this.n = i13;
      if ((paramInt & 0x1000) != 4096)
        break label317;
    }
    while (true)
    {
      this.o = i1;
      return;
      i2 = 0;
      break;
      label251: i3 = 0;
      break label35;
      label257: i4 = 0;
      break label51;
      label263: i5 = 0;
      break label69;
      label269: i6 = 0;
      break label87;
      label275: i7 = 0;
      break label105;
      label281: i8 = 0;
      break label123;
      label287: i9 = 0;
      break label143;
      label293: i10 = 0;
      break label163;
      label299: i11 = 0;
      break label183;
      label305: i12 = 0;
      break label203;
      label311: i13 = 0;
      break label223;
      label317: i1 = 0;
    }
  }

  public static g a(int paramInt)
  {
    return new g(paramInt);
  }

  public int a()
  {
    return this.p;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.g
 * JD-Core Version:    0.6.2
 */