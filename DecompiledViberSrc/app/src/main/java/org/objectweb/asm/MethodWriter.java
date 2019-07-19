package org.objectweb.asm;

class MethodWriter extends MethodVisitor
{
  private ByteVector $;
  private int A;
  private Handler B;
  private Handler C;
  private int D;
  private ByteVector E;
  private int F;
  private ByteVector G;
  private int H;
  private ByteVector I;
  private Attribute J;
  private boolean K;
  private int L;
  private final int M;
  private Label N;
  private Label O;
  private Label P;
  private int Q;
  private int R;
  private int S;
  private int T;
  private AnnotationWriter U;
  private AnnotationWriter V;
  private AnnotationWriter W;
  private AnnotationWriter X;
  private int Y;
  private int Z;
  final ClassWriter b;
  private int c;
  private final int d;
  private final int e;
  private final String f;
  String g;
  int h;
  int i;
  int j;
  int[] k;
  private ByteVector l;
  private AnnotationWriter m;
  private AnnotationWriter n;
  private AnnotationWriter[] o;
  private AnnotationWriter[] p;
  private Attribute q;
  private ByteVector r = new ByteVector();
  private int s;
  private int t;
  private int u;
  private ByteVector v;
  private int w;
  private int[] x;
  private int[] z;

  MethodWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(327680);
    if (paramClassWriter.D == null)
      paramClassWriter.D = this;
    while (true)
    {
      paramClassWriter.E = this;
      this.b = paramClassWriter;
      this.c = paramInt;
      if ("<init>".equals(paramString1))
        this.c = (0x80000 | this.c);
      this.d = paramClassWriter.newUTF8(paramString1);
      this.e = paramClassWriter.newUTF8(paramString2);
      this.f = paramString2;
      this.g = paramString3;
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
        break;
      this.j = paramArrayOfString.length;
      this.k = new int[this.j];
      for (int i3 = 0; i3 < this.j; i3++)
        this.k[i3] = paramClassWriter.newClass(paramArrayOfString[i3]);
      paramClassWriter.E.mv = this;
    }
    int i1 = 0;
    if (paramBoolean2);
    while (true)
    {
      this.M = i1;
      if ((paramBoolean1) || (paramBoolean2))
      {
        int i2 = Type.getArgumentsAndReturnSizes(this.f) >> 2;
        if ((paramInt & 0x8) != 0)
          i2--;
        this.t = i2;
        this.T = i2;
        this.N = new Label();
        Label localLabel = this.N;
        localLabel.a = (0x8 | localLabel.a);
        visitLabel(this.N);
      }
      return;
      if (paramBoolean1)
        i1 = 1;
      else
        i1 = 2;
    }
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt3 + (paramInt2 + 3);
    if ((this.z == null) || (this.z.length < i1))
      this.z = new int[i1];
    this.z[0] = paramInt1;
    this.z[1] = paramInt2;
    this.z[2] = paramInt3;
    return 3;
  }

  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return (0xFF & paramArrayOfByte[paramInt]) << 24 | (0xFF & paramArrayOfByte[(paramInt + 1)]) << 16 | (0xFF & paramArrayOfByte[(paramInt + 2)]) << 8 | 0xFF & paramArrayOfByte[(paramInt + 3)];
  }

  static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    int i1 = paramInt2 - paramInt1;
    int i2 = 0;
    if (i2 < paramArrayOfInt1.length)
    {
      if ((paramInt1 < paramArrayOfInt1[i2]) && (paramArrayOfInt1[i2] <= paramInt2))
        i1 += paramArrayOfInt2[i2];
      while (true)
      {
        i2++;
        break;
        if ((paramInt2 < paramArrayOfInt1[i2]) && (paramArrayOfInt1[i2] <= paramInt1))
          i1 -= paramArrayOfInt2[i2];
      }
    }
    return i1;
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      int i1 = this.z[paramInt1];
      int i2 = 0xF0000000 & i1;
      if (i2 == 0)
      {
        int i5 = i1 & 0xFFFFF;
        switch (i1 & 0xFF00000)
        {
        default:
          this.v.putByte(i5);
        case 24117248:
        case 25165824:
        }
        while (true)
        {
          paramInt1++;
          break;
          this.v.putByte(7).putShort(this.b.newClass(this.b.H[i5].g));
          continue;
          this.v.putByte(8).putShort(this.b.H[i5].c);
        }
      }
      StringBuffer localStringBuffer = new StringBuffer();
      int i4;
      for (int i3 = i2 >> 28; ; i3 = i4)
      {
        i4 = i3 - 1;
        if (i3 <= 0)
          break;
        localStringBuffer.append('[');
      }
      if ((i1 & 0xFF00000) == 24117248)
      {
        localStringBuffer.append('L');
        localStringBuffer.append(this.b.H[(i1 & 0xFFFFF)].g);
        localStringBuffer.append(';');
      }
      while (true)
      {
        this.v.putByte(7).putShort(this.b.newClass(localStringBuffer.toString()));
        break;
        switch (i1 & 0xF)
        {
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        default:
          localStringBuffer.append('J');
          break;
        case 1:
          localStringBuffer.append('I');
          break;
        case 2:
          localStringBuffer.append('F');
          break;
        case 3:
          localStringBuffer.append('D');
          break;
        case 9:
          localStringBuffer.append('Z');
          break;
        case 10:
          localStringBuffer.append('B');
          break;
        case 11:
          localStringBuffer.append('C');
          break;
        case 12:
          localStringBuffer.append('S');
        }
      }
    }
  }

  private void a(int paramInt, Label paramLabel)
  {
    Edge localEdge = new Edge();
    localEdge.a = paramInt;
    localEdge.b = paramLabel;
    localEdge.c = this.P.j;
    this.P.j = localEdge;
  }

  private void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      this.v.putByte(7).putShort(this.b.newClass((String)paramObject));
      return;
    }
    if ((paramObject instanceof Integer))
    {
      this.v.putByte(((Integer)paramObject).intValue());
      return;
    }
    this.v.putByte(8).putShort(((Label)paramObject).c);
  }

  private void a(Label paramLabel, Label[] paramArrayOfLabel)
  {
    int i1 = 0;
    if (this.P != null)
    {
      if (this.M == 0)
      {
        this.P.h.a(171, 0, null, null);
        a(0, paramLabel);
        Label localLabel1 = paramLabel.a();
        localLabel1.a = (0x10 | localLabel1.a);
        for (int i2 = 0; i2 < paramArrayOfLabel.length; i2++)
        {
          a(0, paramArrayOfLabel[i2]);
          Label localLabel2 = paramArrayOfLabel[i2].a();
          localLabel2.a = (0x10 | localLabel2.a);
        }
      }
      this.Q = (-1 + this.Q);
      a(this.Q, paramLabel);
      while (i1 < paramArrayOfLabel.length)
      {
        a(this.Q, paramArrayOfLabel[i1]);
        i1++;
      }
      e();
    }
  }

  static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)paramInt2);
  }

  static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, Label paramLabel)
  {
    if ((0x4 & paramLabel.a) == 0)
    {
      paramLabel.c = a(paramArrayOfInt1, paramArrayOfInt2, 0, paramLabel.c);
      paramLabel.a = (0x4 | paramLabel.a);
    }
  }

  static short b(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)((0xFF & paramArrayOfByte[paramInt]) << 8 | 0xFF & paramArrayOfByte[(paramInt + 1)]);
  }

  private void b()
  {
    if (this.x != null)
    {
      if (this.v == null)
        this.v = new ByteVector();
      c();
      this.u = (1 + this.u);
    }
    this.x = this.z;
    this.z = null;
  }

  private void b(Frame paramFrame)
  {
    int[] arrayOfInt1 = paramFrame.c;
    int[] arrayOfInt2 = paramFrame.d;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    if (i1 < arrayOfInt1.length)
    {
      int i17 = arrayOfInt1[i1];
      if (i17 == 16777216)
        i3++;
      while (true)
      {
        if ((i17 == 16777220) || (i17 == 16777219))
          i1++;
        i1++;
        break;
        i2 += i3 + 1;
        i3 = 0;
      }
    }
    int i4 = 0;
    int i5 = 0;
    while (i4 < arrayOfInt2.length)
    {
      int i16 = arrayOfInt2[i4];
      i5++;
      if ((i16 == 16777220) || (i16 == 16777219))
        i4++;
      i4++;
    }
    int i6 = a(paramFrame.b.c, i2, i5);
    int i7 = i2;
    int i8 = i6;
    int i9 = 0;
    while (i7 > 0)
    {
      int i14 = arrayOfInt1[i9];
      int[] arrayOfInt4 = this.z;
      int i15 = i8 + 1;
      arrayOfInt4[i8] = i14;
      if ((i14 == 16777220) || (i14 == 16777219))
        i9++;
      i9++;
      i7--;
      i8 = i15;
    }
    int i10 = i8;
    int i11 = 0;
    while (i11 < arrayOfInt2.length)
    {
      int i12 = arrayOfInt2[i11];
      int[] arrayOfInt3 = this.z;
      int i13 = i10 + 1;
      arrayOfInt3[i10] = i12;
      if ((i12 == 16777220) || (i12 == 16777219))
        i11++;
      i11++;
      i10 = i13;
    }
    b();
  }

  static int c(byte[] paramArrayOfByte, int paramInt)
  {
    return (0xFF & paramArrayOfByte[paramInt]) << 8 | 0xFF & paramArrayOfByte[(paramInt + 1)];
  }

  private void c()
  {
    int i1 = 64;
    int i2 = 0;
    int i3 = this.z[1];
    int i4 = this.z[2];
    if ((0xFFFF & this.b.b) < 50)
    {
      this.v.putShort(this.z[0]).putShort(i3);
      a(3, i3 + 3);
      this.v.putShort(i4);
      a(i3 + 3, i4 + (i3 + 3));
      return;
    }
    int i5 = this.x[1];
    int i6;
    label108: int i8;
    label168: int i7;
    if (this.u == 0)
    {
      i6 = this.z[0];
      if (i4 != 0)
        break label375;
      i8 = i3 - i5;
      switch (i8)
      {
      default:
        i1 = 255;
        i7 = i5;
      case -3:
      case -2:
      case -1:
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      int i9;
      if (i1 != 255)
        i9 = 3;
      while (true)
      {
        if (i2 < i7)
        {
          if (this.z[i9] == this.x[i9])
            break label411;
          i1 = 255;
        }
        switch (i1)
        {
        default:
          this.v.putByte(255).putShort(i6).putShort(i3);
          a(3, i3 + 3);
          this.v.putShort(i4);
          a(i3 + 3, i4 + (i3 + 3));
          return;
          i6 = -1 + (this.z[0] - this.x[0]);
          break label108;
          i1 = 248;
          i5 = i3;
          break label168;
          if (i6 < i1)
          {
            i1 = 0;
            break label168;
          }
          i1 = 251;
          break label168;
          i1 = 252;
          break label168;
          label375: if ((i3 != i5) || (i4 != 1))
            break label550;
          if (i6 < 63);
          while (true)
          {
            i7 = i5;
            i8 = 0;
            break;
            i1 = 247;
          }
          label411: i9++;
          i2++;
        case 0:
        case 64:
        case 247:
        case 251:
        case 248:
        case 252:
        }
      }
      this.v.putByte(i6);
      return;
      this.v.putByte(i6 + 64);
      a(i3 + 3, i3 + 4);
      return;
      this.v.putByte(247).putShort(i6);
      a(i3 + 3, i3 + 4);
      return;
      this.v.putByte(251).putShort(i6);
      return;
      this.v.putByte(i8 + 251).putShort(i6);
      return;
      this.v.putByte(i8 + 251).putShort(i6);
      a(i7 + 3, i3 + 3);
      return;
      label550: i1 = 255;
      i7 = i5;
      i8 = 0;
    }
  }

  private void d()
  {
    byte[] arrayOfByte1 = this.r.a;
    Object localObject1 = new int[0];
    Object localObject2 = new int[0];
    boolean[] arrayOfBoolean = new boolean[this.r.b];
    int i1 = 3;
    if (i1 == 3)
      i1 = 2;
    int i2 = i1;
    int i3 = 0;
    label46: int i42;
    int i43;
    label163: int[] arrayOfInt1;
    int[] arrayOfInt2;
    int i51;
    label267: int i48;
    label288: int i50;
    if (i3 < arrayOfByte1.length)
    {
      i42 = 0xFF & arrayOfByte1[i3];
      i43 = 0;
      switch (ClassWriter.a[i42])
      {
      case 16:
      default:
        i3 += 4;
      case 0:
      case 4:
        while (i43 != 0)
        {
          arrayOfInt1 = new int[1 + localObject1.length];
          arrayOfInt2 = new int[1 + localObject2.length];
          System.arraycopy(localObject1, 0, arrayOfInt1, 0, localObject1.length);
          System.arraycopy(localObject2, 0, arrayOfInt2, 0, localObject2.length);
          arrayOfInt1[localObject1.length] = i3;
          arrayOfInt2[localObject2.length] = i43;
          if (i43 <= 0)
            break label2007;
          i2 = 3;
          localObject2 = arrayOfInt2;
          localObject1 = arrayOfInt1;
          break;
          i3++;
          i43 = 0;
        }
      case 9:
        if (i42 > 201)
          if (i42 < 218)
          {
            i51 = i42 - 49;
            int i52 = i3 + c(arrayOfByte1, i3 + 1);
            i42 = i51;
            i48 = i52;
            int i49 = a((int[])localObject1, (int[])localObject2, i3, i48);
            if (((i49 >= -32768) && (i49 <= 32767)) || (arrayOfBoolean[i3] != 0))
              break label2016;
            if ((i42 != 167) && (i42 != 168))
              break label384;
            i50 = 2;
            label342: arrayOfBoolean[i3] = true;
          }
        break;
      case 10:
      case 14:
      case 15:
      case 17:
      case 1:
      case 3:
      case 11:
      case 2:
      case 5:
      case 6:
      case 12:
      case 13:
      case 7:
      case 8:
      }
    }
    while (true)
    {
      i3 += 3;
      i43 = i50;
      break label163;
      i51 = i42 - 20;
      break label267;
      i48 = i3 + b(arrayOfByte1, i3 + 1);
      break label288;
      label384: i50 = 5;
      break label342;
      i3 += 5;
      i43 = 0;
      break label163;
      if (i2 == 1)
        i43 = -(0x3 & a((int[])localObject1, (int[])localObject2, 0, i3));
      while (true)
      {
        int i47 = i3 + 4 - (i3 & 0x3);
        i3 = i47 + (12 + 4 * (1 + (a(arrayOfByte1, i47 + 8) - a(arrayOfByte1, i47 + 4))));
        break;
        int i46 = arrayOfBoolean[i3];
        i43 = 0;
        if (i46 == 0)
        {
          i43 = i3 & 0x3;
          arrayOfBoolean[i3] = true;
        }
      }
      if (i2 == 1)
        i43 = -(0x3 & a((int[])localObject1, (int[])localObject2, 0, i3));
      while (true)
      {
        int i45 = i3 + 4 - (i3 & 0x3);
        i3 = i45 + (8 + 8 * a(arrayOfByte1, i45 + 4));
        break;
        int i44 = arrayOfBoolean[i3];
        i43 = 0;
        if (i44 == 0)
        {
          i43 = i3 & 0x3;
          arrayOfBoolean[i3] = true;
        }
      }
      if ((0xFF & arrayOfByte1[(i3 + 1)]) == 132)
      {
        i3 += 6;
        i43 = 0;
        break label163;
      }
      i3 += 4;
      i43 = 0;
      break label163;
      i3 += 2;
      i43 = 0;
      break label163;
      i3 += 3;
      i43 = 0;
      break label163;
      i3 += 5;
      i43 = 0;
      break label163;
      if (i2 < 3)
        i2--;
      if (i2 == 0)
      {
        ByteVector localByteVector1 = new ByteVector(this.r.b);
        int i4 = 0;
        while (true)
        {
          label837: label858: label1023: int i20;
          if (i4 < this.r.b)
          {
            int i14 = 0xFF & arrayOfByte1[i4];
            switch (ClassWriter.a[i14])
            {
            case 16:
            default:
              localByteVector1.putByteArray(arrayOfByte1, i4, 4);
              i4 += 4;
              break;
            case 0:
            case 4:
              localByteVector1.putByte(i14);
              i4++;
              break;
            case 9:
              int i40;
              int i36;
              int i37;
              int i39;
              if (i14 > 201)
                if (i14 < 218)
                {
                  i40 = i14 - 49;
                  int i41 = i4 + c(arrayOfByte1, i4 + 1);
                  i14 = i40;
                  i36 = i41;
                  i37 = a((int[])localObject1, (int[])localObject2, i4, i36);
                  if (arrayOfBoolean[i4] == 0)
                    break label1023;
                  if (i14 != 167)
                    break label938;
                  localByteVector1.putByte(200);
                  i39 = i37;
                  localByteVector1.putInt(i39);
                }
              while (true)
              {
                i4 += 3;
                break;
                i40 = i14 - 20;
                break label837;
                i36 = i4 + b(arrayOfByte1, i4 + 1);
                break label858;
                if (i14 == 168)
                {
                  localByteVector1.putByte(201);
                  i39 = i37;
                  break label898;
                }
                if (i14 <= 166);
                for (int i38 = -1 + (0x1 ^ i14 + 1); ; i38 = i14 ^ 0x1)
                {
                  localByteVector1.putByte(i38);
                  localByteVector1.putShort(8);
                  localByteVector1.putByte(200);
                  i39 = i37 - 3;
                  break;
                }
                localByteVector1.putByte(i14);
                localByteVector1.putShort(i37);
              }
            case 10:
              int i35 = a((int[])localObject1, (int[])localObject2, i4, i4 + a(arrayOfByte1, i4 + 1));
              localByteVector1.putByte(i14);
              localByteVector1.putInt(i35);
              i4 += 5;
              break;
            case 14:
              int i25 = i4 + 4 - (i4 & 0x3);
              localByteVector1.putByte(170);
              localByteVector1.putByteArray(null, 0, (4 - localByteVector1.b % 4) % 4);
              int i26 = i4 + a(arrayOfByte1, i25);
              int i27 = i25 + 4;
              localByteVector1.putInt(a((int[])localObject1, (int[])localObject2, i4, i26));
              int i28 = a(arrayOfByte1, i27);
              int i29 = i27 + 4;
              localByteVector1.putInt(i28);
              int i30 = 1 + (a(arrayOfByte1, i29) - i28);
              int i31 = i29 + 4;
              localByteVector1.putInt(a(arrayOfByte1, i31 - 4));
              i20 = i31;
              int i32 = i30;
              while (i32 > 0)
              {
                int i33 = i4 + a(arrayOfByte1, i20);
                int i34 = i20 + 4;
                localByteVector1.putInt(a((int[])localObject1, (int[])localObject2, i4, i33));
                i32--;
                i20 = i34;
              }
            case 15:
              int i15 = i4 + 4 - (i4 & 0x3);
              localByteVector1.putByte(171);
              localByteVector1.putByteArray(null, 0, (4 - localByteVector1.b % 4) % 4);
              int i16 = i4 + a(arrayOfByte1, i15);
              int i17 = i15 + 4;
              localByteVector1.putInt(a((int[])localObject1, (int[])localObject2, i4, i16));
              int i18 = a(arrayOfByte1, i17);
              int i19 = i17 + 4;
              localByteVector1.putInt(i18);
              i20 = i19;
              int i21 = i18;
              while (i21 > 0)
              {
                localByteVector1.putInt(a(arrayOfByte1, i20));
                int i22 = i20 + 4;
                int i23 = i4 + a(arrayOfByte1, i22);
                int i24 = i22 + 4;
                localByteVector1.putInt(a((int[])localObject1, (int[])localObject2, i4, i23));
                i21--;
                i20 = i24;
              }
            case 17:
              if ((0xFF & arrayOfByte1[(i4 + 1)]) == 132)
              {
                localByteVector1.putByteArray(arrayOfByte1, i4, 6);
                i4 += 6;
                continue;
              }
              localByteVector1.putByteArray(arrayOfByte1, i4, 4);
              i4 += 4;
              break;
            case 1:
            case 3:
            case 11:
              localByteVector1.putByteArray(arrayOfByte1, i4, 2);
              i4 += 2;
              break;
            case 2:
            case 5:
            case 6:
            case 12:
            case 13:
              localByteVector1.putByteArray(arrayOfByte1, i4, 3);
              i4 += 3;
              break;
            case 7:
            case 8:
              label898: label938: localByteVector1.putByteArray(arrayOfByte1, i4, 5);
              i4 += 5;
              break;
            }
          }
          else
          {
            if (this.M == 0)
            {
              for (Label localLabel = this.N; localLabel != null; localLabel = localLabel.i)
              {
                int i13 = -3 + localLabel.c;
                if ((i13 >= 0) && (arrayOfBoolean[i13] != 0))
                  localLabel.a = (0x10 | localLabel.a);
                a((int[])localObject1, (int[])localObject2, localLabel);
              }
              if (this.b.H != null)
                for (int i12 = 0; i12 < this.b.H.length; i12++)
                {
                  Item localItem = this.b.H[i12];
                  if ((localItem != null) && (localItem.b == 31))
                    localItem.c = a((int[])localObject1, (int[])localObject2, 0, localItem.c);
                }
            }
            else if (this.u > 0)
            {
              this.b.L = true;
            }
            for (Handler localHandler = this.B; localHandler != null; localHandler = localHandler.f)
            {
              a((int[])localObject1, (int[])localObject2, localHandler.a);
              a((int[])localObject1, (int[])localObject2, localHandler.b);
              a((int[])localObject1, (int[])localObject2, localHandler.c);
            }
            for (int i5 = 0; i5 < 2; i5++)
            {
              if (i5 == 0);
              for (ByteVector localByteVector2 = this.E; localByteVector2 != null; localByteVector2 = this.G)
              {
                byte[] arrayOfByte3 = localByteVector2.a;
                for (int i8 = 0; i8 < localByteVector2.b; i8 += 10)
                {
                  int i9 = c(arrayOfByte3, i8);
                  int i10 = a((int[])localObject1, (int[])localObject2, 0, i9);
                  a(arrayOfByte3, i8, i10);
                  int i11 = a((int[])localObject1, (int[])localObject2, 0, i9 + c(arrayOfByte3, i8 + 2)) - i10;
                  a(arrayOfByte3, i8 + 2, i11);
                }
              }
            }
            if (this.I != null)
            {
              byte[] arrayOfByte2 = this.I.a;
              for (int i7 = 0; i7 < this.I.b; i7 += 4)
                a(arrayOfByte2, i7, a((int[])localObject1, (int[])localObject2, 0, c(arrayOfByte2, i7)));
            }
            for (Attribute localAttribute = this.J; localAttribute != null; localAttribute = localAttribute.a)
            {
              Label[] arrayOfLabel = localAttribute.getLabels();
              if (arrayOfLabel != null)
                for (int i6 = -1 + arrayOfLabel.length; i6 >= 0; i6--)
                  a((int[])localObject1, (int[])localObject2, arrayOfLabel[i6]);
            }
            this.r = localByteVector1;
            return;
            i4 = i20;
          }
        }
      }
      i1 = i2;
      break;
      label2007: localObject2 = arrayOfInt2;
      localObject1 = arrayOfInt1;
      break label46;
      label2016: i50 = 0;
    }
  }

  private void e()
  {
    if (this.M == 0)
    {
      Label localLabel = new Label();
      localLabel.h = new Frame();
      localLabel.h.b = localLabel;
      localLabel.a(this, this.r.b, this.r.a);
      this.O.i = localLabel;
      this.O = localLabel;
    }
    while (true)
    {
      this.P = null;
      return;
      this.P.g = this.R;
    }
  }

  private void f()
  {
    int i1 = a(0, 1 + this.f.length(), 0);
    int i2;
    if ((0x8 & this.c) == 0)
      if ((0x80000 & this.c) == 0)
      {
        int[] arrayOfInt8 = this.z;
        i2 = i1 + 1;
        arrayOfInt8[i1] = (0x1700000 | this.b.c(this.b.I));
      }
    while (true)
    {
      int i3 = i2;
      int i4 = 1;
      while (true)
      {
        String str1 = this.f;
        int i5 = i4 + 1;
        switch (str1.charAt(i4))
        {
        default:
          this.z[1] = (i3 - 3);
          b();
          return;
          int[] arrayOfInt7 = this.z;
          i2 = i1 + 1;
          arrayOfInt7[i1] = 6;
          break;
        case 'B':
        case 'C':
        case 'I':
        case 'S':
        case 'Z':
          int[] arrayOfInt6 = this.z;
          int i13 = i3 + 1;
          arrayOfInt6[i3] = 1;
          i3 = i13;
          i4 = i5;
          break;
        case 'F':
          int[] arrayOfInt5 = this.z;
          int i12 = i3 + 1;
          arrayOfInt5[i3] = 2;
          i3 = i12;
          i4 = i5;
          break;
        case 'J':
          int[] arrayOfInt4 = this.z;
          int i11 = i3 + 1;
          arrayOfInt4[i3] = 4;
          i3 = i11;
          i4 = i5;
          break;
        case 'D':
          int[] arrayOfInt3 = this.z;
          int i10 = i3 + 1;
          arrayOfInt3[i3] = 3;
          i3 = i10;
          i4 = i5;
          break;
        case '[':
          while (this.f.charAt(i5) == '[')
            i5++;
          if (this.f.charAt(i5) == 'L')
          {
            i5++;
            while (this.f.charAt(i5) != ';')
              i5++;
          }
          int[] arrayOfInt2 = this.z;
          int i8 = i3 + 1;
          ClassWriter localClassWriter2 = this.b;
          String str3 = this.f;
          int i9 = i5 + 1;
          arrayOfInt2[i3] = (0x1700000 | localClassWriter2.c(str3.substring(i4, i9)));
          i4 = i9;
          i3 = i8;
          break;
        case 'L':
          while (this.f.charAt(i5) != ';')
            i5++;
          int[] arrayOfInt1 = this.z;
          int i6 = i3 + 1;
          ClassWriter localClassWriter1 = this.b;
          String str2 = this.f;
          int i7 = i4 + 1;
          i4 = i5 + 1;
          arrayOfInt1[i3] = (0x1700000 | localClassWriter1.c(str2.substring(i7, i5)));
          i3 = i6;
        }
      }
      i2 = i1;
    }
  }

  final int a()
  {
    int i3;
    if (this.h != 0)
    {
      i3 = 6 + this.i;
      return i3;
    }
    int i1 = 8;
    int i8;
    int i9;
    String str;
    if (this.r.b > 0)
    {
      if (this.r.b > 65536)
        throw new RuntimeException("Method code too large!");
      this.b.newUTF8("Code");
      i8 = i1 + (18 + this.r.b + 8 * this.A);
      if (this.E != null)
      {
        this.b.newUTF8("LocalVariableTable");
        i8 += 8 + this.E.b;
      }
      if (this.G != null)
      {
        this.b.newUTF8("LocalVariableTypeTable");
        i8 += 8 + this.G.b;
      }
      if (this.I != null)
      {
        this.b.newUTF8("LineNumberTable");
        i8 += 8 + this.I.b;
      }
      if (this.v != null)
      {
        if ((0xFFFF & this.b.b) < 50)
          break label761;
        i9 = 1;
        ClassWriter localClassWriter = this.b;
        if (i9 == 0)
          break label767;
        str = "StackMapTable";
        label227: localClassWriter.newUTF8(str);
        i8 += 8 + this.v.b;
      }
      if (this.W != null)
      {
        this.b.newUTF8("RuntimeVisibleTypeAnnotations");
        i8 += 8 + this.W.a();
      }
      if (this.X == null)
        break label912;
      this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
    }
    label912: for (i1 = i8 + (8 + this.X.a()); ; i1 = i8)
    {
      if (this.J != null)
        i1 += this.J.a(this.b, this.r.a, this.r.b, this.s, this.t);
      if (this.j > 0)
      {
        this.b.newUTF8("Exceptions");
        i1 += 8 + 2 * this.j;
      }
      if (((0x1000 & this.c) != 0) && (((0xFFFF & this.b.b) < 49) || ((0x40000 & this.c) != 0)))
      {
        this.b.newUTF8("Synthetic");
        i1 += 6;
      }
      if ((0x20000 & this.c) != 0)
      {
        this.b.newUTF8("Deprecated");
        i1 += 6;
      }
      if (this.g != null)
      {
        this.b.newUTF8("Signature");
        this.b.newUTF8(this.g);
        i1 += 8;
      }
      if (this.$ != null)
      {
        this.b.newUTF8("MethodParameters");
        i1 += 7 + this.$.b;
      }
      if (this.l != null)
      {
        this.b.newUTF8("AnnotationDefault");
        i1 += 6 + this.l.b;
      }
      if (this.m != null)
      {
        this.b.newUTF8("RuntimeVisibleAnnotations");
        i1 += 8 + this.m.a();
      }
      if (this.n != null)
      {
        this.b.newUTF8("RuntimeInvisibleAnnotations");
        i1 += 8 + this.n.a();
      }
      if (this.U != null)
      {
        this.b.newUTF8("RuntimeVisibleTypeAnnotations");
        i1 += 8 + this.U.a();
      }
      if (this.V != null)
      {
        this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
        i1 += 8 + this.V.a();
      }
      int i2;
      if (this.o != null)
      {
        this.b.newUTF8("RuntimeVisibleParameterAnnotations");
        i2 = i1 + (7 + 2 * (this.o.length - this.S));
        int i6 = -1 + this.o.length;
        label728: if (i6 >= this.S)
        {
          if (this.o[i6] == null);
          for (int i7 = 0; ; i7 = this.o[i6].a())
          {
            i2 += i7;
            i6--;
            break label728;
            label761: i9 = 0;
            break;
            label767: str = "StackMap";
            break label227;
          }
        }
      }
      else
      {
        i2 = i1;
      }
      if (this.p != null)
      {
        this.b.newUTF8("RuntimeInvisibleParameterAnnotations");
        i2 += 7 + 2 * (this.p.length - this.S);
        int i4 = -1 + this.p.length;
        if (i4 >= this.S)
        {
          if (this.p[i4] == null);
          for (int i5 = 0; ; i5 = this.p[i4].a())
          {
            i2 += i5;
            i4--;
            break;
          }
        }
      }
      i3 = i2;
      if (this.q == null)
        break;
      return i3 + this.q.a(this.b, null, 0, -1, -1);
    }
  }

  final void a(ByteVector paramByteVector)
  {
    int i1 = 1;
    int i2 = 0xE0000 | (0x40000 & this.c) / 64;
    paramByteVector.putShort(this.c & (i2 ^ 0xFFFFFFFF)).putShort(this.d).putShort(this.e);
    if (this.h != 0)
    {
      paramByteVector.putByteArray(this.b.M.b, this.h, this.i);
      return;
    }
    if (this.r.b > 0);
    for (int i3 = i1; ; i3 = 0)
    {
      if (this.j > 0)
        i3++;
      if (((0x1000 & this.c) != 0) && (((0xFFFF & this.b.b) < 49) || ((0x40000 & this.c) != 0)))
        i3++;
      if ((0x20000 & this.c) != 0)
        i3++;
      if (this.g != null)
        i3++;
      if (this.$ != null)
        i3++;
      if (this.l != null)
        i3++;
      if (this.m != null)
        i3++;
      if (this.n != null)
        i3++;
      if (this.U != null)
        i3++;
      if (this.V != null)
        i3++;
      if (this.o != null)
        i3++;
      if (this.p != null)
        i3++;
      if (this.q != null)
        i3 += this.q.a();
      paramByteVector.putShort(i3);
      int i5;
      if (this.r.b > 0)
      {
        i5 = 12 + this.r.b + 8 * this.A;
        if (this.E != null)
          i5 += 8 + this.E.b;
        if (this.G != null)
          i5 += 8 + this.G.b;
        if (this.I != null)
          i5 += 8 + this.I.b;
        if (this.v != null)
          i5 += 8 + this.v.b;
        if (this.W != null)
          i5 += 8 + this.W.a();
        if (this.X == null)
          break label1634;
      }
      label1160: label1165: label1173: label1634: for (int i6 = i5 + (8 + this.X.a()); ; i6 = i5)
      {
        if (this.J != null)
          i6 += this.J.a(this.b, this.r.a, this.r.b, this.s, this.t);
        paramByteVector.putShort(this.b.newUTF8("Code")).putInt(i6);
        paramByteVector.putShort(this.s).putShort(this.t);
        paramByteVector.putInt(this.r.b).putByteArray(this.r.a, 0, this.r.b);
        paramByteVector.putShort(this.A);
        if (this.A > 0)
          for (Handler localHandler = this.B; localHandler != null; localHandler = localHandler.f)
            paramByteVector.putShort(localHandler.a.c).putShort(localHandler.b.c).putShort(localHandler.c.c).putShort(localHandler.e);
        if (this.E != null);
        for (int i7 = i1; ; i7 = 0)
        {
          if (this.G != null)
            i7++;
          if (this.I != null)
            i7++;
          if (this.v != null)
            i7++;
          if (this.W != null)
            i7++;
          if (this.X != null)
            i7++;
          if (this.J != null)
            i7 += this.J.a();
          paramByteVector.putShort(i7);
          if (this.E != null)
          {
            paramByteVector.putShort(this.b.newUTF8("LocalVariableTable"));
            paramByteVector.putInt(2 + this.E.b).putShort(this.D);
            paramByteVector.putByteArray(this.E.a, 0, this.E.b);
          }
          if (this.G != null)
          {
            paramByteVector.putShort(this.b.newUTF8("LocalVariableTypeTable"));
            paramByteVector.putInt(2 + this.G.b).putShort(this.F);
            paramByteVector.putByteArray(this.G.a, 0, this.G.b);
          }
          if (this.I != null)
          {
            paramByteVector.putShort(this.b.newUTF8("LineNumberTable"));
            paramByteVector.putInt(2 + this.I.b).putShort(this.H);
            paramByteVector.putByteArray(this.I.a, 0, this.I.b);
          }
          ClassWriter localClassWriter;
          if (this.v != null)
          {
            if ((0xFFFF & this.b.b) < 50)
              break label1160;
            localClassWriter = this.b;
            if (i1 == 0)
              break label1165;
          }
          for (String str = "StackMapTable"; ; str = "StackMap")
          {
            paramByteVector.putShort(localClassWriter.newUTF8(str));
            paramByteVector.putInt(2 + this.v.b).putShort(this.u);
            paramByteVector.putByteArray(this.v.a, 0, this.v.b);
            if (this.W != null)
            {
              paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
              this.W.a(paramByteVector);
            }
            if (this.X != null)
            {
              paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
              this.X.a(paramByteVector);
            }
            if (this.J != null)
              this.J.a(this.b, this.r.a, this.r.b, this.t, this.s, paramByteVector);
            if (this.j <= 0)
              break label1173;
            paramByteVector.putShort(this.b.newUTF8("Exceptions")).putInt(2 + 2 * this.j);
            paramByteVector.putShort(this.j);
            for (int i4 = 0; i4 < this.j; i4++)
              paramByteVector.putShort(this.k[i4]);
            i1 = 0;
            break;
          }
          if (((0x1000 & this.c) != 0) && (((0xFFFF & this.b.b) < 49) || ((0x40000 & this.c) != 0)))
            paramByteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0);
          if ((0x20000 & this.c) != 0)
            paramByteVector.putShort(this.b.newUTF8("Deprecated")).putInt(0);
          if (this.g != null)
            paramByteVector.putShort(this.b.newUTF8("Signature")).putInt(2).putShort(this.b.newUTF8(this.g));
          if (this.$ != null)
          {
            paramByteVector.putShort(this.b.newUTF8("MethodParameters"));
            paramByteVector.putInt(1 + this.$.b).putByte(this.Z);
            paramByteVector.putByteArray(this.$.a, 0, this.$.b);
          }
          if (this.l != null)
          {
            paramByteVector.putShort(this.b.newUTF8("AnnotationDefault"));
            paramByteVector.putInt(this.l.b);
            paramByteVector.putByteArray(this.l.a, 0, this.l.b);
          }
          if (this.m != null)
          {
            paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleAnnotations"));
            this.m.a(paramByteVector);
          }
          if (this.n != null)
          {
            paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleAnnotations"));
            this.n.a(paramByteVector);
          }
          if (this.U != null)
          {
            paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
            this.U.a(paramByteVector);
          }
          if (this.V != null)
          {
            paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
            this.V.a(paramByteVector);
          }
          if (this.o != null)
          {
            paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleParameterAnnotations"));
            AnnotationWriter.a(this.o, this.S, paramByteVector);
          }
          if (this.p != null)
          {
            paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleParameterAnnotations"));
            AnnotationWriter.a(this.p, this.S, paramByteVector);
          }
          if (this.q == null)
            break;
          this.q.a(this.b, null, 0, -1, -1, paramByteVector);
          return;
        }
      }
    }
  }

  public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    localByteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this.b, true, localByteVector, localByteVector, 2);
    if (paramBoolean)
    {
      localAnnotationWriter.g = this.m;
      this.m = localAnnotationWriter;
      return localAnnotationWriter;
    }
    localAnnotationWriter.g = this.n;
    this.n = localAnnotationWriter;
    return localAnnotationWriter;
  }

  public AnnotationVisitor visitAnnotationDefault()
  {
    this.l = new ByteVector();
    return new AnnotationWriter(this.b, false, this.l, null, 0);
  }

  public void visitAttribute(Attribute paramAttribute)
  {
    if (paramAttribute.isCodeAttribute())
    {
      paramAttribute.a = this.J;
      this.J = paramAttribute;
      return;
    }
    paramAttribute.a = this.q;
    this.q = paramAttribute;
  }

  public void visitCode()
  {
  }

  public void visitEnd()
  {
  }

  public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int i1 = 1;
    int i2 = -2;
    this.Y = this.r.b;
    Item localItem = this.b.a(paramString1, paramString2, paramString3);
    if (this.P != null)
    {
      if (this.M == 0)
        this.P.h.a(paramInt, 0, this.b, localItem);
    }
    else
    {
      this.r.b(paramInt, localItem.a);
      return;
    }
    int i3 = paramString3.charAt(0);
    int i9;
    int i5;
    switch (paramInt)
    {
    default:
      i9 = this.Q;
      if ((i3 == 68) || (i3 == 74))
        i2 = -3;
    case 178:
      int i8;
      for (i5 = i9 + i2; ; i5 = i1 + i8)
      {
        if (i5 > this.R)
          this.R = i5;
        this.Q = i5;
        break;
        i8 = this.Q;
        if ((i3 == 68) || (i3 == 74))
          i1 = 2;
      }
    case 179:
      int i6 = this.Q;
      if ((i3 == 68) || (i3 == 74));
      for (int i7 = i2; ; i7 = -1)
      {
        i5 = i7 + i6;
        break;
      }
    case 180:
    }
    int i4 = this.Q;
    if ((i3 == 68) || (i3 == 74));
    while (true)
    {
      i5 = i1 + i4;
      break;
      i1 = 0;
    }
  }

  public void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2)
  {
    int i1 = 0;
    if (this.M == 0)
      return;
    if (paramInt1 == -1)
    {
      if (this.x == null)
        f();
      this.T = paramInt2;
      int i5 = a(this.r.b, paramInt2, paramInt3);
      int i6 = 0;
      int i7 = 0;
      if (i6 < paramInt2)
      {
        int i13;
        if ((paramArrayOfObject1[i6] instanceof String))
        {
          int[] arrayOfInt6 = this.z;
          int i15 = i5 + 1;
          arrayOfInt6[i5] = (0x1700000 | this.b.c((String)paramArrayOfObject1[i6]));
          i13 = i15;
        }
        while (true)
        {
          i6++;
          i5 = i13;
          break;
          if ((paramArrayOfObject1[i6] instanceof Integer))
          {
            int[] arrayOfInt5 = this.z;
            int i14 = i5 + 1;
            arrayOfInt5[i5] = ((Integer)paramArrayOfObject1[i6]).intValue();
            i13 = i14;
          }
          else
          {
            int[] arrayOfInt4 = this.z;
            int i12 = i5 + 1;
            arrayOfInt4[i5] = (0x1800000 | this.b.a("", ((Label)paramArrayOfObject1[i6]).c));
            i13 = i12;
          }
        }
      }
      if (i7 < paramInt3)
      {
        int i9;
        if ((paramArrayOfObject2[i7] instanceof String))
        {
          int[] arrayOfInt3 = this.z;
          int i11 = i5 + 1;
          arrayOfInt3[i5] = (0x1700000 | this.b.c((String)paramArrayOfObject2[i7]));
          i9 = i11;
        }
        while (true)
        {
          i7++;
          i5 = i9;
          break;
          if ((paramArrayOfObject2[i7] instanceof Integer))
          {
            int[] arrayOfInt2 = this.z;
            int i10 = i5 + 1;
            arrayOfInt2[i5] = ((Integer)paramArrayOfObject2[i7]).intValue();
            i9 = i10;
          }
          else
          {
            int[] arrayOfInt1 = this.z;
            int i8 = i5 + 1;
            arrayOfInt1[i5] = (0x1800000 | this.b.a("", ((Label)paramArrayOfObject2[i7]).c));
            i9 = i8;
          }
        }
      }
      b();
      label376: this.s = Math.max(this.s, paramInt3);
      this.t = Math.max(this.t, this.T);
      return;
    }
    int i2;
    if (this.v == null)
    {
      this.v = new ByteVector();
      i2 = this.r.b;
    }
    switch (paramInt1)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
      while (true)
      {
        label432: this.w = this.r.b;
        this.u = (1 + this.u);
        break label376;
        i2 = -1 + (this.r.b - this.w);
        if (i2 >= 0)
          break label432;
        if (paramInt1 == 3)
          break;
        throw new IllegalStateException();
        this.T = paramInt2;
        this.v.putByte(255).putShort(i2).putShort(paramInt2);
        for (int i4 = 0; i4 < paramInt2; i4++)
          a(paramArrayOfObject1[i4]);
        this.v.putShort(paramInt3);
        while (i1 < paramInt3)
        {
          a(paramArrayOfObject2[i1]);
          i1++;
        }
        this.T = (paramInt2 + this.T);
        this.v.putByte(paramInt2 + 251).putShort(i2);
        for (int i3 = 0; i3 < paramInt2; i3++)
          a(paramArrayOfObject1[i3]);
        this.T -= paramInt2;
        this.v.putByte(251 - paramInt2).putShort(i2);
        continue;
        if (i2 < 64)
          this.v.putByte(i2);
        else
          this.v.putByte(251).putShort(i2);
      }
    case 4:
    }
    if (i2 < 64)
      this.v.putByte(i2 + 64);
    while (true)
    {
      a(paramArrayOfObject2[0]);
      break;
      this.v.putByte(247).putShort(i2);
    }
  }

  public void visitIincInsn(int paramInt1, int paramInt2)
  {
    this.Y = this.r.b;
    if ((this.P != null) && (this.M == 0))
      this.P.h.a(132, paramInt1, null, null);
    if (this.M != 2)
    {
      int i1 = paramInt1 + 1;
      if (i1 > this.t)
        this.t = i1;
    }
    if ((paramInt1 > 255) || (paramInt2 > 127) || (paramInt2 < -128))
    {
      this.r.putByte(196).b(132, paramInt1).putShort(paramInt2);
      return;
    }
    this.r.putByte(132).a(paramInt1, paramInt2);
  }

  public void visitInsn(int paramInt)
  {
    this.Y = this.r.b;
    this.r.putByte(paramInt);
    if (this.P != null)
    {
      if (this.M != 0)
        break label74;
      this.P.h.a(paramInt, 0, null, null);
    }
    while (true)
    {
      if (((paramInt >= 172) && (paramInt <= 177)) || (paramInt == 191))
        e();
      return;
      label74: int i1 = this.Q + Frame.a[paramInt];
      if (i1 > this.R)
        this.R = i1;
      this.Q = i1;
    }
  }

  public AnnotationVisitor visitInsnAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    AnnotationWriter.a(0xFF0000FF & paramInt | this.Y << 8, paramTypePath, localByteVector);
    localByteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this.b, true, localByteVector, localByteVector, -2 + localByteVector.b);
    if (paramBoolean)
    {
      localAnnotationWriter.g = this.W;
      this.W = localAnnotationWriter;
      return localAnnotationWriter;
    }
    localAnnotationWriter.g = this.X;
    this.X = localAnnotationWriter;
    return localAnnotationWriter;
  }

  public void visitIntInsn(int paramInt1, int paramInt2)
  {
    this.Y = this.r.b;
    if (this.P != null)
    {
      if (this.M != 0)
        break label56;
      this.P.h.a(paramInt1, paramInt2, null, null);
    }
    while (paramInt1 == 17)
    {
      this.r.b(paramInt1, paramInt2);
      return;
      label56: if (paramInt1 != 188)
      {
        int i1 = 1 + this.Q;
        if (i1 > this.R)
          this.R = i1;
        this.Q = i1;
      }
    }
    this.r.a(paramInt1, paramInt2);
  }

  public void visitInvokeDynamicInsn(String paramString1, String paramString2, Handle paramHandle, Object[] paramArrayOfObject)
  {
    this.Y = this.r.b;
    Item localItem = this.b.a(paramString1, paramString2, paramHandle, paramArrayOfObject);
    int i1 = localItem.c;
    if (this.P != null)
    {
      if (this.M != 0)
        break label92;
      this.P.h.a(186, 0, this.b, localItem);
    }
    while (true)
    {
      this.r.b(186, localItem.a);
      this.r.putShort(0);
      return;
      label92: if (i1 == 0)
      {
        i1 = Type.getArgumentsAndReturnSizes(paramString2);
        localItem.c = i1;
      }
      int i2 = 1 + (this.Q - (i1 >> 2) + (i1 & 0x3));
      if (i2 > this.R)
        this.R = i2;
      this.Q = i2;
    }
  }

  public void visitJumpInsn(int paramInt, Label paramLabel)
  {
    this.Y = this.r.b;
    Label localLabel1 = this.P;
    Label localLabel2 = null;
    if (localLabel1 != null)
    {
      if (this.M != 0)
        break label182;
      this.P.h.a(paramInt, 0, null, null);
      Label localLabel4 = paramLabel.a();
      localLabel4.a = (0x10 | localLabel4.a);
      a(0, paramLabel);
      localLabel2 = null;
      if (paramInt != 167)
        localLabel2 = new Label();
    }
    if (((0x2 & paramLabel.a) != 0) && (paramLabel.c - this.r.b < -32768))
      if (paramInt == 167)
      {
        this.r.putByte(200);
        label133: paramLabel.a(this, this.r, -1 + this.r.b, true);
      }
    while (true)
    {
      if (this.P != null)
      {
        if (localLabel2 != null)
          visitLabel(localLabel2);
        if (paramInt == 167)
          e();
      }
      return;
      label182: if (paramInt == 168)
      {
        if ((0x200 & paramLabel.a) == 0)
        {
          paramLabel.a = (0x200 | paramLabel.a);
          this.L = (1 + this.L);
        }
        Label localLabel3 = this.P;
        localLabel3.a = (0x80 | localLabel3.a);
        a(1 + this.Q, paramLabel);
        localLabel2 = new Label();
        break;
      }
      this.Q += Frame.a[paramInt];
      a(this.Q, paramLabel);
      localLabel2 = null;
      break;
      if (paramInt == 168)
      {
        this.r.putByte(201);
        break label133;
      }
      if (localLabel2 != null)
        localLabel2.a = (0x10 | localLabel2.a);
      ByteVector localByteVector = this.r;
      if (paramInt <= 166);
      for (int i1 = -1 + (0x1 ^ paramInt + 1); ; i1 = paramInt ^ 0x1)
      {
        localByteVector.putByte(i1);
        this.r.putShort(8);
        this.r.putByte(200);
        break;
      }
      this.r.putByte(paramInt);
      paramLabel.a(this, this.r, -1 + this.r.b, false);
    }
  }

  public void visitLabel(Label paramLabel)
  {
    this.K |= paramLabel.a(this, this.r.b, this.r.a);
    if ((0x1 & paramLabel.a) != 0);
    do
    {
      return;
      if (this.M == 0)
      {
        if (this.P != null)
        {
          if (paramLabel.c == this.P.c)
          {
            Label localLabel2 = this.P;
            localLabel2.a |= 0x10 & paramLabel.a;
            paramLabel.h = this.P.h;
            return;
          }
          a(0, paramLabel);
        }
        this.P = paramLabel;
        if (paramLabel.h == null)
        {
          paramLabel.h = new Frame();
          paramLabel.h.b = paramLabel;
        }
        if (this.O != null)
        {
          if (paramLabel.c == this.O.c)
          {
            Label localLabel1 = this.O;
            localLabel1.a |= 0x10 & paramLabel.a;
            paramLabel.h = this.O.h;
            this.P = this.O;
            return;
          }
          this.O.i = paramLabel;
        }
        this.O = paramLabel;
        return;
      }
    }
    while (this.M != 1);
    if (this.P != null)
    {
      this.P.g = this.R;
      a(this.Q, paramLabel);
    }
    this.P = paramLabel;
    this.Q = 0;
    this.R = 0;
    if (this.O != null)
      this.O.i = paramLabel;
    this.O = paramLabel;
  }

  public void visitLdcInsn(Object paramObject)
  {
    this.Y = this.r.b;
    Item localItem = this.b.a(paramObject);
    int i1;
    if (this.P != null)
    {
      if (this.M == 0)
        this.P.h.a(18, 0, this.b, localItem);
    }
    else
    {
      i1 = localItem.a;
      if ((localItem.b != 5) && (localItem.b != 6))
        break label146;
      this.r.b(20, i1);
      return;
    }
    if ((localItem.b == 5) || (localItem.b == 6));
    for (int i2 = 2 + this.Q; ; i2 = 1 + this.Q)
    {
      if (i2 > this.R)
        this.R = i2;
      this.Q = i2;
      break;
    }
    label146: if (i1 >= 256)
    {
      this.r.b(19, i1);
      return;
    }
    this.r.a(18, i1);
  }

  public void visitLineNumber(int paramInt, Label paramLabel)
  {
    if (this.I == null)
      this.I = new ByteVector();
    this.H = (1 + this.H);
    this.I.putShort(paramLabel.c);
    this.I.putShort(paramInt);
  }

  public void visitLocalVariable(String paramString1, String paramString2, String paramString3, Label paramLabel1, Label paramLabel2, int paramInt)
  {
    int i1 = 2;
    if (paramString3 != null)
    {
      if (this.G == null)
        this.G = new ByteVector();
      this.F = (1 + this.F);
      this.G.putShort(paramLabel1.c).putShort(paramLabel2.c - paramLabel1.c).putShort(this.b.newUTF8(paramString1)).putShort(this.b.newUTF8(paramString3)).putShort(paramInt);
    }
    if (this.E == null)
      this.E = new ByteVector();
    this.D = (1 + this.D);
    this.E.putShort(paramLabel1.c).putShort(paramLabel2.c - paramLabel1.c).putShort(this.b.newUTF8(paramString1)).putShort(this.b.newUTF8(paramString2)).putShort(paramInt);
    if (this.M != i1)
    {
      int i2 = paramString2.charAt(0);
      if ((i2 != 74) && (i2 != 68))
        break label224;
    }
    while (true)
    {
      int i3 = i1 + paramInt;
      if (i3 > this.t)
        this.t = i3;
      return;
      label224: i1 = 1;
    }
  }

  public AnnotationVisitor visitLocalVariableAnnotation(int paramInt, TypePath paramTypePath, Label[] paramArrayOfLabel1, Label[] paramArrayOfLabel2, int[] paramArrayOfInt, String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    localByteVector.putByte(paramInt >>> 24).putShort(paramArrayOfLabel1.length);
    for (int i1 = 0; i1 < paramArrayOfLabel1.length; i1++)
      localByteVector.putShort(paramArrayOfLabel1[i1].c).putShort(paramArrayOfLabel2[i1].c - paramArrayOfLabel1[i1].c).putShort(paramArrayOfInt[i1]);
    if (paramTypePath == null)
      localByteVector.putByte(0);
    AnnotationWriter localAnnotationWriter;
    while (true)
    {
      localByteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
      localAnnotationWriter = new AnnotationWriter(this.b, true, localByteVector, localByteVector, -2 + localByteVector.b);
      if (!paramBoolean)
        break;
      localAnnotationWriter.g = this.W;
      this.W = localAnnotationWriter;
      return localAnnotationWriter;
      int i2 = 1 + 2 * paramTypePath.a[paramTypePath.b];
      localByteVector.putByteArray(paramTypePath.a, paramTypePath.b, i2);
    }
    localAnnotationWriter.g = this.X;
    this.X = localAnnotationWriter;
    return localAnnotationWriter;
  }

  public void visitLookupSwitchInsn(Label paramLabel, int[] paramArrayOfInt, Label[] paramArrayOfLabel)
  {
    int i1 = 0;
    this.Y = this.r.b;
    int i2 = this.r.b;
    this.r.putByte(171);
    this.r.putByteArray(null, 0, (4 - this.r.b % 4) % 4);
    paramLabel.a(this, this.r, i2, true);
    this.r.putInt(paramArrayOfLabel.length);
    while (i1 < paramArrayOfLabel.length)
    {
      this.r.putInt(paramArrayOfInt[i1]);
      paramArrayOfLabel[i1].a(this, this.r, i2, true);
      i1++;
    }
    a(paramLabel, paramArrayOfLabel);
  }

  public void visitMaxs(int paramInt1, int paramInt2)
  {
    if (this.K)
      d();
    Object localObject4;
    int i6;
    Object localObject5;
    Frame localFrame3;
    int i13;
    if (this.M == 0)
    {
      for (Handler localHandler2 = this.B; localHandler2 != null; localHandler2 = localHandler2.f)
      {
        Label localLabel11 = localHandler2.a.a();
        Label localLabel12 = localHandler2.c.a();
        Label localLabel13 = localHandler2.b.a();
        if (localHandler2.d == null);
        for (String str = "java/lang/Throwable"; ; str = localHandler2.d)
        {
          int i14 = 0x1700000 | this.b.c(str);
          localLabel12.a = (0x10 | localLabel12.a);
          for (Label localLabel14 = localLabel11; localLabel14 != localLabel13; localLabel14 = localLabel14.i)
          {
            Edge localEdge5 = new Edge();
            localEdge5.a = i14;
            localEdge5.b = localLabel12;
            localEdge5.c = localLabel14.j;
            localLabel14.j = localEdge5;
          }
        }
      }
      Frame localFrame1 = this.N.h;
      Type[] arrayOfType = Type.getArgumentTypes(this.f);
      localFrame1.a(this.b, this.c, arrayOfType, this.t);
      b(localFrame1);
      localObject4 = this.N;
      i6 = 0;
      if (localObject4 != null)
      {
        localObject5 = ((Label)localObject4).k;
        ((Label)localObject4).k = null;
        localFrame3 = ((Label)localObject4).h;
        if ((0x10 & ((Label)localObject4).a) != 0)
          ((Label)localObject4).a = (0x20 | ((Label)localObject4).a);
        ((Label)localObject4).a = (0x40 | ((Label)localObject4).a);
        i13 = localFrame3.d.length + ((Label)localObject4).g;
        if (i13 <= i6)
          break label1223;
      }
    }
    while (true)
    {
      Edge localEdge4 = ((Label)localObject4).j;
      label322: Object localObject6;
      if (localEdge4 != null)
      {
        localObject6 = localEdge4.b.a();
        if ((!localFrame3.a(this.b, ((Label)localObject6).h, localEdge4.a)) || (((Label)localObject6).k != null))
          break label1216;
        ((Label)localObject6).k = ((Label)localObject5);
      }
      while (true)
      {
        localEdge4 = localEdge4.c;
        localObject5 = localObject6;
        break label322;
        localObject4 = localObject5;
        i6 = i13;
        break;
        Label localLabel9 = this.N;
        int i7 = i6;
        while (localLabel9 != null)
        {
          Frame localFrame2 = localLabel9.h;
          if ((0x20 & localLabel9.a) != 0)
            b(localFrame2);
          if ((0x40 & localLabel9.a) == 0)
          {
            Label localLabel10 = localLabel9.i;
            int i8 = localLabel9.c;
            if (localLabel10 == null);
            int i10;
            for (int i9 = this.r.b; ; i9 = localLabel10.c)
            {
              i10 = i9 - 1;
              if (i10 < i8)
                break label597;
              i7 = Math.max(i7, 1);
              for (int i11 = i8; i11 < i10; i11++)
                this.r.a[i11] = 0;
            }
            this.r.a[i10] = -65;
            int i12 = a(i8, 0, 1);
            this.z[i12] = (0x1700000 | this.b.c("java/lang/Throwable"));
            b();
            this.B = Handler.a(this.B, localLabel9, localLabel10);
          }
          label597: localLabel9 = localLabel9.i;
        }
        Handler localHandler3 = this.B;
        this.A = 0;
        while (localHandler3 != null)
        {
          this.A = (1 + this.A);
          localHandler3 = localHandler3.f;
        }
        this.s = i7;
        return;
        Object localObject1;
        int i1;
        Object localObject2;
        int i2;
        int i3;
        if (this.M == 1)
        {
          for (Handler localHandler1 = this.B; localHandler1 != null; localHandler1 = localHandler1.f)
          {
            Label localLabel6 = localHandler1.a;
            Label localLabel7 = localHandler1.c;
            Label localLabel8 = localHandler1.b;
            if (localLabel6 != localLabel8)
            {
              Edge localEdge3 = new Edge();
              localEdge3.a = 2147483647;
              localEdge3.b = localLabel7;
              if ((0x80 & localLabel6.a) == 0)
              {
                localEdge3.c = localLabel6.j;
                localLabel6.j = localEdge3;
              }
              while (true)
              {
                localLabel6 = localLabel6.i;
                break;
                localEdge3.c = localLabel6.j.c.c;
                localLabel6.j.c.c = localEdge3;
              }
            }
          }
          if (this.L > 0)
          {
            this.N.b(null, 1L, this.L);
            Label localLabel2 = this.N;
            int i5 = 0;
            while (localLabel2 != null)
            {
              if ((0x80 & localLabel2.a) != 0)
              {
                Label localLabel5 = localLabel2.j.c.b;
                if ((0x400 & localLabel5.a) == 0)
                {
                  i5++;
                  localLabel5.b(null, i5 / 32L << 32 | 1L << i5 % 32, this.L);
                }
              }
              localLabel2 = localLabel2.i;
            }
            for (Label localLabel3 = this.N; localLabel3 != null; localLabel3 = localLabel3.i)
              if ((0x80 & localLabel3.a) != 0)
              {
                for (Label localLabel4 = this.N; localLabel4 != null; localLabel4 = localLabel4.i)
                  localLabel4.a = (0xFFFFF7FF & localLabel4.a);
                localLabel3.j.c.b.b(localLabel3, 0L, this.L);
              }
          }
          localObject1 = this.N;
          i1 = 0;
          if (localObject1 != null)
          {
            localObject2 = ((Label)localObject1).k;
            i2 = ((Label)localObject1).f;
            i3 = i2 + ((Label)localObject1).g;
            if (i3 <= i1)
              break label1209;
          }
        }
        while (true)
        {
          Edge localEdge1 = ((Label)localObject1).j;
          Edge localEdge2;
          if ((0x80 & ((Label)localObject1).a) != 0)
            localEdge2 = localEdge1.c;
          while (true)
          {
            label1067: Label localLabel1;
            int i4;
            if (localEdge2 != null)
            {
              localLabel1 = localEdge2.b;
              if ((0x8 & localLabel1.a) != 0)
                break label1195;
              if (localEdge2.a == 2147483647)
              {
                i4 = 1;
                label1104: localLabel1.f = i4;
                localLabel1.a = (0x8 | localLabel1.a);
                localLabel1.k = ((Label)localObject2);
              }
            }
            label1195: for (Object localObject3 = localLabel1; ; localObject3 = localObject2)
            {
              localEdge2 = localEdge2.c;
              localObject2 = localObject3;
              break label1067;
              i4 = i2 + localEdge2.a;
              break label1104;
              localObject1 = localObject2;
              i1 = i3;
              break;
              this.s = Math.max(paramInt1, i1);
              return;
              this.s = paramInt1;
              this.t = paramInt2;
              return;
            }
            localEdge2 = localEdge1;
          }
          label1209: i3 = i1;
        }
        label1216: localObject6 = localObject5;
      }
      label1223: i13 = i6;
    }
  }

  public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.Y = this.r.b;
    Item localItem = this.b.a(paramString1, paramString2, paramString3, paramBoolean);
    int i1 = localItem.c;
    if (this.P != null)
    {
      if (this.M == 0)
        this.P.h.a(paramInt, 0, this.b, localItem);
    }
    else
    {
      if (paramInt != 185)
        break label207;
      if (i1 == 0)
      {
        i1 = Type.getArgumentsAndReturnSizes(paramString3);
        localItem.c = i1;
      }
      this.r.b(185, localItem.a).a(i1 >> 2, 0);
      return;
    }
    int i2;
    if (i1 == 0)
    {
      i2 = Type.getArgumentsAndReturnSizes(paramString3);
      localItem.c = i2;
    }
    while (true)
    {
      if (paramInt == 184);
      for (int i3 = 1 + (this.Q - (i2 >> 2) + (i2 & 0x3)); ; i3 = this.Q - (i2 >> 2) + (i2 & 0x3))
      {
        if (i3 > this.R)
          this.R = i3;
        this.Q = i3;
        i1 = i2;
        break;
      }
      label207: this.r.b(paramInt, localItem.a);
      return;
      i2 = i1;
    }
  }

  public void visitMultiANewArrayInsn(String paramString, int paramInt)
  {
    this.Y = this.r.b;
    Item localItem = this.b.a(paramString);
    if (this.P != null)
    {
      if (this.M != 0)
        break label73;
      this.P.h.a(197, paramInt, this.b, localItem);
    }
    while (true)
    {
      this.r.b(197, localItem.a).putByte(paramInt);
      return;
      label73: this.Q += 1 - paramInt;
    }
  }

  public void visitParameter(String paramString, int paramInt)
  {
    if (this.$ == null)
      this.$ = new ByteVector();
    this.Z = (1 + this.Z);
    ByteVector localByteVector = this.$;
    if (paramString == null);
    for (int i1 = 0; ; i1 = this.b.newUTF8(paramString))
    {
      localByteVector.putShort(i1).putShort(paramInt);
      return;
    }
  }

  public AnnotationVisitor visitParameterAnnotation(int paramInt, String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    if ("Ljava/lang/Synthetic;".equals(paramString))
    {
      this.S = Math.max(this.S, paramInt + 1);
      return new AnnotationWriter(this.b, false, localByteVector, null, 0);
    }
    localByteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this.b, true, localByteVector, localByteVector, 2);
    if (paramBoolean)
    {
      if (this.o == null)
        this.o = new AnnotationWriter[Type.getArgumentTypes(this.f).length];
      localAnnotationWriter.g = this.o[paramInt];
      this.o[paramInt] = localAnnotationWriter;
      return localAnnotationWriter;
    }
    if (this.p == null)
      this.p = new AnnotationWriter[Type.getArgumentTypes(this.f).length];
    localAnnotationWriter.g = this.p[paramInt];
    this.p[paramInt] = localAnnotationWriter;
    return localAnnotationWriter;
  }

  public void visitTableSwitchInsn(int paramInt1, int paramInt2, Label paramLabel, Label[] paramArrayOfLabel)
  {
    int i1 = 0;
    this.Y = this.r.b;
    int i2 = this.r.b;
    this.r.putByte(170);
    this.r.putByteArray(null, 0, (4 - this.r.b % 4) % 4);
    paramLabel.a(this, this.r, i2, true);
    this.r.putInt(paramInt1).putInt(paramInt2);
    while (i1 < paramArrayOfLabel.length)
    {
      paramArrayOfLabel[i1].a(this, this.r, i2, true);
      i1++;
    }
    a(paramLabel, paramArrayOfLabel);
  }

  public AnnotationVisitor visitTryCatchAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    AnnotationWriter.a(paramInt, paramTypePath, localByteVector);
    localByteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this.b, true, localByteVector, localByteVector, -2 + localByteVector.b);
    if (paramBoolean)
    {
      localAnnotationWriter.g = this.W;
      this.W = localAnnotationWriter;
      return localAnnotationWriter;
    }
    localAnnotationWriter.g = this.X;
    this.X = localAnnotationWriter;
    return localAnnotationWriter;
  }

  public void visitTryCatchBlock(Label paramLabel1, Label paramLabel2, Label paramLabel3, String paramString)
  {
    this.A = (1 + this.A);
    Handler localHandler = new Handler();
    localHandler.a = paramLabel1;
    localHandler.b = paramLabel2;
    localHandler.c = paramLabel3;
    localHandler.d = paramString;
    int i1;
    if (paramString != null)
    {
      i1 = this.b.newClass(paramString);
      localHandler.e = i1;
      if (this.C != null)
        break label93;
      this.B = localHandler;
    }
    while (true)
    {
      this.C = localHandler;
      return;
      i1 = 0;
      break;
      label93: this.C.f = localHandler;
    }
  }

  public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    AnnotationWriter.a(paramInt, paramTypePath, localByteVector);
    localByteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this.b, true, localByteVector, localByteVector, -2 + localByteVector.b);
    if (paramBoolean)
    {
      localAnnotationWriter.g = this.U;
      this.U = localAnnotationWriter;
      return localAnnotationWriter;
    }
    localAnnotationWriter.g = this.V;
    this.V = localAnnotationWriter;
    return localAnnotationWriter;
  }

  public void visitTypeInsn(int paramInt, String paramString)
  {
    this.Y = this.r.b;
    Item localItem = this.b.a(paramString);
    if (this.P != null)
    {
      if (this.M != 0)
        break label71;
      this.P.h.a(paramInt, this.r.b, this.b, localItem);
    }
    while (true)
    {
      this.r.b(paramInt, localItem.a);
      return;
      label71: if (paramInt == 187)
      {
        int i1 = 1 + this.Q;
        if (i1 > this.R)
          this.R = i1;
        this.Q = i1;
      }
    }
  }

  public void visitVarInsn(int paramInt1, int paramInt2)
  {
    this.Y = this.r.b;
    int i2;
    label76: int i1;
    if (this.P != null)
    {
      if (this.M == 0)
        this.P.h.a(paramInt1, paramInt2, null, null);
    }
    else
    {
      if (this.M != 2)
      {
        if ((paramInt1 != 22) && (paramInt1 != 24) && (paramInt1 != 55) && (paramInt1 != 57))
          break label245;
        i2 = paramInt2 + 2;
        if (i2 > this.t)
          this.t = i2;
      }
      if ((paramInt2 >= 4) || (paramInt1 == 169))
        break label269;
      if (paramInt1 >= 54)
        break label253;
      i1 = paramInt2 + (26 + (paramInt1 - 21 << 2));
      label122: this.r.putByte(i1);
    }
    while (true)
    {
      if ((paramInt1 >= 54) && (this.M == 0) && (this.A > 0))
        visitLabel(new Label());
      return;
      if (paramInt1 == 169)
      {
        Label localLabel = this.P;
        localLabel.a = (0x100 | localLabel.a);
        this.P.f = this.Q;
        e();
        break;
      }
      int i3 = this.Q + Frame.a[paramInt1];
      if (i3 > this.R)
        this.R = i3;
      this.Q = i3;
      break;
      label245: i2 = paramInt2 + 1;
      break label76;
      label253: i1 = paramInt2 + (59 + (paramInt1 - 54 << 2));
      break label122;
      label269: if (paramInt2 >= 256)
        this.r.putByte(196).b(paramInt1, paramInt2);
      else
        this.r.a(paramInt1, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.MethodWriter
 * JD-Core Version:    0.6.2
 */