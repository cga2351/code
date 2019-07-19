package com.google.android.exoplayer2.e.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.SparseArray;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final byte[] a = { 0, 7, 8, 15 };
  private static final byte[] b = { 0, 119, -120, -1 };
  private static final byte[] c = { 0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1 };
  private final Paint d = new Paint();
  private final Paint e;
  private final Canvas f;
  private final b g;
  private final a h;
  private final h i;
  private Bitmap j;

  public b(int paramInt1, int paramInt2)
  {
    this.d.setStyle(Paint.Style.FILL_AND_STROKE);
    this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.d.setPathEffect(null);
    this.e = new Paint();
    this.e.setStyle(Paint.Style.FILL);
    this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
    this.e.setPathEffect(null);
    this.f = new Canvas();
    this.g = new b(719, 575, 0, 719, 0, 575);
    this.h = new a(0, b(), c(), d());
    this.i = new h(paramInt1, paramInt2);
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt4 | (paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8);
  }

  private static int a(q paramq, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int i3;
    for (int k = 0; ; k = i3)
    {
      int m = paramq.c(2);
      int i2;
      int i4;
      if (m != 0)
      {
        i2 = 1;
        i3 = k;
        i4 = m;
      }
      while (true)
      {
        if ((i2 != 0) && (paramPaint != null))
        {
          if (paramArrayOfByte != null)
            i4 = paramArrayOfByte[i4];
          paramPaint.setColor(paramArrayOfInt[i4]);
          paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + i2, paramInt2 + 1, paramPaint);
        }
        paramInt1 += i2;
        if (i3 == 0)
          break;
        return paramInt1;
        if (paramq.e())
        {
          int i7 = 3 + paramq.c(3);
          int i8 = paramq.c(2);
          i2 = i7;
          i3 = k;
          i4 = i8;
        }
        else if (paramq.e())
        {
          i2 = 1;
          i3 = k;
          i4 = 0;
        }
        else
        {
          switch (paramq.c(2))
          {
          default:
            i3 = k;
            i4 = 0;
            i2 = 0;
            break;
          case 0:
            i3 = 1;
            i4 = 0;
            i2 = 0;
            break;
          case 1:
            i2 = 2;
            i3 = k;
            i4 = 0;
            break;
          case 2:
            int i5 = 12 + paramq.c(4);
            int i6 = paramq.c(2);
            i2 = i5;
            i3 = k;
            i4 = i6;
            break;
          case 3:
            int n = 29 + paramq.c(8);
            int i1 = paramq.c(2);
            i2 = n;
            i3 = k;
            i4 = i1;
          }
        }
      }
    }
  }

  private static b a(q paramq)
  {
    paramq.b(4);
    boolean bool = paramq.e();
    paramq.b(3);
    int k = paramq.c(16);
    int m = paramq.c(16);
    int i2;
    int i1;
    int i3;
    int n;
    if (bool)
    {
      i2 = paramq.c(16);
      i1 = paramq.c(16);
      i3 = paramq.c(16);
      n = paramq.c(16);
    }
    while (true)
    {
      return new b(k, m, i2, i1, i3, n);
      n = m;
      i1 = k;
      i2 = 0;
      i3 = 0;
    }
  }

  private static d a(q paramq, int paramInt)
  {
    int k = paramq.c(8);
    int m = paramq.c(4);
    int n = paramq.c(2);
    paramq.b(2);
    int i1 = paramInt - 2;
    SparseArray localSparseArray = new SparseArray();
    while (i1 > 0)
    {
      int i2 = paramq.c(8);
      paramq.b(8);
      int i3 = paramq.c(16);
      int i4 = paramq.c(16);
      i1 -= 6;
      localSparseArray.put(i2, new e(i3, i4));
    }
    return new d(k, m, n, localSparseArray);
  }

  private static void a(c paramc, a parama, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    int[] arrayOfInt;
    if (paramInt1 == 3)
      arrayOfInt = parama.d;
    while (true)
    {
      a(paramc.c, arrayOfInt, paramInt1, paramInt2, paramInt3, paramPaint, paramCanvas);
      a(paramc.d, arrayOfInt, paramInt1, paramInt2, paramInt3 + 1, paramPaint, paramCanvas);
      return;
      if (paramInt1 == 2)
        arrayOfInt = parama.c;
      else
        arrayOfInt = parama.b;
    }
  }

  private static void a(q paramq, h paramh)
  {
    int k = paramq.c(8);
    int m = paramq.c(16);
    int n = paramq.c(16);
    int i1 = n + paramq.c();
    if (n * 8 > paramq.a())
    {
      l.c("DvbParser", "Data field length exceeds limit");
      paramq.b(paramq.a());
      return;
    }
    switch (k)
    {
    default:
    case 20:
    case 16:
    case 17:
    case 18:
    case 19:
    }
    while (true)
    {
      paramq.d(i1 - paramq.c());
      return;
      if (m == paramh.a)
      {
        paramh.h = a(paramq);
        continue;
        if (m == paramh.a)
        {
          d locald2 = paramh.i;
          d locald3 = a(paramq, n);
          if (locald3.c != 0)
          {
            paramh.i = locald3;
            paramh.c.clear();
            paramh.d.clear();
            paramh.e.clear();
          }
          else if ((locald2 != null) && (locald2.b != locald3.b))
          {
            paramh.i = locald3;
            continue;
            d locald1 = paramh.i;
            if ((m == paramh.a) && (locald1 != null))
            {
              f localf = b(paramq, n);
              if (locald1.c == 0)
                localf.a((f)paramh.c.get(localf.a));
              paramh.c.put(localf.a, localf);
              continue;
              if (m == paramh.a)
              {
                a locala2 = c(paramq, n);
                paramh.d.put(locala2.a, locala2);
              }
              else if (m == paramh.b)
              {
                a locala1 = c(paramq, n);
                paramh.f.put(locala1.a, locala1);
                continue;
                if (m == paramh.a)
                {
                  c localc2 = b(paramq);
                  paramh.e.put(localc2.a, localc2);
                }
                else if (m == paramh.b)
                {
                  c localc1 = b(paramq);
                  paramh.g.put(localc1.a, localc1);
                }
              }
            }
          }
        }
      }
    }
  }

  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, Canvas paramCanvas)
  {
    q localq = new q(paramArrayOfByte);
    Object localObject1 = null;
    Object localObject2 = null;
    int k = paramInt3;
    int m = paramInt2;
    if (localq.a() != 0)
    {
      Object localObject3;
      Object localObject4;
      switch (localq.c(8))
      {
      default:
        localObject3 = localObject2;
        localObject4 = localObject1;
      case 16:
      case 17:
      case 18:
      case 32:
      case 33:
      case 34:
      case 240:
      }
      while (true)
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        Object localObject7;
        label138: Object localObject5;
        if (paramInt1 == 3)
          if (localObject2 == null)
          {
            localObject7 = b;
            localObject5 = localObject7;
          }
        while (true)
        {
          m = a(localq, paramArrayOfInt, localObject5, m, k, paramPaint, paramCanvas);
          localq.f();
          localObject3 = localObject2;
          localObject4 = localObject1;
          break;
          localObject7 = localObject2;
          break label138;
          if (paramInt1 == 2)
          {
            if (localObject1 == null);
            for (Object localObject6 = a; ; localObject6 = localObject1)
            {
              localObject5 = localObject6;
              break;
            }
          }
          localObject5 = null;
        }
        byte[] arrayOfByte2;
        if (paramInt1 == 3)
          if (0 == 0)
            arrayOfByte2 = c;
        label232: for (byte[] arrayOfByte1 = arrayOfByte2; ; arrayOfByte1 = null)
        {
          m = b(localq, paramArrayOfInt, arrayOfByte1, m, k, paramPaint, paramCanvas);
          localq.f();
          localObject3 = localObject2;
          localObject4 = localObject1;
          break;
          arrayOfByte2 = null;
          break label232;
        }
        m = c(localq, paramArrayOfInt, null, m, k, paramPaint, paramCanvas);
        localObject3 = localObject2;
        localObject4 = localObject1;
        continue;
        localObject4 = a(4, 4, localq);
        localObject3 = localObject2;
        continue;
        localObject3 = a(4, 8, localq);
        localObject4 = localObject1;
        continue;
        localObject3 = a(16, 8, localq);
        localObject4 = localObject1;
        continue;
        k += 2;
        localObject3 = localObject2;
        localObject4 = localObject1;
        m = paramInt2;
      }
    }
  }

  private static byte[] a(int paramInt1, int paramInt2, q paramq)
  {
    byte[] arrayOfByte = new byte[paramInt1];
    for (int k = 0; k < paramInt1; k++)
      arrayOfByte[k] = ((byte)paramq.c(paramInt2));
    return arrayOfByte;
  }

  private static int b(q paramq, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int i3;
    for (int k = 0; ; k = i3)
    {
      int m = paramq.c(4);
      int i2;
      int i4;
      if (m != 0)
      {
        i2 = 1;
        i3 = k;
        i4 = m;
      }
      while (true)
      {
        if ((i2 != 0) && (paramPaint != null))
        {
          if (paramArrayOfByte != null)
            i4 = paramArrayOfByte[i4];
          paramPaint.setColor(paramArrayOfInt[i4]);
          paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + i2, paramInt2 + 1, paramPaint);
        }
        paramInt1 += i2;
        if (i3 == 0)
          break;
        return paramInt1;
        if (!paramq.e())
        {
          int i9 = paramq.c(3);
          if (i9 != 0)
          {
            i2 = i9 + 2;
            i3 = k;
            i4 = 0;
          }
          else
          {
            i3 = 1;
            i4 = 0;
            i2 = 0;
          }
        }
        else if (!paramq.e())
        {
          int i7 = 4 + paramq.c(2);
          int i8 = paramq.c(4);
          i2 = i7;
          i3 = k;
          i4 = i8;
        }
        else
        {
          switch (paramq.c(2))
          {
          default:
            i3 = k;
            i4 = 0;
            i2 = 0;
            break;
          case 0:
            i2 = 1;
            i3 = k;
            i4 = 0;
            break;
          case 1:
            i2 = 2;
            i3 = k;
            i4 = 0;
            break;
          case 2:
            int i5 = 9 + paramq.c(4);
            int i6 = paramq.c(4);
            i2 = i5;
            i3 = k;
            i4 = i6;
            break;
          case 3:
            int n = 25 + paramq.c(8);
            int i1 = paramq.c(4);
            i2 = n;
            i3 = k;
            i4 = i1;
          }
        }
      }
    }
  }

  private static c b(q paramq)
  {
    Object localObject = null;
    int k = paramq.c(16);
    paramq.b(4);
    int m = paramq.c(2);
    boolean bool = paramq.e();
    paramq.b(1);
    byte[] arrayOfByte;
    if (m == 1)
    {
      paramq.b(16 * paramq.c(8));
      arrayOfByte = null;
    }
    while (true)
    {
      return new c(k, bool, arrayOfByte, (byte[])localObject);
      if (m == 0)
      {
        int n = paramq.c(16);
        int i1 = paramq.c(16);
        if (n > 0)
        {
          arrayOfByte = new byte[n];
          paramq.b(arrayOfByte, 0, n);
        }
        while (true)
        {
          if (i1 > 0)
          {
            localObject = new byte[i1];
            paramq.b((byte[])localObject, 0, i1);
            break;
          }
          localObject = arrayOfByte;
          break;
          arrayOfByte = null;
        }
      }
      localObject = null;
      arrayOfByte = null;
    }
  }

  private static f b(q paramq, int paramInt)
  {
    int k = paramq.c(8);
    paramq.b(4);
    boolean bool = paramq.e();
    paramq.b(3);
    int m = paramq.c(16);
    int n = paramq.c(16);
    int i1 = paramq.c(3);
    int i2 = paramq.c(3);
    paramq.b(2);
    int i3 = paramq.c(8);
    int i4 = paramq.c(8);
    int i5 = paramq.c(4);
    int i6 = paramq.c(2);
    paramq.b(2);
    int i7 = paramInt - 10;
    SparseArray localSparseArray = new SparseArray();
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    int i14;
    int i15;
    if (i7 > 0)
    {
      i8 = paramq.c(16);
      i9 = paramq.c(2);
      i10 = paramq.c(2);
      i11 = paramq.c(12);
      paramq.b(4);
      i12 = paramq.c(12);
      i13 = i7 - 6;
      if ((i9 != 1) && (i9 != 2))
        break label253;
      i14 = paramq.c(8);
      i15 = paramq.c(8);
      i7 = i13 - 2;
    }
    while (true)
    {
      localSparseArray.put(i8, new g(i9, i10, i11, i12, i14, i15));
      break;
      return new f(k, bool, m, n, i1, i2, i3, i4, i5, i6, localSparseArray);
      label253: i7 = i13;
      i14 = 0;
      i15 = 0;
    }
  }

  private static int[] b()
  {
    return new int[] { 0, -1, -16777216, -8421505 };
  }

  private static int c(q paramq, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, Paint paramPaint, Canvas paramCanvas)
  {
    int i3;
    for (int k = 0; ; k = i3)
    {
      int m = paramq.c(8);
      int i2;
      int i4;
      if (m != 0)
      {
        i2 = 1;
        i3 = k;
        i4 = m;
      }
      while (true)
      {
        if ((i2 != 0) && (paramPaint != null))
        {
          if (paramArrayOfByte != null)
            i4 = paramArrayOfByte[i4];
          paramPaint.setColor(paramArrayOfInt[i4]);
          paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + i2, paramInt2 + 1, paramPaint);
        }
        paramInt1 += i2;
        if (i3 == 0)
          break;
        return paramInt1;
        if (!paramq.e())
        {
          int i5 = paramq.c(7);
          if (i5 != 0)
          {
            i2 = i5;
            i3 = k;
            i4 = 0;
          }
          else
          {
            i3 = 1;
            i4 = 0;
            i2 = 0;
          }
        }
        else
        {
          int n = paramq.c(7);
          int i1 = paramq.c(8);
          i2 = n;
          i3 = k;
          i4 = i1;
        }
      }
    }
  }

  private static a c(q paramq, int paramInt)
  {
    int k = paramq.c(8);
    paramq.b(8);
    int m = paramInt - 2;
    int[] arrayOfInt1 = b();
    int[] arrayOfInt2 = c();
    int[] arrayOfInt3 = d();
    if (m > 0)
    {
      int n = paramq.c(8);
      int i1 = paramq.c(8);
      int i2 = m - 2;
      int[] arrayOfInt4;
      label70: int i3;
      int i4;
      int i5;
      int i6;
      if ((i1 & 0x80) != 0)
      {
        arrayOfInt4 = arrayOfInt1;
        if ((i1 & 0x1) == 0)
          break label271;
        i3 = paramq.c(8);
        i4 = paramq.c(8);
        i5 = paramq.c(8);
        i6 = paramq.c(8);
      }
      for (m = i2 - 4; ; m = i2 - 2)
      {
        if (i3 == 0)
        {
          i4 = 0;
          i5 = 0;
          i6 = 255;
        }
        int i7 = (byte)(255 - (i6 & 0xFF));
        int i8 = (int)(i3 + 1.402D * (i4 - 128));
        int i9 = (int)(i3 - 0.34414D * (i5 - 128) - 0.71414D * (i4 - 128));
        int i10 = (int)(i3 + 1.772D * (i5 - 128));
        arrayOfInt4[n] = a(i7, ag.a(i8, 0, 255), ag.a(i9, 0, 255), ag.a(i10, 0, 255));
        break;
        if ((i1 & 0x40) != 0)
        {
          arrayOfInt4 = arrayOfInt2;
          break label70;
        }
        arrayOfInt4 = arrayOfInt3;
        break label70;
        label271: i3 = paramq.c(6) << 2;
        i4 = paramq.c(4) << 4;
        i5 = paramq.c(4) << 4;
        i6 = paramq.c(2) << 6;
      }
    }
    return new a(k, arrayOfInt1, arrayOfInt2, arrayOfInt3);
  }

  private static int[] c()
  {
    int[] arrayOfInt = new int[16];
    arrayOfInt[0] = 0;
    int k = 1;
    if (k < arrayOfInt.length)
    {
      if (k < 8)
      {
        int i2;
        label34: int i3;
        if ((k & 0x1) != 0)
        {
          i2 = 255;
          if ((k & 0x2) == 0)
            break label83;
          i3 = 255;
          label45: if ((k & 0x4) == 0)
            break label89;
        }
        label83: label89: for (int i4 = 255; ; i4 = 0)
        {
          arrayOfInt[k] = a(255, i2, i3, i4);
          k++;
          break;
          i2 = 0;
          break label34;
          i3 = 0;
          break label45;
        }
      }
      int m;
      label104: int n;
      if ((k & 0x1) != 0)
      {
        m = 127;
        if ((k & 0x2) == 0)
          break label144;
        n = 127;
        label113: if ((k & 0x4) == 0)
          break label149;
      }
      label144: label149: for (int i1 = 127; ; i1 = 0)
      {
        arrayOfInt[k] = a(255, m, n, i1);
        break;
        m = 0;
        break label104;
        n = 0;
        break label113;
      }
    }
    return arrayOfInt;
  }

  private static int[] d()
  {
    int[] arrayOfInt = new int[256];
    arrayOfInt[0] = 0;
    int k = 0;
    if (k < arrayOfInt.length)
    {
      int i34;
      label35: int i35;
      label46: int i36;
      if (k < 8)
        if ((k & 0x1) != 0)
        {
          i34 = 255;
          if ((k & 0x2) == 0)
            break label83;
          i35 = 255;
          if ((k & 0x4) == 0)
            break label89;
          i36 = 255;
          label57: arrayOfInt[k] = a(63, i34, i35, i36);
        }
      while (true)
      {
        k++;
        break;
        i34 = 0;
        break label35;
        label83: i35 = 0;
        break label46;
        label89: i36 = 0;
        break label57;
        switch (k & 0x88)
        {
        default:
        case 0:
        case 8:
        case 128:
        case 136:
        }
      }
      int i26;
      label157: int i27;
      label169: int i28;
      int i29;
      label186: int i30;
      label198: int i31;
      int i32;
      if ((k & 0x1) != 0)
      {
        i26 = 85;
        if ((k & 0x10) == 0)
          break label254;
        i27 = 170;
        i28 = i26 + i27;
        if ((k & 0x2) == 0)
          break label260;
        i29 = 85;
        if ((k & 0x20) == 0)
          break label266;
        i30 = 170;
        i31 = i29 + i30;
        if ((k & 0x4) == 0)
          break label272;
        i32 = 85;
        label215: if ((k & 0x40) == 0)
          break label278;
      }
      label260: label266: label272: label278: for (int i33 = 170; ; i33 = 0)
      {
        arrayOfInt[k] = a(255, i28, i31, i33 + i32);
        break;
        i26 = 0;
        break label157;
        label254: i27 = 0;
        break label169;
        i29 = 0;
        break label186;
        i30 = 0;
        break label198;
        i32 = 0;
        break label215;
      }
      int i18;
      label294: int i19;
      label306: int i20;
      int i21;
      label323: int i22;
      label335: int i23;
      int i24;
      if ((k & 0x1) != 0)
      {
        i18 = 85;
        if ((k & 0x10) == 0)
          break label390;
        i19 = 170;
        i20 = i18 + i19;
        if ((k & 0x2) == 0)
          break label396;
        i21 = 85;
        if ((k & 0x20) == 0)
          break label402;
        i22 = 170;
        i23 = i21 + i22;
        if ((k & 0x4) == 0)
          break label408;
        i24 = 85;
        label352: if ((k & 0x40) == 0)
          break label414;
      }
      label390: label396: label402: label408: label414: for (int i25 = 170; ; i25 = 0)
      {
        arrayOfInt[k] = a(127, i20, i23, i25 + i24);
        break;
        i18 = 0;
        break label294;
        i19 = 0;
        break label306;
        i21 = 0;
        break label323;
        i22 = 0;
        break label335;
        i24 = 0;
        break label352;
      }
      int i7;
      label430: int i9;
      label448: int i10;
      int i11;
      label465: int i13;
      label483: int i14;
      int i15;
      label500: int i16;
      if ((k & 0x1) != 0)
      {
        i7 = 43;
        int i8 = i7 + 127;
        if ((k & 0x10) == 0)
          break label545;
        i9 = 85;
        i10 = i8 + i9;
        if ((k & 0x2) == 0)
          break label551;
        i11 = 43;
        int i12 = i11 + 127;
        if ((k & 0x20) == 0)
          break label557;
        i13 = 85;
        i14 = i12 + i13;
        if ((k & 0x4) == 0)
          break label563;
        i15 = 43;
        i16 = i15 + 127;
        if ((k & 0x40) == 0)
          break label569;
      }
      label545: label551: label557: label563: label569: for (int i17 = 85; ; i17 = 0)
      {
        arrayOfInt[k] = a(255, i10, i14, i17 + i16);
        break;
        i7 = 0;
        break label430;
        i9 = 0;
        break label448;
        i11 = 0;
        break label465;
        i13 = 0;
        break label483;
        i15 = 0;
        break label500;
      }
      int m;
      label584: int n;
      label594: int i1;
      int i2;
      label609: int i3;
      label620: int i4;
      int i5;
      if ((k & 0x1) != 0)
      {
        m = 43;
        if ((k & 0x10) == 0)
          break label674;
        n = 85;
        i1 = m + n;
        if ((k & 0x2) == 0)
          break label679;
        i2 = 43;
        if ((k & 0x20) == 0)
          break label685;
        i3 = 85;
        i4 = i2 + i3;
        if ((k & 0x4) == 0)
          break label691;
        i5 = 43;
        label637: if ((k & 0x40) == 0)
          break label697;
      }
      label674: label679: label685: label691: label697: for (int i6 = 85; ; i6 = 0)
      {
        arrayOfInt[k] = a(255, i1, i4, i6 + i5);
        break;
        m = 0;
        break label584;
        n = 0;
        break label594;
        i2 = 0;
        break label609;
        i3 = 0;
        break label620;
        i5 = 0;
        break label637;
      }
    }
    return arrayOfInt;
  }

  public List<com.google.android.exoplayer2.e.b> a(byte[] paramArrayOfByte, int paramInt)
  {
    q localq = new q(paramArrayOfByte, paramInt);
    while ((localq.a() >= 48) && (localq.c(8) == 15))
      a(localq, this.i);
    if (this.i.i == null)
      return Collections.emptyList();
    b localb;
    ArrayList localArrayList;
    int k;
    f localf;
    int n;
    int i1;
    a locala1;
    if (this.i.h != null)
    {
      localb = this.i.h;
      if ((this.j == null) || (1 + localb.a != this.j.getWidth()) || (1 + localb.b != this.j.getHeight()))
      {
        this.j = Bitmap.createBitmap(1 + localb.a, 1 + localb.b, Bitmap.Config.ARGB_8888);
        this.f.setBitmap(this.j);
      }
      localArrayList = new ArrayList();
      SparseArray localSparseArray1 = this.i.i.d;
      k = 0;
      if (k >= localSparseArray1.size())
        break label733;
      e locale = (e)localSparseArray1.valueAt(k);
      int m = localSparseArray1.keyAt(k);
      localf = (f)this.i.c.get(m);
      n = locale.a + localb.c;
      i1 = locale.b + localb.e;
      int i2 = Math.min(n + localf.c, localb.d);
      int i3 = Math.min(i1 + localf.d, localb.f);
      this.f.clipRect(n, i1, i2, i3, Region.Op.REPLACE);
      locala1 = (a)this.i.d.get(localf.g);
      if (locala1 != null)
        break label736;
      locala1 = (a)this.i.f.get(localf.g);
      if (locala1 != null)
        break label736;
    }
    label692: label733: label736: for (a locala2 = this.h; ; locala2 = locala1)
    {
      SparseArray localSparseArray2 = localf.k;
      int i4 = 0;
      label373: if (i4 < localSparseArray2.size())
      {
        int i6 = localSparseArray2.keyAt(i4);
        g localg = (g)localSparseArray2.valueAt(i4);
        c localc = (c)this.i.e.get(i6);
        if (localc == null)
          localc = (c)this.i.g.get(i6);
        if (localc != null)
          if (!localc.b)
            break label508;
        label508: for (Paint localPaint = null; ; localPaint = this.d)
        {
          a(localc, locala2, localf.f, n + localg.c, i1 + localg.d, localPaint, this.f);
          i4++;
          break label373;
          localb = this.g;
          break;
        }
      }
      int i5;
      if (localf.b)
      {
        if (localf.f != 3)
          break label692;
        i5 = locala2.d[localf.h];
      }
      while (true)
      {
        this.e.setColor(i5);
        this.f.drawRect(n, i1, n + localf.c, i1 + localf.d, this.e);
        localArrayList.add(new com.google.android.exoplayer2.e.b(Bitmap.createBitmap(this.j, n, i1, localf.c, localf.d), n / localb.a, 0, i1 / localb.b, 0, localf.c / localb.a, localf.d / localb.b));
        this.f.drawColor(0, PorterDuff.Mode.CLEAR);
        k++;
        break;
        if (localf.f == 2)
          i5 = locala2.c[localf.i];
        else
          i5 = locala2.b[localf.j];
      }
      return localArrayList;
    }
  }

  public void a()
  {
    this.i.a();
  }

  private static final class a
  {
    public final int a;
    public final int[] b;
    public final int[] c;
    public final int[] d;

    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
    {
      this.a = paramInt;
      this.b = paramArrayOfInt1;
      this.c = paramArrayOfInt2;
      this.d = paramArrayOfInt3;
    }
  }

  private static final class b
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
    }
  }

  private static final class c
  {
    public final int a;
    public final boolean b;
    public final byte[] c;
    public final byte[] d;

    public c(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      this.a = paramInt;
      this.b = paramBoolean;
      this.c = paramArrayOfByte1;
      this.d = paramArrayOfByte2;
    }
  }

  private static final class d
  {
    public final int a;
    public final int b;
    public final int c;
    public final SparseArray<b.e> d;

    public d(int paramInt1, int paramInt2, int paramInt3, SparseArray<b.e> paramSparseArray)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramSparseArray;
    }
  }

  private static final class e
  {
    public final int a;
    public final int b;

    public e(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }

  private static final class f
  {
    public final int a;
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final SparseArray<b.g> k;

    public f(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, SparseArray<b.g> paramSparseArray)
    {
      this.a = paramInt1;
      this.b = paramBoolean;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      this.f = paramInt5;
      this.g = paramInt6;
      this.h = paramInt7;
      this.i = paramInt8;
      this.j = paramInt9;
      this.k = paramSparseArray;
    }

    public void a(f paramf)
    {
      if (paramf == null);
      while (true)
      {
        return;
        SparseArray localSparseArray = paramf.k;
        for (int m = 0; m < localSparseArray.size(); m++)
          this.k.put(localSparseArray.keyAt(m), localSparseArray.valueAt(m));
      }
    }
  }

  private static final class g
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
    }
  }

  private static final class h
  {
    public final int a;
    public final int b;
    public final SparseArray<b.f> c = new SparseArray();
    public final SparseArray<b.a> d = new SparseArray();
    public final SparseArray<b.c> e = new SparseArray();
    public final SparseArray<b.a> f = new SparseArray();
    public final SparseArray<b.c> g = new SparseArray();
    public b.b h;
    public b.d i;

    public h(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    public void a()
    {
      this.c.clear();
      this.d.clear();
      this.e.clear();
      this.f.clear();
      this.g.clear();
      this.h = null;
      this.i = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b.b
 * JD-Core Version:    0.6.2
 */