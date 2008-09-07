package vidis.ui.model.structure;

import java.util.Set;

import javax.media.opengl.GL;

import vidis.ui.events.IEventHandler;

public interface IGuiContainer extends IVisObject, IEventHandler {

	public final double Z_OFFSET = 0.02;
	
	public void render(GL gl);
	public void renderBox(GL gl, double d);
	
	public double getHeight();
	public double getWidth();
	public double getX();
	public double getY();
	
	public void setHeight( double height );
	public void setWidth( double width );
	public void setX( double x );
	public void setY( double y );
	
	public void setBounds( double x, double y, double height, double width );
	
	public void setLayout( ILayout layout );
	public ILayout getLayout();
	
	// parent child ..
	public IGuiContainer getParent();
	public Set<IGuiContainer> getChilds();
	public void addChild( IGuiContainer c );
	public void removeChild( IGuiContainer c );
	public void setParent( IGuiContainer container );
	// ----
	
}
