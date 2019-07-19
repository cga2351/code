package org.objectweb.asm;

public class ClassWriter extends ClassVisitor
{
  public static final int COMPUTE_FRAMES = 2;
  public static final int COMPUTE_MAXS = 1;
  static final byte[] a = arrayOfByte;
  ByteVector A;
  FieldWriter B;
  FieldWriter C;
  MethodWriter D;
  MethodWriter E;
  private short G;
  Item[] H;
  String I;
  private boolean J;
  private boolean K;
  boolean L;
  ClassReader M;
  private AnnotationWriter N;
  private AnnotationWriter O;
  int b;
  int c;
  final ByteVector d;
  Item[] e;
  int f;
  final Item g;
  final Item h;
  final Item i;
  final Item j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int[] p;
  private int q;
  private ByteVector r;
  private int s;
  private int t;
  private AnnotationWriter u;
  private AnnotationWriter v;
  private Attribute w;
  private int x;
  private ByteVector y;
  int z;

  static
  {
    _clinit_();
    byte[] arrayOfByte = new byte['Ü'];
    for (int i1 = 0; i1 < arrayOfByte.length; i1++)
      arrayOfByte[i1] = ((byte)('﾿' + "AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i1)));
  }

  public ClassWriter(int paramInt)
  {
    super(327680);
    this.c = i1;
    this.d = new ByteVector();
    this.e = new Item[256];
    this.f = ((int)(0.75D * this.e.length));
    this.g = new Item();
    this.h = new Item();
    this.i = new Item();
    this.j = new Item();
    boolean bool;
    if ((paramInt & 0x1) != 0)
    {
      bool = i1;
      this.K = bool;
      if ((paramInt & 0x2) == 0)
        break label123;
    }
    while (true)
    {
      this.J = i1;
      return;
      bool = false;
      break;
      label123: i1 = 0;
    }
  }

  public ClassWriter(ClassReader paramClassReader, int paramInt)
  {
    this(paramInt);
    paramClassReader.a(this);
    this.M = paramClassReader;
  }

  static void _clinit_()
  {
  }

  private Item a(Item paramItem)
  {
    for (Item localItem = this.e[(paramItem.j % this.e.length)]; (localItem != null) && ((localItem.b != paramItem.b) || (!paramItem.a(localItem))); localItem = localItem.k);
    return localItem;
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d.b(paramInt1, paramInt2).putShort(paramInt3);
  }

  private Item b(String paramString)
  {
    this.h.a(8, paramString, null, null);
    Item localItem = a(this.h);
    if (localItem == null)
    {
      this.d.b(8, newUTF8(paramString));
      int i1 = this.c;
      this.c = (i1 + 1);
      localItem = new Item(i1, this.h);
      b(localItem);
    }
    return localItem;
  }

  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d.a(paramInt1, paramInt2).putShort(paramInt3);
  }

  private void b(Item paramItem)
  {
    if (this.c + this.G > this.f)
    {
      int i2 = this.e.length;
      int i3 = 1 + i2 * 2;
      Item[] arrayOfItem = new Item[i3];
      for (int i4 = i2 - 1; i4 >= 0; i4--)
      {
        Item localItem;
        for (Object localObject = this.e[i4]; localObject != null; localObject = localItem)
        {
          int i5 = ((Item)localObject).j % arrayOfItem.length;
          localItem = ((Item)localObject).k;
          ((Item)localObject).k = arrayOfItem[i5];
          arrayOfItem[i5] = localObject;
        }
      }
      this.e = arrayOfItem;
      this.f = ((int)(0.75D * i3));
    }
    int i1 = paramItem.j % this.e.length;
    paramItem.k = this.e[i1];
    this.e[i1] = paramItem;
  }

  private Item c(Item paramItem)
  {
    this.G = ((short)(1 + this.G));
    Item localItem = new Item(this.G, this.g);
    b(localItem);
    if (this.H == null)
      this.H = new Item[16];
    if (this.G == this.H.length)
    {
      Item[] arrayOfItem = new Item[2 * this.H.length];
      System.arraycopy(this.H, 0, arrayOfItem, 0, this.H.length);
      this.H = arrayOfItem;
    }
    this.H[this.G] = localItem;
    return localItem;
  }

  int a(int paramInt1, int paramInt2)
  {
    this.h.b = 32;
    this.h.d = (paramInt1 | paramInt2 << 32);
    this.h.j = (0x7FFFFFFF & paramInt2 + (paramInt1 + 32));
    Item localItem = a(this.h);
    if (localItem == null)
    {
      String str1 = this.H[paramInt1].g;
      String str2 = this.H[paramInt2].g;
      this.h.c = c(getCommonSuperClass(str1, str2));
      localItem = new Item(0, this.h);
      b(localItem);
    }
    return localItem.c;
  }

  int a(String paramString, int paramInt)
  {
    this.g.b = 31;
    this.g.c = paramInt;
    this.g.g = paramString;
    this.g.j = (0x7FFFFFFF & paramInt + (31 + paramString.hashCode()));
    Item localItem = a(this.g);
    if (localItem == null)
      localItem = c(this.g);
    return localItem.a;
  }

  Item a(double paramDouble)
  {
    this.g.a(paramDouble);
    Item localItem = a(this.g);
    if (localItem == null)
    {
      this.d.putByte(6).putLong(this.g.d);
      localItem = new Item(this.c, this.g);
      this.c = (2 + this.c);
      b(localItem);
    }
    return localItem;
  }

  Item a(float paramFloat)
  {
    this.g.a(paramFloat);
    Item localItem = a(this.g);
    if (localItem == null)
    {
      this.d.putByte(4).putInt(this.g.c);
      int i1 = this.c;
      this.c = (i1 + 1);
      localItem = new Item(i1, this.g);
      b(localItem);
    }
    return localItem;
  }

  Item a(int paramInt)
  {
    this.g.a(paramInt);
    Item localItem = a(this.g);
    if (localItem == null)
    {
      this.d.putByte(3).putInt(paramInt);
      int i1 = this.c;
      this.c = (i1 + 1);
      localItem = new Item(i1, this.g);
      b(localItem);
    }
    return localItem;
  }

  Item a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.j.a(paramInt + 20, paramString1, paramString2, paramString3);
    Item localItem = a(this.j);
    if (localItem == null)
    {
      if (paramInt <= 4)
      {
        b(15, paramInt, newField(paramString1, paramString2, paramString3));
        int i1 = this.c;
        this.c = (i1 + 1);
        localItem = new Item(i1, this.j);
        b(localItem);
      }
    }
    else
      return localItem;
    if (paramInt == 9);
    for (boolean bool = true; ; bool = false)
    {
      b(15, paramInt, newMethod(paramString1, paramString2, paramString3, bool));
      break;
    }
  }

  Item a(long paramLong)
  {
    this.g.a(paramLong);
    Item localItem = a(this.g);
    if (localItem == null)
    {
      this.d.putByte(5).putLong(paramLong);
      localItem = new Item(this.c, this.g);
      this.c = (2 + this.c);
      b(localItem);
    }
    return localItem;
  }

  Item a(Object paramObject)
  {
    if ((paramObject instanceof Integer))
      return a(((Integer)paramObject).intValue());
    if ((paramObject instanceof Byte))
      return a(((Byte)paramObject).intValue());
    if ((paramObject instanceof Character))
      return a(((Character)paramObject).charValue());
    if ((paramObject instanceof Short))
      return a(((Short)paramObject).intValue());
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue());
      for (int i2 = 1; ; i2 = 0)
        return a(i2);
    }
    if ((paramObject instanceof Float))
      return a(((Float)paramObject).floatValue());
    if ((paramObject instanceof Long))
      return a(((Long)paramObject).longValue());
    if ((paramObject instanceof Double))
      return a(((Double)paramObject).doubleValue());
    if ((paramObject instanceof String))
      return b((String)paramObject);
    if ((paramObject instanceof Type))
    {
      Type localType = (Type)paramObject;
      int i1 = localType.getSort();
      if (i1 == 10)
        return a(localType.getInternalName());
      if (i1 == 11)
        return c(localType.getDescriptor());
      return a(localType.getDescriptor());
    }
    if ((paramObject instanceof Handle))
    {
      Handle localHandle = (Handle)paramObject;
      return a(localHandle.a, localHandle.b, localHandle.c, localHandle.d);
    }
    throw new IllegalArgumentException("value " + paramObject);
  }

  Item a(String paramString)
  {
    this.h.a(7, paramString, null, null);
    Item localItem = a(this.h);
    if (localItem == null)
    {
      this.d.b(7, newUTF8(paramString));
      int i1 = this.c;
      this.c = (i1 + 1);
      localItem = new Item(i1, this.h);
      b(localItem);
    }
    return localItem;
  }

  Item a(String paramString1, String paramString2)
  {
    this.h.a(12, paramString1, paramString2, null);
    Item localItem = a(this.h);
    if (localItem == null)
    {
      a(12, newUTF8(paramString1), newUTF8(paramString2));
      int i1 = this.c;
      this.c = (i1 + 1);
      localItem = new Item(i1, this.h);
      b(localItem);
    }
    return localItem;
  }

  Item a(String paramString1, String paramString2, String paramString3)
  {
    this.i.a(9, paramString1, paramString2, paramString3);
    Item localItem = a(this.i);
    if (localItem == null)
    {
      a(9, newClass(paramString1), newNameType(paramString2, paramString3));
      int i1 = this.c;
      this.c = (i1 + 1);
      localItem = new Item(i1, this.i);
      b(localItem);
    }
    return localItem;
  }

  Item a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramBoolean);
    Item localItem1;
    for (int i1 = 11; ; i1 = 10)
    {
      this.i.a(i1, paramString1, paramString2, paramString3);
      localItem1 = a(this.i);
      if (localItem1 != null)
        break;
      a(i1, newClass(paramString1), newNameType(paramString2, paramString3));
      int i2 = this.c;
      this.c = (i2 + 1);
      Item localItem2 = new Item(i2, this.i);
      b(localItem2);
      return localItem2;
    }
    return localItem1;
  }

  Item a(String paramString1, String paramString2, Handle paramHandle, Object[] paramArrayOfObject)
  {
    ByteVector localByteVector = this.A;
    if (localByteVector == null)
    {
      localByteVector = new ByteVector();
      this.A = localByteVector;
    }
    int i1 = localByteVector.b;
    int i2 = paramHandle.hashCode();
    localByteVector.putShort(newHandle(paramHandle.a, paramHandle.b, paramHandle.c, paramHandle.d));
    int i3 = paramArrayOfObject.length;
    localByteVector.putShort(i3);
    int i4 = i2;
    for (int i5 = 0; i5 < i3; i5++)
    {
      Object localObject = paramArrayOfObject[i5];
      i4 ^= localObject.hashCode();
      localByteVector.putShort(newConst(localObject));
    }
    byte[] arrayOfByte = localByteVector.a;
    int i6 = i3 + 2 << 1;
    int i7 = i4 & 0x7FFFFFFF;
    Item localItem1 = this.e[(i7 % this.e.length)];
    while (localItem1 != null)
      if ((localItem1.b != 33) || (localItem1.j != i7))
      {
        localItem1 = localItem1.k;
      }
      else
      {
        int i11 = localItem1.c;
        for (int i12 = 0; ; i12++)
        {
          if (i12 >= i6)
            break label251;
          if (arrayOfByte[(i1 + i12)] != arrayOfByte[(i11 + i12)])
          {
            localItem1 = localItem1.k;
            break;
          }
        }
      }
    label251: int i8;
    if (localItem1 != null)
    {
      int i10 = localItem1.a;
      localByteVector.b = i1;
      i8 = i10;
    }
    Item localItem3;
    while (true)
    {
      this.i.a(paramString1, paramString2, i8);
      localItem3 = a(this.i);
      if (localItem3 != null)
        break;
      a(18, i8, newNameType(paramString1, paramString2));
      int i9 = this.c;
      this.c = (i9 + 1);
      Item localItem4 = new Item(i9, this.i);
      b(localItem4);
      return localItem4;
      i8 = this.z;
      this.z = (i8 + 1);
      Item localItem2 = new Item(i8);
      localItem2.a(i1, i7);
      b(localItem2);
    }
    return localItem3;
  }

  int c(String paramString)
  {
    this.g.a(30, paramString, null, null);
    Item localItem = a(this.g);
    if (localItem == null)
      localItem = c(this.g);
    return localItem.a;
  }

  Item c(String paramString)
  {
    this.h.a(16, paramString, null, null);
    Item localItem = a(this.h);
    if (localItem == null)
    {
      this.d.b(16, newUTF8(paramString));
      int i1 = this.c;
      this.c = (i1 + 1);
      localItem = new Item(i1, this.h);
      b(localItem);
    }
    return localItem;
  }

  protected String getCommonSuperClass(String paramString1, String paramString2)
  {
    ClassLoader localClassLoader = getClass().getClassLoader();
    Class localClass1;
    Class localClass2;
    try
    {
      localClass1 = Class.forName(paramString1.replace('/', '.'), false, localClassLoader);
      localClass2 = Class.forName(paramString2.replace('/', '.'), false, localClassLoader);
      if (localClass1.isAssignableFrom(localClass2))
        return paramString1;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.toString());
    }
    if (localClass2.isAssignableFrom(localClass1))
      return paramString2;
    if ((localClass1.isInterface()) || (localClass2.isInterface()))
      return "java/lang/Object";
    do
      localClass1 = localClass1.getSuperclass();
    while (!localClass1.isAssignableFrom(localClass2));
    return localClass1.getName().replace('.', '/');
  }

  public int newClass(String paramString)
  {
    return a(paramString).a;
  }

  public int newConst(Object paramObject)
  {
    return a(paramObject).a;
  }

  public int newField(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3).a;
  }

  public int newHandle(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    return a(paramInt, paramString1, paramString2, paramString3).a;
  }

  public int newInvokeDynamic(String paramString1, String paramString2, Handle paramHandle, Object[] paramArrayOfObject)
  {
    return a(paramString1, paramString2, paramHandle, paramArrayOfObject).a;
  }

  public int newMethod(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean).a;
  }

  public int newMethodType(String paramString)
  {
    return c(paramString).a;
  }

  public int newNameType(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2).a;
  }

  public int newUTF8(String paramString)
  {
    this.g.a(1, paramString, null, null);
    Item localItem = a(this.g);
    if (localItem == null)
    {
      this.d.putByte(1).putUTF8(paramString);
      int i1 = this.c;
      this.c = (i1 + 1);
      localItem = new Item(i1, this.g);
      b(localItem);
    }
    return localItem.a;
  }

  public byte[] toByteArray()
  {
    if (this.c > 65535)
      throw new RuntimeException("Class file too large!");
    int i1 = 24 + 2 * this.o;
    FieldWriter localFieldWriter1 = this.B;
    int i12;
    for (int i2 = 0; localFieldWriter1 != null; i2 = i12)
    {
      i12 = i2 + 1;
      i1 += localFieldWriter1.a();
      localFieldWriter1 = (FieldWriter)localFieldWriter1.fv;
    }
    MethodWriter localMethodWriter1 = this.D;
    int i11;
    for (int i3 = 0; localMethodWriter1 != null; i3 = i11)
    {
      i11 = i3 + 1;
      i1 += localMethodWriter1.a();
      localMethodWriter1 = (MethodWriter)localMethodWriter1.mv;
    }
    int i4;
    if (this.A != null)
    {
      i4 = 1;
      i1 += 8 + this.A.b;
      newUTF8("BootstrapMethods");
    }
    while (true)
    {
      if (this.m != 0)
      {
        i4++;
        i1 += 8;
        newUTF8("Signature");
      }
      if (this.q != 0)
      {
        i4++;
        i1 += 8;
        newUTF8("SourceFile");
      }
      if (this.r != null)
      {
        i4++;
        i1 += 6 + this.r.b;
        newUTF8("SourceDebugExtension");
      }
      if (this.s != 0)
      {
        i4++;
        i1 += 10;
        newUTF8("EnclosingMethod");
      }
      if ((0x20000 & this.k) != 0)
      {
        i4++;
        i1 += 6;
        newUTF8("Deprecated");
      }
      if (((0x1000 & this.k) != 0) && (((0xFFFF & this.b) < 49) || ((0x40000 & this.k) != 0)))
      {
        i4++;
        i1 += 6;
        newUTF8("Synthetic");
      }
      if (this.y != null)
      {
        i4++;
        i1 += 8 + this.y.b;
        newUTF8("InnerClasses");
      }
      if (this.u != null)
      {
        i4++;
        i1 += 8 + this.u.a();
        newUTF8("RuntimeVisibleAnnotations");
      }
      if (this.v != null)
      {
        i4++;
        i1 += 8 + this.v.a();
        newUTF8("RuntimeInvisibleAnnotations");
      }
      if (this.N != null)
      {
        i4++;
        i1 += 8 + this.N.a();
        newUTF8("RuntimeVisibleTypeAnnotations");
      }
      if (this.O != null)
      {
        i4++;
        i1 += 8 + this.O.a();
        newUTF8("RuntimeInvisibleTypeAnnotations");
      }
      int i5 = i1;
      int i10;
      if (this.w != null)
      {
        i10 = i4 + this.w.a();
        i5 += this.w.a(this, null, 0, -1, -1);
      }
      for (int i6 = i10; ; i6 = i4)
      {
        ByteVector localByteVector = new ByteVector(i5 + this.d.b);
        localByteVector.putInt(-889275714).putInt(this.b);
        localByteVector.putShort(this.c).putByteArray(this.d.a, 0, this.d.b);
        int i7 = 0x60000 | (0x40000 & this.k) / 64;
        localByteVector.putShort(this.k & (i7 ^ 0xFFFFFFFF)).putShort(this.l).putShort(this.n);
        localByteVector.putShort(this.o);
        for (int i8 = 0; i8 < this.o; i8++)
          localByteVector.putShort(this.p[i8]);
        localByteVector.putShort(i2);
        for (FieldWriter localFieldWriter2 = this.B; localFieldWriter2 != null; localFieldWriter2 = (FieldWriter)localFieldWriter2.fv)
          localFieldWriter2.a(localByteVector);
        localByteVector.putShort(i3);
        for (MethodWriter localMethodWriter2 = this.D; localMethodWriter2 != null; localMethodWriter2 = (MethodWriter)localMethodWriter2.mv)
          localMethodWriter2.a(localByteVector);
        localByteVector.putShort(i6);
        if (this.A != null)
        {
          localByteVector.putShort(newUTF8("BootstrapMethods"));
          localByteVector.putInt(2 + this.A.b).putShort(this.z);
          localByteVector.putByteArray(this.A.a, 0, this.A.b);
        }
        if (this.m != 0)
          localByteVector.putShort(newUTF8("Signature")).putInt(2).putShort(this.m);
        if (this.q != 0)
          localByteVector.putShort(newUTF8("SourceFile")).putInt(2).putShort(this.q);
        if (this.r != null)
        {
          int i9 = this.r.b;
          localByteVector.putShort(newUTF8("SourceDebugExtension")).putInt(i9);
          localByteVector.putByteArray(this.r.a, 0, i9);
        }
        if (this.s != 0)
        {
          localByteVector.putShort(newUTF8("EnclosingMethod")).putInt(4);
          localByteVector.putShort(this.s).putShort(this.t);
        }
        if ((0x20000 & this.k) != 0)
          localByteVector.putShort(newUTF8("Deprecated")).putInt(0);
        if (((0x1000 & this.k) != 0) && (((0xFFFF & this.b) < 49) || ((0x40000 & this.k) != 0)))
          localByteVector.putShort(newUTF8("Synthetic")).putInt(0);
        if (this.y != null)
        {
          localByteVector.putShort(newUTF8("InnerClasses"));
          localByteVector.putInt(2 + this.y.b).putShort(this.x);
          localByteVector.putByteArray(this.y.a, 0, this.y.b);
        }
        if (this.u != null)
        {
          localByteVector.putShort(newUTF8("RuntimeVisibleAnnotations"));
          this.u.a(localByteVector);
        }
        if (this.v != null)
        {
          localByteVector.putShort(newUTF8("RuntimeInvisibleAnnotations"));
          this.v.a(localByteVector);
        }
        if (this.N != null)
        {
          localByteVector.putShort(newUTF8("RuntimeVisibleTypeAnnotations"));
          this.N.a(localByteVector);
        }
        if (this.O != null)
        {
          localByteVector.putShort(newUTF8("RuntimeInvisibleTypeAnnotations"));
          this.O.a(localByteVector);
        }
        if (this.w != null)
          this.w.a(this, null, 0, -1, -1, localByteVector);
        if (this.L)
        {
          this.u = null;
          this.v = null;
          this.w = null;
          this.x = 0;
          this.y = null;
          this.z = 0;
          this.A = null;
          this.B = null;
          this.C = null;
          this.D = null;
          this.E = null;
          this.K = false;
          this.J = true;
          this.L = false;
          new ClassReader(localByteVector.a).accept(this, 4);
          return toByteArray();
        }
        return localByteVector.a;
      }
      i4 = 0;
    }
  }

  public final void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    int i1 = 0;
    this.b = paramInt1;
    this.k = paramInt2;
    this.l = newClass(paramString1);
    this.I = paramString1;
    if (paramString2 != null)
      this.m = newUTF8(paramString2);
    if (paramString3 == null);
    for (int i2 = 0; ; i2 = newClass(paramString3))
    {
      this.n = i2;
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
        break;
      this.o = paramArrayOfString.length;
      this.p = new int[this.o];
      while (i1 < this.o)
      {
        this.p[i1] = newClass(paramArrayOfString[i1]);
        i1++;
      }
    }
  }

  public final AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    localByteVector.putShort(newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this, true, localByteVector, localByteVector, 2);
    if (paramBoolean)
    {
      localAnnotationWriter.g = this.u;
      this.u = localAnnotationWriter;
      return localAnnotationWriter;
    }
    localAnnotationWriter.g = this.v;
    this.v = localAnnotationWriter;
    return localAnnotationWriter;
  }

  public final void visitAttribute(Attribute paramAttribute)
  {
    paramAttribute.a = this.w;
    this.w = paramAttribute;
  }

  public final void visitEnd()
  {
  }

  public final FieldVisitor visitField(int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    return new FieldWriter(this, paramInt, paramString1, paramString2, paramString3, paramObject);
  }

  public final void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.y == null)
      this.y = new ByteVector();
    Item localItem = a(paramString1);
    int i1;
    ByteVector localByteVector2;
    int i2;
    if (localItem.c == 0)
    {
      this.x = (1 + this.x);
      this.y.putShort(localItem.a);
      ByteVector localByteVector1 = this.y;
      if (paramString2 != null)
        break label118;
      i1 = 0;
      localByteVector1.putShort(i1);
      localByteVector2 = this.y;
      i2 = 0;
      if (paramString3 != null)
        break label128;
    }
    while (true)
    {
      localByteVector2.putShort(i2);
      this.y.putShort(paramInt);
      localItem.c = this.x;
      return;
      label118: i1 = newClass(paramString2);
      break;
      label128: i2 = newUTF8(paramString3);
    }
  }

  public final MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    return new MethodWriter(this, paramInt, paramString1, paramString2, paramString3, paramArrayOfString, this.K, this.J);
  }

  public final void visitOuterClass(String paramString1, String paramString2, String paramString3)
  {
    this.s = newClass(paramString1);
    if ((paramString2 != null) && (paramString3 != null))
      this.t = newNameType(paramString2, paramString3);
  }

  public final void visitSource(String paramString1, String paramString2)
  {
    if (paramString1 != null)
      this.q = newUTF8(paramString1);
    if (paramString2 != null)
      this.r = new ByteVector().c(paramString2, 0, 2147483647);
  }

  public final AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    AnnotationWriter.a(paramInt, paramTypePath, localByteVector);
    localByteVector.putShort(newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this, true, localByteVector, localByteVector, -2 + localByteVector.b);
    if (paramBoolean)
    {
      localAnnotationWriter.g = this.N;
      this.N = localAnnotationWriter;
      return localAnnotationWriter;
    }
    localAnnotationWriter.g = this.O;
    this.O = localAnnotationWriter;
    return localAnnotationWriter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.ClassWriter
 * JD-Core Version:    0.6.2
 */