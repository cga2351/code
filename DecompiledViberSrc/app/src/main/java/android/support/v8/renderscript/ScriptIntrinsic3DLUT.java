package android.support.v8.renderscript;

import android.os.Build.VERSION;

public class ScriptIntrinsic3DLUT extends ScriptIntrinsic
{
  private static final int INTRINSIC_API_LEVEL = 19;
  private Element mElement;
  private Allocation mLUT;

  protected ScriptIntrinsic3DLUT(long paramLong, RenderScript paramRenderScript, Element paramElement)
  {
    super(paramLong, paramRenderScript);
    this.mElement = paramElement;
  }

  public static ScriptIntrinsic3DLUT create(RenderScript paramRenderScript, Element paramElement)
  {
    if (!paramElement.isCompatible(Element.U8_4(paramRenderScript)))
      throw new RSIllegalArgumentException("Element must be compatible with uchar4.");
    if ((paramRenderScript.isUseNative()) && (Build.VERSION.SDK_INT < 19));
    for (boolean bool = true; ; bool = false)
    {
      ScriptIntrinsic3DLUT localScriptIntrinsic3DLUT = new ScriptIntrinsic3DLUT(paramRenderScript.nScriptIntrinsicCreate(8, paramElement.getID(paramRenderScript), bool), paramRenderScript, paramElement);
      localScriptIntrinsic3DLUT.setIncSupp(bool);
      return localScriptIntrinsic3DLUT;
    }
  }

  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    forEach(0, paramAllocation1, paramAllocation2, null);
  }

  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 3, null, null);
  }

  public void setLUT(Allocation paramAllocation)
  {
    Type localType = paramAllocation.getType();
    if (localType.getZ() == 0)
      throw new RSIllegalArgumentException("LUT must be 3d.");
    if (!localType.getElement().isCompatible(this.mElement))
      throw new RSIllegalArgumentException("LUT element type must match.");
    this.mLUT = paramAllocation;
    setVar(0, this.mLUT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsic3DLUT
 * JD-Core Version:    0.6.2
 */