package org.objectweb.asm;

final class Item
{
  int a;
  int b;
  int c;
  long d;
  String g;
  String h;
  String i;
  int j;
  Item k;

  Item()
  {
  }

  Item(int paramInt)
  {
    this.a = paramInt;
  }

  Item(int paramInt, Item paramItem)
  {
    this.a = paramInt;
    this.b = paramItem.b;
    this.c = paramItem.c;
    this.d = paramItem.d;
    this.g = paramItem.g;
    this.h = paramItem.h;
    this.i = paramItem.i;
    this.j = paramItem.j;
  }

  void a(double paramDouble)
  {
    this.b = 6;
    this.d = Double.doubleToRawLongBits(paramDouble);
    this.j = (0x7FFFFFFF & this.b + (int)paramDouble);
  }

  void a(float paramFloat)
  {
    this.b = 4;
    this.c = Float.floatToRawIntBits(paramFloat);
    this.j = (0x7FFFFFFF & this.b + (int)paramFloat);
  }

  void a(int paramInt)
  {
    this.b = 3;
    this.c = paramInt;
    this.j = (0x7FFFFFFF & paramInt + this.b);
  }

  void a(int paramInt1, int paramInt2)
  {
    this.b = 33;
    this.c = paramInt1;
    this.j = paramInt2;
  }

  void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramInt;
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
    switch (paramInt)
    {
    default:
      this.j = (0x7FFFFFFF & paramInt + paramString1.hashCode() * paramString2.hashCode() * paramString3.hashCode());
      return;
    case 7:
      this.c = 0;
    case 1:
    case 8:
    case 16:
    case 30:
      this.j = (0x7FFFFFFF & paramInt + paramString1.hashCode());
      return;
    case 12:
    }
    this.j = (0x7FFFFFFF & paramInt + paramString1.hashCode() * paramString2.hashCode());
  }

  void a(long paramLong)
  {
    this.b = 5;
    this.d = paramLong;
    this.j = (0x7FFFFFFF & this.b + (int)paramLong);
  }

  void a(String paramString1, String paramString2, int paramInt)
  {
    this.b = 18;
    this.d = paramInt;
    this.g = paramString1;
    this.h = paramString2;
    this.j = (0x7FFFFFFF & 18 + paramInt * this.g.hashCode() * this.h.hashCode());
  }

  boolean a(Item paramItem)
  {
    switch (this.b)
    {
    default:
      if ((!paramItem.g.equals(this.g)) || (!paramItem.h.equals(this.h)) || (!paramItem.i.equals(this.i)))
        break;
    case 1:
    case 7:
    case 8:
    case 16:
    case 30:
    case 5:
    case 6:
    case 32:
    case 3:
    case 4:
    case 31:
    case 12:
    case 18:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                return paramItem.g.equals(this.g);
              }
              while (paramItem.d == this.d);
              return false;
            }
            while (paramItem.c == this.c);
            return false;
          }
          while ((paramItem.c == this.c) && (paramItem.g.equals(this.g)));
          return false;
        }
        while ((paramItem.g.equals(this.g)) && (paramItem.h.equals(this.h)));
        return false;
      }
      while ((paramItem.d == this.d) && (paramItem.g.equals(this.g)) && (paramItem.h.equals(this.h)));
      return false;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.Item
 * JD-Core Version:    0.6.2
 */