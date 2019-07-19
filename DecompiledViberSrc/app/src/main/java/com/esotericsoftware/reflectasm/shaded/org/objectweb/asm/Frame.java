package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

final class Frame
{
  static final int[] a = arrayOfInt;
  Label b;
  int[] c;
  int[] d;
  private int[] e;
  private int[] f;
  private int g;
  private int h;
  private int[] i;

  static
  {
    int[] arrayOfInt = new int['Ê'];
    for (int j = 0; j < arrayOfInt.length; j++)
      arrayOfInt[j] = ('ﾻ' + "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(j));
  }

  private int a()
  {
    if (this.g > 0)
    {
      int[] arrayOfInt = this.f;
      int k = -1 + this.g;
      this.g = k;
      return arrayOfInt[k];
    }
    Label localLabel = this.b;
    int j = -1 + localLabel.f;
    localLabel.f = j;
    return 0x3000000 | -j;
  }

  private int a(int paramInt)
  {
    int j;
    if ((this.e == null) || (paramInt >= this.e.length))
      j = 0x2000000 | paramInt;
    do
    {
      return j;
      j = this.e[paramInt];
    }
    while (j != 0);
    int[] arrayOfInt = this.e;
    int k = 0x2000000 | paramInt;
    arrayOfInt[paramInt] = k;
    return k;
  }

  private int a(ClassWriter paramClassWriter, int paramInt)
  {
    int j;
    if (paramInt == 16777222)
      j = 0x1700000 | paramClassWriter.c(paramClassWriter.I);
    label148: for (int k = 0; ; k++)
    {
      int m;
      int n;
      int i1;
      if (k < this.h)
      {
        m = this.i[k];
        n = 0xF0000000 & m;
        i1 = 0xF000000 & m;
        if (i1 != 33554432)
          break label117;
        m = n + this.c[(m & 0x7FFFFF)];
      }
      while (true)
      {
        if (paramInt != m)
          break label148;
        paramInt = j;
        do
          return paramInt;
        while ((0xFFF00000 & paramInt) != 25165824);
        j = 0x1700000 | paramClassWriter.c(paramClassWriter.H[(0xFFFFF & paramInt)].g);
        break;
        label117: if (i1 == 50331648)
          m = n + this.d[(this.d.length - (m & 0x7FFFFF))];
      }
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (this.e == null)
      this.e = new int[10];
    int j = this.e.length;
    if (paramInt1 >= j)
    {
      int[] arrayOfInt = new int[Math.max(paramInt1 + 1, j * 2)];
      System.arraycopy(this.e, 0, arrayOfInt, 0, j);
      this.e = arrayOfInt;
    }
    this.e[paramInt1] = paramInt2;
  }

  private void a(ClassWriter paramClassWriter, String paramString)
  {
    int j = b(paramClassWriter, paramString);
    if (j != 0)
    {
      b(j);
      if ((j == 16777220) || (j == 16777219))
        b(16777216);
    }
  }

  private void a(String paramString)
  {
    int j = paramString.charAt(0);
    if (j == 40)
    {
      c(-1 + (Type.getArgumentsAndReturnSizes(paramString) >> 2));
      return;
    }
    if ((j == 74) || (j == 68))
    {
      c(2);
      return;
    }
    c(1);
  }

  private static boolean a(ClassWriter paramClassWriter, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int j = paramArrayOfInt[paramInt2];
    if (j == paramInt1)
      return false;
    if ((0xFFFFFFF & paramInt1) == 16777221)
      if (j == 16777221)
        return false;
    for (int k = 16777221; ; k = paramInt1)
    {
      if (j == 0)
      {
        paramArrayOfInt[paramInt2] = k;
        return true;
      }
      if (((j & 0xFF00000) == 24117248) || ((j & 0xF0000000) != 0))
      {
        if (k == 16777221)
          return false;
        if ((0xFFF00000 & k) == (0xFFF00000 & j))
          if ((j & 0xFF00000) == 24117248)
            k = 0x1700000 | k & 0xF0000000 | paramClassWriter.a(k & 0xFFFFF, 0xFFFFF & j);
      }
      while (j != k)
      {
        paramArrayOfInt[paramInt2] = k;
        return true;
        k = 0x1700000 | paramClassWriter.c("java/lang/Object");
        continue;
        if (((k & 0xFF00000) == 24117248) || ((k & 0xF0000000) != 0))
        {
          k = 0x1700000 | paramClassWriter.c("java/lang/Object");
        }
        else
        {
          k = 16777216;
          continue;
          if (j == 16777221)
          {
            if (((k & 0xFF00000) != 24117248) && ((k & 0xF0000000) == 0))
              k = 16777216;
          }
          else
            k = 16777216;
        }
      }
      return false;
    }
  }

  private static int b(ClassWriter paramClassWriter, String paramString)
  {
    int j = 16777217;
    if (paramString.charAt(0) == '(');
    int i1;
    for (int k = 1 + paramString.indexOf(')'); ; k = 0)
    {
      int m = paramString.charAt(k);
      n = 0;
      switch (m)
      {
      default:
        for (i1 = k + 1; paramString.charAt(i1) == '['; i1++);
      case 66:
      case 67:
      case 73:
      case 83:
      case 90:
      case 86:
      case 70:
      case 74:
      case 68:
      case 76:
      }
    }
    int n = j;
    return n;
    return 16777218;
    return 16777220;
    return 16777219;
    return 0x1700000 | paramClassWriter.c(paramString.substring(k + 1, -1 + paramString.length()));
    switch (paramString.charAt(i1))
    {
    default:
      j = 0x1700000 | paramClassWriter.c(paramString.substring(i1 + 1, -1 + paramString.length()));
    case 'I':
    case 'Z':
    case 'C':
    case 'B':
    case 'S':
    case 'F':
    case 'J':
    case 'D':
    }
    while (true)
    {
      return j | i1 - k << 28;
      j = 16777225;
      continue;
      j = 16777227;
      continue;
      j = 16777226;
      continue;
      j = 16777228;
      continue;
      j = 16777218;
      continue;
      j = 16777220;
      continue;
      j = 16777219;
    }
  }

  private void b(int paramInt)
  {
    if (this.f == null)
      this.f = new int[10];
    int j = this.f.length;
    if (this.g >= j)
    {
      int[] arrayOfInt2 = new int[Math.max(1 + this.g, j * 2)];
      System.arraycopy(this.f, 0, arrayOfInt2, 0, j);
      this.f = arrayOfInt2;
    }
    int[] arrayOfInt1 = this.f;
    int k = this.g;
    this.g = (k + 1);
    arrayOfInt1[k] = paramInt;
    int m = this.b.f + this.g;
    if (m > this.b.g)
      this.b.g = m;
  }

  private void c(int paramInt)
  {
    if (this.g >= paramInt)
    {
      this.g -= paramInt;
      return;
    }
    Label localLabel = this.b;
    localLabel.f -= paramInt - this.g;
    this.g = 0;
  }

  private void d(int paramInt)
  {
    if (this.i == null)
      this.i = new int[2];
    int j = this.i.length;
    if (this.h >= j)
    {
      int[] arrayOfInt2 = new int[Math.max(1 + this.h, j * 2)];
      System.arraycopy(this.i, 0, arrayOfInt2, 0, j);
      this.i = arrayOfInt2;
    }
    int[] arrayOfInt1 = this.i;
    int k = this.h;
    this.h = (k + 1);
    arrayOfInt1[k] = paramInt;
  }

  void a(int paramInt1, int paramInt2, ClassWriter paramClassWriter, Item paramItem)
  {
    switch (paramInt1)
    {
    case 19:
    case 20:
    case 26:
    case 27:
    case 28:
    case 29:
    case 30:
    case 31:
    case 32:
    case 33:
    case 34:
    case 35:
    case 36:
    case 37:
    case 38:
    case 39:
    case 40:
    case 41:
    case 42:
    case 43:
    case 44:
    case 45:
    case 59:
    case 60:
    case 61:
    case 62:
    case 63:
    case 64:
    case 65:
    case 66:
    case 67:
    case 68:
    case 69:
    case 70:
    case 71:
    case 72:
    case 73:
    case 74:
    case 75:
    case 76:
    case 77:
    case 78:
    case 196:
    case 197:
    default:
      c(paramInt2);
      a(paramClassWriter, paramItem.g);
    case 0:
    case 116:
    case 117:
    case 118:
    case 119:
    case 145:
    case 146:
    case 147:
    case 167:
    case 177:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 16:
    case 17:
    case 21:
    case 9:
    case 10:
    case 22:
    case 11:
    case 12:
    case 13:
    case 23:
    case 14:
    case 15:
    case 24:
    case 18:
    case 25:
    case 46:
    case 51:
    case 52:
    case 53:
    case 47:
    case 143:
    case 48:
    case 49:
    case 138:
    case 50:
    case 54:
    case 56:
    case 58:
    case 55:
    case 57:
      int i15;
      do
      {
        do
        {
          int i16;
          do
          {
            do
            {
              return;
              b(16777221);
              return;
              b(16777217);
              return;
              b(16777220);
              b(16777216);
              return;
              b(16777218);
              return;
              b(16777219);
              b(16777216);
              return;
              switch (paramItem.b)
              {
              case 9:
              case 10:
              case 11:
              case 12:
              case 13:
              case 14:
              case 15:
              default:
                b(0x1700000 | paramClassWriter.c("java/lang/invoke/MethodHandle"));
                return;
              case 3:
                b(16777217);
                return;
              case 5:
                b(16777220);
                b(16777216);
                return;
              case 4:
                b(16777218);
                return;
              case 6:
                b(16777219);
                b(16777216);
                return;
              case 7:
                b(0x1700000 | paramClassWriter.c("java/lang/Class"));
                return;
              case 8:
                b(0x1700000 | paramClassWriter.c("java/lang/String"));
                return;
              case 16:
              }
              b(0x1700000 | paramClassWriter.c("java/lang/invoke/MethodType"));
              return;
              b(a(paramInt2));
              return;
              c(2);
              b(16777217);
              return;
              c(2);
              b(16777220);
              b(16777216);
              return;
              c(2);
              b(16777218);
              return;
              c(2);
              b(16777219);
              b(16777216);
              return;
              c(1);
              b(-268435456 + a());
              return;
              a(paramInt2, a());
            }
            while (paramInt2 <= 0);
            i16 = a(paramInt2 - 1);
            if ((i16 == 16777220) || (i16 == 16777219))
            {
              a(paramInt2 - 1, 16777216);
              return;
            }
          }
          while ((0xF000000 & i16) == 16777216);
          a(paramInt2 - 1, i16 | 0x800000);
          return;
          c(1);
          a(paramInt2, a());
          a(paramInt2 + 1, 16777216);
        }
        while (paramInt2 <= 0);
        i15 = a(paramInt2 - 1);
        if ((i15 == 16777220) || (i15 == 16777219))
        {
          a(paramInt2 - 1, 16777216);
          return;
        }
      }
      while ((0xF000000 & i15) == 16777216);
      a(paramInt2 - 1, i15 | 0x800000);
      return;
    case 79:
    case 81:
    case 83:
    case 84:
    case 85:
    case 86:
      c(3);
      return;
    case 80:
    case 82:
      c(4);
      return;
    case 87:
    case 153:
    case 154:
    case 155:
    case 156:
    case 157:
    case 158:
    case 170:
    case 171:
    case 172:
    case 174:
    case 176:
    case 191:
    case 194:
    case 195:
    case 198:
    case 199:
      c(1);
      return;
    case 88:
    case 159:
    case 160:
    case 161:
    case 162:
    case 163:
    case 164:
    case 165:
    case 166:
    case 173:
    case 175:
      c(2);
      return;
    case 89:
      int i14 = a();
      b(i14);
      b(i14);
      return;
    case 90:
      int i12 = a();
      int i13 = a();
      b(i12);
      b(i13);
      b(i12);
      return;
    case 91:
      int i9 = a();
      int i10 = a();
      int i11 = a();
      b(i9);
      b(i11);
      b(i10);
      b(i9);
      return;
    case 92:
      int i7 = a();
      int i8 = a();
      b(i8);
      b(i7);
      b(i8);
      b(i7);
      return;
    case 93:
      int i4 = a();
      int i5 = a();
      int i6 = a();
      b(i5);
      b(i4);
      b(i6);
      b(i5);
      b(i4);
      return;
    case 94:
      int n = a();
      int i1 = a();
      int i2 = a();
      int i3 = a();
      b(i1);
      b(n);
      b(i3);
      b(i2);
      b(i1);
      b(n);
      return;
    case 95:
      int k = a();
      int m = a();
      b(k);
      b(m);
      return;
    case 96:
    case 100:
    case 104:
    case 108:
    case 112:
    case 120:
    case 122:
    case 124:
    case 126:
    case 128:
    case 130:
    case 136:
    case 142:
    case 149:
    case 150:
      c(2);
      b(16777217);
      return;
    case 97:
    case 101:
    case 105:
    case 109:
    case 113:
    case 127:
    case 129:
    case 131:
      c(4);
      b(16777220);
      b(16777216);
      return;
    case 98:
    case 102:
    case 106:
    case 110:
    case 114:
    case 137:
    case 144:
      c(2);
      b(16777218);
      return;
    case 99:
    case 103:
    case 107:
    case 111:
    case 115:
      c(4);
      b(16777219);
      b(16777216);
      return;
    case 121:
    case 123:
    case 125:
      c(3);
      b(16777220);
      b(16777216);
      return;
    case 132:
      a(paramInt2, 16777217);
      return;
    case 133:
    case 140:
      c(1);
      b(16777220);
      b(16777216);
      return;
    case 134:
      c(1);
      b(16777218);
      return;
    case 135:
    case 141:
      c(1);
      b(16777219);
      b(16777216);
      return;
    case 139:
    case 190:
    case 193:
      c(1);
      b(16777217);
      return;
    case 148:
    case 151:
    case 152:
      c(4);
      b(16777217);
      return;
    case 168:
    case 169:
      throw new RuntimeException("JSR/RET are not supported with computeFrames option");
    case 178:
      a(paramClassWriter, paramItem.i);
      return;
    case 179:
      a(paramItem.i);
      return;
    case 180:
      c(1);
      a(paramClassWriter, paramItem.i);
      return;
    case 181:
      a(paramItem.i);
      a();
      return;
    case 182:
    case 183:
    case 184:
    case 185:
      a(paramItem.i);
      if (paramInt1 != 184)
      {
        int j = a();
        if ((paramInt1 == 183) && (paramItem.h.charAt(0) == '<'))
          d(j);
      }
      a(paramClassWriter, paramItem.i);
      return;
    case 186:
      a(paramItem.h);
      a(paramClassWriter, paramItem.h);
      return;
    case 187:
      b(0x1800000 | paramClassWriter.a(paramItem.g, paramInt2));
      return;
    case 188:
      a();
      switch (paramInt2)
      {
      default:
        b(285212676);
        return;
      case 4:
        b(285212681);
        return;
      case 5:
        b(285212683);
        return;
      case 8:
        b(285212682);
        return;
      case 9:
        b(285212684);
        return;
      case 10:
        b(285212673);
        return;
      case 6:
        b(285212674);
        return;
      case 7:
      }
      b(285212675);
      return;
    case 189:
      String str2 = paramItem.g;
      a();
      if (str2.charAt(0) == '[')
      {
        a(paramClassWriter, '[' + str2);
        return;
      }
      b(0x11700000 | paramClassWriter.c(str2));
      return;
    case 192:
    }
    String str1 = paramItem.g;
    a();
    if (str1.charAt(0) == '[')
    {
      a(paramClassWriter, str1);
      return;
    }
    b(0x1700000 | paramClassWriter.c(str1));
  }

  void a(ClassWriter paramClassWriter, int paramInt1, Type[] paramArrayOfType, int paramInt2)
  {
    int j = 1;
    int k = 0;
    this.c = new int[paramInt2];
    this.d = new int[0];
    if ((paramInt1 & 0x8) == 0)
      if ((0x40000 & paramInt1) == 0)
        this.c[0] = (0x1700000 | paramClassWriter.c(paramClassWriter.I));
    while (true)
    {
      int i1;
      if (k < paramArrayOfType.length)
      {
        int n = b(paramClassWriter, paramArrayOfType[k].getDescriptor());
        int[] arrayOfInt2 = this.c;
        i1 = j + 1;
        arrayOfInt2[j] = n;
        if ((n != 16777220) && (n != 16777219))
          break label178;
        int[] arrayOfInt3 = this.c;
        j = i1 + 1;
        arrayOfInt3[i1] = 16777216;
      }
      while (true)
      {
        k++;
        break;
        this.c[0] = 16777222;
        k = 0;
        break;
        while (j < paramInt2)
        {
          int[] arrayOfInt1 = this.c;
          int m = j + 1;
          arrayOfInt1[j] = 16777216;
          j = m;
        }
        return;
        label178: j = i1;
      }
      j = 0;
      k = 0;
    }
  }

  boolean a(ClassWriter paramClassWriter, Frame paramFrame, int paramInt)
  {
    int j = this.c.length;
    int k = this.d.length;
    int[] arrayOfInt = paramFrame.c;
    boolean bool1 = false;
    if (arrayOfInt == null)
    {
      paramFrame.c = new int[j];
      bool1 = true;
    }
    int m = 0;
    boolean bool2 = bool1;
    int i9;
    if (m < j)
      if ((this.e != null) && (m < this.e.length))
      {
        i9 = this.e[m];
        if (i9 == 0)
          i9 = this.c[m];
      }
    while (true)
    {
      if (this.i != null)
        i9 = a(paramClassWriter, i9);
      bool2 |= a(paramClassWriter, i9, paramFrame.c, m);
      m++;
      break;
      int i10 = 0xF0000000 & i9;
      int i11 = 0xF000000 & i9;
      if (i11 != 16777216)
      {
        int i12;
        if (i11 == 33554432)
          i12 = i10 + this.c[(0x7FFFFF & i9)];
        while (true)
          if (((i9 & 0x800000) != 0) && ((i12 == 16777220) || (i12 == 16777219)))
          {
            i9 = 16777216;
            break;
            i12 = i10 + this.d[(k - (0x7FFFFF & i9))];
            continue;
            i9 = this.c[m];
            break;
            boolean bool4;
            if (paramInt > 0)
            {
              int i8 = 0;
              boolean bool6;
              for (boolean bool5 = bool2; i8 < j; bool5 = bool6)
              {
                bool6 = bool5 | a(paramClassWriter, this.c[i8], paramFrame.c, i8);
                i8++;
              }
              if (paramFrame.d == null)
              {
                paramFrame.d = new int[1];
                bool5 = true;
              }
              bool4 = bool5 | a(paramClassWriter, paramInt, paramFrame.d, 0);
              return bool4;
            }
            int n = this.d.length + this.b.f;
            if (paramFrame.d == null)
              paramFrame.d = new int[n + this.g];
            for (boolean bool3 = true; ; bool3 = bool2)
            {
              int i1 = 0;
              bool4 = bool3;
              while (i1 < n)
              {
                int i7 = this.d[i1];
                if (this.i != null)
                  i7 = a(paramClassWriter, i7);
                bool4 |= a(paramClassWriter, i7, paramFrame.d, i1);
                i1++;
              }
              int i2 = 0;
              label425: int i3;
              int i4;
              int i5;
              if (i2 < this.g)
              {
                i3 = this.f[i2];
                i4 = 0xF0000000 & i3;
                i5 = 0xF000000 & i3;
                if (i5 != 16777216)
                  break label506;
              }
              while (true)
              {
                if (this.i != null)
                  i3 = a(paramClassWriter, i3);
                bool4 |= a(paramClassWriter, i3, paramFrame.d, n + i2);
                i2++;
                break label425;
                break;
                label506: if (i5 == 33554432);
                for (int i6 = i4 + this.c[(0x7FFFFF & i3)]; ; i6 = i4 + this.d[(k - (0x7FFFFF & i3))])
                {
                  if (((i3 & 0x800000) == 0) || ((i6 != 16777220) && (i6 != 16777219)))
                    break label578;
                  i3 = 16777216;
                  break;
                }
                label578: i3 = i6;
              }
            }
          }
        i9 = i12;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Frame
 * JD-Core Version:    0.6.2
 */