package AssemblyGlasses;

import AssemblyInterfaces.ILineStep;
import AssemblyInterfaces.IProductPart;

public class GlassesFrameStep implements ILineStep {
  public IProductPart buildProductPart() {
    IProductPart part = new GlassesFrame();
    System.out.println("Frame builded");
    return part;
  };
};