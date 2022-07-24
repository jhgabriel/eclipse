package com.packtpub.e4.clock.ui.internal;

import java.util.TimeZone;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

public class TimeZoneAdapterFactory implements IAdapterFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Object o, Class type) {
		// TODO Auto-generated method stub
		if (type == IPropertySource.class && o instanceof TimeZone) {
			return new TimeZonePropertySource((TimeZone)o);
		} else {
			return null;
		}
	}

	@Override
	public Class<?>[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class[] {
				IPropertySource.class
		};
	}

}
