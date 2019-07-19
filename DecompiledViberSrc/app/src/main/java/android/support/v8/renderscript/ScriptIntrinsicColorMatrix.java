package android.support.v8.renderscript;

import android.os.Build.VERSION;

public class ScriptIntrinsicColorMatrix extends ScriptIntrinsic
{
  private static final int INTRINSIC_API_LEVEL = 19;
  private final Float4 mAdd = new Float4();
  private Allocation mInput;
  private final Matrix4f mMatrix = new Matrix4f();

  protected ScriptIntrinsicColorMatrix(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public static ScriptIntrinsicColorMatrix create(RenderScript paramRenderScript, Element paramElement)
  {
    if (!paramElement.isCompatible(Element.U8_4(paramRenderScript)))
      throw new RSIllegalArgumentException("Unsupported element type.");
    if ((paramRenderScript.isUseNative()) && (Build.VERSION.SDK_INT < 19));
    for (boolean bool = true; ; bool = false)
    {
      ScriptIntrinsicColorMatrix localScriptIntrinsicColorMatrix = new ScriptIntrinsicColorMatrix(paramRenderScript.nScriptIntrinsicCreate(2, paramElement.getID(paramRenderScript), bool), paramRenderScript);
      localScriptIntrinsicColorMatrix.setIncSupp(bool);
      return localScriptIntrinsicColorMatrix;
    }
  }

  private void setMatrix()
  {
    FieldPacker localFieldPacker = new FieldPacker(64);
    localFieldPacker.addMatrix(this.mMatrix);
    setVar(0, localFieldPacker);
  }

  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    forEach(0, paramAllocation1, paramAllocation2, null);
  }

  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions)
  {
    if ((!paramAllocation1.getElement().isCompatible(Element.U8(this.mRS))) && (!paramAllocation1.getElement().isCompatible(Element.U8_2(this.mRS))) && (!paramAllocation1.getElement().isCompatible(Element.U8_3(this.mRS))) && (!paramAllocation1.getElement().isCompatible(Element.U8_4(this.mRS))) && (!paramAllocation1.getElement().isCompatible(Element.F32(this.mRS))) && (!paramAllocation1.getElement().isCompatible(Element.F32_2(this.mRS))) && (!paramAllocation1.getElement().isCompatible(Element.F32_3(this.mRS))) && (!paramAllocation1.getElement().isCompatible(Element.F32_4(this.mRS))))
      throw new RSIllegalArgumentException("Unsupported element type.");
    if ((!paramAllocation2.getElement().isCompatible(Element.U8(this.mRS))) && (!paramAllocation2.getElement().isCompatible(Element.U8_2(this.mRS))) && (!paramAllocation2.getElement().isCompatible(Element.U8_3(this.mRS))) && (!paramAllocation2.getElement().isCompatible(Element.U8_4(this.mRS))) && (!paramAllocation2.getElement().isCompatible(Element.F32(this.mRS))) && (!paramAllocation2.getElement().isCompatible(Element.F32_2(this.mRS))) && (!paramAllocation2.getElement().isCompatible(Element.F32_3(this.mRS))) && (!paramAllocation2.getElement().isCompatible(Element.F32_4(this.mRS))))
      throw new RSIllegalArgumentException("Unsupported element type.");
    forEach(0, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
  }

  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 3, null, null);
  }

  public void setAdd(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mAdd.x = paramFloat1;
    this.mAdd.y = paramFloat2;
    this.mAdd.z = paramFloat3;
    this.mAdd.w = paramFloat4;
    FieldPacker localFieldPacker = new FieldPacker(16);
    localFieldPacker.addF32(this.mAdd.x);
    localFieldPacker.addF32(this.mAdd.y);
    localFieldPacker.addF32(this.mAdd.z);
    localFieldPacker.addF32(this.mAdd.w);
    setVar(1, localFieldPacker);
  }

  public void setAdd(Float4 paramFloat4)
  {
    this.mAdd.x = paramFloat4.x;
    this.mAdd.y = paramFloat4.y;
    this.mAdd.z = paramFloat4.z;
    this.mAdd.w = paramFloat4.w;
    FieldPacker localFieldPacker = new FieldPacker(16);
    localFieldPacker.addF32(paramFloat4.x);
    localFieldPacker.addF32(paramFloat4.y);
    localFieldPacker.addF32(paramFloat4.z);
    localFieldPacker.addF32(paramFloat4.w);
    setVar(1, localFieldPacker);
  }

  public void setColorMatrix(Matrix3f paramMatrix3f)
  {
    this.mMatrix.load(paramMatrix3f);
    setMatrix();
  }

  public void setColorMatrix(Matrix4f paramMatrix4f)
  {
    this.mMatrix.load(paramMatrix4f);
    setMatrix();
  }

  public void setGreyscale()
  {
    this.mMatrix.loadIdentity();
    this.mMatrix.set(0, 0, 0.299F);
    this.mMatrix.set(1, 0, 0.587F);
    this.mMatrix.set(2, 0, 0.114F);
    this.mMatrix.set(0, 1, 0.299F);
    this.mMatrix.set(1, 1, 0.587F);
    this.mMatrix.set(2, 1, 0.114F);
    this.mMatrix.set(0, 2, 0.299F);
    this.mMatrix.set(1, 2, 0.587F);
    this.mMatrix.set(2, 2, 0.114F);
    setMatrix();
  }

  public void setRGBtoYUV()
  {
    this.mMatrix.loadIdentity();
    this.mMatrix.set(0, 0, 0.299F);
    this.mMatrix.set(1, 0, 0.587F);
    this.mMatrix.set(2, 0, 0.114F);
    this.mMatrix.set(0, 1, -0.14713F);
    this.mMatrix.set(1, 1, -0.28886F);
    this.mMatrix.set(2, 1, 0.436F);
    this.mMatrix.set(0, 2, 0.615F);
    this.mMatrix.set(1, 2, -0.51499F);
    this.mMatrix.set(2, 2, -0.10001F);
    setMatrix();
  }

  public void setYUVtoRGB()
  {
    this.mMatrix.loadIdentity();
    this.mMatrix.set(0, 0, 1.0F);
    this.mMatrix.set(1, 0, 0.0F);
    this.mMatrix.set(2, 0, 1.13983F);
    this.mMatrix.set(0, 1, 1.0F);
    this.mMatrix.set(1, 1, -0.39465F);
    this.mMatrix.set(2, 1, -0.5806F);
    this.mMatrix.set(0, 2, 1.0F);
    this.mMatrix.set(1, 2, 2.03211F);
    this.mMatrix.set(2, 2, 0.0F);
    setMatrix();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicColorMatrix
 * JD-Core Version:    0.6.2
 */