package com.packtpub.e4.clock.ui.views;

import java.util.Collection;
import java.util.Map;
import java.util.TimeZone;

import org.eclipse.jface.viewers.ITreeContentProvider;

public class TimeZoneContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object element) {
		if(element instanceof Map) {
			return ((Map)element).entrySet().toArray();
		} else if(element instanceof Map.Entry) {
			return getChildren(((Map.Entry)element).getValue());
		} else if(element instanceof Collection) {
			return ((Collection)element).toArray();
		} else {
			return new Object[0];
		}
	}

	@Override
	public Object[] getElements(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof Object[]) {
			return (Object[]) element;
		} else {
			return new Object[0];
		
		}
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if(element instanceof Map) {
			return !((Map)element).isEmpty();
		} else if(element instanceof Map.Entry) {
			return hasChildren(((Map.Entry)element).getValue());
		} else if(element instanceof Collection) {
			return !((Collection)element).isEmpty();
		} else {
			return false;
		}
	}
	
	

}
