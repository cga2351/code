package org.objectweb.asm;

public class Attribute
{
  Attribute a;
  byte[] b;
  public final String type;

  protected Attribute(String paramString)
  {
    this.type = paramString;
  }

  final int a()
  {
    int i = 0;
    while (this != null)
    {
      i++;
      this = this.a;
    }
    return i;
  }

  final int a(ClassWriter paramClassWriter, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    Attribute localAttribute = this;
    while (localAttribute != null)
    {
      paramClassWriter.newUTF8(localAttribute.type);
      int j = i + (6 + localAttribute.write(paramClassWriter, paramArrayOfByte, paramInt1, paramInt2, paramInt3).b);
      localAttribute = localAttribute.a;
      i = j;
    }
    return i;
  }

  final void a(ClassWriter paramClassWriter, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, ByteVector paramByteVector)
  {
    for (Attribute localAttribute = this; localAttribute != null; localAttribute = localAttribute.a)
    {
      ByteVector localByteVector = localAttribute.write(paramClassWriter, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      paramByteVector.putShort(paramClassWriter.newUTF8(localAttribute.type)).putInt(localByteVector.b);
      paramByteVector.putByteArray(localByteVector.a, 0, localByteVector.b);
    }
  }

  protected Label[] getLabels()
  {
    return null;
  }

  public boolean isCodeAttribute()
  {
    return false;
  }

  public boolean isUnknown()
  {
    return true;
  }

  protected Attribute read(ClassReader paramClassReader, int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3, Label[] paramArrayOfLabel)
  {
    Attribute localAttribute = new Attribute(this.type);
    localAttribute.b = new byte[paramInt2];
    System.arraycopy(paramClassReader.b, paramInt1, localAttribute.b, 0, paramInt2);
    return localAttribute;
  }

  protected ByteVector write(ClassWriter paramClassWriter, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    ByteVector localByteVector = new ByteVector();
    localByteVector.a = this.b;
    localByteVector.b = this.b.length;
    return localByteVector;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.Attribute
 * JD-Core Version:    0.6.2
 */