package vidis.ui.model.graph.layouts.impl;

import java.util.LinkedList;
import java.util.List;

import javax.vecmath.Point3d;

import vidis.data.sim.SimNode;
import vidis.ui.model.graph.layouts.AGraphLayout;

/**
 * spiral layout for nodes
 * 
 * very nice output and low processing time
 * @author Dominik
 *
 */
public class GraphSpiralLayout extends AGraphLayout {
	private final double aMin = 0.15;
	private final double aMax = 1.0;
	private final double dMin = 1.0;
	private final double dMax = 6;
	private double a;
	private double d;
	
	private List<Point3d> points = new LinkedList<Point3d>();

	public void setNodeDensity(double density) {
		density = Math.max(0.0, density);
		density = Math.min(1.0, density);
		a = density * (aMax - aMin) + aMin;
		d = density * (dMax - aMin) + dMin;
	}
	
	private double spirale_rt(double t) {
		return a * t;
	}

	private double spirale_st(double t) {
		return a / 2 * (Math.log(Math.sqrt(t + 1) + 1) + t * Math.sqrt(t * t + 1));
	}

	private double spirale_xt(double t) {
		return spirale_rt(t) * Math.cos(t);
	}

	private double spirale_yt(double t) {
		return 0;
	}

	private double spirale_zt(double t) {
		return spirale_rt(t) * Math.sin(t);
	}

	/**
	 * retrieve the next point for a node
	 * 
	 * @return a point3d
	 */
	private Point3d nextNodePoint3d() {
		Point3d tmp = new Point3d();
		double pi64 = (Math.PI / 64);
		// distance
		double t = 0.0;
		while (spirale_st(t) <= (points.size() + 1) * d) {
			t += pi64;
		}
		tmp.x = spirale_xt(t);
		tmp.y = spirale_yt(t);
		tmp.z = spirale_zt(t);
		points.add(tmp);
		return tmp;
	}
	
	public void apply(List<SimNode> nodes) throws Exception {
		points.clear();
		for(int i=0; i<nodes.size(); i++) {
			setPosition(nodes.get(i), nextNodePoint3d());
		}
	}
}
