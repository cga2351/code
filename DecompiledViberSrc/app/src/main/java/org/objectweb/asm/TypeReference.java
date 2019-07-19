package org.objectweb.asm;

public class TypeReference
{
  public static final int CAST = 71;
  public static final int CLASS_EXTENDS = 16;
  public static final int CLASS_TYPE_PARAMETER = 0;
  public static final int CLASS_TYPE_PARAMETER_BOUND = 17;
  public static final int CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT = 72;
  public static final int CONSTRUCTOR_REFERENCE = 69;
  public static final int CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT = 74;
  public static final int EXCEPTION_PARAMETER = 66;
  public static final int FIELD = 19;
  public static final int INSTANCEOF = 67;
  public static final int LOCAL_VARIABLE = 64;
  public static final int METHOD_FORMAL_PARAMETER = 22;
  public static final int METHOD_INVOCATION_TYPE_ARGUMENT = 73;
  public static final int METHOD_RECEIVER = 21;
  public static final int METHOD_REFERENCE = 70;
  public static final int METHOD_REFERENCE_TYPE_ARGUMENT = 75;
  public static final int METHOD_RETURN = 20;
  public static final int METHOD_TYPE_PARAMETER = 1;
  public static final int METHOD_TYPE_PARAMETER_BOUND = 18;
  public static final int NEW = 68;
  public static final int RESOURCE_VARIABLE = 65;
  public static final int THROWS = 23;
  private int a;

  public TypeReference(int paramInt)
  {
    this.a = paramInt;
  }

  public static TypeReference newExceptionReference(int paramInt)
  {
    return new TypeReference(0x17000000 | paramInt << 8);
  }

  public static TypeReference newFormalParameterReference(int paramInt)
  {
    return new TypeReference(0x16000000 | paramInt << 16);
  }

  public static TypeReference newSuperTypeReference(int paramInt)
  {
    return new TypeReference(0x10000000 | (0xFFFF & paramInt) << 8);
  }

  public static TypeReference newTryCatchReference(int paramInt)
  {
    return new TypeReference(0x42000000 | paramInt << 8);
  }

  public static TypeReference newTypeArgumentReference(int paramInt1, int paramInt2)
  {
    return new TypeReference(paramInt2 | paramInt1 << 24);
  }

  public static TypeReference newTypeParameterBoundReference(int paramInt1, int paramInt2, int paramInt3)
  {
    return new TypeReference(paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8);
  }

  public static TypeReference newTypeParameterReference(int paramInt1, int paramInt2)
  {
    return new TypeReference(paramInt1 << 24 | paramInt2 << 16);
  }

  public static TypeReference newTypeReference(int paramInt)
  {
    return new TypeReference(paramInt << 24);
  }

  public int getExceptionIndex()
  {
    return (0xFFFF00 & this.a) >> 8;
  }

  public int getFormalParameterIndex()
  {
    return (0xFF0000 & this.a) >> 16;
  }

  public int getSort()
  {
    return this.a >>> 24;
  }

  public int getSuperTypeIndex()
  {
    return (short)((0xFFFF00 & this.a) >> 8);
  }

  public int getTryCatchBlockIndex()
  {
    return (0xFFFF00 & this.a) >> 8;
  }

  public int getTypeArgumentIndex()
  {
    return 0xFF & this.a;
  }

  public int getTypeParameterBoundIndex()
  {
    return (0xFF00 & this.a) >> 8;
  }

  public int getTypeParameterIndex()
  {
    return (0xFF0000 & this.a) >> 16;
  }

  public int getValue()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objectweb.asm.TypeReference
 * JD-Core Version:    0.6.2
 */