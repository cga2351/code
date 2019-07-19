package org.objectweb.asm;

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
  private AnnotationWriter k;
  private AnnotationWriter l;

  FieldWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    super(327680);
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
    int m = 8;
    if (this.g != 0)
    {
      this.b.newUTF8("ConstantValue");
      m = 16;
    }
    if (((0x1000 & this.c) != 0) && (((0xFFFF & this.b.b) < 49) || ((0x40000 & this.c) != 0)))
    {
      this.b.newUTF8("Synthetic");
      m += 6;
    }
    if ((0x20000 & this.c) != 0)
    {
      this.b.newUTF8("Deprecated");
      m += 6;
    }
    if (this.f != 0)
    {
      this.b.newUTF8("Signature");
      m += 8;
    }
    if (this.h != null)
    {
      this.b.newUTF8("RuntimeVisibleAnnotations");
      m += 8 + this.h.a();
    }
    if (this.i != null)
    {
      this.b.newUTF8("RuntimeInvisibleAnnotations");
      m += 8 + this.i.a();
    }
    if (this.k != null)
    {
      this.b.newUTF8("RuntimeVisibleTypeAnnotations");
      m += 8 + this.k.a();
    }
    if (this.l != null)
      this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
    for (int n = m + (8 + this.l.a()); ; n = m)
    {
      if (this.j != null)
        n += this.j.a(this.b, null, 0, -1, -1);
      return n;
    }
  }

  void a(ByteVector paramByteVector)
  {
    int m = 0x60000 | (0x40000 & this.c) / 64;
    paramByteVector.putShort(this.c & (m ^ 0xFFFFFFFF)).putShort(this.d).putShort(this.e);
    if (this.g != 0);
    for (int n = 1; ; n = 0)
    {
      if (((0x1000 & this.c) != 0) && (((0xFFFF & this.b.b) < 49) || ((0x40000 & this.c) != 0)))
        n++;
      if ((0x20000 & this.c) != 0)
        n++;
      if (this.f != 0)
        n++;
      if (this.h != null)
        n++;
      if (this.i != null)
        n++;
      if (this.k != null)
        n++;
      if (this.l != null)
        n++;
      if (this.j != null)
        n += this.j.a();
      paramByteVector.putShort(n);
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
      if (this.k != null)
      {
        paramByteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
        this.k.a(paramByteVector);
      }
      if (this.l != null)
      {
        paramByteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
        this.l.a(paramByteVector);
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

  public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean)
  {
    ByteVector localByteVector = new ByteVector();
    AnnotationWriter.a(paramInt, paramTypePath, localByteVector);
    localByteVector.putShort(this.b.newUTF8(paramString)).putShort(0);
    AnnotationWriter localAnnotationWriter = new AnnotationWriter(this.b, true, localByteVector, localByteVector, -2 + localByteVector.b);
    if (paramBoolean)
    {
      localAnnotationWriter.g = this.k;
      this.k = localAnnotationWriter;
      return localAnnotationWriter;
    }
    localAnnotationWriter.g = this.l;
    this.l = localAnnotationWriter;
    return localAnnotationWriter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.FieldWriter
 * JD-Core Version:    0.6.2
 */