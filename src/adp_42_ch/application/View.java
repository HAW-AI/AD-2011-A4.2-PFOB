package adp_42_ch.application;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphView;

import adp_42_ch.interfaces.*;

public class View {

	private final Controller controller;
	
	private final JFrame frame;
	
	private mxGraphComponent graphComponent;
	
	private View(Controller controller, int width, int height, Image image){
		this.controller=controller;
		this.frame=new JFrame();
		frame.setSize(width, height);
		display(image);
		frame.setVisible(true);
	}
	
	protected static View create(Controller controller, int width, int height , Image image){
		return new View(controller, width, height, image);
	}
	
	private void display(Image image){
		mxGraph graph=new mxGraph();
		for(Point p: image.convexHull()){
			graph.insertVertex(graph.getDefaultParent(), null, "H", p.x(), p.y(), 40, 40);
		}
		for(Point p: image.innerPoints()){
			graph.insertVertex(graph.getDefaultParent(), null, "P", p.x(), p.y(), 40, 40);
		}
		graphComponent=new mxGraphComponent(graph);
		frame.add(graphComponent);
	}
}
