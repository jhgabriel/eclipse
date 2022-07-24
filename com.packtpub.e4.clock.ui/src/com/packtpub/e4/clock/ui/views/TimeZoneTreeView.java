package com.packtpub.e4.clock.ui.views;

import java.net.URL;
import java.util.TimeZone;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.ViewPart;

import com.packtpub.e4.clock.ui.internal.TimeZoneComparator;
import com.packtpub.e4.clock.ui.internal.TimeZoneDialog;
import com.packtpub.e4.clock.ui.internal.TimeZoneViewerComparator;
import com.packtpub.e4.clock.ui.internal.TimeZoneViewerFilter;

public class TimeZoneTreeView extends ViewPart {

	private TreeViewer treeViewer;
	
	
	@Override
	public void createPartControl(Composite parent) {
		
		ResourceManager rm = JFaceResources.getResources();
		LocalResourceManager lrm = new LocalResourceManager(rm, parent);
		
		ImageRegistry ir = new ImageRegistry(lrm);
		URL sample = getClass().getResource("/icons/sample.png");
		ir.put("sample", ImageDescriptor.createFromURL(sample));
		
		FontRegistry fr = JFaceResources.getFontRegistry();
		
		// TODO Auto-generated method stub
		treeViewer = new TreeViewer(parent, 
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
//		treeViewer.setLabelProvider(new TimeZoneLabelProvider(ir));
		treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new TimeZoneLabelProvider(ir, fr)));
		treeViewer.setContentProvider(new TimeZoneContentProvider());
		treeViewer.setComparator(new TimeZoneViewerComparator());
		
		Object[] objs = new Object[] {TimeZoneComparator.getTimeZones()};
		
		treeViewer.setInput(objs);
		
		
		treeViewer.setFilters(new ViewerFilter[] {
				new TimeZoneViewerFilter("GMT")
		});
		
		treeViewer.setExpandPreCheckFilters(true);
		
		//treeViewer.setExpandPreCheckFilters(false);
		
		
		
		treeViewer.addDoubleClickListener((event) ->{

			
				// TODO Auto-generated method stub
				Viewer viewer = event.getViewer();
				Shell shell = viewer.getControl().getShell();
				
				ISelection sel = viewer.getSelection();
				Object selectedValue;
				if(!(sel instanceof IStructuredSelection) || sel.isEmpty()) {
					selectedValue = null;
				} else {
					selectedValue = ((IStructuredSelection)sel).getFirstElement();
					
				}
				if(selectedValue instanceof TimeZone) {
					TimeZone timeZone = (TimeZone) selectedValue;
					//MessageDialog.openInformation(shell, zone.getID(), zone.toString());
					new TimeZoneDialog(shell, timeZone).open();
				}
			
		});
		
		getSite().setSelectionProvider(treeViewer);
		
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		treeViewer.getControl().setFocus();
	}

}
