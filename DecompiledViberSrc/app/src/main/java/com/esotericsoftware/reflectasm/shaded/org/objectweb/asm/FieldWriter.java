package com.esotericsoftware.reflectasm.shaded.org.objectweb.asm;

final class FieldWriter extends FieldVisitor
{
  private final ClassWriter b;
  private final int c;
  private final int d;
  private final int e;
  private int f;
  private int g;
  private AnnotationWriter h;
  private AnnotationWriter i;
  private Attribute j;

  FieldWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    super(262144);
    if (paramClassWriter.B == null)
      paramClassWriter.B = this;
    while (true)
    {
      paramClassWriter.C = this;
      this.b = paramClassWriter;
      this.c = paramInt;
      this.d = paramClassWriter.newUTF8(paramString1);
      this.e = paramClassWriter.newUTF8(paramString2);
      if (paramString3 != null)
        this.f = paramClassWriter.newUTF8(paramString3);
      if (paramObject != null)
        this.g = paramClassWriter.a(paramObject).a;
      return;
      paramClassWriter.C.fv = this;
    }
  }

  int a()
  {
    int k = 8;
    if (this.g != 0)
    {
      this.b.newUTF8("ConstantValue");
      k = 16;
    }
    if (((0x1000 & this.c) != 0) && (((0xFFFF & this.b.b) < 49) || ((0x40000 & this.c) != 0)))
    {
      this.b.newUTF8("Synthetic");
      k += 6;
    }
    if ((0x20000 & this.c) != 0)
    {
      this.b.newUTF8("Deprecated");
      k += 6;
    }
    if (this.f != 0)
    {
      this.b.newUTF8("Signature");
      k += 8;
    }
    if (this.h != null)
    {
      this.b.newUTF8("RuntimeVisibleAnnotations");
      k += 8 + this.h.a();
    }
    if (this.i != null)
      this.b.newUTF8("RuntimeInvisibleAnnotations");
    for (int m = k + (8 + this.i.a()); ; m = k)
    {
      if (this.j != null)
        m += this.j.a(this.b, null, 0, -1, -1);
      return m;
    }
  }

  void a(ByteVector paramByteVector)
  {
    int k = 0x60000 | (0x40000 & this.c) / 64;
    paramByteVector.putShort(this.c & (k ^ 0xFFFFFFFF)).putShort(this.d).putShort(this.e);
    if (this.g != 0);
    for (int m = 1; ; m = 0)
    {
      if (((0x1000 & this.c) != 0) && (((0xFFFF & this.b.b) < 49) || ((0x40000 & this.c) != 0)))
        m++;
      if ((0x20000 & this.c) != 0)
        m++;
      if (this.f != 0)
        m++;
      if (this.h != null)
        m++;
      if (this.i != null)
        m++;
      if (this.j != null)
        m += this.j.a();
      paramByteVector.putShort(m);
      if (this.g != 0)
      {
        paramByteVector.putShort(this.b.newUTF8("ConstantValue"));
        paramByteVector.putInt(2).putShort(this.g);
      }
      if (((0x1000 & this.c) != 0) && (((0xFFFF & this.b.b) < 49) || ((0x40000 & this.c) != 0)))
        paramByteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0);
      if ((0x20000 & this.c) != 0)
        paramByteVector.putShort(this.b.newUTF8("Deprecated")).putInt(0);
      if (this.f != 0)
      {
        paramByteVector.putShort(this.b.newUTF8("Signature"));
        paramByteVector.putInt(2).putShort(this.f);
      }
      if (this.h != null)
      {
        paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleAnnotations"));
        this.h.a(paramByteVector);
      }
      if (this.i != null)
      {
        paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleAnnotations"));
        this.i.a(paramByteVector);
      }
      if (this.j != null)
        this.j.a(this.b, null, 0, -1, -1, paramByteVector);
      return;
    }
  }

  public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    localByteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this.b, true, localByteVector, localByteVector, 2);
    if (paramBoolean)
    {
      localAnnotationWriter.g = this.h;
      this.h = localAnnotationWriter;
      return localAnnotationWriter;
    }
    localAnnotationWriter.g = this.i;
    this.i = localAnnotationWriter;
    return localAnnotationWriter;
  }

  public void visitAttribute(Attribute paramAttribute)
  {
    paramAttribute.a = this.j;
    this.j = paramAttribute;
  }

  public void visitEnd()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.FieldWriter
 * JD-Core Version:    0.6.2
 */