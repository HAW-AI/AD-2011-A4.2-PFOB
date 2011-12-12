package adp_42_ch.application;

import java.awt.Canvas;
import java.awt.Color;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import adp_42_ch.implementations.comparators.AngleComparator;
import adp_42_ch.implementations.comparators.LexicographicComparatorYfirst;
import adp_42_ch.interfaces.*;

public class View {

	private final Controller controller;
	
	private final JFrame frame;
	private final JPanel panel;
	
	private mxGraphComponent graphComponent;
	
	private View(Controller controller, int width, int height){
		this.controller=controller;
		frame=new JFrame();
		frame.setSize(width, height);
		panel=new JPanel();
		panel.setAlignmentX(10);
		panel.setAlignmentY(10);
		panel.setSize(width-10, height-10);
		panel.setBackground(new Color(255,255,255));
		frame.add(panel);
		graphComponent=null;
		frame.setVisible(true);
	}
	
	protected static View create(Controller controller, int width, int height){
		return new View(controller, width, height);
	}
	
	void display(Image image){
		mxGraph graph=new mxGraph();
		List<Point> convexHull=image.convexHull();
		SortedSet<Point> hullSet=new TreeSet<Point>(new LexicographicComparatorYfirst());
		hullSet.addAll(convexHull);
		Collections.sort(convexHull, new AngleComparator(hullSet.first()));
		Object start=null;
		Object vertex;
		Object predecessor=null;
		for(Point p: convexHull){
			vertex=graph.insertVertex(graph.getDefaultParent(), null, "H", p.x()+200, p.y()+200, 10, 10);
			if(start==null){
				start=vertex;
			}
			if(predecessor!=null){
				graph.insertEdge(graph.getDefaultParent(), null, "", predecessor, vertex);
			}
			if(convexHull.indexOf(p)==convexHull.size()-1){
				graph.insertEdge(graph.getDefaultParent(), null, "", vertex, start);
			}
			predecessor=vertex;
		}
		for(Point p: image.innerPoints()){
			graph.insertVertex(graph.getDefaultParent(), null, "P", p.x()+200, p.y()+200, 10, 10);
		}
		boolean firstTime=false;
		if(graphComponent==null){ 
			firstTime=true;
		}
		graphComponent=new mxGraphComponent(graph);
		if(firstTime) panel.add(graphComponent);
		panel.validate();
	}
}
